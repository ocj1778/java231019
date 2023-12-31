package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//학생정보를 관리하기 위한 프로그램 작성
public class JTableApp extends JFrame {
	private static final long serialVersionUID = 1L;

	JButton addBtn, removeBtn;
	JTable table;
	InputStudentDialog dialog;
	
	public JTableApp(String title) {
		super(title);
	
		addBtn=new JButton("학생추가");
		removeBtn=new JButton("학생삭제");
		
		JPanel panel=new JPanel();
		panel.add(addBtn);
		panel.add(removeBtn);
		
		//테이블의 컬럼명으로 사용될 String 배열 선언
		String[] columnNames={"학번", "이름", "전화번호"};
		
		//DefaultTableModel 클래스 : 테이블의 행 관련 정보를 저장하기 위한 클래스
		// => TableModel 객체를 이용하여 테이블의 행 또는 열(Cell)을 조작할 수 있는 기능의 메소드 호출
		// => DefaultTableModel(Object[] columnNames, int rows) 생성자를 이용하여 객체 생성
		// => columnNames 매개변수에는 테이블의 컬럼명이 저장된 배열을 전달하고 rows 매개변수에는
		//행의 갯수를 전달하여 객체 생성
		DefaultTableModel tableModel=new DefaultTableModel(columnNames, 0);
		
		//JTable 클래스 : 값을 행과 열로 구성된 테이블(Table - 표) 형식으로 출력하기 위한 컴퍼넌트
		// => JTable(TableModel dm) 생성자를 이용하여 객체 생성 
		table=new JTable(tableModel);
		
		//JTable 컴퍼넌트는 반드시 JScrollPane 컨테이너에 배치하여 JFrame 컨테이너에 배치 처리
		JScrollPane scrollPane=new JScrollPane(table);

		dialog=new InputStudentDialog(this, "학생추가");
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(panel, BorderLayout.SOUTH);

		addBtn.setFont(new Font(" 굴림체", Font.BOLD, 24));
		removeBtn.setFont(new Font(" 굴림체", Font.BOLD, 24));
		
		addBtn.addActionListener(new StudentButtonEventHandle());
		removeBtn.addActionListener(new StudentButtonEventHandle());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 500, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTableApp("JTable 연습");
	}
	
	public class StudentButtonEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventSource=e.getSource();
			
			if(eventSource == addBtn) {
				//다이얼로그 출력
				dialog.setVisible(true);
			} else if(eventSource == removeBtn) {
				DefaultTableModel tableModel=(DefaultTableModel)table.getModel();

				if(tableModel.getRowCount()==0) return;//행이 하나도 없는 경우 메소드 종료
				
				//JTable.getSelectedRow() : 테이블에서 선택행의 행번호를 반환하는 메소드
				int row=table.getSelectedRow();
				if(row == -1) return;//선택행이 없는 경우 메소드 종료
				
				//DefaultTableModel.removeRow(int row) : 매개변수로 전달받은 행을 삭제하는 메소드
				tableModel.removeRow(row);
			}
		}
	}
	
	//JDialog 클래스 : 다이얼로그를 구현한 컨테이너 클래스
	public class InputStudentDialog extends JDialog {
		private static final long serialVersionUID = 1L;
		
		JTextField numTf, nameTf, phoneTf;
		JButton okBtn, cancelBtn;
		
		//생성자 매개변수에는 부모창의 컨테이너 관련 객체와 제목을 전달받아 초기화
		public InputStudentDialog(JFrame frame, String title) {
			//JDialog(Frame owner, String title, boolean model) 생성자를 super 키워드로 호출
			// => owner 매개변수에는 부모창의 JFram 객체를 전달받고 model 매개변수에는 부모창의
			//비활성화 여부를 설정하는 논리값(false : 부모창 활성화 - Modaless, true : 부모창
			//비활성화 - Modal)을 전달받아 JDialog 객체 생성
			super(frame, title, true);//모달 다이얼로그

			getContentPane().setLayout(new GridLayout(2, 1));
		
			JPanel panelOne=new JPanel(new GridLayout(3, 2));

			numTf=new JTextField();
			nameTf=new JTextField();
			phoneTf=new JTextField();
			
			panelOne.add(new JLabel("학번", JLabel.CENTER));
			panelOne.add(numTf);
			panelOne.add(new JLabel("이름", JLabel.CENTER));
			panelOne.add(nameTf);
			panelOne.add(new JLabel("전화번호", JLabel.CENTER));
			panelOne.add(phoneTf);

			numTf.requestFocus();	
			
			okBtn=new JButton("추가");	
			cancelBtn=new JButton("취소");
			
			JPanel panelTwo=new JPanel();
			panelTwo.add(okBtn);
			panelTwo.add(cancelBtn);

			getContentPane().add(panelOne); 
			getContentPane().add(panelTwo); 
			
			okBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//JTextField 컴퍼넌트의 입력값을 반환받아 저장
					String num=numTf.getText();
					String name=nameTf.getText();
					String phone=phoneTf.getText();

					//Vector 객체를 생성하여 입력값을 요소로 추가하여 저장
					Vector<String> vector=new Vector<String>();
					vector.add(num);
					vector.add(name);
					vector.add(phone);
					
					//JTable.getModel() : 테이블 관련 행에 대한 정보가 저장된 TableModel 객체를
					//반환하는 메소드
					// => 명시적 객체 형변환을 이용하여 DefaultTableModel 객체로 형변환
					DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
					
					//DefaultTableModel.addRow(Vector vector) : Vector 객체된 요소값(컬럼값)으로
					//테이블에 행을 추가하는 메소드
					tableModel.addRow(vector);
					
					//JTextField 컴퍼넌트의 입력값 초기화
					numTf.setText("");
					nameTf.setText("");
					phoneTf.setText("");

					setVisible(false);
				}
			});
			
			cancelBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			
			//[닫기] 버튼을 누르면 다이얼로그가 보여지지 않도록 설정
			setDefaultCloseOperation(HIDE_ON_CLOSE);
			setBounds(700, 200, 400, 300);
		}
	}
}

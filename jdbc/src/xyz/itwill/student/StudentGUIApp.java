package xyz.itwill.student; 

/********************************************************
파    일   명 : StudentGUIApp.java
기         능 : 학생 관리 프로그램
*********************************************************/
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StudentGUIApp extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public static final int NONE = 0;
	public static final int ADD = 1;
	public static final int DELETE = 2;
	public static final int UPDATE = 3;
	public static final int UPDATE_CHANGE = 4;
	public static final int SEARCH = 5;

	JTextField noTF, nameTF, phoneTF, addressTF, birthdayTF;
	JButton addB, deleteB, updateB, searchB, cancelB;

	//JTable : 테이블(표)를 제공하기 위한 컴퍼넌트
	JTable table;
	
	int cmd;
	/********************************************
	 * 생성자 정의
	 *********************************************/
	public StudentGUIApp() throws Exception {
		setTitle("◆◆◆ 학생 관리 프로그램 ◆◆◆");
		setSize(800, 400);

		//Dimension : 컴퍼넌트 크기를 저장하기 위한 객체
		Dimension dim = getToolkit().getScreenSize();
		setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2
				- getHeight() / 2);

		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5, 1));

		JPanel pno = new JPanel();
		pno.add(new JLabel("학  번"));
		pno.add(noTF = new JTextField(10));

		JPanel pname = new JPanel();
		pname.add(new JLabel("이  름"));
		pname.add(nameTF = new JTextField(10));
		
		JPanel pphone = new JPanel();
		pphone.add(new JLabel("전  화"));
		pphone.add(phoneTF = new JTextField(10));

		JPanel paddress = new JPanel();
		paddress.add(new JLabel("주  소"));
		paddress.add(addressTF = new JTextField(10));

		JPanel pbirthday = new JPanel();
		pbirthday.add(new JLabel("생  일"));
		pbirthday.add(birthdayTF = new JTextField(10));

		left.add(pno);
		left.add(pname);
		left.add(pphone);
		left.add(paddress);
		left.add(pbirthday);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 5));

		bottom.add(addB = new JButton("삽  입"));
		addB.addActionListener(this);

		bottom.add(updateB = new JButton("변  경"));
		updateB.addActionListener(this);

		bottom.add(deleteB = new JButton("삭  제"));
		deleteB.addActionListener(this);

		bottom.add(searchB = new JButton("검  색"));
		searchB.addActionListener(this);
		
		bottom.add(cancelB = new JButton("초기화"));
		cancelB.addActionListener(this);

		Object[] title={"학번","이름","전화번호","주소","생년월일"};
		//DefaultTableModel : 테이블의 행과 열을 표현하기 위한 객체
		table=new JTable(new DefaultTableModel(title, 0));
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		JScrollPane sp=new JScrollPane(table);
		
		add(sp, "Center");
		add(left, "West");
		add(bottom, "South");
		cmd = NONE;
		initialize();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//모든 JTextField 컴퍼넌트를 비활성화 처리하는 메소드
	public void initialize() {
		noTF.setEditable(false);
		nameTF.setEditable(false);
		phoneTF.setEditable(false);
		addressTF.setEditable(false);
		birthdayTF.setEditable(false);
	}

	//이벤트에 따른 JTextField 컴퍼넌트의 활성화 상태 변경
	public void setEditable(int n) {
		switch (n) {
		case ADD:
			noTF.setEditable(true);
			nameTF.setEditable(true);
			phoneTF.setEditable(true);
			addressTF.setEditable(true);
			birthdayTF.setEditable(true);
			break;
		case DELETE:
			noTF.setEditable(true);
			break;
		case UPDATE:
			noTF.setEditable(true);
			break;
		case UPDATE_CHANGE:
			noTF.setEditable(false);
			nameTF.setEditable(true);
			phoneTF.setEditable(true);
			addressTF.setEditable(true);
			birthdayTF.setEditable(true);
			break;
		case SEARCH:
			nameTF.setEditable(true);
			break;
		case NONE:
			noTF.setEditable(false);
			nameTF.setEditable(false);
			phoneTF.setEditable(false);
			addressTF.setEditable(false);
			birthdayTF.setEditable(false);
		}
	}

	//이벤트에 따른 JTextField 컴퍼넌트와 JButton 컴퍼넌트의 활성화 상태 변경
	public void setEnable(int n) {
		addB.setEnabled(false);
		deleteB.setEnabled(false);
		updateB.setEnabled(false);
		searchB.setEnabled(false);

		switch (n) {
		case ADD:
			addB.setEnabled(true);
			setEditable(ADD);
			cmd = ADD;
			break;
		case DELETE:
			deleteB.setEnabled(true);
			setEditable(DELETE);
			cmd = DELETE;
			break;
		case UPDATE:
			updateB.setEnabled(true);
			setEditable(UPDATE);
			cmd = UPDATE;
			break;			
		case UPDATE_CHANGE:
			updateB.setEnabled(true);
			setEditable(UPDATE_CHANGE);
			cmd = UPDATE_CHANGE;
			break;			
		case SEARCH:
			searchB.setEnabled(true);
			setEditable(SEARCH);
			cmd = SEARCH;
			break;
		case NONE:
			addB.setEnabled(true);
			deleteB.setEnabled(true);
			updateB.setEnabled(true);
			searchB.setEnabled(true);
		}
	}

	//JTextField 컴퍼넌트의 입력값 초기화
	public void clear() {
		noTF.setText("");
		nameTF.setText("");
		phoneTF.setText("");
		addressTF.setText("");
		birthdayTF.setText("");
	}

	//모든 컴퍼넌트의 상태 초기화
	public void initDisplay() {
		setEnable(NONE);
		clear();
		cmd = NONE;
		initialize();		
	}

	public static void main(String args[]) throws Exception {
		new StudentGUIApp();
	}
	
	public void actionPerformed(ActionEvent ev) {
		Component c = (Component) ev.getSource();
		try {
			if (c == addB) {
				if (cmd != ADD) {//첫번째 [삽입] 버튼을 누른 경우 - NONE 상태
					setEnable(ADD);//컴퍼넌트의 활성화 상태 변경 - ADD 상태 변경					
				} else {//두번째 [삽입] 버튼을 누른 경우 - ADD 상태
					initDisplay();
				}
			} else if (c == updateB) {
				if (cmd != UPDATE && cmd != UPDATE_CHANGE) {//첫번째 [변경] 버튼을 누른 경우 - NONE 상태
					setEnable(UPDATE);//입출력 컴퍼넌트의 활성화 상태 변경 - UPDATE 상태 변경		
				} else if (cmd != UPDATE_CHANGE) {//두번째 [변경] 버튼을 누른 경우	- UPDATE 상태
					setEnable(UPDATE_CHANGE);	
				} else {//세번째 [변경] 버튼을 누른 경우 - UPDATE_CHANGE 상태		
					initDisplay();
				}
			} else if (c == deleteB) {
				if (cmd != DELETE) {//첫번째 [삭제] 버튼을 누른 경우 - NONE 상태
					setEnable(DELETE);//입출력 컴퍼넌트의 활성화 상태 변경 - DELETE 상태 변경		
				} else {//두번째 [삭제] 버튼을 누른 경우 - DELETE 상태
					initDisplay();
				}
			} else if (c == searchB) {
				if (cmd != SEARCH) {//첫번째 [검색] 버튼을 누른 경우 - NONE 상태
					setEnable(SEARCH);//입출력 컴퍼넌트의 활성화 상태 변경 - SEARCH 상태 변경		
				} else {//두번째 [검색] 버튼을 누른 경우 - SEARCH 상태
					initDisplay();
				}
			} else if (c == cancelB) {
				initDisplay();
			}
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e);
		}		
	}
}

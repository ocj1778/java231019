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
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

		//JTable 컴퍼넌트에 STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력 처리
		displayAllStudent();
		
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
					//학생정보를 입력받아 STUDENT 테이블에 삽입하여 출력 처리하는 메소드 호출
					addStudent();
				}
			} else if (c == updateB) {
				if (cmd != UPDATE && cmd != UPDATE_CHANGE) {//첫번째 [변경] 버튼을 누른 경우 - NONE 상태
					setEnable(UPDATE);//입출력 컴퍼넌트의 활성화 상태 변경 - UPDATE 상태 변경		
				} else if (cmd != UPDATE_CHANGE) {//두번째 [변경] 버튼을 누른 경우	- UPDATE 상태
					//학번을 입력받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 출력 처리하는 메소드
					searchNoStudent();
				} else {//세번째 [변경] 버튼을 누른 경우 - UPDATE_CHANGE 상태		
					//학생정보를 입력받아 STUDENT 테이블에 저장된 학생정보를 변경하여 출력 처리하는 메소드 호출
					modifyStudent();
				}
			} else if (c == deleteB) {
				if (cmd != DELETE) {//첫번째 [삭제] 버튼을 누른 경우 - NONE 상태
					setEnable(DELETE);//입출력 컴퍼넌트의 활성화 상태 변경 - DELETE 상태 변경		
				} else {//두번째 [삭제] 버튼을 누른 경우 - DELETE 상태
					//학번을 입력받아 STUDENT 테이블에 저장된 학생정보를 삭제하여 출력 처리하는 메소드 호출
					removeStudent();
				}
			} else if (c == searchB) {
				if (cmd != SEARCH) {//첫번째 [검색] 버튼을 누른 경우 - NONE 상태
					setEnable(SEARCH);//입출력 컴퍼넌트의 활성화 상태 변경 - SEARCH 상태 변경		
				} else {//두번째 [검색] 버튼을 누른 경우 - SEARCH 상태
					//이름을 입력받아 STUDENT 테이블에 저장된 해당 이름의 학생정보를 검색하여 출력하는 메소드 호출
					searchNameStudent();
				}
			} else if (c == cancelB) {
				initDisplay();
				displayAllStudent();
			}
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e);
		}		
	}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 JTable 컴퍼넌트에 출력하는 메소드
	public void displayAllStudent() {
		//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 DAO 클래스의 메소드 호출
		// => DAO 클래스의 메소드를 호출하여 반환되는 객체(값)을 변수에 저장
		List<StudentDTO> studentList=StudentDAOImpl.getDAO().selectStudentList();
		
		//List.isEmpty() : List 객체에 요소가 있는 경우 [false]를 반환하고 요소가 없는 경우 
		//[true]를 반환하는 메소드
		if(studentList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "저장된 학생정보가 없습니다.");
			return;
		}

		//JTable.getModel() : JTable 컴퍼넌트의 행정보가 저장된 TableModel 객체를 반환하는 메소드
		// => DefaultTableModel 클래스로 명시적 객체 형변환하여 저장
		//DefaultTableModel 객체 : JTable 컴퍼넌트의 행정보를 저장하기 위한 객체
		// => 행과 열에 대한 조작 관련 기능의 메소드 제공
		DefaultTableModel defaultTableModel=(DefaultTableModel)table.getModel();
		
		//DefaultTableModel.getRowCount() : DefaultTableModel 객체에 저장된 행의 갯수를 반환하는 메소드
		//DefaultTableModel 객체에 저장된 행의 갯수만큼 실행되는 반복문
		// => JTable 컴퍼넌트에 출력된 기존 행을 모두 삭제 처리 - 초기화
		for(int i=defaultTableModel.getRowCount();i>0;i--) {
			//DefaultTableModel.removeRow(int rowIndex) : DefaultTableModel 객체에 저장된
			//행에서 매개변수로 전달받은 위치의 행을 삭제하는 메소드
			defaultTableModel.removeRow(0);//JTable 컴퍼넌트에서 첫번째 행을 삭제
		}
		
		//List 객체의 요소(StudentDTO 객체)를 차례대로 제공받아 처리하는 반복문
		// => JTable 컴퍼넌트에 검색된 모든 학생정보를 출력 처리
		for(StudentDTO student : studentList) {
			//Vector 객체 생성 - JTable 컴퍼넌트에 출력될 하나의 행을 표현하기 위한 객체
			Vector<Object> rowData=new Vector<Object>();
			
			//StudentDTO 객체의 필드값을 반환받아 Vector 객체의 요소로 추가
			// => JTable 컴퍼넌트에 출력될 순서대로 필드값을 반환받아 추가
			rowData.add(student.getNo());
			rowData.add(student.getName());
			rowData.add(student.getPhone());
			rowData.add(student.getAddress());
			rowData.add(student.getBirthday());
			
			//DefaultTableModel.addRow(Vector rowData) : DefaultTableModel 객체에 행을 추가하는 메소드
			// => JTable 컴퍼넌트에 행 출력 처리
			defaultTableModel.addRow(rowData);
		}
	}
	
	//JTextField 컴퍼넌트로 입력된 학생정보를 제공받아 STUDENT 테이블에 삽입하고 STUDENT
	//테이블에 저장된 모든 학생정보를 검색하여 JTable 컴퍼넌트에 출력하는 메소드
	// => JTextField 컴퍼넌트와 JButton 컴퍼넌트의 초기화 및 [NONE] 상태로 변경 처리
	public void addStudent() {
		String noString=noTF.getText();//JTextField 컴퍼넌트의 입력값을 반환받아 저장
		
		if(noString.equals("")) {//JTextField 컴퍼넌트에 입력된 값이 없는 경우
			JOptionPane.showMessageDialog(this, "학번을 입력해 주세요.");
			noTF.requestFocus();//JTextField 컴퍼넌트에 포커스(입력촛점) 제공
			return;
		}
		
		String noReg="^[1-9][0-9]{3}$";
		if(!Pattern.matches(noReg, noString)) {//정규표현값과 입력값의 패턴이 다른 경우
			JOptionPane.showMessageDialog(this, "학번은 4자리 숫자로만 입력해 주세요.");
			noTF.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(noString);//문자열을 정수값으로 변환하여 저장
		
		//학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 반환하는
		//DAO 클래스의 메소드 호출 - NULL(검색행 X) 또는 StudentDTO 객체(검색행 O) 중 하나를 반환
		//선택문을 사용하여 검색된 학생정보가 있는 경우 학번 중복에 대한 처리 명령 실행
		if(StudentDAOImpl.getDAO().selectStudentByNo(no) != null) {
			JOptionPane.showMessageDialog(this, "이미 사용중인 학번을 입력 하였습니다.");
			noTF.requestFocus();
			return;
		}
		
		String name=nameTF.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^[가-힣]{2,5}$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "이름은 2~5 범위의 한글로만 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		String phone=phoneTF.getText();
		
		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "전화번호를 입력해 주세요.");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "전화번호를 형식에 맞게 입력해 주세요.");
			phoneTF.requestFocus();
			return;
		}
		
		String address=addressTF.getText();
		
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "주소를 입력해 주세요.");
			addressTF.requestFocus();
			return;
		}
		
		String birthday=birthdayTF.getText();
		
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "생년월일을 입력해 주세요.");
			birthdayTF.requestFocus();
			return;
		}
		
		String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "생년월일을 형식에 맞게 입력해 주세요.");
			birthdayTF.requestFocus();
			return;
		}
		
		//StudentDTO 객체를 생성하여 입력값을 객체의 필드값으로 변경
		// => DAO 클래스의 메소드를 호출할 때 StudentDTO 객체를 매개변수에 전달
		StudentDTO student=new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		//학생정보(StudentDTO 객체)를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 
		//반환하는 DAO 클래스의 메소드 호출
		int rows=StudentDAOImpl.getDAO().insertStudent(student);
		
		JOptionPane.showMessageDialog(this, rows+"명의 학생정보를 삽입 하였습니다.");
		
		displayAllStudent();
		initDisplay();
	}
	
	//JTextField 컴퍼넌트로 입력된 학번을 제공받아 STUDENT 테이블에 저장된 해당 학번의 
	//학생정보를 검색하여 JTextField 컴퍼넌트에 출력하는 메소드 - [UPDATE_CHANGE] 상태로 변경
	public void searchNoStudent() {
		String noString=noTF.getText();
		
		if(noString.equals("")) {
			JOptionPane.showMessageDialog(this, "학번을 입력해 주세요.");
			noTF.requestFocus();
			return;
		}
		
		String noReg="^[1-9][0-9]{3}$";
		if(!Pattern.matches(noReg, noString)) {
			JOptionPane.showMessageDialog(this, "학번은 4자리 숫자로만 입력해 주세요.");
			noTF.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(noString);
		
		//학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 반환하는
		//DAO 클래스의 메소드 호출 - NULL(검색행 X) 또는 StudentDTO 객체(검색행 O) 중 하나를 반환
		StudentDTO student=StudentDAOImpl.getDAO().selectStudentByNo(no);
		
		if(student == null) {//학번으로 검색된 학생정보가 없는 경우
			JOptionPane.showMessageDialog(this, "변경할 학번의 학생정보가 없습니다.");
			noTF.requestFocus();
			noTF.setText("");
			return;
		}
		
		//검색된 학생정보를 JTextField 컴퍼넌트에 출력 - 변경값 입력
		noTF.setText(student.getNo()+"");
		nameTF.setText(student.getName());
		phoneTF.setText(student.getPhone());
		addressTF.setText(student.getAddress());
		birthdayTF.setText(student.getBirthday());
		
		//[UPDATE_CHANGE] 상태 변경 - 컴퍼넌트의 활성 또는 비활성 상태 변경
		setEnable(UPDATE_CHANGE);
	}
	
	//JTextField 컴퍼넌트로 입력된 학생정보를 제공받아 STUDENT 테이블에 저장된 학생정보를 변경
	//하고 STUDENT 테이블에 저장된 모든 학생정보를 검색하여 JTable 컴퍼넌트에 출력하는 메소드
	// => JTextField 컴퍼넌트와 JButton 컴퍼넌트의 초기화 및 [NONE] 상태로 변경 처리
	public void modifyStudent() {
		//JTextField 컴퍼넌트(학번)의 입력값을 반환받아 저장
		int no=Integer.parseInt(noTF.getText());
		
		//JTextField 컴퍼넌트(이름,전화번호,주소,생년월일)의 입력값(변경값)을 반환받아 저장
		String name=nameTF.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^[가-힣]{2,5}$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "이름은 2~5 범위의 한글로만 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		String phone=phoneTF.getText();
		
		if(phone.equals("")) {
			JOptionPane.showMessageDialog(this, "전화번호를 입력해 주세요.");
			phoneTF.requestFocus();
			return;
		}
		
		String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
		if(!Pattern.matches(phoneReg, phone)) {
			JOptionPane.showMessageDialog(this, "전화번호를 형식에 맞게 입력해 주세요.");
			phoneTF.requestFocus();
			return;
		}
		
		String address=addressTF.getText();
		
		if(address.equals("")) {
			JOptionPane.showMessageDialog(this, "주소를 입력해 주세요.");
			addressTF.requestFocus();
			return;
		}
		
		String birthday=birthdayTF.getText();
		
		if(birthday.equals("")) {
			JOptionPane.showMessageDialog(this, "생년월일을 입력해 주세요.");
			birthdayTF.requestFocus();
			return;
		}
		
		String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(birthdayReg, birthday)) {
			JOptionPane.showMessageDialog(this, "생년월일을 형식에 맞게 입력해 주세요.");
			birthdayTF.requestFocus();
			return;
		}
		
		//StudentDTO 객체를 생성하여 입력값을 객체의 필드값으로 변경
		// => DAO 클래스의 메소드를 호출할 때 StudentDTO 객체를 매개변수에 전달
		StudentDTO student=new StudentDTO();
		student.setNo(no);
		student.setName(name);
		student.setPhone(phone);
		student.setAddress(address);
		student.setBirthday(birthday);
		
		//학생정보(StudentDTO 객체)를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고  
		//변경행의 갯수를 반환하는 DAO 클래스의 메소드 호출
		int rows=StudentDAOImpl.getDAO().updateStudent(student);
		
		JOptionPane.showMessageDialog(this, rows+"명의 학생정보를 변경 하였습니다.");
		
		displayAllStudent();
		initDisplay();
	}
	
	//JTextField 컴퍼넌트로 입력된 학번을 제공받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를  
	//삭제하고 STUDENT 테이블에 저장된 모든 학생정보를 검색하여 JTable 컴퍼넌트에 출력하는 메소드
	// => JTextField 컴퍼넌트와 JButton 컴퍼넌트의 초기화 및 [NONE] 상태로 변경 처리
	public void removeStudent() {
		String noString=noTF.getText();
		
		if(noString.equals("")) {
			JOptionPane.showMessageDialog(this, "학번을 입력해 주세요.");
			noTF.requestFocus();
			return;
		}
		
		String noReg="^[1-9][0-9]{3}$";
		if(!Pattern.matches(noReg, noString)) {
			JOptionPane.showMessageDialog(this, "학번은 4자리 숫자로만 입력해 주세요.");
			noTF.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(noString);
		
		//학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 갯수를 반환하는
		//DAO 클래스의 메소드 호출
		int rows=StudentDAOImpl.getDAO().deleteStudent(no);
		
		if(rows > 0) {
			JOptionPane.showMessageDialog(this, rows+"명의 학생정보를 삭제 하였습니다.");
			displayAllStudent();
		} else {
			JOptionPane.showMessageDialog(this, "삭제할 학번의 학생정보가 없습니다.");
		}
		
		initDisplay();
	}
	
	//JTextField 컴퍼넌트로 입력된 이름을 제공받아 STUDENT 테이블에 저장된 해당 이름의 학생정보를  
	//검색하여 JTable 컴퍼넌트에 출력하는 메소드
	// => JTextField 컴퍼넌트와 JButton 컴퍼넌트의 초기화 및 [NONE] 상태로 변경 처리	
	public void searchNameStudent() {
		String name=nameTF.getText();
		
		if(name.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		String nameReg="^[가-힣]{2,5}$";
		if(!Pattern.matches(nameReg, name)) {
			JOptionPane.showMessageDialog(this, "이름은 2~5 범위의 한글로만 입력해 주세요.");
			nameTF.requestFocus();
			return;
		}
		
		//이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생정보를 검색하여 List 객체로
		//반환하는 DAO 클래스의 메소드 호출
		List<StudentDTO> studentList=StudentDAOImpl.getDAO().selectStudentByName(name);
		
		if(studentList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "입력된 이름의 학생정보가 없습니다.");
			return;
		}

		DefaultTableModel defaultTableModel=(DefaultTableModel)table.getModel();
		
		for(int i=defaultTableModel.getRowCount();i>0;i--) {
			defaultTableModel.removeRow(0);
		}
		
		for(StudentDTO student : studentList) {
			Vector<Object> rowData=new Vector<Object>();
			
			rowData.add(student.getNo());
			rowData.add(student.getName());
			rowData.add(student.getPhone());
			rowData.add(student.getAddress());
			rowData.add(student.getBirthday());
			
			defaultTableModel.addRow(rowData);
		}
		
		initDisplay();
	}
}














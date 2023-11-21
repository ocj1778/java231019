package xyz.itwill.io;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

//문서파일 편집기 프로그램 작성 - 메모장
public class NotepadApp extends JFrame {
	private static final long serialVersionUID = 1L;

	JTextArea textArea;
	JMenuItem init, open, save, exit;
	
	//JFileChooser 클래스 : 파일을 선택하기 위한 다이얼로그를 구현한 컨테이너 클래스
	JFileChooser openFileChooser, saveFileChooser;
	
	//현재 작업중인 문서파일의 경로를 저장하기 위한 필드
	private File file;  
	
	public NotepadApp(String title) {
		super(title);
		
		JMenuBar menuBar=new JMenuBar();
		
		//Mnemonic : [Alt] 기능키와 같이 사용해 메뉴 또는 메뉴아이템을 키보드로 선택하기 위한 문자값  
		JMenu fileMenu=new JMenu("파일(F)");
		fileMenu.setMnemonic('F');
		
		init=new JMenuItem("새로 만들기(N)", 'N');
		open=new JMenuItem("열기(O)", 'O');
		save=new JMenuItem("저장(S)", 'S');
		exit=new JMenuItem("끝내기(X)", 'X');
		
		//메뉴 아이템에 단축키 등록
		init.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O
				, InputEvent.ALT_DOWN_MASK + InputEvent.SHIFT_DOWN_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S
				, InputEvent.ALT_DOWN_MASK + InputEvent.SHIFT_DOWN_MASK));
		
		fileMenu.add(init);
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		
		menuBar.add(fileMenu);
		
		setJMenuBar(menuBar);
		
		textArea=new JTextArea();
		textArea.setFont(new Font("굴림체", Font.PLAIN, 20));
		JScrollPane scrollPane=new JScrollPane(textArea);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		openFileChooser=new JFileChooser();
		//JFileChooser.setCurrentDirectory(File file) : 파일 다이얼로그의 기본 작업 디렉토리를
		//변경하는 메소드
		openFileChooser.setCurrentDirectory(new File("c:/"));
		//JFileChooser.addChoosableFileFilter(FileFilter filter) : 파일 다이얼로그로 선택 가능한
		//파일 필터 기능을 추가하는 메소드 
		// => 파일 이름으로 필터 기능을 제공하기 위해 FileNameExtensionFilter 객체를 생성하여 전달
		openFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("텍스트 파일(*.txt)", "txt"));
		
		saveFileChooser=new JFileChooser();
		saveFileChooser.setCurrentDirectory(new File("c:/"));
		saveFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("텍스트 파일(*.txt)", "txt"));

		//메뉴아이템을 선택할 경우 발생되는 ActionEvent를 처리하기 위해 ActionListener 객체 등록
		init.addActionListener(new NotePadEventHandle());
		open.addActionListener(new NotePadEventHandle());
		save.addActionListener(new NotePadEventHandle());
		exit.addActionListener(new NotePadEventHandle());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(450, 150, 1000, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NotepadApp("제목 없음 - Java 메모장");
	}
	
	public class NotePadEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventSource=e.getSource();
			
			if(eventSource == init) {
				
			} else if(eventSource == open) {
				//JFileChooser.showOpenDialog(Component parent) : 열기 관련 파일 다이얼로그를
				//화면에 출력하는 메소드 - 버튼 선택에 따른 정수값 반환
				int option=openFileChooser.showOpenDialog(NotepadApp.this);
				
				if(option == JFileChooser.APPROVE_OPTION) {//파일 선택 후 [열기] 버튼을 누른 경우
					//JFileChooser.getSelectedFile() : 선택된 파일의 경로가 저장된 File 객체를 반환하는 메소드
					file=openFileChooser.getSelectedFile();
					
					setTitle(file.toString()+" - Java 메모장");
					
					try {
						BufferedReader in=new BufferedReader(new FileReader(file.getAbsoluteFile()));
						
						textArea.setText("");//JTextArea 컴퍼넌트 초기화
						
						while(true) {
							//파일에 저장된 값을 한줄씩 제공받아 문자열로 저장
							// => BufferedReader.readLine() : 입력스트림으로 문자열을 제공받아 반환하는 메소드
							String text=in.readLine();
							
							if(text == null) break;//파일로부터 제공받을 값이 없는 경우 반복문 종료
							
							//JTextArea 컴퍼넌트에 문자열을 추가하여 출력
							textArea.append(text+"\n");
						}
						
						in.close();
					} catch (FileNotFoundException exception) {
						JOptionPane.showMessageDialog(NotepadApp.this, "파일을 찾을 수 없습니다.");
					} catch (IOException exception) {
						JOptionPane.showMessageDialog(NotepadApp.this, "프로그램에 문제가 발생 하였습니다.");
					}
				} else if(option == JFileChooser.CANCEL_OPTION) {//[취소] 버튼을 누른 경우
					return;
				}
			} else if(eventSource == save) {
				
				
			} else if(eventSource == exit) {
				System.exit(0);
			}
		}
	}
}





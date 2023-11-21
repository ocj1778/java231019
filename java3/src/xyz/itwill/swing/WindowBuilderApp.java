package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class WindowBuilderApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton addBtn;
	private JButton modifyBtn;
	private JButton removeBtn;
	private JButton searchBtn;
	private JMenuItem open;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderApp frame = new WindowBuilderApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowBuilderApp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(WindowBuilderApp.class.getResource("/images/penguin1.gif")));
		setTitle("WindowBuilder 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 200, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 4, 0, 0));
		
		addBtn = new JButton("학생추가");
		addBtn.setFont(new Font("굴림", Font.PLAIN, 18));
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(addBtn);
		
		modifyBtn = new JButton("학생변경");
		modifyBtn.setIcon(null);
		modifyBtn.setFont(new Font("굴림", Font.PLAIN, 16));
		panel.add(modifyBtn);
		
		removeBtn = new JButton("학생삭제");
		removeBtn.setFont(new Font("굴림", Font.PLAIN, 16));
		panel.add(removeBtn);
		
		searchBtn = new JButton("학생검색");
		searchBtn.setFont(new Font("굴림", Font.PLAIN, 16));
		panel.add(searchBtn);
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		file.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		menuBar.add(file);
		
		open = new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		open.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		file.add(open);
		
		scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new String[] {
				"\uD559\uBC88", "\uC774\uB984", "\uC804\uD654\uBC88\uD638"
			},0));
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(170);
		table.setFont(new Font("굴림", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
	}

}

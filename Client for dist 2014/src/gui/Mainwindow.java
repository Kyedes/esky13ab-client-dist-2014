package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Mainwindow {

	private JFrame frame;
	private JMenuItem mntmCreateCalendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainwindow window = new Mainwindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mainwindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1024, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel logInPanel = new JPanel();
		frame.getContentPane().add(logInPanel, "name_210335990069010");
		
		JPanel mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, "name_210429652948227");
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel calendarControlPanel = new JPanel();
		mainPanel.add(calendarControlPanel, BorderLayout.NORTH);
		
		JMenuBar menuBar = new JMenuBar();
		mainPanel.add(menuBar, BorderLayout.WEST);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		mntmCreateCalendar = new JMenuItem("Create new calendar");
		mnMenu.add(mntmCreateCalendar);
		
		JMenuItem mntmCreateEvent = new JMenuItem("Create event");
		mnMenu.add(mntmCreateEvent);
		
		JMenuItem mntmDeleteCalendar = new JMenuItem("Delete calendar");
		mnMenu.add(mntmDeleteCalendar);
		
		JMenuItem mntmDeleteEvent = new JMenuItem("Delete event");
		mnMenu.add(mntmDeleteEvent);
		
		JMenuItem mntmSaveNote = new JMenuItem("Edit note");
		mnMenu.add(mntmSaveNote);
		
		JScrollPane scrollPaneCalendar = new JScrollPane();
		mainPanel.add(scrollPaneCalendar, BorderLayout.CENTER);
	}

}

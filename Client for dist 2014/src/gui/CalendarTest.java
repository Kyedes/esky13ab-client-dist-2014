package gui;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import com.google.gson.Gson;

import serverconection.ServerConnection;
import shared.*;
import shared.Event;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarTest{
	static JLabel lblWeek, lblYear;
	static JButton btnPrev, btnNext;
	static JTable tblCalendar;
	static JComboBox<String> cmbYear;
	static JFrame frmMain;
	static Container pane;
	static DefaultTableModel mtblCalendar; //Table model
	static JScrollPane stblCalendar; //The scrollpane
	static JPanel pnlCalendar;
	static JLabel lblMonth;
	static int realYear, realMonth, realWeek, realDay, currentYear, currentMonth, currentWeek;

	static ServerConnection sc = new ServerConnection();

	static GetCalendarObject gco = new GetCalendarObject();
	static GetCalendarReturnObject gcro = new GetCalendarReturnObject();
	static Gson gson = new Gson();
	static String jsonOut = "";
	static String jsonIn = "";

	public static void main (String args[]){
		//Look and feel
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch (ClassNotFoundException e) {}
		catch (InstantiationException e) {}
		catch (IllegalAccessException e) {}
		catch (UnsupportedLookAndFeelException e) {}

		//To import the calendar
		gco.setUserID("esky13ab");//change name to input
		jsonOut = gson.toJson(gco);
		try {
			jsonIn = sc.execute(jsonOut);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gcro = gson.fromJson(jsonIn, GetCalendarReturnObject.class);


		//Prepare frame
		frmMain = new JFrame ("Calendar"); //Create frame
		frmMain.setSize(330, 375); //Set size to 400x400 pixels
		pane = frmMain.getContentPane(); //Get content pane
		pane.setLayout(null); //Apply null layout
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when X is clicked

		//Create controls
		lblWeek = new JLabel ("January");
		lblYear = new JLabel ("Change year:");
		cmbYear = new JComboBox<String>();
		btnPrev = new JButton ("&lt;&lt;");
		btnNext = new JButton ("&gt;&gt;");
		mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
		tblCalendar = new JTable(mtblCalendar);
		stblCalendar = new JScrollPane(tblCalendar);
		pnlCalendar = new JPanel(null);
		lblMonth = new JLabel("Month: ");

		//Set border
		pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));

		//Register action listeners
		btnPrev.addActionListener(new btnPrev_Action());
		btnNext.addActionListener(new btnNext_Action());
		cmbYear.addActionListener(new cmbYear_Action());

		//Add controls to pane
		pane.add(pnlCalendar);
		pnlCalendar.add(lblWeek);
		pnlCalendar.add(lblYear);
		pnlCalendar.add(cmbYear);
		pnlCalendar.add(btnPrev);
		pnlCalendar.add(btnNext);
		pnlCalendar.add(stblCalendar);
		pnlCalendar.add(lblMonth);

		//Set bounds
		frmMain.setBounds(0, 0, 650, 680);
		pnlCalendar.setBounds(0, 0, 640, 670);
		lblWeek.setBounds(160-lblWeek.getPreferredSize().width/2, 25, 100, 25);
		lblYear.setBounds(20, 610, 80, 20);
		cmbYear.setBounds(460, 610, 80, 20);
		btnPrev.setBounds(10, 25, 50, 25);
		btnNext.setBounds(260, 25, 50, 25);
		stblCalendar.setBounds(10, 50, 600, 500);
		lblMonth.setBounds(384, 30, 140, 14);

		//Make frame visible
		frmMain.setResizable(false);
		frmMain.setVisible(true);


		//Get real month/year
		GregorianCalendar cal = new GregorianCalendar(); //Create calendar
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
		realWeek = cal.get(GregorianCalendar.WEEK_OF_YEAR);//Get week
		realMonth = cal.get(GregorianCalendar.MONTH); //Get month
		realYear = cal.get(GregorianCalendar.YEAR); //Get year
		currentWeek = realWeek; //Match month, week and year
		currentMonth = realMonth;
		currentYear = realYear;

		//Add headers
		String[] headers = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"}; //All headers

		for (int i=0; i<7; i++){
			mtblCalendar.addColumn(headers[i]);
		}

		tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background

		//No resize/reorder
		tblCalendar.getTableHeader().setResizingAllowed(false);
		tblCalendar.getTableHeader().setReorderingAllowed(false);

		//Single cell selection
		tblCalendar.setColumnSelectionAllowed(true);
		tblCalendar.setRowSelectionAllowed(true);
		tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//Set row/column count
		tblCalendar.setRowHeight(400);
		mtblCalendar.setColumnCount(7);
		mtblCalendar.setRowCount(1);

		//Populate table
		for (int i = realYear -100; i <= realYear +100; i++){
			cmbYear.addItem(String.valueOf(i));
		}

		//Refresh calendar
		refreshCalendar (realWeek, realYear); //Refresh calendar
	}

	public static void refreshCalendar(int week, int year){
		//Variables
		String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int nod, som, sow, month; //Number Of Days, Start Of Month, Start Of Week
		int[] weeks = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54};

		//Set variables to current
		GregorianCalendar cal = new GregorianCalendar( new Locale("Copenhagen")); //Create calendar
		cal.setWeekDate(year, week, 1);//sets date corresponding to week
		sow = cal.get(GregorianCalendar.DAY_OF_MONTH);
		month = cal.get(GregorianCalendar.MONTH);
		nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		//		System.out.print(month);

		//Allow/disallow buttons
		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);
		if (week == 1 && year <= realYear-100){btnPrev.setEnabled(false);} //Too early
		if (week == cal.getWeeksInWeekYear() && year >= realYear+100){btnNext.setEnabled(false);} //Too late
		lblWeek.setText("Week " + weeks[week-1]); //Refresh the week label (at the top)
		lblWeek.setBounds(160-lblWeek.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
		cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
		lblMonth.setText(String.format("Month: %s", months[month]));
		//Clear table
		for (int i=0; i<1; i++){
			for (int j=0; j<7; j++){
				mtblCalendar.setValueAt(null, i, j);
			}
		}


		//Update day of week with date
		String[] headers = {"Sun", "Mon", "Tue", "Wed ", "Thu", "Fri", "Sat"}; //All headers

		int sowx = sow;

		for(int i = 0; i<headers.length; i++){
			if(sowx >= nod+1){
				sowx = 1;
			}
			String add = String.format(" %d", (sowx));
			headers[i] = headers[i].concat(add);
			sowx++;
		}
		mtblCalendar.setColumnIdentifiers((String[]) headers);


		int sowy = sow;
		for(int y = 0; y < mtblCalendar.getColumnCount();y++){
			
			String dailyEvents ="";
			for (ArrayList<Event> i : gcro.getCalendars()){
				for(Event x : i){
					
					Date d = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");

					try{
						d = sdf.parse(x.getStart().get(0));
						//System.out.print(d);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					GregorianCalendar caly = new GregorianCalendar();
					caly.setGregorianChange(d);
					if(year == caly.get(GregorianCalendar.YEAR)){
						if (month == caly.get(GregorianCalendar.MONTH)){
							if((sowy == caly.get(GregorianCalendar.DAY_OF_MONTH))){
								dailyEvents = dailyEvents.concat(String.format("%s\n", x.getTitle()));
							}
						}
					}
				}
			}
//			dailyEvents.concat("test");
			System.out.print(dailyEvents);
			mtblCalendar.setValueAt(dailyEvents, 0, y);
			sowy++;
			if(sowy >= nod+1){
				sowy = 1;
			}
		}


		//To paint events onto the calendar
		//		 

		//Draw calendar
		//        for (int i=1; i<=nod; i++){
		//            int row = new Integer((i+som-2)/7);
		//            int column  =  (i+som-2)%7;
		//            mtblCalendar.setValueAt(i, row, column);
		//        }

		//Apply renderers
		tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
	}

	static class tblCalendarRenderer extends DefaultTableCellRenderer{
		public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
			super.getTableCellRendererComponent(table, value, selected, focused, row, column);
			if (column == 0 || column == 6){ //Week-end
				setBackground(new Color(255, 220, 220));
			}
			else{ //Week
				setBackground(new Color(255, 255, 255));
			}
			if (value != null){
//				if (Integer.parseInt(value.toString()) == realDay && currentWeek == realWeek && currentYear == realYear){ //Today
//					setBackground(new Color(220, 220, 255));
//				}
			}
			setBorder(null);
			setForeground(Color.black);
			return this;
		}
	}

	static class btnPrev_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			if (currentWeek == 1){ //Back one year
				currentYear -= 1;
				GregorianCalendar cal = new GregorianCalendar(currentYear,1,1);
				currentWeek = cal.getWeeksInWeekYear();
			}
			else{ //Back one month
				currentWeek -= 1;
			}
			refreshCalendar(currentWeek, currentYear);
		}
	}
	static class btnNext_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			GregorianCalendar cal = new GregorianCalendar(currentYear,1,1);
			if (currentWeek == cal.getWeeksInWeekYear()){ //Foward one year
				currentWeek = 1;
				currentYear += 1;
			}
			else{ //Foward one month
				currentWeek += 1;
			}
			refreshCalendar(currentWeek, currentYear);
		}
	}
	static class cmbYear_Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			if (cmbYear.getSelectedItem() != null){
				String b = cmbYear.getSelectedItem().toString();
				currentYear = Integer.parseInt(b);
				refreshCalendar(currentWeek, currentYear);//TODO check for max week in new year
			}
		}
	}
}
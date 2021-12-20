package swing;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import dao.ReservDAO;
import dto.ReservDTO;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.Color;
import java.awt.Font;

public class Reservmain extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public static final int NONE = 0;
	public static final int ADD = 1;
	public static final int DELETE = 2;
	public static final int UPDATE = 3;
	public static final int UPDATE_CHANGE = 4;
	public static final int SEARCH = 5;
	
	JPanel contentPane;
	JTable table;
	JButton addB, modB, delB, searchB, allShowB, logoutB, ticketB;
	JTextField tf_title, tf_rname, tf_tel, tf_grade, tf_opendate, tf_rloc, tf_rno;
	JTextField tf_opendate1, tf_rloc1, tf_grade1, tf_rno1, tf_opendate2, tf_rloc2, tf_rno2, tf_rdate2, tf_grade2;
	JButton closeB;
	JLabel background;
	int cmd;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservmain frame = new Reservmain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Reservmain() {
		
		background=new JLabel(new ImageIcon(getClass().getResource("/images/reservback.png")));
		add(background);
		
		setTitle("\uD2F0\uCF13 \uC608\uC57D \uC815\uBCF4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 1055, 539);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(background);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBackground(Color.BLACK);
		scrollPane.setBorder(null);
		scrollPane.setFont(new Font("ÇÑÄÄ À±°íµñ 250", Font.PLAIN, 10));
		scrollPane.setForeground(Color.WHITE);
		scrollPane.setBounds(179, 210, 848, 245);
		scrollPane.setBackground(new Color(255,0,0,0));
		background.add(scrollPane);
		table = new JTable();
		table.setSelectionBackground(Color.WHITE);
		table.setGridColor(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setBorder(null);
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setFont(new Font("ÇÑÄÄ À±°íµñ 230", Font.PLAIN, 12));
		table.setForeground(Color.BLACK);
		table.setSelectionForeground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uC608\uC57D\uBC88\uD638", "\uACF5\uC5F0\uBA85", "\uC608\uC57D\uC790\uBA85", "\uC608\uC57D\uC790 \uC5F0\uB77D\uCC98", "\uACF5\uC5F0\uC7A5\uC18C", "\uACF5\uC5F0\uC77C", "\uC88C\uC11D\uB4F1\uAE09", "\uC608\uC57D\uC77C", "\uC54C\uB9BC\uD1A1 \uC804\uC1A1\uC77C"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(129);
		table.getColumnModel().getColumn(8).setPreferredWidth(87);
		scrollPane.setViewportView(table);

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		setVisible(true);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(179, 53, 848, 134);
		background.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255,0,0,0));
		panel_1.add(tf_title = new JTextField());
		tf_title.setBorder(null);
		tf_title.setBounds(94, 58, 114, 22);
		tf_title.setColumns(10);
		panel_1.add(tf_tel = new JTextField());
		tf_tel.setBorder(null);
		tf_tel.setColumns(10);
		tf_tel.setBounds(304, 11, 114, 22);
		panel_1.add(tf_rname = new JTextField());
		tf_rname.setBorder(null);
		tf_rname.setColumns(10);
		tf_rname.setBounds(94, 100, 114, 22);
		panel_1.add(tf_grade = new JTextField());
		tf_grade.setBorder(null);
		tf_grade.setColumns(10);
		tf_grade.setBounds(512, 13, 114, 22);
		panel_1.add(tf_opendate = new JTextField());
		tf_opendate.setBorder(null);
		tf_opendate.setColumns(10);
		tf_opendate.setBounds(304, 100, 114, 22);
		panel_1.add(tf_rloc = new JTextField());
		tf_rloc.setBorder(null);
		tf_rloc.setColumns(10);
		tf_rloc.setBounds(304, 56, 114, 22);
		panel_1.add(tf_rno = new JTextField());
		tf_rno.setBorder(null);
		tf_rno.setEditable(false);
		tf_rno.setColumns(10);
		tf_rno.setBounds(94, 12, 114, 22);
		panel_1.add(logoutB = new JButton("·Î±×¾Æ¿ô"));
		logoutB.setForeground(Color.WHITE);
		logoutB.setFont(new Font("ÇÑÄÄ À±°íµñ 230", Font.PLAIN, 20));
		logoutB.setBackground(Color.BLACK);
		logoutB.setBorder(null);
		logoutB.setBounds(715, 26, 114, 37);
		logoutB.addActionListener(this);
		panel_1.add(allShowB = new JButton("ÀüÃ¼Á¶È¸"));
		allShowB.setForeground(Color.WHITE);
		allShowB.setFont(new Font("ÇÑÄÄ À±°íµñ 230", Font.PLAIN, 20));
		allShowB.setBackground(Color.BLACK);
		allShowB.setBorder(null);
		allShowB.setBounds(715, 75, 114, 37);
		allShowB.addActionListener(this);
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(26, 210, 141, 245);
		background.add(panel_3);
		panel_3.setBackground(new Color(255,0,0,0));
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(26, 271, 141, 234);
		panel_5.setBackground(new Color(255,0,0,0));
		background.add(panel_3);
		panel_3.setLayout(null);
		panel_3.add(addB = new JButton("¿¹¾à Ãß°¡"));
		addB.setForeground(Color.WHITE);
		addB.setFont(new Font("ÇÑÄÄ À±°íµñ 230", Font.PLAIN, 20));
		addB.setBackground(Color.BLACK);
		addB.setBorder(null);
		addB.setBounds(12, 71, 117, 43);
		addB.addActionListener(this);
		panel_3.add(modB = new JButton("¿¹¾à ¼öÁ¤"));
		modB.setForeground(Color.WHITE);
		modB.setFont(new Font("ÇÑÄÄ À±°íµñ 230", Font.PLAIN, 20));
		modB.setBackground(Color.BLACK);
		modB.setBorder(null);
		modB.setBounds(12, 131, 117, 43);
		modB.addActionListener(this);
		panel_3.add(delB = new JButton("¿¹¾à »èÁ¦"));
		delB.setForeground(Color.WHITE);
		delB.setFont(new Font("ÇÑÄÄ À±°íµñ 230", Font.PLAIN, 20));
		delB.setBackground(Color.BLACK);
		delB.setBorder(null);
		delB.setBounds(12, 191, 117, 43);
		delB.addActionListener(this);
		panel_3.add(searchB = new JButton("°Ë »ö"));
		searchB.setForeground(Color.WHITE);
		searchB.setFont(new Font("ÇÑÄÄ À±°íµñ 230", Font.PLAIN, 20));
		searchB.setBackground(Color.BLACK);
		searchB.setBorder(null);
		searchB.setBounds(12, 12, 117, 43);
		searchB.addActionListener(this);
		panel_5.setLayout(null);
		panel_5.setToolTipText("\u3147\u3141\u313B\u3134\u3147");
		
		cmd = NONE;
		
		initialize();
		displayReservInfo();
		
		setVisible(true);
}
	
	public void addReserv() {
		String title=tf_title.getText();
		
		if(title.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "°ø¿¬¸íÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_title.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃÐÁ¡(Focus) ÀÌµ¿
			return;
		}
		
		String grade=tf_grade.getText();
		
		if(grade.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "µî±ÞÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_grade.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃÐÁ¡(Focus) ÀÌµ¿
			return;
		}
		
		String opendate=tf_opendate.getText();
		
		if(opendate.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "°ø¿¬ÀÏÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_opendate.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃÐÁ¡(Focus) ÀÌµ¿
			return;
		}
		
		String opendateReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(opendateReg, opendate)) {
			JOptionPane.showMessageDialog(this, "°ø¿¬ÀÏÀ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_opendate.requestFocus();
			return;
		}
		
		String rloc=tf_rloc.getText();
		
		if(rloc.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "°ø¿¬Àå¼Ò¸¦ ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_rloc.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃÐÁ¡(Focus) ÀÌµ¿
			return;
		}
		
		String rname=tf_rname.getText();
		
		if(rname.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_rname.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃÐÁ¡(Focus) ÀÌµ¿
			return;
		}
		
		String rnameReg="^([°¡-ÆR]{2,7})$";//2~7 ¹üÀ§ÀÇ ÇÑ±ÛÀ» Ç¥ÇöÇÑ Á¤±Ô Ç¥Çö½Ä
		if(!Pattern.matches(rnameReg, rname)) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§Àº 2~7 ¹üÀ§ÀÇ ÇÑ±Û¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_rname.requestFocus();
			return;
		}
		
		String tel=tf_tel.getText();
		
		if(tel.equals("")) {
			JOptionPane.showMessageDialog(this, "¿¬¶ôÃ³¸¦ ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_tel.requestFocus();
			return;
		}
		
		String telReg="(01[016789])-\\d{3,4}-\\d{4}";
		if(!Pattern.matches(telReg, tel)) {
			JOptionPane.showMessageDialog(this, "¿¬¶ôÃ³¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_tel.requestFocus();
			return;
		}
		
		ReservDTO reserv=new ReservDTO();
		reserv.setTitle(title);
		reserv.setR_grade(grade);
		reserv.setOpen_date(opendate);
		reserv.setR_loc(rloc);
		reserv.setR_name(rname);
		reserv.setTel(tel);
		
		int rows=ReservDAO.getDao().insertReserv(reserv);
		
		displayReservInfo();
		
		initDisplay();
	}
	
	public void removeReserv() {
		String inputNo=tf_rno.getText();
		
		if(inputNo.equals("")) {
			JOptionPane.showMessageDialog(this, "¿¹¾à¹øÈ£¸¦ ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_rno.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(inputNo);
		int rows=ReservDAO.getDao().deleteReserv(no);
		
		displayReservInfo();

		initDisplay();
	}
	
	public void searchNoReserv() {
		String inputNo=tf_rno.getText();
		
		if(inputNo.equals("")) {
			JOptionPane.showMessageDialog(this, "¿¹¾à¹øÈ£¸¦ ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_rno.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(inputNo);

		ReservDTO reserv=ReservDAO.getDao().selectNoReserv(no);
		
		tf_title.setText(reserv.getTitle());
		tf_grade.setText(reserv.getR_grade());
		tf_opendate.setText(reserv.getOpen_date());
		tf_rloc.setText(reserv.getR_loc());
		tf_rname.setText(reserv.getR_name());
		tf_tel.setText(reserv.getTel());
		
		setEnable(UPDATE_CHANGE);
	}
	
	public void updateReserv() {
		String title=tf_title.getText();
		
		if(title.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "°ø¿¬¸íÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_title.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃÐÁ¡(Focus) ÀÌµ¿
			return;
		}
		
		String grade=tf_grade.getText();
		
		if(grade.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "µî±ÞÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_grade.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃÐÁ¡(Focus) ÀÌµ¿
			return;
		}
		
		String opendate=tf_opendate.getText();
		
		if(opendate.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "°ø¿¬ÀÏÀ» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_opendate.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃÐÁ¡(Focus) ÀÌµ¿
			return;
		}
		
		String opendateReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
		if(!Pattern.matches(opendateReg, opendate)) {
			JOptionPane.showMessageDialog(this, "°ø¿¬ÀÏÀ» Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_opendate.requestFocus();
			return;
		}
		
		String rloc=tf_rloc.getText();
		
		if(rloc.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "°ø¿¬Àå¼Ò¸¦ ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_rloc.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃÐÁ¡(Focus) ÀÌµ¿
			return;
		}
		
		String rname=tf_rname.getText();
		
		if(rname.equals("")) {//ÀÔ·Â°ªÀÌ ¾ø´Â °æ¿ì
			JOptionPane.showMessageDialog(this, "ÀÌ¸§À» ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_rname.requestFocus();//ÄÄÆÛ³ÍÆ®·Î ÀÔ·ÂÃÐÁ¡(Focus) ÀÌµ¿
			return;
		}
		
		String rnameReg="^([°¡-ÆR]{2,7})$";//2~7 ¹üÀ§ÀÇ ÇÑ±ÛÀ» Ç¥ÇöÇÑ Á¤±Ô Ç¥Çö½Ä
		if(!Pattern.matches(rnameReg, rname)) {
			JOptionPane.showMessageDialog(this, "ÀÌ¸§Àº 2~7 ¹üÀ§ÀÇ ÇÑ±Û¸¸ ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_rname.requestFocus();
			return;
		}
		
		String tel=tf_tel.getText();
		
		if(tel.equals("")) {
			JOptionPane.showMessageDialog(this, "¿¬¶ôÃ³¸¦ ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_tel.requestFocus();
			return;
		}
		
		String telReg="(01[016789])-\\d{3,4}-\\d{4}";
		if(!Pattern.matches(telReg, tel)) {
			JOptionPane.showMessageDialog(this, "¿¬¶ôÃ³¸¦ Çü½Ä¿¡ ¸Â°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_tel.requestFocus();
			return;
		}
		
		String inputNo=tf_rno.getText();
		
		int no=Integer.parseInt(inputNo);
		
		ReservDTO reserv=new ReservDTO();
		reserv.setTitle(title);
		reserv.setR_name(rname);
		reserv.setTel(tel);
		reserv.setR_loc(rloc);
		reserv.setOpen_date(opendate);
		reserv.setR_grade(grade);
		reserv.setR_no(no);
		
		int rows=ReservDAO.getDao().updateReserv(reserv);
		
		displayReservInfo();
		initDisplay();
	}
	
	public void searchNameReserv() {
		String inputNo=tf_rno.getText();
		
		if(inputNo.equals("")) {
			JOptionPane.showMessageDialog(this, "¿¹¾à¹øÈ£¸¦ ¹Ýµå½Ã ÀÔ·ÂÇØ ÁÖ¼¼¿ä.");
			tf_rno.requestFocus();
			return;
		}
		
		int no=Integer.parseInt(inputNo);
		List<ReservDTO> reservList=ReservDAO.getDao().searchNo(no);
		
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}
		
		for(ReservDTO reservInfo:reservList) {
			Vector<Object> rowData=new Vector<Object>();
			rowData.add(reservInfo.getR_no());
			rowData.add(reservInfo.getTitle());
			rowData.add(reservInfo.getR_name());
			rowData.add(reservInfo.getTel());
			rowData.add(reservInfo.getR_loc());
			rowData.add(reservInfo.getOpen_date());
			rowData.add(reservInfo.getR_grade());
			rowData.add(reservInfo.getR_date());
			rowData.add(reservInfo.getAlarm_date());
			model.addRow(rowData);
		}
		
		initDisplay();
	}
	
	public void Editable(int n) {
		switch(n) {
		case ADD :
			tf_title.setEditable(true);
			tf_grade.setEditable(true);
			tf_opendate.setEditable(true);
			tf_rloc.setEditable(true);
			tf_rname.setEditable(true);
			tf_tel.setEditable(true);
			break;
		case DELETE:
			tf_rno.setEditable(true);
			break;
		case UPDATE:
			tf_rno.setEditable(true);
			break;
		case UPDATE_CHANGE:
			tf_rno.setEditable(false);
			tf_title.setEditable(true);
			tf_grade.setEditable(true);
			tf_opendate.setEditable(true);
			tf_rloc.setEditable(true);
			tf_rname.setEditable(true);
			tf_tel.setEditable(true);
			break;
		case SEARCH:
			tf_rno.setEditable(true);
			break;
		case NONE:
			tf_rno.setEditable(false);
			tf_title.setEditable(false);
			tf_grade.setEditable(false);
			tf_opendate.setEditable(false);
			tf_rloc.setEditable(false);
			tf_rname.setEditable(false);
			tf_tel.setEditable(false);
		}
	}
	
	public void setEnable(int n) {
		addB.setEnabled(false);
		delB.setEnabled(false);
		modB.setEnabled(false);
		searchB.setEnabled(false);

		switch (n) {
		case ADD:
			addB.setEnabled(true);
			Editable(ADD);
			cmd = ADD;
			break;
		case DELETE:
			delB.setEnabled(true);
			Editable(DELETE);
			cmd = DELETE;
			break;
		case UPDATE:
			modB.setEnabled(true);
			Editable(UPDATE);
			cmd = UPDATE;
			break;			
		case UPDATE_CHANGE:
			modB.setEnabled(true);
			Editable(UPDATE_CHANGE);
			cmd = UPDATE_CHANGE;
			break;
		case SEARCH:
			searchB.setEnabled(true);
			Editable(SEARCH);
			cmd = SEARCH;
			break;
		case NONE:
			addB.setEnabled(true);
			delB.setEnabled(true);
			modB.setEnabled(true);
			searchB.setEnabled(true);
		}
	}
	
	public void clear() {
		tf_grade.setText("");
		tf_opendate.setText("");
		tf_rloc.setText("");
		tf_rname.setText("");
		tf_tel.setText("");
		tf_title.setText("");
		tf_rno.setText("");
	}
	
	public void initialize() {
		tf_grade.setEditable(false);
		tf_opendate.setEditable(false);
		tf_rloc.setEditable(false);
		tf_rname.setEditable(false);
		tf_tel.setEditable(false);
		tf_title.setEditable(false);
		tf_rno.setEditable(false);
	}
	
	public void initDisplay() {
		setEnable(NONE);
		clear();
		cmd = NONE;
		initialize();		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		try {
			if(obj.equals(addB)) {
				if(cmd!=ADD) {
					setEnable(ADD);
				} else {
					addReserv();
				}
			
			} else if (obj.equals(delB)) {
				if (cmd != DELETE) {
					setEnable(DELETE);
				} else {
					removeReserv();
				}
			} else if (obj.equals(modB)) {
				if (cmd != UPDATE && cmd != UPDATE_CHANGE) {
					setEnable(UPDATE);
				} else if (cmd != UPDATE_CHANGE){
					searchNoReserv();
				} else {
					updateReserv();
				}
				
			} else if (obj.equals(searchB)) {
				if (cmd != SEARCH) {
					setEnable(SEARCH);
				} else {
					searchNameReserv();
				}
			} else if (obj.equals(allShowB)) {
				displayReservInfo();
				initDisplay();
			} else if (obj.equals(logoutB)) {
				new LoginApp();
				dispose();

			}
		} catch (Exception ee) {
			System.out.println("¿¹¿Ü¹ß»ý : "+ee);
		}
	}
	
	public void displayReservInfo() {
		List<ReservDTO> reservInfo=ReservDAO.getDao().showAll();

		DefaultTableModel model=(DefaultTableModel)table.getModel();
		
		
		for(int i=model.getRowCount();i>0;i--) {
			model.removeRow(0);
		}

		for(ReservDTO reserv:reservInfo) {
			Vector<Object> rowData=new Vector<Object>();
			rowData.add(reserv.getR_no());
			rowData.add(reserv.getTitle());
			rowData.add(reserv.getR_name());
			rowData.add(reserv.getTel());
			rowData.add(reserv.getR_loc());
			rowData.add(reserv.getOpen_date());
			rowData.add(reserv.getR_grade());
			rowData.add(reserv.getR_date());
			rowData.add(reserv.getAlarm_date());
			model.addRow(rowData);
		}
	}

}

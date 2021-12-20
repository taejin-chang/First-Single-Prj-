package swing;

import java.awt.Container;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import com.sun.tools.javac.Main;

import dao.ManagerDAO;
import dto.ManagerDTO;
import dto.ReservDTO;
import main.login;
import java.awt.Color;
import java.awt.Font;

public class LoginApp extends JFrame{
	
	JTextField tf_id;
	JPasswordField tf_pw;
	
	public LoginApp() {
		getContentPane().setLayout(null);

		JLabel background=new JLabel(new ImageIcon(getClass().getResource("/images/mainback.png")));
		background.setBounds(0, 0, 284, 375);
		getContentPane().add(background);
		
		JPanel panel = new JPanel();
		tf_id = new JTextField(10);
		tf_id.setFont(new Font("Arial", Font.PLAIN, 15));
		tf_id.setBorder(null);
		tf_id.setBounds(106, 216, 116, 21);
		tf_pw = new JPasswordField(10);
		tf_pw.setFont(new Font("Arial", Font.PLAIN, 15));
		tf_pw.setBorder(null);
		tf_pw.setBounds(106, 257, 116, 21);
		
		ImageIcon loginimg = new ImageIcon(getClass().getResource("/images/loginbutton.png"));
		background.setLayout(null);
		
		JButton logBtn = new JButton(loginimg);
		logBtn.setBorder(null);
		logBtn.setBackground(new Color(240, 240, 240));
		logBtn.setBounds(71, 306, 137, 42);
		background.add(logBtn);
		
		logBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<ManagerDTO> managerInfo=ManagerDAO.getDao().showManager();
				login login = new login();
				
				int result = login.findIdPw(tf_id.getText(), tf_pw.getText());
				
				idpwCheck();
				
				if(result ==1) {
					new Reservmain();
					setVisible(false);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
			}
		});
		background.add(tf_id);
		background.add(tf_pw);
		getContentPane().add(background);
		
		setVisible(true);
		setSize(300,414);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void idpwCheck() {
		String id=tf_id.getText();
		String pw=tf_pw.getText();
		
		if(id.equals("")) {
			JOptionPane.showMessageDialog(this, "아이디를 반드시 입력해 주세요.");
			tf_id.requestFocus();
			return;
		}
		
		if(pw.equals("")) {//입력값이 없는 경우
			JOptionPane.showMessageDialog(this, "비밀번호를 반드시 입력해 주세요.");
			tf_pw.requestFocus();
			return;
		}
		
	}
	public static void main(String args[])
	{
		new LoginApp();
	}
}


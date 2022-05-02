package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import connectDB.Database;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class FormDangNhap extends JFrame implements ActionListener{
	public String TaiKhoan;
	private JPanel contentPane;
	private JTextField txtUsename;
	private JPasswordField txtPass;
	private JButton btnReset, btnExit, btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the frame.
	 */
	public FormDangNhap() {
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblLoginSystems = new JLabel("ĐĂNG NHẬP ");
		lblLoginSystems.setBounds(150, 11, 300, 30);
		lblLoginSystems.setBackground(Color.PINK);
		lblLoginSystems.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblLoginSystems);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 52, 434, 209);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsename = new JLabel("Username :");
		lblUsename.setBounds(50, 40, 80, 14);
		lblUsename.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(lblUsename);
		
		txtUsename = new JTextField();
		txtUsename.setBounds(120, 37, 200, 20);
		panel_1.add(txtUsename);
		txtUsename.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password  :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(50, 81, 67, 14);
		panel_1.add(lblPassword);
		
		btnReset = new JButton("Reset");
		btnReset.setBackground(Color.ORANGE);
		btnReset.addActionListener(this);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(120, 78, 200, 20);
		panel_1.add(txtPass);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setBounds(33, 159, 89, 23);
		panel_1.add(btnReset);
		
		btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.green);
		btnLogin.addActionListener(this);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBounds(162, 159, 89, 23);
		panel_1.add(btnLogin);
		
		btnExit = new JButton("Exit");
		btnExit.setBackground(Color.RED);
		btnExit.addActionListener(this);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(293, 159, 89, 23);
		panel_1.add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 136, 371, 2);
		panel_1.add(separator);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	   Object obj=e.getSource();
			   if(obj.equals(btnLogin)) {
				   checklogin();
			   }
			   if(obj.equals(btnExit)) {
				   System.exit(EXIT_ON_CLOSE);
			   }
			   if(obj.equals(btnReset)) {
				   txtUsename.setText(null);
					txtPass.setText(null);
			   }
	    }
     @SuppressWarnings("deprecation")
	private void checklogin() {
    	   if((txtUsename.getText()).equals("")) {
   	    	JOptionPane.showMessageDialog(this, "Vui lòng điền tài khoản!");
   	    }
   	    else if((txtPass.getText()).equals("")) {
   	    	JOptionPane.showMessageDialog(this, "Vui lòng điền mật khẩu!");
   	    }
   	    else {
   	    	
   	    		Database.getInstance().connect();
   	    		Connection conn = Database.getConnection();
   	    		try {
   				String sql = "select maNguoiDung from TaiKhoan where maTK = ? and matKhau = ?";
   				PreparedStatement pstm = conn.prepareStatement(sql);
   				pstm.setString(1, txtUsename.getText());
   				pstm.setString(2, txtPass.getText());
   				ResultSet rs=pstm.executeQuery();
   				if(rs.next()) {
   					TaiKhoan = rs.getString(1);
   					GiaoDienChinh info = new GiaoDienChinh();
   					info.setLocationRelativeTo(null);
   					info.setVisible(true);
   					
   				}
   				else {
   					JOptionPane.showMessageDialog(this, "Đăng nhập thất bại! Kiểm tra lại tài khoản/mật khẩu!");
   					txtUsename.requestFocus();
   				}
   	    	}catch(Exception e1) {
   					System.out.println(e1);
   				}
   	    	}
     }
        

}

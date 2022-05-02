package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import connectDB.ConnectDB;
import dao.DAO_DangNhap;


public class GUI_DangNhap extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassWord;
	private JButton btnThot;
	private AbstractButton btnngNhp;
	private JLabel lblGio;
	private static String dnma;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DangNhap frame = new GUI_DangNhap();
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
	public GUI_DangNhap() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Đăng Nhập");
		setBounds(100, 100, 1036, 599);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		try{
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		new DAO_DangNhap();
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 999, 539);
		contentPane.add(panel);
		panel.setLayout(null);
		
		setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon("data\\\\\\\\img\\\\\\\\backgroud.jpg"));
		add(background);
		background.setLayout(new FlowLayout());
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setToolTipText("Thông Tin Đăng Nhập");
		panel_1.setBounds(10, 10, 979, 131);
		panel.add(panel_1);
		panel_1.setLayout(null);
		lblGio = new JLabel();
		lblGio.setForeground(Color.black);
		lblGio.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblGio.setBounds(875, 0, 94, 35);
		panel_1.add(lblGio);
		addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                System.exit(1);
	            }
	        });
		
		
		JLabel lblNewLabel = new JLabel("Thông Tin Đăng Nhập");
		lblNewLabel.setBounds(271, 67, 455, 58);
		lblNewLabel.setMaximumSize(new Dimension(90, 13));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 45));
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Thành Phát Company");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 56));
		lblNewLabel_2.setBounds(217, 0, 722, 72);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(SystemColor.activeCaption);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1.setBounds(10, 151, 979, 260);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản:");
		lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(209, 25, 132, 29);
		panel_1_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1.setFont(new Font("Serif", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(209, 131, 132, 29);
		panel_1_1.add(lblNewLabel_1_1);
		
		txtUserName = new JTextField();
		txtUserName.setForeground(Color.DARK_GRAY);
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtUserName.setToolTipText("User Name");
		txtUserName.setColumns(10);
		txtUserName.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		txtUserName.setBounds(209, 64, 600, 37);
		panel_1_1.add(txtUserName);
		
		txtPassWord = new JPasswordField();
		txtPassWord.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtPassWord.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK));
		txtPassWord.setBounds(209, 170, 600, 45);
		panel_1_1.add(txtPassWord);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setSize(new Dimension(10, 10));
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setLayout(null);
		panel_2.setBounds(10, 421, 979, 108);
		panel.add(panel_2);
		btnThot = new JButton(" Thoát");
		btnThot.setIcon(new ImageIcon("data\\img\\icons8-exit-50.png"));
		btnThot.setBorder(UIManager.getBorder("Button.border"));
		btnThot.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		btnThot.setBounds(785, 39, 184, 53);
		panel_2.add(btnThot);
		
		btnngNhp = new JButton("  Đăng Nhập");
		btnngNhp.setIcon(new ImageIcon("data\\img\\icons8-login-50.png"));
		btnngNhp.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 25));
		btnngNhp.setBorder(UIManager.getBorder("Button.border"));
		btnngNhp.setBounds(384, 10, 234, 53);
		panel_2.add(btnngNhp);
		setResizable(false);
		btnngNhp.addActionListener(this);
		btnThot.addActionListener(this);	
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	@Override
public void actionPerformed(ActionEvent e ) {
	Object o = e.getSource();
		if(o.equals(btnThot))
			System.exit(0);
		if(o.equals(btnngNhp)) {
			if(txtUserName.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Chú ý: Vui lòng nhâp tài khoản!");
			}else {
				if(txtPassWord.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "Chú ý: Vui lòng Nhập Mật Khẩu!");
				}else {
					ConnectDB.getInstance();
					Connection con = ConnectDB.getConnection();
					try {
						
						String stmt = "select *from TaiKhoan where tenTaiKhoan=? AND matKhau=?";
						PreparedStatement ps= con.prepareStatement(stmt);
						ps.setString(1, txtUserName.getText());
						ps.setString(2, txtPassWord.getText());	
						
						ResultSet rs = ps.executeQuery();
						if(rs.next()){
							GUI_DangNhap.dnma=rs.getString(1);
							this.setVisible(false);
							new GUI_TabpanelMenu().setVisible(true);
						}else {
							JOptionPane.showMessageDialog(this, "Đăng nhâp thất bại!");
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
			
		}
	}

	public static String getDnma() {
		return dnma;
	}
	
	
}

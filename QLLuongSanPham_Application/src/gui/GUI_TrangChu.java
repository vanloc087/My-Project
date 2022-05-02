package gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JOptionPane;

public class GUI_TrangChu extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel txtma;
	private JButton btnthongtin;
	private JButton btnQuanLyTK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_TrangChu frame = new GUI_TrangChu();
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
	public GUI_TrangChu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	    contentPane.setLayout(null);
	
	    
	    JLabel lblNewLabel = new JLabel("NV004");
	    lblNewLabel.setBounds(1097, 20, 81, 60);
	    lblNewLabel.setBackground(Color.GRAY);
	    lblNewLabel.setIcon(new ImageIcon("data\\img\\icons8-user-64.png"));
	    lblNewLabel.setForeground(Color.WHITE);
	    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
	    getContentPane().add(lblNewLabel);
	    
	    btnthongtin = new JButton("Thông Tin");
	    btnthongtin.setBackground(Color.ORANGE);
	    btnthongtin.setBounds(1107, 90, 229, 32);
	    btnthongtin.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    contentPane.add(btnthongtin);
	    
	    txtma = new JLabel("NV-0001");
	    txtma.setBounds(1178, 27, 138, 54);
	    txtma.setFont(new Font("Tahoma", Font.PLAIN, 30));
	    txtma.setText(GUI_DangNhap.getDnma());
	    contentPane.add(txtma);
	    
	    btnQuanLyTK = new JButton("Quản Lý Tài Khoản");
	    btnQuanLyTK.setBackground(Color.ORANGE);
	    btnQuanLyTK.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    btnQuanLyTK.setBounds(1107, 150, 229, 32);
	   // contentPane.add(btnQuanLyTK);
	    
	    JLabel background=new JLabel(new ImageIcon("data\\\\\\\\img\\\\\\\\2.jpg"));
	    background.setBounds(10, 0, 1336, 663);
	    background.setBackground(Color.GRAY);
	    background.setFont(new Font("Tahoma", Font.PLAIN, 23));
	    getContentPane().add(background);
	    background.setLayout(new FlowLayout());

	    btnthongtin.addActionListener(this);
	    btnQuanLyTK.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnthongtin)) {
			new GUI_ThongTinTK().setVisible(true);
			this.setVisible(false);
		}
		if(o.equals(btnQuanLyTK)) {
			String ma = GUI_DangNhap.getDnma(); 
			if(ma.matches("QL001")) {
				new GUI_QuanLyTaiKhoan().setVisible(true);
				this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(this, "Chú ý:Chức năng này chỉ dành cho quản lý!");
			}	
		}
		
	}
}

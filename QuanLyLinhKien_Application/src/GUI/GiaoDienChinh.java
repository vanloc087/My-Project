package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GiaoDienChinh extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbllk;

	public GiaoDienChinh() {
		setTitle("Linh Kiện");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(5, 5, 548, 69);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblQunLNh = new JLabel("Quản Lý Bán Hàng");
		lblQunLNh.setBounds(154, 11, 353, 31);
		lblQunLNh.setForeground(Color.BLUE);
		lblQunLNh.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblQunLNh);
		
		JButton btnQunLNhn = new JButton("Quản Lý Khách Hàng ");
		btnQunLNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormKhachHang info = new FormKhachHang();
				info.setVisible(true);
				info.setSize(600, 600);
				info.pack();
				info.setLocationRelativeTo(null);
				info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
				
			
			}
		});
		btnQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQunLNhn.setBounds(202, 100, 187, 23);
		contentPane.add(btnQunLNhn);
		
		JButton btnThngTinKhch = new JButton("Quản Lý Nhân Viên");
		btnThngTinKhch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formNV info = new formNV();
				info.setVisible(true);
			//	info.pack();
				info.setLocationRelativeTo(null);
				info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		btnThngTinKhch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThngTinKhch.setBounds(202, 160, 187, 23);
		contentPane.add(btnThngTinKhch);
		
		
		JButton btnNhpThuc = new JButton("Quản Lý Linh Kiện ");
		btnNhpThuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormQuanLyLinhKien info = new FormQuanLyLinhKien();
				info.setVisible(true);
			//	info.pack();
				info.setLocationRelativeTo(null);
				info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		btnNhpThuc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNhpThuc.setBounds(202, 218, 187, 23);
		contentPane.add(btnNhpThuc);
		
		JButton btnHonKhch = new JButton("Bán Hàng");
		btnHonKhch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormBanHang info = new FormBanHang();
				info.setVisible(true);
			//	info.pack();
				info.setLocationRelativeTo(null);
				info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		btnHonKhch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHonKhch.setBounds(202, 276, 187, 23);
		contentPane.add(btnHonKhch);
		
		JButton btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormDangNhap info = new FormDangNhap();
				info.setVisible(true);
			//	info.pack();
				info.setLocationRelativeTo(null);
				info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDangXuat.setBounds(202, 345, 187, 23);
		contentPane.add(btnDangXuat);
		
	
	}
	
	public static void main(String[] args) {
	}

}

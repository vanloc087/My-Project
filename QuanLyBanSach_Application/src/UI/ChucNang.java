package UI;

import java.awt.BorderLayout;
import java.io.FileWriter;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.DAO_NhanVien;

import entity.NhanVien;

public class ChucNang extends JFrame implements ActionListener,MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnWest;
	private JButton btnTrangChu, btnQLKH, btnQLNV, btnThongKe, btnQLHoaDon, btnQLSP, btnChucNang, btnDangXuat, btnQLTaiKhoan, btnDoiMK, btnHelp;
	private JLabel lblLogo, lblQLKH,lblQLNV,lblQLTK,lblQLHD, lblQLSP, lblDangXuat, lblTrangChu, lblQLTaiKhoan, lblDoiMK, lblHelp;
	private JPanel pnCenter, pnQLKH, pnQLHoaDon, pnQLNV, pnQLThongKe, pnQLSP, pnTrangChu, pnQLTaiKhoan,pnHelp;
	private JTextField txtMaNV, txtTenNV;

	DAO_NhanVien nhanVien_dao;
	//UI_ThongTinNhanVien nv = new UI_ThongTinNhanVien();
	//UI_ThongTinKhachHang kh = new UI_ThongTinKhachHang();
	boolean flag = true;

	public static String maNhanVien = null;


	public ChucNang(String maNV) throws Exception {
		setTitle("Cửa hàng sách Flames");
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setResizable(true);
		setLocationRelativeTo(null);
		ImageIcon imgDefault = new ImageIcon("Icon/iconCuaHangSach.png");
		Image imgDefault1 = imgDefault.getImage();
		Image newImgDefault1 = imgDefault1.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		imgDefault = new ImageIcon(newImgDefault1);
		this.setIconImage(imgDefault.getImage());

		maNhanVien = maNV;
		nhanVien_dao = new DAO_NhanVien();
		pnQLKH= new JPanel();
		pnQLKH = new QuanLiKhachHang();
		pnQLHoaDon = new JPanel();
		pnQLHoaDon = new QuanLiHoaDon(maNV);
		pnQLNV = new JPanel();
		pnQLNV = new QuanLiNhanVien();
		pnQLThongKe = new JPanel();
		pnQLThongKe = new QuanLiThongKe(maNhanVien);
		pnQLSP = new JPanel();
		pnQLSP = new QuanLiSanPham();
		pnTrangChu = new JPanel();
		pnTrangChu = new TrangChu();
		pnQLTaiKhoan = new JPanel();
		pnQLTaiKhoan = new QuanLiTaiKhoan();
		pnHelp = new JPanel();
		pnHelp = new TroGiup(maNhanVien);


		//North
		JPanel pnNorth = new JPanel();
		pnNorth.setPreferredSize(new Dimension(150,60));
		pnNorth.setLayout(new BorderLayout());
		pnNorth.setBackground(Color.cyan);

		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBackground(new Color(255, 255, 255));
		pnTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblTieuDe = new JLabel("Quản Lý Hiệu Sách FLAMES");
		Font font =new Font("Arial",Font.BOLD,25);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		pnTieuDe.add(lblTieuDe);

		JPanel pnTTNhanVien = new JPanel();
		pnTTNhanVien.setBackground(new Color(255, 255, 255));
		pnTTNhanVien.setLayout(new GridLayout(2,1));
		JPanel pnMaNV = new JPanel();
		pnMaNV.setBackground(new Color(255, 255, 255));
		JLabel lblMaNV = new JLabel("Mã nhân viên: ");
		txtMaNV = new JTextField(10);
		txtMaNV.setText(maNhanVien);
		txtMaNV.setEditable(false);
		txtMaNV.setOpaque(false);
		pnMaNV.add(lblMaNV);
		pnMaNV.add(txtMaNV);
		JPanel pnTenNV = new JPanel();
		pnTenNV.setBackground(new Color(255, 255, 255));
		JLabel lblTenNV = new JLabel("Tên nhân viên: ");
		txtTenNV = new JTextField(10);
		txtTenNV.setText(nhanVien_dao.layNhanVienTheoMa(maNhanVien).getTenNV().toString());
		txtTenNV.setOpaque(false);
		txtTenNV.setEditable(false);
		pnTenNV.add(lblTenNV);
		pnTenNV.add(txtTenNV);

		lblMaNV.setPreferredSize(lblTenNV.getPreferredSize());
		pnTTNhanVien.add(pnMaNV);
		pnTTNhanVien.add(pnTenNV);
		pnTTNhanVien.setBackground(Color.CYAN);
		pnNorth.add(pnTTNhanVien,BorderLayout.EAST);
		pnNorth.add(pnTieuDe,BorderLayout.CENTER);
		pnNorth.add(pnTieuDe,BorderLayout.CENTER);
		add(pnNorth,BorderLayout.NORTH);


		//Center
		pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout());
		pnCenter.setBackground(new Color(255, 255, 255));

		pnCenter.add(pnTrangChu);
		add(pnCenter, BorderLayout.CENTER);

		//WEST
		pnWest = new JPanel();
		pnWest.setBackground(new Color(255, 255, 255));
		pnWest.setLayout(new BorderLayout());
		JLabel iconLabel = new JLabel(new ImageIcon("Icon/menu.png"));
		btnChucNang = new JButton("");
		btnChucNang.setLayout(new BorderLayout());
		btnChucNang.add(iconLabel,BorderLayout.CENTER);//Vinh 29-5
		btnChucNang.setPreferredSize(new Dimension(50,50));
		btnChucNang.setBackground(new Color(255, 255, 255));
		btnChucNang.setBorderPainted(false);
		btnChucNang.setFocusPainted(false);
		btnChucNang.setContentAreaFilled(false);
		btnChucNang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		lblLogo = new JLabel(ResizeImage("Icon/logo1.jpg"));
		lblLogo.setPreferredSize(new Dimension(140,50));
		JPanel pnChucNang = new JPanel();
		pnChucNang.setLayout(new FlowLayout(FlowLayout.LEFT));
		//pnChucNang.setPreferredSize(pnTTNhanVien.getPreferredSize());
		pnChucNang.add(btnChucNang);
		pnChucNang.add(lblLogo);
		pnChucNang.setBackground(new Color(255, 255, 255));
		pnNorth.add(pnChucNang,BorderLayout.WEST);

		ImageIcon imgqlkh = new ImageIcon("Icon/cus5.png");
		Image img1 = imgqlkh.getImage();
		Image newImg1 = img1.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		imgqlkh = new ImageIcon(newImg1);
		JLabel iconLabel1 = new JLabel(imgqlkh);
		lblQLKH = new JLabel("Quản lý khách hàng", SwingConstants.CENTER);

		btnQLKH = new JButton("");
		btnQLKH.setLayout(new BorderLayout());
		btnQLKH.add(iconLabel1,BorderLayout.WEST);
		btnQLKH.add(lblQLKH,BorderLayout.CENTER);

		ImageIcon imgqlnv = new ImageIcon("Icon/employee.png");
		Image img2 = imgqlnv.getImage();
		Image newImg2 = img2.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		imgqlnv = new ImageIcon(newImg2);
		JLabel lblImgQLNV = new JLabel(imgqlnv);
		lblQLNV = new JLabel("Quản lý nhân viên", SwingConstants.CENTER);

		btnQLNV = new JButton("");
		btnQLNV.setLayout(new BorderLayout());
		btnQLNV.add(lblImgQLNV,BorderLayout.WEST);
		btnQLNV.add(lblQLNV,BorderLayout.CENTER);

		JLabel lblImgQLTK = new JLabel(new ImageIcon("Icon/statistical.png"));
		lblQLTK = new JLabel("Quản lý thống kê", SwingConstants.CENTER);
		btnThongKe = new JButton("");
		btnThongKe.setLayout(new BorderLayout());
		btnThongKe.add(lblImgQLTK,BorderLayout.WEST);
		btnThongKe.add(lblQLTK,BorderLayout.CENTER);

		ImageIcon imgqlhd = new ImageIcon("Icon/receipt.png");
		Image img4 = imgqlhd.getImage();
		Image newImg4 = img4.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		imgqlhd = new ImageIcon(newImg4);
		JLabel lblImgQLHD = new JLabel(imgqlhd);
		lblQLHD = new JLabel("Quản lý hóa đơn", SwingConstants.CENTER);
		btnQLHoaDon = new JButton("");
		btnQLHoaDon.setLayout(new BorderLayout());
		btnQLHoaDon.add(lblImgQLHD,BorderLayout.WEST);
		btnQLHoaDon.add(lblQLHD,BorderLayout.CENTER);

		ImageIcon imgqlsp = new ImageIcon("Icon/product.png");
		Image img5 = imgqlsp.getImage();
		Image newImg5 = img5.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		imgqlsp = new ImageIcon(newImg5);
		JLabel lblImgQLSP = new JLabel(imgqlsp);
		lblQLSP = new JLabel("Quản lý sản phẩm", SwingConstants.CENTER);
		btnQLSP = new JButton("");
		btnQLSP.setLayout(new BorderLayout());
		btnQLSP.add(lblImgQLSP,BorderLayout.WEST);
		btnQLSP.add(lblQLSP,BorderLayout.CENTER);


		JLabel lblImgDangXuat = new JLabel(new ImageIcon("Icon/log-out.png"));
		lblDangXuat = new JLabel("Đăng xuất", SwingConstants.CENTER);
		lblDangXuat.setForeground(Color.WHITE);
		btnDangXuat = new JButton("");
		btnDangXuat.setLayout(new BorderLayout());
		btnDangXuat.add(lblImgDangXuat,BorderLayout.WEST);
		btnDangXuat.add(lblDangXuat,BorderLayout.CENTER);

		JLabel lblImgTrangChu = new JLabel(new ImageIcon("Icon/house.png"));
		lblTrangChu = new JLabel("Trang Chủ", SwingConstants.CENTER);
		btnTrangChu = new JButton("");
		btnTrangChu.setLayout(new BorderLayout());
		btnTrangChu.add(lblImgTrangChu,BorderLayout.WEST);
		btnTrangChu.add(lblTrangChu,BorderLayout.CENTER);


		ImageIcon imgqltk = new ImageIcon("Icon/personal-information.png");
		Image img6 = imgqltk.getImage();
		Image newImg6 = img6.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		imgqltk = new ImageIcon(newImg6);
		JLabel lblImgTaiKhoan = new JLabel(imgqltk);
		lblQLTaiKhoan = new JLabel("Quản lý tài khoản", SwingConstants.CENTER);
		btnQLTaiKhoan = new JButton("");
		btnQLTaiKhoan.setLayout(new BorderLayout());
		btnQLTaiKhoan.add(lblImgTaiKhoan,BorderLayout.WEST);
		btnQLTaiKhoan.add(lblQLTaiKhoan,BorderLayout.CENTER);

		JLabel lblImgDoiMatKhau = new JLabel(ResizeImagePassword("Icon/password.png"));
		lblDoiMK = new JLabel("Đổi mật khẩu", SwingConstants.CENTER);
		lblDoiMK.setForeground(new Color(255, 133, 51));
		lblDoiMK.setFont(new Font("Arial", Font.BOLD, 16));
		btnDoiMK = new JButton("");
		btnDoiMK.setLayout(new BorderLayout());
		btnDoiMK.add(lblImgDoiMatKhau,BorderLayout.WEST);
		btnDoiMK.add(lblDoiMK,BorderLayout.CENTER);
		
		JLabel lblImgHelp = new JLabel(ResizeImagePassword("Icon/question.png"));
		lblHelp = new JLabel("Trợ giúp", SwingConstants.CENTER);
		btnHelp = new JButton("");
		btnHelp.setLayout(new BorderLayout());
		btnHelp.add(lblImgHelp,BorderLayout.WEST);
		btnHelp.add(lblHelp,BorderLayout.CENTER);

		btnChucNang.setBackground(Color.WHITE);
		btnQLKH.setBackground(Color.WHITE);
		btnQLNV.setBackground(Color.WHITE);
		btnQLHoaDon.setBackground(Color.WHITE);
		btnThongKe.setBackground(Color.WHITE);
		btnQLSP.setBackground(Color.WHITE);
		btnTrangChu.setBackground(Color.WHITE);
		btnQLTaiKhoan.setBackground(Color.WHITE);
		btnDangXuat.setBackground(new Color(255, 0, 0));
		btnDoiMK.setBackground(Color.WHITE);
		btnHelp.setBackground(Color.WHITE);

		JPanel pnCN = new JPanel();
		pnCN.setBackground(new Color(255, 255, 255));

		JPanel pnDX = new JPanel();
		pnDX.setLayout(new BoxLayout(pnDX, BoxLayout.Y_AXIS));
		pnDX.add(btnDoiMK);
		pnDX.add(btnDangXuat);
		pnDX.setBackground(new Color(255, 255, 255));
		pnWest.add(pnCN, BorderLayout.CENTER);
		pnWest.add(pnDX,BorderLayout.SOUTH);
		pnWest.setPreferredSize(new Dimension(200,400));
		btnQLKH.setPreferredSize(new Dimension(180,50));
		btnQLNV.setPreferredSize(btnQLKH.getPreferredSize());
		btnThongKe.setPreferredSize(btnQLKH.getPreferredSize());
		btnQLHoaDon.setPreferredSize(btnQLKH.getPreferredSize());
		btnQLSP.setPreferredSize(btnQLKH.getPreferredSize());
		btnTrangChu.setPreferredSize(btnQLKH.getPreferredSize());
		btnQLTaiKhoan.setPreferredSize(btnQLKH.getPreferredSize());
		btnDangXuat.setPreferredSize(btnQLKH.getPreferredSize());
		btnDoiMK.setPreferredSize(btnQLKH.getPreferredSize());
		btnHelp.setPreferredSize(btnQLKH.getPreferredSize());
		add(pnWest,BorderLayout.WEST);

		
		btnQLKH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQLNV.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQLHoaDon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQLSP.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTrangChu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQLTaiKhoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDangXuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDoiMK.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHelp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		


		NhanVien nhanvienTheoMa = nhanVien_dao.layNhanVienTheoMa(maNV);		
		if(nhanvienTheoMa.getChucVu().trim().equals("Chủ Cửa Hàng")) {
			btnChucNang.addActionListener(this);
			btnQLKH.addActionListener(this);
			btnQLHoaDon.addActionListener(this);
			btnQLNV.addActionListener(this);
			btnThongKe.addActionListener(this);
			btnQLSP.addActionListener(this);
			btnTrangChu.addActionListener(this);
			btnQLTaiKhoan.addActionListener(this);
			btnDangXuat.addActionListener(this);
			btnDoiMK.addActionListener(this);
			btnHelp.addActionListener(this);

			btnQLKH.addMouseListener(this);
			btnQLHoaDon.addMouseListener(this);
			btnQLNV.addMouseListener(this);
			btnThongKe.addMouseListener(this);
			btnQLSP.addMouseListener(this);
			btnTrangChu.addMouseListener(this);
			btnQLTaiKhoan.addMouseListener(this);
			btnDoiMK.addMouseListener(this);
			btnHelp.addMouseListener(this);

			pnCN.add(btnTrangChu);
			pnCN.add(btnQLSP);
			pnCN.add(btnQLHoaDon);
			pnCN.add(btnQLKH);
			pnCN.add(btnQLNV);
			pnCN.add(btnThongKe);
			pnCN.add(btnQLTaiKhoan);
			pnCN.add(btnHelp);

		}
		else {
			btnChucNang.addActionListener(this);
			btnQLKH.addActionListener(this);
			btnQLHoaDon.addActionListener(this);		
			btnThongKe.addActionListener(this);
			btnQLSP.addActionListener(this);
			btnTrangChu.addActionListener(this);
			btnDangXuat.addActionListener(this);
			btnDoiMK.addActionListener(this);
			btnHelp.addActionListener(this);

			btnQLKH.addMouseListener(this);
			btnQLHoaDon.addMouseListener(this);
			btnThongKe.addMouseListener(this);
			btnQLSP.addMouseListener(this);
			btnTrangChu.addMouseListener(this);
			btnDoiMK.addMouseListener(this);
			btnHelp.addMouseListener(this);

			btnQLNV.setEnabled(false);
			btnQLTaiKhoan.setEnabled(false);

			pnCN.add(btnTrangChu);
			pnCN.add(btnQLSP);
			pnCN.add(btnQLHoaDon);
			pnCN.add(btnQLKH);
			pnCN.add(btnThongKe);
			pnCN.add(btnHelp);
		}





		lblLogo.addMouseListener(this);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					new FileWriter("luuThongTinSach", false).close();
					new FileWriter("luuThongTinDCHT", false).close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});	
	}

	public static void main(String[] args) throws Exception {
		new ChucNang(maNhanVien).setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		if(object.equals(btnQLKH)) {
			btnQLKH.setBackground(new Color(255, 133, 51));
			lblQLKH.setForeground(Color.WHITE);

			btnThongKe.setBackground(Color.WHITE);
			lblQLTK.setForeground(Color.BLACK);
			btnQLNV.setBackground(Color.WHITE);
			lblQLNV.setForeground(Color.BLACK);
			btnQLHoaDon.setBackground(Color.WHITE);
			lblQLHD.setForeground(Color.BLACK);
			btnQLSP.setBackground(Color.WHITE);
			lblQLSP.setForeground(Color.BLACK);
			btnTrangChu.setBackground(Color.WHITE);
			lblTrangChu.setForeground(Color.BLACK);
			btnQLTaiKhoan.setBackground(Color.WHITE);
			lblQLTaiKhoan.setForeground(Color.BLACK);
			btnHelp.setBackground(Color.WHITE);
			lblHelp.setForeground(Color.BLACK);
			btnDoiMK.setBackground(Color.WHITE);
			lblDoiMK.setForeground(new Color(255, 133, 51));

			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnQLKH,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();		
		}	
		else if(object.equals(btnQLHoaDon)) {
			btnQLHoaDon.setBackground(new Color(255, 133, 51));
			lblQLHD.setForeground(Color.WHITE);

			btnQLKH.setBackground(Color.WHITE);
			lblQLKH.setForeground(Color.BLACK);
			btnThongKe.setBackground(Color.WHITE);
			lblQLTK.setForeground(Color.BLACK);
			btnQLNV.setBackground(Color.WHITE);
			lblQLNV.setForeground(Color.BLACK);
			btnQLSP.setBackground(Color.WHITE);
			lblQLSP.setForeground(Color.BLACK);
			btnTrangChu.setBackground(Color.WHITE);
			lblTrangChu.setForeground(Color.BLACK);
			btnQLTaiKhoan.setBackground(Color.WHITE);
			lblQLTaiKhoan.setForeground(Color.BLACK);
			btnDoiMK.setBackground(Color.WHITE);
			btnHelp.setBackground(Color.WHITE);
			lblHelp.setForeground(Color.BLACK);
			lblDoiMK.setForeground(new Color(255, 133, 51));

			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnQLHoaDon,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}

		else if(object.equals(btnQLNV)) {	
			btnQLNV.setBackground(new Color(255, 133, 51));
			lblQLNV.setForeground(Color.WHITE);

			btnQLHoaDon.setBackground(Color.WHITE);
			lblQLHD.setForeground(Color.BLACK);
			btnThongKe.setBackground(Color.WHITE);
			lblQLTK.setForeground(Color.BLACK);
			btnQLKH.setBackground(Color.WHITE);
			lblQLKH.setForeground(Color.BLACK);
			btnQLSP.setBackground(Color.WHITE);
			lblQLSP.setForeground(Color.BLACK);
			btnTrangChu.setBackground(Color.WHITE);
			lblTrangChu.setForeground(Color.BLACK);
			btnQLTaiKhoan.setBackground(Color.WHITE);
			lblQLTaiKhoan.setForeground(Color.BLACK);
			btnDoiMK.setBackground(Color.WHITE);
			btnHelp.setBackground(Color.WHITE);
			lblHelp.setForeground(Color.BLACK);
			lblDoiMK.setForeground(new Color(255, 133, 51));

			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnQLNV,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
		else if(object.equals(btnChucNang)) {
			if (flag == true) {
				pnWest.setPreferredSize(new Dimension(68,400));
				btnQLKH.remove(lblQLKH);
				btnQLNV.remove(lblQLNV);
				btnThongKe.remove(lblQLTK);
				btnQLHoaDon.remove(lblQLHD);
				btnQLSP.remove(lblQLSP);
				btnDangXuat.remove(lblDangXuat);
				btnTrangChu.remove(lblTrangChu);
				btnQLTaiKhoan.remove(lblQLTaiKhoan);
				btnHelp.remove(lblHelp);
				btnQLKH.setPreferredSize(new Dimension(60,50));
				btnQLHoaDon.setPreferredSize(new Dimension(60,50));
				btnQLNV.setPreferredSize(new Dimension(60,50));
				btnThongKe.setPreferredSize(new Dimension(60,50));
				btnQLSP.setPreferredSize(new Dimension(60,50));
				btnDangXuat.setPreferredSize(new Dimension(60,50));
				btnTrangChu.setPreferredSize(new Dimension(60,50));
				btnQLTaiKhoan.setPreferredSize(new Dimension(60,50));
				btnHelp.setPreferredSize(new Dimension(60,50));
				
				pnWest.revalidate();
				flag = false; 
			}
			else if(flag == false){
				pnWest.setPreferredSize(new Dimension(200,400));
				btnQLKH.add(lblQLKH, BorderLayout.CENTER);
				btnQLNV.add(lblQLNV,BorderLayout.CENTER);
				btnThongKe.add(lblQLTK,BorderLayout.CENTER);
				btnQLHoaDon.add(lblQLHD,BorderLayout.CENTER);
				btnQLSP.add(lblQLSP,BorderLayout.CENTER);
				btnDangXuat.add(lblDangXuat, BorderLayout.CENTER);
				btnTrangChu.add(lblTrangChu,BorderLayout.CENTER);
				btnQLTaiKhoan.add(lblQLTaiKhoan,BorderLayout.CENTER);
				btnHelp.add(lblHelp,BorderLayout.CENTER);
				btnQLKH.setPreferredSize(new Dimension(180,50));
				btnQLHoaDon.setPreferredSize(new Dimension(180,50));
				btnQLNV.setPreferredSize(new Dimension(180,50));
				btnThongKe.setPreferredSize(new Dimension(180,50));
				btnQLSP.setPreferredSize(new Dimension(180,50));
				btnDangXuat.setPreferredSize(new Dimension(180,50));
				btnTrangChu.setPreferredSize(new Dimension(180,50));
				btnQLTaiKhoan.setPreferredSize(new Dimension(180,50));
				btnHelp.setPreferredSize(new Dimension(180,50));
				
				pnWest.revalidate();
				flag = true;
			}
		}
		else if(object.equals(btnThongKe)) {		
			btnThongKe.setBackground(new Color(255, 133, 51));
			lblQLTK.setForeground(Color.WHITE);

			btnQLNV.setBackground(Color.WHITE);
			lblQLNV.setForeground(Color.BLACK);
			btnQLHoaDon.setBackground(Color.WHITE);
			lblQLHD.setForeground(Color.BLACK);
			btnQLKH.setBackground(Color.WHITE);
			lblQLKH.setForeground(Color.BLACK);
			btnQLSP.setBackground(Color.WHITE);
			lblQLSP.setForeground(Color.BLACK);
			btnTrangChu.setBackground(Color.WHITE);
			lblTrangChu.setForeground(Color.BLACK);
			btnQLTaiKhoan.setBackground(Color.WHITE);
			lblQLTaiKhoan.setForeground(Color.BLACK);
			btnHelp.setBackground(Color.WHITE);
			lblHelp.setForeground(Color.BLACK);
			btnDoiMK.setBackground(Color.WHITE);
			lblDoiMK.setForeground(new Color(255, 133, 51));
			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnQLThongKe,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
		else if(object.equals(btnQLSP)) {		
			btnQLSP.setBackground(new Color(255, 133, 51));
			lblQLSP.setForeground(Color.WHITE);

			btnQLNV.setBackground(Color.WHITE);
			lblQLNV.setForeground(Color.BLACK);
			btnQLHoaDon.setBackground(Color.WHITE);
			lblQLHD.setForeground(Color.BLACK);
			btnThongKe.setBackground(Color.WHITE);
			lblQLTK.setForeground(Color.BLACK);
			btnQLKH.setBackground(Color.WHITE);
			lblQLKH.setForeground(Color.BLACK);
			btnTrangChu.setBackground(Color.WHITE);
			lblTrangChu.setForeground(Color.BLACK);
			btnQLTaiKhoan.setBackground(Color.WHITE);
			lblQLTaiKhoan.setForeground(Color.BLACK);
			btnHelp.setBackground(Color.WHITE);
			lblHelp.setForeground(Color.BLACK);
			btnDoiMK.setBackground(Color.WHITE);
			lblDoiMK.setForeground(new Color(255, 133, 51));
			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnQLSP,BorderLayout.CENTER);
			pnCenter.setBackground(new Color(255, 255, 255));
			pnCenter.revalidate();
			pnCenter.repaint();
		}

		else if(object.equals(btnTrangChu)) {
			btnTrangChu.setBackground(new Color(255, 133, 51));
			lblTrangChu.setForeground(Color.WHITE);

			btnQLNV.setBackground(Color.WHITE);
			lblQLNV.setForeground(Color.BLACK);
			btnQLHoaDon.setBackground(Color.WHITE);
			lblQLHD.setForeground(Color.BLACK);
			btnThongKe.setBackground(Color.WHITE);
			lblQLTK.setForeground(Color.BLACK);
			btnQLKH.setBackground(Color.WHITE);
			lblQLKH.setForeground(Color.BLACK);
			btnQLSP.setBackground(Color.WHITE);
			lblQLSP.setForeground(Color.BLACK);
			btnQLTaiKhoan.setBackground(Color.WHITE);
			lblQLTaiKhoan.setForeground(Color.BLACK);
			btnHelp.setBackground(Color.WHITE);
			lblHelp.setForeground(Color.BLACK);
			btnDoiMK.setBackground(Color.WHITE);
			lblDoiMK.setForeground(new Color(255, 133, 51));
			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnTrangChu,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}		

		else if(object.equals(btnDangXuat)) {
			JFrame f= new JFrame();
			int hoi=JOptionPane.showConfirmDialog(f, "Bạn có chắc muốn đăng xuất?","Chú ý",JOptionPane.YES_NO_OPTION);
			if(hoi==JOptionPane.YES_OPTION) {
				DangNhap dn = new DangNhap();
				dn.setVisible(true);
				dispose();

			}
		}
		else if(object.equals(btnHelp)) {
			btnHelp.setBackground(new Color(255, 133, 51));
			lblHelp.setForeground(Color.WHITE);

			btnQLNV.setBackground(Color.WHITE);
			lblQLNV.setForeground(Color.BLACK);
			btnQLHoaDon.setBackground(Color.WHITE);
			lblQLHD.setForeground(Color.BLACK);
			btnThongKe.setBackground(Color.WHITE);
			lblQLTK.setForeground(Color.BLACK);
			btnQLKH.setBackground(Color.WHITE);
			lblQLKH.setForeground(Color.BLACK);
			btnQLSP.setBackground(Color.WHITE);
			lblQLSP.setForeground(Color.BLACK);
			btnQLTaiKhoan.setBackground(Color.WHITE);
			lblQLTaiKhoan.setForeground(Color.BLACK);
			btnDoiMK.setBackground(Color.WHITE);
			lblDoiMK.setForeground(new Color(255, 133, 51));
			
			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnHelp,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
			
		}
		else if(object.equals(btnDoiMK)) {
			btnDoiMK.setBackground(new Color(255, 133, 51));
			lblDoiMK.setForeground(Color.WHITE);
			new FormDoiMatKhau().setVisible(true);
			
			btnQLHoaDon.setBackground(Color.WHITE);
			lblQLHD.setForeground(Color.BLACK);
			btnThongKe.setBackground(Color.WHITE);
			lblQLTK.setForeground(Color.BLACK);
			btnQLKH.setBackground(Color.WHITE);
			lblQLKH.setForeground(Color.BLACK);
			btnQLSP.setBackground(Color.WHITE);
			lblQLSP.setForeground(Color.BLACK);
			btnTrangChu.setBackground(Color.WHITE);
			lblTrangChu.setForeground(Color.BLACK);
			btnQLNV.setBackground(Color.WHITE);
			lblQLNV.setForeground(Color.BLACK);
			btnHelp.setBackground(Color.WHITE);
			lblHelp.setForeground(Color.BLACK);
			btnQLTaiKhoan.setBackground(Color.WHITE);
			lblQLTaiKhoan.setForeground(Color.BLACK);
			
		}
		else if(object.equals(btnQLTaiKhoan)) {	
			btnQLTaiKhoan.setBackground(new Color(255, 133, 51));
			lblQLTaiKhoan.setForeground(Color.WHITE);

			btnQLHoaDon.setBackground(Color.WHITE);
			lblQLHD.setForeground(Color.BLACK);
			btnThongKe.setBackground(Color.WHITE);
			lblQLTK.setForeground(Color.BLACK);
			btnQLKH.setBackground(Color.WHITE);
			lblQLKH.setForeground(Color.BLACK);
			btnQLSP.setBackground(Color.WHITE);
			lblQLSP.setForeground(Color.BLACK);
			btnTrangChu.setBackground(Color.WHITE);
			lblTrangChu.setForeground(Color.BLACK);
			btnQLNV.setBackground(Color.WHITE);
			lblQLNV.setForeground(Color.BLACK);
			btnHelp.setBackground(Color.WHITE);
			lblHelp.setForeground(Color.BLACK);
			btnDoiMK.setBackground(Color.WHITE);
			lblDoiMK.setForeground(new Color(255, 133, 51));

			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnQLTaiKhoan,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj.equals(lblLogo)) {
			btnTrangChu.setBackground(Color.CYAN);
			btnQLNV.setBackground(Color.WHITE);
			btnQLHoaDon.setBackground(Color.WHITE);
			btnThongKe.setBackground(Color.WHITE);
			btnQLKH.setBackground(Color.WHITE);
			btnQLSP.setBackground(Color.WHITE);
			btnQLTaiKhoan.setBackground(Color.WHITE);

			pnCenter.removeAll();
			pnCenter.revalidate();
			pnCenter.add(pnTrangChu,BorderLayout.CENTER);
			pnCenter.revalidate();
			pnCenter.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(flag==true)
		{
			if(obj.equals(btnQLKH)) {
				btnQLKH.setPreferredSize(new Dimension(200,70));
				btnQLKH.revalidate();
			}
			else if(obj.equals(btnQLHoaDon)) {
				btnQLHoaDon.setPreferredSize(new Dimension(200,70));
				btnQLHoaDon.revalidate();
			}
			else if(obj.equals(btnThongKe)) {
				btnThongKe.setPreferredSize(new Dimension(200,70));
				btnThongKe.revalidate();
			}
			else if(obj.equals(btnQLNV)) {
				btnQLNV.setPreferredSize(new Dimension(200,70));
				btnQLNV.revalidate();
			}
			else if(obj.equals(btnQLSP)) {
				btnQLSP.setPreferredSize(new Dimension(200,70));
				btnQLSP.revalidate();
			}
			else if(obj.equals(btnTrangChu)) {
				btnTrangChu.setPreferredSize(new Dimension(200,70));
				btnTrangChu.revalidate();
			}
			else if(obj.equals(btnQLTaiKhoan)) {
				btnQLTaiKhoan.setPreferredSize(new Dimension(200,70));
				btnQLTaiKhoan.revalidate();
			}
			else if(obj.equals(btnHelp)) {
				btnHelp.setPreferredSize(new Dimension(200,70));
				btnHelp.revalidate();
			}
//			else if(obj.equals(btnDoiMK)) {
//				btnDoiMK.setBackground(new Color(255, 133, 51));
//				lblDoiMK.setForeground(Color.WHITE);
//			}
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(flag==true) {
			if(obj.equals(btnQLKH)) {
				btnQLKH.setPreferredSize(new Dimension(180,50));
				btnQLKH.revalidate();
			}
			else if(obj.equals(btnQLHoaDon)) {
				btnQLHoaDon.setPreferredSize(new Dimension(180,50));
				btnQLHoaDon.revalidate();
			}
			else if(obj.equals(btnThongKe)) {
				btnThongKe.setPreferredSize(new Dimension(180,50));
				btnThongKe.revalidate();
			}
			else if(obj.equals(btnQLNV)) {
				btnQLNV.setPreferredSize(new Dimension(180,50));
				btnQLNV.revalidate();
			}
			else if(obj.equals(btnQLSP)) {
				btnQLSP.setPreferredSize(new Dimension(180,50));
				btnQLSP.revalidate();
			}
			else if(obj.equals(btnTrangChu)) {
				btnTrangChu.setPreferredSize(new Dimension(180,50));
				btnTrangChu.revalidate();
			}
			else if(obj.equals(btnQLTaiKhoan)) {
				btnQLTaiKhoan.setPreferredSize(new Dimension(180,50));
				btnQLTaiKhoan.revalidate();
			}
			else if(obj.equals(btnHelp)) {
				btnHelp.setPreferredSize(new Dimension(180,50));
				btnHelp.revalidate();
			}
//			else if(obj.equals(btnDoiMK)) {
//				btnDoiMK.setBackground(new Color(255, 255, 255));
//				lblDoiMK.setForeground(new Color(255, 133, 51));
//			}
		}
	}
	public ImageIcon ResizeImage(String ImagePath)
	{
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(100, 80, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
	public ImageIcon ResizeImagePassword(String ImagePath)
	{
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
}
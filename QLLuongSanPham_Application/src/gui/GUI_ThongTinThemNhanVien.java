package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import connectDB.ConnectDB;
import dao.DAO_NhanVienHanhChinh;
import entity.NhanVienHanhChinh;

public class GUI_ThongTinThemNhanVien extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txthoTen;
	private JTextField txtSDT;
	private JTextField txtMACN;
	private JDatePickerImpl datePickerImplNgaysinh;
	private JTextField txtDiaChi;
	private JTextField txthsLuong;
	private JTextField txtDonViCT;
	private JTextField txtChucVu;
	private JDatePickerImpl datePickerImplNgayBatDau;
	private JButton btnThoat;
	private JButton btnThem;
	private JCheckBox checkGT;
	private DAO_NhanVienHanhChinh nv_Dao;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ThongTinThemNhanVien frame = new GUI_ThongTinThemNhanVien();
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
	public GUI_ThongTinThemNhanVien() {
		setBounds(100, 100, 1000, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Thông Tin Thêm Nhân Viên");
		setResizable(false);
		
		try{
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		nv_Dao = new DAO_NhanVienHanhChinh();
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(10, 10, 966, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblThngTinKhch = new JLabel("Thông Thêm Nhân Viên");
		lblThngTinKhch.setBounds(280, 10, 512, 53);
		panel.add(lblThngTinKhch);
		lblThngTinKhch.setFont(new Font("Serif", Font.ITALIC, 50));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(10, 96, 966, 559);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1.setBackground(SystemColor.activeCaption);
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 0, 966, 464);
		panel_1.add(panel_1_1);
		
		txtMACN = new JTextField();
		txtMACN.setForeground(Color.BLACK);
		txtMACN.setColumns(10);
		txtMACN.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtMACN.setBounds(312, 10, 487, 36);
		panel_1_1.add(txtMACN);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mã Khách Hàng:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_3.setBounds(123, 10, 194, 36);
		panel_1_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Họ Tên:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1_1.setBounds(201, 56, 89, 36);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		SqlDateModel model1 = new SqlDateModel();
		Properties p =  new Properties();
		p.put("text.date", "date");
		p.put("text.month", "month");
		p.put("text.year", "year");
		JDatePanelImpl impl1 = new JDatePanelImpl(model1, p);
		datePickerImplNgaysinh= new JDatePickerImpl(impl1, new AbstractFormatter() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public String valueToString(Object value) throws ParseException {
				if(value != null) {
					Calendar cal = (Calendar) value;
					SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
					String strDate = format.format(cal.getTime());
					return strDate;
				}
				return "";
			}
			@Override
			public Object stringToValue(String text) throws ParseException {
				// TODO Auto-generated method stub
				return null;
			}
		});
		datePickerImplNgaysinh.setBounds(312, 194, 250, 36);
		panel_1_1.add(datePickerImplNgaysinh);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setForeground(Color.BLACK);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtDiaChi.setBounds(312, 240, 487, 36);
		panel_1_1.add(txtDiaChi);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("Địa Chỉ:");
		lblNewLabel_1_5_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_5_2.setBounds(211, 240, 79, 36);
		panel_1_1.add(lblNewLabel_1_5_2);
		
		SqlDateModel model2 = new SqlDateModel();
		JDatePanelImpl impl2 = new JDatePanelImpl(model2, p);
		datePickerImplNgayBatDau = new JDatePickerImpl(impl2, new AbstractFormatter() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public String valueToString(Object value) throws ParseException {
				if(value != null) {
					Calendar cal = (Calendar) value;
					SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
					String strDate = format.format(cal.getTime());
					return strDate;
				}
				return "";
			}
			@Override
			public Object stringToValue(String text) throws ParseException {
				// TODO Auto-generated method stub
				return null;
			}
		});
		datePickerImplNgayBatDau.setBounds(312, 286, 250, 36);
		panel_1_1.add(datePickerImplNgayBatDau);
		
		JLabel lblNewLabel_1_5_3 = new JLabel("Ngày Bắt Đầu:");
		lblNewLabel_1_5_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_5_3.setBounds(146, 286, 155, 36);
		panel_1_1.add(lblNewLabel_1_5_3);
		
		txthsLuong = new JTextField();
		txthsLuong.setForeground(Color.BLACK);
		txthsLuong.setColumns(10);
		txthsLuong.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txthsLuong.setBounds(312, 332, 487, 36);
		panel_1_1.add(txthsLuong);
		
		JLabel lblNewLabel_1_5_4 = new JLabel("Hệ Số Lương:");
		lblNewLabel_1_5_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_5_4.setBounds(146, 332, 155, 36);
		panel_1_1.add(lblNewLabel_1_5_4);
		
		txtDonViCT = new JTextField();
		txtDonViCT.setForeground(Color.BLACK);
		txtDonViCT.setColumns(10);
		txtDonViCT.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtDonViCT.setBounds(312, 378, 487, 36);
		panel_1_1.add(txtDonViCT);
		
		JLabel lblNewLabel_1_5_5 = new JLabel("Đơn Vị Công Tác:");
		lblNewLabel_1_5_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_5_5.setBounds(105, 378, 178, 36);
		panel_1_1.add(lblNewLabel_1_5_5);
		
		txtChucVu = new JTextField();
		txtChucVu.setForeground(Color.BLACK);
		txtChucVu.setColumns(10);
		txtChucVu.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtChucVu.setBounds(312, 424, 487, 36);
		panel_1_1.add(txtChucVu);
		
		JLabel lblNewLabel_1_5_6 = new JLabel("Chức Vụ:");
		lblNewLabel_1_5_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_5_6.setBounds(194, 424, 93, 36);
		panel_1_1.add(lblNewLabel_1_5_6);
		
		txthoTen = new JTextField();
		txthoTen.setBounds(312, 56, 487, 36);
		panel_1_1.add(txthoTen);
		txthoTen.setInheritsPopupMenu(true);
		txthoTen.setIgnoreRepaint(true);
		txthoTen.setForeground(Color.DARK_GRAY);
		txthoTen.setColumns(10);
		txthoTen.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		
		JLabel lblNewLabel_1_2 = new JLabel("Giới Tính:");
		lblNewLabel_1_2.setBounds(194, 102, 112, 36);
		panel_1_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		checkGT = new JCheckBox("Nam");
		checkGT.setBounds(312, 110, 93, 28);
		panel_1_1.add(checkGT);
		checkGT.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_5 = new JLabel("Số Điện Thoại:");
		lblNewLabel_1_5.setBounds(146, 148, 155, 36);
		panel_1_1.add(lblNewLabel_1_5);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		txtSDT = new JTextField();
		txtSDT.setBounds(312, 148, 487, 36);
		panel_1_1.add(txtSDT);
		txtSDT.setForeground(Color.BLACK);
		txtSDT.setColumns(10);
		txtSDT.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		
		JLabel lbNgaySinh = new JLabel("Ngày Sinh:");
		lbNgaySinh.setBounds(183, 194, 112, 36);
		panel_1_1.add(lbNgaySinh);
		lbNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setBounds(0, 469, 966, 80);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("data\\img\\icons8-add-24.png"));
		btnThem.setBounds(439, 10, 162, 35);
		panel_2.add(btnThem);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("data\\img\\icons8-exit-24.png"));
		btnThoat.setBounds(774, 35, 172, 35);
		panel_2.add(btnThoat);
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDonViCT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txthoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txthsLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMACN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnThem.addActionListener(this);
		btnThoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
				if(kiemtra()) {
					String makh = txtMACN.getText();
					String tenkh = txthoTen.getText();
					String phai = checkGT.isSelected()?"Nam":"Nữ";
					String sdt = txtSDT.getText();
					java.sql.Date ngaysinh = (java.sql.Date) datePickerImplNgaysinh.getModel().getValue();
					String diaChi = txtDiaChi.getText();
					java.sql.Date ngaybatdau = (java.sql.Date) datePickerImplNgayBatDau.getModel().getValue();
					double hesoluong = Double.parseDouble(txthsLuong.getText());
					String donviCongtac = txtDonViCT.getText();
					String chucVu = txtChucVu.getText();
					NhanVienHanhChinh nv = new NhanVienHanhChinh(makh,tenkh,phai,sdt,ngaysinh,diaChi,ngaybatdau,hesoluong,donviCongtac,chucVu);
					
					if(!nv_Dao.getAllNhanVienHanhChinh().contains(nv)) {
							try {
								nv_Dao.create(nv);
								JOptionPane.showMessageDialog(this, "Thêm thành Công!");
							} catch (Exception e2) {
								e2.printStackTrace();
							}	
					}else {
						JOptionPane.showMessageDialog(this, "TRÙNG");
					}	
				}
		}
		if(o.equals(btnThoat)) {
			this.setVisible(false);
		}
	}
	
	
	private boolean kiemtra() {
		String ma = txtMACN.getText().trim();
		String hoten = txthoTen.getText().trim();
		String sdt =  txtSDT.getText().trim();
		String diachi =  txtDiaChi.getText().trim();
		String hsluong = txthsLuong.getText().trim();
		String donVicongtac=  txtDonViCT.getText().trim();
		String chucvu = txtChucVu.getText().trim();
		Date ngaysinh = (Date) datePickerImplNgaysinh.getModel().getValue();
		Date ngaybatdau = (Date) datePickerImplNgayBatDau.getModel().getValue();
		
		if(!(ma.length() > 0 && ma.matches("[A-Z0-9]{3,8}$"))) {
			JOptionPane.showMessageDialog(this, "Chú ý: Nhập mã sai cú pháp! (mã phải nhập chữ in hoa không dấu và số độ dài 3-8)");
			return false;
		}
		if (!(hoten.length() > 0 && hoten.matches("[A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\\\.'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this,"Chú ý: Nhập tên sai cú pháp! (Phải nhập kí tự không có dấu)");
			return false;
		}
		if (!(sdt.length() > 0 && sdt.matches("[0-9]{10}$"))) {
			JOptionPane.showMessageDialog(this,"Chú ý: Nhập số điện thoại sai cú pháp!Là số và 10 kí tự!)");
			return false;
		}
		if (!(diachi.length() > 0 && diachi.matches("[/A-Za-z0-9*a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\\\.'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this,"Chú ý: Nhập địa chỉ sai cú pháp! (không được nhập kĩ tự đặc biệt!)");
			return false;
		}
		if (!(hsluong.length() > 0 && hsluong.matches("[0-9]{3,10}$"))) {
			JOptionPane.showMessageDialog(this,"Chú ý: Nhập lương sai!(Phải nhập số và dưới 10 kí tự)");
			return false;
		}
		if (!(donVicongtac.length() > 0 && donVicongtac.matches("[A-Za-z0-9*a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\\\.'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this,"Chú ý: Nhập Đơn vị công tác sai! (Không nhập kí tự đặc biệt!)");
			return false;
		}
		if (!(chucvu.length() > 0 && chucvu.matches("[A-Za-z0-9*a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\\\.'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this,"Chú ý: Nhập chức vụ sai! (Không nhập kí tự đặc biệt!)");
			return false;
		}
		if (!(ngaysinh.before(ngaybatdau))) {
			JOptionPane.showMessageDialog(this, "Chú ý: Ngày hết làm việc phải sau ngày sinh!");
			return false;
		}
		
		return true;
	}
}

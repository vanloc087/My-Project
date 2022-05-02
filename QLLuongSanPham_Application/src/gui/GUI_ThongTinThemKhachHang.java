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
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import connectDB.ConnectDB;
import dao.DAO_KhachHang;
import entity.KhachHang;

public class GUI_ThongTinThemKhachHang extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JButton btnThoat;
	private JButton btnThem;
	private DAO_KhachHang kh_dao;
	private JDatePickerImpl datePickerImpl;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField txtMaKH;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtTenKH;
	private JCheckBox CheckGioiTinh;
	private JLabel lblNewLabel_1_1;
	private JPanel panel_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ThongTinThemKhachHang frame = new GUI_ThongTinThemKhachHang();
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
	public GUI_ThongTinThemKhachHang() {
		setBounds(100, 100, 1000, 692);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setTitle("Thông Tin Khách Hàng");
		
		try{
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		kh_dao = new DAO_KhachHang();
		
		SqlDateModel model = new SqlDateModel();
		Properties p =  new Properties();
		p.put("text.date", "date");
		p.put("text.month", "month");
		p.put("text.year", "year");
		JDatePanelImpl impl = new JDatePanelImpl(model, p);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setForeground(SystemColor.activeCaptionBorder);
		panel.setBounds(10, 10, 966, 89);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblThngTinKhch = new JLabel("Thông Tin Khách Hàng");
		lblThngTinKhch.setBounds(215, 0, 512, 82);
		panel.add(lblThngTinKhch);
		lblThngTinKhch.setFont(new Font("Serif", Font.ITALIC, 50));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(10, 102, 966, 453);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtMaKH = new JTextField();
		txtMaKH.setForeground(Color.BLACK);
		txtMaKH.setColumns(10);
		txtMaKH.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtMaKH.setBounds(306, 30, 487, 48);
		panel_1.add(txtMaKH);
		
		lblNewLabel = new JLabel("Mã Khách Hàng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(115, 42, 194, 36);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Họ Tên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(196, 116, 89, 36);
		panel_1.add(lblNewLabel_1);
		
		txtTenKH = new JTextField();
		txtTenKH.setInheritsPopupMenu(true);
		txtTenKH.setIgnoreRepaint(true);
		txtTenKH.setForeground(Color.DARK_GRAY);
		txtTenKH.setColumns(10);
		txtTenKH.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtTenKH.setBounds(306, 106, 487, 48);
		panel_1.add(txtTenKH);
		
		CheckGioiTinh = new JCheckBox("Nam");
		CheckGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 22));
		CheckGioiTinh.setBounds(306, 185, 93, 21);
		panel_1.add(CheckGioiTinh);
		
		lblNewLabel_1_1 = new JLabel("Giới Tính:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(185, 177, 112, 36);
		panel_1.add(lblNewLabel_1_1);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(306, 225, 487, 48);
		panel_1.add(txtSDT);
		txtSDT.setForeground(SystemColor.activeCaptionText);
		txtSDT.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtSDT.setColumns(10);
		
		JLabel lblNewLabel_1_5 = new JLabel("Số Điện Thoại:");
		lblNewLabel_1_5.setBounds(130, 237, 155, 36);
		panel_1.add(lblNewLabel_1_5);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		datePickerImpl = new JDatePickerImpl(impl, new AbstractFormatter() {
			
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
		datePickerImpl.setBounds(306, 299, 200, 40);
		panel_1.add(datePickerImpl);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(306, 364, 487, 48);
		panel_1.add(txtDiaChi);
		txtDiaChi.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtDiaChi.setColumns(10);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày Sinh:");
		lblNewLabel_1_4.setBounds(173, 303, 112, 36);
		panel_1.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_3 = new JLabel("Địa chỉ:");
		lblNewLabel_1_3.setBounds(185, 364, 89, 36);
		panel_1.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setBounds(10, 556, 966, 89);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("data\\img\\icons8-add-24.png"));
		btnThem.setBorder(UIManager.getBorder("OptionPane.buttonAreaBorder"));
		btnThem.setBounds(407, 10, 182, 44);
		panel_2.add(btnThem);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("data\\img\\icons8-exit-24.png"));
		btnThoat.setBorder(UIManager.getBorder("OptionPane.buttonAreaBorder"));
		btnThoat.setBounds(761, 32, 182, 44);
		panel_2.add(btnThoat);
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnThoat.addActionListener(this);
		btnThem.addActionListener(this);
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
				if(kiemtra()) {
					String makh = txtMaKH.getText();
					String tenkh = txtTenKH.getText();
					String phai = CheckGioiTinh.isSelected()?"Nam":"Nữ";
					String sdt = txtSDT.getText();
					java.sql.Date ngaysinh = (java.sql.Date) datePickerImpl.getModel().getValue();
					String diaChi = txtDiaChi.getText();
					KhachHang kh = new KhachHang(makh,tenkh,phai,sdt,ngaysinh,diaChi);
					
					if(!kh_dao.getAllKhachHang().contains(kh)) {
							try {
								kh_dao.create(kh);
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
		String ma = txtMaKH.getText().trim();
		String hoten = txtTenKH.getText().trim();
		String sdt =  txtSDT.getText().trim();
		String diachi =  txtDiaChi.getText().trim();
		Date ngaySinh = (Date) datePickerImpl.getModel().getValue();
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
		if(!(ngaySinh!=null)) {
			JOptionPane.showMessageDialog(this, "Chú ý: Ngày Sinh không được rỗng!");
			return false;
		}
		if (!(diachi.length() > 0 && diachi.matches("[/A-Za-z0-9*a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\\\.'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this,"Chú ý: Nhập địa chỉ sai cú pháp! (không được nhập kĩ tự đặc biệt!)");
			return false;
		}
		
		return true;
	}
	
}
	

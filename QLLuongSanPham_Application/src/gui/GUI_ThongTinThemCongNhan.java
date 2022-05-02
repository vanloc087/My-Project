package gui;

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
import dao.DAO_CongNhan;
import entity.CongNhan;

public class GUI_ThongTinThemCongNhan extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtmaCN;
	private JTextField txtTenCN;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JButton btnThem;
	private JButton btnThoat;
	private JDatePickerImpl datePickerImpl;
	private JCheckBox CheckGioiTinh;
	private DAO_CongNhan cn_dao;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ThongTinThemCongNhan frame = new GUI_ThongTinThemCongNhan();
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
	public GUI_ThongTinThemCongNhan() {
		setBounds(100, 100, 1000, 692);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setTitle("Thông Tin Thêm Công Nhân");
		
		try{
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		cn_dao = new DAO_CongNhan();
		contentPane.setLayout(null);
		
		SqlDateModel model = new SqlDateModel();
		Properties p =  new Properties();
		p.put("text.date", "date");
		p.put("text.month", "month");
		p.put("text.year", "year");
		JDatePanelImpl impl = new JDatePanelImpl(model, p);
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
		datePickerImpl.setBounds(295, 408, 254, 38);
		contentPane.add(datePickerImpl);
			
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(295, 479, 510, 48);
		txtDiaChi.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.inactiveCaptionText, SystemColor.windowText, SystemColor.windowText, SystemColor.windowText));
		txtDiaChi.setColumns(10);
		contentPane.add(txtDiaChi);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(10, 10, 966, 94);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông Tin Công Nhân");
		lblNewLabel.setBounds(247, 10, 549, 82);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Serif", Font.ITALIC, 50));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(10, 114, 966, 431);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtmaCN = new JTextField();
		txtmaCN.setBounds(275, 10, 510, 48);
		panel_1.add(txtmaCN);
		txtmaCN.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.inactiveCaptionText, SystemColor.windowText, SystemColor.windowText, SystemColor.windowText));
		txtmaCN.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ Tên:");
		lblNewLabel_1_1.setBounds(176, 95, 89, 36);
		panel_1.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		txtTenCN = new JTextField();
		txtTenCN.setBounds(275, 84, 510, 48);
		panel_1.add(txtTenCN);
		txtTenCN.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.inactiveCaptionText, SystemColor.windowText, SystemColor.windowText, SystemColor.windowText));
		txtTenCN.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Công Nhân:");
		lblNewLabel_1.setBounds(108, 12, 194, 36);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		CheckGioiTinh = new JCheckBox("Nam");
		CheckGioiTinh.setBounds(275, 143, 266, 42);
		panel_1.add(CheckGioiTinh);
		CheckGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_2 = new JLabel("Giới Tính:");
		lblNewLabel_1_2.setBounds(157, 146, 112, 36);
		panel_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		txtSDT = new JTextField();
		txtSDT.setBounds(275, 202, 510, 48);
		panel_1.add(txtSDT);
		txtSDT.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.inactiveCaptionText, SystemColor.windowText, SystemColor.windowText, SystemColor.windowText));
		txtSDT.setColumns(10);
		
		JLabel lblNewLabel_1_5 = new JLabel("Số Điện Thoại:");
		lblNewLabel_1_5.setBounds(110, 214, 155, 36);
		panel_1.add(lblNewLabel_1_5);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày Sinh:");
		lblNewLabel_1_4.setBounds(153, 296, 112, 36);
		panel_1.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_3 = new JLabel("Địa chỉ:");
		lblNewLabel_1_3.setBounds(176, 365, 89, 36);
		panel_1.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setBounds(10, 551, 966, 94);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(428, 10, 182, 42);
		panel_2.add(btnThem);
		btnThem.setIcon(new ImageIcon("data\\img\\icons8-add-24.png"));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(774, 42, 182, 42);
		panel_2.add(btnThoat);
		btnThoat.setIcon(new ImageIcon("data\\img\\icons8-exit-24.png"));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtmaCN.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtTenCN.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnThoat.addActionListener(this);
	
		btnThem.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
				if(kiemtra()) {
					String macn = txtmaCN.getText();
					String tencn = txtTenCN.getText();
					String phai = CheckGioiTinh.isSelected()?"Nam":"Nữ";
					String sdt = txtSDT.getText();
					java.sql.Date ngaysinh = (java.sql.Date) datePickerImpl.getModel().getValue();
					String diaChi = txtDiaChi.getText();
					CongNhan cn = new CongNhan(macn,tencn,phai,sdt,ngaysinh,diaChi);
					if(!cn_dao.getAllCongNhan().contains(cn)) {
						try {
							cn_dao.create(cn);
							JOptionPane.showMessageDialog(this, "Thêm thành Công!");
						} catch (Exception e2) {
							e2.printStackTrace();
						}	
				}else {
					JOptionPane.showMessageDialog(this, "Trùng Mã Công Nhân!");
				}
				}
							
		}
		if(o.equals(btnThoat)) {
			this.setVisible(false);
		}	
	}
	private boolean kiemtra() {
		String ma = txtmaCN.getText().trim();
		String hoten = txtTenCN.getText().trim();
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

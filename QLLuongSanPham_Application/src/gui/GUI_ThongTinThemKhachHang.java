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
		setTitle("Th??ng Tin Kh??ch H??ng");
		
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
		
		JLabel lblThngTinKhch = new JLabel("Th??ng Tin Kh??ch H??ng");
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
		
		lblNewLabel = new JLabel("M?? Kh??ch H??ng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(115, 42, 194, 36);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("H??? T??n:");
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
		
		lblNewLabel_1_1 = new JLabel("Gi???i T??nh:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(185, 177, 112, 36);
		panel_1.add(lblNewLabel_1_1);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(306, 225, 487, 48);
		panel_1.add(txtSDT);
		txtSDT.setForeground(SystemColor.activeCaptionText);
		txtSDT.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		txtSDT.setColumns(10);
		
		JLabel lblNewLabel_1_5 = new JLabel("S??? ??i???n Tho???i:");
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
		
		JLabel lblNewLabel_1_4 = new JLabel("Ng??y Sinh:");
		lblNewLabel_1_4.setBounds(173, 303, 112, 36);
		panel_1.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_3 = new JLabel("?????a ch???:");
		lblNewLabel_1_3.setBounds(185, 364, 89, 36);
		panel_1.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setBounds(10, 556, 966, 89);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btnThem = new JButton("Th??m");
		btnThem.setIcon(new ImageIcon("data\\img\\icons8-add-24.png"));
		btnThem.setBorder(UIManager.getBorder("OptionPane.buttonAreaBorder"));
		btnThem.setBounds(407, 10, 182, 44);
		panel_2.add(btnThem);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		btnThoat = new JButton("Tho??t");
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
					String phai = CheckGioiTinh.isSelected()?"Nam":"N???";
					String sdt = txtSDT.getText();
					java.sql.Date ngaysinh = (java.sql.Date) datePickerImpl.getModel().getValue();
					String diaChi = txtDiaChi.getText();
					KhachHang kh = new KhachHang(makh,tenkh,phai,sdt,ngaysinh,diaChi);
					
					if(!kh_dao.getAllKhachHang().contains(kh)) {
							try {
								kh_dao.create(kh);
								JOptionPane.showMessageDialog(this, "Th??m th??nh C??ng!");
							} catch (Exception e2) {
								e2.printStackTrace();
							}	
					}else {
						JOptionPane.showMessageDialog(this, "TR??NG");
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
			JOptionPane.showMessageDialog(this, "Ch?? ??: Nh???p m?? sai c?? ph??p! (m?? ph???i nh???p ch??? in hoa kh??ng d???u v?? s??? ????? d??i 3-8)");
			return false;
		}
		if (!(hoten.length() > 0 && hoten.matches("[A-Za-za-zA-Z??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????\\s\\\\.'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p t??n sai c?? ph??p! (Ph???i nh???p k?? t??? kh??ng c?? d???u)");
			return false;
		}
		if (!(sdt.length() > 0 && sdt.matches("[0-9]{10}$"))) {
			JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p s??? ??i???n tho???i sai c?? ph??p!L?? s??? v?? 10 k?? t???!)");
			return false;
		}
		if(!(ngaySinh!=null)) {
			JOptionPane.showMessageDialog(this, "Ch?? ??: Ng??y Sinh kh??ng ???????c r???ng!");
			return false;
		}
		if (!(diachi.length() > 0 && diachi.matches("[/A-Za-z0-9*a-zA-Z??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????\\s\\\\.'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this,"Ch?? ??: Nh???p ?????a ch??? sai c?? ph??p! (kh??ng ???????c nh???p k?? t??? ?????c bi???t!)");
			return false;
		}
		
		return true;
	}
	
}
	

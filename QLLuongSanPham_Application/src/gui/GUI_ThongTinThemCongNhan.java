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
		setTitle("Th??ng Tin Th??m C??ng Nh??n");
		
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
		
		JLabel lblNewLabel = new JLabel("Th??ng Tin C??ng Nh??n");
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
		
		JLabel lblNewLabel_1_1 = new JLabel("H??? T??n:");
		lblNewLabel_1_1.setBounds(176, 95, 89, 36);
		panel_1.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		txtTenCN = new JTextField();
		txtTenCN.setBounds(275, 84, 510, 48);
		panel_1.add(txtTenCN);
		txtTenCN.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.inactiveCaptionText, SystemColor.windowText, SystemColor.windowText, SystemColor.windowText));
		txtTenCN.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("M?? C??ng Nh??n:");
		lblNewLabel_1.setBounds(108, 12, 194, 36);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		CheckGioiTinh = new JCheckBox("Nam");
		CheckGioiTinh.setBounds(275, 143, 266, 42);
		panel_1.add(CheckGioiTinh);
		CheckGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_2 = new JLabel("Gi???i T??nh:");
		lblNewLabel_1_2.setBounds(157, 146, 112, 36);
		panel_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		txtSDT = new JTextField();
		txtSDT.setBounds(275, 202, 510, 48);
		panel_1.add(txtSDT);
		txtSDT.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.inactiveCaptionText, SystemColor.windowText, SystemColor.windowText, SystemColor.windowText));
		txtSDT.setColumns(10);
		
		JLabel lblNewLabel_1_5 = new JLabel("S??? ??i???n Tho???i:");
		lblNewLabel_1_5.setBounds(110, 214, 155, 36);
		panel_1.add(lblNewLabel_1_5);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_4 = new JLabel("Ng??y Sinh:");
		lblNewLabel_1_4.setBounds(153, 296, 112, 36);
		panel_1.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1_3 = new JLabel("?????a ch???:");
		lblNewLabel_1_3.setBounds(176, 365, 89, 36);
		panel_1.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setBounds(10, 551, 966, 94);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btnThem = new JButton("Th??m");
		btnThem.setBounds(428, 10, 182, 42);
		panel_2.add(btnThem);
		btnThem.setIcon(new ImageIcon("data\\img\\icons8-add-24.png"));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		btnThoat = new JButton("Tho??t");
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
					String phai = CheckGioiTinh.isSelected()?"Nam":"N???";
					String sdt = txtSDT.getText();
					java.sql.Date ngaysinh = (java.sql.Date) datePickerImpl.getModel().getValue();
					String diaChi = txtDiaChi.getText();
					CongNhan cn = new CongNhan(macn,tencn,phai,sdt,ngaysinh,diaChi);
					if(!cn_dao.getAllCongNhan().contains(cn)) {
						try {
							cn_dao.create(cn);
							JOptionPane.showMessageDialog(this, "Th??m th??nh C??ng!");
						} catch (Exception e2) {
							e2.printStackTrace();
						}	
				}else {
					JOptionPane.showMessageDialog(this, "Tr??ng M?? C??ng Nh??n!");
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

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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import connectDB.ConnectDB;
import dao.DAO_KhachHang;
import entity.KhachHang;

public class GUI_QuanLyKhachHang extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnXoaRong;
	private DAO_KhachHang kh_dao;
	private JTable table;
	private DefaultTableModel model;
	private JCheckBox checkGioiTinh;
	private JDatePickerImpl datePickerImpl;
	private JTextField txtTim;
	private JButton btnTim;
	private JComboBox<String> comboBoxloc;
	private JButton btnLoc;
	private JButton btnTaiLai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLyKhachHang frame = new GUI_QuanLyKhachHang();
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
	public GUI_QuanLyKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 680);
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
		
		kh_dao = new DAO_KhachHang();
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(null);
		panel.setLayout(null);
		panel.setBounds(0, 10, 1346, 653);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 110, 1326, 322);
		panel.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 22));
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(10, 49, 1298, 261);
		panel_1.add(scrollPane);
		
		String[] cols= {"Mã khách hàng","Họ Tên","Giới tính","Số Điện Thoại","Ngày Sinh","Địa Chỉ"};
		model= new DefaultTableModel(cols,0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(1);
		table.getColumnModel().getColumn(2).setPreferredWidth(1);
		table.getColumnModel().getColumn(3).setPreferredWidth(1);
		table.getColumnModel().getColumn(4).setPreferredWidth(1);
		scrollPane.setViewportView(table);
		
		comboBoxloc = new JComboBox<String>();
		comboBoxloc.setModel(new DefaultComboBoxModel<String>(new String[] {"Chọn Giới Tính", "Nam ", "Nữ"}));
		comboBoxloc.setFont(new Font("Tahoma", Font.PLAIN, 22));
		comboBoxloc.setBounds(576, 9, 230, 31);
		panel_1.add(comboBoxloc);
		
		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTim.setColumns(10);
		txtTim.setBounds(10, 9, 389, 31);
		panel_1.add(txtTim);
		
		btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Serif", Font.PLAIN, 25));
		btnTim.setBounds(420, 9, 127, 32);
		panel_1.add(btnTim);
		
		btnLoc = new JButton("Lọc");
		btnLoc.setFont(new Font("Serif", Font.PLAIN, 25));
		btnLoc.setBounds(828, 8, 143, 31);
		panel_1.add(btnLoc);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng Tin Chi Ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 442, 1326, 109);
		panel.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Khách Hàng: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(31, 11, 172, 33);
		panel_2.add(lblNewLabel_1);
		
		txtMaKH = new JTextField();
		txtMaKH.setBorder(new LineBorder(SystemColor.activeCaptionText));
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(209, 10, 225, 31);
		panel_2.add(txtMaKH);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ Tên:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(108, 54, 95, 33);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giới Tính:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_2.setBounds(543, 9, 113, 33);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ngày Sinh:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(925, 10, 109, 33);
		panel_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Địa Chỉ:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(955, 66, 79, 33);
		panel_2.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Số Điện Thoại:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(501, 66, 155, 33);
		panel_2.add(lblNewLabel_1_5);
		
		txtTenKH = new JTextField();
		txtTenKH.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(209, 54, 225, 31);
		panel_2.add(txtTenKH);
		
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
		datePickerImpl.setBounds(1055, 10, 223, 33);
		panel_2.add(datePickerImpl);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(1055, 66, 223, 33);
		panel_2.add(txtDiaChi);
		
		txtSDT = new JTextField();
		txtSDT.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSDT.setColumns(10);
		txtSDT.setBounds(660, 53, 223, 33);
		panel_2.add(txtSDT);
		
		checkGioiTinh = new JCheckBox("Nam");
		checkGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 22));
		checkGioiTinh.setBounds(662, 16, 79, 25);
		panel_2.add(checkGioiTinh);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 10, 1326, 93);
		panel.add(panel_3);
		
		JLabel lblThngTinKhch = new JLabel("Thông Tin Khách Hàng");
		lblThngTinKhch.setFont(new Font("Tahoma", Font.ITALIC, 45));
		lblThngTinKhch.setBounds(357, 10, 605, 73);
		panel_3.add(lblThngTinKhch);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBackground(SystemColor.activeCaptionBorder);
		panel_4.setBounds(10, 556, 1326, 70);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("data\\img\\icons8-remove-24.png"));
		btnXoa.setBounds(429, 10, 147, 41);
		panel_4.add(btnXoa);
		btnXoa.setFont(new Font("Serif", Font.PLAIN, 22));
		
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("data\\img\\icons8-add-24.png"));
		btnThem.setBounds(224, 10, 162, 40);
		panel_4.add(btnThem);
		btnThem.setFont(new Font("Serif", Font.PLAIN, 22));
		
		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("data\\img\\icons8-support-24 (1).png"));
		btnSua.setBounds(626, 10, 147, 40);
		panel_4.add(btnSua);
		btnSua.setFont(new Font("Serif", Font.PLAIN, 22));
		
		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setIcon(new ImageIcon("data\\img\\icons8-delete-key-24.png"));
		btnXoaRong.setBounds(798, 10, 162, 40);
		panel_4.add(btnXoaRong);
		btnXoaRong.setFont(new Font("Serif", Font.PLAIN, 22));
		
		btnTaiLai = new JButton("Tải Lại");
		btnTaiLai.setIcon(new ImageIcon("data\\img\\icons8-process-24.png"));
		btnTaiLai.setBounds(995, 10, 177, 40);
		panel_4.add(btnTaiLai);
		btnTaiLai.setFont(new Font("Serif", Font.PLAIN, 22));
		
		btnXoaRong.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		checkGioiTinh.addActionListener(this);
		btnTim.addActionListener(this);
		comboBoxloc.addActionListener(this);
		btnLoc.addActionListener(this);
		btnTaiLai.addActionListener(this);
		
		Doculieuvaotabel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow(); 
				if(row != -1){
					String ma = (String) table.getValueAt(row, 0);
					KhachHang kh = new KhachHang(ma);
					ArrayList<KhachHang> lskh = kh_dao.getAllKhachHang();
					if(kh_dao.getAllKhachHang().contains(kh)){
						kh = lskh.get(lskh.indexOf(kh));
						txtMaKH.setText(kh.getMaKhachHang() + "");
						txtMaKH.setEditable(false);
						txtTenKH.setText(kh.getHoTen() + "");
						checkGioiTinh.setSelected(kh.getGioiTinh().matches("Nam")?true:false);
						datePickerImpl.getJFormattedTextField().setText(kh.getNgaySinh().toString());
						txtSDT.setText(kh.getsDT()+"");
						txtDiaChi.setText(kh.getDiaChi()+"");
					}
				}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)){
			new GUI_ThongTinThemKhachHang().setVisible(true);
			this.setVisible(false);
		}
		
		if(o.equals(btnSua)) {
			try {
					int row = table.getSelectedRow();
					if(row>=0) {
						KhachHang kh = suakh();
						if(kh_dao.Updata(kh)) {
							table.setValueAt(txtTenKH.getText(), row, 1);
							table.setValueAt(checkGioiTinh.isSelected()?"Nam":"Nữ", row, 2);
							table.setValueAt(txtSDT.getText(), row, 3);
							table.setValueAt(kh.getNgaySinh(), row, 4);
							table.setValueAt(txtDiaChi.getText(), row, 5);
							JOptionPane.showMessageDialog(this, "Sửa thông tin thành công!");
						}
				}else
					JOptionPane.showMessageDialog(this, "Chú ý: Bạn phải chọn Khách Hàng cần sửa. ");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		if(o.equals(btnXoaRong)) {
			
			txtMaKH.setText("");
			txtMaKH.setEditable(true);
			txtTenKH.setText("");
			checkGioiTinh.setSelected(false);
			txtSDT.setText("");
			datePickerImpl.getJFormattedTextField().setText("");
			txtDiaChi.setText("");
		}
		
		if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if(row != -1){
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Chắc chắn xóa không? ", "Chú ý", JOptionPane.YES_NO_OPTION);
				
					if(hoiNhac == JOptionPane.YES_OPTION) {
						String maKH = (String) table.getValueAt(row, 0);
						if(kh_dao.delete(maKH)) {
							model.removeRow(row);
							txtMaKH.setText("");
							txtTenKH.setText("");
							txtSDT.setText("");
							datePickerImpl.setVisible(true);
							txtDiaChi.setText("");
							JOptionPane.showMessageDialog(this, "Đã xóa 1 Khách Hàng!");
							
						}
					}
			
			}
		}
		if(o.equals(btnTim)) {
			String tim =  txtTim.getText();
			model.setRowCount(0);
			try {
				Doculieuvaotabel1(tim);
				if(tim.equals("")) {
					tim="rong";
					Doculieuvaotabel();
				}else {
					Doculieuvaotabel2(tim);
				}
				Doculieuvaotabel3(tim);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(o.equals(btnLoc)) {
			int option = comboBoxloc.getSelectedIndex();
			model.setRowCount(0);
			if(option==0) {
				Doculieuvaotabel();
			}
			if(option==1) {
				List<KhachHang> list = kh_dao.getkhachHangGT("Nam");
				if(list!=null) {
					for (KhachHang kh :list) {
						model.addRow(new Object[] {
								kh.getMaKhachHang(),
								kh.getHoTen(),
								kh.getGioiTinh(),
								kh.getsDT(),
								kh.getNgaySinh(),
								kh.getDiaChi()
						});			
					}
				}else {
					return;
				}
			}
			if(option==2) {
				List<KhachHang> list = kh_dao.getkhachHangGT("Nữ");
				if(list!=null) {
					for (KhachHang kh :list) {
						model.addRow(new Object[] {
								kh.getMaKhachHang(),
								kh.getHoTen(),
								kh.getGioiTinh(),
								kh.getsDT(),
								kh.getNgaySinh(),
								kh.getDiaChi()
						});			
					}
				}else {
					return;
				}
			}
			
		}
		if(o.equals(btnTaiLai)) {
			tailai();
		}
		
	}
	
	public void Doculieuvaotabel(){
		List<KhachHang> list = kh_dao.getAllKhachHang();
		if(list!=null) {
			for (KhachHang kh :list) {
				model.addRow(new Object[] {
						kh.getMaKhachHang(),
						kh.getHoTen(),
						kh.getGioiTinh(),
						kh.getsDT(),
						kh.getNgaySinh(),
						kh.getDiaChi()
				});			
			}
		}else {
			return;
		}
	}
	public void Doculieuvaotabel1(String ma){
		KhachHang kh = kh_dao.getkhachHangma(ma);
				if(kh!=null) {
					model.addRow(new Object[] {
							kh.getMaKhachHang(),
							kh.getHoTen(),
							kh.getGioiTinh(),
							kh.getsDT(),
							kh.getNgaySinh(),
							kh.getDiaChi()
					});	
				}else {
					return;
				}
	}
	public void Doculieuvaotabel2(String ten){
		List<KhachHang> list = kh_dao.getkhachHangTen(ten);
		if(list != null) {
			for (KhachHang kh :list) {
				model.addRow(new Object[] {
						kh.getMaKhachHang(),
						kh.getHoTen(),
						kh.getGioiTinh(),
						kh.getsDT(),
						kh.getNgaySinh(),
						kh.getDiaChi()
				});			
			}
		}else {
			return;
		}
	}
	public void Doculieuvaotabel3(String sdt){
		KhachHang kh = kh_dao.getkhachHangsdt(sdt);
					if(kh!=null) {
						model.addRow(new Object[] {
								kh.getMaKhachHang(),
								kh.getHoTen(),
								kh.getGioiTinh(),
								kh.getsDT(),
								kh.getNgaySinh(),
								kh.getDiaChi()
						});	
					}else {
						return;
					}
	}
	public void tailai() {
		DefaultTableModel defaultTableModel =  (DefaultTableModel) table.getModel();
		defaultTableModel.getDataVector().removeAllElements();
		defaultTableModel.fireTableDataChanged();
		Doculieuvaotabel();
	}
	
	private KhachHang suakh()  {
		int row = table.getSelectedRow();
		try {
				String maKhachHang = txtMaKH.getText();
				String hoTen = txtTenKH.getText();
				String gioiTinh = checkGioiTinh.isSelected()?"Nam":"Nữ";
				String sDT = txtSDT.getText();
				Date ngaysinh = (Date) datePickerImpl.getModel().getValue();
				
				if(ngaysinh==null){
					ngaysinh = (Date) table.getValueAt(row, 4);
				}
					
				String diaChi = txtDiaChi.getText();
				if(kiemtra(maKhachHang, hoTen, sDT, ngaysinh, diaChi)) {
					return new KhachHang(maKhachHang,hoTen,gioiTinh,sDT,ngaysinh,diaChi);
				}
		} catch (Exception e) {

		}
		return null;
	}
	@SuppressWarnings("deprecation")
	private boolean kiemtra(String ma,String hoten,String sdt,Date ngaySinh ,String diachi) {

		
		if(!(ma.length() > 0 && ma.matches("[A-Z0-9]{3,8}$"))) {
			JOptionPane.showMessageDialog(this, "Chú ý: Nhập mã sai cú pháp! (mã phải nhập chữ in hoa không dấu và số độ dài 3-8)");
			return false;
		}
		if (!(hoten.length() > 0 && hoten.matches("[A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\\\.,'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this,"Chú ý: Nhập tên sai cú pháp! (Phải nhập kí tự không có dấu)");
			return false;
		}
		if (!(sdt.length() > 0 && sdt.matches("[0-9]{10}$"))) {
			JOptionPane.showMessageDialog(this,"Chú ý: Nhập số điện thoại sai cú pháp!Là số và 10 kí tự!)");
			return false;
		}
		if(new java.util.Date().getYear() - 18 <= ngaySinh.getYear()) {
			JOptionPane.showMessageDialog(this,"CÔNG NHÂN PHẢI ĐỦ 18 TUỔI - NHẬP LẠI NGÀY SINH");
			return false;
		}
		if (!(diachi.length() > 0 && diachi.matches("[/A-Za-z0-9*a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\\\.,'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this,"Chú ý: Nhập địa chỉ sai cú pháp! (không được nhập kĩ tự đặc biệt!)");
			return false;
		}
		return true;
	}
}

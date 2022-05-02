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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import connectDB.ConnectDB;
import dao.DAO_CongNhan;
import entity.CongNhan;

public class GUI_QuanLyCongNhan extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txthoTen;
	private JTextField txtmaCN;
	private DefaultTableModel model;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnXoaRong;
	private JButton btnThem;
	private DAO_CongNhan cn_dao;
	private JCheckBox checkGioiTinh;
	private JDatePickerImpl datePickerImpl;
	private JTextField txtTim;
	private JComboBox<String> comboLoc;
	private JButton btnTim;
	private JButton btnLoc;
	private JButton btntaiLai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLyCongNhan frame = new GUI_QuanLyCongNhan();
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
	public GUI_QuanLyCongNhan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 680);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try{
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		cn_dao = new DAO_CongNhan();
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 10, 1346, 623);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBounds(10, 82, 1327, 332);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 53, 1327, 269);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setAutoscrolls(true);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_1.add(scrollPane);
		
		String[] cols= {"Mã Công Nhân","Họ Tên","Giới tính","Số Điện Thoại","Ngày Sinh","Địa Chỉ"};
		model= new DefaultTableModel(cols,0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(1);
		table.getColumnModel().getColumn(2).setPreferredWidth(1);
		table.getColumnModel().getColumn(3).setPreferredWidth(1);
		table.getColumnModel().getColumn(4).setPreferredWidth(1);
		scrollPane.setViewportView(table);
		
		comboLoc = new JComboBox<String>();
		comboLoc.setBounds(611, 9, 281, 33);
		comboLoc.setFont(new Font("Tahoma", Font.PLAIN, 22));
		comboLoc.setModel(new DefaultComboBoxModel<String>(new String[] {"Lọc Giới Tính", "Nam", "Nữ"}));
		panel_1.add(comboLoc);
		
		txtTim = new JTextField();
		txtTim.setBounds(10, 10, 402, 33);
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTim.setColumns(10);
		panel_1.add(txtTim);
		
		btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Serif", Font.PLAIN, 25));
		btnTim.setBounds(426, 10, 143, 33);
		panel_1.add(btnTim);
		
		btnLoc = new JButton("Lọc");
		btnLoc.setFont(new Font("Serif", Font.PLAIN, 25));
		btnLoc.setBounds(922, 9, 143, 33);
		panel_1.add(btnLoc);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setBounds(10, 422, 1327, 112);
		panel_2.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Chi Ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Công Nhân: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(42, 10, 170, 33);
		panel_2.add(lblNewLabel_1);
		
		txtSDT = new JTextField();
		txtSDT.setBorder(new LineBorder(SystemColor.activeCaptionText));
		txtSDT.setBounds(595, 60, 226, 27);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ Tên:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(107, 51, 95, 33);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giới Tính:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(482, 10, 103, 33);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ngày Sinh:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(825, 10, 109, 33);
		panel_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Địa Chỉ:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(846, 53, 88, 33);
		panel_2.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Số Điện Thoại:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(446, 53, 170, 33);
		panel_2.add(lblNewLabel_1_5);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBorder(new LineBorder(SystemColor.activeCaptionText));
		txtDiaChi.setColumns(10);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDiaChi.setBounds(944, 61, 226, 27);
		panel_2.add(txtDiaChi);
		
		txthoTen = new JTextField();
		txthoTen.setBorder(new LineBorder(SystemColor.activeCaptionText));
		txthoTen.setColumns(10);
		txthoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txthoTen.setBounds(195, 53, 226, 27);
		panel_2.add(txthoTen);
		
		txtmaCN = new JTextField();
		txtmaCN.setBorder(new LineBorder(SystemColor.activeCaptionText));
		txtmaCN.setColumns(10);
		txtmaCN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtmaCN.setBounds(195, 10, 226, 27);

		panel_2.add(txtmaCN);
		
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
		datePickerImpl.setBounds(944, 13, 226, 33);
		panel_2.add(datePickerImpl);
		
		checkGioiTinh = new JCheckBox("Nam");
		checkGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 22));
		checkGioiTinh.setBounds(595, 20, 79, 25);
		panel_2.add(checkGioiTinh);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(10, 10, 1327, 68);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông Tin Công Nhân");
		lblNewLabel.setBounds(373, 10, 449, 55);
		panel_3.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 45));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaptionBorder);
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(10, 539, 1327, 74);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setBounds(758, 20, 185, 40);
		panel_4.add(btnXoaRong);
		btnXoaRong.setIcon(new ImageIcon("data\\img\\icons8-delete-key-24.png"));
		btnXoaRong.setFont(new Font("Serif", Font.PLAIN, 22));
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(196, 20, 168, 40);
		panel_4.add(btnThem);
		btnThem.setIcon(new ImageIcon("data\\img\\icons8-add-24.png"));
		btnThem.setFont(new Font("Serif", Font.PLAIN, 22));
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(398, 20, 142, 40);
		panel_4.add(btnSua);
		btnSua.setIcon(new ImageIcon("data\\img\\icons8-support-24 (1).png"));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSua.setFont(new Font("Serif", Font.PLAIN, 22));
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(565, 20, 155, 40);
		panel_4.add(btnXoa);
		btnXoa.setIcon(new ImageIcon("data\\img\\icons8-remove-24.png"));
		btnXoa.setFont(new Font("Serif", Font.PLAIN, 22));
		
		btntaiLai = new JButton("Tải Lại");
		btntaiLai.setBounds(971, 20, 193, 37);
		panel_4.add(btntaiLai);
		btntaiLai.setIcon(new ImageIcon("data\\img\\icons8-process-24.png"));
		btntaiLai.setFont(new Font("Serif", Font.PLAIN, 22));
		
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		checkGioiTinh.addActionListener(this);
		comboLoc.addActionListener(this);
		btntaiLai.addActionListener(this);
		btnTim.addActionListener(this);
		btnLoc.addActionListener(this);
		btntaiLai.addActionListener(this);
		
		Doculieuvaotabel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				int row = table.getSelectedRow(); 
				if(row != -1){
					
					String ma = (String) table.getValueAt(row, 0);
					CongNhan cn = new CongNhan(ma);
					ArrayList<CongNhan> lscn = cn_dao.getAllCongNhan();
					
					if(cn_dao.getAllCongNhan().contains(cn)) {
						cn = lscn.get(lscn.indexOf(cn));
						txtmaCN.setText(cn.getMaCongNhan() + "");
						txthoTen.setText(cn.getHoTen() + "");
						checkGioiTinh.setSelected(cn.getGioiTinh().matches("Nam")?true:false);
						txtSDT.setText(cn.getSdt() + "");
						datePickerImpl.getJFormattedTextField().setText(cn.getNgaySinh().toString());
						txtDiaChi.setText(cn.getDiaChi()+"");
						txtmaCN.setEditable(false);
						
					}
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		if(o.equals(btnThem)){
			new GUI_ThongTinThemCongNhan().setVisible(true);
			this.setVisible(false);
		}
		if(o.equals(btnSua)) {
			try {
					int row = table.getSelectedRow();
					if(row>=0) {
						CongNhan cn = suakh();
						if(cn_dao.Updata(cn)) {
							table.setValueAt(txthoTen.getText(), row, 1);
							table.setValueAt(checkGioiTinh.isSelected()?"Nam":"Nữ", row, 2);
							table.setValueAt(txtSDT.getText(), row, 3);
							table.setValueAt(cn.getNgaySinh(), row, 4);
							table.setValueAt(txtDiaChi.getText(), row, 5);
							JOptionPane.showMessageDialog(this, "Sửa thông tin thành công!");
						}
				}else
					JOptionPane.showMessageDialog(this, "Chú ý: Bạn phải chọn Khách Hàng cần sửa. ");
			} catch (Exception e2) {
				
			}
		}
		
		if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if(row != -1){
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Chắc chắn xóa không? ", "Chú ý", JOptionPane.YES_NO_OPTION);
				if(hoiNhac == JOptionPane.YES_OPTION) {
					String macn = (String) table.getValueAt(row, 0);
					if(cn_dao.delete(macn)) {
						model.removeRow(row);
						txtmaCN.setText("");
						txthoTen.setText("");
						txtSDT.setText("");
						datePickerImpl.setVisible(true);
						txtDiaChi.setText("");
						JOptionPane.showMessageDialog(this, "Đã xóa 1 Khách Hàng!");
						
					}
				}
			}
		}
			if(o.equals(btnXoaRong)) {
						txtmaCN.setText("");
						txthoTen.setText("");
						checkGioiTinh.setSelected(false);
						datePickerImpl.getJFormattedTextField().setText("");
						txtSDT.setText("");
						txtDiaChi.setText("");
						txtmaCN.setEditable(true);
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
				int option = comboLoc.getSelectedIndex();
				model.setRowCount(0);
				if(option==0) {
					Doculieuvaotabel();
				}
				if(option==1) {
					List<CongNhan> list = cn_dao.getCongNhanGT("Nam");
					if(list!=null) {
						for (CongNhan cn :list) {
							model.addRow(new Object[] {
									cn.getMaCongNhan(),
									cn.getHoTen(),
									cn.getGioiTinh(),
									cn.getSdt(),
									cn.getNgaySinh(),
									cn.getDiaChi()
							});			
						}
					}else {
						return;
					}
				}
				if(option==2) {
					List<CongNhan> list = cn_dao.getCongNhanGT("Nữ");
					if(list!=null) {
						for (CongNhan cn :list) {
							model.addRow(new Object[] {
									cn.getMaCongNhan(),
									cn.getHoTen(),
									cn.getGioiTinh(),
									cn.getSdt(),
									cn.getNgaySinh(),
									cn.getDiaChi()
							});			
						}
					}else {
						return;
					}
				}
			}
			if(o.equals(btntaiLai)) {
				tailai();
				
			}
	}
	
	public void tailai() {
		DefaultTableModel defaultTableModel =  (DefaultTableModel) table.getModel();
		defaultTableModel.getDataVector().removeAllElements();
		defaultTableModel.fireTableDataChanged();
		Doculieuvaotabel();
	}
	
	public void Doculieuvaotabel(){
		List<CongNhan> list = cn_dao.getAllCongNhan();
		for (CongNhan cn :list) {
					model.addRow(new Object[] {
							cn.getMaCongNhan(),cn.getHoTen(),cn.getGioiTinh(),cn.getSdt(),cn.getNgaySinh(),cn.getDiaChi()
					});			
		}
	}
	
	private CongNhan suakh()  {
		int row = table.getSelectedRow();
		try {
			
				String maKhachHang = txtmaCN.getText();
				String hoTen = txthoTen.getText();
				String gioiTinh = checkGioiTinh.isSelected()?"Nam":"Nữ";
				String sDT = txtSDT.getText();
				java.sql.Date ngaysinh = (java.sql.Date) datePickerImpl.getModel().getValue();
				if(ngaysinh==null){
					ngaysinh = (Date) table.getValueAt(row, 4);
				}
				String diaChi = txtDiaChi.getText();
				
				if(kiemtra(maKhachHang, hoTen, sDT, ngaysinh, diaChi)) {
					return new CongNhan(maKhachHang,hoTen,gioiTinh,sDT,ngaysinh,diaChi);
				}
				
		} catch (Exception e) {
			
		}
		return null;
	}

	
	//Đọc Dữ liệu vào theo mã
		public void Doculieuvaotabel1(String ma){
				CongNhan cn = cn_dao.getCongNhanma(ma);
							if(cn != null) {
								model.addRow(new Object[] {
										cn.getMaCongNhan(),
										cn.getHoTen(),
										cn.getGioiTinh(),
										cn.getSdt(),
										cn.getNgaySinh(),
										cn.getDiaChi(),	
								});
							}else {
								return;
							}
			
		}
		//Đọc Dữ liệu vào theo tên
		public void Doculieuvaotabel2(String ten){
			
				ArrayList<CongNhan> list = cn_dao.getCongNhanTen(ten);
							if(list != null) {
								for (CongNhan nv2 :list) {		
									model.addRow(new Object[] {
											nv2.getMaCongNhan(),
											nv2.getHoTen(),
											nv2.getGioiTinh(),
											nv2.getSdt(),
											nv2.getNgaySinh(),
											nv2.getDiaChi(),
									});			
								}
							}else {
									return;
							}
														
		}
				
							

		//Đọc Dữ liệu vào theo sdt
		public void Doculieuvaotabel3(String sdt){
			
			CongNhan nv3 = cn_dao.getCongNhansdt(sdt);
				if(nv3 != null) {
							model.addRow(new Object[] {
									nv3.getMaCongNhan(),
									nv3.getHoTen(),
									nv3.getGioiTinh(),
									nv3.getSdt(),
									nv3.getNgaySinh(),
									nv3.getDiaChi(),
		
							});
				}else {
					return;
				}
	}
		@SuppressWarnings("deprecation")
		private boolean kiemtra(String ma, String hoTen,String sdt,Date ngaySinh,String diachi) {
			
			if(!(ma.length() > 0 && ma.matches("[A-Z0-9]{3,8}$"))) {
				JOptionPane.showMessageDialog(this, "Chú ý: Nhập mã sai cú pháp! (mã phải nhập chữ in hoa không dấu và số độ dài 3-8)");
				return false;
			}
			if (!(hoTen.length() > 0 && hoTen.matches("[A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\\\.,'\\\\-]+"))) {
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

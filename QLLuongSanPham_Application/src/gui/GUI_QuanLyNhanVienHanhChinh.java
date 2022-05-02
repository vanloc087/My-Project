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
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import connectDB.ConnectDB;
import dao.DAO_NhanVienHanhChinh;
import entity.NhanVienHanhChinh;

public class GUI_QuanLyNhanVienHanhChinh extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtMa;
	private JTextField txtHoTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtHesoLuong;
	private JTextField txtDVCongTac1;
	private JTextField txtChucVu;
	private DefaultTableModel model;
	private JDatePickerImpl datePickerImplNgaySinh;
	private JDatePickerImpl datePickerImplNgayBatDau;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnXoaRong;
	private JButton btnSua;
	private JButton btnTiLai;
	private JCheckBox checkGioiTinh;
	private DAO_NhanVienHanhChinh nv_Dao;
	private JTextField txtTim;
	private JButton btnTim;
	private JButton btnLoc;
	private JComboBox<String> comboGioitinh;
	private JComboBox<String> combodvct;
	private JComboBox<String> combochucvu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLyNhanVienHanhChinh frame = new GUI_QuanLyNhanVienHanhChinh();
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
	public GUI_QuanLyNhanVienHanhChinh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 680);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try{
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		nv_Dao = new DAO_NhanVienHanhChinh();
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 10, 1326, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông Tin Nhân Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 45));
		lblNewLabel.setBounds(468, 10, 440, 55);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.inactiveCaptionText, SystemColor.inactiveCaptionText, SystemColor.inactiveCaptionText, SystemColor.inactiveCaptionText));
		panel_1.setBounds(10, 90, 1326, 265);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(10, 53, 1306, 206);
		panel_1.add(scrollPane);
		
		
//		String[] cols= {"Mã Nhân Viên","Họ Tên","Giới tính","Số Điện Thoại","Ngày Sinh","Địa Chỉ","Ngày Bắt Đầu","Lương Cơ Bản","Đơn Vị Công Tác","Chức Vụ"};
//		model= new DefaultTableModel(cols,0);
//		table = new JTable(model);
//		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		table.setRowHeight(30);
//		table.getColumnModel().getColumn(0).setPreferredWidth(1);
//		table.getColumnModel().getColumn(2).setPreferredWidth(1);
//		table.getColumnModel().getColumn(3).setPreferredWidth(1);
//		table.getColumnModel().getColumn(4).setPreferredWidth(1);
//		scrollPane.setViewportView(table);
		
		
		model =new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public Class<?> getColumnClass(int column){
				switch(column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				case 5:
					return String.class;
				case 6:
					return String.class;
				case 7:
					return Double.class;
				case 8:
					return String.class;
				case 9:
					return String.class;
					
				default:
				return String.class;
				}
			}
			boolean[] columnEditables = new boolean[] {
					false,false, false, false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			
		};
		table = new JTable(model);
		table.setRowHeight(30);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		model.addColumn("Mã Nhân Viên");
		model.addColumn("Họ Tên");
		model.addColumn("Giới tính");
		model.addColumn("Số Điện Thoại");
		model.addColumn("Ngày Sinh");
		model.addColumn("Địa Chỉ");
		model.addColumn("Ngày Bắt Đầu");
		model.addColumn("Hệ Số Lương");
		model.addColumn("Đơn Vị Công Tác");
		model.addColumn("Chức Vụ");
		table.getColumnModel().getColumn(0).setPreferredWidth(4);
		scrollPane.setViewportView(table);
		
		comboGioitinh = new JComboBox<String>();
		comboGioitinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboGioitinh.setModel(new DefaultComboBoxModel<String>(new String[] {"Chọn Giới Tính", "Nam", "Nữ"}));
		comboGioitinh.setBounds(552, 9, 175, 34);
		panel_1.add(comboGioitinh);
		
		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTim.setBounds(10, 10, 352, 34);
		panel_1.add(txtTim);
		txtTim.setColumns(10);
		
		btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setFont(new Font("Serif", Font.PLAIN, 25));
		btnTim.setBounds(372, 9, 147, 34);
		panel_1.add(btnTim);
		
		combodvct = new JComboBox<String>();
		combodvct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		combodvct.setModel(new DefaultComboBoxModel<String>(new String[] {"Chọn Đơn Vị Công Tác", "Tổ Chấm Công", "Tổ Quản Kho", "Tổ Kế Toán"}));
		combodvct.setBounds(737, 9, 206, 34);
		panel_1.add(combodvct);
		
		combochucvu = new JComboBox<String>();
		combochucvu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		combochucvu.setModel(new DefaultComboBoxModel<String>(new String[] {"Chọn Chức Vụ", "Tổ Trưởng", "Nhân Viên", "Tập Sự"}));
		combochucvu.setBounds(963, 9, 197, 34);
		panel_1.add(combochucvu);
		
		 btnLoc = new JButton("Lọc");
		btnLoc.setFont(new Font("Serif", Font.PLAIN, 25));
		btnLoc.setBounds(1177, 7, 139, 34);
		panel_1.add(btnLoc);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 548, 1326, 85);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("data\\img\\icons8-add-24.png"));
		btnThem.setFont(new Font("Serif", Font.PLAIN, 22));
		btnThem.setBounds(155, 14, 158, 40);
		panel_2.add(btnThem);
		
		 btnXoa = new JButton("Xóa");
		 btnXoa.setIcon(new ImageIcon("data\\img\\icons8-remove-24.png"));
		btnXoa.setFont(new Font("Serif", Font.PLAIN, 22));
		btnXoa.setBounds(353, 14, 153, 40);
		panel_2.add(btnXoa);
		
		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setIcon(new ImageIcon("data\\img\\icons8-delete-key-24.png"));
		btnXoaRong.setFont(new Font("Serif", Font.PLAIN, 22));
		btnXoaRong.setBounds(718, 14, 166, 40);
		panel_2.add(btnXoaRong);
		
		 btnSua = new JButton("Sửa");
		 btnSua.setIcon(new ImageIcon("data\\img\\icons8-support-24 (1).png"));
		btnSua.setFont(new Font("Serif", Font.PLAIN, 22));
		btnSua.setBounds(540, 14, 153, 40);
		panel_2.add(btnSua);
		
		 btnTiLai = new JButton("Tải Lại");
		 btnTiLai.setIcon(new ImageIcon("data\\img\\icons8-process-24.png"));
		 btnTiLai.setBounds(927, 14, 182, 40);
		 panel_2.add(btnTiLai);
		 btnTiLai.setFont(new Font("Serif", Font.PLAIN, 22));
		 btnTiLai.addActionListener(this);
		
		JPanel lable_9 = new JPanel();
		lable_9.setBounds(10, 365, 1326, 173);
		contentPane.add(lable_9);
		lable_9.setBackground(SystemColor.scrollbar);
		lable_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lable_9.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Chi ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lable_9.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Công Nhân: ");
		lblNewLabel_1.setBounds(21, 10, 154, 33);
		lable_9.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtMa = new JTextField();
		txtMa.setBounds(162, 17, 211, 27);
		lable_9.add(txtMa);
		txtMa.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtMa.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số Điện Thoai:");
		lblNewLabel_1_2.setBounds(406, 10, 154, 33);
		lable_9.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtSDT = new JTextField();
		txtSDT.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSDT.setBounds(555, 17, 226, 27);
		lable_9.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Ngày Bắt Đầu:");
		lblNewLabel_1_2_3.setBounds(834, 18, 154, 33);
		lable_9.add(lblNewLabel_1_2_3);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Lương Cơ Bản:");
		lblNewLabel_1_2_4.setBounds(844, 54, 154, 33);
		lable_9.add(lblNewLabel_1_2_4);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		SqlDateModel model1 = new SqlDateModel();
		Properties p =  new Properties();
		p.put("text.date", "date");
		p.put("text.month", "month");
		p.put("text.year", "year");
		JDatePanelImpl impl1 = new JDatePanelImpl(model1, p);
		datePickerImplNgayBatDau = new JDatePickerImpl(impl1, new AbstractFormatter() {
			
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
		datePickerImplNgayBatDau.setTextEditable(true);
		datePickerImplNgayBatDau.setBounds(998, 17, 226, 27);
		lable_9.add(datePickerImplNgayBatDau);
		
		
		txtHesoLuong = new JTextField();
		txtHesoLuong.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtHesoLuong.setBounds(998, 61, 226, 27);
		lable_9.add(txtHesoLuong);
		txtHesoLuong.setColumns(10);
		
		SqlDateModel model2 = new SqlDateModel();
		JDatePanelImpl impl2 = new JDatePanelImpl(model2, p);
		datePickerImplNgaySinh = new JDatePickerImpl(impl2, new AbstractFormatter() {
			
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
		datePickerImplNgaySinh.setTextEditable(true);
		datePickerImplNgaySinh.getJFormattedTextField().setBorder(new LineBorder(new Color(171, 173, 179)));
		datePickerImplNgaySinh.setBounds(555, 61, 226, 27);
		lable_9.add(datePickerImplNgaySinh);
		
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ngày Sinh:");
		lblNewLabel_1_2_1.setBounds(436, 54, 114, 33);
		lable_9.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		
		txtHoTen = new JTextField();
		txtHoTen.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtHoTen.setBounds(162, 61, 211, 27);
		lable_9.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ Tên:");
		lblNewLabel_1_1.setBounds(82, 54, 87, 33);
		lable_9.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giới Tính:");
		lblNewLabel_1_1_1.setBounds(65, 97, 98, 33);
		lable_9.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Địa Chỉ:");
		lblNewLabel_1_2_2.setBounds(463, 91, 70, 33);
		lable_9.add(lblNewLabel_1_2_2);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDiaChi.setBounds(555, 98, 226, 27);
		lable_9.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblNewLabel_1_2_5 = new JLabel("Đơn Vị Công Tác:");
		lblNewLabel_1_2_5.setBounds(812, 91, 186, 33);
		lable_9.add(lblNewLabel_1_2_5);
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtDVCongTac1 = new JTextField();
		txtDVCongTac1.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDVCongTac1.setBounds(998, 98, 226, 27);
		lable_9.add(txtDVCongTac1);
		txtDVCongTac1.setColumns(10);
		
		txtChucVu = new JTextField();
		txtChucVu.setBounds(998, 135, 226, 27);
		lable_9.add(txtChucVu);
		txtChucVu.setColumns(10);
		txtChucVu.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1_3 = new JLabel("Chức Vụ:");
		lblNewLabel_1_3.setBounds(882, 128, 87, 33);
		lable_9.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		checkGioiTinh = new JCheckBox("Nam");
		checkGioiTinh.setBorder(new LineBorder(new Color(0, 0, 0)));
		checkGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkGioiTinh.setBounds(162, 103, 211, 27);
		lable_9.add(checkGioiTinh);
		
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		combochucvu.addActionListener(this);
		combodvct.addActionListener(this);
		btnLoc.addActionListener(this);
		btnTiLai.addActionListener(this);
		
		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDVCongTac1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtHesoLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		Doculieuvaotabel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow(); 
				if(row != -1){
					String ma = (String) table.getValueAt(row, 0);
					NhanVienHanhChinh nv = new NhanVienHanhChinh(ma);
					ArrayList<NhanVienHanhChinh> lskh = nv_Dao.getAllNhanVienHanhChinh();
					if(nv_Dao.getAllNhanVienHanhChinh().contains(nv)){
						nv = lskh.get(lskh.indexOf(nv));
						txtMa.setText(nv.getMaNhanVien() + "");
						txtMa.setEditable(false);
						txtHoTen.setText(nv.getHoTen() + "");
						checkGioiTinh.setSelected(nv.getGioiTinh().matches("Nam")?true:false);
						datePickerImplNgaySinh.getJFormattedTextField().setText(nv.getNgaySinh().toString());
						txtSDT.setText(nv.getSdt()+"");
						txtDiaChi.setText(nv.getDiaChi()+"");
						datePickerImplNgayBatDau.getJFormattedTextField().setText(nv.getNgayBatDau().toString());
						txtHesoLuong.setText(nv.getHeSoluong() + "");
						txtDVCongTac1.setText(nv.getDonViCongTac() + "");
						txtChucVu.setText(nv.getChucVu() + "");
					}
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		if(o.equals(btnThem)){
			new GUI_ThongTinThemNhanVien().setVisible(true);
			this.setVisible(false);
		}
		if(o.equals(btnXoaRong)) {
					txtMa.setText("");
					txtMa.setEditable(true);
					txtHoTen.setText("");
					checkGioiTinh.setSelected(false);
					txtSDT.setText("");
					datePickerImplNgaySinh.getJFormattedTextField().setText("");
					txtDiaChi.setText("");
					datePickerImplNgayBatDau.getJFormattedTextField().setText("");
					txtHesoLuong.setText("");
					txtDVCongTac1.setText("");
					txtChucVu.setText("");
				}
		if(o.equals(btnSua)) {
			try {	
					int row = table.getSelectedRow();
					if(row>=0) {
						NhanVienHanhChinh nv = suakh();
						if(nv_Dao.Updata(nv)) {
							model.setRowCount(0);
							Doculieuvaotabel();
							JOptionPane.showMessageDialog(this, "Sửa thông tin thành công!");
						}
				}else
					JOptionPane.showMessageDialog(this, "Bạn phải chọn Khách Hàng cần sửa. ");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if(row != -1){
				int hoiNhac = JOptionPane.showConfirmDialog(this, "Chắc chắn xóa không? ", "Chú ý", JOptionPane.YES_NO_OPTION);
				if(hoiNhac == JOptionPane.YES_OPTION) {
					String maKH = (String) table.getValueAt(row, 0);
					if(nv_Dao.delete(maKH)) {
						model.removeRow(row);
						txtMa.setText("");
						txtHoTen.setText("");
						txtSDT.setText("");
						datePickerImplNgaySinh.setVisible(true);
						txtDiaChi.setText("");
						datePickerImplNgayBatDau.setVisible(true);
						txtHesoLuong.setText("");
						txtDVCongTac1.setText("");
						txtChucVu.setText("");
						JOptionPane.showMessageDialog(this, "Đã xóa 1 Khách Hàng!");
						
					}
				}
			}
		}
		if(o.equals(btnTim)){
			String tim = txtTim.getText();
			DefaultTableModel model1 = (DefaultTableModel) table.getModel();
			model1.setRowCount(0);
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
				
			}
		}
		if(o.equals(btnTiLai)) {
			tailai();
		}
		if(o.equals(btnLoc)){
			ArrayList<NhanVienHanhChinh> list = null;
			int select = comboGioitinh.getSelectedIndex();
			if(select==0) {
				int select1 = combodvct.getSelectedIndex();
				if(select1==0){
					
					int select3 = combochucvu.getSelectedIndex();
					if(select3==0) {
						list = nv_Dao.locnhanvien("","","");
					}
					if(select3==1) {
						
						list = nv_Dao.locnhanvien("","","Tổ Trưởng");
					}
					if(select3==2) {
						list = nv_Dao.locnhanvien("","","Nhân viên");
						
					}
					if(select3==3) {
						list = nv_Dao.locnhanvien("","","Tập sự");
					}
				}
				if(select1==1){
					list = nv_Dao.locnhanvien("", "Tổ Chấm Công","");
					int select3 = combochucvu.getSelectedIndex();
					if(select3==0) {
						list = nv_Dao.locnhanvien("", "Tổ Chấm Công","");
					}
					if(select3==1) {
						list = nv_Dao.locnhanvien("", "Tổ Chấm Công","Nhân viên");
					}
					if(select3==2) {
						list = nv_Dao.locnhanvien("", "Tổ Chấm Công","Tổ Trưởng");
					}
					if(select3==3) {
						list = nv_Dao.locnhanvien("", "Tổ Chấm Công","Tập sự");
					}
				}
				if(select1==2){
					list = nv_Dao.locnhanvien("", "Tổ Quản Kho","");
					int select3 = combochucvu.getSelectedIndex();
					if(select3==0) {
						list = nv_Dao.locnhanvien("", "Tổ Quản Kho","");
					}
					if(select3==1) {
						list = nv_Dao.locnhanvien("", "Tổ Quản Kho","Nhân viên");
					}
					if(select3==2) {
						list = nv_Dao.locnhanvien("", "Tổ Quản Kho","Tổ Trưởng");
					}
					if(select3==3) {
						list = nv_Dao.locnhanvien("", "Tổ Quản Kho","Tập sự");
					}
				}
				if(select1==3){
					list = nv_Dao.locnhanvien("", "Tổ Kế Toán","");
					int select3 = combochucvu.getSelectedIndex();
					if(select3==0) {
						list = nv_Dao.locnhanvien("", "Tổ Kế Toán","");
					}
					if(select3==1) {
						list = nv_Dao.locnhanvien("", "Tổ Kế Toán","Nhân viên");
					}
					if(select3==2) {
						list = nv_Dao.locnhanvien("", "Tổ Kế Toán","Tổ Trưởng");
					}
					if(select3==3) {
						list = nv_Dao.locnhanvien("", "Tổ Kế Toán","Tập sự");
					}
				}
			}
			if(select==1) {
				int select1 = combodvct.getSelectedIndex();
					if(select1==0){
						list = nv_Dao.locnhanvien("Nam","","");
						int select3 = combochucvu.getSelectedIndex();
						if(select3==0) {
							list = nv_Dao.locnhanvien("Nam", "","");
						}
						if(select3==1) {
							list = nv_Dao.locnhanvien("Nam", "","Nhân viên");
						}
						if(select3==2) {
							list = nv_Dao.locnhanvien("Nam", "","Tổ Trưởng");
						}
						if(select3==3) {
							list = nv_Dao.locnhanvien("Nam", "","Tập sự");
						}
					}
					if(select1==1){
						list = nv_Dao.locnhanvien("Nam", "Tổ Chấm Công","");
						int select3 = combochucvu.getSelectedIndex();
						if(select3==0) {
							list = nv_Dao.locnhanvien("Nam", "Tổ Chấm Công","");
						}
						if(select3==1) {
							list = nv_Dao.locnhanvien("Nam", "Tổ Chấm Công","Nhân viên");
						}
						if(select3==2) {
							list = nv_Dao.locnhanvien("Nam", "Tổ Chấm Công","Tổ Trưởng");
						}
						if(select3==3) {
							list = nv_Dao.locnhanvien("Nam", "Tổ Chấm Công","Tập sự");
						}
					}
					if(select1==2){
						list = nv_Dao.locnhanvien("Nam", "Tổ Quản Kho","");
						int select3 = combochucvu.getSelectedIndex();
						if(select3==0) {
							list = nv_Dao.locnhanvien("Nam", "Tổ Quản Kho","");
							
						}
						if(select3==1) {
							list = nv_Dao.locnhanvien("Nam", "Tổ Quản Kho","Nhân viên");
							
						}
						if(select3==2) {
							list = nv_Dao.locnhanvien("Nam", "Tổ Quản Kho","Tổ Trưởng");
							
						}
						if(select3==3) {
							list = nv_Dao.locnhanvien("Nam", "Tổ Quản Kho","Tập sự");
							
						}
					}
					if(select1==3){
						list = nv_Dao.locnhanvien("Nam", "Tổ Kế Toán","");
						int select3 = combochucvu.getSelectedIndex();
						if(select3==3) {
							if(select3==0) {
								list = nv_Dao.locnhanvien("Nam", "Tổ Kế Toán","");
								
							}
							if(select3==1) {
								list = nv_Dao.locnhanvien("Nam", "Tổ Kế Toán","Nhân viên");
								
							}
							if(select3==2) {
								list = nv_Dao.locnhanvien("Nam", "Tổ Kế Toán","Tổ Trưởng");
								
							}
							if(select3==3) {
								list = nv_Dao.locnhanvien("Nam", "Tổ Kế Toán","Tập sự");
								
							}
						}
					}
			}
			if(select==2) {
				int select1 = combodvct.getSelectedIndex();
				if(select1==0){
					list = nv_Dao.locnhanvien("Nữ","","");
					int select3 = combochucvu.getSelectedIndex();
					if(select3==0) {
						list = nv_Dao.locnhanvien("Nữ", "","");
					}
					if(select3==1) {
						list = nv_Dao.locnhanvien("Nữ", "","Nhân viên");
					}
					if(select3==2) {
						list = nv_Dao.locnhanvien("Nữ", "","Tổ Trưởng");
					}
					if(select3==3) {
						list = nv_Dao.locnhanvien("Nữ", "","Tập sự");
					}
				}
				if(select1==1){
					list = nv_Dao.locnhanvien("Nữ", "Tổ Chấm Công","");
					int select3 = combochucvu.getSelectedIndex();
					if(select3==0) {
						list = nv_Dao.locnhanvien("Nữ", "Tổ Chấm Công","");
					}
					if(select3==1) {
						list = nv_Dao.locnhanvien("Nữ", "Tổ Chấm Công","Nhân viên");
					}
					if(select3==2) {
						list = nv_Dao.locnhanvien("Nữ", "Tổ Chấm Công","Tổ Trưởng");
					}
					if(select3==3) {
						list = nv_Dao.locnhanvien("Nữ", "Tổ Chấm Công","Tập sự");
					}
				}
				if(select1==2){
					list = nv_Dao.locnhanvien("Nữ", "Tổ Quản Kho","");
					int select3 = combochucvu.getSelectedIndex();
					if(select3==0) {
						list = nv_Dao.locnhanvien("Nữ", "Tổ Quản Kho","");
						
					}
					if(select3==1) {
						list = nv_Dao.locnhanvien("Nữ", "Tổ Quản Kho","Nhân viên");
						
					}
					if(select3==2) {
						list = nv_Dao.locnhanvien("Nữ", "Tổ Quản Kho","Tổ Trưởng");
						
					}
					if(select3==3) {
						list = nv_Dao.locnhanvien("Nữ", "Tổ Quản Kho","Tập sự");
						
					}
				}
				if(select1==3){
					list = nv_Dao.locnhanvien("Nữ", "Tổ Kế Toán","");
					int select3 = combochucvu.getSelectedIndex();
					if(select3==3) {
						if(select3==0) {
							list = nv_Dao.locnhanvien("Nữ", "Tổ Kế Toán","");
							
						}
						if(select3==1) {
							list = nv_Dao.locnhanvien("Nữ", "Tổ Kế Toán","Nhân viên");
							
						}
						if(select3==2) {
							list = nv_Dao.locnhanvien("Nữ", "Tổ Kế Toán","Tổ Trưởng");
							
						}
						if(select3==3) {
							list = nv_Dao.locnhanvien("Nữ", "Tổ Kế Toán","Tập sự");
							
						}
					}
				}
			}
			model.setRowCount(0);
			for (NhanVienHanhChinh nv :list) {
				model.addRow(new Object[] {
						nv.getMaNhanVien(),
						nv.getHoTen(),
						nv.getGioiTinh(),
						nv.getSdt(),
						nv.getNgaySinh(),
						nv.getDiaChi(),
						nv.getNgayBatDau(),
						nv.getHeSoluong(),
						nv.getDonViCongTac(),
						nv.getChucVu()
				});			
	}
			
		}
	}
	
	public void tailai() {
		DefaultTableModel defaultTableModel =  (DefaultTableModel) table.getModel();
		defaultTableModel.getDataVector().removeAllElements();
		defaultTableModel.fireTableDataChanged();
		Doculieuvaotabel();
	}
	public void Doculieuvaotabel(){
		List<NhanVienHanhChinh> list = nv_Dao.getAllNhanVienHanhChinh();
		
		for (NhanVienHanhChinh nv :list) {
					model.addRow(new Object[] {
							nv.getMaNhanVien(),
							nv.getHoTen(),
							nv.getGioiTinh(),
							nv.getSdt(),
							nv.getNgaySinh(),
							nv.getDiaChi(),
							nv.getNgayBatDau(),
							nv.getHeSoluong(),
							nv.getDonViCongTac(),
							nv.getChucVu()
					});			
		}
	}
	//Đọc Dữ liệu vào theo mã
	public void Doculieuvaotabel1(String ma){
		
			NhanVienHanhChinh nv1 = nv_Dao.getnhanvienma(ma);
						
						if(nv1 != null) {
							model.addRow(new Object[] {
									nv1.getMaNhanVien(),
									nv1.getHoTen(),
									nv1.getGioiTinh(),
									nv1.getSdt(),
									nv1.getNgaySinh(),
									nv1.getDiaChi(),
									nv1.getNgayBatDau(),
									nv1.getHeSoluong(),
									nv1.getDonViCongTac(),
									nv1.getChucVu()
									
							});
						}else {
							return;
						}
		
	}
	//Đọc Dữ liệu vào theo tên
	public void Doculieuvaotabel2(String ten){
		
			ArrayList<NhanVienHanhChinh> list = nv_Dao.getnhanvienten(ten);
						if(list != null) {
							for (NhanVienHanhChinh nv2 :list) {		
								model.addRow(new Object[] {
										nv2.getMaNhanVien(),
										nv2.getHoTen(),
										nv2.getGioiTinh(),
										nv2.getSdt(),
										nv2.getNgaySinh(),
										nv2.getDiaChi(),
										nv2.getNgayBatDau(),
										nv2.getHeSoluong(),
										nv2.getDonViCongTac(),
										nv2.getChucVu()
								});			
							}
						}else {
								return;
						}
													
	}
			
						

	//Đọc Dữ liệu vào theo sdt
	public void Doculieuvaotabel3(String sdt){
		
			NhanVienHanhChinh nv3 = nv_Dao.getnhanviensdt(sdt);
			if(nv3 != null) {
						model.addRow(new Object[] {
								nv3.getMaNhanVien(),
								nv3.getHoTen(),
								nv3.getGioiTinh(),
								nv3.getSdt(),
								nv3.getNgaySinh(),
								nv3.getDiaChi(),
								nv3.getNgayBatDau(),
								nv3.getHeSoluong(),
								nv3.getDonViCongTac(),
								nv3.getChucVu()
								
						});
			}else {
				return;
			}
		
					

}
	private NhanVienHanhChinh suakh()  {
		int row = table.getSelectedRow();
		try {
			if(kiemtra()) {
				String maKhachHang = txtMa.getText();
				String hoTen = txtHoTen.getText();
				String gioiTinh = checkGioiTinh.isSelected()? "Nam": "Nữ";
				String sDT = txtSDT.getText();
				java.sql.Date ngaysinh = (java.sql.Date) datePickerImplNgaySinh.getModel().getValue();
				String diaChi = txtDiaChi.getText();
				java.sql.Date ngaybatdau = (java.sql.Date) datePickerImplNgayBatDau.getModel().getValue();
				
				if(ngaysinh==null)
					ngaysinh = (Date) table.getValueAt(row, 4);
				if (ngaybatdau==null)
					ngaybatdau = (Date) table.getValueAt(row, 6);
				
				double heSoLuong = Double.parseDouble(txtHesoLuong.getText());
				String donViCongTac = txtDVCongTac1.getText();
				String chucvu = txtChucVu.getText();
				return new NhanVienHanhChinh(maKhachHang,hoTen,gioiTinh,sDT,ngaysinh,diaChi,ngaybatdau,heSoLuong,donViCongTac,chucvu);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private boolean kiemtra() {
		String ma = txtMa.getText().trim();
		String hoten = txtHoTen.getText().trim();
		String sdt =  txtSDT.getText().trim();
		String diachi =  txtDiaChi.getText().trim();
		String hsluong = txtHesoLuong.getText().trim();
		String donVicongtac=  txtDVCongTac1.getText().trim();
		String chucvu = txtChucVu.getText().trim();
		
		
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
		if (!(diachi.length() > 0 && diachi.matches("[/A-Za-z0-9*a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\\\.,'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this,"Chú ý: Nhập địa chỉ sai cú pháp! (không được nhập kĩ tự đặc biệt!)");
			return false;
		}
		
		
		if (!(hsluong.length() > 0 && hsluong.matches("[0-9.]{3,10}$"))) {
			JOptionPane.showMessageDialog(this,"Chú ý: Nhập lương sai!(Phải nhập số và dưới 10 kí tự)");
			return false;
		}
		if (!(donVicongtac.length() > 0 && donVicongtac.matches("[A-Za-z0-9*a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\\\.,'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this,"Chú ý: Nhập Đơn vị công tác sai! (Không nhập kí tự đặc biệt!)");
			return false;
		}
		if (!(chucvu.length() > 0 && chucvu.matches("[A-Za-z0-9*a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\\\.,'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this,"Chú ý: Nhập chức vụ sai! (Không nhập kí tự đặc biệt!)");
			return false;
		}
		return true;
	}
}

package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import dao.DAO_CaLam;
import dao.DAO_CongNhan;
import entity.CaLam;
import entity.CongNhan;
import entity.SanPham;
import java.awt.Toolkit;

public class GUI_ChamCongCongNhan extends JFrame implements ActionListener,MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	private DAO_CaLam dao_CaLam = new DAO_CaLam();
	private DAO_CongNhan dao_CongNhan= new DAO_CongNhan();	
	
	private JTable table;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private DefaultTableModel model2;
	private JTextField textField_MaPhieu;
	private JTextField textField_MaNVTao;
	private JTextField textField_SoLuongSP;
	private JTable table_1;
	private JTextField textField_TimKiemCaLam;
	private JTextField textField_TimKiemCongNhan;
	private JTextField textField_MaCN;
	private JTextField textField_NgayTao;
	private JTextField textField_MaSP;
	private JTable table_2;
	private JTextField textField_TimKiemSP;
	private JPanel panel,panel_1,panel_2,panel_3;
	private JButton btnTimKiemCongNhan,btnSapXepCN,btnTimKiemSP,btnSapXepSP,btnTimKiemCaLam,btnSapXepCaLam,btnTaiLaiCaLam,btnTaoPhieuMoi,btnXoa,btnSuaPhieu,btnLuu;
	private JCheckBox cbNgayCN;
	private JComboBox<String> comboBox_SapXepSP,comboBox_SapXepCN,comboBox_SapXepCaLam,comboBox_CaLam;
	private JButton btnThem,btnTaiLaiSP,btnTaiLaiCN;
	private JButton btnLamRong;
	private JButton btnThoat;
	private JDatePickerImpl datePickerImpl;
	private JLabel lblNhanVienDangNhap;
	private SqlDateModel modelNgayLam;
	public static void main(String[] args) {
		
		//System.out.print();;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ChamCongCongNhan frame = new GUI_ChamCongCongNhan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public GUI_ChamCongCongNhan() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\vanlo\\Downloads\\BaiTapLonPT\\QuanLyLinhKien\\image\\Clear-icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 650);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 204, 51), new Color(0, 153, 153), new Color(0, 102, 204), new Color(0, 255, 255)));
		panel.setBounds(7, 10, 1330, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Chấm Công Công Nhân");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 38));
		lblNewLabel.setBounds(10, 0, 595, 46);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_9 = new JLabel("Mã nhân viên:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(1048, 25, 125, 14);
		panel.add(lblNewLabel_9);
		
		lblNhanVienDangNhap = new JLabel();
		lblNhanVienDangNhap.setToolTipText("Mã nhân viên đang đăng nhập");
		lblNhanVienDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNhanVienDangNhap.setBounds(1203, 27, 117, 14);
		panel.add(lblNhanVienDangNhap);
		lblNhanVienDangNhap.setText(GUI_DangNhap.getDnma());
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(7, 339, 1330, 235);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 50, 394, 135);
		panel_1.add(scrollPane);
		
		model = new DefaultTableModel() {
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
				default:
					return String.class;
				}
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			
		};
		table = new JTable(model);
		model.addColumn("STT");
		model.addColumn("Mã Công Nhân");
		model.addColumn("Họ Tên");
		model.addColumn("Giới Tính");
		table.setForeground(Color.BLACK);
		table.getColumnModel().getColumn(0).setPreferredWidth(4);

		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Thông Tin Ca Làm");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setForeground(new Color(51, 51, 204));
		lblNewLabel_3.setBounds(0, 0, 348, 22);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày tạo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(670, 139, 61, 17);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mã Nhân Viên Tạo:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(670, 178, 97, 17);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mã phiếu:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6.setBounds(417, 50, 61, 17);
		panel_1.add(lblNewLabel_6);
		
		textField_TimKiemCongNhan = new JTextField();
		textField_TimKiemCongNhan.setToolTipText("Nhập vào thông tin công nhân càn tìm");
		textField_TimKiemCongNhan.setBounds(0, 24, 190, 23);
		panel_1.add(textField_TimKiemCongNhan);
		textField_TimKiemCongNhan.setColumns(10);
		
		btnTimKiemCongNhan = new JButton("Tìm Kiếm");
		btnTimKiemCongNhan.setToolTipText("Tìm kiếm theo thông tin đã nhập");
		btnTimKiemCongNhan.setBounds(194, 23, 97, 25);
		panel_1.add(btnTimKiemCongNhan);
		
		comboBox_SapXepCN = new JComboBox<String>();
		comboBox_SapXepCN.setToolTipText("Chọn loại sắp xếp hiển thị bảng ca làm");
		comboBox_SapXepCN.setModel(new DefaultComboBoxModel<String>(new String[] {"Sắp xếp theo mã", "Sắp xếp theo tên"}));
		comboBox_SapXepCN.setBounds(7, 192, 284, 22);
		panel_1.add(comboBox_SapXepCN);
		
		btnSapXepCN = new JButton("Sắp Xếp");
		btnSapXepCN.setToolTipText("Sắp xếp theo loại đã chon");
		btnSapXepCN.setBounds(298, 191, 96, 25);
		panel_1.add(btnSapXepCN);
		
		comboBox_CaLam = new JComboBox<String>();
		comboBox_CaLam.setFont(new Font("Tahoma", Font.PLAIN, 10));
		//comboBox_CaLam.setModel(new DefaultComboBoxModel(new String[] {"Ca 1", "Ca 2", "Ca 3"}));
		comboBox_CaLam.setBounds(597, 175, 50, 22);
		panel_1.add(comboBox_CaLam);
		
		JLabel lblNewLabel_7 = new JLabel("Ca làm:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_7.setBounds(521, 178, 66, 17);
		panel_1.add(lblNewLabel_7);
		
		textField_MaPhieu = new JTextField();
		textField_MaPhieu.setEditable(false);
		textField_MaPhieu.setBounds(521, 48, 126, 23);
		panel_1.add(textField_MaPhieu);
		textField_MaPhieu.setColumns(10);
		
		textField_SoLuongSP = new JTextField();
		textField_SoLuongSP.setEditable(false);
		textField_SoLuongSP.setBounds(521, 137, 126, 23);
		panel_1.add(textField_SoLuongSP);
		textField_SoLuongSP.setColumns(10);
		
		textField_MaNVTao = new JTextField();
		textField_MaNVTao.setEditable(false);
		textField_MaNVTao.setBounds(767, 175, 126, 23);
		panel_1.add(textField_MaNVTao);
		textField_MaNVTao.setColumns(10);
		
		cbNgayCN = new JCheckBox("Ngày Chủ Nhật");
		cbNgayCN.setEnabled(false);
		cbNgayCN.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cbNgayCN.setBounds(417, 178, 98, 17);
		panel_1.add(cbNgayCN);
		
		textField_MaCN = new JTextField();
		textField_MaCN.setEditable(false);
		textField_MaCN.setBounds(521, 92, 126, 23);
		panel_1.add(textField_MaCN);
		textField_MaCN.setColumns(10);
		
		textField_NgayTao = new JTextField();
		textField_NgayTao.setEditable(false);
		textField_NgayTao.setBounds(767, 137, 126, 23);
		panel_1.add(textField_NgayTao);
		textField_NgayTao.setColumns(10);
		
		textField_MaSP = new JTextField();
		textField_MaSP.setEditable(false);
		textField_MaSP.setBounds(767, 92, 126, 23);
		panel_1.add(textField_MaSP);
		textField_MaSP.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Công Nhân:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(417, 91, 77, 23);
		panel_1.add(lblNewLabel_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(929, 50, 394, 135);
		panel_1.add(scrollPane_2);
		
		
		model2 = new DefaultTableModel() {
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
				default:
					return String.class;
				}
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false,false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			
		};
		table_2 = new JTable(model2);
		model2.addColumn("STT");
		model2.addColumn("Mã Sản Phẩm");
		model2.addColumn("Tên Sản Phẩm");
		model2.addColumn("Loại Sản Phẩm");
		table_2.getColumnModel().getColumn(0).setPreferredWidth(4);

		scrollPane_2.setViewportView(table_2);
		
		JLabel lblNewLabel_8 = new JLabel("Số Lượng Sản Phẩm:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_8.setBounds(417, 139, 97, 16);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_ = new JLabel("Mã Sản Phẩm:");
		lblNewLabel_.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_.setBounds(670, 92, 90, 24);
		panel_1.add(lblNewLabel_);
		
		textField_TimKiemSP = new JTextField();
		textField_TimKiemSP.setToolTipText("Nhập vào thông tin sản phẩm cần tìm");
		textField_TimKiemSP.setColumns(10);
		textField_TimKiemSP.setBounds(929, 24, 202, 23);
		panel_1.add(textField_TimKiemSP);
		
		btnTimKiemSP = new JButton("Tìm Kiếm");
		btnTimKiemSP.setToolTipText("Tìm kiếm sản phẩm theo thông tin đã nhập");
		btnTimKiemSP.setBounds(1139, 23, 90, 25);
		panel_1.add(btnTimKiemSP);
		
		btnSapXepSP = new JButton("Sắp Xếp");
		btnSapXepSP.setBounds(1226, 191, 96, 25);
		panel_1.add(btnSapXepSP);
		
		comboBox_SapXepSP = new JComboBox<String>();
		comboBox_SapXepSP.setModel(new DefaultComboBoxModel<String>(new String[] {"Sắp xếp theo mã", "Sắp xếp theo tên"}));
		comboBox_SapXepSP.setBounds(929, 192, 284, 22);
		panel_1.add(comboBox_SapXepSP);
		
		JLabel lblNgayLam = new JLabel("Ngày Làm:");
		lblNgayLam.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNgayLam.setBounds(670, 50, 61, 17);
		panel_1.add(lblNgayLam);
		
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		modelNgayLam = new SqlDateModel(date);
		Properties p =  new Properties();
		p.put("text.date", "date");
		p.put("text.month", "month");
		p.put("text.year", "year");
		JDatePanelImpl impl = new JDatePanelImpl(modelNgayLam, p);
		datePickerImpl = new JDatePickerImpl(impl, new AbstractFormatter() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public String valueToString(Object value) throws ParseException {
				if(value != null) {
					Calendar cal = (Calendar) value;
					SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
					String strDate = format.format(cal.getTime());
					return strDate;
				}
				return "";
			}
			public Object stringToValue(String text) throws ParseException {
				// TODO Auto-generated method stub
				return null;
			}
		});
		datePickerImpl.setBounds(767, 50, 126, 23);
		panel_1.add(datePickerImpl);
		
		
		panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(7, 67, 1330, 264);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setToolTipText("Bảng ca làm");
		scrollPane_1.setBounds(0, 51, 1330, 202);
		panel_2.add(scrollPane_1);
		
		model1 = new DefaultTableModel() {
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
					return Boolean.class;
				case 7:
					return String.class;
				case 8:
					return String.class;
				case 9:
					return String.class;
				default:
					return String.class;
				}
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			
		};
		table_1 = new JTable(model1);
		model1.addColumn("STT");
		model1.addColumn("Mã Ca Làm");
		model1.addColumn("Mã Công Nhân");
		model1.addColumn("Mã Sản Phẩm");
		model1.addColumn("Số Lượng Sản Phẩm");
		model1.addColumn("Loại Ca Làm");
		model1.addColumn("Ngày Chủ Nhật");
		model1.addColumn("Ngày Làm");
		model1.addColumn("Mã Người Tạo");
		model1.addColumn("Ngày Tạo");
		table_1.getColumnModel().getColumn(0).setPreferredWidth(4);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("Ca Làm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(51, 51, 204));
		lblNewLabel_1.setBounds(14, 0, 128, 17);
		panel_2.add(lblNewLabel_1);
		
		textField_TimKiemCaLam = new JTextField();
		textField_TimKiemCaLam.setToolTipText("Nhập vào thông tin ca làm cần tìm kiếm");
		textField_TimKiemCaLam.setBounds(0, 24, 270, 23);
		panel_2.add(textField_TimKiemCaLam);
		textField_TimKiemCaLam.setColumns(10);
		
		btnTimKiemCaLam = new JButton("Tìm kiếm");
		btnTimKiemCaLam.setToolTipText("Tìm kiếm theo thông tin ca làm đã nhập");
		btnTimKiemCaLam.setBounds(275, 23, 105, 25);
		panel_2.add(btnTimKiemCaLam);
		
		comboBox_SapXepCaLam = new JComboBox<String>();
		comboBox_SapXepCaLam.setToolTipText("Chọn loại sắp xếp hiển thị bảng ca làm");
		comboBox_SapXepCaLam.setModel(new DefaultComboBoxModel<String>(new String[] {"Sắp xếp theo mã ca làm", "Sắp xếp theo công nhân", 
		"Sắp xếp theo người tạo", "Sắp xếp theo ngày tạo","Sắp xếp theo sản phẩm","Sắp xếp theo ngày làm","Sắp xếp theo này Chủ nhật"}));
		comboBox_SapXepCaLam.setBounds(459, 23, 192, 25);
		panel_2.add(comboBox_SapXepCaLam);
		
		btnSapXepCaLam = new JButton("Sắp Xếp");
		btnSapXepCaLam.setToolTipText("Sắp xếp theo loại đã chọn");
		btnSapXepCaLam.setBounds(655, 23, 105, 25);
		panel_2.add(btnSapXepCaLam);
		
		btnTaiLaiCN = new JButton("Tải Lại");
		btnTaiLaiCN.setToolTipText("Tải lại nội dung thông tin ca ");
		btnTaiLaiCN.setBounds(297, 24, 97, 25);
		panel_1.add(btnTaiLaiCN);
		
		btnTaiLaiSP = new JButton("Tải Lại");
		btnTaiLaiSP.setToolTipText("Tải lại nôi dung bảng sản phẩm");
		btnTaiLaiSP.setBounds(1233, 23, 90, 25);
		panel_1.add(btnTaiLaiSP);
		
		
		btnTaiLaiCaLam = new JButton("Tải Lại");
		btnTaiLaiCaLam.setToolTipText("Tải lại nội dung bảng ca làm");
		btnTaiLaiCaLam.setBounds(802, 24, 88, 25);
		panel_2.add(btnTaiLaiCaLam);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBounds(7, 578, 1330, 35);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		btnTaoPhieuMoi = new JButton("Tạo Phiếu Mới");
		btnTaoPhieuMoi.setToolTipText("Tạo phiếu ca làm mới");
		btnTaoPhieuMoi.setBackground(SystemColor.inactiveCaptionBorder);
		btnTaoPhieuMoi.setBounds(384, 0, 156, 30);
		
		btnThem = new JButton("Thêm ");
		btnThem.setBackground(SystemColor.inactiveCaptionBorder);
		btnThem.setBounds(384, 0, 156, 30);
		
		btnLamRong = new JButton("Làm Rỗng");
		btnLamRong.setBackground(SystemColor.textHighlight);
		btnLamRong.setBounds(573, 0, 156, 30);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.PINK);
		btnThoat.setBounds(769, 0, 156, 30);
		
		
		btnXoa = new JButton("Xóa Phiếu");
		btnXoa.setToolTipText("Xóa phiếu ca làm đã chọn");
		btnXoa.setBackground(Color.PINK);
		btnXoa.setBounds(769, 0, 156, 30);
		
		btnSuaPhieu = new JButton("Sửa Phiếu ");
		btnSuaPhieu.setToolTipText("Sửa đổi thông tin phiếu ca làm");
		btnSuaPhieu.setBackground(SystemColor.textHighlight);
		btnSuaPhieu.setBounds(573, 0, 156, 30);
	
		btnLuu = new JButton("Lưu");
		btnLuu.setBackground(SystemColor.inactiveCaptionBorder);
		btnLuu.setBounds(384, 0, 156, 30);
		
		
		table.addMouseListener(this);
		table_1.addMouseListener(this);
		panel.addMouseListener(this);
		panel_1.addMouseListener(this);
		panel_2.addMouseListener(this);
		panel_3.addMouseListener(this);
		btnTaiLaiCaLam.addActionListener(this);
		btnSapXepCaLam.addActionListener(this);
		btnSapXepCN.addActionListener(this);
		btnSapXepSP.addActionListener(this);
		btnSuaPhieu.addActionListener(this);
		btnTaoPhieuMoi.addActionListener(this);
		btnTimKiemCaLam.addActionListener(this);
		btnTimKiemCongNhan.addActionListener(this);
		btnTimKiemSP.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnLamRong.addActionListener(this);
		btnTaiLaiCN.addActionListener(this);
		btnTaiLaiSP.addActionListener(this);

		
		panel_3.add(btnTaoPhieuMoi);
		panel_3.add(btnXoa);
		panel_3.add(btnSuaPhieu);
		
		table_2.setEnabled(false);
	
		
		docDuLieuDatabaseVaoTable2();
		docDuLieuDatabaseVaoTable1();
		docDuLieuDatabaseVaoTable();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o.equals(btnSapXepCN)) {
			String loai =  comboBox_SapXepCN.getSelectedItem().toString();
			if(loai.equals("Sắp xếp theo mã")) {
				xoaHetDuLieuTrenTableModel();
				docDuLieuDatabaseVaoTable();
			}
			if(loai.equals("Sắp xếp theo tên")) {
				xoaHetDuLieuTrenTableModel();
				docDuLieuDatabaseVaoTableTheoTen();
			}
			
		}
		if(o.equals(btnSapXepSP)) {
			String loai =  comboBox_SapXepSP.getSelectedItem().toString();
			if(loai.equals("Sắp xếp theo mã")) {
				xoaHetDuLieuTrenTableModel_2();
				docDuLieuDatabaseVaoTable2();
			}
			if(loai.equals("Sắp xếp theo tên")) {
				xoaHetDuLieuTrenTableModel_2();
				docDuLieuDatabaseVaoTable2TheoTen();
			}
			
		}
		if(o.equals(btnTimKiemCaLam)) {
			String str = textField_TimKiemCaLam.getText();
			xoaHetDuLieuTrenTableMode_1();
			try {
				int stt=1;
				List<CaLam> list =  dao_CaLam.getAllCaLam();
				for (CaLam cl : list) {
					String str2 = cl.getLoaiCaLam()+cl.getMaCaLam()+cl.getMaCongNhan()+cl.getMaNguoiTao()+cl.getSoLuongSP()+cl.isNgayCN()+cl.getNgayLam().toString()+cl.getNgayTao().toString();
					if(str2.contains(str)) {
						model1.addRow(new Object[] {
								stt,cl.getMaCaLam(),cl.getMaCongNhan(),cl.getMaSanPham(),Integer.toString(cl.getSoLuongSP()),cl.getLoaiCaLam(),cl.isNgayCN(),cl.getNgayLam(),cl.getMaNguoiTao(),cl.getNgayTao()
						});
						stt++;
					}
					
					}
				}
				catch (Exception t) {
					System.out.println(t);
				}
		}
		if(o.equals(btnTimKiemCongNhan)) {
			String str = textField_TimKiemCongNhan.getText();
			xoaHetDuLieuTrenTableModel();
			try {
				List<CongNhan> list =  dao_CongNhan.getAllCongNhan();
				int stt=1;
				for (CongNhan cn : list) {
					String str2 = cn.getHoTen()+cn.getMaCongNhan()+cn.getGioiTinh();
					if(str2.contains(str)) {
						model.addRow(new Object[] {
								stt,cn.getMaCongNhan(),cn.getHoTen(),cn.getGioiTinh()
						});
						stt++;
						}
					}
				}
				catch (Exception t) {
					System.out.println(t);
				}
					
		}
		if(o.equals(btnTimKiemSP)) {
			String str = textField_TimKiemSP.getText();
			xoaHetDuLieuTrenTableModel_2();
			try {
				int stt=1;
				List<SanPham> list =  dao_CaLam.getAllSanPham();
				for (SanPham sp : list) {
					String str2 = sp.getMaSP()+sp.getTenSP()+sp.getLoaiSP().getMaLoaiSP();
					if(str2.contains(str)) {
						model2.addRow(new Object[] {
								stt,sp.getMaSP(),sp.getTenSP(),sp.getLoaiSP().getMaLoaiSP()
						}); 
						stt++;
						}
					}
				}
				catch (Exception t) {
					System.out.println(t);
				}
			
		}
		if(o.equals(btnSapXepCaLam)) {
			String loai =  comboBox_SapXepCaLam.getSelectedItem().toString();
			if(loai.equals("Sắp xếp theo công nhân")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoCN();
			}
			if(loai.equals("Sắp xếp theo mã ca làm")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoCaLam();
			}
			if(loai.equals("Sắp xếp theo người tạo")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoNVTao();
			}
			if(loai.equals("Sắp xếp theo ngày tạo")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoNgayTao();
			}
			if(loai.equals("Sắp xếp theo này Chủ nhật")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoNgayCN();
			}
			if(loai.equals("Sắp xếp theo ngày làm")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoNgayLam();
			}
			if(loai.equals("Sắp xếp theo sản phẩm")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoSP();
			}
		}
		if(o.equals(btnTaiLaiCaLam)) {
			taiLaiBang1();
			
		}
		if(o.equals(btnTaiLaiCN)) {
			taiLaiBang();
			
		}
		if(o.equals(btnTaiLaiSP)) {
			taiLaiBang2();
			
		}
		if(o.equals(btnTaoPhieuMoi)) {
				xoaTrang();
				docNgayTao();
				textField_MaNVTao.setText(GUI_DangNhap.getDnma());
				panel.removeMouseListener(this);
				panel_1.removeMouseListener(this);
				panel_2.removeMouseListener(this);
				panel_3.removeMouseListener(this);
				table_1.removeMouseListener(this);
				table.clearSelection();
				table_1.clearSelection();
				table_2.clearSelection();
				table_2.addMouseListener(this);
				table_2.setEnabled(true);
				table_1.setEnabled(false);
				comboBox_CaLam.addItem("Ca 1");
				comboBox_CaLam.addItem("Ca 2");
				comboBox_CaLam.addItem("Ca 3");
				textField_MaCN.setEditable(true);
				textField_SoLuongSP.setEditable(true);
				cbNgayCN.setEnabled(true);
				panel_3.removeAll();
				panel_3.add(btnThoat);
				panel_3.add(btnLamRong);
				panel_3.add(btnThem);
				taoMaCaLam();
				panel_3.updateUI();

		}
		if(o.equals(btnThoat)) {
			panel.addMouseListener(this);
			panel_1.addMouseListener(this);
			panel_2.addMouseListener(this);
			panel_3.addMouseListener(this);
			table_1.addMouseListener(this);
			panel_3.removeAll();
			panel_3.add(btnTaoPhieuMoi);
			panel_3.add(btnXoa);
			panel_3.add(btnSuaPhieu);
			table_1.setEnabled(true);
			textField_MaCN.setEditable(false);
			textField_MaSP.setEditable(false);
			textField_SoLuongSP.setEditable(false);
			cbNgayCN.setEnabled(false);
			panel_3.updateUI();
		}
		if(o.equals(btnThem)) {
			if(textField_MaCN.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Mã công nhân không được để trống");
			}
			if(textField_MaSP.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Mã sản phẩm không được để trống");
			}
			if(textField_SoLuongSP.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Số lượng sản phẩm không được để trống");
			}
			
			else {
				if(KiemTra()) {
				try {
					Date ngayTao = Date.valueOf(textField_NgayTao.getText());
					java.sql.Date selectedDate = (java.sql.Date) datePickerImpl.getModel().getValue(); ;
					CaLam cl= new CaLam(textField_MaPhieu.getText(),textField_MaCN.getText(),textField_MaSP.getText(),Integer.parseInt(textField_SoLuongSP.getText()),comboBox_CaLam.getSelectedItem().toString(),
					cbNgayCN.isSelected(),selectedDate,textField_MaNVTao.getText(),ngayTao);
					dao_CaLam.create(cl);
					JOptionPane.showMessageDialog(this, "Thêm Thành Công");
					taoMaCaLam();
					taiLaiBang1();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(this,"Sô lượng sản phẩm phải là sso");
				}
					}
			}
		}
		
		
		
		if(o.equals(btnSuaPhieu)) {
			textField_MaNVTao.setText("NV002");
			panel.removeMouseListener(this);
			panel_1.removeMouseListener(this);
			panel_2.removeMouseListener(this);
			panel_3.removeMouseListener(this);
			table_2.addMouseListener(this);
			table.clearSelection();
			table_1.clearSelection();
			table_2.clearSelection();
			table_2.setEnabled(true);
			textField_MaCN.setEditable(true);
			textField_SoLuongSP.setEditable(true);
			cbNgayCN.setEnabled(true);
			panel_3.removeAll();
			panel_3.add(btnThoat);
			panel_3.add(btnLuu);
			panel_3.add(btnLamRong);
			panel_3.updateUI();
			
		}
		
		if(o.equals(btnLuu)) {
			if( textField_MaPhieu.getText().equals(""))

				JOptionPane.showMessageDialog(this, "Hãy chọn phiếu cần sửa");
			else {
			if(KiemTra()) {
					Date ngayTao = Date.valueOf(textField_NgayTao.getText());
					java.sql.Date selectedDate = (java.sql.Date) datePickerImpl.getModel().getValue(); ;
					CaLam cl= new CaLam(textField_MaPhieu.getText(),textField_MaCN.getText(),textField_MaSP.getText(),Integer.parseInt(textField_SoLuongSP.getText()),comboBox_CaLam.getSelectedItem().toString(),
					cbNgayCN.isSelected(),selectedDate,textField_MaNVTao.getText(),ngayTao);
					if(textField_MaCN.getText().equals("")) {
						JOptionPane.showMessageDialog(this, "Mã công nhân không được để trống");
					}
					if(textField_MaSP.getText().equals("")) {
						JOptionPane.showMessageDialog(this, "Mã sản phẩm không được để trống");
					}
					if(textField_SoLuongSP.getText().equals("")) {
						JOptionPane.showMessageDialog(this, "Số lượng sản phẩm không được để trống");
					}
					else if(KiemTra()) {
						int hoinhac = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn sửa ca làm này?","Warnning",JOptionPane.YES_NO_CANCEL_OPTION);
						if(hoinhac == JOptionPane.YES_OPTION) {
							try {
								dao_CaLam.suaCaLam(cl);
								JOptionPane.showMessageDialog(this, "Sửa Thành Công");
								
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							taiLaiBang1();
						}
					  }
			}
			}
		}
		if(o.equals(btnXoa)) {
			if( textField_MaPhieu.getText().equals(""))

				JOptionPane.showMessageDialog(this, "Hãy chọn phiếu cần xóa");
			else {
				int hoinhac = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xóa ca làm này?","Warnning",JOptionPane.YES_NO_CANCEL_OPTION);
				if(hoinhac == JOptionPane.YES_OPTION) {
					try {
							int r= table_1.getSelectedRow();
							model1.removeRow(r); 
							dao_CaLam.xoaCaLam(textField_MaPhieu.getText());
							JOptionPane.showMessageDialog(this, "Xóa Thành Công");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}
			}
			}
		if(o.equals(btnLamRong)) {
			xoaXam();
		}
			
		
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o.equals(table_1)) {
			int row = table_1.getSelectedRow();
			
			textField_MaPhieu.setText(model1.getValueAt(row, 1).toString());
			textField_MaCN.setText(model1.getValueAt(row, 2).toString());
			textField_MaSP.setText(model1.getValueAt(row, 3).toString());
			textField_SoLuongSP.setText(model1.getValueAt(row, 4).toString());
			textField_MaNVTao.setText(model1.getValueAt(row, 8).toString());
			textField_NgayTao.setText(model1.getValueAt(row, 9).toString());
			Date ngayLam = Date.valueOf(model1.getValueAt(row, 7).toString());
			modelNgayLam.setValue(ngayLam);
			cbNgayCN.setSelected(false);
			if(model1.getValueAt(row, 6).toString()=="true") {
				cbNgayCN.setSelected(true);
			}
			comboBox_CaLam.removeAllItems();
			if(model1.getValueAt(row, 5).toString().equals("Ca 1")) {
				comboBox_CaLam.addItem(model1.getValueAt(row, 5).toString());
				comboBox_CaLam.addItem("Ca 2");
				comboBox_CaLam.addItem("Ca 3");
				
			}
			if(model1.getValueAt(row, 5).toString().equals("Ca 2")) {
				comboBox_CaLam.addItem(model1.getValueAt(row, 5).toString());
				comboBox_CaLam.addItem("Ca 1");
				comboBox_CaLam.addItem("Ca 3");
				
			}
			if(model1.getValueAt(row, 5).toString().equals("Ca 3")) {
				comboBox_CaLam.addItem(model1.getValueAt(row, 5).toString());
				comboBox_CaLam.addItem("Ca 1");
				comboBox_CaLam.addItem("Ca 2");
				
			}
			
		}
		
		
		if(o.equals(table)) {	
			int row = table.getSelectedRow();
			textField_MaCN.setText(model.getValueAt(row, 1).toString());
			xoaHetDuLieuTrenTableMode_1();
			docCaLamTheoCN(model.getValueAt(row, 1).toString());
			
		}
		if(o.equals(table_2)) {
			int row = table_2.getSelectedRow();
			textField_MaSP.setText(model2.getValueAt(row, 1).toString());
		}
		if(o.equals(panel_2)||o.equals(panel)||o.equals(panel_1)||o.equals(panel_3)) {
			xoaTrang();
			table.clearSelection();
			table_1.clearSelection();
			table_2.clearSelection();
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
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	// Doc
	
	public void docNgayTao() {
		try {
			long millis=System.currentTimeMillis();  
			java.sql.Date date=new java.sql.Date(millis);  
				textField_NgayTao.setText(date.toString());
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
	public void docCaLamTheoCN(String ma) {
		try {
		List<CaLam> list =  dao_CaLam.getCaLamTheoMa(ma);
		int stt=1;
		for (CaLam cl : list) {
			model1.addRow(new Object[] {
					stt,cl.getMaCaLam(),cl.getMaCongNhan(),cl.getMaSanPham(),Integer.toString(cl.getSoLuongSP()),cl.getLoaiCaLam(),cl.isNgayCN(),cl.getNgayLam(),cl.getMaNguoiTao(),cl.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
	public void docDuLieuDatabaseVaoTable1() {
		try {
		int stt=1;
		List<CaLam> list =  dao_CaLam.getAllCaLam();
		for (CaLam cl : list) {
			model1.addRow(new Object[] {
					stt,cl.getMaCaLam(),cl.getMaCongNhan(),cl.getMaSanPham(),Integer.toString(cl.getSoLuongSP()),cl.getLoaiCaLam(),cl.isNgayCN(),cl.getNgayLam(),cl.getMaNguoiTao(),cl.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	/// Sắp xếp
	
	public void docDuLieuDatabaseVaoTable1TheoCN() {
		try {
		int stt=1;
		List<CaLam> list =  dao_CaLam.getAllCaLamTheoCN();
		for (CaLam cl : list) {
			model1.addRow(new Object[] {
					stt,cl.getMaCaLam(),cl.getMaCongNhan(),cl.getMaSanPham(),Integer.toString(cl.getSoLuongSP()),cl.getLoaiCaLam(),cl.isNgayCN(),cl.getNgayLam(),cl.getMaNguoiTao(),cl.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void docDuLieuDatabaseVaoTable1TheoNgayLam() {
		try {
		int stt=1;
		List<CaLam> list =  dao_CaLam.getAllCaLamTheoNgayLam();
		for (CaLam cl : list) {
			model1.addRow(new Object[] {
					stt,cl.getMaCaLam(),cl.getMaCongNhan(),cl.getMaSanPham(),Integer.toString(cl.getSoLuongSP()),cl.getLoaiCaLam(),cl.isNgayCN(),cl.getNgayLam(),cl.getMaNguoiTao(),cl.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void docDuLieuDatabaseVaoTable1TheoCaLam() {
		try {
		int stt=1;
		List<CaLam> list =  dao_CaLam.getAllCaLamTheoCaLam();
		for (CaLam cl : list) {
			model1.addRow(new Object[] {
					stt,cl.getMaCaLam(),cl.getMaCongNhan(),cl.getMaSanPham(),Integer.toString(cl.getSoLuongSP()),cl.getLoaiCaLam(),cl.isNgayCN(),cl.getNgayLam(),cl.getMaNguoiTao(),cl.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
	public void docDuLieuDatabaseVaoTable1TheoNgayTao() {
		try {
		int stt=1;
		List<CaLam> list =  dao_CaLam.getAllCaLamTheoNgayTao();
		for (CaLam cl : list) {
			model1.addRow(new Object[] {
					stt,cl.getMaCaLam(),cl.getMaCongNhan(),cl.getMaSanPham(),Integer.toString(cl.getSoLuongSP()),cl.getLoaiCaLam(),cl.isNgayCN(),cl.getNgayLam(),cl.getMaNguoiTao(),cl.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void docDuLieuDatabaseVaoTable1TheoNVTao() {
		try {
		int stt=1;
		List<CaLam> list =  dao_CaLam.getAllCaLamTheoNVTao();
		for (CaLam cl : list) {
			model1.addRow(new Object[] {
					stt,cl.getMaCaLam(),cl.getMaCongNhan(),cl.getMaSanPham(),Integer.toString(cl.getSoLuongSP()),cl.getLoaiCaLam(),cl.isNgayCN(),cl.getNgayLam(),cl.getMaNguoiTao(),cl.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void docDuLieuDatabaseVaoTable1TheoSP() {
		try {
		int stt=1;
		List<CaLam> list =  dao_CaLam.getAllCaLamTheoSP();
		for (CaLam cl : list) {
			model1.addRow(new Object[] {
					stt,cl.getMaCaLam(),cl.getMaCongNhan(),cl.getMaSanPham(),Integer.toString(cl.getSoLuongSP()),cl.getLoaiCaLam(),cl.isNgayCN(),cl.getNgayLam(),cl.getMaNguoiTao(),cl.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTable1TheoNgayCN() {
		try {
		int stt=1;
		List<CaLam> list =  dao_CaLam.getAllCaLamTheoNgayCN();
		for (CaLam cl : list) {
			model1.addRow(new Object[] {
					stt,cl.getMaCaLam(),cl.getMaCongNhan(),cl.getMaSanPham(),Integer.toString(cl.getSoLuongSP()),cl.getLoaiCaLam(),cl.isNgayCN(),cl.getNgayLam(),cl.getMaNguoiTao(),cl.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
	
	
	
	
	
	
	
	public void docDuLieuDatabaseVaoTable() {
		try {
		List<CongNhan> list =  dao_CongNhan.getAllCongNhan();
		int stt=1;
		for (CongNhan cn : list) {
			model.addRow(new Object[] {
					stt,cn.getMaCongNhan(),cn.getHoTen(),cn.getGioiTinh()
			});
			stt++;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTableTheoTen() {
		try {
		List<CongNhan> list =  dao_CongNhan.getAllCongNhanTheoTen();
		int stt=1;
		for (CongNhan cn : list) {
			model.addRow(new Object[] {
					stt,cn.getMaCongNhan(),cn.getHoTen(),cn.getGioiTinh()
			});
			stt++;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void docDuLieuDatabaseVaoTable2() {
		try {
		int stt=1;
		List<SanPham> list =  dao_CaLam.getAllSanPham();
		for (SanPham sp : list) {
			model2.addRow(new Object[] {
					stt,sp.getMaSP(),sp.getTenSP(),sp.getLoaiSP().getMaLoaiSP()
			}); 
			stt++;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTable2TheoTen() {
		try {
		int stt=1;
		List<SanPham> list =  dao_CaLam.getAllSanPhamTheoTen();
		for (SanPham sp : list) {
			model2.addRow(new Object[] {
					stt,sp.getMaSP(),sp.getTenSP(),sp.getLoaiSP().getMaLoaiSP()
			}); 
			stt++;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// Xóa
	public void xoaTrang(){
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		textField_NgayTao.setText(date.toString());
		textField_MaNVTao.setText("");
		textField_MaCN.setText("");
		textField_MaSP.setText("");
		textField_SoLuongSP.setText("");
		textField_MaPhieu.setText("");
		textField_NgayTao.setText("");
		comboBox_CaLam.removeAllItems();
		cbNgayCN.setSelected(false);
		
		
	}
	
	public void xoaXam(){
		textField_MaCN.setText("");
		textField_MaSP.setText("");
		textField_SoLuongSP.setText("");	
		cbNgayCN.setSelected(false);
	}
	
	
	private void xoaHetDuLieuTrenTableMode_1() {
		DefaultTableModel dm = (DefaultTableModel) table_1.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();

		}
	private void xoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();

		}
	private void xoaHetDuLieuTrenTableModel_2() {
		DefaultTableModel dm = (DefaultTableModel) table_2.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();

		}
	
	private boolean KiemTra() {
		String ma=textField_MaCN.getText().trim();
	//	String slsp =textField_SoLuongSP.getText().trim();
		
		try {
			int sl = Integer.parseInt(textField_SoLuongSP.getText());
			if(sl<1) {
				JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải lớn hơn 0");
				return false;
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this,"Sô lượng sản phẩm phải là số");
			return false;
		}
		if(!(ma.matches("[C][N][0-9]+"))) {
			JOptionPane.showMessageDialog(this, "Nhập lại mã công nhân Theo Mẫu CN + Số Bất Kỳ VD:CN001");
			return false;
		}
		
		
		return true;
	}
	private void taoMaCaLam() {
		String ma= dao_CaLam.getMaLonNhat();
		int maMoi;
		maMoi =Integer.parseInt(ma.substring(2, 6)) + 1;
		if(maMoi<10000) {
			textField_MaPhieu.setText("CL"+maMoi);
		}
		if(maMoi<1000) {
			textField_MaPhieu.setText("CL0"+maMoi);
		}
		if(maMoi<100) {
			textField_MaPhieu.setText("CL00"+maMoi);
		}
		if(maMoi<10) {
			textField_MaPhieu.setText("CL000"+maMoi);
		}
		
		
		
	}
	
	private void taiLaiBang1(){
		xoaHetDuLieuTrenTableMode_1();
		docDuLieuDatabaseVaoTable1();
	}
	private void taiLaiBang(){
		xoaHetDuLieuTrenTableModel();
		docDuLieuDatabaseVaoTable();
	}
	private void taiLaiBang2(){
		xoaHetDuLieuTrenTableModel_2();
		docDuLieuDatabaseVaoTable2();
	}
}


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
import javax.swing.table.DefaultTableModel;


import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import dao.DAO_NgayNghi;
import dao.DAO_NhanVienHanhChinh;
import dao.DAO_TangCa;
import entity.NgayNghi;
import entity.NhanVienHanhChinh;
import entity.TangCa;

import javax.swing.JTextPane;
import javax.swing.JCheckBox;

public class GUI_ChamCongNhanVien extends JFrame  implements ActionListener,MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private DAO_TangCa dao_TangCa= new DAO_TangCa();
	private DAO_NgayNghi dao_NgayNghi= new DAO_NgayNghi();
	private DAO_NhanVienHanhChinh dao_NhanVien= new DAO_NhanVienHanhChinh();
	
	
	private JTable table;
	private DefaultTableModel model;
	private DefaultTableModel model1,model2;
	private String[]  cols={"STT","M\u00E3 T\u0103ng Ca", "M\u00E3 Nh\u00E2n Vi\u00EAn", "Ng\u00E0y T\u0103ng Ca", "S\u1ED1 Gi\u1EDD", "M\u00E3 Ng\u01B0\u1EDDi T\u1EA1o", "Ng\u00E0y T\u1EA1o"};
	private JTextField textField_NgayTao;
	private JTextField textField_SoGio;
	private JTable table_1;
	private JTextField textField_TimKiemNN;
	private JTextField textField_TimKiemTC;
	private JTextField textField_MaNVTaoTC;
	private JTextField textField_MaNVTC;
	private JTextField textField_MaTC;
	private JTextField textField_MaNVNN;
	private JTextField textField_MaNguoiTaoNN;
	private JTextField textField_NgayTaoNN;
	private JTextField textField_MaNN;
	private JTextPane textPane_LyDo;
	private JTable table_2;
	private JButton btnTimKiemTC,btnTimKiemNN,btnSuaNN,btnTaoMoiNN,btnXoaNN,btnTaoMoiTC,
	btnSuaTC,btnXoaTC,btnSapXepNN,btnTaiLaiNN,btnTaiLaiTC,btnSapXepTC,btnLuuNN,btnLuuTC ,btnTaiLaiNhanVien;
	private JComboBox<String> comboBox_SapXepTC,comboBoxSapXepNN,comboBox_SapXepNV;
	private JCheckBox cbTroCap;
	private JLabel lblNewLabel_6_7;
	JDatePickerImpl ngayTangCa,ngayNghi,ngayHetNghi;
	SqlDateModel modelNgayTC,modelNgayNghi,modelNgayHetNghi;
	private JTextField textTimKiemNV;
	private JPanel panel_5,panel_3,panel_2,panel_1,panel;
	private JButton btnXoaRongTC;
	private JButton btnThoatTC;
	private JButton btnThemTC;
	private JButton btnThemNN;
	private JButton btnXoaRongNN;
	private JButton btnThoatNN,btnTimKiemNV,btnSapXepNV,btnTaiLaiNV;
	private JLabel lblNewLabel_7;
	private JLabel lbNVDN;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ChamCongNhanVien frame = new GUI_ChamCongNhanVien();
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
	public GUI_ChamCongNhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 650);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(14, 10, 1323, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Chấm Công Nhân Viên");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 38));
		lblNewLabel.setBounds(0, 0, 595, 46);
		panel.add(lblNewLabel);
		
		lblNewLabel_7 = new JLabel("Mã nhân viên:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(981, 27, 120, 14);
		panel.add(lblNewLabel_7);
		
		lbNVDN = new JLabel("");
		lbNVDN.setToolTipText("Mã nhân viên đang đăng nhập");
		lbNVDN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbNVDN.setBounds(1180, 27, 120, 14);
		lbNVDN.setText(GUI_DangNhap.getDnma());
		panel.add(lbNVDN);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(7, 67, 660, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Bảng tăng ca");
		scrollPane.setBounds(0, 50, 653, 240);
		panel_1.add(scrollPane);
		
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Tăng Ca");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setForeground(new Color(51, 51, 204));
		lblNewLabel_3.setBounds(7, 0, 341, 22);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày tạo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(418, 329, 90, 24);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mã Nhân Viên Tạo:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(196, 333, 97, 17);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mã Tăng Ca:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6.setBounds(10, 329, 61, 17);
		panel_1.add(lblNewLabel_6);
		
		textField_TimKiemTC = new JTextField();
		textField_TimKiemTC.setToolTipText("Nhập vào thông tin tăng ca cần tìm");
		textField_TimKiemTC.setBounds(0, 24, 175, 23);
		panel_1.add(textField_TimKiemTC);
		textField_TimKiemTC.setColumns(10);
		
		btnTimKiemTC = new JButton("Tìm Kiếm");
		btnTimKiemTC.setToolTipText("Tìm kiếm phiếu tăng ca theo thông tin đã nhập");
		btnTimKiemTC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiemTC.setBounds(182, 23, 97, 25);
		panel_1.add(btnTimKiemTC);
		
		comboBox_SapXepTC = new JComboBox<String>();
		comboBox_SapXepTC.setToolTipText("Chọn loại sắp xếp hiển thi bảng tăng ca");
		comboBox_SapXepTC.setModel(new DefaultComboBoxModel<String>(new String[] {"Sắp xếp theo mã","Sắp xếp theo tên"}));
		comboBox_SapXepTC.setBounds(286, 24, 176, 22);
		panel_1.add(comboBox_SapXepTC);
		
		btnSapXepTC = new JButton("Sắp Xếp");
		btnSapXepTC.setToolTipText("Sắp xếp theo loại đã chọn");
		btnSapXepTC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSapXepTC.setBounds(469, 23, 96, 25);
		panel_1.add(btnSapXepTC);
		
		textField_SoGio = new JTextField();
		textField_SoGio.setEditable(false);
		textField_SoGio.setBounds(78, 362, 108, 23);
		panel_1.add(textField_SoGio);
		textField_SoGio.setColumns(10);
		
		textField_NgayTao = new JTextField();
		textField_NgayTao.setEditable(false);
		textField_NgayTao.setBounds(523, 329, 126, 23);
		panel_1.add(textField_NgayTao);
		textField_NgayTao.setColumns(10);
		
		textField_MaNVTaoTC = new JTextField();
		textField_MaNVTaoTC.setEditable(false);
		textField_MaNVTaoTC.setBounds(286, 330, 126, 23);
		panel_1.add(textField_MaNVTaoTC);
		textField_MaNVTaoTC.setColumns(10);
		
		textField_MaNVTC = new JTextField();
		textField_MaNVTC.setEditable(false);
		textField_MaNVTC.setBounds(286, 361, 126, 23);
		panel_1.add(textField_MaNVTC);
		textField_MaNVTC.setColumns(10);
		
		textField_MaTC = new JTextField();
		textField_MaTC.setEditable(false);
		textField_MaTC.setBounds(78, 329, 108, 23);
		panel_1.add(textField_MaTC);
		textField_MaTC.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Nhân Viên:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(196, 362, 77, 23);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_8 = new JLabel("Số Giờ:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_8.setBounds(10, 364, 97, 16);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Ngày Tăng Ca:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_9.setBounds(419, 364, 89, 17);
		panel_1.add(lblNewLabel_9);
		
		
//		long millis=System.currentTimeMillis();  
//		java.sql.Date date=new java.sql.Date(millis);  
		modelNgayTC = new SqlDateModel();
		Properties p =  new Properties();
		p.put("text.date", "date");
		p.put("text.month", "month");
		p.put("text.year", "year");
		JDatePanelImpl impl = new JDatePanelImpl(modelNgayTC, p);
		ngayTangCa = new JDatePickerImpl(impl, new AbstractFormatter() {
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
		ngayTangCa.setBounds(523, 359, 126, 23);
		panel_1.add(ngayTangCa);
		
			
		
		btnTaiLaiTC = new JButton("Tải lại");
		btnTaiLaiTC.setToolTipText("Tải lại nội dung bảng tăng ca");
		btnTaiLaiTC.setBounds(573, 23, 80, 25);
		panel_1.add(btnTaiLaiTC);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(674, 67, 663, 413);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setToolTipText("Bảng ngày nghỉ");
		scrollPane_1.setBounds(7, 52, 656, 238);
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
					return Boolean.class;
				case 6:
					return String.class;
				case 7:
					return String.class;
				case 8:
					return String.class;
				default:
					return String.class;
				}
			}
			boolean[] columnEditables = new boolean[] {
					false,false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			
		};
		table_1 = new JTable(model1);
		model1.addColumn("STT");
		model1.addColumn("Mã");
		model1.addColumn("Mã Nhân Viên");
		model1.addColumn("Ngày Nghỉ");
		model1.addColumn("Ngày Kết Thúc");
		model1.addColumn("Trợ Cấp");
		model1.addColumn("Lý Do");
		model1.addColumn("Mã Người Tạo");
		model1.addColumn("Ngày Tạo");
		table_1.getColumnModel().getColumn(0).setPreferredWidth(4);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(45);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(65);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(55);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(65);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(35);
		table_1.getColumnModel().getColumn(7).setPreferredWidth(45);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày Nghỉ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(51, 51, 204));
		lblNewLabel_1.setBounds(10, 7, 128, 17);
		panel_2.add(lblNewLabel_1);
		
		textField_TimKiemNN = new JTextField();
		textField_TimKiemNN.setToolTipText("Nhập vào thông tin phiếu ngày nghỉ cần tìm");
		textField_TimKiemNN.setBounds(7, 24, 175, 23);
		panel_2.add(textField_TimKiemNN);
		textField_TimKiemNN.setColumns(10);
		
		btnTimKiemNN = new JButton("Tìm kiếm");
		btnTimKiemNN.setToolTipText("Tìm kiếm theo thông tin ngày nghỉ đã nhập");
		btnTimKiemNN.setBounds(189, 23, 105, 25);
		panel_2.add(btnTimKiemNN);
		
		comboBoxSapXepNN = new JComboBox<String>();
		comboBoxSapXepNN.setToolTipText("Chọn loại sắp xếp hiển thị phiếu ngày nghỉ");
		comboBoxSapXepNN.setModel(new DefaultComboBoxModel<String>(new String[] {"Sắp xếp theo mã", "Sắp xếp theo nhân viên", "Sắp xếp theo người tạo", "Sắp xếp theo ngày tạo","Sắp xếp theo trợ cấp"}));
		comboBoxSapXepNN.setBounds(307, 23, 150, 25);
		panel_2.add(comboBoxSapXepNN);
		
		btnSapXepNN = new JButton("Sắp Xếp");
		btnSapXepNN.setToolTipText("Sắp xếp theo loại đã chọn");
		btnSapXepNN.setBounds(464, 23, 105, 25);
		panel_2.add(btnSapXepNN);
		
		btnTaiLaiNN = new JButton("Tải lại");
		btnTaiLaiNN.setToolTipText("Tải lại nội dung bẳng ngày nghỉ");
		btnTaiLaiNN.setBounds(575, 23, 80, 25);
		panel_2.add(btnTaiLaiNN);
		
		textField_MaNVNN = new JTextField();
		textField_MaNVNN.setEditable(false);
		textField_MaNVNN.setColumns(10);
		textField_MaNVNN.setBounds(90, 347, 108, 23);
		panel_2.add(textField_MaNVNN);
		

		modelNgayNghi = new SqlDateModel();
		Properties p1 =  new Properties();
		p.put("text.date", "date");
		p.put("text.month", "month");
		p.put("text.year", "year");
		JDatePanelImpl impl1 = new JDatePanelImpl(modelNgayNghi, p1);
		ngayNghi = new JDatePickerImpl(impl1, new AbstractFormatter() {
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
		ngayNghi.setBounds(90, 378, 108, 23);
		panel_2.add(ngayNghi);
		
		textField_MaNguoiTaoNN = new JTextField();
		textField_MaNguoiTaoNN.setEditable(false);
		textField_MaNguoiTaoNN.setColumns(10);
		textField_MaNguoiTaoNN.setBounds(324, 311, 108, 23);
		panel_2.add(textField_MaNguoiTaoNN);
		
		textField_NgayTaoNN = new JTextField();
		textField_NgayTaoNN.setEditable(false);
		textField_NgayTaoNN.setColumns(10);
		textField_NgayTaoNN.setBounds(324, 347, 108, 23);
		panel_2.add(textField_NgayTaoNN);
		
		textPane_LyDo = new JTextPane();
		textPane_LyDo.setEditable(false);
		textPane_LyDo.setBounds(464, 334, 191, 67);
		panel_2.add(textPane_LyDo);
		
		JLabel lblNewLabel_6_1 = new JLabel("Mã Nhân Viên:");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6_1.setBounds(7, 350, 74, 17);
		panel_2.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Ngày Nghỉ:");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6_2.setBounds(7, 381, 61, 17);
		panel_2.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("Mã Người Tạo:");
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6_3.setBounds(232, 314, 82, 17);
		panel_2.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_6_4 = new JLabel("Ngày Tạo:");
		lblNewLabel_6_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6_4.setBounds(232, 350, 61, 17);
		panel_2.add(lblNewLabel_6_4);
		
		JLabel lblNewLabel_6_5 = new JLabel("Lý Do:");
		lblNewLabel_6_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6_5.setBounds(464, 314, 61, 17);
		panel_2.add(lblNewLabel_6_5);
		
		JLabel lblNewLabel_6_6 = new JLabel("Mã Ngày Nghỉ:");
		lblNewLabel_6_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6_6.setBounds(7, 314, 74, 17);
		panel_2.add(lblNewLabel_6_6);
		
		textField_MaNN = new JTextField();
		textField_MaNN.setEditable(false);
		textField_MaNN.setColumns(10);
		textField_MaNN.setBounds(90, 311, 108, 23);
		panel_2.add(textField_MaNN);
		
		cbTroCap = new JCheckBox("Trợ Cấp");
		cbTroCap.setEnabled(false);
		cbTroCap.setBounds(541, 311, 99, 23);
		panel_2.add(cbTroCap);
		
		modelNgayHetNghi = new SqlDateModel();
		Properties p2 =  new Properties();
		p.put("text.date", "date");
		p.put("text.month", "month");
		p.put("text.year", "year");
		JDatePanelImpl impl2 = new JDatePanelImpl(modelNgayHetNghi, p2);
		ngayHetNghi = new JDatePickerImpl(impl2, new AbstractFormatter() {
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
		ngayHetNghi.setBounds(324, 378, 108, 23);
		
		panel_2.add(ngayHetNghi);
		lblNewLabel_6_7 = new JLabel("Ngày Hết Nghỉ:");
		lblNewLabel_6_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6_7.setBounds(232, 378, 82, 17);
		panel_2.add(lblNewLabel_6_7);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBounds(1073, 484, 264, 129);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		btnSuaNN = new JButton("Sửa ");
		btnSuaNN.setToolTipText("Sửa phiếu ngày nghỉ đã chọn");
		btnSuaNN.setBackground(SystemColor.textHighlight);
		btnSuaNN.setBounds(10, 40, 244, 41);
		panel_3.add(btnSuaNN);
		btnXoaNN = new JButton("Xóa");
		btnXoaNN.setToolTipText("Xóa phiếu ngày nghỉ đã chọn");
		btnXoaNN.setBounds(10, 80, 244, 41);
		btnXoaNN.setBackground(Color.PINK);
		panel_3.add(btnXoaNN);
		
		btnLuuNN = new JButton("Lưu");
		btnLuuNN.setBackground(SystemColor.inactiveCaptionBorder);
		btnLuuNN.setBounds(10, 0, 244, 41);
		
		btnTaoMoiNN = new JButton("Tạo Mới");
		btnTaoMoiNN.setToolTipText("Tạo mới phiếu ngày nghỉ");
		btnTaoMoiNN.setBackground(SystemColor.inactiveCaptionBorder);
		btnTaoMoiNN.setBounds(10, 0, 244, 41);
		panel_3.add(btnTaoMoiNN);
		btnTaoMoiNN.addActionListener(this);
		
		btnThemNN = new JButton("Thêm");
		btnThemNN.setBackground(SystemColor.inactiveCaptionBorder);
		btnThemNN.setBounds(10, 0, 244, 41);
		
		btnXoaRongNN = new JButton("Xóa Rỗng");
		btnXoaRongNN.setBackground(SystemColor.textHighlight);
		btnXoaRongNN.setBounds(10, 39, 244, 41);
		
		btnThoatNN = new JButton("Thoát");
		btnThoatNN.setBackground(Color.PINK);
		btnThoatNN.setBounds(10, 77, 244, 41);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBounds(7, 484, 264, 129);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		btnTaoMoiTC = new JButton("Tạo Mới");
		btnTaoMoiTC.setToolTipText("Tạo mới phiếu tăng ca");
		btnTaoMoiTC.setBackground(SystemColor.inactiveCaptionBorder);
		btnTaoMoiTC.setBounds(7, 0, 253, 41);
		panel_5.add(btnTaoMoiTC);
		
		btnSuaTC = new JButton("Sửa");
		btnSuaTC.setToolTipText("Sửa phiếu tăng ca");
		btnSuaTC.setBackground(SystemColor.textHighlight);
		btnSuaTC.setBounds(7, 40, 253, 41);
		panel_5.add(btnSuaTC);
		
		btnXoaTC = new JButton("Xóa");
		btnXoaTC.setToolTipText("Xóa phiếu tăng ca đã chọn");
		btnXoaTC.setBounds(7, 80, 253, 41);
		panel_5.add(btnXoaTC);
		btnXoaTC.addActionListener(this);
		
		btnXoaRongTC = new JButton("Xóa Rỗng");
		btnXoaRongTC.setBackground(SystemColor.textHighlight);
		btnXoaRongTC.setBounds(7, 45, 253, 41);
		
		btnThoatTC = new JButton("Thoát");
		btnThoatTC.setBackground(Color.PINK);
		btnThoatTC.setBounds(7, 83, 253, 41);
		
		btnThemTC = new JButton("Thêm");
		btnThemTC.setBackground(SystemColor.inactiveCaptionBorder);
		btnThemTC.setBounds(7, 7, 253, 41);
		btnXoaTC.setBackground(Color.PINK);
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setToolTipText("Bảng thông tin công nhân");
		scrollPane_2.setBounds(281, 510, 782, 103);
		contentPane.add(scrollPane_2);
		
		
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
				case 4:
					return String.class;
				case 5:
					return String.class;
				default:
					return String.class;
				}
			}
			boolean[] columnEditables = new boolean[] {
					false,false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			
		};
		table_2 = new JTable(model2);
		model2.addColumn("STT");
		model2.addColumn("Mã Nhân Viên");
		model2.addColumn("Họ Tên");
		model2.addColumn("Giới Tính");
		model2.addColumn("Chức Vụ");
		model2.addColumn("Đơn Vị");
		table_2.getColumnModel().getColumn(0).setPreferredWidth(4);
		scrollPane_2.setViewportView(table_2);
		
		btnTaiLaiNV = new JButton("Tải lại");
		btnTaiLaiNV.setBounds(865, 615, 80, 25);
		contentPane.add(btnTaiLaiNV);
		
		comboBox_SapXepNV = new JComboBox<String>();
		comboBox_SapXepNV.setToolTipText("Chọn loại sắp xếp hiển thị bảng công nhân");
		comboBox_SapXepNV.setBounds(674, 484, 184, 22);
		comboBox_SapXepNV.setModel(new DefaultComboBoxModel<String>(new String[] {"Sắp xếp theo mã", "Sắp xếp theo tên", "Sắp xếp theo chức vụ","Sắp xếp theo đơn vị" }));
		contentPane.add(comboBox_SapXepNV);
		
		
		btnSapXepNV = new JButton("Sắp Xếp");
		btnSapXepNV.setToolTipText("Sắp xếp theo loại đã chọn ");
		btnSapXepNV.setBounds(873, 484, 96, 25);
		contentPane.add(btnSapXepNV);
		
		textTimKiemNV = new JTextField();
		textTimKiemNV.setToolTipText("Nhập thông tin công nhân cần tìm");
		textTimKiemNV.setColumns(10);
		textTimKiemNV.setBounds(281, 484, 256, 23);
		contentPane.add(textTimKiemNV);
		
		btnTimKiemNV = new JButton("Tìm Kiếm");
		btnTimKiemNV.setToolTipText("Tìm công nhân theo thông tin đã nhập");
		btnTimKiemNV.setBounds(547, 484, 96, 25);
		contentPane.add(btnTimKiemNV);
		
		btnTaiLaiNhanVien = new JButton("Tải Lại");
		btnTaiLaiNhanVien.setToolTipText("Tải lại nội dung bảng công nhân");
		btnTaiLaiNhanVien.setBounds(979, 484, 81, 25);
		contentPane.add(btnTaiLaiNhanVien);
		btnLuuTC = new JButton("Lưu");
		btnLuuTC.setBounds(7, 7, 253, 41);
		btnLuuTC.setBackground(SystemColor.inactiveCaptionBorder);
		
		
		table.addMouseListener(this);
		table_1.addMouseListener(this);
		table_2.addMouseListener(this);
		panel.addMouseListener(this);
		panel_1.addMouseListener(this);
		panel_2.addMouseListener(this);
		panel_3.addMouseListener(this);
		panel_5.addMouseListener(this);
		btnSapXepTC.addActionListener(this);
		btnSapXepNN.addActionListener(this);
		btnSapXepNV.addActionListener(this);
		btnTimKiemNV.addActionListener(this);
		btnSuaNN.addActionListener(this);
		btnSuaTC.addActionListener(this);
		btnTaiLaiNN.addActionListener(this);
		btnTaiLaiTC.addActionListener(this);
		btnTaoMoiTC.addActionListener(this);
		btnTimKiemNN.addActionListener(this);
		btnTimKiemTC.addActionListener(this);
		btnXoaNN.addActionListener(this);
		btnThemNN.addActionListener(this);
		btnThemTC.addActionListener(this);
		btnXoaRongNN.addActionListener(this);
		btnXoaRongTC.addActionListener(this);
		btnThoatNN.addActionListener(this);
		btnThoatTC.addActionListener(this);
		btnLuuNN.addActionListener(this);
		btnLuuTC.addActionListener(this);
		btnTaiLaiNhanVien.addActionListener(this);
		
		docDuLieuDatabaseVaoTable();
		docDuLieuDatabaseVaoTable1();
		docDuLieuDatabaseVaoTable2();
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnSapXepTC)) {
			String loai =  comboBox_SapXepTC.getSelectedItem().toString();
			if(loai.equals("Sắp xếp theo mã")) {
				xoaHetDuLieuTrenTableMode();
				docDuLieuDatabaseVaoTable();
			}
			if(loai.equals("Sắp xếp theo mã nhân viên")) {
				xoaHetDuLieuTrenTableMode();
				docDuLieuDatabaseVaoTableTheoNV();
			}
			if(loai.equals("Sắp xếp theo người tạo")) {
				xoaHetDuLieuTrenTableMode();
				docDuLieuDatabaseVaoTableTheoNguoiTao();
			}
			if(loai.equals("Sắp xếp theo ngày tạo")) {
				xoaHetDuLieuTrenTableMode();
				docDuLieuDatabaseVaoTableTheoNgayTao();
			}
			if(loai.equals("Sắp xếp theo số giờ")) {
				xoaHetDuLieuTrenTableMode();
				docDuLieuDatabaseVaoTableTheoSoGio();
			}
			
		}
		if(o.equals(btnSapXepNN)) {
			String loai =  comboBoxSapXepNN.getSelectedItem().toString();
			if(loai.equals("Sắp xếp theo mã")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1();
			}
			if(loai.equals("Sắp xếp theo mã nhân viên")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoNV();
			}
			if(loai.equals("Sắp xếp theo người tạo")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoNguoiTao();
			}
			if(loai.equals("Sắp xếp theo ngày tạo")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoNgayTao();
			}
			if(loai.equals("Sắp xếp theo trợ cấp")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoTroCap();
			}
		}
		if(o.equals(btnSapXepNV)) {
			String loai =  comboBox_SapXepNV.getSelectedItem().toString();
			if(loai.equals("Sắp xếp theo mã")) {
				xoaHetDuLieuTrenTableMode_2();
				docDuLieuDatabaseVaoTable2();
			}
			if(loai.equals("Sắp xếp theo tên")) {
				xoaHetDuLieuTrenTableMode_2();
				docDuLieuDatabaseVaoTable2TheoTen();
			}
			if(loai.equals("Sắp xếp theo chức vụ")) {
				xoaHetDuLieuTrenTableMode_2();
				docDuLieuDatabaseVaoTable2TheoCV();
			}
			if(loai.equals("Sắp xếp theo đơn vị")) {
				xoaHetDuLieuTrenTableMode_2();
				docDuLieuDatabaseVaoTable2TheoDV();
			}
			
		}
		
		if(o.equals(btnXoaRongTC)) {
			xoaXamTC();
		}
		if(o.equals(btnXoaRongNN)) {
			xoaXamNN();
		}
		if(o.equals(btnTaiLaiTC)) {
			taiLaiBang();
			
		}
		if(o.equals(btnTaiLaiNN)) {
			taiLaiBang1();
			
		}
		if(o.equals(btnTaiLaiNhanVien)) {
			taiLaiBang2();
			
		}
		if(o.equals(btnTimKiemNV)) {
			String str = textTimKiemNV.getText();
			xoaHetDuLieuTrenTableMode_2();
			List<NhanVienHanhChinh> list =  dao_NhanVien.getAllNhanVienHanhChinh();
			int stt = 1;
			for (NhanVienHanhChinh nv : list) {
				String str2 = nv.getMaNhanVien()+nv.getHoTen()+nv.getChucVu()+nv.getDonViCongTac()+nv.getGioiTinh();
					if(str2.contains(str)) {
					model2.addRow(new Object[] {
							stt,nv.getMaNhanVien(),nv.getHoTen(),nv.getGioiTinh(),nv.getChucVu(),nv.getDonViCongTac()
					});
					stt++;
				}
			}
		}
		
		if(o.equals(btnTimKiemTC)) {
			String str = textField_TimKiemTC.getText();
			xoaHetDuLieuTrenTableMode();
			List<TangCa> list =  dao_TangCa.getAllTangCa();
			int stt= 1;
			for (TangCa tc : list) {
				String str2 = tc.getMaTangCa()+tc.getMaNhanVien()+tc.getNgayTangCa().toString()+tc.getNgayTao().toString()+tc.getMaNguoiTao();
				if(str2.contains(str)) {
				model.addRow(new Object[] {
						stt,tc.getMaTangCa(),tc.getMaNhanVien(),tc.getNgayTangCa(),tc.getSoGio(),
						tc.getMaNguoiTao(),tc.getNgayTao()
				});
				stt++;
				}
			}
			
					
		}
		if(o.equals(btnTimKiemNN)) {
			String str = textField_TimKiemNN.getText();
			xoaHetDuLieuTrenTableMode_1();
			List<NgayNghi> list =  dao_NgayNghi.getAllNN();
			int stt=1;
			for (NgayNghi cl : list) {
				String str2 = cl.getMaNgayNghi()+cl.getNgayNghi()+cl.getMaNguoiTao()+cl.getLyDo()+cl.getMaNhanVien()+cl.getNgayHetNghi()+cl.isTroCap();
				if(str2.contains(str)) {
				model1.addRow(new Object[] {
						stt,cl.getMaNgayNghi(),cl.getMaNhanVien(),cl.getNgayNghi(),cl.getNgayHetNghi(),cl.isTroCap(),
						cl.getLyDo(),cl.getMaNguoiTao(),cl.getNgayTao()
				});
				stt++;
				}
			}
		}
		
		if(o.equals(btnTaoMoiTC)) {
			xoaTrangTC();
			docNgayTao();
			textField_MaNVTaoTC.setText(GUI_DangNhap.getDnma());
			panel.removeMouseListener(this);
			panel_1.removeMouseListener(this);
			panel_2.removeMouseListener(this);
			panel_3.removeMouseListener(this);
			panel_5.removeMouseListener(this);
			table.removeMouseListener(this);
			table.clearSelection();
			table_2.clearSelection();
			table.setEnabled(false);
			textField_MaNVTC.setEditable(true);
			textField_SoGio.setEditable(true);
			panel_5.removeAll();
			panel_5.add(btnThoatTC);
			panel_5.add(btnXoaRongTC);
			panel_5.add(btnThemTC);
			taoMaTangCa();
			panel_5.updateUI();
			
		}
		if(o.equals(btnThoatTC)) {
			panel.removeMouseListener(this);
			panel_1.addMouseListener(this);
			panel_2.addMouseListener(this);
			panel_3.addMouseListener(this);
			panel_5.addMouseListener(this);
			table.addMouseListener(this);
			table.clearSelection();
			table_2.clearSelection();
			table.setEnabled(true);
			textField_MaNVTC.setEditable(false);
			textField_SoGio.setEditable(false);
			panel_5.removeAll();
			panel_5.add(btnTaoMoiTC);
			panel_5.add(btnXoaTC);
			panel_5.add(btnSuaTC);
			panel_5.updateUI();
			
		}
		if(o.equals(btnSuaTC)) {
			textField_MaNVTaoTC.setText(GUI_DangNhap.getDnma());
			panel.removeMouseListener(this);
			panel_1.removeMouseListener(this);
			panel_2.removeMouseListener(this);
			panel_3.removeMouseListener(this);
			panel_5.removeMouseListener(this);
			table_2.clearSelection();
			table.setEnabled(true);
			textField_MaNVTC.setEditable(true);
			textField_SoGio.setEditable(true);
			panel_5.removeAll();
			panel_5.add(btnThoatTC);
			panel_5.add(btnXoaRongTC);
			panel_5.add(btnLuuTC);
			panel_5.updateUI();
			
		}
		
		if(o.equals(btnTaoMoiNN)) {
				xoaTrangNN();
				docNgayTaoNN();
				textField_MaNguoiTaoNN.setText(GUI_DangNhap.getDnma());
				panel.removeMouseListener(this);
				panel_1.removeMouseListener(this);
				panel_2.removeMouseListener(this);
				panel_3.removeMouseListener(this);
				panel_5.removeMouseListener(this);
				table_1.removeMouseListener(this);
				table_1.clearSelection();
				table_2.clearSelection();
				table_1.setEnabled(false);
				textField_MaNVNN.setEditable(true);
				textPane_LyDo.setEditable(true);
				cbTroCap.setEnabled(true);
				panel_3.removeAll();
				panel_3.add(btnThoatNN);
				panel_3.add(btnXoaRongNN);
				panel_3.add(btnThemNN);
				taoMaNgayNghi();
				panel_3.updateUI();
				
			
		}
		
		
		if(o.equals(btnThoatNN)) {
			xoaTrangNN();
			panel.addMouseListener(this);
			panel_1.addMouseListener(this);
			panel_2.addMouseListener(this);
			panel_3.addMouseListener(this);
			panel_5.addMouseListener(this);
			table_1.addMouseListener(this);
			table.clearSelection();
			table_2.clearSelection();
			table_1.setEnabled(true);
			textField_MaNVNN.setEditable(false);
			textPane_LyDo.setEditable(false);
			cbTroCap.setEnabled(false);
			panel_3.removeAll();
			panel_3.add(btnTaoMoiNN);
			panel_3.add(btnXoaNN);
			panel_3.add(btnSuaNN);
			panel_3.updateUI();
			
		}
		
		if(o.equals(btnSuaNN)) {
			textField_MaNguoiTaoNN.setText(GUI_DangNhap.getDnma());
			panel.removeMouseListener(this);
			panel_1.removeMouseListener(this);
			panel_2.removeMouseListener(this);
			panel_3.removeMouseListener(this);
			panel_5.removeMouseListener(this);
			table_2.clearSelection();
			table_1.setEnabled(true);
			textField_MaNVNN.setEditable(true);
			textPane_LyDo.setEditable(true);
			cbTroCap.setEnabled(true);
			panel_3.removeAll();
			panel_3.add(btnThoatNN);
			panel_3.add(btnXoaRongNN);
			panel_3.add(btnLuuNN);
			panel_3.updateUI();
			
		}
		
		
		if(o.equals(btnThemTC)) {
			java.sql.Date t = (java.sql.Date)ngayTangCa.getModel().getValue();
			
			if(textField_MaNVTC.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống");
			}
			if(textField_SoGio.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Số giờ không được để trống");
			}
			if(t==null) {
				JOptionPane.showMessageDialog(this, "Ngày tăng ca không được để trống");
			}
			else {
				if(KiemTraTC()) {
					Date ngayTao = Date.valueOf(textField_NgayTao.getText());
					java.sql.Date selectedDate = (java.sql.Date) ngayTangCa.getModel().getValue(); ;
					TangCa tc = new  TangCa(textField_MaTC.getText(),textField_MaNVTC.getText(), selectedDate, Integer.parseInt(textField_SoGio.getText()), textField_MaNVTaoTC.getText(), ngayTao);
					dao_TangCa.create(tc);
					JOptionPane.showMessageDialog(this, "Thêm Thành Công");
					taoMaTangCa();
					taiLaiBang();
					xoaXamTC();
					}
				}
		}
		if(o.equals(btnLuuTC)) {
			java.sql.Date t = (java.sql.Date)ngayTangCa.getModel().getValue();
			
			if(textField_MaNVTC.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống");
			}
			if(textField_SoGio.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Số giờ không được để trống");
			}
			if(t==null) {
				JOptionPane.showMessageDialog(this, "Ngày tăng ca không được để trống");
			}
			else {
				if(KiemTraTC()) {
					int hoinhac = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn sửa phiếu tăng ca này?","Warnning",JOptionPane.YES_NO_CANCEL_OPTION);
					if(hoinhac == JOptionPane.YES_OPTION) {
						try {
							Date ngayTao = Date.valueOf(textField_NgayTao.getText());
							java.sql.Date selectedDate = (java.sql.Date) ngayTangCa.getModel().getValue(); ;
							TangCa tc = new  TangCa(textField_MaTC.getText(),textField_MaNVTC.getText(), selectedDate, Integer.parseInt(textField_SoGio.getText()), textField_MaNVTaoTC.getText(), ngayTao);						
							dao_TangCa.suaTangCa(tc);
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
		
		if(o.equals(btnLuuNN)) {
			java.sql.Date nn = (java.sql.Date)ngayNghi.getModel().getValue();
			java.sql.Date kt = (java.sql.Date)ngayHetNghi.getModel().getValue();
			
			if(textField_MaNVNN.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống");
			}
			if(textPane_LyDo.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Lý do bị bỏ trống");
			}
			if(nn==null) {
				JOptionPane.showMessageDialog(this, "Ngày bắt đầu nghỉ không được để trống");
			}
			if(kt==null) {
				JOptionPane.showMessageDialog(this, "Ngày kết thúc nghỉ được để trống");
			}
			else {
	
				if(KiemTraNN()) {
					int hoinhac = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn sửa phiếu tăng ca này?","Warnning",JOptionPane.YES_NO_CANCEL_OPTION);
					if(hoinhac == JOptionPane.YES_OPTION) {
						try {
							Date ngayTao = Date.valueOf(textField_NgayTaoNN.getText()); 
							NgayNghi tc = new  NgayNghi(textField_MaNN.getText(),textField_MaNVNN.getText(), nn, kt,cbTroCap.isSelected(), textPane_LyDo.getText(), textField_MaNguoiTaoNN.getText(), ngayTao);
							dao_NgayNghi.suaNgayNghi(tc);
							JOptionPane.showMessageDialog(this, "Sửa Thành Công");
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						taiLaiBang();
					}
				  }
		}
		}
		
		if(o.equals(btnThemNN)) {
			java.sql.Date nn = (java.sql.Date)ngayNghi.getModel().getValue();
			java.sql.Date kt = (java.sql.Date)ngayHetNghi.getModel().getValue();
			if(textField_MaNVNN.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống");
			}
			if(textPane_LyDo.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Lý do nghỉ không được để trống");
			}
			if(nn==null) {
				JOptionPane.showMessageDialog(this, "Ngày bắt đầu nghỉ không được để trống");
			}
			if(kt==null) {
				JOptionPane.showMessageDialog(this, "Ngày kết thúc nghỉ được để trống");
			}
			
			else {
				if(KiemTraNN()) {
					Date ngayTao = Date.valueOf(textField_NgayTaoNN.getText()); 
					NgayNghi tc = new  NgayNghi(textField_MaNN.getText(),textField_MaNVNN.getText(), nn, kt,cbTroCap.isSelected(), textPane_LyDo.getText(), textField_MaNguoiTaoNN.getText(), ngayTao);
					dao_NgayNghi.create(tc);
					JOptionPane.showMessageDialog(this, "Thêm Thành Công");
					taoMaNgayNghi();
					taiLaiBang1();
					xoaXamNN();
					}
				}
		}
		
		if(o.equals(btnXoaNN)) {
			if( textField_MaNN.getText().equals(""))

				JOptionPane.showMessageDialog(this, "Hãy chọn ngày nghỉ cần xóa");
			else {
				int hoinhac = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xóa ngày nghỉ này?","Warnning",JOptionPane.YES_NO_CANCEL_OPTION);
				if(hoinhac == JOptionPane.YES_OPTION) {
					try {
							dao_NgayNghi.xoaNgayNghi(textField_MaNN.getText());
							JOptionPane.showMessageDialog(this, "Xóa Thành Công");
							taiLaiBang1();
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}
			}
		}
		
		
		if(o.equals(btnXoaTC)) {
			if( textField_MaTC.getText().equals(""))

				JOptionPane.showMessageDialog(this, "Hãy chọn phiếu tăng ca cần xóa");
			else {
				int hoinhac = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xóa phiếu tăng ca này?","Warnning",JOptionPane.YES_NO_CANCEL_OPTION);
				if(hoinhac == JOptionPane.YES_OPTION) {
					try {
							dao_TangCa.xoaTangCa(textField_MaTC.getText());
							JOptionPane.showMessageDialog(this, "Xóa Thành Công");
							taiLaiBang();
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}
			}
		}
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o.equals(table_1)) {
			int row = table_1.getSelectedRow();	
			textField_MaNN.setText(model1.getValueAt(row, 1).toString());
			textField_MaNVNN.setText(model1.getValueAt(row, 2).toString());
			textField_MaNguoiTaoNN.setText(model1.getValueAt(row, 7).toString());
			textField_NgayTaoNN.setText(model1.getValueAt(row, 8).toString());
			textPane_LyDo.setText(model1.getValueAt(row, 6).toString());
			Date ngayNghi = Date.valueOf(model1.getValueAt(row, 3).toString());
			modelNgayNghi.setValue(ngayNghi);
			Date ngayHetNghi = Date.valueOf(model1.getValueAt(row, 4).toString());
			modelNgayHetNghi.setValue(ngayHetNghi);
			cbTroCap.setSelected(false);
			if(model1.getValueAt(row, 5).toString()=="true") {
				cbTroCap.setSelected(true);
			}
		}
		if(o.equals(table)) {
			int row = table.getSelectedRow();
			textField_MaTC.setText(model.getValueAt(row, 1).toString());
			textField_MaNVTC.setText(model.getValueAt(row, 2).toString());
			textField_MaNVTaoTC.setText(model.getValueAt(row, 5).toString());
			textField_NgayTao.setText(model.getValueAt(row, 6).toString());
			textField_SoGio.setText(model.getValueAt(row, 4).toString());
			Date ngayTangCa = Date.valueOf(model.getValueAt(row, 3).toString());
			modelNgayTC.setValue(ngayTangCa);
		}
		
		if(o.equals(table_2)) {
			int row = table_2.getSelectedRow();
			textField_MaNVNN.setText(model2.getValueAt(row, 1).toString());
			textField_MaNVTC.setText(model2.getValueAt(row, 1).toString());
			xoaHetDuLieuTrenTableMode_1();
			xoaHetDuLieuTrenTableMode();
			docTangCaTheoNV(model2.getValueAt(row, 1).toString());
			docNgayNghiTheoNV(model2.getValueAt(row, 1).toString());
		}
		
		if(o.equals(panel_1)) {
			xoaTrangTC();
			table.clearSelection();
			table.clearSelection();
			table_2.clearSelection();
		}
		if(o.equals(panel_2)) {
			xoaTrangNN();
			table_1.clearSelection();
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
	//Doc
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
	
	public void docNgayTaoNN() {
		try {
			long millis=System.currentTimeMillis();  
			java.sql.Date date=new java.sql.Date(millis);  
				textField_NgayTaoNN.setText(date.toString());
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTable1() {
		try {
		List<NgayNghi> list =  dao_NgayNghi.getAllNN();
		int stt=1;
		for (NgayNghi cl : list) {
			model1.addRow(new Object[] {
					stt,cl.getMaNgayNghi(),cl.getMaNhanVien(),cl.getNgayNghi(),cl.getNgayHetNghi(),cl.isTroCap(),
					cl.getLyDo(),cl.getMaNguoiTao(),cl.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTable1TheoNV() {
		try {
		List<NgayNghi> list =  dao_NgayNghi.getAllNNNV();
		int stt=1;
		for (NgayNghi cl : list) {
			model1.addRow(new Object[] {
					stt,cl.getMaNgayNghi(),cl.getMaNhanVien(),cl.getNgayNghi(),cl.getNgayHetNghi(),cl.isTroCap(),
					cl.getLyDo(),cl.getMaNguoiTao(),cl.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTable1TheoNguoiTao() {
		try {
		List<NgayNghi> list =  dao_NgayNghi.getAllNNTheoNguoiTao();
		int stt=1;
		for (NgayNghi cl : list) {
			model1.addRow(new Object[] {
					stt,cl.getMaNgayNghi(),cl.getMaNhanVien(),cl.getNgayNghi(),cl.getNgayHetNghi(),cl.isTroCap(),
					cl.getLyDo(),cl.getMaNguoiTao(),cl.getNgayTao()
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
		List<NgayNghi> list =  dao_NgayNghi.getAllNNTheoNgayTao();
		int stt=1;
		for (NgayNghi cl : list) {
			model1.addRow(new Object[] {
					stt,cl.getMaNgayNghi(),cl.getMaNhanVien(),cl.getNgayNghi(),cl.getNgayHetNghi(),cl.isTroCap(),
					cl.getLyDo(),cl.getMaNguoiTao(),cl.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTable1TheoTroCap() {
		try {
		List<NgayNghi> list =  dao_NgayNghi.getAllNNTheoTroCap();
		int stt=1;
		for (NgayNghi cl : list) {
			model1.addRow(new Object[] {
					stt,cl.getMaNgayNghi(),cl.getMaNhanVien(),cl.getNgayNghi(),cl.getNgayHetNghi(),cl.isTroCap(),
					cl.getLyDo(),cl.getMaNguoiTao(),cl.getNgayTao()
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
		List<TangCa> list =  dao_TangCa.getAllTangCa();
		int stt= 1;
		for (TangCa tc : list) {
			model.addRow(new Object[] {
					stt,tc.getMaTangCa(),tc.getMaNhanVien(),tc.getNgayTangCa(),tc.getSoGio(),
					tc.getMaNguoiTao(),tc.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTableTheoNV() {
		try {
		List<TangCa> list =  dao_TangCa.getAllTangCaTheoNV();
		int stt= 1;
		for (TangCa tc : list) {
			model.addRow(new Object[] {
					stt,tc.getMaTangCa(),tc.getMaNhanVien(),tc.getNgayTangCa(),tc.getSoGio(),
					tc.getMaNguoiTao(),tc.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTableTheoNguoiTao() {
		try {
		List<TangCa> list =  dao_TangCa.getAllTangCaTheoNguoiTao();
		int stt= 1;
		for (TangCa tc : list) {
			model.addRow(new Object[] {
					stt,tc.getMaTangCa(),tc.getMaNhanVien(),tc.getNgayTangCa(),tc.getSoGio(),
					tc.getMaNguoiTao(),tc.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTableTheoNgayTao() {
		try {
		List<TangCa> list =  dao_TangCa.getAllTangCaTheoNgayTao();
		int stt= 1;
		for (TangCa tc : list) {
			model.addRow(new Object[] {
					stt,tc.getMaTangCa(),tc.getMaNhanVien(),tc.getNgayTangCa(),tc.getSoGio(),
					tc.getMaNguoiTao(),tc.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTableTheoSoGio() {
		try {
		List<TangCa> list =  dao_TangCa.getAllTangCaTheoSoGio();
		int stt= 1;
		for (TangCa tc : list) {
			model.addRow(new Object[] {
					stt,tc.getMaTangCa(),tc.getMaNhanVien(),tc.getNgayTangCa(),tc.getSoGio(),
					tc.getMaNguoiTao(),tc.getNgayTao()
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
		List<NhanVienHanhChinh> list =  dao_NhanVien.getAllNhanVienHanhChinh();
		int stt = 1;
		for (NhanVienHanhChinh nv : list) {
			model2.addRow(new Object[] {
					stt,nv.getMaNhanVien(),nv.getHoTen(),nv.getGioiTinh(),nv.getChucVu(),nv.getDonViCongTac()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTable2TheoTen() {
		try {
		List<NhanVienHanhChinh> list =  dao_NhanVien.getAllNhanVienHanhChinhTheoTen();
		int stt = 1;
		for (NhanVienHanhChinh nv : list) {
			model2.addRow(new Object[] {
					stt,nv.getMaNhanVien(),nv.getHoTen(),nv.getGioiTinh(),nv.getChucVu(),nv.getDonViCongTac()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTable2TheoCV() {
		try {
		List<NhanVienHanhChinh> list =  dao_NhanVien.getAllNhanVienHanhChinhTheoCV();
		int stt = 1;
		for (NhanVienHanhChinh nv : list) {
			model2.addRow(new Object[] {
					stt,nv.getMaNhanVien(),nv.getHoTen(),nv.getGioiTinh(),nv.getChucVu(),nv.getDonViCongTac()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTable2TheoDV() {
		try {
		List<NhanVienHanhChinh> list =  dao_NhanVien.getAllNhanVienHanhChinhTheoDV();
		int stt = 1;
		for (NhanVienHanhChinh nv : list) {
			model2.addRow(new Object[] {
					stt,nv.getMaNhanVien(),nv.getHoTen(),nv.getGioiTinh(),nv.getChucVu(),nv.getDonViCongTac()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void docTangCaTheoNV(String ma) {
		try {
			List<TangCa> list =  dao_TangCa.getAllTangCaTheoMa(ma);
			int stt= 1;
			for (TangCa tc : list) {
				model.addRow(new Object[] {
						stt,tc.getMaTangCa(),tc.getMaNhanVien(),tc.getNgayTangCa(),tc.getSoGio(),
						tc.getMaNguoiTao(),tc.getNgayTao()
				});
				stt++;
				}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void docNgayNghiTheoNV(String ma) {
		try {
			List<NgayNghi> list =  dao_NgayNghi.getNgayNghiTheoMa(ma);
			int stt=1;
			for (NgayNghi cl : list) {
				model1.addRow(new Object[] {
						stt,cl.getMaNgayNghi(),cl.getMaNhanVien(),cl.getNgayNghi(),cl.getNgayHetNghi(),cl.isTroCap(),
						cl.getLyDo(),cl.getMaNguoiTao(),cl.getNgayTao()
				});
				stt++;
				}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
	
	//Kiểm tra
	private boolean KiemTraNN() {
		String ma=textField_MaNVNN.getText().trim();
		
		java.sql.Date nn = (java.sql.Date)ngayNghi.getModel().getValue();
		java.sql.Date kt = (java.sql.Date)ngayHetNghi.getModel().getValue();
		
		if(!(ma.matches("[N][V][0-9]+"))) {
			JOptionPane.showMessageDialog(this, "Nhập lại mã nhân viên theo Mẫu NV + Số Bất Kỳ VD:NV001");
			return false;
		}
		if (!(nn.before(kt))) {
			JOptionPane.showMessageDialog(this, "Ngày hết nghỉ phải sau ngày nghỉ");
			return false;
		}
		
		return true;
	}
	
	
	private boolean KiemTraTC() {
		String ma=textField_MaNVTC.getText().trim();
		
		try {
			int sl = Integer.parseInt(textField_SoGio.getText());
			if(sl<1) {
				JOptionPane.showMessageDialog(this, "Số giờ phải lớn hơn 0");
				return false;
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this,"Số giờ phải là số tự nhiên");
			return false;
		}
		if(!(ma.matches("[N][V][0-9]+"))) {
			JOptionPane.showMessageDialog(this, "Nhập lại mã nhân viên theo Mẫu NV + Số Bất Kỳ VD:NV001");
			return false;
		}
		
		
		
		return true;
	}
	
	
	
	//Tạo Mới
	
	
	private void taoMaTangCa() {
		String ma= dao_TangCa.getMaLonNhat();
		int maMoi;
		maMoi =Integer.parseInt(ma.substring(2, 6)) + 1;
		if(maMoi<10000) {
			textField_MaTC.setText("TC"+maMoi);
		}
		if(maMoi<1000) {
			textField_MaTC.setText("TC0"+maMoi);
		}
		if(maMoi<100) {
			textField_MaTC.setText("TC00"+maMoi);
		}
		if(maMoi<10) {
			textField_MaTC.setText("TC000"+maMoi);
		}
		
		
		
	}
	
	private void taoMaNgayNghi() {
		String ma= dao_NgayNghi.getMaLonNhat();
		int maMoi;
		maMoi =Integer.parseInt(ma.substring(2, 6)) + 1;
		if(maMoi<10000) {
			textField_MaNN.setText("NN"+maMoi);
		}
		if(maMoi<1000) {
			textField_MaNN.setText("NN0"+maMoi);
		}
		if(maMoi<100) {
			textField_MaNN.setText("NN00"+maMoi);
		}
		if(maMoi<10) {
			textField_MaNN.setText("NN000"+maMoi);
		}
		
		
		
	}
	
	
	
	//Xóa
	
	public void xoaTrangTC(){ 
		textField_MaNVTC.setText("");
		textField_SoGio.setText("");
		textField_MaTC.setText("");
		textField_MaNVTaoTC.setText("");
		textField_NgayTao.setText("");
		modelNgayTC.setValue(null);
	}
	
	public void xoaXamTC(){ 
		textField_MaNVTC.setText("");
		textField_SoGio.setText("");
		modelNgayTC.setValue(null);
	}
	
	
	public void xoaTrangNN(){  
		textField_MaNVNN.setText("");
		textPane_LyDo.setText("");
		textField_NgayTaoNN.setText("");
		textField_MaNN.setText("");
		textField_MaNguoiTaoNN.setText("");
		modelNgayNghi.setValue(null);
		modelNgayHetNghi.setValue(null);
		cbTroCap.setSelected(false);
	}
	
	public void xoaXamNN(){  
		textField_MaNVNN.setText("");
		textPane_LyDo.setText("");
		modelNgayNghi.setValue(null);
		modelNgayHetNghi.setValue(null);
		cbTroCap.setSelected(false);
	}
	
	
	private void xoaHetDuLieuTrenTableMode() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();

		}
	
	
	private void xoaHetDuLieuTrenTableMode_1() {
		DefaultTableModel dm = (DefaultTableModel) table_1.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();

		}
	private void xoaHetDuLieuTrenTableMode_2() {
		DefaultTableModel dm = (DefaultTableModel) table_2.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();

		}
	

	//Tải Lại
	private void taiLaiBang(){
		xoaHetDuLieuTrenTableMode();
		docDuLieuDatabaseVaoTable();
	}
	private void taiLaiBang1(){
		xoaHetDuLieuTrenTableMode_1();
		docDuLieuDatabaseVaoTable1();
	}
	private void taiLaiBang2(){
		xoaHetDuLieuTrenTableMode_2();
		docDuLieuDatabaseVaoTable2();
	}
}

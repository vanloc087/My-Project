package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;
import connectDB.ConnectDB;
import dao.DAO_NhanVienHanhChinh;
import dao.DAO_HopDong;
import dao.DAO_KhachHang;
import dao.DAO_SanPham;
import entity.ChiTietHopDong;
import entity.HopDong;
import entity.KhachHang;
import entity.NhanVienHanhChinh;
import entity.SanPham;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
public class GUI_QuanLyHopDong extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel quanLyHopdong;
	private JTable tableQLHD;
	private JTextField timKiem;
	private JTextField loc;
	private DAO_HopDong hopDong_DAO;
	private DefaultTableModel modelHopDong;
	private JButton them;
	private JButton sua;
	private JButton xoa;
	private JComboBox<String> loaiTimKiem;
	private TableRowSorter<TableModel> filter;
	private JTextArea chiTietHD;
	

//-------  Dành cho JFame nhập và sửa
	private JPanel themHD;
	private JTextField textFieldSoLuongSanPham;
	private JTextField textFieldGiaTriHD;
	private JTextField textFieldtenHD;
	private JTextField textFieldMaHD;
	private JButton xoaRong;
	private JButton thoat;
	private JButton themHopDong;
	private JFrame nhap_SuaHD;
	private JButton suaHD;
	private JDatePickerImpl ngayTaoHD;
	private JDatePickerImpl ngayHetHanHD;
	private JComboBox<String> comboBoxMaSP;
	private JComboBox<String> comboBoxMaKH;
	private JComboBox<String> comboBoxMaNV;
	private DAO_SanPham sanPham_DAO;
	private DAO_KhachHang khachHang_Dao;
	private DAO_NhanVienHanhChinh nhanVienHanhChinh_Dao;
	private JCheckBox chckbxThanhToan;
	private JButton btnLocHDChuaThanhToan;
	private JButton btnLocHD;
	private JButton btnLocHDHetHan;
	
//--------------------------------------
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLyHopDong frame = new GUI_QuanLyHopDong();
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
	@SuppressWarnings("deprecation")
	public GUI_QuanLyHopDong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 680);
		setLocationRelativeTo(null);
		setResizable(false);
		
		quanLyHopdong = new JPanel();
		quanLyHopdong.setBackground(new Color(255, 140, 0));
		quanLyHopdong.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(quanLyHopdong);
		quanLyHopdong.setLayout(null);
		
		
		modelHopDong = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"M\u00E3 h\u1EE3p \u0111\u1ED3ng", "Ng\u00E0y t\u1EA1o", "Ng\u00E0y h\u1EBFt h\u1EA1n", "M\u00E3 s\u1EA3n ph\u1EA9m", "M\u00E3 kh\u00E1ch h\u00E0ng", "M\u00E3 nh\u00E2n vi\u00EAn t\u1EA1o","Tình trạng"
				}
			);
		
		JPanel panelChucNang = new JPanel();
		panelChucNang.setBorder(new LineBorder(Color.ORANGE));
		panelChucNang.setBackground(Color.WHITE);
		panelChucNang.setBounds(10, 304, 468, 347);
		quanLyHopdong.add(panelChucNang);
		panelChucNang.setLayout(null);
		
		timKiem = new JTextField();
		timKiem.setToolTipText("Nhập để tìm kiếm");
		timKiem.setBounds(10, 120, 273, 29);
		panelChucNang.add(timKiem);
		timKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		timKiem.setColumns(10);
		
		loc = new JTextField();
		loc.setToolTipText("Nhập để lọc");
		loc.setBounds(10, 186, 273, 29);
		panelChucNang.add(loc);
		loc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loc.setColumns(10);
		
		loaiTimKiem = new JComboBox<String>();
		loaiTimKiem.setToolTipText("Tùy chọn để tìm kiếm");
		loaiTimKiem.setBackground(new Color(245, 222, 179));
		loaiTimKiem.setBounds(293, 120, 165, 29);
		panelChucNang.add(loaiTimKiem);
		loaiTimKiem.setModel(new DefaultComboBoxModel<String>(new String[] {"Tìm theo mã hợp đồng", "Tìm theo mã nhân viên", "Tìm theo mã khách hàng"}));
		
		them = new JButton("Thêm hợp đồng");
		them.setToolTipText("Thêm mới một hợp đồng");
		them.setBackground(new Color(224, 255, 255));
		them.setBounds(10, 56, 140, 29);
		panelChucNang.add(them);
		them.setFont(new Font("Tahoma", Font.PLAIN, 15));
		xoa = new JButton("Xóa hợp đồng");
		xoa.setToolTipText("Xóa một hợp đồng");
		xoa.setBackground(new Color(250, 250, 210));
		xoa.setBounds(318, 56, 140, 29);
		panelChucNang.add(xoa);
		xoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		sua = new JButton("Sửa hợp đồng ");
		sua.setToolTipText("Sửa một hợp hợp đồng");
		sua.setBackground(new Color(255, 239, 213));
		sua.setBounds(164, 56, 140, 29);
		panelChucNang.add(sua);
		sua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblChucNang = new JLabel("Tùy chọn");
		lblChucNang.setFont(new Font("Sitka Display", Font.PLAIN, 27));
		lblChucNang.setHorizontalAlignment(SwingConstants.LEFT);
		lblChucNang.setBounds(10, 0, 109, 34);
		panelChucNang.add(lblChucNang);
		
		btnLocHD = new JButton("Lọc theo mã sản phẩm");
		btnLocHD.setToolTipText("Lọc hợp đồng theo mã sản phẩm");
		btnLocHD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLocHD.setBackground(new Color(224, 255, 255));
		btnLocHD.setBounds(293, 187, 165, 29);
		panelChucNang.add(btnLocHD);
		
		btnLocHDHetHan = new JButton("Lọc hợp đồng hết hạn");
		btnLocHDHetHan.setToolTipText("lọc hợp đồng đã hết hạn");
		btnLocHDHetHan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLocHDHetHan.setBackground(new Color(224, 255, 255));
		btnLocHDHetHan.setBounds(152, 246, 165, 29);
		panelChucNang.add(btnLocHDHetHan);
		
		btnLocHDChuaThanhToan = new JButton("Lọc hợp đồng chưa thanh toán");
		btnLocHDChuaThanhToan.setToolTipText("Lọc hợp đồng chưa thanh toán");
		btnLocHDChuaThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLocHDChuaThanhToan.setBackground(new Color(224, 255, 255));
		btnLocHDChuaThanhToan.setBounds(122, 286, 225, 29);
		panelChucNang.add(btnLocHDChuaThanhToan);
		sua.addActionListener(this);
		xoa.addActionListener(this);
		
		JPanel panelQLHD = new JPanel();
		panelQLHD.setBorder(new LineBorder(Color.ORANGE));
		panelQLHD.setBackground(Color.WHITE);
		panelQLHD.setBounds(479, 304, 875, 347);
		quanLyHopdong.add(panelQLHD);
		panelQLHD.setLayout(null);
		
		JScrollPane scrollPaneTableQLHD = new JScrollPane();
		scrollPaneTableQLHD.setBounds(10, 39, 855, 297);
		panelQLHD.add(scrollPaneTableQLHD);
		tableQLHD = new JTable(modelHopDong);
		tableQLHD.setBackground(Color.WHITE);
		tableQLHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPaneTableQLHD.setViewportView(tableQLHD);
		
		JLabel tieuDe = new JLabel("Hợp đồng");
		tieuDe.setBounds(10, 0, 120, 40);
		panelQLHD.add(tieuDe);
		tieuDe.setFont(new Font("Sitka Display", Font.PLAIN, 27));
		tieuDe.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel panelChiTietHD = new JPanel();
		panelChiTietHD.setBorder(new LineBorder(Color.ORANGE));
		panelChiTietHD.setBackground(Color.WHITE);
		panelChiTietHD.setBounds(10, 31, 1344, 273);
		quanLyHopdong.add(panelChiTietHD);
		panelChiTietHD.setLayout(null);
		
		JLabel thongTinChiTiet = new JLabel("Thông tin chi tiết");
		thongTinChiTiet.setBounds(10, 0, 174, 31);
		panelChiTietHD.add(thongTinChiTiet);
		thongTinChiTiet.setFont(new Font("Sitka Display", Font.PLAIN, 24));
		thongTinChiTiet.setHorizontalAlignment(SwingConstants.LEFT);
		
		JScrollPane scrollPaneThongTinChiTiet = new JScrollPane();
		scrollPaneThongTinChiTiet.setBounds(10, 29, 1324, 233);
		panelChiTietHD.add(scrollPaneThongTinChiTiet);
		
		chiTietHD = new JTextArea();
		chiTietHD.setToolTipText("Thông tin chi tiết hợp đồng");
		chiTietHD.setBackground(Color.WHITE);
		scrollPaneThongTinChiTiet.setViewportView(chiTietHD);
		chiTietHD.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		chiTietHD.setEditable(false);
		
		JPanel panelTieuDe = new JPanel();
		panelTieuDe.setBorder(new LineBorder(Color.ORANGE));
		panelTieuDe.setBackground(new Color(211, 211, 211));
		panelTieuDe.setBounds(10, 0, 1344, 30);
		quanLyHopdong.add(panelTieuDe);
		panelTieuDe.setLayout(null);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("data\\\\img\\\\login.png"));
		lblNewLabel.setText("  "+GUI_DangNhap.getDnma());
		lblNewLabel.setBounds(1217, 0, 117, 30);
		panelTieuDe.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(10, 0, 391, 30);
		java.util.Date date = new java.util.Date();
		lblNewLabel_1.setText(date.getDate()+"/"+(date.getMonth()+1)+"/"+(date.getYear()+1900));
		panelTieuDe.add(lblNewLabel_1);
		
		them.addActionListener(this);
		loaiTimKiem.addActionListener(this);
		timKiem.addActionListener(this);
		btnLocHD.addActionListener(this);
		btnLocHDChuaThanhToan.addActionListener(this);
		btnLocHDHetHan.addActionListener(this);
		
//==================================================================================================================================================
		
		nhap_SuaHD = new JFrame();
		nhap_SuaHD.setBounds(100, 100, 600, 635);
		nhap_SuaHD.setLocationRelativeTo(null);
		nhap_SuaHD.setResizable(false);
		themHD = new JPanel();
		themHD.setBorder(new LineBorder(Color.ORANGE));
		themHD.setBackground(new Color(245, 255, 250));
		themHD.setBorder(new EmptyBorder(5, 5, 5, 5));
		nhap_SuaHD.setContentPane(themHD);
		themHD.setLayout(null);

		JLabel tieuDeThemHD = new JLabel("Thông tin hợp đồng");
		tieuDeThemHD.setBounds(0, 0, 594, 58);
		tieuDeThemHD.setFont(new Font("Tahoma", Font.BOLD, 23));
		tieuDeThemHD.setHorizontalAlignment(SwingConstants.CENTER);
		themHD.add(tieuDeThemHD);
		
		JLabel maHD = new JLabel("Mã hợp đồng: ");
		maHD.setBounds(59, 69, 84, 22);
		themHD.add(maHD);
		
		JLabel tenHD = new JLabel("Tên hợp đồng: ");
		tenHD.setBounds(59, 150, 84, 22);
		themHD.add(tenHD);
		
		JLabel ngayTao = new JLabel("Ngày tạo:  ");
		ngayTao.setBounds(59, 194, 84, 22);
		themHD.add(ngayTao);
		
		JLabel soLuongSP = new JLabel("Số lượng sản phẩm: ");
		soLuongSP.setBounds(59, 323, 119, 22);
		themHD.add(soLuongSP);
		
		JLabel giaTri = new JLabel("Giá trị hợp đồng: ");
		giaTri.setBounds(59, 281, 98, 22);
		themHD.add(giaTri);
		
		JLabel ngayHetHan = new JLabel("Ngày hết hạn:");
		ngayHetHan.setBounds(59, 365, 84, 22);
		themHD.add(ngayHetHan);
		
		textFieldSoLuongSanPham = new JTextField();
		textFieldSoLuongSanPham.setToolTipText("Nhập số lượng sản phẩm");
		textFieldSoLuongSanPham.setBounds(181, 324, 329, 20);
		themHD.add(textFieldSoLuongSanPham);
		textFieldSoLuongSanPham.setColumns(10);
		
		textFieldGiaTriHD = new JTextField();
		textFieldGiaTriHD.setToolTipText("Nhập giá trị hợp đồng");
		textFieldGiaTriHD.setColumns(10);
		textFieldGiaTriHD.setBounds(181, 282, 329, 20);
		themHD.add(textFieldGiaTriHD);
		
		SqlDateModel modelngayTaoHD = new SqlDateModel();
		Properties pngayTaoHD =  new Properties();
		pngayTaoHD.put("text.date", "date");
		pngayTaoHD.put("text.month", "month");
		pngayTaoHD.put("text.year", "year");
		JDatePanelImpl implngayTaoHD = new JDatePanelImpl(modelngayTaoHD, pngayTaoHD);
		ngayTaoHD = new JDatePickerImpl(implngayTaoHD, new AbstractFormatter() {
			
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
				
				return null;
			}
		});
		ngayTaoHD.setToolTipText("Chọn ngày tạo");
		ngayTaoHD.getJFormattedTextField().setBackground(new Color(250, 250, 210));
		ngayTaoHD.setBackground(new Color(250, 250, 210));
		ngayTaoHD.setBounds(181, 195, 329, 25);
		themHD.add(ngayTaoHD);
		
		
		textFieldtenHD = new JTextField();
		textFieldtenHD.setToolTipText("Nhập tên hợp đồng");
		textFieldtenHD.setColumns(10);
		textFieldtenHD.setBounds(181, 151, 329, 20);
		themHD.add(textFieldtenHD);
		
		textFieldMaHD = new JTextField();
		textFieldMaHD.setToolTipText("Mã hợp đồng tạo tự động");
		textFieldMaHD.setColumns(10);
		textFieldMaHD.setBounds(181, 69, 329, 20);
		textFieldMaHD.setEditable(false);
		themHD.add(textFieldMaHD);
		
		SqlDateModel modelHetHanHD = new SqlDateModel();
		Properties pHetHanHD =  new Properties();
		pHetHanHD.put("text.date", "date");
		pHetHanHD.put("text.month", "month");
		pHetHanHD.put("text.year", "year");
		JDatePanelImpl implHetHanHD = new JDatePanelImpl(modelHetHanHD, pHetHanHD);
		ngayHetHanHD = new JDatePickerImpl(implHetHanHD, new AbstractFormatter() {
			
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
				
				return null;
			}
		});
		ngayHetHanHD.setToolTipText("Chọn ngày hết hạn hợp đồng");
		ngayHetHanHD.getJFormattedTextField().setBackground(new Color(250, 250, 210));
		ngayHetHanHD.setBackground(new Color(250, 250, 210));
		ngayHetHanHD.setBounds(181, 366, 329, 25);
		themHD.add(ngayHetHanHD);
		
		comboBoxMaSP = new JComboBox<String>();
		comboBoxMaSP.setToolTipText("Tùy chọn mã sản phẩm");
		comboBoxMaSP.setBounds(181, 238, 329, 20);
		comboBoxMaSP.setBackground(new Color(245, 222, 179));
		themHD.add(comboBoxMaSP);
		
		comboBoxMaKH = new JComboBox<String>();
		comboBoxMaKH.setToolTipText("Tùy chọn mã khách hàng");
		comboBoxMaKH.setBackground(new Color(245, 222, 179));
		comboBoxMaKH.setBounds(181, 110, 329, 20);
		themHD.add(comboBoxMaKH);
		
		comboBoxMaNV = new JComboBox<String>();
		comboBoxMaNV.setToolTipText("Tùy chọn mã nhân viên tạo");
		comboBoxMaNV.setBounds(181, 450, 329, 20);
		comboBoxMaNV.setBackground(new Color(245, 222, 179));
		themHD.add(comboBoxMaNV);
		
		JLabel maSP = new JLabel("Mã sản phẩm:");
		maSP.setBounds(59, 237, 84, 22);
		themHD.add(maSP);
		
		JLabel maKH = new JLabel("Mã khách hàng:");
		maKH.setBounds(59, 109, 98, 22);
		themHD.add(maKH);
		
		JLabel maNV = new JLabel("Mã nhân viên tạo:");
		maNV.setBounds(59, 449, 98, 22);
		themHD.add(maNV);
		
		themHopDong = new JButton("Thêm");
		themHopDong.setToolTipText("Thêm mới hợp đồng");
		themHopDong.setBackground(new Color(224, 255, 255));
		themHopDong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		themHopDong.setBounds(254, 488, 98, 33);
		themHD.add(themHopDong);
		
		xoaRong = new JButton("Xóa rỗng");
		xoaRong.setToolTipText("Xóa nội dung đã nhập ở trên để bắt đầu nhập lại");
		xoaRong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		xoaRong.setBackground(new Color(224, 255, 255));
		xoaRong.setBounds(254, 532, 98, 30);
		themHD.add(xoaRong);
		
		thoat = new JButton("Thoát");
		thoat.setToolTipText("Ngừng thêm hợp đồng");
		thoat.setBackground(new Color(224, 255, 255));
		thoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		thoat.setBounds(254, 573, 98, 22);
		themHD.add(thoat);
		
		suaHD = new JButton("Sửa");
		suaHD.setBackground(new Color(224, 255, 255));
		suaHD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		suaHD.setBounds(254, 488, 98, 33);
		themHD.add(suaHD);
		
		JLabel lblTnhTrang = new JLabel("Tình trạng:");
		lblTnhTrang.setBounds(59, 407, 84, 22);
		themHD.add(lblTnhTrang);
		
		chckbxThanhToan = new JCheckBox("  Đã thanh toán");
		chckbxThanhToan.setToolTipText("Nếu hợp đồng đã thanh toán thì ấn chọn");
		chckbxThanhToan.setBackground(new Color(255, 250, 205));
		chckbxThanhToan.setBounds(181, 407, 110, 23);
		themHD.add(chckbxThanhToan);
		
		themHopDong.addActionListener(this);
		xoaRong.addActionListener(this);
		suaHD.addActionListener(this);
		thoat.addActionListener(this);
		
////==================================================================================================================================================
		
		try{
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		hopDong_DAO = new DAO_HopDong();
		sanPham_DAO = new DAO_SanPham();
		khachHang_Dao = new DAO_KhachHang();
		nhanVienHanhChinh_Dao = new DAO_NhanVienHanhChinh();
		filter = new TableRowSorter<TableModel>(modelHopDong);
		
		tableQLHD.getSelectionModel().addListSelectionListener(selectRow);
		panelChucNang.addMouseListener(mouseListener);
		panelChiTietHD.addMouseListener(mouseListener);
		panelQLHD.addMouseListener(mouseListener);
		panelTieuDe.addMouseListener(mouseListener);
		
		DocDuLieuVaoTabel();
		updateComboboxMaSP();
		updateComboboxMaKH();
		updateComboboxMaNV();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(them)) {
			nhanThem();
		}
		if(o.equals(themHopDong)) {
			if(kiemTraNhapHopDong()) {
				nhanThemHD();
			}
		}
		if(o.equals(xoa)) {
			xoaHD();
		}
		if(o.equals(loaiTimKiem)) {
			timKiem();
		}
		if(o.equals(sua)) {
			int row = tableQLHD.getSelectedRow();
			if(row!=-1) {
				themHopDong.setVisible(false);
				suaHD.setVisible(true);
				nhap_SuaHD.setVisible(true);
			}
			else
				JOptionPane.showMessageDialog(this, "Bạn phải chọn hop dong cần sửa. ");
		}
		if(o.equals(suaHD)) {
			suaHD();
		}
		if(o.equals(btnLocHD)) { 
				tableQLHD.setRowSorter(filter);
				filter.setRowFilter(RowFilter.regexFilter(loc.getText(),3));
		}
		if (o.equals(btnLocHDChuaThanhToan)) {
			tableQLHD.setRowSorter(filter);
			filter.setRowFilter(RowFilter.regexFilter(" Chưa thanh toán",6));
		}
		if(o.equals(btnLocHDHetHan)) {

			tableQLHD.setRowSorter(filter);
			filter.setRowFilter(RowFilter.dateFilter(ComparisonType.BEFORE, new java.util.Date(), 2));
		}
		if(o.equals(thoat)) {
			nhap_SuaHD.setVisible(false);
		}
		if(o.equals(xoaRong)) {
			xoaRong();
		}
	}
	public void DocDuLieuVaoTabel(){
		List<HopDong> dsHD = hopDong_DAO.getAllHopDong();
		if(dsHD.size()!=0) {
			for (HopDong hopDong :dsHD) {
				ChiTietHopDong chiTietHopDong = new ChiTietHopDong(hopDong);
				chiTietHopDong = hopDong_DAO.getAllChiTietHopDong().get(hopDong_DAO.getAllChiTietHopDong().indexOf(chiTietHopDong));
				modelHopDong.addRow(new Object[] {
						hopDong.getMaHD(),hopDong.getNgayTao(),hopDong.getNgayHetHan(),hopDong.getMaSP().getMaSP(),hopDong.getMaKH().getMaKhachHang(),hopDong.getMaNV().getMaNhanVien(),chiTietHopDong.isThanhToan()?" Đã thanh toán":" Chưa thanh toán"
				});
			}
		}
	}

	private void updateComboboxMaSP(){
		int n = sanPham_DAO.getAllSanPham().size(); 
		String []items = new String[n];
		int i = 0;
		for(SanPham sanPham : sanPham_DAO.getAllSanPham()){
			items[i] = sanPham.getMaSP();
			i++;
		}
		comboBoxMaSP.setModel(new DefaultComboBoxModel<String>(items));
	}
	private void updateComboboxMaKH(){
		int n = khachHang_Dao.getAllKhachHang().size(); 
		String []items = new String[n];
		int i = 0;
		for(KhachHang khachHang : khachHang_Dao.getAllKhachHang()){
			items[i] = khachHang.getMaKhachHang();
			i++;
		}
		comboBoxMaKH.setModel(new DefaultComboBoxModel<String>(items));
	}
	private void updateComboboxMaNV(){
		int n = nhanVienHanhChinh_Dao.getAllNhanVienHanhChinh().size(); 
		String []items = new String[n];
		int i = 0;
		for(NhanVienHanhChinh nhanVienHanhChinh : nhanVienHanhChinh_Dao.getAllNhanVienHanhChinh()){
			items[i] = nhanVienHanhChinh.getMaNhanVien();
			i++;
		}
		comboBoxMaNV.setModel(new DefaultComboBoxModel<String>(items));
	}
	public boolean kiemTraNhapHopDong() {
		String tenHD = textFieldtenHD.getText();
		String giaTriHD = textFieldGiaTriHD.getText();
		String soLuongSP = textFieldSoLuongSanPham.getText();
		Date ngayTao = (Date) ngayTaoHD.getModel().getValue();
		Date ngayHetHan = (Date) ngayHetHanHD.getModel().getValue();
		
		if (!(tenHD.length() > 0 && tenHD.matches("[A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\\\.,'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this, "NHẬP TÊN HỢP ĐỒNG");
			return false;
		}
		if (ngayTao==null) {
			JOptionPane.showMessageDialog(this, "PHẢI CHỌN NGÀY TẠO");
			return false;
		}
		if(!(giaTriHD.length()>0)){
			JOptionPane.showMessageDialog(this,"NHẬP GIÁ TRỊ HỢP ĐỒNG.");
		}
		if(!(soLuongSP.length()>0)){
			JOptionPane.showMessageDialog(this,"SỐ LƯỢNG SẢN PHẨM.");
		}
		if (soLuongSP.length() > 0) {
			try {
				int y = Integer.parseInt(soLuongSP);
				if (y <= 0) {
					JOptionPane.showMessageDialog(this,"SỐ LỰONG SẢN PHẢM PHẢI LỚN HƠN 0.");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,"SỐ LƯỢNG SẢN PHẢM PHẢI NHẬP SỐ.");
				return false;
			}
		}
		if (giaTriHD.length() > 0) {
			try {
				double y = Double.parseDouble(giaTriHD);
				if (y <= 0) {
					JOptionPane.showMessageDialog(this,"GIÁ TRỊ HỢP ĐỒNG PHẢI LỚN HƠN 0.");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,"GIÁ TRỊ HỢP ĐỒNG PHẢI NHẬP SỐ.");
				return false;
			}
		}
		if (ngayHetHan==null) {
			JOptionPane.showMessageDialog(this, "PHẢI CHỌN NGÀY HẾT HẠN");
			return false;
		}
		if (!(comboBoxMaKH.getSelectedIndex()>=0)) {
			JOptionPane.showMessageDialog(this, "CHỌN MÃ KHÁCH HÀNG");
			return false;
		}
		if (!(comboBoxMaNV.getSelectedIndex()>=0)) {
			JOptionPane.showMessageDialog(this, "CHỌN MÃ NHÂN VIÊN ");
			return false;
		}
		if (!(comboBoxMaSP.getSelectedIndex()>=0)) {
			JOptionPane.showMessageDialog(this, "CHỌN MÃ SẢN PHẨM ");
			return false;
		}
		if (!(ngayTao.before(ngayHetHan))) {
			JOptionPane.showMessageDialog(this, "NGÀY HẾT HẠN PHẢI SAU NGÀY TẠO");
			return false;
		}
		
		return true;
	}
	public boolean kiemTraNhapHopDong(String tenHD, String soLuongSP, String giaTriHD, Date ngayTao, Date ngayHetHan) {
		
		if (!(tenHD.length() > 0 && tenHD.matches("[A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\\\.,'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this, "NHẬP TÊN HỢP ĐỒNG");
			return false;
		}
		if(!(giaTriHD.length()>0)){
			JOptionPane.showMessageDialog(this,"NHẬP GIÁ TRỊ HỢP ĐỒNG.");
		}
		if(!(soLuongSP.length()>0)){
			JOptionPane.showMessageDialog(this,"SỐ LƯỢNG SẢN PHẨM.");
		}
		if (soLuongSP.length() > 0) {
			try {
				int y = Integer.parseInt(soLuongSP);
				if (y <= 0) {
					JOptionPane.showMessageDialog(this,"SỐ LƯỢNG SẢN PHẨM PHẢI LỚN HƠN 0.");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,"SỐ LƯỢNG SẢN PHẨM PHẢI NHẬP SỐ.");
				return false;
			}
		}
		if (giaTriHD.length() > 0) {
			try {
				double y = Double.parseDouble(giaTriHD);
				if (y <= 0) {
					JOptionPane.showMessageDialog(this,"GIÁ TRỊ HỢP ĐỒNG PHẢI LỚN HƠN 0.");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,"GIÁ TRỊ HỌP ĐỒNG PHẢI NHẬP SỐ.");
				return false;
			}
		}
		if (!(comboBoxMaKH.getSelectedIndex()>=0)) {
			JOptionPane.showMessageDialog(this, "CHỌN MÃ KHÁCH HÀNG ");
			return false;
		}
		if (!(comboBoxMaNV.getSelectedIndex()>=0)) {
			JOptionPane.showMessageDialog(this, "CHỌN MÃ NHÂN VIÊN ");
			return false;
		}
		if (!(comboBoxMaSP.getSelectedIndex()>=0)) {
			JOptionPane.showMessageDialog(this, "CHỌN MÃ SẢN PHẨM ");
			return false;
		}
		if (!(ngayTao.before(ngayHetHan))) {
			JOptionPane.showMessageDialog(this, "NGÀY HẾT HẠN PHẢI SAU NGÀY TẠO");
			return false;
		}
		return true;
	}
	
	ListSelectionListener selectRow = new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			int row = tableQLHD.getSelectedRow(); 
			if(row != -1){
				String maHD = tableQLHD.getValueAt(row, 0).toString();
				HopDong hopDong = new HopDong(maHD);
				ChiTietHopDong chiTietHopDong = new ChiTietHopDong(hopDong);
				ArrayList<HopDong> listHopDong = hopDong_DAO.getAllHopDong();
				ArrayList<ChiTietHopDong> listChiTietHopDong = hopDong_DAO.getAllChiTietHopDong();
				if(hopDong_DAO.getAllHopDong().contains(hopDong)){
					hopDong = listHopDong.get(listHopDong.indexOf(hopDong));
					chiTietHopDong = listChiTietHopDong.get(listChiTietHopDong.indexOf(chiTietHopDong));
					String thongTinchiTiet = hopDong_DAO.getChiTietHopDong(maHD);
					chiTietHD.setText(thongTinchiTiet);
					comboBoxMaKH.setSelectedItem(tableQLHD.getValueAt(row, 4));
					textFieldMaHD.setText(hopDong.getMaHD());
					textFieldtenHD.setText(chiTietHopDong.getTenHD());
					textFieldSoLuongSanPham.setText(chiTietHopDong.getSoLuongSP()+"");
					textFieldGiaTriHD.setText((long)chiTietHopDong.getGiaTriHD()+"");
					comboBoxMaSP.setSelectedItem(tableQLHD.getValueAt(row, 3));
					comboBoxMaNV.setSelectedItem(tableQLHD.getValueAt(row, 5));
					ngayTaoHD.getJFormattedTextField().setText(hopDong.getNgayTao()+"");
					ngayHetHanHD.getJFormattedTextField().setText(hopDong.getNgayHetHan()+"");
					chckbxThanhToan.setSelected(chiTietHopDong.isThanhToan());
				}
			}
		}
	};
	MouseListener mouseListener =  new MouseListener() {
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {
			tableQLHD.setEnabled(true);	
		}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseClicked(MouseEvent e) {
			tableQLHD.clearSelection();
			tableQLHD.setEnabled(false);
			chiTietHD.setText("");
			tableQLHD.setRowSorter(filter);
			filter.setRowFilter(RowFilter.regexFilter(""));
		}
	};
	private JLabel lblNewLabel;
	
	public void nhanThem() {
		themHopDong.setVisible(true);
		suaHD.setVisible(false);
		nhap_SuaHD.setVisible(true);
		tableQLHD.clearSelection();
		taoMaHD();
		chiTietHD.setText("");
		textFieldtenHD.setText("");
		textFieldSoLuongSanPham.setText("");
		textFieldGiaTriHD.setText("");
		comboBoxMaKH.setSelectedItem(-1);
		comboBoxMaNV.setSelectedItem(-1);
		comboBoxMaSP.setSelectedItem(-1);
		chckbxThanhToan.setSelected(false);
		ngayTaoHD.getJFormattedTextField().setText("");
		ngayHetHanHD.getJFormattedTextField().setText("");
	}
	
	public void nhanThemHD(){
		String maHD = textFieldMaHD.getText();
		String tenHD = textFieldtenHD.getText();
		int soLuongSP = Integer.parseInt(textFieldSoLuongSanPham.getText());
		double giaTriHD = Double.parseDouble(textFieldGiaTriHD.getText());
		String maSP = comboBoxMaSP.getSelectedItem().toString();
		String maKH = comboBoxMaKH.getSelectedItem().toString();
		String maNV = comboBoxMaNV.getSelectedItem().toString();
		Date ngayTao = (Date) ngayTaoHD.getModel().getValue();
		Date ngayHetHan = (Date) ngayHetHanHD.getModel().getValue();
		boolean thanhToan = chckbxThanhToan.isSelected();
		
		SanPham sanPham = new SanPham(maSP);
		KhachHang khachHang = new KhachHang(maKH);
		NhanVienHanhChinh nhanVienHanhChinh = new NhanVienHanhChinh(maNV);
		HopDong hopDong = new HopDong(maHD, ngayTao, ngayHetHan, nhanVienHanhChinh, khachHang, sanPham);
		ChiTietHopDong chiTietHopDong = new ChiTietHopDong(hopDong, tenHD, soLuongSP, giaTriHD, thanhToan);
		if(!hopDong_DAO.getAllHopDong().contains(hopDong)) {
			try {
				hopDong_DAO.creatHopDong(hopDong);
				hopDong_DAO.createChiTietHopDong(chiTietHopDong);
				modelHopDong.addRow(new Object[] {
						hopDong.getMaHD(),hopDong.getNgayTao(),hopDong.getNgayHetHan(),hopDong.getMaSP().getMaSP(),hopDong.getMaKH().getMaKhachHang(),hopDong.getMaNV().getMaNhanVien(),(chckbxThanhToan.isSelected()?" Đã thanh toán":" Chưa thanh toán")
				});
				textFieldMaHD.setText("");
				textFieldtenHD.setText("");
				textFieldSoLuongSanPham.setText("");
				textFieldGiaTriHD.setText("");
				comboBoxMaKH.setSelectedItem(null);
				comboBoxMaNV.setSelectedItem(null);
				comboBoxMaSP.setSelectedItem(null);
				chckbxThanhToan.setSelected(false);
				ngayTaoHD.getJFormattedTextField().setText("");
				ngayHetHanHD.getJFormattedTextField().setText("");
				nhanThem();
				JOptionPane.showMessageDialog(this, "Thêm thành công");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(this, "TRÙNG!");
		}	
	}
	
	public void xoaHD() {
		int row = tableQLHD.getSelectedRow();
		if(row != -1){
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Chắc chắn xóa không? ", "Chú ý", JOptionPane.YES_NO_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION){
				String maHD = tableQLHD.getValueAt(row, 0).toString();
				if(hopDong_DAO.deleteChiTietHopDong(maHD)) {
					hopDong_DAO.deleteHopDong(maHD);
					modelHopDong.removeRow(row);
					chiTietHD.setText("");
					JOptionPane.showMessageDialog(this, "Đã xóa 1 hợp đồng.");										
				}
				else {
					JOptionPane.showMessageDialog(this, "không xóa được");
				}
			}
		}else
			JOptionPane.showMessageDialog(this, "Bạn phải chọn hợp đồng cần xóa. ");
	}
	public void suaHD() {
		int row = tableQLHD.getSelectedRow();
		String maHD = textFieldMaHD.getText();
		String tenHD = textFieldtenHD.getText();
		int soLuongSP = Integer.parseInt(textFieldSoLuongSanPham.getText());
		double giaTriHD = Double.parseDouble(textFieldGiaTriHD.getText());
		String maSP = comboBoxMaSP.getSelectedItem().toString();
		String maKH = comboBoxMaKH.getSelectedItem().toString();
		String maNV = comboBoxMaNV.getSelectedItem().toString();
		Date ngayTao = (Date) ngayTaoHD.getModel().getValue();
		Date ngayHetHan = (Date) ngayHetHanHD.getModel().getValue();
		boolean thanhToan = chckbxThanhToan.isSelected();
		if(ngayTao==null)
			ngayTao = (Date) tableQLHD.getValueAt(row, 1);
		if (ngayHetHan==null)
			ngayHetHan = (Date) tableQLHD.getValueAt(row, 2);
		
		if (kiemTraNhapHopDong(tenHD, Integer.toString(soLuongSP), Double.toString(giaTriHD), ngayTao, ngayHetHan)) {
			SanPham sanPham = new SanPham(maSP);
			KhachHang khachHang = new KhachHang(maKH);
			NhanVienHanhChinh nhanVienHanhChinh = new NhanVienHanhChinh(maNV);
			HopDong hopDong = new HopDong(maHD, ngayTao, ngayHetHan, nhanVienHanhChinh, khachHang, sanPham);
			ChiTietHopDong chiTietHopDong = new ChiTietHopDong(hopDong, tenHD, soLuongSP, giaTriHD, thanhToan);
			String dieuKien = tableQLHD.getValueAt(row, 0).toString();				
			if(hopDong_DAO.updateChiTietHopDong(chiTietHopDong, dieuKien)) {
				hopDong_DAO.updateHopDong(hopDong, dieuKien);
				tableQLHD.setValueAt(maHD, row, 0);
				tableQLHD.setValueAt(ngayTao, row, 1);
				tableQLHD.setValueAt(ngayHetHan, row, 2);
				tableQLHD.setValueAt(maSP, row, 3);
				tableQLHD.setValueAt(maKH, row, 4);
				tableQLHD.setValueAt(maNV, row, 5);
				tableQLHD.setValueAt(thanhToan?" Đã thanh toán":" Chưa thanh toán", row, 6);
				
				nhap_SuaHD.setVisible(false);
				JOptionPane.showMessageDialog(this,"Đã sửa thành công");
				
			}
			else {
				JOptionPane.showMessageDialog(this, "Không sửa được");
			}
		}
	}
	public void timKiem() {
		int select = loaiTimKiem.getSelectedIndex();
		if(select==0) {
			tableQLHD.setRowSorter(filter);
			filter.setRowFilter(RowFilter.regexFilter(timKiem.getText(),0));
		}
		if (select==1) {
			tableQLHD.setRowSorter(filter);
			filter.setRowFilter(RowFilter.regexFilter(timKiem.getText(),5));
		}
		if (select==2) {
			tableQLHD.setRowSorter(filter);
			filter.setRowFilter(RowFilter.regexFilter(timKiem.getText(),4));
		}
		if (timKiem.getText().length()<=0) {
			JOptionPane.showMessageDialog(this, "PHẢI NHẬP ĐIỀU KIỆN ĐỂ TÌM KIẾM");
		}
	}
	public void xoaRong() {
		tableQLHD.clearSelection();
		chiTietHD.setText("");
		textFieldtenHD.setText("");
		textFieldSoLuongSanPham.setText("");
		textFieldGiaTriHD.setText("");
		comboBoxMaKH.setSelectedItem(-1);
		comboBoxMaNV.setSelectedItem(-1);
		comboBoxMaSP.setSelectedItem(-1);
		chckbxThanhToan.setSelected(false);
		ngayTaoHD.getJFormattedTextField().setText("");
		ngayHetHanHD.getJFormattedTextField().setText("");
	}
	public void taoMaHD() {
		int maSoHD = hopDong_DAO.getAllHopDong().size();	
		if(maSoHD==0)
			textFieldMaHD.setText("HD_No."+(maSoHD+1));
		else {
			HopDong hopDong =  hopDong_DAO.getAllHopDong().get(maSoHD-1);
			String maSoHopDongCuoi = hopDong.getMaHD().substring(6);
			textFieldMaHD.setText("HD_No."+(Integer.parseInt(maSoHopDongCuoi)+1));
		}
	}
}

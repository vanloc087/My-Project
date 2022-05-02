package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DAO_NhanVienHanhChinh;
import dao.DAO_PhieuLuongNhanVien;
import entity.NhanVienHanhChinh;
import entity.PhieuLuongNhanVien;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;

public class GUI_QuanLyLuongNhanVien extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAO_PhieuLuongNhanVien dao_PhieuLuongNhanVien = new DAO_PhieuLuongNhanVien();
	private DAO_NhanVienHanhChinh dao_NhanVien = new DAO_NhanVienHanhChinh();
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_ThucLanh;
	private JLabel lblNewLabel_2;
	private JTextField textField_NVTao;
	private JTextField textField_NgayTao;
	private JTextField textField_MaPhieu;
	private JTable table_1;
	private JTextField textField_TimKiemPL;
	private JTextField textField_TimKiemNV;
	private JTextField textField_Nam;
	private DefaultTableModel model, model1;
	private JTextField textField_NgayNghi;
	private JTextField textField_NghiCoTroCap;
	private JTextField textField_SoGoTangCa;
	private JButton btnNewButton_Xoa,btnNewButton_Them,btnNewButton_TinhLuong,btnNewButton_SapXepPL,
	btnNewButton_TimKiemPL,btnNewButton_SapXepNV,btnNewButton_TimKiemNV ;
	private JComboBox<String> comboBox_SapXepPL,comboBox_Thang,comboBox_SapXepNV;
	private JPanel panel_2,panel_1,panel;
	private JButton btnTaiLaiNV;
	private JButton btnTaiLaiPL;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLyLuongNhanVien frame = new GUI_QuanLyLuongNhanVien();
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
	public GUI_QuanLyLuongNhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 650);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(14, 10, 1330, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Lương Nhân Viên");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 38));
		lblNewLabel.setBounds(0, 0, 460, 46);
		panel.add(lblNewLabel);
		
		lblNewLabel_9 = new JLabel("Mã nhân viên:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(909, 25, 133, 14);
		panel.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setToolTipText("Mã nhân viên đang đăng nhập");
		lblNewLabel_10.setText(GUI_DangNhap.getDnma());
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(1107, 25, 133, 14);
		panel.add(lblNewLabel_10);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(14, 64, 1330, 204);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 50, 762, 105);
		panel_1.add(scrollPane);
		
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
					return Double.class;
				case 5:
					return String.class;
				case 6:
					return String.class;
				default:
				return String.class;
				}
			}
			boolean[] columnEditables = new boolean[] {
					false,false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			
		};
		table = new JTable(model);
		model.addColumn("STT");
		model.addColumn("Mã Nhân Viên");
		model.addColumn("Họ Tên");
		model.addColumn("Giới Tính");
		model.addColumn("Lương Cơ Bản");
		model.addColumn("Đơn Vị");
		model.addColumn("Chức Vụ");
		table.getColumnModel().getColumn(0).setPreferredWidth(4);
		scrollPane.setViewportView(table);
		
		textField_ThucLanh = new JTextField();
		textField_ThucLanh.setEditable(false);
		textField_ThucLanh.setForeground(Color.BLUE);
		textField_ThucLanh.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_ThucLanh.setBounds(127, 166, 331, 28);
		panel_1.add(textField_ThucLanh);
		textField_ThucLanh.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Thực Lãnh:");
		lblNewLabel_2.setBounds(10, 166, 111, 36);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("    Nhân Viên");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setForeground(new Color(51, 51, 204));
		lblNewLabel_3.setBounds(-13, 0, 126, 22);
		panel_1.add(lblNewLabel_3);
		
		textField_NVTao = new JTextField();
		textField_NVTao.setEditable(false);
		textField_NVTao.setBounds(1175, 162, 126, 23);
		panel_1.add(textField_NVTao);
		textField_NVTao.setColumns(10);
		
		textField_NgayTao = new JTextField();
		textField_NgayTao.setEditable(false);
		textField_NgayTao.setBounds(1175, 65, 126, 23);
		panel_1.add(textField_NgayTao);
		textField_NgayTao.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày tạo:");
		lblNewLabel_4.setBounds(1090, 71, 61, 17);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nhân viên tạo:");
		lblNewLabel_5.setBounds(1090, 165, 97, 17);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mã phiếu:");
		lblNewLabel_6.setBounds(1090, 115, 61, 17);
		panel_1.add(lblNewLabel_6);
		
		textField_MaPhieu = new JTextField();
		textField_MaPhieu.setEditable(false);
		textField_MaPhieu.setBounds(1175, 112, 126, 23);
		panel_1.add(textField_MaPhieu);
		textField_MaPhieu.setColumns(10);
		
		textField_TimKiemNV = new JTextField();
		textField_TimKiemNV.setToolTipText("Nhập vào thông tin nhân viên cần tìm");
		textField_TimKiemNV.setBounds(0, 24, 267, 23);
		panel_1.add(textField_TimKiemNV);
		textField_TimKiemNV.setColumns(10);
		
		btnNewButton_TimKiemNV = new JButton("Tìm Kiếm");
		btnNewButton_TimKiemNV.setToolTipText("Tìm kiếm nhân viên theo thông tin đã nhập");
		btnNewButton_TimKiemNV.setBounds(270, 23, 105, 25);
		panel_1.add(btnNewButton_TimKiemNV);
		
		comboBox_SapXepNV = new JComboBox<String>();
		comboBox_SapXepNV.setToolTipText("Chọn loại sắp xếp hiển thị bảng nhân viên");
		comboBox_SapXepNV.setModel(new DefaultComboBoxModel<String>(new String[] {"Sắp xếp theo mã", "Sắp xếp theo tên", "Sắp xếp theo đơn vị", "Sắp xếp theo chức vụ"}));
		comboBox_SapXepNV.setBounds(385, 24, 151, 22);
		panel_1.add(comboBox_SapXepNV);
		
		btnNewButton_SapXepNV = new JButton("Sắp Xếp");
		btnNewButton_SapXepNV.setToolTipText("Sắp xếp bảng nhân viên theo loại đã chọn");
		btnNewButton_SapXepNV.setBounds(546, 23, 105, 25);
		panel_1.add(btnNewButton_SapXepNV);
		
		comboBox_Thang = new JComboBox<String>();
		comboBox_Thang.setToolTipText("Chọn tháng muốn tính lương");
		comboBox_Thang.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11", "12"}));
		comboBox_Thang.setBounds(1015, 25, 51, 22);
		panel_1.add(comboBox_Thang);
		
		textField_Nam = new JTextField();
		textField_Nam.setToolTipText("Nhập vào năm muốn tính lương");
		textField_Nam.setText("2021");
		textField_Nam.setBounds(1225, 25, 76, 20);
		panel_1.add(textField_Nam);
		textField_Nam.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Tháng tính lương:");
		lblNewLabel_7.setBounds(856, 29, 151, 14);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Năm tính lương:");
		lblNewLabel_8.setBounds(1090, 29, 129, 14);
		panel_1.add(lblNewLabel_8);
		
		textField_NgayNghi = new JTextField();
		textField_NgayNghi.setEditable(false);
		textField_NgayNghi.setColumns(10);
		textField_NgayNghi.setBounds(911, 68, 126, 23);
		panel_1.add(textField_NgayNghi);
		
		JLabel lblNewLabel_6_1 = new JLabel("Sô Ngày Nghỉ:");
		lblNewLabel_6_1.setBounds(772, 72, 97, 17);
		panel_1.add(lblNewLabel_6_1);
		
		textField_NghiCoTroCap = new JTextField();
		textField_NghiCoTroCap.setEditable(false);
		textField_NghiCoTroCap.setColumns(10);
		textField_NghiCoTroCap.setBounds(911, 113, 126, 23);
		panel_1.add(textField_NghiCoTroCap);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Nghỉ Có Trợ Cấp:");
		lblNewLabel_6_1_1.setBounds(772, 116, 129, 17);
		panel_1.add(lblNewLabel_6_1_1);
		
		textField_SoGoTangCa = new JTextField();
		textField_SoGoTangCa.setEditable(false);
		textField_SoGoTangCa.setColumns(10);
		textField_SoGoTangCa.setBounds(911, 162, 126, 23);
		panel_1.add(textField_SoGoTangCa);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("Số Giờ Tăng Ca:");
		lblNewLabel_6_1_1_1.setBounds(772, 166, 129, 17);
		panel_1.add(lblNewLabel_6_1_1_1);
		
		btnTaiLaiNV = new JButton("Tải Lại");
		btnTaiLaiNV.setToolTipText("Tait lại nội dung bảng nhân viên");
		btnTaiLaiNV.setBounds(661, 23, 97, 25);
		panel_1.add(btnTaiLaiNV);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(14, 271, 1330, 342);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setToolTipText("Bảng phiếu lương nhân viên");
		scrollPane_1.setBounds(0, 51, 1330, 244);
		panel_2.add(scrollPane_1);
		
		model1 =new DefaultTableModel() {
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
					return String.class;
				case 8:
					return Double.class;
				case 9:
					return String.class;
				case 10:
					return String.class;
				case 11:
					return String.class;
				case 12:
					return Double.class;
				case 13:
					return String.class;
				case 14:
					return String.class;
					
				default:
				return String.class;
				}
			}
			boolean[] columnEditables = new boolean[] {
					false,false, false, false, false, false, false, false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			
		};
		table_1 = new JTable(model1);
		model1.addColumn("STT");
		model1.addColumn("Mã");
		model1.addColumn("Tháng Lương");
		model1.addColumn("Mã Nhân Viên");
		model1.addColumn("Họ Tên");
		model1.addColumn("Giới Tính");
		model1.addColumn("Chức Vụ");
		model1.addColumn("Đơn Vị");
		model1.addColumn("Lương Cơ Bản");
		model1.addColumn("Ngày Nghỉ");
		model1.addColumn("Nghỉ Trợ Cấp");
		model1.addColumn("Giờ Tăng Ca");
		model1.addColumn("Thực Lãnh");
		model1.addColumn("Người Tạo");
		model1.addColumn("Ngày Tạo");
		table_1.getColumnModel().getColumn(0).setPreferredWidth(4);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(55);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(9).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(10).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(11).setPreferredWidth(55);
		table_1.getColumnModel().getColumn(12).setPreferredWidth(95);
		table_1.getColumnModel().getColumn(14).setPreferredWidth(90);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("Phiếu Lương");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(51, 51, 204));
		lblNewLabel_1.setBounds(14, 0, 128, 17);
		panel_2.add(lblNewLabel_1);
		
		textField_TimKiemPL = new JTextField();
		textField_TimKiemPL.setToolTipText("Nhập vào thông tin phiếu lương cần tìm");
		textField_TimKiemPL.setForeground(Color.BLUE);
		textField_TimKiemPL.setBounds(0, 24, 270, 23);
		panel_2.add(textField_TimKiemPL);
		textField_TimKiemPL.setColumns(10);
		
		btnNewButton_TimKiemPL = new JButton("Tìm kiếm");
		btnNewButton_TimKiemPL.setToolTipText("Tìm kiếm theo thông tin phiếu lương đã nhập");
		btnNewButton_TimKiemPL.setBounds(275, 23, 105, 25);
		panel_2.add(btnNewButton_TimKiemPL);
		
		comboBox_SapXepPL = new JComboBox<String>();
		comboBox_SapXepPL.setToolTipText("Chọn loại sắp xếp hiển thị bảng phiếu lương");
		comboBox_SapXepPL.setModel(new DefaultComboBoxModel<String>(new String[] {"Sắp xếp theo mã", "Sắp xếp theo công nhân","Sắp xếp theo tên công nhân", "Sắp xếp theo mã người tạo" ,"Sắp xếp theo ngày tạo"}));
		comboBox_SapXepPL.setBounds(459, 23, 192, 25);
		panel_2.add(comboBox_SapXepPL);
		
		btnNewButton_SapXepPL = new JButton("Sắp Xếp");
		btnNewButton_SapXepPL.setToolTipText("Sắp xếp thep loại đã chọn");
		btnNewButton_SapXepPL.setBounds(655, 23, 105, 25);
		panel_2.add(btnNewButton_SapXepPL);
		
		btnNewButton_TinhLuong = new JButton("Tính Lương");
		btnNewButton_TinhLuong.setToolTipText("Tính lương nhân viên theo tháng/năm đã chọn");
		btnNewButton_TinhLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_TinhLuong.setBounds(402, 297, 156, 38);
		panel_2.add(btnNewButton_TinhLuong);
		
		btnNewButton_Them = new JButton("Thêm Phiếu Lương");
		btnNewButton_Them.setToolTipText("Thêm phiếu lương vào dữ liệu");
		btnNewButton_Them.setBounds(586, 297, 174, 38);
		panel_2.add(btnNewButton_Them);
		
		btnNewButton_Xoa = new JButton("Xóa Phiếu Lương");
		btnNewButton_Xoa.setToolTipText("Xóa phiếu lương đã chọn");
		btnNewButton_Xoa.setBounds(790, 297, 143, 38);
		panel_2.add(btnNewButton_Xoa);
		
		btnTaiLaiPL = new JButton("Tải Lại");
		btnTaiLaiPL.setToolTipText("Tải lại nội dung bảng phiếu lương");
		btnTaiLaiPL.setBounds(802, 24, 97, 25);
		panel_2.add(btnTaiLaiPL);
		
		btnNewButton_SapXepNV.addActionListener(this);
		btnNewButton_SapXepPL.addActionListener(this);
		btnNewButton_Them.addActionListener(this);
		btnNewButton_TimKiemNV.addActionListener(this);
		btnNewButton_TimKiemPL.addActionListener(this);
		btnNewButton_TinhLuong.addActionListener(this);
		btnNewButton_Xoa.addActionListener(this);
		btnTaiLaiNV.addActionListener(this);
		btnTaiLaiPL.addActionListener(this);
		table.addMouseListener(this);
		table_1.addMouseListener(this);
		panel_1.addMouseListener(this);
		docDuLieuDatabaseVaoTable();
		docDuLieuDatabaseVaoTable1();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnNewButton_SapXepNV)) {
			String loai =  comboBox_SapXepNV.getSelectedItem().toString();
			if(loai.equals("Sắp xếp theo mã")) {
				xoaHetDuLieuTrenTableModel();
				docDuLieuDatabaseVaoTable();
			}
			if(loai.equals("Sắp xếp theo tên")) {
				xoaHetDuLieuTrenTableModel();
				docDuLieuDatabaseVaoTableTheoTen();
			}
			if(loai.equals("Sắp xếp theo chức vụ")) {
				xoaHetDuLieuTrenTableModel();
				docDuLieuDatabaseVaoTableTheoCV();
			}
			if(loai.equals("Sắp xếp theo đơn vị")) {
				xoaHetDuLieuTrenTableModel();
				docDuLieuDatabaseVaoTableTheoDV();
			}
		}
		if(o.equals(btnNewButton_SapXepPL)) {
			String loai =  comboBox_SapXepPL.getSelectedItem().toString();
			if(loai.equals("Sắp xếp theo mã")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1();
			}
			if(loai.equals("Sắp xếp theo công nhân")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoNV();
			}
			if(loai.equals("Sắp xếp theo ngày tạo")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoNgayTao();
			}
			if(loai.equals("Sắp xếp theo mã người tạo")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoMaNguoiTao();
			}
			if(loai.equals("Sắp xếp theo tháng lương")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoThangLuong();
			}
			if(loai.equals("Sắp xếp theo tên công nhân")) {
				xoaHetDuLieuTrenTableMode_1();
				docDuLieuDatabaseVaoTable1TheoTen();
			}
		}
		if(o.equals(btnTaiLaiNV)) {
			taiLaiBang();
		}
		if(o.equals(btnTaiLaiPL)) {
			taiLaiBang1();
		}
		if(o.equals(btnNewButton_TimKiemNV)) {
			String str = textField_TimKiemNV.getText();
			xoaHetDuLieuTrenTableModel();
			List<NhanVienHanhChinh> list = dao_NhanVien.getAllNhanVienHanhChinh();
			int stt=1;
			for (NhanVienHanhChinh nv : list) {
				String str2=nv.getMaNhanVien()+nv.getChucVu()+nv.getHoTen()+nv.getDonViCongTac();
				if(str2.contains(str)) {
				model.addRow(new Object[] {
						stt,nv.getMaNhanVien(), nv.getHoTen(),nv.getGioiTinh(),nv.getHeSoluong(),nv.getDonViCongTac(),nv.getChucVu()
				});
				stt++;
				}
			}
			
		}
		if(o.equals(btnNewButton_TimKiemPL)) {
			String str = textField_TimKiemPL.getText();
			xoaHetDuLieuTrenTableMode_1();
			List<PhieuLuongNhanVien> list = dao_PhieuLuongNhanVien.getAllPhieuLuongNhanVien();
			int stt=1;
			for (PhieuLuongNhanVien plcn : list) {
				String str2 = plcn.getMaPhieuLuong()+plcn.getHoTen()+plcn.getDonViCongTac()+plcn.getMaNguoiHuong()+plcn.getMaNguoiTao()+plcn.getChucVu()+plcn.getNgayTao().toString()+plcn.getThangLuong();
				if(str2.contains(str)) {
				model1.addRow(new Object[] {
						stt,plcn.getMaPhieuLuong(),plcn.getThangLuong(),plcn.getMaNguoiHuong(),plcn.getHoTen(),plcn.getGioiTinh(),plcn.getChucVu(),
						plcn.getDonViCongTac(),plcn.getHeSoLuong(),plcn.getNgayNghi(),plcn.getNgayNghiCoPhep(),plcn.getSoGioTangCa(),plcn.getThanhTien(),plcn.getMaNguoiTao(),plcn.getNgayTao()
				});
				stt++;
				}
			}
			
		}
		if(o.equals(btnNewButton_Xoa)) {
			if( textField_MaPhieu.getText().equals(""))

				JOptionPane.showMessageDialog(this, "Hãy chọn phiếu cần xóa");
			else {
				int hoinhac = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xóa phiếu lương này?","Warnning",JOptionPane.YES_NO_CANCEL_OPTION);
				if(hoinhac == JOptionPane.YES_OPTION) {
					try {
							int r= table_1.getSelectedRow();
							model1.removeRow(r); 
							dao_PhieuLuongNhanVien.xoaPL(textField_MaPhieu.getText());
							JOptionPane.showMessageDialog(this, "Xóa Thành Công");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}
			}
		}
		if (o.equals(btnNewButton_Them)) {
			if(textField_ThucLanh.getText().equals(""))

				JOptionPane.showMessageDialog(this, "Nhân viên không có thực  lãnh");
			else {
					int row = table.getSelectedRow();
					String tL = textField_Nam.getText()+"-"+comboBox_Thang.getSelectedItem().toString();
					Date ngayTao = Date.valueOf(textField_NgayTao.getText());
					PhieuLuongNhanVien pl= new PhieuLuongNhanVien(textField_MaPhieu.getText(),tL,model.getValueAt(row, 1).toString(),model.getValueAt(row, 2).toString(), model.getValueAt(row, 3).toString(), model.getValueAt(row, 6).toString(),
					 model.getValueAt(row, 5).toString(), Double.parseDouble(model.getValueAt(row, 4).toString()),Integer.parseInt(textField_NgayNghi.getText()),
					Integer.parseInt(textField_NghiCoTroCap.getText()),Integer.parseInt(textField_SoGoTangCa.getText()),
					Double.parseDouble(textField_ThucLanh.getText()),textField_NVTao.getText(),ngayTao);
						dao_PhieuLuongNhanVien.create(pl);
						taiLaiBang1();
						JOptionPane.showMessageDialog(this, "Thêm Thành Công");
						taoMaPhieuLuong();
					}
			}
		if(o.equals(btnNewButton_TinhLuong)) {
			int row = table.getSelectedRow();
			if(row==-1) {
				JOptionPane.showMessageDialog(this, "Hãy chọn nhân viên muốn tính lương ") ;
			}
			else {
			tinhThucLanh();
			taoMaPhieuLuong();
			docNgayTao();
			textField_NVTao.setText(GUI_DangNhap.getDnma());
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if(o.equals(table_1)) {
			try {
				int row = table_1.getSelectedRow();
				DAO_PhieuLuongNhanVien dsnv= new DAO_PhieuLuongNhanVien();
				List<NhanVienHanhChinh> list =dsnv.timMa(model1.getValueAt(row, 3).toString());
				
				textField_MaPhieu.setText(model1.getValueAt(row, 1).toString());
				textField_NgayNghi.setText(model1.getValueAt(row, 9).toString());
				textField_NghiCoTroCap.setText(model1.getValueAt(row, 10).toString());
				textField_SoGoTangCa.setText(model1.getValueAt(row, 11).toString());
				textField_ThucLanh.setText(model1.getValueAt(row, 12).toString());
				textField_NVTao.setText(model1.getValueAt(row, 13).toString());
				textField_NgayTao.setText(model1.getValueAt(row, 14).toString());
				comboBox_Thang.removeAllItems();
				comboBox_Thang.addItem(model1.getValueAt(row, 2).toString().substring(5,7));
				docNamLuong();
				xoaHetDuLieuTrenTableModel();
				int stt=1;
				for(NhanVienHanhChinh nv :list) {
					
					model.addRow(new Object[] {
							stt,nv.getMaNhanVien(), nv.getHoTen(),nv.getGioiTinh(),nv.getHeSoluong(),nv.getDonViCongTac(),nv.getChucVu()
					});
					stt++;
					}
				
				table.setModel(model);
					
				
			} catch (Exception e2) {
				System.out.print(e);
			}
			
		}
		
		if(o.equals(table)) {
			try {
				int row = table.getSelectedRow();
				docSoNgayNghi(model.getValueAt(row, 1).toString());
				docSoGioTangCa(model.getValueAt(row, 1).toString());
				docSoNgayNghiTroCap(model.getValueAt(row, 1).toString());
				xoaHetDuLieuTrenTableMode_1();
				textField_ThucLanh.setText("");
				docPhieuLuongTheoNV(model.getValueAt(row, 1).toString());
			} catch (Exception e2) {
				System.out.print(e);
			}
		}
		if(o.equals(panel_1)) {
			xoaTrang();
			taiLaiBang1();
			docThangLuong();
			table.clearSelection();
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

	
	public void docPhieuLuongTheoNV(String ma) {
		try {
		List<PhieuLuongNhanVien> list = dao_PhieuLuongNhanVien.getPhieuLuongTheoNV(ma);
		int stt=1;
		for (PhieuLuongNhanVien plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaPhieuLuong(),plcn.getThangLuong(),plcn.getMaNguoiHuong(),plcn.getHoTen(),plcn.getGioiTinh(),plcn.getChucVu(),
					plcn.getDonViCongTac(),plcn.getHeSoLuong(),plcn.getNgayNghi(),plcn.getNgayNghiCoPhep(),plcn.getSoGioTangCa(),plcn.getThanhTien(),plcn.getMaNguoiTao(),plcn.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
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
	
	public void xoaTrang(){
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		textField_NgayTao.setText(date.toString());
		textField_MaPhieu.setText("");
		textField_NgayNghi.setText("");
		textField_NghiCoTroCap.setText("");
		textField_SoGoTangCa.setText("");
		textField_ThucLanh.setText("");
		textField_NVTao.setText("");
		
		
	}
	
	public void docDuLieuDatabaseVaoTable() {
		try {
		List<NhanVienHanhChinh> list = dao_NhanVien.getAllNhanVienHanhChinh();
		int stt=1;
		for (NhanVienHanhChinh nv : list) {
			model.addRow(new Object[] {
					stt,nv.getMaNhanVien(), nv.getHoTen(),nv.getGioiTinh(),nv.getHeSoluong(),nv.getDonViCongTac(),nv.getChucVu()
			});
			stt++;
			
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void docDuLieuDatabaseVaoTableTheoTen() {
		try {
		List<NhanVienHanhChinh> list = dao_NhanVien.getAllNhanVienHanhChinhTheoTen();
		int stt=1;
		for (NhanVienHanhChinh nv : list) {
			model.addRow(new Object[] {
					stt,nv.getMaNhanVien(), nv.getHoTen(),nv.getGioiTinh(),nv.getHeSoluong(),nv.getDonViCongTac(),nv.getChucVu()
			});
			stt++;
			
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void docDuLieuDatabaseVaoTableTheoCV() {
		try {
		List<NhanVienHanhChinh> list = dao_NhanVien.getAllNhanVienHanhChinhTheoCV();
		int stt=1;
		for (NhanVienHanhChinh nv : list) {
			model.addRow(new Object[] {
					stt,nv.getMaNhanVien(), nv.getHoTen(),nv.getGioiTinh(),nv.getHeSoluong(),nv.getDonViCongTac(),nv.getChucVu()
			});
			stt++;
			
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void docDuLieuDatabaseVaoTableTheoDV() {
		try {
		List<NhanVienHanhChinh> list = dao_NhanVien.getAllNhanVienHanhChinhTheoDV();
		int stt=1;
		for (NhanVienHanhChinh nv : list) {
			model.addRow(new Object[] {
					stt,nv.getMaNhanVien(), nv.getHoTen(),nv.getGioiTinh(),nv.getHeSoluong(),nv.getDonViCongTac(),nv.getChucVu()
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
		List<PhieuLuongNhanVien> list = dao_PhieuLuongNhanVien.getAllPhieuLuongNhanVien();
		int stt=1;
		for (PhieuLuongNhanVien plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaPhieuLuong(),plcn.getThangLuong(),plcn.getMaNguoiHuong(),plcn.getHoTen(),plcn.getGioiTinh(),plcn.getChucVu(),
					plcn.getDonViCongTac(),plcn.getHeSoLuong(),plcn.getNgayNghi(),plcn.getNgayNghiCoPhep(),plcn.getSoGioTangCa(),plcn.getThanhTien(),plcn.getMaNguoiTao(),plcn.getNgayTao()
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
		List<PhieuLuongNhanVien> list = dao_PhieuLuongNhanVien.getAllPhieuLuongNhanVienNV();
		int stt=1;
		for (PhieuLuongNhanVien plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaPhieuLuong(),plcn.getThangLuong(),plcn.getMaNguoiHuong(),plcn.getHoTen(),plcn.getGioiTinh(),plcn.getChucVu(),
					plcn.getDonViCongTac(),plcn.getHeSoLuong(),plcn.getNgayNghi(),plcn.getNgayNghiCoPhep(),plcn.getSoGioTangCa(),plcn.getThanhTien(),plcn.getMaNguoiTao(),plcn.getNgayTao()
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
		List<PhieuLuongNhanVien> list = dao_PhieuLuongNhanVien.getAllPhieuLuongNhanVienNgayTao();
		int stt=1;
		for (PhieuLuongNhanVien plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaPhieuLuong(),plcn.getThangLuong(),plcn.getMaNguoiHuong(),plcn.getHoTen(),plcn.getGioiTinh(),plcn.getChucVu(),
					plcn.getDonViCongTac(),plcn.getHeSoLuong(),plcn.getNgayNghi(),plcn.getNgayNghiCoPhep(),plcn.getSoGioTangCa(),plcn.getThanhTien(),plcn.getMaNguoiTao(),plcn.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTable1TheoMaNguoiTao() {
		try {
		List<PhieuLuongNhanVien> list = dao_PhieuLuongNhanVien.getAllPhieuLuongNhanVienNguoiTao();
		int stt=1;
		for (PhieuLuongNhanVien plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaPhieuLuong(),plcn.getThangLuong(),plcn.getMaNguoiHuong(),plcn.getHoTen(),plcn.getGioiTinh(),plcn.getChucVu(),
					plcn.getDonViCongTac(),plcn.getHeSoLuong(),plcn.getNgayNghi(),plcn.getNgayNghiCoPhep(),plcn.getSoGioTangCa(),plcn.getThanhTien(),plcn.getMaNguoiTao(),plcn.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTable1TheoThangLuong() {
		try {
		List<PhieuLuongNhanVien> list = dao_PhieuLuongNhanVien.getAllPhieuLuongNhanVienThangLuong();
		int stt=1;
		for (PhieuLuongNhanVien plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaPhieuLuong(),plcn.getThangLuong(),plcn.getMaNguoiHuong(),plcn.getHoTen(),plcn.getGioiTinh(),plcn.getChucVu(),
					plcn.getDonViCongTac(),plcn.getHeSoLuong(),plcn.getNgayNghi(),plcn.getNgayNghiCoPhep(),plcn.getSoGioTangCa(),plcn.getThanhTien(),plcn.getMaNguoiTao(),plcn.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTable1TheoTen() {
		try {
		List<PhieuLuongNhanVien> list = dao_PhieuLuongNhanVien.getAllPhieuLuongNhanVienTen();
		int stt=1;
		for (PhieuLuongNhanVien plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaPhieuLuong(),plcn.getThangLuong(),plcn.getMaNguoiHuong(),plcn.getHoTen(),plcn.getGioiTinh(),plcn.getChucVu(),
					plcn.getDonViCongTac(),plcn.getHeSoLuong(),plcn.getNgayNghi(),plcn.getNgayNghiCoPhep(),plcn.getSoGioTangCa(),plcn.getThanhTien(),plcn.getMaNguoiTao(),plcn.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
	
	private void xoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();

		}
	
	private void xoaHetDuLieuTrenTableMode_1() {
		DefaultTableModel dm = (DefaultTableModel) table_1.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();

		}
	private void taiLaiBang1(){
		xoaHetDuLieuTrenTableMode_1();
		docDuLieuDatabaseVaoTable1();
	}
	
	private void taiLaiBang(){
		xoaHetDuLieuTrenTableModel();
		docDuLieuDatabaseVaoTable();
	}
	
	
	private void taoMaPhieuLuong() {
		String ma= dao_PhieuLuongNhanVien.getMaLonNhat();
		int maMoi;
		maMoi =Integer.parseInt(ma.substring(4, 8)) + 1;
		if(maMoi<10000) {
			textField_MaPhieu.setText("PLNV"+maMoi);
		}
		if(maMoi<1000) {
			textField_MaPhieu.setText("PLNV0"+maMoi);
		}
		if(maMoi<100) {
			textField_MaPhieu.setText("PLNV00"+maMoi);
		}
		if(maMoi<10) {
			textField_MaPhieu.setText("PLNV000"+maMoi);
		}
		
		
		
	}
	
	public void docSoNgayNghi(String ma) {
		try {
			String thangNho = taoThangNhoHon();
			String thangLon = taoThangLonHon();
			String nn = dao_PhieuLuongNhanVien.docSoNgayNghi(ma,thangNho,thangLon);
			textField_NgayNghi.setText(nn);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void docSoNgayNghiTroCap(String ma) {
		try {
			String thangNho = taoThangNhoHon();
			String thangLon = taoThangLonHon();
			String nn = dao_PhieuLuongNhanVien.docSoNgayNghiTroCap(ma,thangNho,thangLon);
			textField_NghiCoTroCap.setText(nn);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void docSoGioTangCa(String ma) {
		try {
			String thangNho = taoThangNhoHon();
			String thangLon = taoThangLonHon();
			String nn = dao_PhieuLuongNhanVien.docSoGioTangCa(ma,thangNho,thangLon);
			textField_SoGoTangCa.setText(nn);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	private void docNamLuong() {
		int row = table_1.getSelectedRow();
		String nam = model1.getValueAt(row, 3).toString().substring(0,4);
		textField_Nam.setText(nam);	
	}
	private void docThangLuong() {
		comboBox_Thang.removeAllItems();
		comboBox_Thang.addItem("01");
		comboBox_Thang.addItem("02");
		comboBox_Thang.addItem("03");
		comboBox_Thang.addItem("04");
		comboBox_Thang.addItem("05");
		comboBox_Thang.addItem("06");
		comboBox_Thang.addItem("07");
		comboBox_Thang.addItem("08");
		comboBox_Thang.addItem("09");
		comboBox_Thang.addItem("10");
		comboBox_Thang.addItem("11");
		comboBox_Thang.addItem("12");
		
	}
	
	private String taoThangLonHon() {
		int t=0;
		String nam = textField_Nam.getText();
		String thang = comboBox_Thang.getSelectedItem().toString();
		t= Integer.parseInt(thang)+1;
		thang = Integer.toString(t);
		if(t<10) {
			thang = "0"+Integer.toString(t);
		}
		if(t>12) {
			thang = "01";
		}
		String thangLonHon;
		thangLonHon =nam+"-"+thang+"-01";
		return thangLonHon;
		
		
	}
	
	private String taoThangNhoHon() {
		String nam = textField_Nam.getText();
		String thang = comboBox_Thang.getSelectedItem().toString();
		String thangNhoHon;
		thangNhoHon =nam+"-"+thang+"-01";
		return thangNhoHon;
		
		
	}
	public void tinhThucLanh() {
		try {
		int row = table.getSelectedRow();
		int soNgayNghi= Integer.parseInt(textField_NgayNghi.getText());
		int soNgayNghiTC=Integer.parseInt(textField_NghiCoTroCap.getText());
		int soGioTangCa=Integer.parseInt(textField_SoGoTangCa.getText());
		Double luongCoBan = Double.parseDouble(model.getValueAt(row, 4).toString());
		Double truTien = soNgayNghi-(soNgayNghiTC*0.05*luongCoBan);
		Double thucLanh = luongCoBan-truTien+(soGioTangCa*0.01*luongCoBan);
		textField_ThucLanh.setText(Double.toString(thucLanh));
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"Năm không đúng định dạng");
		}
	}
	
	
}

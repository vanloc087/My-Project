package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import dao.DAO_BangLuongCongTy;
import entity.BangLuongCongTy;
import java.awt.SystemColor;

public class GUI_QuanLyLuongCongTy extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DAO_BangLuongCongTy dao_BangLuongCongTy = new DAO_BangLuongCongTy();
	private JPanel contentPane;
	private JTextField textField_TongLuong;
	private JLabel lblNewLabel_2;
	private JTextField textField_MaPhieu;
	private JTextField textField_TongLuongNV;
	private JTextField textField_TongSanPham;
	private JTable table_1;
	private JTextField textField_TimKiem;
	private JTextField textField_Nam;
	private JTextField textField_NhanVienTao;
	private JTextField textField_NgayTao;
	private JTextField textField_TongGioTangCa;
	private JTextField textField_TongLuongCN;
	private JPanel panel,panel_2;
	private JButton btnTimKiem,btnSapXep,btnTaiLai, btnXoa,btnTaoMoi,btnSua,btnTinh,btnThem,btnThoat;
	private JComboBox<String> comboBoxSapXep,comboBox_Thang;
	private DefaultTableModel model1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLyLuongCongTy frame = new GUI_QuanLyLuongCongTy();
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
	public GUI_QuanLyLuongCongTy()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 650);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(14, 10, 1322, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Lương Công Ty");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 38));
		lblNewLabel.setBounds(0, 0, 460, 46);
		panel.add(lblNewLabel);
		
		lblNewLabel_3 = new JLabel("Mã nhân viên:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(1014, 27, 131, 14);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setToolTipText("Mã nhân viên đang đăng nhập");
		lblNewLabel_6.setText(GUI_DangNhap.getDnma());
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(1165, 27, 131, 14);
		panel.add(lblNewLabel_6);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(255, 0, 0), new Color(255, 140, 0), new Color(255, 0, 0)));
		panel_2.setBounds(14, 65, 1330, 537);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setToolTipText("Bảng lương công ty");
		scrollPane_1.setBounds(10, 157, 1310, 335);
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
					return Double.class;
				case 4:
					return Double.class;
				case 5:
					return Double.class;
				case 6:
					return String.class;
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
					false,false, false, false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			
		};
		table_1 = new JTable(model1);
		model1.addColumn("STT");
		model1.addColumn("Mã");
		model1.addColumn("Tháng Lương");
		model1.addColumn("Tổng Lương");
		model1.addColumn("Tổng Lương Nhân Viên");
		model1.addColumn("Tổng Lương Công Nhân");
		model1.addColumn("Tổng Sản Phẩn");
		model1.addColumn("Tổng Giờ Tăng Ca");
		model1.addColumn("Người Tạo");
		model1.addColumn("Ngày Tạo");
		table_1.getColumnModel().getColumn(0).setPreferredWidth(4);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("Bảng Lương");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(51, 51, 204));
		lblNewLabel_1.setBounds(10, 136, 128, 17);
		panel_2.add(lblNewLabel_1);
		
		textField_TimKiem = new JTextField();
		textField_TimKiem.setToolTipText("Nhập vào thông tin bản lương cần tìm");
		textField_TimKiem.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_TimKiem.setForeground(Color.BLACK);
		textField_TimKiem.setBounds(135, 130, 303, 23);
		panel_2.add(textField_TimKiem);
		textField_TimKiem.setColumns(10);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setToolTipText("Tìm kiếm bảng lương theo thông tin đã nhập");
		btnTimKiem.setBounds(448, 129, 105, 25);
		panel_2.add(btnTimKiem);
		
		comboBoxSapXep = new JComboBox<String>();
		comboBoxSapXep.setToolTipText("Chọn loại sắp xếp hiển thị nội dung bảng lương");
		comboBoxSapXep.setModel(new DefaultComboBoxModel<String>(new String[] {"Sắp xếp theo mã", "Sắp xếp theo tháng lương", "Sắp xếp theo mã người tạo", "Sắp xếp theo ngày tạo"}));
		comboBoxSapXep.setBounds(612, 129, 256, 25);
		panel_2.add(comboBoxSapXep);
		
		btnSapXep = new JButton("Sắp Xếp");
		btnSapXep.setToolTipText("Hiển thi bảng lương theo loại sắp xếp");
		btnSapXep.setBounds(878, 129, 105, 25);
		panel_2.add(btnSapXep);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(101, 496, 180, 38);
		//panel_2.add(btnSua);
		
		btnTinh = new JButton("Tính");
		btnTinh.setBounds(573, 496, 171, 38);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(356, 496, 171, 38);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(787, 496, 171, 38);
		
		btnTaoMoi = new JButton("Tạo Mới");
		btnTaoMoi.setToolTipText("Tạo bảng lương mới theo tháng/ năm đã chọn");
		btnTaoMoi.setBackground(SystemColor.textHighlight);
		btnTaoMoi.setBounds(448, 496, 171, 38);
		panel_2.add(btnTaoMoi);
		
		btnXoa = new JButton("Xóa ");
		btnXoa.setToolTipText("Xóa bảng lương đã chọn");
		btnXoa.setBackground(new Color(255, 182, 193));
		btnXoa.setBounds(712, 496, 171, 38);
		panel_2.add(btnXoa);
		
		JLabel lblNewLabel_7 = new JLabel("Tháng tính lương:");
		lblNewLabel_7.setBounds(10, 27, 115, 14);
		panel_2.add(lblNewLabel_7);
		
		comboBox_Thang = new JComboBox<String>();
		comboBox_Thang.setToolTipText("Chọn tháng tính lương");
		comboBox_Thang.setBounds(122, 23, 50, 22);
		panel_2.add(comboBox_Thang);
		comboBox_Thang.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09","10", "11", "12"}));
		
		textField_Nam = new JTextField();
		textField_Nam.setToolTipText("Nhập vào năm tính lương");
		textField_Nam.setBounds(182, 24, 76, 20);
		panel_2.add(textField_Nam);
		textField_Nam.setText("2021");
		textField_Nam.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày tạo:");
		lblNewLabel_4.setBounds(1102, 26, 61, 17);
		panel_2.add(lblNewLabel_4);
		
		textField_TongLuongNV = new JTextField();
		textField_TongLuongNV.setEditable(false);
		textField_TongLuongNV.setBounds(670, 23, 126, 23);
		panel_2.add(textField_TongLuongNV);
		textField_TongLuongNV.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nhân viên tạo:");
		lblNewLabel_5.setBounds(1098, 75, 86, 17);
		panel_2.add(lblNewLabel_5);
		
		
			
		textField_MaPhieu = new JTextField();
		textField_MaPhieu.setEditable(false);
		textField_MaPhieu.setBounds(349, 23, 126, 23);
		panel_2.add(textField_MaPhieu);
		textField_MaPhieu.setColumns(10);
		
		textField_TongSanPham = new JTextField();
		textField_TongSanPham.setEditable(false);
		textField_TongSanPham.setBounds(962, 72, 126, 23);
		panel_2.add(textField_TongSanPham);
		textField_TongSanPham.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Tổng Lương:");
		lblNewLabel_2.setBounds(10, 61, 128, 36);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 20));
		
		textField_TongLuong = new JTextField();
		textField_TongLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_TongLuong.setForeground(Color.BLUE);
		textField_TongLuong.setEditable(false);
		textField_TongLuong.setBounds(122, 69, 340, 28);
		panel_2.add(textField_TongLuong);
		textField_TongLuong.setColumns(10);
		
		btnTaiLai = new JButton("Tải Lại");
		btnTaiLai.setToolTipText("Tải lại nội dung bảng lương");
		btnTaiLai.setBounds(1004, 129, 105, 25);
		panel_2.add(btnTaiLai);
		
		textField_NhanVienTao = new JTextField();
		textField_NhanVienTao.setEditable(false);
		textField_NhanVienTao.setColumns(10);
		textField_NhanVienTao.setBounds(1194, 72, 126, 23);
		panel_2.add(textField_NhanVienTao);
		
		textField_NgayTao = new JTextField();
		textField_NgayTao.setEditable(false);
		textField_NgayTao.setColumns(10);
		textField_NgayTao.setBounds(1194, 23, 126, 23);
		panel_2.add(textField_NgayTao);
		
		textField_TongGioTangCa = new JTextField();
		textField_TongGioTangCa.setEditable(false);
		textField_TongGioTangCa.setColumns(10);
		textField_TongGioTangCa.setBounds(962, 23, 126, 23);
		panel_2.add(textField_TongGioTangCa);
		
		JLabel lblNewLabel_6_1 = new JLabel("Mã phiếu:");
		lblNewLabel_6_1.setBounds(278, 26, 61, 17);
		panel_2.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Tổng Giờ Tăng Ca:");
		lblNewLabel_6_2.setBounds(823, 26, 135, 17);
		panel_2.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_3 = new JLabel("Tổng Sản Phẩm:");
		lblNewLabel_6_3.setBounds(823, 75, 115, 17);
		panel_2.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_TongLuongNhanVien = new JLabel("Tổng Lương NV:");
		lblNewLabel_TongLuongNhanVien.setBounds(528, 26, 121, 17);
		panel_2.add(lblNewLabel_TongLuongNhanVien);
		
		JLabel lblNewLabel_6_2_2 = new JLabel("Tổng Lương CN:");
		lblNewLabel_6_2_2.setBounds(528, 75, 114, 17);
		panel_2.add(lblNewLabel_6_2_2);
		
		textField_TongLuongCN = new JTextField();
		textField_TongLuongCN.setEditable(false);
		textField_TongLuongCN.setColumns(10);
		textField_TongLuongCN.setBounds(670, 72, 126, 23);
		panel_2.add(textField_TongLuongCN);
		
		btnSapXep.addActionListener(this);
		btnTaiLai.addActionListener(this);
		btnTaoMoi.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTinh.addActionListener(this);
		btnThoat.addActionListener(this);
		btnThem.addActionListener(this);
		table_1.addMouseListener(this);
		panel.addMouseListener(this);
		panel_2.addMouseListener(this);
		
		docDuLieuDatabaseVaoTable1();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		
		if(o.equals(btnSapXep)) {
			String loai =  comboBoxSapXep.getSelectedItem().toString();
			if(loai.equals("Sắp xếp theo mã")) {
				xoaHetDuLieuTrenTableModel_1();
				docDuLieuDatabaseVaoTable1();
			}
			if(loai.equals("Sắp xếp theo tháng lương")) {
				xoaHetDuLieuTrenTableModel_1();
				docDuLieuDatabaseVaoTable1TheoThangLuong();
			}
			if(loai.equals("Sắp xếp theo ngày tạo")) {
				xoaHetDuLieuTrenTableModel_1();
				docDuLieuDatabaseVaoTable1TheoNgayTao();
			}
			if(loai.equals("Sắp xếp theo mã người tạo")) {
				xoaHetDuLieuTrenTableModel_1();
				docDuLieuDatabaseVaoTable1TheoMaNguoiTao();
			}
		}
		if(o.equals(btnTaiLai)) {
			taiLaiBang1();
		}
		if(o.equals(btnTimKiem)) {
			String str = textField_TimKiem.getText();
			xoaHetDuLieuTrenTableModel_1();
			List<BangLuongCongTy> list = dao_BangLuongCongTy.getAllBangLuong();
			int stt=1;
			for (BangLuongCongTy plcn : list) {
				String str2 = plcn.getMaBangLuong()+plcn.getThangLuong()+plcn.getMaNguoiTao()+plcn.getNgayTao().toString();
				if(str2.contains(str)) {
				model1.addRow(new Object[] {
						stt,plcn.getMaBangLuong(),plcn.getThangLuong(),plcn.getTongLuongCongTy(),plcn.getTongLuongNhanVien(),plcn.getTongLuongCongNhan(),plcn.getTongSanPham(),plcn.getTongSoGioTangCa(),
						plcn.getMaNguoiTao(),plcn.getNgayTao()
				});
				stt++;
				}
			}
		}
		if(o.equals(btnTaoMoi)) {
			xoaTrang();
			docNgayTao();
			docThangLuong();
			textField_NhanVienTao.setText(GUI_DangNhap.getDnma());
			panel.removeMouseListener(this);
			panel_2.removeMouseListener(this);
			table_1.clearSelection();
			table_1.removeMouseListener(this);
			table_1.setEnabled(false);
			panel_2.remove(btnTaoMoi);
			panel_2.remove(btnXoa);
			panel_2.add(btnThoat);
			panel_2.add(btnTinh);
			panel_2.add(btnThem);
			taoMaBangLuong();
			panel_2.updateUI();
			
		}
		if(o.equals(btnThem)) {
			if(textField_TongLuong.getText().equals(""))

				JOptionPane.showMessageDialog(this, "Không có lương trong tháng");
			else {
					String tL = textField_Nam.getText()+"-"+comboBox_Thang.getSelectedItem().toString();
					Date ngayTao = Date.valueOf(textField_NgayTao.getText());
					BangLuongCongTy bl = new BangLuongCongTy(textField_MaPhieu.getText(), tL,Double.parseDouble(textField_TongLuong.getText()) , 
							Double.parseDouble(textField_TongLuongNV.getText()), Double.parseDouble(textField_TongLuongCN.getText()),Integer.parseInt(textField_TongSanPham.getText()), Integer.parseInt(textField_TongGioTangCa.getText()), textField_NhanVienTao.getText(), ngayTao);
						dao_BangLuongCongTy.create(bl);
						taiLaiBang1();
						JOptionPane.showMessageDialog(this, "Thêm Thành Công");
						taoMaBangLuong();
					}
			
		}
		if(o.equals(btnTinh)) {
			docSoTongGioTangCa();
			docSoTongSanPham();
			docTongLuongCN();
			docTongLuongNV();
			tinhTongLuong();
			
		}
		if(o.equals(btnThoat)) {
			xoaTrang();
			docNgayTao();
			textField_NhanVienTao.setText("");
			panel.addMouseListener(this);
			panel_2.addMouseListener(this);
			table_1.clearSelection();
			table_1.addMouseListener(this);
			table_1.setEnabled(true);
			panel_2.add(btnTaoMoi);
			panel_2.add(btnXoa);
			panel_2.remove(btnThoat);
			panel_2.remove(btnTinh);
			panel_2.remove(btnThem);
			textField_MaPhieu.setText("");
			panel_2.updateUI();
			
			
		}
		if(o.equals(btnXoa)) {
			if( textField_MaPhieu.getText().equals(""))

				JOptionPane.showMessageDialog(this, "Hãy chọn phiếu cần xóa");
			else {
				int hoinhac = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xóa phiếu lương này?","Warnning",JOptionPane.YES_NO_CANCEL_OPTION);
				if(hoinhac == JOptionPane.YES_OPTION) {
					try {
							int r= table_1.getSelectedRow();
							model1.removeRow(r); 
							dao_BangLuongCongTy.xoaPL(textField_MaPhieu.getText());
							JOptionPane.showMessageDialog(this, "Xóa Thành Công");
						
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
			try {
				int row = table_1.getSelectedRow();
				textField_MaPhieu.setText(model1.getValueAt(row, 1).toString());
				NumberFormat num = NumberFormat.getInstance();
				String tongLuong = num.format( model1.getValueAt(row, 3));
				String tongLuongCN = num.format( model1.getValueAt(row, 5));
				String tongLuongNV = num.format( model1.getValueAt(row, 4));
				
				textField_TongLuong.setText(tongLuong);
				textField_TongLuongNV.setText(tongLuongCN);
				textField_TongLuongCN.setText(tongLuongNV);
				textField_TongSanPham.setText(model1.getValueAt(row, 6).toString());
				textField_TongGioTangCa.setText(model1.getValueAt(row, 7).toString());
				textField_NhanVienTao.setText(model1.getValueAt(row, 8).toString());
				textField_NgayTao.setText(model1.getValueAt(row, 9).toString());
				comboBox_Thang.removeAllItems();
				comboBox_Thang.addItem(model1.getValueAt(row, 2).toString().substring(5,7));
				docNamLuong();
					
				
			} catch (Exception e2) {
				System.out.print(e);
			}
			
		}
		if(o.equals(panel_2)||o.equals(panel)) {
			xoaTrang();
			taiLaiBang1();
			table_1.clearSelection();
			docThangLuong();
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
	
	
	public void docDuLieuDatabaseVaoTable1() {
		try {
		List<BangLuongCongTy> list = dao_BangLuongCongTy.getAllBangLuong();
		int stt=1;
		for (BangLuongCongTy plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaBangLuong(),plcn.getThangLuong(),plcn.getTongLuongCongTy(),plcn.getTongLuongNhanVien(),plcn.getTongLuongCongNhan(),plcn.getTongSanPham(),plcn.getTongSoGioTangCa(),
					plcn.getMaNguoiTao(),plcn.getNgayTao()
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
		List<BangLuongCongTy> list = dao_BangLuongCongTy.getAllBangLuongThangLuong();
		int stt=1;
		for (BangLuongCongTy plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaBangLuong(),plcn.getThangLuong(),plcn.getTongLuongCongTy(),plcn.getTongLuongNhanVien(),plcn.getTongLuongCongNhan(),plcn.getTongSanPham(),plcn.getTongSoGioTangCa(),
					plcn.getMaNguoiTao(),plcn.getNgayTao()
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
		List<BangLuongCongTy> list = dao_BangLuongCongTy.getAllBangLuongMaNguoiTao();
		int stt=1;
		for (BangLuongCongTy plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaBangLuong(),plcn.getThangLuong(),plcn.getTongLuongCongTy(),plcn.getTongLuongNhanVien(),plcn.getTongLuongCongNhan(),plcn.getTongSanPham(),plcn.getTongSoGioTangCa(),
					plcn.getMaNguoiTao(),plcn.getNgayTao()
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
		List<BangLuongCongTy> list = dao_BangLuongCongTy.getAllBangLuongNgayTao();
		int stt=1;
		for (BangLuongCongTy plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaBangLuong(),plcn.getThangLuong(),plcn.getTongLuongCongTy(),plcn.getTongLuongNhanVien(),plcn.getTongLuongCongNhan(),plcn.getTongSanPham(),plcn.getTongSoGioTangCa(),
					plcn.getMaNguoiTao(),plcn.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	private void docNamLuong() {
		int row = table_1.getSelectedRow();
		String nam = model1.getValueAt(row, 2).toString().substring(0,4);
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
	private void xoaHetDuLieuTrenTableModel_1() {
		DefaultTableModel dm = (DefaultTableModel) table_1.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();

		}
	private void taiLaiBang1(){
		xoaHetDuLieuTrenTableModel_1();
		docDuLieuDatabaseVaoTable1();
	}
	
	private void taoMaBangLuong() {
		String ma= dao_BangLuongCongTy.getMaLonNhat();
		int maMoi;
		maMoi =Integer.parseInt(ma.substring(4, 8)) + 1;
		if(maMoi<10000) {
			textField_MaPhieu.setText("BLCT"+maMoi);
		}
		if(maMoi<1000) {
			textField_MaPhieu.setText("BLCT0"+maMoi);
		}
		if(maMoi<100) {
			textField_MaPhieu.setText("BLCT00"+maMoi);
		}
		if(maMoi<10) {
			textField_MaPhieu.setText("BLCT000"+maMoi);
		}
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
	public void xoaTrang(){
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		textField_NgayTao.setText(date.toString());
		textField_TongGioTangCa.setText("");
		textField_MaPhieu.setText("");
		textField_NhanVienTao.setText("");
		textField_TongLuong.setText("");
		textField_TongLuongCN.setText("");
		textField_TongLuongNV.setText("");
		textField_TongSanPham.setText("");
		
		
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
	
	public void docSoTongSanPham() {
		try {
			String thangNho = taoThangNhoHon();
			String thangLon = taoThangLonHon();
		String ssp = dao_BangLuongCongTy .docSoSanPham(thangNho,thangLon);

		textField_TongSanPham.setText(ssp);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void docSoTongGioTangCa() {
		try {
			String thangNho = taoThangNhoHon();
			String thangLon = taoThangLonHon();
		String ssp = dao_BangLuongCongTy .docSoGioTangCa(thangNho,thangLon);
		textField_TongGioTangCa.setText(ssp);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void docTongLuongNV() {
		try {
			String thang = textField_Nam.getText().toString()+"-"+comboBox_Thang.getSelectedItem() ;
			System.out.print(thang);
		String ssp = dao_BangLuongCongTy .docTongLuongNV(thang);
		textField_TongLuongNV.setText(ssp);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void docTongLuongCN() {
		try {
			String thang = textField_Nam.getText().toString()+"-"+comboBox_Thang.getSelectedItem() ;
		String ssp = dao_BangLuongCongTy .docTongLuongCN(thang);
		textField_TongLuongCN.setText(ssp);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void tinhTongLuong() {
		try {
		Double luongCN = Double.parseDouble(textField_TongLuongCN.getText().toString());
		Double luongNV = Double.parseDouble(textField_TongLuongNV.getText().toString());
		Double tongLuong = luongCN+luongNV;
		String  tL = String.format("%.2f", tongLuong);
		textField_TongLuong.setText(tL);
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"Năm không đúng định dạng");
		}
	}


}

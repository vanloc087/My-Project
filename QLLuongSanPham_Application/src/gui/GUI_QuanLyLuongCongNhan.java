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

import dao.DAO_PhieuLuongCongNhan;
import entity.CongNhan;
import entity.PhieuLuongCongNhan;
import javax.swing.UIManager;

public class GUI_QuanLyLuongCongNhan extends JFrame implements ActionListener,MouseListener {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private DAO_PhieuLuongCongNhan dao_PhieuLuongCongNhan = new DAO_PhieuLuongCongNhan();
	
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private String[]  cols={"STT","M\u00E3 C\u00F4ng Nh\u00E2n", "Gi\u1EDBi T\u00EDnh", "H\u1ECD T\u00EAn"};
	private JTextField textField_ThucLanh;
	private JLabel lblNewLabel_2;
	private JTextField textField_MaPhieu;
	private JTextField textField_DonGia;
	private JTextField textField_NgayTao;
	private JTable table_1;
	private JTextField textField_TimPL;
	private JTextField txtNhpVoThng;
	private JTextField textField_Nam;
	private JTextField textField_SoSP;
	private JTextField textField_SoSPCa3;
	private JTextField textField_SoSPCN;
	private JTextField textField_NVTao;
	private JButton btnTimCongNhan,btnSapXepCN,btnThemPL,btnXoaPL,btnSapXepPhieuLuong,btnTimPhieuLuong,btnTinhLuong,btnTaiLaiPL;
	private JPanel panel_NVTao,panel_2,panel;
	private JLabel lblNewLabel_3;
	private JComboBox<String> comboBox_Thang,comboSapXepPhieuLuong,comboBox_SapXepCN;
	private JButton btnTaiLaiCN;
	/**
	 * Launch the application.
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLyLuongCongNhan frame = new GUI_QuanLyLuongCongNhan();
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
	public GUI_QuanLyLuongCongNhan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 650);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dao_PhieuLuongCongNhan = new DAO_PhieuLuongCongNhan();
		
		panel_NVTao = new JPanel();
		panel_NVTao.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_NVTao.setBounds(14, 64, 1330, 204);
		contentPane.add(panel_NVTao);
		panel_NVTao.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 50, 566, 143);
		panel_NVTao.add(scrollPane);
		
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(55);
		table.getColumnModel().getColumn(2).setPreferredWidth(86);
		scrollPane.setViewportView(table);
		
		textField_ThucLanh = new JTextField();
		textField_ThucLanh.setEditable(false);
		textField_ThucLanh.setBackground(UIManager.getColor("Button.background"));
		textField_ThucLanh.setForeground(Color.BLUE);
		textField_ThucLanh.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField_ThucLanh.setBounds(1048, 168, 272, 28);
		panel_NVTao.add(textField_ThucLanh);
		textField_ThucLanh.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Thực Lãnh:");
		lblNewLabel_2.setBounds(918, 162, 120, 36);
		panel_NVTao.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 20));
		
		lblNewLabel_3 = new JLabel("    Công Nhân");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setForeground(new Color(51, 51, 204));
		lblNewLabel_3.setBounds(-13, 0, 126, 22);
		panel_NVTao.add(lblNewLabel_3);
		
		textField_MaPhieu = new JTextField();
		textField_MaPhieu.setToolTipText("Mã phiếu lương công nhân");
		textField_MaPhieu.setBackground(UIManager.getColor("Button.background"));
		textField_MaPhieu.setEditable(false);
		textField_MaPhieu.setBounds(930, 105, 126, 23);
		panel_NVTao.add(textField_MaPhieu);
		textField_MaPhieu.setColumns(10);
		
		textField_DonGia = new JTextField();
		textField_DonGia.setToolTipText("Đơn giá của sản phẩm công nhân làm trong tháng (10% giá trị sản phẩm)");
		textField_DonGia.setBackground(UIManager.getColor("Button.background"));
		textField_DonGia.setEditable(false);
		textField_DonGia.setBounds(930, 40, 126, 23);
		panel_NVTao.add(textField_DonGia);
		textField_DonGia.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Ngày tạo:");
		lblNewLabel_4.setBounds(1083, 108, 61, 17);
		panel_NVTao.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Đơn giá:");
		lblNewLabel_5.setBounds(840, 43, 97, 17);
		panel_NVTao.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mã phiếu:");
		lblNewLabel_6.setBounds(840, 108, 61, 17);
		panel_NVTao.add(lblNewLabel_6);
		
		textField_NgayTao = new JTextField();
		textField_NgayTao.setToolTipText("Ngày khởi tạo phiếu lương");
		textField_NgayTao.setBackground(UIManager.getColor("Button.background"));
		textField_NgayTao.setEditable(false);
		textField_NgayTao.setBounds(1194, 105, 126, 23);
		panel_NVTao.add(textField_NgayTao);
		textField_NgayTao.setColumns(10);
		
		txtNhpVoThng = new JTextField();
		txtNhpVoThng.setText("Nhập vào thông tin cần tìm kiếm");
		txtNhpVoThng.setBounds(0, 24, 143, 23);
		panel_NVTao.add(txtNhpVoThng);
		txtNhpVoThng.setColumns(10);
		
		btnTimCongNhan = new JButton("Tìm Kiếm");
		btnTimCongNhan.setToolTipText("Tìm kiếm công nhân theo thông tin đã");
		btnTimCongNhan.setBounds(146, 23, 97, 25);
		panel_NVTao.add(btnTimCongNhan);
		
		comboBox_SapXepCN = new JComboBox<String>();
		comboBox_SapXepCN.setToolTipText("Chọn loại sắp xếp bảng công nhân");
		comboBox_SapXepCN.setModel(new DefaultComboBoxModel<String>(new String[] {"Sắp xếp theo mã", "Sắp xếp theo tên"}));
		comboBox_SapXepCN.setBounds(254, 24, 135, 22);
		panel_NVTao.add(comboBox_SapXepCN);
		
		btnSapXepCN = new JButton("Sắp Xếp");
		btnSapXepCN.setToolTipText("Sắp xếp theo loại đã chọn");
		btnSapXepCN.setBounds(390, 23, 86, 25);
		panel_NVTao.add(btnSapXepCN);
		
		comboBox_Thang = new JComboBox<String>();
		comboBox_Thang.setToolTipText("Chọn tháng muốn tính lương");
		comboBox_Thang.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "11", "12"}));
		comboBox_Thang.setBounds(713, 3, 50, 22);
		panel_NVTao.add(comboBox_Thang);
		
		textField_Nam = new JTextField();
		textField_Nam.setToolTipText("Nhập vào năm muốn tính lương");
		textField_Nam.setText("2021");
		textField_Nam.setBounds(773, 4, 50, 20);
		panel_NVTao.add(textField_Nam);
		textField_Nam.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Tháng tính lương:");
		lblNewLabel_7.setBounds(588, 7, 115, 14);
		panel_NVTao.add(lblNewLabel_7);
		
		textField_SoSP = new JTextField();
		textField_SoSP.setToolTipText("Số lượng sản phẩm của công nhân trong tháng");
		textField_SoSP.setBackground(UIManager.getColor("Button.background"));
		textField_SoSP.setEditable(false);
		textField_SoSP.setColumns(10);
		textField_SoSP.setBounds(684, 40, 126, 23);
		panel_NVTao.add(textField_SoSP);
		
		textField_SoSPCa3 = new JTextField();
		textField_SoSPCa3.setToolTipText("Số lương sản phẩm trong ca 3 của công nhân trong tháng");
		textField_SoSPCa3.setBackground(UIManager.getColor("Button.background"));
		textField_SoSPCa3.setEditable(false);
		textField_SoSPCa3.setColumns(10);
		textField_SoSPCa3.setBounds(684, 105, 126, 23);
		panel_NVTao.add(textField_SoSPCa3);
		
		textField_SoSPCN = new JTextField();
		textField_SoSPCN.setToolTipText("Số sản phẩm ca làm và ngày chủ nhật của công nhân trong tháng");
		textField_SoSPCN.setBackground(UIManager.getColor("Button.background"));
		textField_SoSPCN.setEditable(false);
		textField_SoSPCN.setColumns(10);
		textField_SoSPCN.setBounds(684, 170, 126, 23);
		panel_NVTao.add(textField_SoSPCN);
		
		JLabel lblNewLabel_4_1 = new JLabel("Số Sản Phẩm:");
		lblNewLabel_4_1.setBounds(588, 42, 97, 17);
		panel_NVTao.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Số SP Ca 3:");
		lblNewLabel_4_2.setBounds(588, 108, 97, 17);
		panel_NVTao.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Số SP Ngày CN:");
		lblNewLabel_4_3.setBounds(588, 171, 97, 17);
		panel_NVTao.add(lblNewLabel_4_3);
		
		textField_NVTao = new JTextField();
		textField_NVTao.setToolTipText("Mã nhân viên tạo");
		textField_NVTao.setBackground(UIManager.getColor("Button.background"));
		textField_NVTao.setEditable(false);
		textField_NVTao.setColumns(10);
		textField_NVTao.setBounds(1194, 40, 126, 23);
		panel_NVTao.add(textField_NVTao);
		
		JLabel lblDonGia = new JLabel("Nhân viên tạo:");
		lblDonGia.setBounds(1083, 43, 97, 17);
		panel_NVTao.add(lblDonGia);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(14, 271, 1330, 342);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 51, 1330, 238);
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
					return String.class;
				case 7:
					return String.class;
				case 8:
					return String.class;
				case 9:
					return Double.class;
				case 10:
					return Double.class;
				case 11:
					return String.class;
				case 12:
					return String.class;
					
				default:
				return String.class;
				}
			}
			boolean[] columnEditables = new boolean[] {
					false,false, false, false, false, false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			
		};
		table_1 = new JTable(model1);
		model1.addColumn("STT");
		model1.addColumn("Mã");
		model1.addColumn("Tháng Lương");
		model1.addColumn("Mã Công Nhân ");
		model1.addColumn("Họ Tên");
		model1.addColumn("Giới Tính");
		model1.addColumn("Số Sản Phẩm");
		model1.addColumn("Sản Phẩm Ca 3");
		model1.addColumn("Sản Phẩm CN");
		model1.addColumn("Đơn Giá");
		model1.addColumn("Thực Lãnh");
		model1.addColumn("Người Tạo");
		model1.addColumn("Ngày Tạo");
//		table_1.getColumnModel().getColumn(0).setPreferredWidth(4);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("Phiếu Lương");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(51, 51, 204));
		lblNewLabel_1.setBounds(14, 0, 128, 17);
		panel_2.add(lblNewLabel_1);
		
		textField_TimPL = new JTextField();
		textField_TimPL.setToolTipText("Nhập vào thông tin phiếu lương cần tìm");
		textField_TimPL.setBounds(0, 24, 270, 23);
		panel_2.add(textField_TimPL);
		textField_TimPL.setColumns(10);
		
		btnTimPhieuLuong = new JButton("Tìm kiếm");
		btnTimPhieuLuong.setToolTipText("Tìm kiếm theo thông tin phiêu lương");
		btnTimPhieuLuong.setBounds(275, 23, 105, 25);
		panel_2.add(btnTimPhieuLuong);
		
		comboSapXepPhieuLuong= new JComboBox<String>();
		comboSapXepPhieuLuong.setToolTipText("Chọn loại sắp xếp hiển thị nội dung bảng phiếu lương");
		comboSapXepPhieuLuong.setModel(new DefaultComboBoxModel<String>(new String[] {"Sắp xếp theo mã", "Sắp xếp theo công nhân", "Sắp xếp theo người tạo", "Sắp xếp theo ngày tạo","Sắp xếp theo tên công nhân","Sắp xếp theo tháng lương"}));
		comboSapXepPhieuLuong.setBounds(459, 23, 192, 25);
		panel_2.add(comboSapXepPhieuLuong);
		
		btnSapXepPhieuLuong = new JButton("Sắp Xếp");
		btnSapXepPhieuLuong.setToolTipText("Sắp xếp theo loại");
		btnSapXepPhieuLuong.setBounds(655, 23, 105, 25);
		panel_2.add(btnSapXepPhieuLuong);
		
		btnTinhLuong = new JButton("Tính Lương");
		btnTinhLuong.setToolTipText("Tính thực lãnh trong tháng của công nhân");
		btnTinhLuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTinhLuong.setBounds(304, 293, 192, 41);
		panel_2.add(btnTinhLuong);
		
		btnThemPL = new JButton("Thêm Phiếu Lương");
		btnThemPL.setToolTipText("Thêm phiếu lương vào dữ liệu");
		btnThemPL.setBounds(530, 293, 204, 41);
		panel_2.add(btnThemPL);
		
		btnXoaPL = new JButton("Xóa Phiếu Lương");
		btnXoaPL.setToolTipText("Xóa phiếu lương đã chọn");
		btnXoaPL.setBounds(772, 293, 184, 41);
		panel_2.add(btnXoaPL);
		
		btnTaiLaiPL = new JButton("Tải Lại");
		btnTaiLaiPL.setToolTipText("Tải lại nôi dung bảng phiếu lương");
		btnTaiLaiPL.setBounds(836, 24, 105, 25);
		panel_2.add(btnTaiLaiPL);
		
		btnTaiLaiCN = new JButton("Tải Lại");
		btnTaiLaiCN.setToolTipText("Tải lại nội dung bảng công nhân");
		btnTaiLaiCN.setBounds(479, 23, 87, 25);
		panel_NVTao.add(btnTaiLaiCN);
		
		panel = new JPanel();
		panel.setBounds(14, 11, 1330, 50);
		contentPane.add(panel);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Mã nhân viên:");
		lblNewLabel_8.setBounds(1032, 10, 115, 33);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel_NVDangNhap = new JLabel("");
		lblNewLabel_NVDangNhap.setToolTipText("Mã nhân viên đang đăng nhập");
		lblNewLabel_NVDangNhap.setBounds(1197, 10, 115, 32);
		panel.add(lblNewLabel_NVDangNhap);
		lblNewLabel_NVDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("Quản Lý Lương Công Nhân");
		lblNewLabel.setBounds(10, 3, 460, 46);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 38));
		
		
		table_1.addMouseListener(this);
		table.addMouseListener(this);
		panel_NVTao.addMouseListener(this);
		panel_2.addMouseListener(this);
		
		
		btnTimCongNhan.addActionListener(this);
		btnSapXepCN.addActionListener(this);
		btnSapXepPhieuLuong.addActionListener(this);
		btnThemPL.addActionListener(this);
		btnTimPhieuLuong.addActionListener(this);
		btnTinhLuong.addActionListener(this);
		btnXoaPL.addActionListener(this);
		btnTaiLaiPL.addActionListener(this);
		btnTaiLaiCN.addActionListener(this);
		docDuLieuDatabaseVaoTable();
		docDuLieuDatabaseVaoTable1();
		docNgayTao();
		
	
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
		if(o.equals(btnSapXepPhieuLuong)) {
			String loai =  comboSapXepPhieuLuong.getSelectedItem().toString();
			if(loai.equals("Sắp xếp theo mã")) {
				xoaHetDuLieuTrenTableModel_1();
				docDuLieuDatabaseVaoTable1();
			}
			if(loai.equals("Sắp xếp theo công nhân")) {
				xoaHetDuLieuTrenTableModel_1();
				docDuLieuDatabaseVaoTable1TheoCN();
			}
			if(loai.equals("Sắp xếp theo ngày tạo")) {
				xoaHetDuLieuTrenTableModel_1();
				docDuLieuDatabaseVaoTable1TheoNgayTao();
			}
			if(loai.equals("Sắp xếp theo mã người tạo")) {
				xoaHetDuLieuTrenTableModel_1();
				docDuLieuDatabaseVaoTable1TheoMaNguoiTao();
			}
			if(loai.equals("Sắp xếp theo tháng lương")) {
				xoaHetDuLieuTrenTableModel_1();
				docDuLieuDatabaseVaoTable1TheoThangLuong();
			}
			if(loai.equals("Sắp xếp theo tên công nhân")) {
				xoaHetDuLieuTrenTableModel_1();
				docDuLieuDatabaseVaoTable1TheoTen();
			}
		}
		
		if (o.equals(btnTaiLaiCN)) {
			taiLaiBang();
			
		}
		if (o.equals(btnTimCongNhan)) {
			String str = txtNhpVoThng.getText();
			xoaHetDuLieuTrenTableModel();
			List<CongNhan> list = dao_PhieuLuongCongNhan.getAllCongNhan();
			int stt=1;
			for (CongNhan cn : list) {
				String str2 = cn.getMaCongNhan()+cn.getHoTen();
				if(str2.contains(str)) {
				model.addRow(new Object[] {
					stt,	cn.getMaCongNhan(), cn.getHoTen(),cn.getGioiTinh()
				});
				stt++;
				}
			}
					
		}
		if (o.equals(btnThemPL)) {
			
		}
		if (o.equals(btnThemPL)) {
			
		}
		if (o.equals(btnThemPL)) {
					
		}
		
		if (o.equals(btnThemPL)) {
			if(textField_ThucLanh.getText().equals(""))

				JOptionPane.showMessageDialog(this, "Công nhân không có thực  lãnh");
			else {
					int row = table.getSelectedRow();
					String tL = textField_Nam.getText()+"-"+comboBox_Thang.getSelectedItem().toString();
					Date ngayTao = Date.valueOf(textField_NgayTao.getText());
					PhieuLuongCongNhan pl= new PhieuLuongCongNhan(textField_MaPhieu.getText(),tL,model.getValueAt(row, 1).toString() ,
					model.getValueAt(row, 2).toString(), model.getValueAt(row, 3).toString(),Integer.parseInt(textField_SoSP.getText()),
					Integer.parseInt(textField_SoSPCa3.getText()),Integer.parseInt(textField_SoSPCN.getText()),Double.parseDouble(textField_DonGia.getText()),
					Double.parseDouble(textField_ThucLanh.getText()),textField_NVTao.getText(),ngayTao);
						dao_PhieuLuongCongNhan.create(pl);
						taiLaiBang1();
						JOptionPane.showMessageDialog(this, "Thêm Thành Công");
						taoMaPhieuLuong();
					}
			}
		
		
		if(o.equals(btnTimCongNhan)) {
			DAO_PhieuLuongCongNhan dscn= new DAO_PhieuLuongCongNhan();
			List<CongNhan> list =dscn.timCNTheoTen(txtNhpVoThng.getText());
			if(txtNhpVoThng.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tên công nhân cần tìm !!!");
				
			}
			else if(list.size()==0)
			{
				JOptionPane.showMessageDialog(this, "Không tìm thấy công nhân nào ") ;
				
			}
			else
			{
				xoaHetDuLieuTrenTableModel();
				for(CongNhan cn :list) {
					
					model.addRow(new Object[] {
							cn.getMaCongNhan(),cn.getHoTen(),cn.getGioiTinh()
					});
				
					}
				
				table.setModel(model);
					
				}
			
			
		}
		
		if(o.equals(btnTinhLuong)) {
			int row = table.getSelectedRow();
			if(row==-1) {
				JOptionPane.showMessageDialog(this, "Hãy chọn công nhân muốn tính lương ") ;
			}
			else {
				docNgayTao();
				tinhThucLanh();
				taoMaPhieuLuong();
				textField_NVTao.setText(GUI_DangNhap.getDnma());
			}
			
		}
		if(o.equals(btnTaiLaiPL)) {
			taiLaiBang1();
		}
		if(o.equals(btnXoaPL)) {
			if( textField_MaPhieu.getText().equals(""))

				JOptionPane.showMessageDialog(this, "Hãy chọn phiếu cần xóa");
			else {
				int hoinhac = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xóa phiếu lương này?","Warnning",JOptionPane.YES_NO_CANCEL_OPTION);
				if(hoinhac == JOptionPane.YES_OPTION) {
					try {
							int r= table_1.getSelectedRow();
							model1.removeRow(r); 
							dao_PhieuLuongCongNhan.xoaPL(textField_MaPhieu.getText());
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
				DAO_PhieuLuongCongNhan dscn= new DAO_PhieuLuongCongNhan();
				List<CongNhan> list =dscn.timMa(model1.getValueAt(row, 3).toString());
				
				textField_MaPhieu.setText(model1.getValueAt(row, 2).toString());
				textField_SoSP.setText(model1.getValueAt(row, 6).toString());
				textField_SoSPCa3.setText(model1.getValueAt(row, 7).toString());
				textField_SoSPCN.setText(model1.getValueAt(row, 8).toString());
				textField_DonGia.setText(model1.getValueAt(row, 9).toString());
				NumberFormat num = NumberFormat.getInstance();
				String thucLanh = num.format( model1.getValueAt(row, 10));
				textField_ThucLanh.setText(thucLanh);
				textField_NVTao.setText(model1.getValueAt(row, 11).toString());
				textField_NgayTao.setText(model1.getValueAt(row, 12).toString());
				comboBox_Thang.removeAllItems();
				comboBox_Thang.addItem(model1.getValueAt(row, 2).toString().substring(5,7));
				docNamLuong();
				xoaHetDuLieuTrenTableModel();
				
				for(CongNhan cn :list) {
					int stt=1;
					model.addRow(new Object[] {
							stt,cn.getMaCongNhan(),cn.getHoTen(),cn.getGioiTinh()
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
				docSoSanPham(model.getValueAt(row, 1).toString());
				docSoSanPhamCa3(model.getValueAt(row, 1).toString());
				docSoSanPhamNgayCN(model.getValueAt(row, 1).toString());
				docDonGia(model.getValueAt(row, 1).toString());
				xoaHetDuLieuTrenTableModel_1();
				textField_ThucLanh.setText("");
				docPhieuLuongTheoCN(model.getValueAt(row, 1).toString());
			} catch (Exception e2) {
				System.out.print(e);
			}
		}
		if(o.equals(panel_2)||o.equals(panel_NVTao)) {
			xoaTrang();
			docDuLieuDatabaseVaoTable1();
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
	
	
	public void docPhieuLuongTheoCN(String ma) {
		try {
		List<PhieuLuongCongNhan> list = dao_PhieuLuongCongNhan.getPhieuLuongTheoCN(ma);
		int stt=1;
		for (PhieuLuongCongNhan plcn : list) {
			model1.addRow(new Object[] {
					stt,plcn.getMaPhieuLuong(),plcn.getThangLuong(),plcn.getMaNguoiHuong(),plcn.getHoTen(),plcn.getGioiTinh(),plcn.getSoSanPham(),
					plcn.getSoSanPhamCa3(),plcn.getSoSanPhamNgayCN(),plcn.getDonGia(),plcn.getThanhTien(),plcn.getMaNguoiTao(),plcn.getNgayTao()
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
		List<CongNhan> list = dao_PhieuLuongCongNhan.getAllCongNhan();
		int stt=1;
		for (CongNhan cn : list) {
			model.addRow(new Object[] {
				stt,	cn.getMaCongNhan(), cn.getHoTen(),cn.getGioiTinh()
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
		List<CongNhan> list = dao_PhieuLuongCongNhan.getAllCongNhanTheoTen();
		int stt=1;
		for (CongNhan cn : list) {
			model.addRow(new Object[] {
				stt,	cn.getMaCongNhan(), cn.getHoTen(),cn.getGioiTinh()
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
		List<PhieuLuongCongNhan> list = dao_PhieuLuongCongNhan.getAllPhieuLuongCongNhan();
		int stt=1;
		for (PhieuLuongCongNhan plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaPhieuLuong(),plcn.getThangLuong(),plcn.getMaNguoiHuong(),plcn.getHoTen(),plcn.getGioiTinh(),plcn.getSoSanPham(),
					plcn.getSoSanPhamCa3(),plcn.getSoSanPhamNgayCN(),plcn.getDonGia(),plcn.getThanhTien(),plcn.getMaNguoiTao(),plcn.getNgayTao()
			});
			stt++;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void docDuLieuDatabaseVaoTable1TheoCN() {
		try {
		List<PhieuLuongCongNhan> list = dao_PhieuLuongCongNhan.getAllPhieuLuongCongNhanCN();
		int stt=1;
		for (PhieuLuongCongNhan plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaPhieuLuong(),plcn.getThangLuong(),plcn.getMaNguoiHuong(),plcn.getHoTen(),plcn.getGioiTinh(),plcn.getSoSanPham(),
					plcn.getSoSanPhamCa3(),plcn.getSoSanPhamNgayCN(),plcn.getDonGia(),plcn.getThanhTien(),plcn.getMaNguoiTao(),plcn.getNgayTao()
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
		List<PhieuLuongCongNhan> list = dao_PhieuLuongCongNhan.getAllPhieuLuongCongNhanNgayTao();
		int stt=1;
		for (PhieuLuongCongNhan plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaPhieuLuong(),plcn.getThangLuong(),plcn.getMaNguoiHuong(),plcn.getHoTen(),plcn.getGioiTinh(),plcn.getSoSanPham(),
					plcn.getSoSanPhamCa3(),plcn.getSoSanPhamNgayCN(),plcn.getDonGia(),plcn.getThanhTien(),plcn.getMaNguoiTao(),plcn.getNgayTao()
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
		List<PhieuLuongCongNhan> list = dao_PhieuLuongCongNhan.getAllPhieuLuongCongNhanMaNguoiTao();
		int stt=1;
		for (PhieuLuongCongNhan plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaPhieuLuong(),plcn.getThangLuong(),plcn.getMaNguoiHuong(),plcn.getHoTen(),plcn.getGioiTinh(),plcn.getSoSanPham(),
					plcn.getSoSanPhamCa3(),plcn.getSoSanPhamNgayCN(),plcn.getDonGia(),plcn.getThanhTien(),plcn.getMaNguoiTao(),plcn.getNgayTao()
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
		List<PhieuLuongCongNhan> list = dao_PhieuLuongCongNhan.getAllPhieuLuongCongNhanThangLuong();
		int stt=1;
		for (PhieuLuongCongNhan plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaPhieuLuong(),plcn.getThangLuong(),plcn.getMaNguoiHuong(),plcn.getHoTen(),plcn.getGioiTinh(),plcn.getSoSanPham(),
					plcn.getSoSanPhamCa3(),plcn.getSoSanPhamNgayCN(),plcn.getDonGia(),plcn.getThanhTien(),plcn.getMaNguoiTao(),plcn.getNgayTao()
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
		List<PhieuLuongCongNhan> list = dao_PhieuLuongCongNhan.getAllPhieuLuongCongNhanTheoTen();
		int stt=1;
		for (PhieuLuongCongNhan plcn : list) {

			model1.addRow(new Object[] {
					stt,plcn.getMaPhieuLuong(),plcn.getThangLuong(),plcn.getMaNguoiHuong(),plcn.getHoTen(),plcn.getGioiTinh(),plcn.getSoSanPham(),
					plcn.getSoSanPhamCa3(),plcn.getSoSanPhamNgayCN(),plcn.getDonGia(),plcn.getThanhTien(),plcn.getMaNguoiTao(),plcn.getNgayTao()
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
	private void xoaHetDuLieuTrenTableModel_1() {
		DefaultTableModel dm = (DefaultTableModel) table_1.getModel();
		dm.getDataVector().removeAllElements();
		dm.fireTableDataChanged();

		}
	
	public void docSoSanPham(String ma) {
		try {
			String thangNho = taoThangNhoHon();
			String thangLon = taoThangLonHon();
		String ssp = dao_PhieuLuongCongNhan.docSoSanPham(ma,thangNho,thangLon);
		textField_SoSP.setText(ssp);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void docSoSanPhamCa3(String ma) {
		try {
			String thangNho = taoThangNhoHon();
			String thangLon = taoThangLonHon();
		String ssp = dao_PhieuLuongCongNhan.docSoSanPhamCa3(ma,thangNho,thangLon);
		textField_SoSPCa3.setText(ssp);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
	public void docSoSanPhamNgayCN(String ma) {
		try {
			String thangNho = taoThangNhoHon();
			String thangLon = taoThangLonHon();
		String ssp = dao_PhieuLuongCongNhan.docSoSanPhamNgayCN(ma,thangNho,thangLon);
		textField_SoSPCN.setText(ssp);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
	public void docDonGia(String ma) {
		try {
		String ssp = dao_PhieuLuongCongNhan.docDonGia(ma);
		Double donGia = Double.parseDouble(ssp)*0.1;
		ssp =  donGia.toString();
		textField_DonGia.setText(ssp);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
	public void tinhThucLanh() {
		try {
		int soSPCa3= Integer.parseInt(textField_SoSPCa3.getText());
		int soSPCN=Integer.parseInt(textField_SoSPCN.getText());
		int soSP=Integer.parseInt(textField_SoSP.getText());
		Double  donGia=Double.parseDouble(textField_DonGia.getText());
		Double thucLanh = donGia*soSPCa3*0.3+donGia*soSPCN*0.3+(soSP*donGia);
		textField_ThucLanh.setText(Double.toString(thucLanh));
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this,"Năm không đúng định dạng");
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
		textField_DonGia.setText("");
		textField_MaPhieu.setText("");
		textField_SoSP.setText("");
		textField_SoSPCa3.setText("");
		textField_SoSPCN.setText("");
		textField_ThucLanh.setText("");
		textField_NVTao.setText("");
		
		
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
		String ma= dao_PhieuLuongCongNhan.getMaLonNhat();
		int maMoi;
		maMoi =Integer.parseInt(ma.substring(4, 8)) + 1;
		if(maMoi<10000) {
			textField_MaPhieu.setText("PLCN"+maMoi);
		}
		if(maMoi<1000) {
			textField_MaPhieu.setText("PLCN0"+maMoi);
		}
		if(maMoi<100) {
			textField_MaPhieu.setText("PLCN00"+maMoi);
		}
		if(maMoi<10) {
			textField_MaPhieu.setText("PLCN000"+maMoi);
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
	
	
	
}

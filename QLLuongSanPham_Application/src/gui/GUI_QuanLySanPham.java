package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

//import javax.swing.table.TableModel;
//import javax.swing.table.TableRowSorter;
import connectDB.ConnectDB;
import dao.DAO_SanPham;
import entity.LoaiSanPham;
import entity.SanPham;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
//import javax.swing.RowFilter;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.border.LineBorder;

public class GUI_QuanLySanPham extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private JPanel quanLySP;
	private DAO_SanPham sanPham_DAO;
	private DefaultTableModel modelSP;
	private DefaultTableModel modelLoaiSP;
	private JTable tableLoaiSP;
	private JTextField textFieldTenLoaiSP;
	private JTextField textFieldMaLoaiSP;
	private JTable tableSP;
	
	private TableRowSorter<TableModel> filterLoaiSP;
	private JPanel panelLoaiSP;
	private JPanel panelSP;
	private JButton btnThemLoaiSP;
	private JButton btnXoaLoaiSP;
	private JButton btnSuaLoaiSP;
	private JButton btnXoaRongLoaiSP;
	private JTextField textFieldSoLuongSP;
	private JTextField textFieldDonGia;
	private JTextField textFieldTenSP;
	private JTextField textFieldMaSP;
	private JComboBox<String> comboBoxMaLoaiSP;
	private JTextField textFieldTimKiemLoaiSP;
	private JTextField textFieldTimkiemSP;
	private JButton btnThemSP;
	private JButton btnXoaSP;
	private JButton btnSuaSP;
	private JButton btnXoaRongSP;
	private JComboBox<String> comboBoxTimKiemSP;
	private JComboBox<String> comboBoxTimKiemLoaiSP;
	private JLabel lblNewLabel_2;
	private TableRowSorter<TableModel> filterSP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLySanPham frame = new GUI_QuanLySanPham();
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
	public GUI_QuanLySanPham() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1360, 680);
		setLocationRelativeTo(null);
		setResizable(false);
		quanLySP = new JPanel();
		quanLySP.setBackground(Color.YELLOW);
		quanLySP.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(quanLySP);
		quanLySP.setLayout(null);
		
		modelSP = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "M\u00E3 lo\u1EA1i s\u1EA3n ph\u1EA9m"
				}
			);
		
		panelLoaiSP = new JPanel();
		panelLoaiSP.setBorder(new LineBorder(new Color(255, 0, 0)));
		panelLoaiSP.setBackground(Color.WHITE);
		panelLoaiSP.setBounds(851, 37, 509, 644);
		quanLySP.add(panelLoaiSP);
		panelLoaiSP.setLayout(null);
		
		JLabel lblLoaiSP = new JLabel("Loại sản phẩm");
		lblLoaiSP.setFont(new Font("Sitka Display", Font.PLAIN, 30));
		lblLoaiSP.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoaiSP.setBounds(10, 0, 489, 38);
		panelLoaiSP.add(lblLoaiSP);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 489, 341);
		panelLoaiSP.add(scrollPane);
		
		modelLoaiSP = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"M\u00E3 lo\u1EA1i s\u1EA3n ph\u1EA9m", "T\u00EAn lo\u1EA1i s\u1EA3n ph\u1EA9m"
				}
			); 
		tableLoaiSP = new JTable(modelLoaiSP);
		tableLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(tableLoaiSP);
		
		JLabel lblNewLabel = new JLabel("Mã loại sản phẩm: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 400, 127, 23);
		panelLoaiSP.add(lblNewLabel);
		
		textFieldTenLoaiSP = new JTextField();
		textFieldTenLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldTenLoaiSP.setBounds(10, 502, 489, 23);
		panelLoaiSP.add(textFieldTenLoaiSP);
		textFieldTenLoaiSP.setColumns(10);
		
		JLabel lblTnLoiSn = new JLabel("Tên loại sản phẩm: ");
		lblTnLoiSn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnLoiSn.setBounds(10, 468, 141, 23);
		panelLoaiSP.add(lblTnLoiSn);
		
		textFieldMaLoaiSP = new JTextField();
		textFieldMaLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldMaLoaiSP.setColumns(10);
		textFieldMaLoaiSP.setBounds(10, 434, 489, 23);
		panelLoaiSP.add(textFieldMaLoaiSP);
		
		btnXoaLoaiSP = new JButton("Xóa loại sản phẩm");
		btnXoaLoaiSP.setToolTipText("Xóa một loại sản phẩm (sẽ không xóa được nếu loại sản phẩm đang được sử dụng) ");
		btnXoaLoaiSP.setBackground(new Color(255, 250, 205));
		btnXoaLoaiSP.setBounds(350, 536, 149, 32);
		panelLoaiSP.add(btnXoaLoaiSP);
		
		btnSuaLoaiSP = new JButton("Sửa loại sản phẩm");
		btnSuaLoaiSP.setToolTipText("Sửa một loại sản phẩm (sẽ không sửa được mã loại sản phẩm nếu loại sản phẩm đang được sử dụng)");
		btnSuaLoaiSP.setBackground(new Color(250, 250, 210));
		btnSuaLoaiSP.setBounds(350, 579, 149, 32);
		panelLoaiSP.add(btnSuaLoaiSP);
		
		textFieldTimKiemLoaiSP = new JTextField();
		textFieldTimKiemLoaiSP.setToolTipText("Nhập để tìm kiếm loại sản phẩm");
		textFieldTimKiemLoaiSP.setBounds(169, 579, 171, 32);
		panelLoaiSP.add(textFieldTimKiemLoaiSP);
		textFieldTimKiemLoaiSP.setColumns(10);
		
		btnXoaRongLoaiSP = new JButton("Xóa rỗng");
		btnXoaRongLoaiSP.setToolTipText("Xóa thông tin loại sản phẩm vừa nhập trên vùng nhập");
		btnXoaRongLoaiSP.setBackground(Color.WHITE);
		btnXoaRongLoaiSP.setBounds(10, 536, 149, 32);
		panelLoaiSP.add(btnXoaRongLoaiSP);
		
		btnThemLoaiSP = new JButton("Thêm loại sản phẩm");
		btnThemLoaiSP.setToolTipText("Thêm mới một loại sản phẩm");
		btnThemLoaiSP.setBackground(new Color(224, 255, 255));
		btnThemLoaiSP.setBounds(169, 536, 171, 32);
		panelLoaiSP.add(btnThemLoaiSP);
		
		comboBoxTimKiemLoaiSP = new JComboBox<String>();
		comboBoxTimKiemLoaiSP.setToolTipText("Tùy chọn tìm kiếm loại sản phẩm");
		comboBoxTimKiemLoaiSP.setBackground(new Color(175, 238, 238));
		comboBoxTimKiemLoaiSP.setBounds(10, 579, 149, 32);
		panelLoaiSP.add(comboBoxTimKiemLoaiSP);
		comboBoxTimKiemLoaiSP.setModel(new DefaultComboBoxModel<String>(new String[] {"Tìm loại theo mã", "Tìm loại theo tên"}));
		
		btnThemLoaiSP.addActionListener(this);
		
		panelSP = new JPanel();
		panelSP.setBorder(new LineBorder(new Color(255, 0, 0)));
		panelSP.setBackground(Color.WHITE);
		panelSP.setBounds(0, 0, 846, 681);
		quanLySP.add(panelSP);
		panelSP.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Quản lý sản phẩm");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(10, 0, 826, 38);
		panelSP.add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 40, 826, 377);
		
		panelSP.add(scrollPane_1);
		
		tableSP = new JTable(modelSP);
		
		tableSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_1.setViewportView(tableSP);
		
		JLabel lblMaSP = new JLabel("Mã sản phẩm:");
		lblMaSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaSP.setBounds(82, 424, 103, 30);
		panelSP.add(lblMaSP);
		
		JLabel lblTenSP = new JLabel("Tên sản phẩm:");
		lblTenSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenSP.setBounds(82, 453, 103, 30);
		panelSP.add(lblTenSP);
		
		JLabel lblSoLuongSP = new JLabel("Số lượng sản phẩm:");
		lblSoLuongSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoLuongSP.setBounds(82, 515, 141, 30);
		panelSP.add(lblSoLuongSP);
		
		JLabel lblDonGiaSP = new JLabel("Đơn giá:");
		lblDonGiaSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDonGiaSP.setBounds(82, 483, 60, 30);
		panelSP.add(lblDonGiaSP);
		
		JLabel lblMaLoaiSP = new JLabel("Mã loại sản phẩm:");
		lblMaLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaLoaiSP.setBounds(428, 515, 132, 30);
		panelSP.add(lblMaLoaiSP);
		
		textFieldSoLuongSP = new JTextField();
		textFieldSoLuongSP.setToolTipText("Nhập số lượng sản phẩm");
		textFieldSoLuongSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldSoLuongSP.setColumns(10);
		textFieldSoLuongSP.setBounds(214, 518, 209, 23);
		panelSP.add(textFieldSoLuongSP);
		
		textFieldDonGia = new JTextField();
		textFieldDonGia.setToolTipText("Nhập đơn giá sản phẩm");
		textFieldDonGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldDonGia.setColumns(10);
		textFieldDonGia.setBounds(214, 487, 502, 23);
		panelSP.add(textFieldDonGia);
		
		textFieldTenSP = new JTextField();
		textFieldTenSP.setToolTipText("Nhập tên sản phẩm");
		textFieldTenSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldTenSP.setColumns(10);
		textFieldTenSP.setBounds(214, 457, 502, 23);
		panelSP.add(textFieldTenSP);
		
		textFieldMaSP = new JTextField();
		textFieldMaSP.setToolTipText("Nhập mã sản phẩm (không được trùng mã với sản phẩm khác)");
		textFieldMaSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldMaSP.setColumns(10);
		textFieldMaSP.setBounds(214, 428, 502, 23);
		panelSP.add(textFieldMaSP);
		
		comboBoxMaLoaiSP = new JComboBox<String>();
		comboBoxMaLoaiSP.setToolTipText("Tùy chọn mã loại sản phẩm");
		comboBoxMaLoaiSP.setBackground(Color.WHITE);
		comboBoxMaLoaiSP.setBounds(554, 518, 162, 23);
		panelSP.add(comboBoxMaLoaiSP);
		
		btnThemSP = new JButton("Thêm sản phẩm");
		btnThemSP.setToolTipText("Thêm mới một sản phẩm");
		btnThemSP.setBackground(new Color(224, 255, 255));
		btnThemSP.setBounds(82, 562, 150, 32);
		panelSP.add(btnThemSP);
		
		btnXoaSP = new JButton("Xóa sản phẩm");
		btnXoaSP.setToolTipText("Xóa một sản phẩm (sẽ không xóa được nếu sản phẩm đang được hợp đồng)");
		btnXoaSP.setBackground(new Color(255, 250, 205));
		btnXoaSP.setBounds(566, 562, 150, 32);
		panelSP.add(btnXoaSP);
		
		btnSuaSP = new JButton("Sửa sản phẩm");
		btnSuaSP.setToolTipText("Sửa thông tin sản phẩm (sẽ không sửa được mã nếu sản phẩm phẩm đang được hợp đồng)");
		btnSuaSP.setBackground(new Color(250, 250, 210));
		btnSuaSP.setBounds(242, 562, 150, 32);
		panelSP.add(btnSuaSP);
		
		btnXoaRongSP = new JButton("Xóa rỗng");
		btnXoaRongSP.setToolTipText("Xóa thông tin sản phẩm vừa nhập trên vùng nhập sản phẩm");
		btnXoaRongSP.setBackground(Color.WHITE);
		btnXoaRongSP.setBounds(406, 562, 150, 32);
		panelSP.add(btnXoaRongSP);
		
		textFieldTimkiemSP = new JTextField();
		textFieldTimkiemSP.setToolTipText("Nhập để tìm kiếm sản phẩm");
		textFieldTimkiemSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldTimkiemSP.setColumns(10);
		textFieldTimkiemSP.setBounds(314, 614, 329, 32);
		panelSP.add(textFieldTimkiemSP);
		
		comboBoxTimKiemSP = new JComboBox<>();
		comboBoxTimKiemSP.setToolTipText("Tùy chọn để tìm kiếm");
		comboBoxTimKiemSP.setBackground(new Color(175, 238, 238));
		comboBoxTimKiemSP.setModel(new DefaultComboBoxModel<String>(new String[] {"Tìm sản phẩm theo mã ", "Tìm sản phẩm theo tên"}));
		comboBoxTimKiemSP.setBounds(142, 615, 162, 32);
		panelSP.add(comboBoxTimKiemSP);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 0, 0)));
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(851, 0, 505, 35);
		quanLySP.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(414, 0, 81, 35);
		lblNewLabel_2.setIcon(new ImageIcon("data\\\\img\\\\login.png"));
		lblNewLabel_2.setText("  "+GUI_DangNhap.getDnma());
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel();
		Date date = new Date();
		lblNewLabel_2_1.setText(date.getDate()+"/"+(date.getMonth()+1)+"/"+(date.getYear()+1900));
		lblNewLabel_2_1.setBounds(10, 0, 251, 35);
		panel.add(lblNewLabel_2_1);
		
		try{
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		sanPham_DAO = new DAO_SanPham();
		DocDuLieuSanPhamVaoTabel();
		DocDuLieuLoaiSanPhamVaoTabel();
		updateComboboxMaLoaiSP();
		tableSP.getSelectionModel().addListSelectionListener(listSelectionListenerTableSP);
		panelSP.addMouseListener(mouseListener);
		panelLoaiSP.addMouseListener(mouseListener);
		tableLoaiSP.getSelectionModel().addListSelectionListener(listSelectionListenerTableLoaiSP);
		
		filterLoaiSP = new TableRowSorter<TableModel>(modelLoaiSP);
		filterSP = new TableRowSorter<TableModel>(modelSP);
		
		btnThemSP.addActionListener(this);
		btnSuaSP.addActionListener(this);
		btnXoaSP.addActionListener(this);
		btnXoaRongSP.addActionListener(this);
		btnXoaLoaiSP.addActionListener(this);
		btnSuaLoaiSP.addActionListener(this);
		btnXoaRongLoaiSP.addActionListener(this);
		comboBoxTimKiemLoaiSP.addActionListener(this);
		comboBoxTimKiemSP.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o =e.getSource();
		if(o.equals(btnThemSP)) {
			if(kiemTraNhapSanPham()) {
				themSP();
			}
		}
		if(o.equals(btnSuaSP)) {
			suaSP();
		}
		
		if(o.equals(btnXoaRongSP)) {
			textFieldMaSP.setText("");
			textFieldTenSP.setText("");
			textFieldDonGia.setText("");
			textFieldSoLuongSP.setText("");
			comboBoxMaLoaiSP.setSelectedItem(-1);
		}
		if(o.equals(btnXoaSP)) {
			xoaSP();
		}
		if(o.equals(comboBoxTimKiemSP)) {
			timKiemSP();
		}
		if(o.equals(btnThemLoaiSP)) {
			if(kiemTraNhapLoaiSP()) {
				themLoaiSP();
			}
		}
		if(o.equals(btnXoaRongLoaiSP)) {
			textFieldMaLoaiSP.setText("");
			textFieldTenLoaiSP.setText("");
		}
		
		if(o.equals(comboBoxTimKiemLoaiSP)) {
			timKiemLoaiSP();
		}
		if(o.equals(btnSuaLoaiSP)) {
			suaLoaiSP();
		}
		
		if(o.equals(btnXoaLoaiSP)) {
			xoaLoaiSP();
		}

	}
	public void DocDuLieuSanPhamVaoTabel(){
		List<SanPham> dsSP = sanPham_DAO.getAllSanPham();
		
		for (SanPham sp :dsSP) {
			modelSP.addRow(new Object[] {
					sp.getMaSP(),sp.getTenSP(),sp.getSoLuongSP(),NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(sp.getDonGiaSP()),sp.getLoaiSP().getMaLoaiSP()
			});
		}
	}

	public void DocDuLieuLoaiSanPhamVaoTabel(){
		List<LoaiSanPham> dsLoaiSP = sanPham_DAO.getAllLoaiSanPham();
		
		for (LoaiSanPham lsp :dsLoaiSP) {
			modelLoaiSP.addRow(new Object[] {
					lsp.getMaLoaiSP(),lsp.getTenLoaiSP()
			});
		}
	}
	private void updateComboboxMaLoaiSP(){
		int n = sanPham_DAO.getAllLoaiSanPham().size(); 
		String []items = new String[n];
		int i = 0;
		for(LoaiSanPham lsp : sanPham_DAO.getAllLoaiSanPham()){
			items[i] = lsp.getMaLoaiSP();
			i++;
		}
		comboBoxMaLoaiSP.setModel(new DefaultComboBoxModel<String>(items));
	}
	public boolean kiemTraNhapSanPham() {
		String maSP = textFieldMaSP.getText();
		String tenSP = textFieldTenSP.getText();
		String soLuongSP = textFieldSoLuongSP.getText();
		String donGiaSP = textFieldDonGia.getText();
		
		if (!(maSP.length() > 0 && maSP.matches("[a-zA-Z'0-9 ]+"))) {
			JOptionPane.showMessageDialog(this, "NHẬP MÃ VÀ NHẬP ĐÚNG CÚ PHÁP (KHÔNG CÓ DẤU VÀ KÝ TỰ ĐẶC BIỆT)");
			return false;
		}
		if (!(tenSP.length() > 0 &&tenSP.matches("[A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\\\.,'\\\\-]+"))) {
			JOptionPane.showMessageDialog(this, "NHẬP TÊN ");
			return false;
		}
		if(!(soLuongSP.length()>0)) {
			JOptionPane.showMessageDialog(this,"NHẬP SỐ LƯỢNG SẢN PHẨM.");
		}
		
		if (soLuongSP.length() > 0) {
			try {
				int y = Integer.parseInt(soLuongSP);
				if (y <= 0) {
					JOptionPane.showMessageDialog(this,"SỐ LƯỢNG SẢN PHẨM PHẢI LỚN HƠN 0.");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,"SỐ LƯỢNG SẢN PHẨM PHẨI NHẬP SỐ.");
				return false;
			}
		}
		if(!(donGiaSP.length()>0)) {
			JOptionPane.showMessageDialog(this,"NHẬP SỐ ĐƠN GIÁ SẢN PHẨM.");
		}
		if (donGiaSP.length() > 0 && donGiaSP.length() <= 15) {
			try {
				double y = Double.parseDouble(donGiaSP);
				if (y <= 0) {
					JOptionPane.showMessageDialog(this,"ĐƠN GIÁ SẢN PHẨM PHẢI LỚN HƠN 0.");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this,"ĐƠN GIÁ SẢN PHẨM PHẢI NHẬP SỐ.");
				return false;
			}
		}
		if (!(comboBoxMaLoaiSP.getSelectedIndex()>=0)) {
			JOptionPane.showMessageDialog(this, "CHỌN MÃ LOẠI SẢN PHẨM ");
			return false;
		}
		return true;
	}
	public boolean kiemTraNhapLoaiSP() {
		String maLoaiSP = textFieldMaLoaiSP.getText();
		String tenLoaiSP = textFieldTenLoaiSP.getText();
		
		if (!(maLoaiSP.length() > 0&&maLoaiSP.matches("[a-zA-Z'0-9 ]+") )) {
			JOptionPane.showMessageDialog(this, "NHẬP MÃ LOẠI SẢN PHẨM VÀ NHẬP ĐÚNG CÚ PHÁP (KHÔNG CÓ DẤU VÀ KÝ TỰ ĐẶC BIỆT)");
			return false;
		}
		if (!(tenLoaiSP.length() > 0 &&tenLoaiSP.matches("[A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\\\.,'\\\\-]+") )) {
			JOptionPane.showMessageDialog(this, "NHẬP TÊN LOẠI SẢN PHẨM");
			return false;
		}
		return true;
	}
	
	ListSelectionListener listSelectionListenerTableSP = new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			int row = tableSP.getSelectedRow(); 
			if(row != -1){
				String maSP = tableSP.getValueAt(row, 0).toString();
				SanPham sp = new SanPham(maSP);
				ArrayList<SanPham> listSanPham = sanPham_DAO.getAllSanPham();
				if(sanPham_DAO.getAllSanPham().contains(sp)){
					sp = listSanPham.get(listSanPham.indexOf(sp));
					textFieldMaSP.setText(sp.getMaSP());
					textFieldTenSP.setText(sp.getTenSP());
					textFieldSoLuongSP.setText(sp.getSoLuongSP()+"");
					textFieldDonGia.setText((long)sp.getDonGiaSP()+"");
					comboBoxMaLoaiSP.setSelectedItem(tableSP.getValueAt(row, 4));
					
					LoaiSanPham loaiSanPham  = new LoaiSanPham(tableSP.getValueAt(row, 4).toString());
					if(loaiSanPham != null){
						int index = sanPham_DAO.getAllLoaiSanPham().indexOf(loaiSanPham);
						tableLoaiSP.getSelectionModel().setSelectionInterval(index, index);
						tableLoaiSP.scrollRectToVisible(tableLoaiSP.getCellRect(index, index, true));
					}
				}
			}
		}
	};
	
	MouseListener mouseListener = new MouseListener() {
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {
			tableLoaiSP.setEnabled(true);
			tableSP.setEnabled(true);	
		}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseClicked(MouseEvent e) {
			tableLoaiSP.clearSelection();
			tableSP.clearSelection();
			tableLoaiSP.setEnabled(false);
			tableSP.setEnabled(false);
			textFieldMaLoaiSP.setText("");
			tableSP.setRowSorter(filterSP);
			tableLoaiSP.setRowSorter(filterLoaiSP);
			filterLoaiSP.setRowFilter(RowFilter.regexFilter(""));
			filterSP.setRowFilter(RowFilter.regexFilter(""));
			textFieldTimKiemLoaiSP.setText("");
			textFieldTenLoaiSP.setText("");
			textFieldMaSP.setText("");
			textFieldTenSP.setText("");
			textFieldDonGia.setText("");
			textFieldMaLoaiSP.setText("");
			textFieldTenLoaiSP.setText("");
			textFieldSoLuongSP.setText("");
			comboBoxMaLoaiSP.setSelectedItem(null);
		}
	};
	
	ListSelectionListener listSelectionListenerTableLoaiSP = new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			int row = tableLoaiSP.getSelectedRow(); 
			if(row != -1){
				String maLoaiSP = tableLoaiSP.getValueAt(row, 0).toString();
				LoaiSanPham lsp = new LoaiSanPham(maLoaiSP);
				ArrayList<LoaiSanPham> lsLoaiSP = sanPham_DAO.getAllLoaiSanPham();
				if(sanPham_DAO.getAllLoaiSanPham().contains(lsp)){
					lsp = lsLoaiSP.get(lsLoaiSP.indexOf(lsp));
					textFieldMaLoaiSP.setText(lsp.getMaLoaiSP());
			        textFieldTenLoaiSP.setText(lsp.getTenLoaiSP());
				}
		    }
		}
	};
	
	public void themSP() {
		String maSP = textFieldMaSP.getText();
		String tenSP = textFieldTenSP.getText();
		int soLuongSP = Integer.parseInt(textFieldSoLuongSP.getText());
		double donGiaSP = Double.parseDouble(textFieldDonGia.getText());
		String maLoaiSP = comboBoxMaLoaiSP.getSelectedItem().toString();
		
		LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiSP);
		SanPham sanPham = new SanPham(maSP,tenSP,soLuongSP,donGiaSP,loaiSanPham);
		if(!sanPham_DAO.getAllSanPham().contains(sanPham)) {
			try {
				sanPham_DAO.creatSanPham(sanPham);
				modelSP.addRow(new Object[] {
						sanPham.getMaSP(),sanPham.getTenSP(),sanPham.getSoLuongSP(),NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(sanPham.getDonGiaSP()),sanPham.getLoaiSP().getMaLoaiSP()
				});
				textFieldMaSP.setText("");
				textFieldTenSP.setText("");
				textFieldSoLuongSP.setText("");
				textFieldDonGia.setText("");
				comboBoxMaLoaiSP.setSelectedItem(null);
				JOptionPane.showMessageDialog(this, "Them thanh cong");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(this, "TRÙNG!");
		}
	}
	
	public void suaSP() {
		int row = tableSP.getSelectedRow();
		if(row!=-1) {
			if(kiemTraNhapSanPham()) {
				String maSP = textFieldMaSP.getText();
				String tenSP = textFieldTenSP.getText();
				int soLuongSP = Integer.parseInt(textFieldSoLuongSP.getText());
				double donGiaSP = Double.parseDouble(textFieldDonGia.getText());
				
				String maLoaiSP = comboBoxMaLoaiSP.getSelectedItem().toString();
				LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiSP);
				SanPham sanPham = new SanPham(maSP,tenSP,soLuongSP,donGiaSP,loaiSanPham);
				
				String dieuKien = tableSP.getValueAt(row,0).toString();
				
				if(sanPham_DAO.updateSanPham(sanPham,dieuKien)) {
					tableSP.setValueAt(textFieldMaSP.getText(), row, 0);
					tableSP.setValueAt(textFieldTenSP.getText(), row, 1);
					tableSP.setValueAt(textFieldSoLuongSP.getText(), row, 2);
					tableSP.setValueAt(NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(Double.parseDouble(textFieldDonGia.getText())), row, 3);
					tableSP.setValueAt(comboBoxMaLoaiSP.getSelectedItem().toString(), row,4);
					
					JOptionPane.showMessageDialog(this,"Đã sửa thành công");
				}
				else {
					JOptionPane.showMessageDialog(this, "Không sửa được mã sản phẩm");
				}
			}
		}
		else
			JOptionPane.showMessageDialog(this, "Bạn phải chọn sản phẩm cần sửa.");
	}
	
	public void xoaSP() {
		int row = tableSP.getSelectedRow();
		if(row != -1){
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa sản phẩm không? ", "Chú ý", JOptionPane.YES_NO_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION){
				String maSP = tableSP.getValueAt(row, 0).toString();
				if(sanPham_DAO.deleteSanPham(maSP)) {
					modelSP.removeRow(row);
					textFieldMaSP.setText("");
					textFieldTenSP.setText("");
					textFieldDonGia.setText("");
					textFieldSoLuongSP.setText("");
					comboBoxMaLoaiSP.setSelectedItem(null);
					JOptionPane.showMessageDialog(this, "Đã xóa 1 sản phẩm.");										
				}
				else {
					JOptionPane.showMessageDialog(this, "Không xóa được vì sản phẩm đang được hợp đồng");
				}
			}
		}else
			JOptionPane.showMessageDialog(this, "Bạn phải chọn sản phẩm cần xóa. ");
	}
	
	public void timKiemSP() {
		int select = comboBoxTimKiemSP.getSelectedIndex();
		if(select==0) {
			tableSP.setRowSorter(filterSP);
			filterSP.setRowFilter(RowFilter.regexFilter(textFieldTimkiemSP.getText(),0));
		}
		if (select==1) {
			tableSP.setRowSorter(filterSP);
			filterSP.setRowFilter(RowFilter.regexFilter(textFieldTimkiemSP.getText(),1));
		}
	}
	
	public void themLoaiSP() {
		String maLoaiSP = textFieldMaLoaiSP.getText();
		String tenLoaiSP = textFieldTenLoaiSP.getText();
		
		LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiSP,tenLoaiSP);
		if(!sanPham_DAO.getAllLoaiSanPham().contains(loaiSanPham)) {
			try {
				sanPham_DAO.createLoaiSP(loaiSanPham);
				modelLoaiSP.addRow(new Object[] {loaiSanPham.getMaLoaiSP(),loaiSanPham.getTenLoaiSP()});
				updateComboboxMaLoaiSP();
				textFieldMaLoaiSP.setText("");
				textFieldTenLoaiSP.setText("");
				JOptionPane.showMessageDialog(this, "Thêm thành công");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(this, "TRÙNG!");
		}
	}
	
	public void timKiemLoaiSP() {
		int select = comboBoxTimKiemLoaiSP.getSelectedIndex();
		if(select==0) {
//			LoaiSanPham loaiSanPham = new LoaiSanPham(textFieldTimKiemLoaiSP.getText());
//			if(loaiSanPham != null){
//				int index = sanPham_DAO.getAllLoaiSanPham().indexOf(loaiSanPham);
//				tableLoaiSP.getSelectionModel().setSelectionInterval(index, index);
//				tableLoaiSP.scrollRectToVisible(tableLoaiSP.getCellRect(index, index, true));
//				if(index==-1)
//					JOptionPane.showMessageDialog(this,"KHÔNG TÌM THẤY");
//			}
			tableLoaiSP.setRowSorter(filterLoaiSP);
			filterLoaiSP.setRowFilter(RowFilter.regexFilter(textFieldTimKiemLoaiSP.getText(),0));
		}
		if (select==1) {
			tableLoaiSP.setRowSorter(filterLoaiSP);
			filterLoaiSP.setRowFilter(RowFilter.regexFilter(textFieldTimKiemLoaiSP.getText(),1));
		}
	}
	
	public void suaLoaiSP() {
		int row = tableLoaiSP.getSelectedRow();
		if(row!=-1) {
			if(kiemTraNhapLoaiSP()) {
				String maLoaiSP = textFieldMaLoaiSP.getText();
				String tenLoaiSP = textFieldTenLoaiSP.getText();
				LoaiSanPham loaiSanPham = new LoaiSanPham(maLoaiSP, tenLoaiSP);
				String dieuKien = tableSP.getValueAt(row,0).toString();
				
				if(sanPham_DAO.updateLoaiSP(loaiSanPham,dieuKien)) {
					tableLoaiSP.setValueAt(textFieldMaLoaiSP.getText(), row, 0);
					tableLoaiSP.setValueAt(textFieldTenLoaiSP.getText(), row, 1);
					
					JOptionPane.showMessageDialog(this,"Đã sửa thành công");
				}
				else {
					JOptionPane.showMessageDialog(this, "Không sửa được mã sản phẩm vì mã loại sản phẩm đang được sử dụng!");
				}
			}
		}
		else
			JOptionPane.showMessageDialog(this, "Bạn phải chọn sản phẩm cần sửa. ");
	}
	
	public void xoaLoaiSP() {
		int row = tableLoaiSP.getSelectedRow();
		if(row != -1){
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không? ", "Chú ý", JOptionPane.YES_NO_OPTION);
			if(hoiNhac == JOptionPane.YES_OPTION){
				String maLoaiSP = tableLoaiSP.getValueAt(row, 0).toString();
				if(sanPham_DAO.deleteLoaiSP(maLoaiSP)) {
					modelLoaiSP.removeRow(row);
					textFieldMaLoaiSP.setText("");
					textFieldTenLoaiSP.setText("");
					JOptionPane.showMessageDialog(this, "Đã xóa 1 loại sản phẩm.");					
					updateComboboxMaLoaiSP();					
				}
				else {
					JOptionPane.showMessageDialog(this, "không xoá được vì vẫn còn sản phẩm thuộc loại này!");
				}
			}
		}else
			JOptionPane.showMessageDialog(this, "Bạn phải chọn loại sản phẩm cần xóa. ");
	}
	
}

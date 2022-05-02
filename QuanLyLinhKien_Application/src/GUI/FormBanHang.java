package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.DAO_ChiTietHoaDon;
import dao.DAO_KhachHang;
import dao.DAO_HoaDon;
import dao.DAO_LinhKien;
import entity.ChiTietHoaDon;
import entity.KhachHang;
import entity.HoaDon;
import entity.LinhKien;




public class FormBanHang  extends JFrame implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTenKH;
	private JTextField txtMaKH;
	private JTextField txtSDT;
	private JTextField txtSoLuong;
	private JTextField txtDiaChi;
	private JTextField  txtGia, txtMaHD, txtMaLK;
	
	private JButton btnThemKH;
	private JButton btnThemHD;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JButton btnThanhToan, btnThoat, btnInHD;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTable tableKH;
	//FromTam tableModelKH;
	private DefaultTableModel tableModelKH;

	private DAO_ChiTietHoaDon daoCTHD;
	private DAO_KhachHang daoKH;
	private ArrayList<KhachHang> list;


	
	public FormBanHang() {
		setTitle("Quản Lý Bán Hàng - Linh Kiện Máy Tính");
		setSize(750, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		JPanel pnNorth = new JPanel();
		add(pnNorth, BorderLayout.NORTH);
		pnNorth.setBackground(new Color(0,255,0));
		JLabel lblNewLabel = new JLabel("Quản Lý Bán Hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(100, 10 , 100, 25);
		pnNorth.add(lblNewLabel);
		
		JPanel pnCenter = new JPanel();
		add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null); 
		JPanel pnThongTinKH;
		pnCenter.add(pnThongTinKH = new JPanel());
		pnThongTinKH.setBackground(new Color(245,255,250));
		pnThongTinKH.setLayout(null);
		pnThongTinKH.setBorder(BorderFactory.createTitledBorder("Thông Tin Khách Hàng"));
		JLabel  lblTenKH, lblMaKH, lblSDT, lblDiaChi;
		pnThongTinKH.add(lblTenKH = new JLabel("Tên Khách Hàng:"));
		pnThongTinKH.add(txtTenKH = new JTextField());
		pnThongTinKH.add(lblMaKH = new JLabel("Mã Khách Hàng:"));
		pnThongTinKH.add(txtMaKH = new JTextField());
		pnThongTinKH.add(lblSDT = new JLabel("Số Điện Thoại:"));
		pnThongTinKH.add(txtSDT = new JTextField());
		pnThongTinKH.add(lblDiaChi = new JLabel("Địa Chỉ:"));
		pnThongTinKH.add(txtDiaChi = new JTextField());
		pnThongTinKH.add(btnThemKH = new JButton("Thêm Khách Hàng"));
		lblMaKH.setBounds(10, 50 , 100, 25);
		txtMaKH.setBounds(120, 50 , 180, 25);
		lblTenKH.setBounds(10, 85 , 100, 25);
		txtTenKH.setBounds(120, 85 , 180, 25);	
		lblSDT.setBounds(10, 120 , 100, 25);
		txtSDT.setBounds(120, 120 , 180, 25);		
		lblDiaChi.setBounds(10, 155 , 100, 25);
		txtDiaChi.setBounds(120, 155 , 180, 25);
		btnThemKH.setBounds(90, 200 , 150, 30);
		pnThongTinKH.setBounds(30, 20, 330, 250);
				
		JPanel pnThongTinLK;
		pnCenter.add(pnThongTinLK = new JPanel());
		pnThongTinLK.setLayout(null);
		pnThongTinLK.setBackground(new Color(245,255,250));
		pnThongTinLK.setBorder(BorderFactory.createTitledBorder("Thông Tin Hóa Đơn"));
		JLabel lblMaHD, lblMaLK, lblSL, lblGia;
		pnThongTinLK.add(lblMaHD = new JLabel("Mã Hóa Đơn:"));
		pnThongTinLK.add(txtMaHD = new JTextField());
		pnThongTinLK.add(lblMaLK = new JLabel("Mã Linh Kiện:"));
		pnThongTinLK.add(txtMaLK = new JTextField());
		pnThongTinLK.add(lblGia = new JLabel("Đơn Giá:"));
		pnThongTinLK.add(txtGia = new JTextField());
		pnThongTinLK.add(lblSL = new JLabel("Số Lượng:"));
		pnThongTinLK.add(txtSoLuong = new JTextField());
		pnThongTinLK.add(btnThemHD = new JButton("Thêm Vào Hóa Đơn"));
		lblMaHD.setBounds(20, 50 , 100, 25);
		txtMaHD.setBounds(120, 50 , 180, 25);		
		lblMaLK.setBounds(20, 85 , 100, 25);
		txtMaLK.setBounds(120, 85 , 180, 25);	
		lblGia.setBounds(20, 120 , 100, 25);
		txtGia.setBounds(120, 120 , 180, 25);
		lblSL.setBounds(20, 160 , 100, 25);
		txtSoLuong.setBounds(120, 160 , 180, 25);		
		btnThemHD.setBounds(100, 200 , 150, 30);		
		pnThongTinLK.setBounds(380, 20, 330, 250);	
		
		JPanel pnTable1;
		pnCenter.add(pnTable1 = new JPanel());
		pnTable1.setBackground(new Color(224,255,255));
		pnTable1.setLayout(null);
		pnTable1.setBorder(BorderFactory.createTitledBorder("Thông Tin Khách Hàng"));
		String header1 [] = {"Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Địa Chỉ", };String data[][] = { { "KH0001", "Nguyễn Lê Nam Anh", "0123546852","12 Trần Não Q.2 TP.HCM"  },  { "KH0001", "Nguyễn Lê Nam Anh", "0123546852","12 Trần Não Q.2 TP.HCM" }, { "KH0003", "Nguyễn Tuấn Kiệt", "0152478654","321 Quang Trung Q.Gò vấp TP.HCM" },{"KH0004","Phan Tuấn Tài","0124536852","213 Nguyễn Thị Minh Khai Q.3 TP.HCM"},
				{"KH0005","Lưu Quang Vinh","0524368547","10 Ngô Quyền Q.5 TP.HCM"},{"KH0006","Lê Hoàng","0623154789","01 Nguyễn Tất Thành Q.4 TP.HCM"},{"KH0006","Lê Hoàng","0623154789","01 Nguyễn Tất Thành Q.4 TP.HCM"},{"KH0008","Trần Thị Giàu","0192468523","232/5 Lê Lợi Q.1 TP.HCM"},{"KH0009","Lê Hoàng","0623154789","01 Nguyễn Tất Thành Q.4 TP.HCM"}};
		
		//tableModelKH = new  FromTam(header1);
		tableModelKH = new  DefaultTableModel(data,header1);
		tableKH = new JTable(tableModelKH);	
		JScrollPane jsc1 = new JScrollPane(tableKH);
		jsc1.setBounds(10, 20, 680, 100);
		jsc1.setBackground(Color.white);
		pnTable1.add(jsc1);
		
		pnTable1.setBounds(20, 280, 700, 130);
		
		JPanel pnTable;
		pnCenter.add(pnTable = new JPanel());
		pnTable.setBackground(new Color(224,255,255));
		pnTable.setLayout(null);
		pnTable.setBorder(BorderFactory.createTitledBorder("Chi Tiết Hóa Đơn"));
		String headers [] = {"Mã hóa đơn", "Mã linh kiện", "Giá bán", "Số lượng"};
		tableModel = new  DefaultTableModel(headers, 0);
		table = new JTable(tableModel);	
		JScrollPane jsc = new JScrollPane(table);
		jsc.setBounds(10, 20, 680, 140);
		jsc.setBackground(Color.white);
		pnTable.add(jsc);
		
		
		pnTable.add(btnXoa = new JButton("Xóa"));
		pnTable.add(btnLamMoi = new JButton("Làm Mới"));
		pnTable.add(btnSua = new JButton("Sửa"));
		btnXoa.setBounds(220, 165, 80, 25);
		btnLamMoi.setBounds(310, 165, 100, 25);
		btnSua.setBounds(420, 165, 80, 25);
		pnTable.setBounds(20, 420, 700, 200);
		
		
		JPanel pnCTSouth2;
		pnCenter.add(pnCTSouth2 = new JPanel());
		pnCTSouth2.setLayout(null);
		pnCTSouth2.add(btnThanhToan = new JButton("In Hóa Đơn"));
		btnThanhToan.setBounds(0, 5, 100, 25);
		pnCTSouth2.add(btnThanhToan = new JButton("Thanh Toán"));
		btnThanhToan.setBounds(115, 5, 100, 25);
		pnCTSouth2.add(btnThoat = new JButton("Thóat"));
		btnThoat.setBounds(530, 5, 100, 25);
		pnCTSouth2.setBounds(60, 650, 630, 40);


		
		btnThemKH.addActionListener(this);
		tableKH.addMouseListener(this);
		table.addMouseListener(this);
		btnThemHD.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnThoat.addActionListener(this);

		//Database.getInstance().connect();
		//DocDuLieuDatabaseVaoTableKH();
	}
	
	public static void main(String[] args) {
		new FormBanHang().setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableKH.getSelectedRow();
		txtMaKH.setText(tableKH.getValueAt(row, 0).toString());
		txtMaKH.setEditable(false);
		txtTenKH.setText(tableKH.getValueAt(row, 1).toString());
		txtSDT.setText(tableKH.getValueAt(row, 2).toString());
		txtDiaChi.setText(tableKH.getValueAt(row, 3).toString());
		int row2 = table.getSelectedRow();
		txtMaHD.setText(table.getValueAt(row2, 0).toString());
		txtMaHD.setEditable(false);
		txtMaLK.setText(table.getValueAt(row2, 1).toString());
		txtGia.setText(table.getValueAt(row2, 2).toString());
		txtSoLuong.setText(table.getValueAt(row2, 3).toString());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThemHD)) {
			if(txtMaHD.getText().equals("")||txtMaLK.getText().equals("")||txtGia.getText().equals("")||txtSoLuong.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập dữ liệu!");
			}else {			
				String data[] = {txtMaHD.getText(), txtMaLK.getText(), txtGia.getText(), txtSoLuong.getText()};
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				tableModel.addRow(data);
				JOptionPane.showMessageDialog(null, "Thêm Thành Công");
		}
		}else if (o.equals(btnThemKH)) {
				if(txtMaKH.getText().equals("")||txtTenKH.getText().equals("")||txtSDT.getText().equals("")||txtDiaChi.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập dữ liệu!");
				}else {			
					String data2[] = {txtMaKH.getText(), txtTenKH.getText(), txtSDT.getText(), txtDiaChi.getText()};
					DefaultTableModel tableModelKH = (DefaultTableModel) tableKH.getModel();
					tableModelKH.addRow(data2);
					JOptionPane.showMessageDialog(null, "Thêm Thành Công");
				}
			
		}else if(o.equals(btnLamMoi)) {
			txtMaHD.setText("");
			txtMaLK.setText("");
			txtGia.setText("");
			txtSoLuong.setText("");
			txtMaHD.requestFocus();
		}else if(o.equals(btnXoa)) {
			int i = table.getSelectedRow();
			if(i>=0) {
				tableModel.removeRow(i);
				txtMaHD.setText("");
				txtMaLK.setText("");
				txtGia.setText("");
				txtSoLuong.setText("");
				JOptionPane.showMessageDialog(null, "Xóa Thành Công");
			}else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng để xóa!");
			}
				
		}else if(o.equals(btnSua)) {
			int i = table.getSelectedRow();
			
			if(i>=0) {
				tableModel.setValueAt(txtMaHD.getText(), i, 0);
				tableModel.setValueAt(txtMaLK.getText(), i, 1);
				tableModel.setValueAt(txtGia.getText(), i, 2);
				tableModel.setValueAt(txtSoLuong.getText(), i, 3);	
				JOptionPane.showMessageDialog(null, "Sửa Thành Công");
			}else {
				JOptionPane.showMessageDialog(null, "Vui Lòng Nhập Dữ Liệu Mới Cần Sửa!");
			}
		}else if(o.equals(btnThoat)) {
			GiaoDienChinh info=new GiaoDienChinh();
			info.setVisible(true);
			//	info.pHD8ack();
			info.setLocationRelativeTo(null);
			info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dispose();
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
	


	
}

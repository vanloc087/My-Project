  package GUI;
import java.awt.ActiveEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import connectDB.Database;
import dao.DAO_KhachHang;
import entity.KhachHang;
import entity.LinhKien;
import entity.NhanVien;

public class FormKhachHang extends JFrame  implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMa,txtten,txtdiachi,txtsdt,txtTimKiem,txtTimKiemID,txtSapXep;
	private JButton btnXoa,btnSua,btnTimKiem,btnTimKiemID,btnThem,btnXoatrang,btnThoat,btnTaiLai,btnXoaBang,btnHienThi,btnLichSuMua;
	private DefaultTableModel model;
	private JComboBox<String> jcbTimKiem, jcbSapXep;
	private JTable table;
	private String[] cols={"Mã Khách Hàng","Tên Khách Hàng", "Số Điện Thoại" ,"Địa Chỉ"};
	private DAO_KhachHang dao_KhachHang;
	private ArrayList<KhachHang> list;
	private JScrollPane scrl;
	public FormKhachHang() {
		// TODO Auto-generated constructor stub
		setTitle("Quản Lý Khách Hàng");
		setResizable(false);
		setSize(900, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Database.getInstance().connect();
		dao_KhachHang=  new DAO_KhachHang();
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		scrl= new JScrollPane(table);
		scrl.setPreferredSize(new Dimension(600, 550));
		
		JPanel ptren = new JPanel();
		JLabel lblTitile = new JLabel("Quản Lý Khách Hàng");
		
		
		
		
		
		
		Font fTitle = new Font("tahoma", Font.BOLD,24);
		lblTitile.setFont(fTitle);
		ptren.add(lblTitile);
		add(ptren,BorderLayout.NORTH);
		Box B = new Box(BoxLayout.Y_AXIS);
		Box bl = Box.createVerticalBox();
		Box br = Box.createVerticalBox();
		JPanel a = new JPanel(new BorderLayout());
		JPanel v = new JPanel(new BorderLayout());
		JPanel t = new JPanel(new BorderLayout());
		Box bb = new Box(BoxLayout.X_AXIS);
		Box b1,b2,b3,b4,a1,a2,a3;
		
		JLabel lbTraCuu = new JLabel("Tra Cứu Thông Tin ");
		Font fTraCuu = new Font("tahoma", Font.BOLD,12);
		lbTraCuu.setFont(fTraCuu);
		lbTraCuu.setForeground(Color.red);
		a1=new Box(BoxLayout.X_AXIS);
		a1.add(lbTraCuu);
		v.add(a1,BorderLayout.WEST);
		
		String loaiTimKiem[] = {"Tìm Theo Mã","Tìm Theo Tên","Tìm Theo SĐT","Tìm Theo Địa Chỉ"};
		jcbTimKiem = new JComboBox<String>(loaiTimKiem);
		t.add(a2 =new Box(BoxLayout.X_AXIS),BorderLayout.WEST);
		a2.add(new JLabel(" Loại Tìm Kiếm :"));
		a2.add(jcbTimKiem);
		a2.add(txtTimKiem= new JTextField(20));
		btnTimKiem = new JButton("Tìm Kiếm");
		a2.add(btnTimKiem);
		B.add(v);
		B.add(t);
		
		String loaiHienThi[] = {"Hiển Thị Theo Mã","Hiển Thị Theo Tên","Chỉ Khách Hàng Nội Thành"};
		jcbSapXep = new JComboBox<String>(loaiHienThi);
		a.add(a3 =new Box(BoxLayout.X_AXIS),BorderLayout.WEST);
		a.add(Box.createVerticalStrut(10));
		a3.add(new JLabel(" Loại Hiển Thị  :"));
		a3.add(jcbSapXep);
		btnHienThi = new JButton("Hiển Thị");
		a3.add(btnHienThi);
		B.add(a);
		
		
		

	
		
		JLabel lbBang = new JLabel("Bảng Khách Hàng");
		Font fBang = new Font("tahoma", Font.BOLD,17);
		lbBang.setFont(fBang);
		lbBang.setForeground(Color.blue);
		
		JPanel b = new JPanel(new BorderLayout());
		b.add(lbBang,BorderLayout.WEST);
		B.add(b);
		
		table.setOpaque(true);
		table.setFillsViewportHeight(true);
		table.setBackground(Color.WHITE);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(Color.decode("#c4c4c4"));
		table.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.WHITE));
		TableColumnModel columnModel = table.getColumnModel();
//		table.setShowGrid(false);
		table.setShowVerticalLines(false);
		table.setGridColor(Color.decode("#c4c4c4"));
		table.setRowHeight(25);
		table.setSelectionBackground(Color.decode("#c4c4c4"));
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(50);
		columnModel.getColumn(3).setPreferredWidth(60);

		B.add(scrl);
		
		

		bl.add(b2 = Box.createHorizontalBox());
		bl.add(Box.createVerticalStrut(10));
		b2.add(new JLabel(" Mã Khách Hàng:    "));
		b2.add(txtMa= new JTextField(10));

		bl.add(b1 = Box.createHorizontalBox());
		bl.add(Box.createVerticalStrut(10));
		b1.add(new JLabel(" Tên Khách Hàng:   "));
		b1.add(txtten= new JTextField(10));

		br.add(b3 = Box.createHorizontalBox());
		br.add(Box.createVerticalStrut(10));
		b3.add(new JLabel(" Địa Chỉ:                  "));
		b3.add(txtdiachi= new JTextField(10));

		br.add(b4 = Box.createHorizontalBox());
		br.add(Box.createVerticalStrut(10));
		b4.add(new JLabel(" Số Điện Thoại:       "));
		b4.add(txtsdt= new JTextField(10));
		
		
		
		//

		
		
		bb.add(bl);
		bb.add(br);
		B.add(bb);
		

		
		add(B);
		JPanel pduoi = new JPanel(new BorderLayout());
		Box pduoi1 = new Box(BoxLayout.X_AXIS);
		Box pduoi2 = new Box(BoxLayout.X_AXIS);
		btnThem = new JButton("Thêm");
		btnXoaBang =new JButton("Làm Trắng Bảng");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xoá");
		btnXoatrang = new JButton("Xoá Trắng");
		btnThoat = new JButton("Trở Lại");
		btnTaiLai = new JButton("Tải lại bảng");
		btnLichSuMua = new JButton("Lịch Sử Mua Hàng");
		pduoi1.add(btnXoaBang);
		pduoi1.add(btnThem);
		pduoi1.add(btnSua);
		pduoi1.add(btnXoa);
		pduoi1.add(btnXoatrang);
		pduoi1.add(btnTaiLai);
		//pduoi1.add(btnLichSuMua);
		pduoi2.add(btnThoat);
		pduoi.add(pduoi1,BorderLayout.WEST);
		pduoi.add(pduoi2,BorderLayout.EAST );
		B.add(pduoi);
		
		btnThem.setToolTipText("Thêm khách hàng theo thông tin đã điền vào bảng khách hàng!");
		jcbTimKiem.setToolTipText("Chọn loại tìm kiếm (Theo Mã,Theo Tên,Theo SĐT)");
		txtTimKiem.setToolTipText("Nhập vào thông tin khách hàng cần tìm theo loại tìm kiếm");
		btnTimKiem.setToolTipText("Hiện thị khách hàng cần tìm lên bảng khách hàng");
		btnTaiLai.setToolTipText("Làm mới bảng khách hàng");
		btnThoat.setToolTipText("Quay lại giao diện chính");
		btnXoaBang.setToolTipText("Làm trắng bảng khách hàng !");
		btnXoa.setToolTipText("Xóa khách hàng đang chọn!");
		btnSua.setToolTipText("Sửa thông tin khách hàng theo mẫu được nhập"+  txtMa.getText());
		txtdiachi.setToolTipText("Địa chỉ của khách hàng");
		txtMa.setToolTipText("Mã của khách hàng");
		txtsdt.setToolTipText("Số điện thoại của khách hàng");
		txtten.setToolTipText("Tên của khách hàng");
		btnHienThi.setToolTipText("Sắp xếp lại bảng theo loại hiển thị");
		btnLichSuMua.setToolTipText("Hiển thị lịch sử mua hàng");
		jcbSapXep.setToolTipText("Chọn cách sắp xếp khách hàng trên bảng khách hàng");
		
		
		DocDuLieuDatabaseVaoTable();
		btnXoaBang.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoatrang.addActionListener(this);
		btnThoat.addActionListener(this);
		btnSua.addActionListener(this);
		btnTaiLai.addActionListener(this);
		btnHienThi.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnLichSuMua.addActionListener(this);
		table.addMouseListener(this);
		DAO_KhachHang dnv = new DAO_KhachHang();
		list = dnv.getAllKhachHang();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FormKhachHang().setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMa.setText(model.getValueAt(row, 0).toString());
		txtten.setText(model.getValueAt(row, 1).toString());
		txtsdt.setText(model.getValueAt(row, 2).toString());
		txtdiachi.setText(model.getValueAt(row, 3).toString());
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if(txtten.getText().equals("")|| txtMa.getText().equals("")||txtsdt.getText().equals("")||txtdiachi.getText().equals(""))

				JOptionPane.showMessageDialog(this, "Không được để trống");
			else {
				if(KiemTra()) {
					KhachHang kh= new KhachHang(txtMa.getText(), txtten.getText(), txtsdt.getText(), txtdiachi.getText());
					if(!(dao_KhachHang.create(kh))) {
						JOptionPane.showMessageDialog(this, "Trùng Mã");
					}else {
						dao_KhachHang.create(kh);
						model.addRow(new Object[] {
								kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getSDT(),kh.getDiaChi()
						});
						JOptionPane.showMessageDialog(this, "Thêm Thành Công");
					}
					}
				}
			}
		if(o.equals(btnThoat)) {
			GiaoDienChinh info=new GiaoDienChinh();
			info.setVisible(true);
			//	info.pHD8ack();
			info.setLocationRelativeTo(null);
			info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dispose();
		}
		if(o.equals(btnXoa)) {
			if( txtMa.getText().equals(""))

				JOptionPane.showMessageDialog(this, "Không được để trống");
			else {
				int hoinhac = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xóa khách hàng này?","Warnning",JOptionPane.YES_NO_CANCEL_OPTION);
				if(hoinhac == JOptionPane.YES_OPTION) {
					try {
							int r= table.getSelectedRow();
							model.removeRow(r); 
							dao_KhachHang.xoa(txtMa.getText());
							JOptionPane.showMessageDialog(this, "Xóa Thành Công");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			}
			
	if(o.equals(btnSua)) {
		KhachHang kh= new KhachHang(txtMa.getText(), txtten.getText(), txtsdt.getText(), txtdiachi.getText());
		if(txtten.getText().equals("")|| txtMa.getText().equals("")||txtsdt.getText().equals("")||txtdiachi.getText().equals("")) {

			JOptionPane.showMessageDialog(this, "Không được để trống");
		}
		else if(dao_KhachHang.create(kh)) {
			JOptionPane.showMessageDialog(this, "Mã khách hàng không tồn tại");
		}
		else if(KiemTra()) {
			int hoinhac = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn sửa khách hàng này?","Warnning",JOptionPane.YES_NO_CANCEL_OPTION);
			if(hoinhac == JOptionPane.YES_OPTION) {
				try {
					dao_KhachHang.update(kh);
					JOptionPane.showMessageDialog(this, "Sửa Thành Công");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		  }
		}
	 if(o.equals(btnXoatrang)) {
		 txtMa.setText("");
		 txtten.setText("");
		 txtsdt.setText("");
		 txtdiachi.setText("");
	 }
	 if(o.equals(btnTaiLai)) {
		 XoaHetDuLieuTrenTableModel();
		 DocDuLieuDatabaseVaoTable();
	 }
	if(o.equals(btnTimKiem))
	{
		String loaiTK = jcbTimKiem.getSelectedItem().toString();
		if(loaiTK.equals("Tìm Theo Tên")) {
			
				DAO_KhachHang dskh = new DAO_KhachHang();
				List<KhachHang> list =dao_KhachHang.findname(txtTimKiem.getText());
				if(txtTimKiem.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khách hàng cần tìm !!!");
					
				}
				else if(list.size()==0)
				{
					JOptionPane.showMessageDialog(this, "Không tìm thấy : " +txtTimKiem.getText());
				}
				else
				{
					XoaHetDuLieuTrenTableModel();
					for(KhachHang kh :dao_KhachHang.findname(txtTimKiem.getText())) {
						model.addRow(new Object[] {
								kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getSDT(),kh.getDiaChi()
						});
					
						}
					table.setModel(model);
					}	
			
				}
			if(loaiTK.equals("Tìm Theo Mã")) {
				DAO_KhachHang dskh = new DAO_KhachHang();
				List<KhachHang> list =dskh.findid(txtTimKiem.getText());
				if(txtTimKiem.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khách hàng cần tìm !!!");
					
				}
				else if(list.size()==0)
				{
					JOptionPane.showMessageDialog(this, "Không tìm thấy mã khách hàng: " +txtTimKiem.getText());
					
				}
				else
				{
					XoaHetDuLieuTrenTableModel();
					for(KhachHang kh :list) {
						
						model.addRow(new Object[] {
								kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getSDT(),kh.getDiaChi()
						});
					
						}
					
					table.setModel(model);
						
					}
				
				}			
				
			if(loaiTK.equals("Tìm Theo SĐT")) {
				DAO_KhachHang dskh = new DAO_KhachHang();
				List<KhachHang> list =dskh.findsdt(txtTimKiem.getText());
				if(txtTimKiem.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "Vui lòng nhập SĐT khách hàng cần tìm !!!");
					
				}
				else if(list.size()==0)
				{
					JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng có SĐT: " +txtTimKiem.getText());
					
				}
				else
				{
					XoaHetDuLieuTrenTableModel();
					for(KhachHang kh :list) {
						
						model.addRow(new Object[] {
								kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getSDT(),kh.getDiaChi()
						});
					
						}
					
					table.setModel(model);
						
					}
			}
			if(loaiTK.equals("Tìm Theo Địa Chỉ")) {
				DAO_KhachHang dskh = new DAO_KhachHang();
				List<KhachHang> list =dskh.findDiaChi(txtTimKiem.getText());
				if(txtTimKiem.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ khách hàng cần tìm !!!");
					
				}
				else if(list.size()==0)
				{
					JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng ở : " +txtTimKiem.getText());
					
				}
				else
				{
					XoaHetDuLieuTrenTableModel();
					for(KhachHang kh :list) {
						
						model.addRow(new Object[] {
								kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getSDT(),kh.getDiaChi()
						});
					
						}
					
					table.setModel(model);
						
					}
			}
			
				
	}
	
	if(o.equals(btnXoaBang)) {
		XoaHetDuLieuTrenTableModel();
	}
	if(o.equals(btnHienThi)) {
		String loaiHT = jcbSapXep.getSelectedItem().toString();
		if(loaiHT.equals("Hiển Thị Theo Mã")) {
			XoaHetDuLieuTrenTableModel();
			DocDuLieuDatabaseVaoTable();
		}
		else if(loaiHT.equals("Hiển Thị Theo Tên")){
			XoaHetDuLieuTrenTableModel();
			DocDuLieuDatabaseVaoTableTheoTen();
	
		
		}
		else if(loaiHT.equals("Chỉ Khách Hàng Nội Thành")) {
			XoaHetDuLieuTrenTableModel();
			DocDuLieuDatabaseVaoTableTheoDiaChi();
		}
	
	}
	if(o.equals(btnLichSuMua)) {
		FormLichSuMuaHang info = new FormLichSuMuaHang();
		info.setLocationRelativeTo(null);
		info.setVisible(true);
	}
}


	public void DocDuLieuDatabaseVaoTable() {
		List<KhachHang> list = dao_KhachHang.getAllKhachHang();
		for (KhachHang cv : list) {
			model.addRow(new Object[] {
					cv.getMaKhachHang(),cv.getTenKhachHang(),cv.getSDT(),cv.getDiaChi()
			});}
	}
	public void DocDuLieuDatabaseVaoTableTheoTen() {
		List<KhachHang> list = dao_KhachHang.getAllKhachHangTheoTen();
		for (KhachHang cv : list) {
			model.addRow(new Object[] {
					cv.getMaKhachHang(),cv.getTenKhachHang(),cv.getSDT(),cv.getDiaChi()
			});}
	}
	public void DocDuLieuDatabaseVaoTableTheoDiaChi() {
		List<KhachHang> list = dao_KhachHang.getAllKhachHangTheoDiaChi("TP.HCM");
		for (KhachHang cv : list) {
			model.addRow(new Object[] {
					cv.getMaKhachHang(),cv.getTenKhachHang(),cv.getSDT(),cv.getDiaChi()
			});}
	}
	private boolean KiemTra() {
		String ma=txtMa.getText().trim();
		String sdt= txtsdt.getText();
		if(!(ma.matches("[K][H][0-9]+"))) {
			JOptionPane.showMessageDialog(this, "Nhập lại Theo Mẫu KH + Số Bất Kỳ VD:KH01237");
			return false;
		}
		if(!(sdt.length()==10)) {
			JOptionPane.showMessageDialog(this, "Số Điện thoại Phải là 10 số");
			return false;
		}
		if (sdt.length() > 0) {
			try {
				int x = Integer.parseInt(sdt);
				if (x <= 0) {
					JOptionPane.showMessageDialog(null, "Nhập Lại: Số Điện Thoại Phải là Số Nguyên Dương");
					return false;
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "nhập Lại: Số Điện Thoại Phải là Số");

				return false;
			}}
		if(!(txtdiachi.getText().trim().length()>10)) {
			JOptionPane.showMessageDialog(this, "địa chỉ phải từ 10 ký tự trở lên");
			return false;
		}
		return true;
	}
	private void XoaHetDuLieuTrenTableModel() {
	DefaultTableModel dm = (DefaultTableModel) table.getModel();
	dm.getDataVector().removeAllElements();
	dm.fireTableDataChanged();

	}

}

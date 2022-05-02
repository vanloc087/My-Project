package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.Database;
import dao.DAO_LinhKien;
import entity.LinhKien;
import entity.LoaiLinhKien;
import entity.NhaCungCap;

public class FormQuanLyLinhKien extends JFrame implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTextField txtMaLK,txtTen,txtMaLoaiLK,txtSoLuong,txtDonGia,txtMaNCC;
	private JButton btnThem,btnSua,btnXoa,btnXoaTrang,btnThoat;
	private JTable table;
	private String[] cols={"Mã linh kiện","Tên linh kiện", "Mã loại linh kiện","Số lượng", "Đơn giá", "Mã nhà cung cấp"};
	public FormQuanLyLinhKien() {
		setTitle("Quản Lý Linh Kiện");
		setResizable(true);
		setSize(900, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Database.getInstance().connect();
		
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		JPanel ptren = new JPanel();
		JLabel lblTitile = new JLabel("Quản Lý Linh Kiện");
		Font fTitle = new Font("tahoma", Font.BOLD,24);
		lblTitile.setFont(fTitle);
		ptren.add(lblTitile);
		add(ptren,BorderLayout.NORTH);
		
		Box b = Box.createVerticalBox();
		Box b1,b2,b3,b4,b5,b6;

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10)); 
		b2.add(new JLabel(" Mã linh kiện:         "));
		b2.add(txtMaLK= new JTextField(10));
		txtMaLK.setToolTipText("Theo mẫu LK + 4 số bất kì");

		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b1.add(new JLabel(" Tên linh kiện:        "));
		b1.add(txtTen= new JTextField(10));
		txtTen.setToolTipText("Không được rỗng");

		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b3.add(new JLabel(" Mã loại linh kiện:   "));
		b3.add(txtMaLoaiLK= new JTextField(10));
		txtMaLoaiLK.setToolTipText("Theo mẫu LLK + 4 số bất kì");

		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(new JLabel(" Đơn giá:                 "));
		b4.add(txtDonGia= new JTextField(10));
		add(b,BorderLayout.CENTER);
		txtDonGia.setToolTipText("Lớn hơn 0");
		
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b6.add(new JLabel(" Mã nhà cung cấp:  "));
		b6.add(txtMaNCC= new JTextField(10));
		add(b,BorderLayout.CENTER);
		txtMaNCC.setToolTipText("Theo mẫu NCC + 4 số bất kì");
		
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));
		b4.add(new JLabel("     Số lượng: "));
		b4.add(txtSoLuong= new JTextField(10));
		add(b,BorderLayout.CENTER);
		txtSoLuong.setToolTipText("Lớn hơn 0");
	
		JSplitPane spl=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		spl.setTopComponent(b);
		spl.setBottomComponent(new JScrollPane(table));
		add(spl);
		JPanel Pduoi = new JPanel();
		btnThem = new JButton("Thêm");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xóa");
		btnXoaTrang = new JButton("Xoá trắng");
		new JButton("Tìm kiếm");
		btnThoat = new JButton("Quay lại");
		Pduoi.add(btnThem);
		Pduoi.add(btnSua);
		Pduoi.add(btnXoa);
		Pduoi.add(btnXoaTrang);
		Pduoi.add(btnThoat);
		add(Pduoi,BorderLayout.SOUTH);
		DocDuLieuDatabaseVaoTable();
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnThoat.addActionListener(this);
		btnSua.addActionListener(this);
		table.addMouseListener(this);
		DAO_LinhKien.getAllLinhKien();
	}
	public static void main(String[] args) {
	}
	
	public void DocDuLieuDatabaseVaoTable() {
		ArrayList<LinhKien> list = DAO_LinhKien.getAllLinhKien();
		for (LinhKien cv : list) {
			model.addRow(new Object[] {
					cv.getMaLinhKien(),cv.getTenLinhKien(),cv.getMaLoaiLK().getMaLoaiLK(),
					cv.getDonGia(),cv.getSoLuong(),cv.getMaNCC().getMaNCC()});}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			GiaoDienChinh info=new GiaoDienChinh();
			info.setVisible(true);
			//	info.pHD8ack();
			info.setLocationRelativeTo(null);
			info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dispose();
		}
		if(o.equals(btnXoaTrang)) {
			txtMaLK.setText("");
			txtTen.setText("");
			txtMaLoaiLK.setText("");
			txtSoLuong.setText("");
			txtDonGia.setText("");
			txtMaNCC.setText("");
		}
		
		if(o.equals(btnXoa)) {
			if( txtMaLK.getText().equals(""))
					JOptionPane.showMessageDialog(this, "Không được rỗng");
			else {
					try {
						DAO_LinhKien.delete(txtMaLK.getText());
						JOptionPane.showMessageDialog(this, "Xóa thành công");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		if (o.equals(btnThem)) {
			if(txtMaLK.getText().equals("")|| txtTen.getText().equals("")||
					txtMaLoaiLK.getText().equals("")||txtSoLuong.getText().equals("")
					||txtDonGia.getText().equals("")||txtMaNCC.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Không được rỗng");
			else {
				if(KiemTra()) {
					NhaCungCap ncc= new NhaCungCap(txtMaNCC.getText());
					LoaiLinhKien llk = new LoaiLinhKien(txtMaLoaiLK.getText());
					LinhKien lk= new LinhKien(txtMaLK.getText(), txtTen.getText(),llk,Integer.parseInt(txtSoLuong.getText())
							,Double.parseDouble(txtDonGia.getText()),ncc);
					if(!(DAO_LinhKien.create(lk))) {
						JOptionPane.showMessageDialog(this, "Trùng mã");
					}
					else 
					{
						DAO_LinhKien.create(lk);
						model.addRow(new Object[] {
								lk.getMaLinhKien(),lk.getTenLinhKien(),lk.getMaLoaiLK().getMaLoaiLK(),lk.getSoLuong()
								,lk.getDonGia(),lk.getMaNCC().getMaNCC()
						});
						DocDuLieuDatabaseVaoTable();
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					}
					}
				}
			}
		if(o.equals(btnSua)) {
				if(txtMaLK.getText().equals("")|| txtTen.getText().equals("")||
						txtMaLoaiLK.getText().equals("")||txtSoLuong.getText().equals("")
						||txtDonGia.getText().equals("")||txtMaNCC.getText().equals(""))
					JOptionPane.showMessageDialog(this, "Không được rỗng");
				else {
					if(KiemTra()) {
						NhaCungCap ncc= new NhaCungCap(txtMaNCC.getText());
						LoaiLinhKien llk = new LoaiLinhKien(txtMaLoaiLK.getText());
						DocDuLieuDatabaseVaoTable();
						LinhKien lk= new LinhKien(txtMaLK.getText(), txtTen.getText(),llk,Integer.parseInt(txtSoLuong.getText())
								,Double.parseDouble(txtDonGia.getText()),ncc);
							DAO_LinhKien.create(lk);
							model.addRow(new Object[] {
									lk.getMaLinhKien(),lk.getTenLinhKien(),lk.getMaLoaiLK().getMaLoaiLK(),lk.getSoLuong()
									,lk.getDonGia(),lk.getMaNCC().getMaNCC()
							});
							DocDuLieuDatabaseVaoTable();
							JOptionPane.showMessageDialog(this, "Sửa thành công");
						}
						}
					}
				}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaLK.setText(model.getValueAt(row, 0).toString());
		txtTen.setText(model.getValueAt(row, 1).toString());
		txtMaLoaiLK.setText(model.getValueAt(row, 2).toString());
		txtSoLuong.setText(model.getValueAt(row, 3).toString());
		txtDonGia.setText(model.getValueAt(row, 4).toString());
		txtMaNCC.setText(model.getValueAt(row, 5).toString());
	}
	private boolean KiemTra() {
		String malk=txtMaLK.getText().trim();
		String maloailk= txtMaLoaiLK.getText().trim();
		String maNCC = txtMaNCC.getText().trim();
		
//		if(!(malk.matches("^[L][K][0-9]{4}"))) {
//			JOptionPane.showMessageDialog(this, " MÃ£ Linh Kiá»‡n nháº­p láº¡i theo máº«u 4 chá»¯ cÃ¡i in hoa + sá»‘ báº¥t kÃ¬ VD: QU1237");
//			return false;
//		}
//		if(!(maloailk.matches("^[L][L][K][0-9]{4}"))) {
//			JOptionPane.showMessageDialog(this, "MÃ£ Loáº¡i Linh Kiá»‡n nháº­p láº¡i theo máº«u 4 chá»¯ cÃ¡i in hoa VD: BP");
//			return false;
//		}
//		if(!(maNCC.matches("^[N][C][C][0-9]{4}"))) {
//			JOptionPane.showMessageDialog(this, " MÃ£ NhÃ  Cung Cáº¥p nháº­p láº¡i theo máº«u 4 chá»¯ cÃ¡i in hoa + sá»‘ báº¥t kÃ¬ VD: QUR1237");
//			return false;
//		}
		return true;
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

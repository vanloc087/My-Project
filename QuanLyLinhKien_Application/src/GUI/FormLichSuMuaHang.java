package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import connectDB.Database;
import dao.DAO_HoaDon;
import entity.HoaDon;



public class FormLichSuMuaHang extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DAO_HoaDon dao_HoaDon;
	private DefaultTableModel model;
	private JScrollPane scrl;
	private String[] cols={"Mã Hóa Đơn","Mã Khách Hang","Mã Nhân Viên", "Ngày Tạo" ,"Nơi Nhận","Tông Tiền"};
	private ArrayList<HoaDon> list;
	public FormLichSuMuaHang() {
		// TODO Auto-generated constructor stub
		setTitle("Quản Lý Khách Hàng");
		setResizable(false);
		setSize(900, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Database.getInstance().connect();
		model = new DefaultTableModel(cols, 0);
		table = new JTable(model);
		scrl= new JScrollPane(table);
		scrl.setPreferredSize(new Dimension(400, 400));
		
		JPanel p = new JPanel(new BorderLayout());
		JLabel lblTitile = new JLabel("Lịch Sử Mua Hàng");
		Font fTitle = new Font("tahoma", Font.BOLD,24);
		lblTitile.setFont(fTitle);
		p.add(lblTitile,BorderLayout.NORTH);
		
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
//		columnModel.getColumn(0).setPreferredWidth(50);
//		columnModel.getColumn(1).setPreferredWidth(100);
//		columnModel.getColumn(2).setPreferredWidth(50);
//		columnModel.getColumn(3).setPreferredWidth(60);
//		columnModel.getColumn(4).setPreferredWidth(60);
//		columnModel.getColumn(6).setPreferredWidth(90);

		p.add(scrl,BorderLayout.CENTER);
		
		this.add(p);
		DocDuLieuDatabaseVaoTable();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FormLichSuMuaHang().setVisible(true);
		
	}
	public void DocDuLieuDatabaseVaoTable() {
		List<HoaDon> list = dao_HoaDon.getAllHoaDon();
		for (HoaDon cv : list) {
			model.addRow(new Object[] {
					cv.getMaHoaDon(),cv.getMaKhachHang().getMaKhachHang(),cv.getMaNhanVien().getMaNV(),cv.getNgayTao(),cv.getNoiNhan(),cv.getTongtien()
			});}
	}
}


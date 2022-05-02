package gui;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;



public class GUI_TabpanelQuanLyLuong extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabPane;
	private GUI_QuanLyLuongCongNhan qllcn;
	private GUI_QuanLyLuongNhanVien qllnv;
	private GUI_QuanLyLuongCongTy  qllct;
	public GUI_TabpanelQuanLyLuong() {
		
		setTitle("Quản Lý Lương");
		setSize(1360,680);
		setLocationRelativeTo(null);
		setResizable(false);
		
		ImageIcon nv = new ImageIcon("icon/nv.png");
		

		tabPane = new JTabbedPane();
		
		qllcn = new GUI_QuanLyLuongCongNhan();
		qllnv = new GUI_QuanLyLuongNhanVien();
		qllct = new GUI_QuanLyLuongCongTy();

		tabPane.addTab("Quản Lý Lương Nhân Viên", nv,qllnv.getContentPane(),"Quản Lý Lương Nhân Viên");
		tabPane.addTab("Quản Lý Lương Công Nhân", nv,qllcn.getContentPane(),"Quản Lý Lương Công Nhân");
		tabPane.addTab("Quản Lý Lương Công Ty", nv,qllct.getContentPane(),"Quản Lý Lương Công Ty");
		
		add(tabPane);
	}
	public static void main(String[] args) {
		new GUI_TabpanelQuanLyLuong().setVisible(true);
	}
		
}
	


package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import connectDB.ConnectDB;
import dao.DAO_Sach;
import dao.DAO_LoaiDCHT;
import dao.DAO_LoaiSach;
import entity.LoaiDungCuHocTap;
import entity.LoaiSach;
import entity.Sach;

public class SachTrongQLSP  extends JPanel implements ActionListener, MouseListener{
	private DAO_LoaiSach daoLoaiSach;
	private ArrayList<LoaiSach> listLoaiSach;
	private DAO_Sach sachDao;
	private ArrayList<Sach> listSach;
	private static Sach sachStatic;
	
	private JPanel pnTT, pnHinhAnh;
	public  JLabel lblHinhAnh;
	private JLabel lblThongBao , lblTinhTrang;
	private JButton btnSua, btnNgungKinhDoanh;
	String path;
	public  static String chuoiTinhTrang;
	public static boolean tinhTrang;
	public  static int soluongton;
	public SachTrongQLSP(Sach s) {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sachStatic = s;
		daoLoaiSach = new DAO_LoaiSach();
		sachDao = new DAO_Sach();
		//Border borderSP = BorderFactory.createLineBorder(Color.GRAY);
		//setBackground(new Color(230, 230, 230));
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(620,185));

		//setBorder(borderSP);

		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		pnRight.setBackground(new Color(230, 230, 230));

		JPanel pnSLT = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pnSLT.setBackground(new Color(230, 230, 230));
		JLabel lblSoLuongTon = new JLabel("S??? l?????ng t???n: " + s.getSoLuong());
		lblSoLuongTon.setFont(new Font("Arial", Font.BOLD, 14));
		soluongton = s.getSoLuong();
		lblSoLuongTon.setForeground(Color.BLACK);
		pnSLT.add(lblSoLuongTon);

		DecimalFormat formatter = new DecimalFormat("###,###,###");

		JPanel pnGiaBan = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pnGiaBan.setBackground(new Color(230, 230, 230));
		JLabel lblGiaBan = new JLabel("Gi?? b??n: " + String.valueOf(formatter.format(s.getGiaBan())+" VN??"));
		lblGiaBan.setFont(new Font("Arial", Font.BOLD, 14));
		lblGiaBan.setForeground(Color.BLACK);
		pnGiaBan.add(lblGiaBan);


		JPanel pnSuaXoa = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pnSuaXoa.setBackground(new Color(230, 230, 230));
		JLabel lblSua = new JLabel("S???a");
		Font font = new Font("Arial",Font.BOLD , 14);
		lblSua.setFont(font);
		btnSua = new JButton("");
		btnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSua.setBackground(new Color(255, 133, 51));
		lblSua.setForeground(Color.WHITE);
		btnSua.add(lblSua);
		JLabel lblNgungKinhDoanh = new JLabel("Ng???ng kinh doanh");
		btnNgungKinhDoanh = new JButton("");
		btnNgungKinhDoanh.setBackground(new Color(255, 133, 51));
		btnNgungKinhDoanh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNgungKinhDoanh.setForeground(Color.WHITE);
		lblNgungKinhDoanh.setFont(font);
		btnNgungKinhDoanh.add(lblNgungKinhDoanh);
		pnSuaXoa.add(btnSua);
		pnSuaXoa.add(btnNgungKinhDoanh);

		JPanel pnTinhTrang = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pnTinhTrang.setBackground(new Color(230, 230, 230));
		chuoiTinhTrang = null;
		lblTinhTrang = new JLabel();
		if(s.getTinhTrang()) {
			if(s.getSoLuong() == 0) {
				chuoiTinhTrang = "H???t h??ng";
				lblTinhTrang = new JLabel("T??nh tr???ng: " + chuoiTinhTrang);
				lblTinhTrang.setFont(new Font("Arial", Font.BOLD, 14));
				lblTinhTrang.setForeground(Color.RED);
			}
			else {
				chuoiTinhTrang = "C??n h??ng";
				lblTinhTrang = new JLabel("T??nh tr???ng: " + chuoiTinhTrang);
				lblTinhTrang.setFont(new Font("Arial", Font.BOLD, 14));
			}
		}
		else {
			//if(s.getSoLuong() == 0) {
			chuoiTinhTrang = "Ng???ng kinh doanh";
			lblTinhTrang.setText("T??nh tr???ng: " + chuoiTinhTrang);
			lblTinhTrang.setFont(new Font("Arial", Font.BOLD, 14));
			lblTinhTrang.setForeground(Color.RED);
			btnSua.setEnabled(false);
			btnNgungKinhDoanh.setEnabled(false);
			btnSua.setBackground(new Color(255, 179, 128));
			btnNgungKinhDoanh.setBackground(new Color(255, 179, 128));
		}
		pnTinhTrang.add(lblTinhTrang);



		pnRight.add(pnSLT);
		pnRight.add(pnGiaBan);
		pnRight.add(pnTinhTrang);
		pnRight.add(pnSuaXoa);

		pnTT = new JPanel();
		pnTT.setLayout(new BoxLayout(pnTT, BoxLayout.Y_AXIS));
		pnTT.setBackground(new Color(230, 230, 230));

		JPanel pnTenSach = new JPanel();
		JLabel lblTenSach = new JLabel("T??n S??ch: " + s.getTenSanPham());
		lblTenSach.setFont(new Font("Arial", Font.BOLD, 16));
		lblTenSach.setForeground(Color.BLACK);
		pnTenSach.setBackground(new Color(230, 230, 230));
		pnTenSach.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnTenSach.add(lblTenSach);
		pnTT.add(pnTenSach);

		JPanel pnTacGia = new JPanel();
		pnTacGia.setBackground(new Color(230, 230, 230));
		JLabel lblTacGia = new JLabel("T??c gi???: " + s.getTacGia());
		lblTacGia.setFont(new Font("Arial", Font.BOLD, 14));
		lblTacGia.setForeground(Color.BLACK);
		pnTacGia.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnTacGia.add(lblTacGia);
		pnTT.add(pnTacGia);


		JPanel pnNhaXuatBan = new JPanel();
		pnNhaXuatBan.setBackground(new Color(230, 230, 230));
		JLabel lblNhaXuatBan = new JLabel("Nh?? xu???t b???n: "+ s.getNhaXuatBan());
		lblNhaXuatBan.setFont(new Font("Arial", Font.BOLD, 14));
		lblNhaXuatBan.setForeground(Color.BLACK);
		pnNhaXuatBan.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnNhaXuatBan.add(lblNhaXuatBan);
		pnTT.add(pnNhaXuatBan);

		String tenLoaiSach = null;
		listLoaiSach = daoLoaiSach.getAllLoaiSach();
		for(LoaiSach loaiSach : listLoaiSach) {
			if(s.getLoaiSach().getMaLoaiSach().equals(loaiSach.getMaLoaiSach())) {
				tenLoaiSach = loaiSach.getTenLoaiSach();
			}
		}
		JLabel lblLoaiSach = new JLabel("Th??? lo???i: " + tenLoaiSach);
		lblLoaiSach.setFont(new Font("Arial", Font.BOLD, 14));
		lblLoaiSach.setForeground(Color.BLACK);
		JPanel pnLoaiSach = new JPanel();
		pnLoaiSach.setBackground(new Color(230, 230, 230));
		pnLoaiSach.setLayout(new FlowLayout(FlowLayout.LEFT));
		pnLoaiSach.add(lblLoaiSach);
		pnTT.add(pnLoaiSach);


		lblHinhAnh = new JLabel("");

		JPanel pnLeft = new JPanel(new BorderLayout());
		pnLeft.setBackground(new Color(230, 230, 230));
		//String path = t.getHinhAnh();
		pnHinhAnh = new JPanel();
		//pnHinhAnh.setPreferredSize(new Dimension(170,170));
		pnHinhAnh.setBackground(new Color(230, 230, 230));
		path = s.getHinhAnh().trim();
		
		if(s.getHinhAnh().trim().equals("Ch??a c?? h??nh ???nh")) {
			JPanel pnKhungHinhAnh = new JPanel();
			pnKhungHinhAnh.setPreferredSize(new Dimension(170,170));
			pnKhungHinhAnh.setLayout(new BoxLayout(pnKhungHinhAnh, BoxLayout.X_AXIS));
			pnKhungHinhAnh.add(Box.createHorizontalStrut(40));
			lblHinhAnh.setText("Ch??a c?? h??nh ???nh");
			pnKhungHinhAnh.add(lblHinhAnh);
			pnHinhAnh.add(pnKhungHinhAnh);
		}
		else {
			lblHinhAnh.setPreferredSize(new Dimension(170,170));
			lblHinhAnh.setIcon(ResizeImage(path));
			pnHinhAnh.add(lblHinhAnh);
		}
		lblHinhAnh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnHinhAnh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		pnLeft.add(pnHinhAnh, BorderLayout.CENTER);
		pnLeft.add(pnTT, BorderLayout.EAST);

		Border borderSP = BorderFactory.createLineBorder(Color.GRAY);
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

		pnMain.setBackground(new Color(230, 230, 230));
		pnMain.add(pnLeft, BorderLayout.WEST);
		pnMain.add(pnRight, BorderLayout.EAST);
		pnMain.setBorder(borderSP);
		pnLeft.setBorder(new EmptyBorder(6, 10, 6, 10));
		pnRight.setBorder(new EmptyBorder(6, 10, 6, 10));

		//		add(pnLeft, BorderLayout.WEST);
		//		add(pnRight, BorderLayout.EAST);
		add(pnMain);

		btnSua.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FormSuaSach(s);
			}
		});
		lblHinhAnh.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				new FormChiTietSach(s);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				if(s.getHinhAnh().trim().equals("Ch??a c?? h??nh ???nh")) {
					lblHinhAnh.setText("Ch??a c?? h??nh ???nh");
				}
				else {
					lblHinhAnh.setIcon(ResizeImage(path));
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				if(s.getHinhAnh().trim().equals("Ch??a c?? h??nh ???nh")) {
					lblHinhAnh.setText("Ch??a c?? h??nh ???nh");
				}
				else {
					lblHinhAnh.setIcon(ResizeImageHover(path));
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		pnHinhAnh.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				new FormChiTietSach(s);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnNgungKinhDoanh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(s.getTinhTrang()) {
					int hoi=JOptionPane.showConfirmDialog(null, "Quy???n s??ch n??y s??? ng???ng kinh doanh","Ch?? ??",JOptionPane.YES_NO_OPTION);
					if(hoi==JOptionPane.YES_OPTION) { 
						lblTinhTrang.setText("T??nh tr???ng: " + "Ng???ng kinh doanh");
						sachDao.suaTinhTrangSach(false, s.getMaSanPham());
						lblTinhTrang.setFont(new Font("Arial", Font.BOLD, 14));
						lblTinhTrang.setForeground(Color.RED);
						btnSua.setEnabled(false);
						btnNgungKinhDoanh.setEnabled(false);
						btnSua.setBackground(new Color(255, 179, 128));
						btnNgungKinhDoanh.setBackground(new Color(255, 179, 128));
					}
				}
//				else {
//					JOptionPane.showMessageDialog(
//							null, 
//							"M???t h??ng n??y v???n c??n h??ng", 
//							"Th??ng b??o", 
//							JOptionPane.INFORMATION_MESSAGE);
//				}
			}
		});
	}
	public ImageIcon ResizeImage(String ImagePath)
	{
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(160, 160, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
	public ImageIcon ResizeImageHover(String ImagePath)
	{
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}
	@Override
	public void actionPerformed(ActionEvent e) {

	}
	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

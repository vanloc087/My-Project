package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
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
import dao.DAO_NhanVien;
import entity.NhanVien;

public class formNV extends JFrame implements ActionListener,MouseListener{
	
	private String[] cols={"Mã Nhân Viên","Tên Nhân Viên", "Số điện thoại","Địa chỉ" };
	private DefaultTableModel model;
	private JTable table;
	private JTextField txtMa;
	private JTextField txtten;
	private JTextField txtdiachi;
	private JTextField txtsdt;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXoatrang;
	private JButton btnTimkiem;
	private JButton btnThoat;
	private JTextField txtTim;
	private DAO_NhanVien dao_NhanVien;
	private ArrayList<NhanVien> list;
	private Object jbexit;
	private Object nv;
	public formNV(){
		// TODO Auto-generated constructor stub
				setTitle("Quản Lý Nhân Viên");
				setResizable(true);
				setSize(800,700);
				setLocationRelativeTo(null);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				Database.getInstance().connect();
				dao_NhanVien=  new DAO_NhanVien();
				model = new DefaultTableModel(cols, 0);
				table = new JTable(model);
				JPanel pN,pS,pC;
				pN = new JPanel();
				pC = new JPanel();
				pS = new JPanel();
				JLabel lblTD;
				pN.add(lblTD = new JLabel("Quản Lý Nhân Viên"));
				lblTD.setFont(new Font("Times", Font.BOLD, 20));
				
				Box b = Box.createVerticalBox();
				JPanel p1,p2,p3,p4,p5,p6;
				p1 = new JPanel();
				p2 = new JPanel();
				p3 = new JPanel();
				p4 = new JPanel();
				p5 = new JPanel();
				p6 = new JPanel();
				
				
				JLabel lblMa, imageMa;
				ImageIcon i=new ImageIcon("..\\image\\ma.png");
				imageMa = new JLabel(i);
				p1.add(imageMa); 
				p1.add(lblMa =new JLabel("Mã Nhân Viên:"));
				p1.add(txtMa= new JTextField(50));
				txtMa.setToolTipText("Mã Nhân Viên phải theo mẫu: NV + 4 Số Bất Kỳ. VD:NV0123 ");
				
				JLabel lblTen, imageTen;
				p2.add(imageTen = new JLabel(new ImageIcon("..\\image\\ten.png")));
				p2.add(lblTen =  new JLabel(" Tên Nhân Viên:"));
				p2.add(txtten= new JTextField(50));
				txtten.setToolTipText("Tên Nhân Viên không được để trống.");
				
				JLabel lblSDT, imageSDT;
				p3.add(imageSDT = new JLabel(new ImageIcon("..\\image\\sdt.png")));
				p3.add(lblSDT = new JLabel(" Số Điện Thoại:"));
				p3.add(txtsdt= new JTextField(50));
				txtsdt.setToolTipText("Số Điện thoại bắt đầu bằng 09/03/07 + 8 số");
				
				JLabel lblDC, imageDC;
				p4.add(imageDC = new JLabel(new ImageIcon("..\\image\\diaChi.png")));
				p4.add(lblDC= new JLabel(" Địa chỉ"));
				p4.add(txtdiachi= new JTextField(50));
				txtdiachi.setToolTipText("Địa chỉ phải từ 11 ký tự trở lên");
				
				
				
				lblTen.setFont(new Font("Times New Roman",Font.PLAIN , 18));
				lblMa.setFont(new Font("Times New Roman",Font.PLAIN , 18));
				lblSDT.setFont(new Font("Times New Roman",Font.PLAIN , 18));
				lblDC.setFont(new Font("Times New Roman",Font.PLAIN , 18));
				
				lblMa.setPreferredSize(lblTen.getPreferredSize());
				lblSDT.setPreferredSize(lblTen.getPreferredSize());
				lblDC.setPreferredSize(lblTen.getPreferredSize());
				
				btnThem = new JButton("Thêm", new ImageIcon("..\\image\\timKiem.png"));
				btnSua = new JButton("Sửa", new ImageIcon("..\\image\\sua.png"));
				btnXoa = new JButton("Xoá", new ImageIcon("..\\image\\xoa.png"));
				btnXoatrang = new JButton("Xoá Trắng");
//				btnTimkiem= new JButton("TÃ¬m Kiáº¿m", new ImageIcon("D:\\huongSKNhat\\image\\timKiem.png"));
				btnThoat = new JButton("Trở Lại", new ImageIcon("..\\image\\troLai.png"));
				DocDuLieuDatabaseVaoTable();
				p5.add(btnThem);
				p5.add(btnSua);
				p5.add(btnXoa);
				p5.add(btnXoatrang);
				p5.add(btnThoat);
			
				b.add(pN);
				b.add(p1);
				b.add(p2);
				b.add(p3);
				b.add(p4);
				b.add(p5);
				b.add(p6);
				pC.add(b);
			
				add(pC,BorderLayout.NORTH);
				add(new JScrollPane(table),BorderLayout.CENTER);
				Box  b1 = Box.createHorizontalBox();
				JLabel lblTim, imageTim;				
				pS.add(lblTim = new JLabel("Tim kiem:"));
				lblTim.setFont(new Font("Times New Roman",Font.PLAIN , 20));
				pS.add(txtTim =  new JTextField(20));
				pS.add(imageMa = new JLabel(new ImageIcon("..\\image\\timKiem.png"))); 
				add(pS,BorderLayout.SOUTH);
				
				
				
				
					
		
				btnThem.addActionListener(this);
				btnXoa.addActionListener(this);
				btnXoatrang.addActionListener(this);
				btnThoat.addActionListener(this);
				btnSua.addActionListener(this);
				
				DAO_NhanVien dnv = new DAO_NhanVien();
				list = dnv.getAllNhanVien();
	}

	private boolean KiemTra() {
		// TODO Auto-generated method stub
		String ma=txtMa.getText().trim();
		String sdt= txtsdt.getText();
		if(!(ma.matches("^[N][V]\\d{4}$"))) {
			JOptionPane.showMessageDialog(this, "Nhập lại Theo Mẫu: NV + 4 Số Bất Kỳ VD:NV0123");
			return false;
		}
		if(!(sdt.matches("^0[937]{1}\\d{8}$"))) {
			JOptionPane.showMessageDialog(this, "Số Điện thoại bắt đầu bằng 09/03/07 + 8 số");
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
				JOptionPane.showMessageDialog(null, "Nhập Lại: Số Điện Thoại Phải Là Số");

				return false;
			}}
		if(!(txtdiachi.getText().trim().length()>10)) {
			JOptionPane.showMessageDialog(this, "Địa chỉ phải từ 11 ký tự trở lên");
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new  formNV().setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if(txtMa.getText().equals("")|| txtten.getText().equals("")||txtsdt.getText().equals("")||txtdiachi.getText().equals(""))

				JOptionPane.showMessageDialog(this, "Không được để trống");
			else {
				if(KiemTra()) {
					NhanVien nv= new NhanVien(txtMa.getText(), txtten.getText(), txtsdt.getText(), txtdiachi.getText());
					if(!(dao_NhanVien.create(nv))) {
						JOptionPane.showMessageDialog(this, "Trùng Mã");
					}else {
//						dao_NhanVien.create(nv);
//						model.addRow(new Object[] {
//								nv.getMaNV(),nv.getTenNV(),nv.getSDT(),nv.getDiaChi()
//						});
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
					try {
							dao_NhanVien.xoa(txtMa.getText());
//							model.addRow(new Object[] {
//									kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getSDT(),kh.getDiaChi()
//							});
							JOptionPane.showMessageDialog(this, "Xóa Thành Công");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		if(o.equals(btnSua)) {
			if(txtten.getText().equals("")|| txtMa.getText().equals("")||txtsdt.getText().equals("")||txtdiachi.getText().equals(""))

				JOptionPane.showMessageDialog(this, "Không được để trống");
			else {
				if(KiemTra()) {
					NhanVien nv= new NhanVien(txtMa.getText(), txtten.getText(), txtsdt.getText(), txtdiachi.getText());
					try {
							dao_NhanVien.update(nv);
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
	}
	private void DocDuLieuDatabaseVaoTable() {
		// TODO Auto-generated method stub
		List<NhanVien> list = dao_NhanVien.getAllNhanVien();
		for (NhanVien nv : list) {
			model.addRow(new Object[] {
					nv.getMaNV(),nv.getTenNV(),nv.getSDT(),nv.getDiaChi()
			});}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMa.setText(model.getValueAt(row, 0).toString());
		txtten.setText(model.getValueAt(row, 1).toString());
		txtsdt.setText(model.getValueAt(row, 1).toString());
		txtdiachi.setText(model.getValueAt(row, 1).toString());
		
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

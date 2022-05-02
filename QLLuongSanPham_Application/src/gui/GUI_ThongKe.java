package gui;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;



import connectDB.ConnectDB;
import dao.DAO_CongNhan;
import dao.DAO_HopDong;
import dao.DAO_NhanVienHanhChinh;
import dao.DAO_PhieuLuongCongNhan;
import dao.DAO_PhieuLuongNhanVien;
import entity.ChiTietHopDong;
import entity.CongNhan;
import entity.NhanVienHanhChinh;
import entity.PhieuLuongCongNhan;
import entity.PhieuLuongNhanVien;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUI_ThongKe extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelThongKe;
	private DAO_HopDong hopDong_DAO;
	private DAO_NhanVienHanhChinh nhanVienHanhChinh_DAO;
	private DAO_CongNhan congNhan_DAO;
	private DAO_PhieuLuongNhanVien phieuLuongNhanVien_DAO;
	private DAO_PhieuLuongCongNhan phieuLuongCongNhan_DAO;
	private JButton btnBarChartHD;
	private JFrame jframeBarChatGTHD;
	private JFrame jframePieChartTTTTHD;
	private JButton btnPieChart;
	private JFrame jframeBarChartDoTuoiNV;
	private JButton btnTuoiNV;
	private JFrame jframeBarChartDoTuoiCongNhan;
	private JButton btnTuoiCN;
	private JButton btnNV_CN;
	private JButton btnGioiTinhCN;
	private JButton btnGioiTinhNV;
	private JFrame jframePieChartNhanSu;
	private JFrame jframePieChartGioiTinhCN;
	private JFrame jframePieChartGioiTinhNV;
	private JComboBox<String> comboBoxNV;
	private JButton btnLuongCN;
	private JButton btnLuongNV;
	private JComboBox<String> comboBoxCN;
	private JComboBox<String> comboBoxLuong;
	private JButton btnLuong;



	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_ThongKe frame = new GUI_ThongKe();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */

	@SuppressWarnings("deprecation")
	public GUI_ThongKe() {
		setBackground(new Color(255, 215, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 680);
		setResizable(false);
		setLocationRelativeTo(null);
		panelThongKe = new JPanel();
		panelThongKe.setBackground(new Color(255, 99, 71));
		panelThongKe.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelThongKe);
		panelThongKe.setLayout(null);
		
		JPanel panelThongKeNhanSu = new JPanel();
		panelThongKeNhanSu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelThongKeNhanSu.setBackground(Color.WHITE);
		panelThongKeNhanSu.setBounds(10, 330, 1340, 310);
		panelThongKe.add(panelThongKeNhanSu);
		panelThongKeNhanSu.setLayout(null);
		
		JLabel lblThngK = new JLabel("Thống kê nhân sự");
		lblThngK.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblThngK.setBounds(10, 11, 221, 48);
		panelThongKeNhanSu.add(lblThngK);
		
		btnTuoiNV = new JButton("New button");
		btnTuoiNV.setBackground(Color.WHITE);
		btnTuoiNV.setBounds(1085, 70, 245, 180);
		btnTuoiNV.setIcon(new ImageIcon("data\\\\img\\\\tuoiNV.png"));
		panelThongKeNhanSu.add(btnTuoiNV);
		
		btnTuoiCN = new JButton("New button");
		btnTuoiCN.setBackground(Color.WHITE);
		btnTuoiCN.setBounds(815, 70, 245, 180);
		btnTuoiCN.setIcon(new ImageIcon("data\\\\img\\\\tuoiCN.png"));
		panelThongKeNhanSu.add(btnTuoiCN);
		
		btnNV_CN = new JButton("");
		btnNV_CN.setBackground(Color.WHITE);
		btnNV_CN.setBounds(10, 70, 245, 180);
		btnNV_CN.setIcon(new ImageIcon("data\\\\img\\\\CN_NV.png"));
		panelThongKeNhanSu.add(btnNV_CN);
		
		btnGioiTinhCN = new JButton("New button");
		btnGioiTinhCN.setBackground(Color.WHITE);
		btnGioiTinhCN.setBounds(278, 70, 245, 180);
		btnGioiTinhCN.setIcon(new ImageIcon("data\\\\img\\\\CN.png"));
		panelThongKeNhanSu.add(btnGioiTinhCN);
		
		btnGioiTinhNV = new JButton("New button");
		btnGioiTinhNV.setBackground(Color.WHITE);
		btnGioiTinhNV.setBounds(547, 70, 245, 180);
		btnGioiTinhNV.setIcon(new ImageIcon("data\\\\img\\\\NV.png"));
		panelThongKeNhanSu.add(btnGioiTinhNV);
		
		JLabel lblNewLabel_2 = new JLabel("GIỚI TÍNH CỦA CÔNG NHÂN");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(278, 261, 245, 25);
		panelThongKeNhanSu.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("CÔNG NHÂN - NHÂN VIÊN");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(10, 261, 245, 25);
		panelThongKeNhanSu.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("GIỚI TÍNH CỦA NHÂN VIÊN");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(547, 261, 245, 25);
		panelThongKeNhanSu.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("TUỔI CỦA CÔNG NHÂN");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_3.setBounds(815, 261, 245, 25);
		panelThongKeNhanSu.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("TUỔI CỦA NHÂN VIÊN");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2_4.setBounds(1085, 261, 245, 25);
		panelThongKeNhanSu.add(lblNewLabel_2_4);
		
		JPanel panelThongKeLuong = new JPanel();
		panelThongKeLuong.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelThongKeLuong.setBackground(Color.WHITE);
		panelThongKeLuong.setBounds(10, 11, 665, 308);
		panelThongKe.add(panelThongKeLuong);
		panelThongKeLuong.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thống kê lương năm "+(new Date().getYear()+1900));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(10, 11, 316, 48);
		panelThongKeLuong.add(lblNewLabel);
		
		comboBoxNV = new JComboBox<String>();
		comboBoxNV.setBackground(new Color(175, 238, 238));
		comboBoxNV.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		comboBoxNV.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxNV.setBounds(122, 254, 43, 27);
		panelThongKeLuong.add(comboBoxNV);
		
		JLabel lblNewLabel_4 = new JLabel("Chọn tháng:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(33, 252, 87, 31);
		panelThongKeLuong.add(lblNewLabel_4);
		
		btnLuongNV = new JButton("New button");
		btnLuongNV.setBackground(Color.WHITE);
		btnLuongNV.setBounds(10, 84, 190, 167);
		btnLuongNV.setIcon(new ImageIcon("data\\\\img\\\\luongnv.png"));
		panelThongKeLuong.add(btnLuongNV);
		
		btnLuongCN = new JButton("New button");
		btnLuongCN.setBackground(Color.WHITE);
		btnLuongCN.setBounds(465, 84, 190, 167);
		btnLuongCN.setIcon(new ImageIcon("data\\\\img\\\\luongcn.png"));
		panelThongKeLuong.add(btnLuongCN);
		
		comboBoxCN = new JComboBox<String>();
		comboBoxCN.setBackground(new Color(173, 216, 230));
		comboBoxCN.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		comboBoxCN.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxCN.setBounds(580, 254, 43, 27);
		panelThongKeLuong.add(comboBoxCN);
		
		JLabel lblNewLabel_4_1 = new JLabel("Chọn tháng:");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(492, 252, 87, 31);
		panelThongKeLuong.add(lblNewLabel_4_1);
		
		btnLuong = new JButton("New button");
		btnLuong.setBackground(Color.WHITE);
		btnLuong.setBounds(237, 84, 190, 167);
		btnLuong.setIcon(new ImageIcon("data\\\\img\\\\luong.png"));
		panelThongKeLuong.add(btnLuong);
		
		comboBoxLuong = new JComboBox<String>();
		comboBoxLuong.setBackground(new Color(173, 216, 230));
		comboBoxLuong.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		comboBoxLuong.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxLuong.setBounds(355, 254, 43, 27);
		panelThongKeLuong.add(comboBoxLuong);
		
		JLabel lblNewLabel_4_2 = new JLabel("Chọn tháng:");
		lblNewLabel_4_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4_2.setBounds(266, 252, 87, 31);
		panelThongKeLuong.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("NHÂN VIÊN");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 61, 190, 27);
		panelThongKeLuong.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("NHÂN VIÊN - CÔNG NHÂN");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(237, 62, 190, 27);
		panelThongKeLuong.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("CÔNG NHÂN");
		lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1_2.setBounds(465, 61, 190, 27);
		panelThongKeLuong.add(lblNewLabel_2_1_1_2);
		
		JPanel panelThongKeHopDong = new JPanel();
		panelThongKeHopDong.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelThongKeHopDong.setBackground(Color.WHITE);
		panelThongKeHopDong.setBounds(685, 50, 665, 269);
		panelThongKe.add(panelThongKeHopDong);
		panelThongKeHopDong.setLayout(null);
		
		JLabel lblThngKHp = new JLabel("Thống kê hợp đồng");
		lblThngKHp.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblThngKHp.setBounds(10, 11, 234, 48);
		panelThongKeHopDong.add(lblThngKHp);
		
		btnBarChartHD = new JButton("New button");
		btnBarChartHD.setBackground(Color.WHITE);
		btnBarChartHD.setBounds(10, 70, 310, 147);
		btnBarChartHD.setIcon(new ImageIcon("data\\\\img\\\\iconbarchart.png"));
		panelThongKeHopDong.add(btnBarChartHD);
		
		btnPieChart = new JButton("New button");
		btnPieChart.setBackground(Color.WHITE);
		btnPieChart.setBounds(345, 70, 310, 147);
		btnPieChart.setIcon(new ImageIcon("data\\\\img\\\\pie-chart-icon-design-vector.jpg"));
		panelThongKeHopDong.add(btnPieChart);
		
		JLabel lblNewLabel_1 = new JLabel("GIÁ TRỊ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 228, 310, 30);
		panelThongKeHopDong.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("TÌNH TRẠNG THANH TOÁN");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(345, 228, 310, 30);
		panelThongKeHopDong.add(lblNewLabel_1_1);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelLogin.setBackground(new Color(250, 250, 210));
		panelLogin.setBounds(685, 11, 665, 28);
		panelThongKe.add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(554, 2, 101, 25);
		lblNewLabel_3.setIcon(new ImageIcon("data\\\\img\\\\login.png"));
		lblNewLabel_3.setText("  "+GUI_DangNhap.getDnma());
		panelLogin.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel();
		Date date = new Date();
		lblNewLabel_3_1.setText(date.getDate()+"/"+(date.getMonth()+1)+"/"+(date.getYear()+1900));
		lblNewLabel_3_1.setBackground(Color.WHITE);
		lblNewLabel_3_1.setBounds(10, 2, 300, 25);
		panelLogin.add(lblNewLabel_3_1);
		
		 try{
				ConnectDB.getInstance().connect();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		hopDong_DAO = new DAO_HopDong();
		nhanVienHanhChinh_DAO = new DAO_NhanVienHanhChinh();
		congNhan_DAO = new DAO_CongNhan();
		phieuLuongNhanVien_DAO = new DAO_PhieuLuongNhanVien();
		phieuLuongCongNhan_DAO = new DAO_PhieuLuongCongNhan();
		
		jframeBarChatGTHD = new JFrame();
		jframeBarChatGTHD.setSize(900,700);
		jframeBarChatGTHD.setLocationRelativeTo(null);
		JFreeChart jFreeChartGiaTriHopDong = createChartGiaTriHopDong(hopDong_DAO.getAllChiTietHopDong());
		ChartPanel chartPanelGiaTriHopDong = new ChartPanel(jFreeChartGiaTriHopDong);
		chartPanelGiaTriHopDong.setPreferredSize(new java.awt.Dimension(560, 367));
		jframeBarChatGTHD.getContentPane().add(chartPanelGiaTriHopDong);
		
		
		jframePieChartTTTTHD = new JFrame();
		jframePieChartTTTTHD.setSize(900,700);
		jframePieChartTTTTHD.setLocationRelativeTo(null);
		JFreeChart pieChart = createPieChartTinhTrangThanhToanHD(createDatasetPieTinhTrangThanhToanHD());
        ChartPanel chartPanelpieChart = new ChartPanel(pieChart);
		jframePieChartTTTTHD.getContentPane().add(chartPanelpieChart);
		
		jframeBarChartDoTuoiNV = new JFrame();
		jframeBarChartDoTuoiNV.setSize(900,700);
		jframeBarChartDoTuoiNV.setLocationRelativeTo(null);
		JFreeChart jFreeChartDoTuoiNV = createChartDoTuoiNhanVien(nhanVienHanhChinh_DAO.getAllNhanVienHanhChinh());
		ChartPanel chartPanelDoTuoiNV = new ChartPanel(jFreeChartDoTuoiNV);
		chartPanelDoTuoiNV.setPreferredSize(new java.awt.Dimension(560, 367));
		jframeBarChartDoTuoiNV.getContentPane().add(chartPanelDoTuoiNV);
		

		jframeBarChartDoTuoiCongNhan = new JFrame();
		jframeBarChartDoTuoiCongNhan.setSize(900,700);
		jframeBarChartDoTuoiCongNhan.setLocationRelativeTo(null);
		JFreeChart jFreeChartDoTuoiCongNhan = createChartDoTuoiCongNhan(congNhan_DAO.getAllCongNhan());
		ChartPanel chartPanelDoTuoiCongNhan = new ChartPanel(jFreeChartDoTuoiCongNhan);
		chartPanelDoTuoiCongNhan.setPreferredSize(new java.awt.Dimension(560, 367));
		jframeBarChartDoTuoiCongNhan.getContentPane().add(chartPanelDoTuoiCongNhan);
		
		jframePieChartNhanSu = new JFrame();
		jframePieChartNhanSu.setSize(900,700);
		jframePieChartNhanSu.setLocationRelativeTo(null);
		JFreeChart pieChartNhanSu = createPieChartNhanSu(createDatasetPieNhanSu());
        ChartPanel chartPanelpieChartNhanSu = new ChartPanel(pieChartNhanSu);
		jframePieChartNhanSu.getContentPane().add(chartPanelpieChartNhanSu);
		
		jframePieChartGioiTinhCN = new JFrame();
		jframePieChartGioiTinhCN.setSize(900,700);
		jframePieChartGioiTinhCN.setLocationRelativeTo(null);
		JFreeChart pieChartGioiTinhCN = createPieChartGioiTinhCN(createDatasetPieGioiTinhCN());
        ChartPanel chartPanelpieChartGioiTinhCN = new ChartPanel(pieChartGioiTinhCN);
		jframePieChartGioiTinhCN.getContentPane().add(chartPanelpieChartGioiTinhCN);
		
		jframePieChartGioiTinhNV = new JFrame();
		jframePieChartGioiTinhNV.setSize(900,700);
		jframePieChartGioiTinhNV.setLocationRelativeTo(null);
		JFreeChart pieChartGioiTinhNV = createPieChartGioiTinhNV(createDatasetPieGioiTinhNV());
        ChartPanel chartPanelpieChartGioiTinhNV = new ChartPanel(pieChartGioiTinhNV);
		jframePieChartGioiTinhNV.getContentPane().add(chartPanelpieChartGioiTinhNV);
		
		
		
		btnBarChartHD.addActionListener(this);
		btnPieChart.addActionListener(this);
		btnTuoiNV.addActionListener(this);
		btnNV_CN.addActionListener(this);
		btnGioiTinhCN.addActionListener(this);
		btnGioiTinhNV.addActionListener(this);
		btnTuoiCN.addActionListener(this);
		comboBoxNV.addActionListener(this);
		comboBoxCN.addActionListener(this);
		comboBoxLuong.addActionListener(this);
		btnLuongNV.addActionListener(this);
		btnLuongCN.addActionListener(this);
		btnLuong.addActionListener(this);
		
	}
	
	public JFreeChart createChartGiaTriHopDong(List<ChiTietHopDong> list ) {
		 CategoryDataset categoryDataset = createDatasetGiaTriHD();
		 double tongGiaTri = 0;
		 for(ChiTietHopDong chiTietHopDong : list) {
			 tongGiaTri+=chiTietHopDong.getGiaTriHD();
			 }
		 JFreeChart barChart = ChartFactory.createBarChart(
	                "Giá trị tất cả các hợp đồng: "+NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(tongGiaTri),
	                "Mã hợp đồng", "Giá trị hợp đồng",
	                categoryDataset, PlotOrientation.VERTICAL, false, false, false);
		 return barChart;
	    }
	 
	 public CategoryDataset createDatasetGiaTriHD() {
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 for(ChiTietHopDong chiTietHopDong : hopDong_DAO.getTatCaHopDong()) {
			 dataset.addValue(chiTietHopDong.getGiaTriHD(),"Giá trị",chiTietHopDong.getMaHD().getMaHD());
			 }
		 return dataset;
		 }
	 public JFreeChart createPieChartTinhTrangThanhToanHD(PieDataset dataset) {
	        JFreeChart chart = ChartFactory.createPieChart(
	                "Tình trạng thanh toán của tất cả các hợp đồng", dataset, true, true, true);
	        return chart;
	    }
	 public PieDataset createDatasetPieTinhTrangThanhToanHD() {
		 DefaultPieDataset dataset = new DefaultPieDataset();
		 double x=0,y=0;
		 for(ChiTietHopDong chiTietHopDong : hopDong_DAO.getAllChiTietHopDong()) {
			 if(chiTietHopDong.isThanhToan()==true)
				 x++;
			 else
				 y++;
		 }
		 dataset.setValue("Chưa thanh toán", y);
		 dataset.setValue("Đã thanh toán" , x);
		 return dataset;
	    }
	
	public JFreeChart createChartDoTuoiCongNhan(List<CongNhan> list ) {
		 CategoryDataset categoryDataset = createDatasetDoTuoiCongNhan();
		 JFreeChart barChart = ChartFactory.createBarChart(
	                "Số lượng công nhân: "+list.size(),
	                "Mã công nhân", "Tuổi",
	                categoryDataset, PlotOrientation.VERTICAL, false, false, false);
		 return barChart;
	    }
	 
	
	@SuppressWarnings("deprecation")
	public CategoryDataset createDatasetDoTuoiCongNhan() {
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 Date date = new Date();
		 for(CongNhan congNhan : congNhan_DAO.getAllCongNhan()) {
			 dataset.addValue(date.getYear() - congNhan.getNgaySinh().getYear(),"Tuổi",congNhan.getMaCongNhan());
			 }
		 return dataset;
		 }
	public JFreeChart createPieChartNhanSu(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Tổng số công nhân và nhân viên hành chính: "+(nhanVienHanhChinh_DAO.getAllNhanVienHanhChinh().size()+congNhan_DAO.getAllCongNhan().size()), dataset, true, true, true);
        return chart;
    }
	public PieDataset createDatasetPieNhanSu() {
		DefaultPieDataset dataset = new DefaultPieDataset();
	    dataset.setValue("Công nhân", congNhan_DAO.getAllCongNhan().size());
	    dataset.setValue("Nhân viên hành chính" ,nhanVienHanhChinh_DAO.getAllNhanVienHanhChinh().size());
	    return dataset;
    }
	
	public JFreeChart createPieChartGioiTinhCN(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Tương quan giới tính của công nhân", dataset, true, true, true);
        return chart;
    }
	public PieDataset createDatasetPieGioiTinhCN() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		double x=0,y=0;
		 for(CongNhan congNhan : congNhan_DAO.getAllCongNhan()) {
			 if(congNhan.getGioiTinh().matches("Nam")||congNhan.getGioiTinh().matches("nam"))
				 x++;
			 else
				 y++;
		 }
		 dataset.setValue("Nử", y);
		 dataset.setValue("Nam" , x);
	    return dataset;
    }
	public JFreeChart createPieChartGioiTinhNV(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Tuong quan gioi tinh cua nhan vien", dataset, true, true, true);
        return chart;
    }
	public PieDataset createDatasetPieGioiTinhNV() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		double x=0,y=0;
		 for(NhanVienHanhChinh nhanVienHanhChinh : nhanVienHanhChinh_DAO.getAllNhanVienHanhChinh()) {
			 if(nhanVienHanhChinh.getGioiTinh().matches("Nam")||nhanVienHanhChinh.getGioiTinh().matches("nam"))
				 x++;
			 else
				 y++;
		 }
		 dataset.setValue("Nu", y);
		 dataset.setValue("Nam" , x);
	    return dataset;
    }
	
	public JFreeChart createChartDoTuoiNhanVien(List<NhanVienHanhChinh> list ) {
		 CategoryDataset categoryDataset = createDatasetDoTuoiNhanVien();
		 JFreeChart barChart = ChartFactory.createBarChart(
	                "Số lượng nhân viên hành chính: "+list.size(),
	                "Mã nhân viên", "Tuổi",
	                categoryDataset, PlotOrientation.VERTICAL, false, false, false);
		 return barChart;
	}
	 
	@SuppressWarnings("deprecation")
	public CategoryDataset createDatasetDoTuoiNhanVien() {
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 Date date = new Date();
		 for(NhanVienHanhChinh nhanVienHanhChinh : nhanVienHanhChinh_DAO.getAllNhanVienHanhChinh()) {
			 dataset.addValue(date.getYear() - nhanVienHanhChinh.getNgaySinh().getYear(),"Tuổi",nhanVienHanhChinh.getMaNhanVien());
			 }
		 return dataset; 
	}
	
	@SuppressWarnings("deprecation")
	public JFreeChart createChartLuongNV(List<PhieuLuongNhanVien> list, int mouth ) {
		 CategoryDataset categoryDataset = createDatasetLuongNV(mouth);
		 double tong=0;
		 for (PhieuLuongNhanVien phieuLuongNhanVien:list) {
			if(phieuLuongNhanVien.getNgayTao().getMonth()+1==mouth&&phieuLuongNhanVien.getNgayTao().getYear()==new Date().getYear())
				tong+=phieuLuongNhanVien.getThanhTien();
		}
		 JFreeChart barChart = ChartFactory.createBarChart(
				    "Lương nhân viên trong tháng "+mouth+"\n"+"Tổng lương: "+NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(tong),
	                "Mã người hưởng lương", "Lương",
	                categoryDataset, PlotOrientation.VERTICAL, false, false, false);
		 return barChart;  
	}
	 
	
	@SuppressWarnings("deprecation")
	public CategoryDataset createDatasetLuongNV(int mouth) {
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 for(PhieuLuongNhanVien phieuLuongNhanVien : phieuLuongNhanVien_DAO.getAllPhieuLuongNhanVien()) {
			 if (phieuLuongNhanVien.getNgayTao().getMonth()+1==mouth&&phieuLuongNhanVien.getNgayTao().getYear()==new Date().getYear()) {
				 dataset.addValue(phieuLuongNhanVien.getThanhTien(),"",phieuLuongNhanVien.getMaNguoiHuong());
			 }	 
		 }
		 return dataset;	 
	}
	
	@SuppressWarnings("deprecation")
	public JFreeChart createChartLuongCN(List<PhieuLuongCongNhan> list, int mouth ) {
		 CategoryDataset categoryDataset = createDatasetLuongCN(mouth);
		 double tong = 0;
		 for (PhieuLuongCongNhan phieuLuongCongNhan:list) {
				if(phieuLuongCongNhan.getNgayTao().getMonth()+1==mouth&&phieuLuongCongNhan.getNgayTao().getYear()==new Date().getYear())
					tong+=phieuLuongCongNhan.getThanhTien();
			}
		 JFreeChart barChart = ChartFactory.createBarChart(
	                "Lương công nhân trong tháng "+mouth+"\nTổng lương: "+NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(tong),
	                "Mã người hưởng lương", "Thành tiền",
	                categoryDataset, PlotOrientation.VERTICAL, false, false, false);
		 return barChart;
	}
	 
	
	@SuppressWarnings("deprecation")
	public CategoryDataset createDatasetLuongCN(int mouth) {
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 for(PhieuLuongCongNhan phieuLuongCongNhan : phieuLuongCongNhan_DAO.getAllPhieuLuongCongNhan()) {
			 if (phieuLuongCongNhan.getNgayTao().getMonth()+1==mouth&&phieuLuongCongNhan.getNgayTao().getYear()==new Date().getYear()) {
				 dataset.addValue(phieuLuongCongNhan.getThanhTien(),"",phieuLuongCongNhan.getMaNguoiHuong());
			 }	 
		 }
		 return dataset;	
	}
	
	@SuppressWarnings("deprecation")
	public JFreeChart createPieChartLuong(PieDataset dataset,int month,List<PhieuLuongCongNhan> listCN,List<PhieuLuongNhanVien> listNV) {
		double tong =0;
		for(PhieuLuongNhanVien phieuLuongNhanVien : phieuLuongNhanVien_DAO.getAllPhieuLuongNhanVien()) {
			if(phieuLuongNhanVien.getNgayTao().getMonth()+1==month&&phieuLuongNhanVien.getNgayTao().getYear()==new Date().getYear())
				tong+=phieuLuongNhanVien.getThanhTien();
		}
		for(PhieuLuongCongNhan phieuLuongCongNhan : phieuLuongCongNhan_DAO.getAllPhieuLuongCongNhan()) {
			if(phieuLuongCongNhan.getNgayTao().getMonth()+1==month&&phieuLuongCongNhan.getNgayTao().getYear()==new Date().getYear())
				tong+=phieuLuongCongNhan.getThanhTien();
		}
        JFreeChart chart = ChartFactory.createPieChart(
                "Tương quan về lương thực lĩnh giữa công nhân và nhân viên hành chính trong tháng: "+month
                +"\nTổng lương thực lĩnh: "+NumberFormat.getCurrencyInstance(new Locale("vi","VN")).format(tong), dataset, true, true, true);
        return chart;
    }
 
	@SuppressWarnings("deprecation")
	public PieDataset createDatasetPieLuong(int month) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		double x=0,y=0;
		for(PhieuLuongNhanVien phieuLuongNhanVien : phieuLuongNhanVien_DAO.getAllPhieuLuongNhanVien()) {
			if(phieuLuongNhanVien.getNgayTao().getMonth()+1==month&&phieuLuongNhanVien.getNgayTao().getYear()==new Date().getYear())
				x+=phieuLuongNhanVien.getThanhTien();
		}
		for(PhieuLuongCongNhan phieuLuongCongNhan : phieuLuongCongNhan_DAO.getAllPhieuLuongCongNhan()) {
			if(phieuLuongCongNhan.getNgayTao().getMonth()+1==month&&phieuLuongCongNhan.getNgayTao().getYear()==new Date().getYear())
				y+=phieuLuongCongNhan.getThanhTien();
		}
		dataset.setValue("Tổng lương công nhân ", y);
		dataset.setValue("Tổng lương nhân viên " , x);
		return dataset;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnBarChartHD)) {
			jframeBarChatGTHD.setVisible(true);
		}
		if (o.equals(btnPieChart)) {
			jframePieChartTTTTHD.setVisible(true);
		}
		if (o.equals(btnTuoiNV)) {
			jframeBarChartDoTuoiNV.setVisible(true);
		}
		if (o.equals(btnTuoiCN)) {
			jframeBarChartDoTuoiCongNhan.setVisible(true);
		}
		if (o.equals(btnNV_CN)) {
			jframePieChartNhanSu.setVisible(true);
		}
		if (o.equals(btnGioiTinhCN)) {
			jframePieChartGioiTinhCN.setVisible(true);
		}
		if (o.equals(btnGioiTinhNV)) {
			jframePieChartGioiTinhNV.setVisible(true);
		}
		if(o.equals(btnLuongNV)) {
			if(comboBoxNV.getSelectedIndex()!=-1) {
				bieuDoLuongNV(phieuLuongNhanVien_DAO.getAllPhieuLuongNhanVien(),Integer.parseInt(comboBoxNV.getSelectedItem().toString()));
				
			}else {
				JOptionPane.showMessageDialog(this, "PHẢI CHỌN THÁNG ĐỂ XEM THỐNG KÊ!");
			}
		}
		if(o.equals(btnLuongCN)) {
			if(comboBoxCN.getSelectedIndex()!=-1) {
				bieuDoLuongCN(phieuLuongCongNhan_DAO.getAllPhieuLuongCongNhan(),Integer.parseInt(comboBoxCN.getSelectedItem().toString()));
				
			}else {
				JOptionPane.showMessageDialog(this, "PHẢI CHỌN THÁNG ĐỂ XEM THỐNG KÊ!");
			}
		}
		if(o.equals(btnLuong)) {
			if(comboBoxLuong.getSelectedIndex()!=-1) {
				bieuDoLuong(Integer.parseInt(comboBoxLuong.getSelectedItem().toString()), phieuLuongCongNhan_DAO.getAllPhieuLuongCongNhan(), phieuLuongNhanVien_DAO.getAllPhieuLuongNhanVien());
				
			}else {
				JOptionPane.showMessageDialog(this, "PHẢI CHỌN THÁNG ĐỂ XEM THỐNG KÊ!");
			}
		}
		
	}
	
	public void bieuDoLuongNV(List<PhieuLuongNhanVien> list,int month) {
		JFrame jframeBarChartLuongNV = new JFrame();
		jframeBarChartLuongNV.setSize(900,700);
		jframeBarChartLuongNV.setLocationRelativeTo(null);
		JFreeChart jFreeChartLuongNV = createChartLuongNV(list, month);
		ChartPanel chartPanelLuongNV = new ChartPanel(jFreeChartLuongNV);
		jframeBarChartLuongNV.getContentPane().add(chartPanelLuongNV);
		jframeBarChartLuongNV.setVisible(true);
	}
	public void bieuDoLuongCN(List<PhieuLuongCongNhan> list,int month) {
		JFrame jframeBarChartLuongCN = new JFrame();
		jframeBarChartLuongCN.setSize(900,700);
		jframeBarChartLuongCN.setLocationRelativeTo(null);
		JFreeChart jFreeChartLuongCN = createChartLuongCN(list, month);
		ChartPanel chartPanelLuongCN = new ChartPanel(jFreeChartLuongCN);
		jframeBarChartLuongCN.getContentPane().add(chartPanelLuongCN);
		jframeBarChartLuongCN.setVisible(true);

	}
	public void bieuDoLuong(int month,List<PhieuLuongCongNhan> listCN,List<PhieuLuongNhanVien> listNV) {
		JFrame jframePieChartLuong = new JFrame();
		jframePieChartLuong.setSize(900,700);
		jframePieChartLuong.setLocationRelativeTo(null);
		JFreeChart pieChartLuong = createPieChartLuong(createDatasetPieLuong(month), month, listCN, listNV);
        ChartPanel chartPanelpieChartLuong = new ChartPanel(pieChartLuong);
		jframePieChartLuong.getContentPane().add(chartPanelpieChartLuong);
		jframePieChartLuong.setVisible(true);
	}
	
}

package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel labelExit;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/imagenes/Model1-120.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 910, 537);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(52, 142, 145));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(0, 0, 910, 537);
		panel.setBackground(new Color(52, 142, 145));
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Barra para controlar la ventana 
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(new Color(33, 54, 53));
		panel.add(header);
		
		//Bot??n salir
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 500, 910, 37);
		panel_1.setBackground(new Color(33, 54, 53));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCopyR = new JLabel("Desarrollado por Matias Riffo ?? 2022");
		lblCopyR.setBounds(315, 11, 284, 19);
		lblCopyR.setForeground(new Color(240, 248, 255));
		lblCopyR.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel_1.add(lblCopyR);
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 35, 569, 468);
		imagenFondo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/2.jpg")));
		panel.add(imagenFondo);
		
		JLabel logo = new JLabel("");
		logo.setBounds(624, 62, 197, 209);
		logo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/Model1-150.png")));
		panel.add(logo);
		
		//Bot??n Login
		JPanel btnLogin = new JPanel(); 
		btnLogin.setBounds(654, 331, 83, 70);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnLogin.setBackground(new Color(52, 142, 145));
		panel.add(btnLogin);
		
		JLabel imagenLogin = new JLabel("");
		imagenLogin.setBounds(0, 0, 80, 70);
		btnLogin.add(imagenLogin);
		imagenLogin.setHorizontalAlignment(SwingConstants.CENTER);
		imagenLogin.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/imagenes/login.png")));
		
		JLabel lblTitulo = new JLabel("Iniciar Sesi??n");
		lblTitulo.setBounds(623, 289, 150, 26);
		lblTitulo.setBackground(SystemColor.window);
		panel.add(lblTitulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(33, 54, 53));
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 22));
		
		JLabel lblCopyR_1 = new JLabel("Bienvenido");
		lblCopyR_1.setBackground(new Color(33, 54, 53));
		lblCopyR_1.setForeground(new Color(33, 54, 53));
		lblCopyR_1.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblCopyR_1.setBounds(624, 401, 181, 77);
		panel.add(lblCopyR_1);
	}
	
	//C??digo que permite movimentar a janela pela tela seguindo a posi????o de "x" e "y"	
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }
    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
}
}

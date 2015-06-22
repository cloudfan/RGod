package net.fragbashers.rgp;

import java.awt.Color;

public class Updater extends JFrame {
	private JPanel contentPane;
	private JPanel downloading;
	private Point initialClick;
	
	
	
	public Updater() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e ){
			
		}
		
		JPanel contentPane = new JPanel();
		
		contentPane.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	            initialClick = e.getPoint();
	            getComponentAt(initialClick);
	        }
	    });
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				 // get location of Window
	            int thisX = getLocation().x;
	            int thisY = getLocation().y;

	            // Determine how much the mouse moved since the initial click
	            int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
	            int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

	            // Move window to this position
	            int X = thisX + xMoved;
	            int Y = thisY + yMoved;
	            setLocation(X, Y);
			}
		});
		
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("RGP Updater");
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow")));
		
		JLabel lblYouAreOut = new JLabel("You are out of date!");
		lblYouAreOut.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 14));
		lblYouAreOut.setBounds(94, 35, 112, 25);
		contentPane.add(lblYouAreOut);
		
		HoverButton btnExit = new HoverButton("X");
		btnExit.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnExit.setForeground(Color.RED);
		btnExit.setBounds(275, 10, 15, 15);
		contentPane.add(btnExit);
		
		JLabel lblUpdate = new JLabel("Update?");
		lblUpdate.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 14));
		lblUpdate.setBounds(126, 70, 49, 14);
		contentPane.add(lblUpdate);
		
		HoverButton btnYes = new HoverButton("Yes");
		btnYes.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 14));
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Backend.downloadUpdate();
				} catch (Exception e1) {
					
				}
				
				JPanel downloading = new JPanel();
				setContentPane(downloading);
				
				downloading.setBorder(new EmptyBorder(5, 5, 5, 5));
				downloading.setLayout(null);
				downloading.setBackground(new Color(255, 255, 255));
				downloading.setForeground(new Color(255, 255, 255));
				downloading.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow")));
				
				HoverButton btnExit = new HoverButton("X");
				btnExit.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 14));
				btnExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(EXIT_ON_CLOSE);
					}
				});
				btnExit.setForeground(Color.RED);
				btnExit.setBounds(275, 10, 15, 15);
				downloading.add(btnExit);
				dispose();
			}
		});
		btnYes.setForeground(Color.GREEN);
		btnYes.setBounds(94, 105, 40, 20);
		contentPane.add(btnYes);
		
		HoverButton btnNo = new HoverButton("No");
		btnNo.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 14));
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interface frame = new Interface();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNo.setForeground(Color.RED);
		btnNo.setBounds(166, 105, 40, 20);
		contentPane.add(btnNo);
	}
}

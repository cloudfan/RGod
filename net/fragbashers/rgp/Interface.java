package net.fragbashers.rgp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

/**
 * @author Liam
 * Random God Picker (RGP) was a pet project for simple GUI design.
 * 
 * I in no way own Smite, or am affiliated with Hi-Rez Studios.
 * All custom code belongs to Liam "Fragbashers" Kelly.
 * I withhold the right at any time to stop supporting RGP.
 * I also withhold my right to close projects using my code without permission.
 */
public class Interface extends JFrame{
	private static final long serialVersionUID = 4915419670445011557L;
	
	private Point initialClick;
	private boolean getAssassin = false;
	private boolean getGuardian = false;
	private boolean getHunter = false;
	private boolean getMage = false;
	private boolean getWarrior = false;
	private boolean chooseRole = false;
	
	public Interface() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e ){
			
		}
		
		String rgod = "";
		String rrole = "";
		JPanel cont = new JPanel();
		
		final JCheckBox chckbxAssassin = new JCheckBox("Assassin");
		final JCheckBox chckbxGuardian = new JCheckBox("Guardian");
		final JCheckBox chckbxHunter = new JCheckBox("Hunter");
		final JCheckBox chckbxMage = new JCheckBox("Mage");
		final JCheckBox chckbxWarrior = new JCheckBox("Warrior");
		final JCheckBox chckbxRandomRole = new JCheckBox("Random Role");

		final JLabel lblCopyright = new JLabel("v2.0 by Fragbashers ©");
		final JLabel lblGodName = DefaultComponentFactory.getInstance().createLabel(rgod);
		final JLabel lblRandom = DefaultComponentFactory.getInstance().createLabel("Your Random God is:");
		final JLabel lblRole = DefaultComponentFactory.getInstance().createLabel(rrole);
		final JLabel lblYourRoleIs = new JLabel("Your Role is:");
		
		int chckbxlHeight = 17;
		int chckbxWidth = 90;
		
		setSize(300, 167);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Random God Picker");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		cont.setLayout(null);
		setUndecorated(true);
		setContentPane(cont);
		cont.setBackground(new Color(255, 255, 255));
		cont.setForeground(new Color(255, 255, 255));
		cont.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow")));
		
		cont.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	            initialClick = e.getPoint();
	            getComponentAt(initialClick);
	        }
	    });
		cont.addMouseMotionListener(new MouseMotionAdapter() {
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
		
		HoverButton btnNewGod = new HoverButton("New God");
		btnNewGod.setForeground(new Color(50, 205, 50));
		btnNewGod.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 14));
		btnNewGod.setBounds(16, 139, 60, 14);
		cont.add(btnNewGod);
		btnNewGod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAssassin = chckbxAssassin.isSelected();
				getGuardian = chckbxGuardian.isSelected();
				getHunter = chckbxHunter.isSelected();
				getMage = chckbxMage.isSelected();
				getWarrior = chckbxWarrior.isSelected();
				chooseRole = chckbxRandomRole.isSelected();
				
				try {
				if (getAssassin & getGuardian & getHunter & getMage & getWarrior) {
					//System.out.println("Getting All.");
					String rangod = Backend.getAll();
					lblGodName.setText(rangod);
				} else {
					List<String> someRoles = new ArrayList<String>();
					Random rand = new Random();
					//System.out.println("Getting Most.");
					
					if (getAssassin) {
			            someRoles.addAll(Backend.getAs());
			        }
					if (getGuardian) {
			            someRoles.addAll(Backend.getGd());
			        }
					if (getHunter) {
			            someRoles.addAll(Backend.getHn());
			        }
					if (getMage) {
			            someRoles.addAll(Backend.getMg());
			        }
					if (getWarrior) {
			            someRoles.addAll(Backend.getWr());
			        }
					int index = rand.nextInt(someRoles.size());
					String rangod = someRoles.get(index);
					lblGodName.setText(rangod);
					//System.out.println("Random God = " + rangod);
				}
				if (chooseRole) {
					String ranRole = Backend.getRole();
					lblRole.setText(ranRole);
					//System.out.println("Random Role = " + ranRole);
				}	
				} catch (Exception ex){
					//System.out.println("No gods chosen!");
					lblGodName.setText("No gods chosen!");
				}
			}
		});
		
		chckbxAssassin.setBounds(6, 14, chckbxWidth, 17);
		chckbxAssassin.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 12));
		chckbxAssassin.setBackground(Color.WHITE);
		chckbxAssassin.setSelected(true);
		cont.add(chckbxAssassin);
		
		chckbxGuardian.setBounds(6, 35, chckbxWidth, 17);
		chckbxGuardian.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 12));
		chckbxGuardian.setBackground(Color.WHITE);
		chckbxGuardian.setSelected(true);
		cont.add(chckbxGuardian);
		
		chckbxHunter.setBounds(6, 55, chckbxWidth, chckbxlHeight);
		chckbxHunter.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 12));
		chckbxHunter.setBackground(Color.WHITE);
		chckbxHunter.setSelected(true);
		cont.add(chckbxHunter);
		
		chckbxMage.setBounds(6, 75, chckbxWidth, chckbxlHeight);
		chckbxMage.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 12));
		chckbxMage.setBackground(Color.WHITE);
		chckbxMage.setSelected(true);
		cont.add(chckbxMage);
		
		chckbxWarrior.setBounds(6, 95, chckbxWidth, chckbxlHeight);
		chckbxWarrior.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 12));
		chckbxWarrior.setBackground(Color.WHITE);
		chckbxWarrior.setSelected(true);
		cont.add(chckbxWarrior);
		
		chckbxRandomRole.setBounds(6, 115, 97, 17);
		chckbxRandomRole.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 12));
		chckbxRandomRole.setBackground(Color.WHITE);
		chckbxRandomRole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxRandomRole.isSelected()) {
					lblYourRoleIs.setVisible(true);
					lblRole.setVisible(true);
				} else {
					lblYourRoleIs.setVisible(false);
					lblRole.setVisible(false);
				}
			}
		});
		cont.add(chckbxRandomRole);
		
		lblCopyright.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 14));
		lblCopyright.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCopyright.setBounds(169, 152, 130, 14);
		cont.add(lblCopyright);
		
		lblGodName.setHorizontalAlignment(SwingConstants.CENTER);
		lblGodName.setFont(new Font("Estrangelo Edessa", Font.BOLD | Font.ITALIC, 15));
		lblGodName.setBounds(97, 48, 193, 36);
		cont.add(lblGodName);
		
		lblRandom.setHorizontalAlignment(SwingConstants.CENTER);
		lblRandom.setFont(new Font("Estrangelo Edessa", Font.BOLD, 15));
		lblRandom.setBounds(98, 26, 192, 36);
		cont.add(lblRandom);
		
		lblRole.setHorizontalAlignment(SwingConstants.CENTER);
		lblRole.setFont(new Font("Estrangelo Edessa", Font.BOLD | Font.ITALIC, 15));
		lblRole.setBounds(97, 100, 193, 36);
		cont.add(lblRole);
		
		lblYourRoleIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourRoleIs.setFont(new Font("Estrangelo Edessa", Font.BOLD, 15));
		lblYourRoleIs.setBounds(102, 85, 182, 14);
		cont.add(lblYourRoleIs);
		
		lblRole.setVisible(false);
		lblYourRoleIs.setVisible(false);
		
		HoverButton btnExit = new HoverButton("X");
		btnExit.setFont(new Font("Estrangelo Edessa", Font.PLAIN, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnExit.setForeground(Color.RED);
		btnExit.setBounds(275, 10, 15, 15);
		cont.add(btnExit);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					Backend.DownloadLists();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

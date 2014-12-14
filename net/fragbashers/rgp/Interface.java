package net.fragbashers.rgp;

import java.awt.EventQueue;

/**
 * @author Liam
 * Random God Picker (RGP) was a pet project for simple GUI design.
 * 
 * I in no way own Smite, or am affiliated with Hi-Rez Studios.
 * All custom code belongs to Liam "Fragbashers" Kelly.
 * I withhold the right at any time to stop supporting RGP.
 * I also withhold my right to close projects using my code without permission.
 */
public class Interface extends JFrame implements Runnable{
	private static final long serialVersionUID = 4915419670445011557L;
	
	private boolean getAssassin = false;
	private boolean getGuardian = false;
	private boolean getHunter = false;
	private boolean getMage = false;
	private boolean getWarrior = false;
	
	public void run() {
		
	}
	
	public Interface() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e){
			//e.printStackTrace();
			System.out.println("Exception");
		}

		int chckbxlHeight = 17;
		int chckbxWidth = 90;
		String rgod = "";
		
		final JCheckBox chckbxAssassin = new JCheckBox("Assassin");
		final JCheckBox chckbxGuardian = new JCheckBox("Guardian");
		final JCheckBox chckbxHunter = new JCheckBox("Hunter");
		final JCheckBox chckbxMage = new JCheckBox("Mage");
		final JCheckBox chckbxWarrior = new JCheckBox("Warrior");
		
		final JLabel lblGodName = DefaultComponentFactory.getInstance().createLabel(rgod);
		
		JButton btnNewGod = new JButton("New God");
		btnNewGod.setBounds(0, 105, 75, 23);
		getContentPane().add(btnNewGod);
		btnNewGod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAssassin = chckbxAssassin.isSelected();
				getGuardian = chckbxGuardian.isSelected();
				getHunter = chckbxHunter.isSelected();
				getMage = chckbxMage.isSelected();
				getWarrior = chckbxWarrior.isSelected();
				try {
				if (getAssassin & getGuardian & getHunter & getMage & getWarrior) {
					System.out.println("Getting All.");
					String rangod = Backend.getAll();
					lblGodName.setText(rangod);
					setTitle("Random God: " + rangod);
				} else {
					List<String> someRoles = new ArrayList<String>();
					Random rand = new Random();
					
					if (getAssassin) {
			            System.out.println("Getting Assassins.");
			            someRoles.addAll(Backend.getAs());
			        }
					if (getGuardian) {
			            System.out.println("Getting Guardians.");
			            someRoles.addAll(Backend.getGd());
			        }
					if (getHunter) {
			            System.out.println("Getting Hunters.");
			            someRoles.addAll(Backend.getHn());
			        }
					if (getMage) {
			            System.out.println("Getting Mages.");
			            someRoles.addAll(Backend.getMg());
			        }
					if (getWarrior) {
			            System.out.println("Getting Warriors.");
			            someRoles.addAll(Backend.getWr());
			        }
					
					int index = rand.nextInt(someRoles.size());
					String rangod = someRoles.get(index);
					System.out.println("Random God = " + rangod);
					lblGodName.setText(rangod);
					setTitle("Random God: " + rangod);
				}
				} catch (Exception ex){
					System.out.println("No roles chosen!");
					lblGodName.setText("No roles chosen!");
					setTitle("Random God: ");
				}
			}
		});
		
		JLabel lblCopyright = new JLabel("Fragbashers\u00A9 ");
		lblCopyright.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCopyright.setBounds(212, 114, 82, 14);
		getContentPane().add(lblCopyright);
		
		chckbxAssassin.setBounds(0, 5, chckbxWidth, 17);
		chckbxAssassin.setSelected(true);
		getContentPane().add(chckbxAssassin);
		
		chckbxGuardian.setBounds(0, 25, chckbxWidth, 17);
		chckbxGuardian.setSelected(true);
		getContentPane().add(chckbxGuardian);
		
		chckbxHunter.setBounds(0, 45, chckbxWidth, chckbxlHeight);
		chckbxHunter.setSelected(true);
		getContentPane().add(chckbxHunter);
		
		chckbxMage.setBounds(0, 65, chckbxWidth, chckbxlHeight);
		chckbxMage.setSelected(true);
		getContentPane().add(chckbxMage);
		
		chckbxWarrior.setBounds(0, 85, chckbxWidth, chckbxlHeight);
		chckbxWarrior.setSelected(true);
		getContentPane().add(chckbxWarrior);
		
		JLabel lblRandom = DefaultComponentFactory.getInstance().createLabel("Your Random God is:");
		lblRandom.setHorizontalAlignment(SwingConstants.CENTER);
		lblRandom.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 15));
		lblRandom.setBounds(82, 29, 192, 36);
		getContentPane().add(lblRandom);
		
		lblGodName.setHorizontalAlignment(SwingConstants.CENTER);
		lblGodName.setFont(new Font("Lucida Sans Unicode", Font.BOLD | Font.ITALIC, 15));
		lblGodName.setBounds(82, 49, 193, 36);
		getContentPane().add(lblGodName);
		
		setSize(300, 157);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Random God: " + rgod);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

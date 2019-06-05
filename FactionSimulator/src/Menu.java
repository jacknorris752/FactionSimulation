import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;



public class Menu extends JFrame {
	private JLabel ErrorTextLabel;
	
	private String[] col = new String[] {"Blue","Red","Green","Black","Yellow","Pink"};
	private Color[] availableColors = new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.BLACK, Color.YELLOW, Color.PINK};
	
	public Menu() {
		setAlwaysOnTop(true);
		setSize(new Dimension(500, 300));
		setPreferredSize(new Dimension(500, 300));
		setMinimumSize(new Dimension(500, 300));
		setTitle("FACTION SIMULATOR");
		getContentPane().setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFactionSimulator = new JLabel("FACTION SIMULATOR");
		lblFactionSimulator.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblFactionSimulator);
		
		//FACTION 1
		JPanel Faction1Panel = new JPanel();
		getContentPane().add(Faction1Panel);
		Faction1Panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel Fac1Label = new JLabel("    Faction_1");
		Faction1Panel.add(Fac1Label);
		
		JTextField txtFactionName = new JTextField();
		txtFactionName.setText("Faction Name");
		Faction1Panel.add(txtFactionName);
		txtFactionName.setColumns(20);
		
		JLabel lblStats = new JLabel("Stats");
		Faction1Panel.add(lblStats);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(col));
		comboBox.setSelectedIndex(0);
		Faction1Panel.add(comboBox);
		//END OF FACTION 1
		
		//FACTION 2
		JPanel Faction2Panel = new JPanel();
		getContentPane().add(Faction2Panel);
		Faction2Panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel Fac2Label = new JLabel("    Faction_2");
		Faction2Panel.add(Fac2Label);
		
		JTextField txtFactionName2 = new JTextField();
		txtFactionName2.setText("Faction Name");
		txtFactionName2.setColumns(20);
		Faction2Panel.add(txtFactionName2);
		
		JLabel label = new JLabel("Stats");
		Faction2Panel.add(label);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(col));
		comboBox_1.setSelectedIndex(1);
		Faction2Panel.add(comboBox_1);
		//END OF FACTION 2
		
		//FACTION 3
		JPanel Faction3Panel = new JPanel();
		getContentPane().add(Faction3Panel);
		Faction3Panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JRadioButton Fac3Button = new JRadioButton("Faction_3");
		Fac3Button.setSelected(true);
		Faction3Panel.add(Fac3Button);
		
		JTextField txtFactionName3 = new JTextField();
		txtFactionName3.setText("Faction Name");
		txtFactionName3.setColumns(20);
		Faction3Panel.add(txtFactionName3);
		
		JLabel label_1 = new JLabel("Stats");
		Faction3Panel.add(label_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(col));
		comboBox_2.setSelectedIndex(2);
		Faction3Panel.add(comboBox_2);
		//END OF FACTION 3
		
		//FACTION 4
		JPanel Faction4Panel = new JPanel();
		getContentPane().add(Faction4Panel);
		Faction4Panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JRadioButton Fac4Button = new JRadioButton("Faction_4");
		Fac4Button.setSelected(true);
		Faction4Panel.add(Fac4Button);
		
		JTextField txtFactionName4 = new JTextField();
		txtFactionName4.setText("Faction Name");
		txtFactionName4.setColumns(20);
		Faction4Panel.add(txtFactionName4);
		
		JLabel label_2 = new JLabel("Stats");
		Faction4Panel.add(label_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(col));
		comboBox_3.setSelectedIndex(3);
		Faction4Panel.add(comboBox_3);
		//END OF FACTION 4
		
		//INFO PANEL
		JPanel InfoPanel = new JPanel();
		getContentPane().add(InfoPanel);
		InfoPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Collect relevant fields and determine how many factions
				int howMany = 2; 				//must be at least two
				if(Fac3Button.isSelected()) {
					howMany++;
				}
				if(Fac4Button.isSelected()) {
					howMany++;
				}
				
				//collect Faction names
				String[] factionNames = new String[4];
				factionNames[0] = txtFactionName.getText();
				factionNames[0] = txtFactionName2.getText();
				factionNames[0] = txtFactionName3.getText();
				factionNames[0] = txtFactionName4.getText();
				
				//TODO: check colours are all different
				//code here
				//break if not
				
				//Convert colour selection to "Color" array
				Color[] colorSelection = new Color[4];
				colorSelection[0] = availableColors[comboBox.getSelectedIndex()];
				colorSelection[1] = availableColors[comboBox_1.getSelectedIndex()];
				colorSelection[2] = availableColors[comboBox_2.getSelectedIndex()];
				colorSelection[3] = availableColors[comboBox_3.getSelectedIndex()];
				
				//start game
				World.createFactions(howMany,factionNames,colorSelection);
				Engine.startSim();
				//close this window
				setVisible(false);
			}
		});
		InfoPanel.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		InfoPanel.add(separator);
		
		ErrorTextLabel = new JLabel("    error stuff");
		InfoPanel.add(ErrorTextLabel);
		
		setVisible(true);
	}
	
}

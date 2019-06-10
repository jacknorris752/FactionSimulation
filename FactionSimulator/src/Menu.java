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
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.BevelBorder;
import java.awt.Font;

/*
 * TODO: Stat buttons that open new windows for that specific factions stats?
 * 	^^ include random button to generate random stats
 * TODO: Fix bug if pick factions 1,2 and 4
 */

public class Menu extends JFrame {
	
	private String[] col = new String[] {"Blue","Red","Green","Black","Yellow","Pink"};
	private Color[] availableColors = new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.BLACK, Color.YELLOW, Color.PINK};
	private boolean validColours = true;
	private static JTextArea errorTextArea;
	
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblFactionSimulator.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFactionSimulator.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblFactionSimulator);
		
		//FACTION 1
		JPanel Faction1Panel = new JPanel();
		Faction1Panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(Faction1Panel);
		Faction1Panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel Fac1Label = new JLabel("    Faction_1");
		Faction1Panel.add(Fac1Label);
		
		JTextField txtFactionName = new JTextField();
		txtFactionName.setToolTipText("Faction Name");
		txtFactionName.setText("Faction_1");
		Faction1Panel.add(txtFactionName);
		txtFactionName.setColumns(20);
		
		JButton facStatButton = new JButton("Faction Stats");
		facStatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO: YES
				statMenu();
				//faction = statMenu();
			}
		});
		Faction1Panel.add(facStatButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(col));
		comboBox.setSelectedIndex(0);
		Faction1Panel.add(comboBox);
		//END OF FACTION 1
		
		//FACTION 2
		JPanel Faction2Panel = new JPanel();
		Faction2Panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(Faction2Panel);
		Faction2Panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel Fac2Label = new JLabel("    Faction_2");
		Faction2Panel.add(Fac2Label);
		
		JTextField txtFactionName2 = new JTextField();
		txtFactionName2.setToolTipText("Faction Name");
		txtFactionName2.setText("Faction_2");
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
		Faction3Panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(Faction3Panel);
		Faction3Panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JRadioButton Fac3Button = new JRadioButton("Faction_3");
		Fac3Button.setSelected(true);
		Faction3Panel.add(Fac3Button);
		
		JTextField txtFactionName3 = new JTextField();
		txtFactionName3.setToolTipText("Faction Name");
		txtFactionName3.setText("Faction_3");
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
		Faction4Panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(Faction4Panel);
		Faction4Panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JRadioButton Fac4Button = new JRadioButton("Faction_4");
		Fac4Button.setSelected(true);
		Faction4Panel.add(Fac4Button);
		
		JTextField txtFactionName4 = new JTextField();
		txtFactionName4.setToolTipText("Faction Name");
		txtFactionName4.setText("Faction_4");
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
		InfoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(InfoPanel);
		GridBagLayout gbl_InfoPanel = new GridBagLayout();
		gbl_InfoPanel.columnWidths = new int[]{121, 121, 121, 0};
		gbl_InfoPanel.rowHeights = new int[]{43, 0};
		gbl_InfoPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_InfoPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		InfoPanel.setLayout(gbl_InfoPanel);
		
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
				
				//Convert colour selection to "Color" array
				Color[] colorSelection = new Color[4];
				colorSelection[0] = availableColors[comboBox.getSelectedIndex()];
				colorSelection[1] = availableColors[comboBox_1.getSelectedIndex()];
				
				//if factions are not being used colour value is null
				if(Fac3Button.isSelected()) {
					colorSelection[2] = availableColors[comboBox_2.getSelectedIndex()];
				}else {
					colorSelection[2] = null;
				}
				if(Fac4Button.isSelected()) {
					colorSelection[3] = availableColors[comboBox_3.getSelectedIndex()];
				}else {
					colorSelection[3] = null;
				}
				
				
				//check colours are all different
				for(Color col : colorSelection) {
					int i = 0;
					if(col == colorSelection[0]) {
						i++;
					}
					if(col == colorSelection[1]) {
						i++;
					}
					if(col == colorSelection[2] && colorSelection[2] != null) {
						i++;
					}
					if(col == colorSelection[3] && colorSelection[3] != null) {
						i++;
					}
					if(i > 1) {
						validColours = false;
						errorMessage("Each faction must have a different color");
						break;
					}
				}
				
				if(validColours) {
					//start game
					World.createFactions(howMany,factionNames,colorSelection);
					Engine.startSim();
					//close this window
					setVisible(false);
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		InfoPanel.add(btnNewButton, gbc_btnNewButton);
		
		errorTextArea = new JTextArea();
		errorTextArea.setRows(4);
		errorTextArea.setEditable(false);
		GridBagConstraints gbc_errorTextArea = new GridBagConstraints();
		gbc_errorTextArea.gridwidth = 2;
		gbc_errorTextArea.insets = new Insets(0, 0, 0, 5);
		gbc_errorTextArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_errorTextArea.gridx = 1;
		gbc_errorTextArea.gridy = 0;
		InfoPanel.add(errorTextArea, gbc_errorTextArea);
		
		setVisible(true);
	}
	
	public static void errorMessage(String msg) {
		errorTextArea.setText(msg);
	}
	
	//TODO: New window that pops up adjust variables of given faction
	//TODO: needs return type faction
	public void statMenu() {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //TODO: change this for the love of fuck
		jf.setAlwaysOnTop(true);
		jf.setSize(new Dimension(200, 200));
		jf.setPreferredSize(new Dimension(200, 200));
		jf.setMinimumSize(new Dimension(200, 200));
		jf.setTitle("stats");
		
		JPanel panel = new JPanel();
		jf.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		jf.setVisible(true);
	}
	
}

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



public class Menu extends JFrame {
	private JLabel ErrorTextLabel;
	
	private Color[] availableColors = new Color[] {Color.BLUE, Color.RED, Color.GREEN, Color.BLACK, Color.YELLOW, Color.PINK};
	
	public static void runMenu() {
		
	}
	
	public Menu() {
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
		//TODO: CHANGE TYPE TO "COLOR"
		comboBox.setModel(new DefaultComboBoxModel(availableColors));
		Faction1Panel.add(comboBox);
		//END OF FACTION 1
		
		//FACTION 2
		JPanel Faction2Panel = new JPanel();
		getContentPane().add(Faction2Panel);
		Faction2Panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel Fac2Label = new JLabel("    Faction_2");
		Faction2Panel.add(Fac2Label);
		
		JTextField textField = new JTextField();
		textField.setText("Faction Name");
		textField.setColumns(20);
		Faction2Panel.add(textField);
		
		JLabel label = new JLabel("Stats");
		Faction2Panel.add(label);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(availableColors));
		Faction2Panel.add(comboBox_1);
		//END OF FACTION 2
		
		//FACTION 3
		JPanel Faction3Panel = new JPanel();
		getContentPane().add(Faction3Panel);
		Faction3Panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JRadioButton Fac3Button = new JRadioButton("Faction_3");
		Fac3Button.setSelected(true);
		Faction3Panel.add(Fac3Button);
		
		JTextField textField_1 = new JTextField();
		textField_1.setText("Faction Name");
		textField_1.setColumns(20);
		Faction3Panel.add(textField_1);
		
		JLabel label_1 = new JLabel("Stats");
		Faction3Panel.add(label_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(availableColors));
		Faction3Panel.add(comboBox_2);
		//END OF FACTION 3
		
		//FACTION 4
		JPanel Faction4Panel = new JPanel();
		getContentPane().add(Faction4Panel);
		Faction4Panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JRadioButton Fac4Button = new JRadioButton("Faction_4");
		Fac4Button.setSelected(true);
		Faction4Panel.add(Fac4Button);
		
		JTextField textField_2 = new JTextField();
		textField_2.setText("Faction Name");
		textField_2.setColumns(20);
		Faction4Panel.add(textField_2);
		
		JLabel label_2 = new JLabel("Stats");
		Faction4Panel.add(label_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(availableColors));
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
				
				//TODO: check colours are all different
				//code here
				
				//start game
				World.createFactions(howMany);
				//TODO:close this window
				//code here
			}
		});
		InfoPanel.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		InfoPanel.add(separator);
		
		ErrorTextLabel = new JLabel("    error stuff");
		InfoPanel.add(ErrorTextLabel);
		//END OF INFO PANEL
	}
	
}

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class Menu extends JFrame {
	private JTextField txtFactionName;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public Menu() {
		setTitle("FACTION SIMULATOR");
		getContentPane().setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFactionSimulator = new JLabel("FACTION SIMULATOR");
		lblFactionSimulator.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblFactionSimulator);
		
		JPanel Faction1Panel = new JPanel();
		getContentPane().add(Faction1Panel);
		Faction1Panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JRadioButton rdbtnFaction = new JRadioButton("Faction_1");
		rdbtnFaction.setSelected(true);
		Faction1Panel.add(rdbtnFaction);
		
		txtFactionName = new JTextField();
		txtFactionName.setText("Faction Name");
		Faction1Panel.add(txtFactionName);
		txtFactionName.setColumns(20);
		
		JLabel lblStats = new JLabel("Stats");
		Faction1Panel.add(lblStats);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BLUE", "RED", "GREEN"}));
		Faction1Panel.add(comboBox);
		
		JPanel Faction2Panel = new JPanel();
		getContentPane().add(Faction2Panel);
		Faction2Panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JRadioButton radioButton = new JRadioButton("Faction_1");
		radioButton.setSelected(true);
		Faction2Panel.add(radioButton);
		
		textField = new JTextField();
		textField.setText("Faction Name");
		textField.setColumns(20);
		Faction2Panel.add(textField);
		
		JLabel label = new JLabel("Stats");
		Faction2Panel.add(label);
		
		JComboBox comboBox_1 = new JComboBox();
		Faction2Panel.add(comboBox_1);
		
		JPanel Faction3Panel = new JPanel();
		getContentPane().add(Faction3Panel);
		Faction3Panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JRadioButton radioButton_1 = new JRadioButton("Faction_1");
		radioButton_1.setSelected(true);
		Faction3Panel.add(radioButton_1);
		
		textField_1 = new JTextField();
		textField_1.setText("Faction Name");
		textField_1.setColumns(20);
		Faction3Panel.add(textField_1);
		
		JLabel label_1 = new JLabel("Stats");
		Faction3Panel.add(label_1);
		
		JComboBox comboBox_2 = new JComboBox();
		Faction3Panel.add(comboBox_2);
		
		JPanel Faction4Panel = new JPanel();
		getContentPane().add(Faction4Panel);
		Faction4Panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JRadioButton radioButton_2 = new JRadioButton("Faction_1");
		radioButton_2.setSelected(true);
		Faction4Panel.add(radioButton_2);
		
		textField_2 = new JTextField();
		textField_2.setText("Faction Name");
		textField_2.setColumns(20);
		Faction4Panel.add(textField_2);
		
		JLabel label_2 = new JLabel("Stats");
		Faction4Panel.add(label_2);
		
		JComboBox comboBox_3 = new JComboBox();
		Faction4Panel.add(comboBox_3);
		
		JPanel InfoPanel = new JPanel();
		getContentPane().add(InfoPanel);
		InfoPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnNewButton = new JButton("START");
		InfoPanel.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		InfoPanel.add(separator);
		
		JLabel label_3 = new JLabel(">>");
		InfoPanel.add(label_3);
	}
	
}

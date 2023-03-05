import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Insets;
import javax.swing.JButton;

public class ConverterOtraSolucion {
	public static void main(String[] args) {
		JFrame myJFrame = new JFrame("Conversor");
		myJFrame.setResizable(false);
		myJFrame.setSize(339,208);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{146, 257, 135, 0};
		gridBagLayout.rowHeights = new int[]{35, 0, 0, 0, 34, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		myJFrame.getContentPane().setLayout(gridBagLayout);
		
		JLabel labelSelectConversor = new JLabel("Seleccione una opcion de Conversor");
		labelSelectConversor.setFont(new Font("Georgia", Font.PLAIN, 16));
		GridBagConstraints gbc_labelSelectConversor = new GridBagConstraints();
		gbc_labelSelectConversor.insets = new Insets(0, 0, 5, 5);
		gbc_labelSelectConversor.gridx = 1;
		gbc_labelSelectConversor.gridy = 1;
		myJFrame.getContentPane().add(labelSelectConversor, gbc_labelSelectConversor);
		
		JComboBox boxSelectedConversor = new JComboBox();
		boxSelectedConversor.setFont(new Font("Georgia", Font.PLAIN, 12));
		boxSelectedConversor.setModel(new DefaultComboBoxModel(new String[] {"Conversor Monedas", "Conversor Temperatura"}));
		GridBagConstraints gbc_boxSelectedConversor = new GridBagConstraints();
		gbc_boxSelectedConversor.insets = new Insets(0, 0, 5, 5);
		gbc_boxSelectedConversor.anchor = GridBagConstraints.NORTH;
		gbc_boxSelectedConversor.gridx = 1;
		gbc_boxSelectedConversor.gridy = 3;
		myJFrame.getContentPane().add(boxSelectedConversor, gbc_boxSelectedConversor);
		
		String option = (String) boxSelectedConversor.getModel().getSelectedItem();
		System.out.println(option);

		myJFrame.setVisible(true);
	}
}
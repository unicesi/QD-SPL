package unicesi.driso.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import unicesi.driso.musicstore.kernel.*;

public class PanelOrder extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private MusicStore facadeSystem;
	private final static String ORDER = "order";
	private JComboBox jComboBoxOrder;
	private JButton jButtonOrder;

	public PanelOrder() {
		facadeSystem = MusicStore.getInstance();
		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Order By"));
		this.setPreferredSize(new java.awt.Dimension(294, 121));
		{
			ComboBoxModel jComboBoxOrderModel = new DefaultComboBoxModel(
					getComboBoxModel());
			jComboBoxOrder = new JComboBox();
			this.add(jComboBoxOrder, BorderLayout.NORTH);
			jComboBoxOrder.setModel(jComboBoxOrderModel);
			jComboBoxOrder.setPreferredSize(new java.awt.Dimension(164, 35));
		}
		{
			jButtonOrder = new JButton();
			this.add(jButtonOrder, BorderLayout.SOUTH);
			jButtonOrder.setText("Order Songs");
			jButtonOrder.setActionCommand(ORDER);
			jButtonOrder.addActionListener(this);
			jButtonOrder.setPreferredSize(new java.awt.Dimension(284, 35));
		}
	}

	private String[] getComboBoxModel() {
		String[] model = new String[]{"name", "price", "length", "size",
				"bitRate"};
		return model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals(ORDER)) {
			String attributeName = (String) jComboBoxOrder.getSelectedItem();

			if (attributeName != null && !attributeName.equals("")) {

				if (attributeName.equals("name")) {

					Object[] algorithms = {"Bubble", "Insertion"};
					String option = (String) JOptionPane.showInputDialog(this,
							"Ordering Algorithm:\n", "",
							JOptionPane.PLAIN_MESSAGE, null, algorithms,
							"Bubble");

					if (option != null) {
						if (option.equals(algorithms[0])) {
							facadeSystem.bubbleSortByName();
						} else if (option.equals(algorithms[1])) {
							facadeSystem.insertionSortByName();
						}
					}

				}

				if (attributeName.equals("price")) {

					Object[] algorithms = {"Bubble", "Insertion"};
					String option = (String) JOptionPane.showInputDialog(this,
							"Ordering Algorithm:\n", "",
							JOptionPane.PLAIN_MESSAGE, null, algorithms,
							"Bubble");

					if (option != null) {
						if (option.equals(algorithms[0])) {
							facadeSystem.bubbleSortByPrice();
						} else if (option.equals(algorithms[1])) {
							facadeSystem.insertionSortByPrice();
						}
					}

				}

				if (attributeName.equals("length")) {

					Object[] algorithms = {"Bubble", "Insertion"};
					String option = (String) JOptionPane.showInputDialog(this,
							"Ordering Algorithm:\n", "",
							JOptionPane.PLAIN_MESSAGE, null, algorithms,
							"Bubble");

					if (option != null) {
						if (option.equals(algorithms[0])) {
							facadeSystem.bubbleSortByLength();
						} else if (option.equals(algorithms[1])) {
							facadeSystem.insertionSortByLength();
						}
					}

				}

				if (attributeName.equals("size")) {

					Object[] algorithms = {"Bubble", "Insertion"};
					String option = (String) JOptionPane.showInputDialog(this,
							"Ordering Algorithm:\n", "",
							JOptionPane.PLAIN_MESSAGE, null, algorithms,
							"Bubble");

					if (option != null) {
						if (option.equals(algorithms[0])) {
							facadeSystem.bubbleSortBySize();
						} else if (option.equals(algorithms[1])) {
							facadeSystem.insertionSortBySize();
						}
					}

				}

				if (attributeName.equals("bitRate")) {

					Object[] algorithms = {"Bubble", "Insertion"};
					String option = (String) JOptionPane.showInputDialog(this,
							"Ordering Algorithm:\n", "",
							JOptionPane.PLAIN_MESSAGE, null, algorithms,
							"Bubble");

					if (option != null) {
						if (option.equals(algorithms[0])) {
							facadeSystem.bubbleSortByBitRate();
						} else if (option.equals(algorithms[1])) {
							facadeSystem.insertionSortByBitRate();
						}
					}

				}

			}

		}
	}

}

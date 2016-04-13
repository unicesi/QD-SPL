package unicesi.driso.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import unicesi.driso.musicstore.kernel.*;

public class DialogCreate extends JDialog implements ActionListener {

	{
		try {
			javax.swing.UIManager.setLookAndFeel(UIManager
					.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final long serialVersionUID = 1L;

	private final static String ADD = "Create Song";

	private JLabel labelName;
	private JTextField textFieldName;

	private JLabel labelPrice;
	private JTextField textFieldPrice;

	private JLabel labelLength;
	private JTextField textFieldLength;

	private JLabel labelSize;
	private JTextField textFieldSize;

	private JLabel labelBitRate;
	private JTextField textFieldBitRate;

	private JPanel panelData;

	private JButton buttonAdd;

	private MusicStore facadeSystem;

	public DialogCreate(SystemGUI gui) {
		super(gui, true);
		facadeSystem = MusicStore.getInstance();
		setTitle("Create Song");
		setLayout(new java.awt.BorderLayout());
		panelData = new JPanel();
		panelData.setBorder(new TitledBorder("Information"));
		panelData.setLayout(new GridLayout(5, 2));
		add(panelData, BorderLayout.NORTH);

		labelName = new JLabel("Name:");
		panelData.add(labelName);
		textFieldName = new JTextField();
		panelData.add(textFieldName);

		labelPrice = new JLabel("Price:");
		panelData.add(labelPrice);
		textFieldPrice = new JTextField();
		panelData.add(textFieldPrice);

		labelLength = new JLabel("Length:");
		panelData.add(labelLength);
		textFieldLength = new JTextField();
		panelData.add(textFieldLength);

		labelSize = new JLabel("Size:");
		panelData.add(labelSize);
		textFieldSize = new JTextField();
		panelData.add(textFieldSize);

		labelBitRate = new JLabel("BitRate:");
		panelData.add(labelBitRate);
		textFieldBitRate = new JTextField();
		panelData.add(textFieldBitRate);

		panelData.setPreferredSize(new Dimension(200, 40 * 5));
		buttonAdd = new JButton(ADD);
		buttonAdd.setActionCommand(ADD);
		buttonAdd.addActionListener(this);
		add(buttonAdd, BorderLayout.SOUTH);
		buttonAdd.setPreferredSize(new java.awt.Dimension(200, 28));
		pack();
		setLocationRelativeTo(null);
	}

	public boolean addSong(Song value) {
		return facadeSystem.add(value);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(ADD)) {
			try {
				Song value = new Song();

				String nName = textFieldName.getText();
				value.setName(nName);

				String nPrice = textFieldPrice.getText();
				value.setPrice(nPrice);

				String nLength = textFieldLength.getText();
				value.setLength(nLength);

				String nSize = textFieldSize.getText();
				value.setSize(nSize);

				String nBitRate = textFieldBitRate.getText();
				value.setBitRate(nBitRate);

				if (addSong(value)) {
					dispose();
				} else {
					JOptionPane.showMessageDialog(this,
							"Record already exists.", "Create Add Song",
							JOptionPane.ERROR_MESSAGE);
				}
				return;
			} catch (NumberFormatException ne) {
				JOptionPane.showMessageDialog(this,
						"Not a valid number format.", "Create Add Song",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}

}

package unicesi.driso.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.util.Observable;
import java.util.Observer;

import unicesi.driso.musicstore.kernel.*;

public class PanelInfoSingle extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;

	private JPanel panelInformation;

	private JLabel labelName;

	private JLabel labelPrice;

	private JLabel labelLength;

	private JLabel labelSize;

	private JLabel labelBitRate;

	private MusicStore facadeSystem;

	public PanelInfoSingle() {
		facadeSystem = MusicStore.getInstance();
		facadeSystem.addObserver(this);
		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Song Information"));
		panelInformation = new JPanel();
		initPanelInformation();
		add(panelInformation, BorderLayout.NORTH);
	}

	private void initPanelInformation() {
		GridLayout layout = new GridLayout(7, 2);
		layout.setVgap(7);
		panelInformation.setLayout(layout);
		panelInformation.setBackground(Color.WHITE);
		initializeComponents();
	}

	private void initializeComponents() {

		labelName = new JLabel("Name:");
		panelInformation.add(labelName);

		labelPrice = new JLabel("Price:");
		panelInformation.add(labelPrice);

		labelLength = new JLabel("Length:");
		panelInformation.add(labelLength);

		labelSize = new JLabel("Size:");
		panelInformation.add(labelSize);

		labelBitRate = new JLabel("BitRate:");
		panelInformation.add(labelBitRate);

	}

	@Override
	public void update(Observable o, Object arg) {
		updateInfo();
	}

	public void updateInfo() {
		Song value = facadeSystem.getSelectedElement();
		if (value != null) {

			labelName.setText("name: " + value.getName());

			labelPrice.setText("price: " + value.getPrice());

			labelLength.setText("length: " + value.getLength());

			labelSize.setText("size: " + value.getSize());

			labelBitRate.setText("bitRate: " + value.getBitRate());

		}
	}
}

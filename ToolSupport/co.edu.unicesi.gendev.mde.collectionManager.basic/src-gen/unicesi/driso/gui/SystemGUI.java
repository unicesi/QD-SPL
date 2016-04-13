package unicesi.driso.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class SystemGUI extends JFrame {
	{
		try {
			javax.swing.UIManager.setLookAndFeel(UIManager
					.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final long serialVersionUID = 1L;

	private PanelInfoSingle panelInfoSingle;

	private PanelList panelList;

	private PanelOrder panelOrder;

	private PanelTitle panelTitle;

	public SystemGUI() {
		try {
			getContentPane().setLayout(new BorderLayout());
			setSize(700, 500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("MusicStore");
			JPanel panelCentral = new JPanel(new BorderLayout());
			panelTitle = new PanelTitle();
			add(panelTitle, BorderLayout.NORTH);

			panelInfoSingle = new PanelInfoSingle();
			panelCentral.add(panelInfoSingle, BorderLayout.CENTER);

			JPanel containerFilterAndOrder = new JPanel(new GridLayout(2, 1));

			panelOrder = new PanelOrder();
			containerFilterAndOrder.add(panelOrder);

			panelCentral.add(containerFilterAndOrder, BorderLayout.SOUTH);

			panelList = new PanelList(this);
			add(panelList, BorderLayout.WEST);

			add(panelCentral, BorderLayout.CENTER);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SystemGUI gui = new SystemGUI();
		gui.setVisible(true);
	}
}

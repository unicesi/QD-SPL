package unicesi.driso.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import unicesi.driso.musicstore.kernel.*;

public class PanelList extends JPanel
		implements
			ActionListener,
			ListSelectionListener,
			Observer {
	private static final long serialVersionUID = 1L;

	private final static String ADD = "Add Song";
	private SystemGUI gui;
	private JList list;

	private JButton buttonAdd;

	private MusicStore facadeSystem;

	public PanelList(SystemGUI gui) {
		this.gui = gui;
		facadeSystem = MusicStore.getInstance();
		facadeSystem.addObserver(this);
		setLayout(new BorderLayout());
		TitledBorder border = new TitledBorder("Songs");
		JPanel listPanel = new JPanel();
		listPanel.setBorder(border);
		listPanel.setLayout(new BorderLayout());
		list = new JList();
		list.addListSelectionListener(this);
		listPanel.add(list, BorderLayout.CENTER);

		buttonAdd = new JButton(ADD);
		buttonAdd.setActionCommand(ADD);
		buttonAdd.addActionListener(this);
		buttonAdd.setPreferredSize(new java.awt.Dimension(284, 35));
		listPanel.add(buttonAdd, BorderLayout.SOUTH);

		add(listPanel, BorderLayout.CENTER);
	}

	@Override
	public void update(Observable o, Object arg) {
		updateList();
	}

	private void updateList() {
		ArrayList<Song> values = facadeSystem.getElements();
		DataListElement[] elements = new DataListElement[values.size()];
		int i = 0;
		for (Iterator<Song> iterator = values.iterator(); iterator.hasNext(); i++) {
			Song element = iterator.next();
			DataListElement data = new DataListElement(element);
			elements[i] = data;
		}
		list.setListData(elements);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals(ADD)) {
			DialogCreate dialogCreate = new DialogCreate(gui);
			dialogCreate.setVisible(true);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList list = (JList) e.getSource();
		Object[] dataList = list.getSelectedValues();
		if (dataList != null && dataList.length > 0) {
			DataListElement selected = (DataListElement) dataList[0];
			facadeSystem.setSelectedElement(selected.getElement());
		}
	}
}

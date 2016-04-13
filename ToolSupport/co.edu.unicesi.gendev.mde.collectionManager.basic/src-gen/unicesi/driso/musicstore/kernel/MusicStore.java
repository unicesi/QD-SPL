package unicesi.driso.musicstore.kernel;

import java.util.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class MusicStore extends Observable {

	private ArrayList<Song> elements;
	private Song selectedElement;
	private static MusicStore instance;

	private MusicStore() {
		this.selectedElement = null;
		this.elements = new ArrayList<Song>();
	}

	public static MusicStore getInstance() {
		if (instance == null) {
			instance = new MusicStore();
		}
		return instance;
	}

	public boolean add(Song value) {
		boolean result = false;
		if (findSongByID(value) == null) {
			this.elements.add(value);
			result = true;
		}
		setChanged();
		notifyObservers();
		return result;
	}

	public ArrayList<Song> getElements() {
		ArrayList<Song> elementsCopy = new ArrayList<Song>(elements);
		return elementsCopy;
	}

	public void setSelectedElement(Song selectedElement) {
		this.selectedElement = selectedElement;
		setChanged();
		notifyObservers();
	}

	public Song getSelectedElement() {
		return this.selectedElement;
	}

	public Song findSongByID(Song searchedElement) {
		boolean found = false;
		Song element = null;
		for (Iterator<Song> iterator = elements.iterator(); iterator.hasNext()
				&& !found;) {
			element = iterator.next();
			if (element.getName().equals(searchedElement.getName())) {
				found = true;
			}
		}

		if (!found) {
			element = null;
		}
		return element;
	}

	public void bubbleSortByName() {
		Song[] objects = getElements().toArray(new Song[elements.size()]);
		for (int i = 0; i < objects.length; i++) {
			for (int j = i + 1; j < objects.length; j++) {
				if (objects[i].getName().compareTo(objects[j].getName()) > 0) {
					swap(objects, i, j);
				}
			}
		}
		elements = new ArrayList<Song>(Arrays.asList(objects));
		setChanged();
		notifyObservers();
	}

	public void bubbleSortByPrice() {
		Song[] objects = getElements().toArray(new Song[elements.size()]);
		for (int i = 0; i < objects.length; i++) {
			for (int j = i + 1; j < objects.length; j++) {
				if (objects[i].getPrice().compareTo(objects[j].getPrice()) > 0) {
					swap(objects, i, j);
				}
			}
		}
		elements = new ArrayList<Song>(Arrays.asList(objects));
		setChanged();
		notifyObservers();
	}

	public void bubbleSortByLength() {
		Song[] objects = getElements().toArray(new Song[elements.size()]);
		for (int i = 0; i < objects.length; i++) {
			for (int j = i + 1; j < objects.length; j++) {
				if (objects[i].getLength().compareTo(objects[j].getLength()) > 0) {
					swap(objects, i, j);
				}
			}
		}
		elements = new ArrayList<Song>(Arrays.asList(objects));
		setChanged();
		notifyObservers();
	}

	public void bubbleSortBySize() {
		Song[] objects = getElements().toArray(new Song[elements.size()]);
		for (int i = 0; i < objects.length; i++) {
			for (int j = i + 1; j < objects.length; j++) {
				if (objects[i].getSize().compareTo(objects[j].getSize()) > 0) {
					swap(objects, i, j);
				}
			}
		}
		elements = new ArrayList<Song>(Arrays.asList(objects));
		setChanged();
		notifyObservers();
	}

	public void bubbleSortByBitRate() {
		Song[] objects = getElements().toArray(new Song[elements.size()]);
		for (int i = 0; i < objects.length; i++) {
			for (int j = i + 1; j < objects.length; j++) {
				if (objects[i].getBitRate().compareTo(objects[j].getBitRate()) > 0) {
					swap(objects, i, j);
				}
			}
		}
		elements = new ArrayList<Song>(Arrays.asList(objects));
		setChanged();
		notifyObservers();
	}

	public void insertionSortByName() {
		Song[] objects = getElements().toArray(new Song[elements.size()]);
		for (int i = 0; i < objects.length; i++) {
			for (int j = i; j > 0; j--) {
				if (objects[j - 1].getName().compareTo(objects[j].getName()) > 0) {
					swap(objects, j - 1, j);
				}
			}
		}
		elements = new ArrayList<Song>(Arrays.asList(objects));
		setChanged();
		notifyObservers();
	}

	public void insertionSortByPrice() {
		Song[] objects = getElements().toArray(new Song[elements.size()]);
		for (int i = 0; i < objects.length; i++) {
			for (int j = i; j > 0; j--) {
				if (objects[j - 1].getPrice().compareTo(objects[j].getPrice()) > 0) {
					swap(objects, j - 1, j);
				}
			}
		}
		elements = new ArrayList<Song>(Arrays.asList(objects));
		setChanged();
		notifyObservers();
	}

	public void insertionSortByLength() {
		Song[] objects = getElements().toArray(new Song[elements.size()]);
		for (int i = 0; i < objects.length; i++) {
			for (int j = i; j > 0; j--) {
				if (objects[j - 1].getLength()
						.compareTo(objects[j].getLength()) > 0) {
					swap(objects, j - 1, j);
				}
			}
		}
		elements = new ArrayList<Song>(Arrays.asList(objects));
		setChanged();
		notifyObservers();
	}

	public void insertionSortBySize() {
		Song[] objects = getElements().toArray(new Song[elements.size()]);
		for (int i = 0; i < objects.length; i++) {
			for (int j = i; j > 0; j--) {
				if (objects[j - 1].getSize().compareTo(objects[j].getSize()) > 0) {
					swap(objects, j - 1, j);
				}
			}
		}
		elements = new ArrayList<Song>(Arrays.asList(objects));
		setChanged();
		notifyObservers();
	}

	public void insertionSortByBitRate() {
		Song[] objects = getElements().toArray(new Song[elements.size()]);
		for (int i = 0; i < objects.length; i++) {
			for (int j = i; j > 0; j--) {
				if (objects[j - 1].getBitRate().compareTo(
						objects[j].getBitRate()) > 0) {
					swap(objects, j - 1, j);
				}
			}
		}
		elements = new ArrayList<Song>(Arrays.asList(objects));
		setChanged();
		notifyObservers();
	}

	private void swap(Object[] objects, int i, int j) {
		Object temp = objects[i];
		objects[i] = objects[j];
		objects[j] = temp;
	}

}

package unicesi.driso.gui;

import unicesi.driso.musicstore.kernel.*;

public class DataListElement {
	private Song element;

	public DataListElement(Song element) {
		this.element = element;
	}

	public Song getElement() {
		return this.element;
	}

	public String toString() {
		String result = element.getName();
		return result;
	}
}

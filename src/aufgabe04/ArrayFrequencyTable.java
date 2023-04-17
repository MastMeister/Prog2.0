package aufgabe04;

/**
 *
 * @author oliverbittel
 * @since 25.03.2021
 */

import java.util.Arrays;
public class ArrayFrequencyTable<T> extends AbstractFrequencyTable<T> {
	private int size;
	private Word[] fqTable;
	private final int DEFAULT_SIZE = 100;

	public ArrayFrequencyTable() {
        clear();
    }
	
	@Override
	public int size() {
		// throw muss noch auskommentiert werden!
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code:
		/*int i = 0;
		while(this.fqTable[i] != null) // vielleicht obsolet
			i++;
		this.size = i;
		*/
		return this.size;
	}

	@Override
	public final void clear() {
		// throw muss noch auskommentiert werden!
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code: 
		// ...
		;
		this.size = 0;
		this.fqTable = new Word[DEFAULT_SIZE];
	}



	@Override
	public void add(T w, int f) {
		// throw muss noch auskommentiert werden!
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code: 
		// ...
		//this.fqTable
		if(f<1)
			return;
		// wenn array voll ist erweitern :
		if(this.size() == this.fqTable.length){
			this.fqTable= Arrays.copyOf(this.fqTable,2*this.size()); // bessere kopie wenn import erlaubt
/*
			Word[] temp2 = new Word[this.size()*2]; // falls import nicht erlaubt
			for (int j = 0; j < this.size(); j++) {
				temp2[j] = this.fqTable[j];
			}
			this.fqTable = temp2.clone();
*/
		}

		if (this.isEmpty()) {//Wenn array leer ist ist an 1ste stelle des Arrays setzten
			this.fqTable[0] = new Word(w, f);
			this.size++;
			return;
		}
		// wenn wort schon vorhanden ist erhöhen und dann sortieren
		for (int l = 0; l< this.size();l++) {
			if (this.fqTable[l].getWord().equals(w)) {
				this.fqTable[l].addFrequency(f);
				moveToLeft(l);
				return;
			}
		}
		// wenn nicht vorhanden richtig einfügen
		int b = size();
		this.fqTable[b] = new Word(w,f);
		this.size++;
		moveToLeft(b);

	} // METHODE um Wort an die richtige stelle zu bringen
	public void moveToLeft(int pos){
		Word w = this.fqTable[pos];
		int i = pos -1;

		while (i >= 0 && this.fqTable[i].getFrequency() < w.getFrequency()) {
				this.fqTable[i + 1] = this.fqTable[i];
				i--;
		}

		this.fqTable[i+1] = w;

	}

	@Override
	public Word get(int pos) {
		// throw muss noch auskommentiert werden!
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code: 
		// ...
		if(pos<0 || pos >=size())
			return null;
		return this.fqTable[pos];


	}

	@Override
	public int get(T w) {
		// throw muss noch auskommentiert werden!
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		// Ihr Code: 
		// ...
		for (int l = 0; l< this.size();l++) {
			if (this.fqTable[l].getWord().equals(w)) {
				return this.fqTable[l].getFrequency();
			}
		}

		return 0;
	}
}

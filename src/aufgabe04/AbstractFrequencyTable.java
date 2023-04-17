package aufgabe04;

/**
 *
 * @author oliverbittel
 * @since 22.2.2019
 */
public abstract class AbstractFrequencyTable<T> implements FrequencyTable<T> {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	@Override
	public void add(T w) {
      add(w,1);
    }


	@Override
	public void addAll(FrequencyTable fq) {
		//code
		for (int i = 0;i< fq.size();i++){
			this.add((T) fq.get(i).getWord(), fq.get(i).getFrequency());
		}
		
	}

	@Override
	public void collectMostFrequent(FrequencyTable fq) {
		// Ihr Code:
		fq.clear();
		if(this.isEmpty())
			return;
			int fqTemp = this.get(0).getFrequency();
			fq.add((T) this.get(0).getWord(),this.get(0).getFrequency());
			int i = 0;
			while (this.get(0).getFrequency() == this.get(i+1).getFrequency() &&
					i < this.size()-2) {
				fq.add((T) this.get(i+1).getWord(), this.get(i+1).getFrequency());
				i++;
			}


	}

	@Override
	public void collectLeastFrequent(FrequencyTable fq) {
		// Ihr Code:
		// fügt dem array fq die wenigst häufigen wörter zu (von rechts nach links)
		fq.clear();
		if(this.isEmpty())
			return;
			int posStart = this.size() -1;
			fq.add((T) this.get(posStart).getWord(),this.get(posStart).getFrequency()); // ich finde so besser logischer
			int i = posStart;
			while (i > 1 && this.get(i).getFrequency() == this.get(i-1).getFrequency()) {
				fq.add((T) this.get(i-1).getWord(), this.get(i-1).getFrequency());
				i--;
			}
			//fq.add(this.get(posStart).getWord(),this.get(posStart).getFrequency()); // nur für test

	}

	/**
	 * Liefert eine String-Darstellung zur&uuml;ck.
	 * @return String-Darstellung.
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("");


		// Ihr Code:
		for (int i =0; i<this.size();i++){
			s.append(this.get(i).toString());
		}
			s.append(" size : " + this.size());
		return s.toString();
	}
}

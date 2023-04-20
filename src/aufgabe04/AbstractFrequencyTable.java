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
	public void addAll(FrequencyTable<? extends T>fq) {
		//code
		for (var x : fq){
			add(x.getElement(), x.getFrequency());
		}

	}

	@Override
	public void collectMostFrequent(FrequencyTable<? super T> fq) {
		// Ihr Code:
		fq.clear();
		if(!this.isEmpty()){
			int a = get(0).getFrequency();
			for(var x : this){
				if(x.getFrequency()==a)
					fq.add(x.getElement(), x.getFrequency());
			}
		}
	}


	@Override
	public void collectLeastFrequent(FrequencyTable<? super T> fq) {
		// Ihr Code:
		// fügt dem array fq die wenigst häufigen wörter zu (von rechts nach links)
		fq.clear();
		if(this.isEmpty())
			return;
		int a = get(size()-1).getFrequency();
		for(var x : this){
			if(x.getFrequency() == a)
				fq.add(x.getElement(), x.getFrequency());
		}
	}
		//fq.add(this.get(posStart).getWord(),this.get(posStart).getFrequency()); // nur für test

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

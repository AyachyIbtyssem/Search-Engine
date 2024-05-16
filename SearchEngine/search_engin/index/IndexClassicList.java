package search_engin.index;
import java.util.*;

import search_engin.statistics.Statistic;
public class IndexClassicList implements Index{
	private List<Statistic> listeDesStat;
	public IndexClassicList() {
		listeDesStat= new ArrayList<>();
	}
	public List<Statistic> getIndex(){
		return this.listeDesStat;
	}
	public List<Statistic> getStatMot(String mot){
		List<Statistic> result = new ArrayList<>();
		for(Statistic stat :listeDesStat) {
			if(stat.getMot().equals(mot))
				result.add(stat);
		}
		return result;
	}
	public void ajouterStat(String word, String filePath, int occurrence) {
		listeDesStat.add(new Statistic(word,occurrence,filePath));
	}
	public void removeFile(String path) {
		Iterator<Statistic> iterator = listeDesStat.iterator();
		while (iterator.hasNext()) {
			Statistic stat = iterator.next();
			if (stat.getPath().equals(path)) {
				iterator.remove(); // Safely remove the element using the iterator
			}
		}
	}
}

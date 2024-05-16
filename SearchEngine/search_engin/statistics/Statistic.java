package search_engin.statistics;
public class Statistic {
	private String word;
	private int occ;
	private String path;
	public Statistic(String word,int occ,String path) {
		this.word=word;
		this.occ=occ;
		this.path=path;
	}
	public String getMot() {
		return this.word;
	}
	public int getOcc() {
		return this.occ;
	}
	public String getPath() {
		return this.path;
	}
	public String toString() {
        return "[ word: " + word + ", occ: " + occ + ", path: " +path+"]\n";
	}
}

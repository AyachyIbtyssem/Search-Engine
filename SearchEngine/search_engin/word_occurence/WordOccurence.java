package search_engin.word_occurence;
public class WordOccurence implements Comparable<WordOccurence> {
    private String word;
    private int occ;

    public WordOccurence(String word, int occ) {
        this.word = word;
        this.occ = occ;
    }
    public String getWord() {
        return word;
    }
    public int getOcc() {
        return occ;
    }
    public void incrementer() {
        occ += 1;
    }
    public int compareTo(WordOccurence other) {
        return this.word.compareToIgnoreCase(other.getWord());
    }
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordOccurence wordOcc = (WordOccurence) o;
        return word.equals(wordOcc.word);
    }
    public int hashCode() {
        return word.hashCode();
    }
    public String toString() {
        return "[ word: " + word + ", occ: " + occ + " ]\n";
    }
}
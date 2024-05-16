package search_engin.traiteur;

import java.util.*;

public class TraiteurUnimportantWordRemover implements Traiteur {
    private static final Set<String> unimportantWord = new HashSet<>(Arrays.asList(
        "a", "an", "and", "the", "it", "he", "she", "they", "this", "that", "there",
        "is", "are", "was", "were", "has", "have", "had", "to", "for", "of", "in",
        "on", "at", "with", "by", "from", "as", "or", "but", "not", "also", "just",
        "only","le", "la", "l'", "de", "pour", "comme", "et", "est", "c'est", "quand", "avec"));
    public List<String> traiter(List<String> listeMots) {
        List<String> filteredList = new ArrayList<>();
        for (String mot : listeMots) {
            if (!isUnimportantWord(mot)) {
                filteredList.add(mot);
            }
            }
        return filteredList;
    }
        
    public void addUnimportantWord(String word) {
        unimportantWord.add(word.toLowerCase());
    }
    public void removeUnimportantWord(String word) {
        unimportantWord.remove(word.toLowerCase());
    }
    private boolean isUnimportantWord(String word) {
        return unimportantWord.contains(word.toLowerCase());
    }
    public Set<String> getUnimportantWord(){
        return unimportantWord;
    }
}

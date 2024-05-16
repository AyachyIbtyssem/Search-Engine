package search_engin.analyseur;
import java.util.*;

import search_engin.word_occurence.WordOccurence;
public class AnalyseurHashMapVersion implements Analyseur{
    public List<WordOccurence> analyser(List<String> listeMots) {
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String mot : listeMots) {
            wordCounts.put(mot, wordCounts.getOrDefault(mot, 0) + 1);
        }
        List<WordOccurence> listeDesMotOcc = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            listeDesMotOcc.add(new WordOccurence(entry.getKey(), entry.getValue()));
        }
        return listeDesMotOcc;
    }
}

package search_engin.analyseur;
import java.util.List;

import search_engin.word_occurence.WordOccurence;

import java.util.ArrayList;
public class AnalyseurSortedListVersion implements Analyseur{
    public List<WordOccurence> analyser(List<String> sortedListeMots) {
        List<WordOccurence> listeDesMotOcc = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < sortedListeMots.size(); i++) {
            if (i > 0 && sortedListeMots.get(i).equals(sortedListeMots.get(i - 1))) {
                listeDesMotOcc.get(index).incrementer();
            } 
            else {
                index++;
                listeDesMotOcc.add(new WordOccurence(sortedListeMots.get(i), 1));
            }
        }
        return listeDesMotOcc;
    }
}
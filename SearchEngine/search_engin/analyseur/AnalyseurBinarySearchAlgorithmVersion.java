package search_engin.analyseur;
import java.util.*;
import search_engin.word_occurence.WordOccurence;
public class AnalyseurBinarySearchAlgorithmVersion implements Analyseur{
    public List<WordOccurence> analyser(List<String> listeWord) {
        List<WordOccurence> listeDesMotOcc = new ArrayList<>();
        int index;
        for (String word : listeWord) {
            WordOccurence tempWordOccurence = new WordOccurence(word, 1);
            index = search(listeDesMotOcc, tempWordOccurence);
            if (index < 0) {
                index = -(index + 1);
                if (index < listeDesMotOcc.size()) {
                    listeDesMotOcc.add(index, tempWordOccurence);
                } else {
                    listeDesMotOcc.add(tempWordOccurence);
                }
            } else {
                listeDesMotOcc.get(index).incrementer();
            }
        }
        return listeDesMotOcc;
    }
    private int search(List<WordOccurence> sortedList, WordOccurence target){
        int low = 0;
        int high = sortedList.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            WordOccurence midElement = sortedList.get(mid);
            int comparisonResult = midElement.compareTo(target);
            if (comparisonResult == 0) {
                return mid;
            } else if (comparisonResult < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
     
}

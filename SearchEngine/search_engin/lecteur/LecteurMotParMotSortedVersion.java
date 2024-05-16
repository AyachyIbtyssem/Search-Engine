package search_engin.lecteur;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class LecteurMotParMotSortedVersion implements Lecteur {
    public List<String> lire(String chemin) {
        List<String> words = new ArrayList<>();
        BufferedReader br = null;
        try {
            String currentLine;
            br = new BufferedReader(new FileReader(chemin));
            while ((currentLine = br.readLine()) != null) {
                String[] sentenceWords = currentLine.split(" ");
                for (String word : sentenceWords) {
                    insertSorted(words, word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return words;
    }

    private void insertSorted(List<String> list, String word) {
        int index = search(list, word);
        if (index < 0) {
            index = -(index + 1); // Calculate the insertion point
        }
        if (index < list.size()) {
            list.add(index, word);
        } else {
            list.add(word);
        }
    }
    private int search(List<String> sortedList, String target){
        int low = 0;
        int high = sortedList.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midElement = sortedList.get(mid);
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


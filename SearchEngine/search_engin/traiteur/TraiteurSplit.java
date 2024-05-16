package search_engin.traiteur;
import java.util.ArrayList;
import java.util.List;
public class TraiteurSplit implements Traiteur {
    public  List<String> traiter(List<String> sentences) {
        List<String> words = new ArrayList<>();
        for (String sentence : sentences) {
            String[] sentenceWords = sentence.split("\\s+"); // Split by space
            for (String word : sentenceWords){
                if (!word.isEmpty())
                    words.add(word);
            }
        }
        return words;
    }
}

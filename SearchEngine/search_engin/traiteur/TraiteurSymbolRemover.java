package search_engin.traiteur;
import java.util.ArrayList;
import java.util.List;

public class TraiteurSymbolRemover implements Traiteur {
    private String symbolsToRemove;
    public TraiteurSymbolRemover(String symbolsToRemove){
        this.symbolsToRemove = symbolsToRemove;
    }
    public List<String> traiter(List<String> wordList) {
        List<String> processedList = new ArrayList<>();
        for (String word : wordList) {
            String processedWord = word;
            for (char c : symbolsToRemove.toCharArray()) {
                processedWord = processedWord.replace(String.valueOf(c), "");
            }
            if (!processedWord.isEmpty()) {
                processedList.add(processedWord);
            }
        }
        return processedList;
    }
    
    }

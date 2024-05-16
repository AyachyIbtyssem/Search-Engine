package search_engin.traiteur;
import java.util.ArrayList;
import java.util.List;
public class TraiteurLowerCast implements Traiteur{
	    public List<String> traiter(List<String> words) {
    		List<String> processedList = new ArrayList<>();
    		for (String word : words) {
        		processedList.add(word.toLowerCase());
    		}
    	return processedList;
	}

}
package search_engin.analyseur;
import java.util.List;

import search_engin.word_occurence.WordOccurence;

public interface Analyseur {
	 List<WordOccurence> analyser( List<String> listeMots);

}
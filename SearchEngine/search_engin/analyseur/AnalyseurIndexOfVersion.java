package search_engin.analyseur;
import java.util.ArrayList;
import java.util.List;

import search_engin.word_occurence.WordOccurence;
public class AnalyseurIndexOfVersion implements  Analyseur {
	public   List<WordOccurence> analyser ( List<String> motList) {
		List<WordOccurence> motOccList = new ArrayList<>();
        int  pos;
		WordOccurence test;
		for (String mot : motList) {
			test =new WordOccurence(mot,0);
		    pos = motOccList.indexOf(test);
		        if (pos == -1) {
		            motOccList.add(new WordOccurence(mot,1)); 
		            } 
                else {	
					 
		    	    motOccList.get(pos).incrementer();
                }
        }
        return motOccList;
	}
}
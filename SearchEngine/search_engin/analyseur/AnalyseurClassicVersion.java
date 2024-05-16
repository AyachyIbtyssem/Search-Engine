package search_engin.analyseur;
import java.util.List;
import search_engin.word_occurence.WordOccurence;

import java.util.ArrayList;
public class AnalyseurClassicVersion implements Analyseur{

	public List<WordOccurence> analyser( List<String> listeMots){
		List<WordOccurence> listeDesMotOcc=new ArrayList<>();
		int position;
		for(String word: listeMots){
			WordOccurence tempWordOccurence = new WordOccurence(word, 0);
			position = search(listeDesMotOcc, tempWordOccurence);
			if(position == -1)
				listeDesMotOcc.add(new WordOccurence(word,1));
			else
				listeDesMotOcc.get(position).incrementer();
		}
		return listeDesMotOcc;
	}
	public int search(List<WordOccurence> list, WordOccurence target){
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(target)){
                return i;
            }
        }
        return -1;
    }
}
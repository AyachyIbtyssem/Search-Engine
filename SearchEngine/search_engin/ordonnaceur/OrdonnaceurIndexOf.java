package search_engin.ordonnaceur;
import search_engin.statistics.*;
import search_engin.file_score.*;

import java.util.ArrayList;
import java.util.List;
public class OrdonnaceurIndexOf implements Ordonnanceur{
    public List<FileScore> calculerScore(List<Statistic> statistics){
		int  pos;
		List<FileScore> fileScores = new ArrayList<>();
		FileScore test;
		for (Statistic stat : statistics) {
			test =new FileScore(stat.getPath(),0.0);
		    pos = fileScores.indexOf(test);
		        if (pos == -1) {
		            fileScores.add(new FileScore(stat.getPath(), (double)stat.getOcc())); 
		            } 
                else {	
		    	    fileScores.get(pos).incrementScore((double)stat.getOcc());
                }
        }
        return fileScores;
	}
}

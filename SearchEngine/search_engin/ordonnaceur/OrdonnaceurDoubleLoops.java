package search_engin.ordonnaceur;
import search_engin.statistics.*;
import search_engin.file_score.*;
import java.util.*;
public class OrdonnaceurDoubleLoops implements Ordonnanceur{
    public List<FileScore> calculerScore(List<Statistic> statistics){
		List<FileScore> fileScores = new ArrayList<>();
		for(Statistic stat : statistics){
			boolean motExist=false;
			for(FileScore existanceFileScore :fileScores) {
				if(existanceFileScore.getFilePath().equals(stat.getPath())) {
					motExist=true;
					existanceFileScore.incrementScore(stat.getOcc());
					break;
				}
			}
			if(!motExist)
                fileScores.add(new FileScore(stat.getPath(),(double)stat.getOcc()));
		}
		return fileScores;
    }
}
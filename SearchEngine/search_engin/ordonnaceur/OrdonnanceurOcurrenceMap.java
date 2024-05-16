package search_engin.ordonnaceur;
import java.util.*;
import search_engin.file_score.FileScore;
import search_engin.statistics.*;
public class OrdonnanceurOcurrenceMap implements Ordonnanceur{
	public  List<FileScore> calculerScore(List<Statistic> statics){
        Map<String, Double> fileScore = new HashMap<>();
        List<FileScore> result = new ArrayList<>();
        for (Statistic s : statics) {
            fileScore.put(s.getPath(), fileScore.getOrDefault(s.getPath(), (double) 0) + s.getOcc());
        }
        for (Map.Entry<String,Double> entry : fileScore.entrySet()) {
            result.add(new FileScore(entry.getKey(),entry.getValue()));
        }
        return result;
    }
}
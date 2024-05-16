package search_engin.ordonnaceur;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import search_engin.file_score.FileScore;
import search_engin.statistics.*;
public class OrdonnanceurExistanceWords implements Ordonnanceur{
    public  List<FileScore> calculerScore(List<Statistic> statics){
        List<FileScore> result = new ArrayList<>();
        Map<String, Double> fileScore = new HashMap<>();
        for (Statistic s : statics) {
            fileScore.put(s.getPath(), fileScore.getOrDefault(s.getPath(), (double) 0) + 1);
        }
        for (Map.Entry<String,Double> entry : fileScore.entrySet()) {
            result.add(new FileScore(entry.getKey(),entry.getValue()));
        }
        return result;
    }

}

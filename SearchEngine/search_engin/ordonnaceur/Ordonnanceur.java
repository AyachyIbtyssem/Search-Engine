package search_engin.ordonnaceur;
import java.util.List;
import search_engin.file_score.FileScore;
import search_engin.statistics.Statistic;
public interface Ordonnanceur {
    public List<FileScore> calculerScore(List<Statistic> statistics);
}

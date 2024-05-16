package search_engin.index;
import java.util.List;

import search_engin.statistics.Statistic;

public interface Index {
    void ajouterStat(String word, String filePath, int occurrence);
    List<Statistic> getStatMot(String word);
    void removeFile(String filePath);
}
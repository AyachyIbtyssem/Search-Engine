package search_engin.index;
import java.util.*;

import search_engin.statistics.Statistic;
public class IndexHashMapVersion implements Index{
 private HashMap<String, List<Statistic>> indexMap;
    public IndexHashMapVersion() {
        indexMap = new HashMap<>();
    }
    public HashMap<String, List<Statistic>> getIndex(){
        return indexMap;
    }
    public void ajouterStat(String word, String filePath, int occurrence) {
        if (indexMap.containsKey(word)) {
            indexMap.get(word).add(new Statistic(word, occurrence,filePath));
        } else {
            indexMap.put(word, new ArrayList<>(Collections.singletonList(new Statistic(word, occurrence, filePath))));
        }
    }
    public List<Statistic> getStatMot(String word) {
            return indexMap.get(word);
        }
        public void removeFile(String filePath) {
            Iterator<Map.Entry<String, List<Statistic>>> iterator = indexMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, List<Statistic>> entry = iterator.next();
                List<Statistic> occurrences = entry.getValue();
                Iterator<Statistic> listStatistics = occurrences.iterator();
                while (listStatistics.hasNext()) {
                    Statistic statistics = listStatistics.next();
                    if (statistics.getPath().equals(filePath)) {
                        listStatistics.remove();
                    }
                }
                if (occurrences.isEmpty()) {
                    iterator.remove();
                }
            }
        }
}

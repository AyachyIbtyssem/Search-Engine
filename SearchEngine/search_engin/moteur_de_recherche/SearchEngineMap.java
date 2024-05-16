package search_engin.moteur_de_recherche;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import search_engin.analyseur.*;
import search_engin.file_score.FileScore;
import search_engin.index.*;
import search_engin.lecteur.*;
import search_engin.ordonnaceur.*;
import search_engin.statistics.*;
import search_engin.traiteur.*;
import search_engin.word_occurence.*;
public class SearchEngineMap {
	private Lecteur lecteur;
	private List<Traiteur> traiteurs;
	private Ordonnanceur ordonnanceur;
	private Analyseur analyseur ;
	private Index index;
	public SearchEngineMap(Lecteur lecteur,List<Traiteur> traiteurs,Analyseur analyseur,Ordonnanceur ordonnanceur,Index index){
		this.lecteur=lecteur;
		this.traiteurs=traiteurs;
		this.ordonnanceur=ordonnanceur;
		this.analyseur=analyseur;
		this.index=index;
	}
	   private void indexDirectory(String path){
	        File pathFile = Paths.get(path).toFile();
	        File[] files = pathFile.listFiles();
	        for(File f: files ){
	            if(f.isDirectory()){
	                indexDirectory(f.getAbsolutePath());
	            }else{
	                indexSingleDocument(f.getAbsolutePath());
	            }
	        }
	    }
    private void indexSingleDocument(String path){
    	List<String> motList;
		List<WordOccurence> listMotOcc;
    	motList = lecteur.lire(path);
		//traitement de fichier 
		for(Traiteur t : traiteurs){
			motList=t.traiter(motList);
		}
    	listMotOcc = analyseur.analyser(motList);
    	for(WordOccurence m : listMotOcc) {
    		index.ajouterStat(m.getWord(),path,m.getOcc());
    	}
    }
    public void index(String path){
        File filePath = Paths.get(path).toFile();
        if(filePath.exists()){
            if(filePath.isDirectory()){
                indexDirectory(path);
            }else{
                indexSingleDocument(path);

            }
        }
    }
	public void removeFile(String path){
		index.removeFile(path);
	}
	public List<FileScore> rechercher(List<String> searchedWords){ 
		List<Statistic> resultStatistics = new ArrayList<>();
			List<FileScore> fileScores;
		for(String mot : searchedWords) {
			List<Statistic> statistics = index.getStatMot(mot);
			if(statistics != null){
				resultStatistics.addAll(statistics);
			}
		}
		fileScores = ordonnanceur.calculerScore(resultStatistics);
		Collections.sort(fileScores);
        Collections.reverse(fileScores);
        return fileScores;
	}
}
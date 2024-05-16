package search_engin.lecteur;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LecteurMotParMot implements Lecteur{
	public List<String> lire(String chemin) {
		List<String> words = new ArrayList<>();
		BufferedReader br = null;
		try {
			String currentLine;
			br = new BufferedReader(new FileReader(chemin));
			while ((currentLine = br.readLine()) != null) {
				String[] sentenceWords = currentLine.split(" ");
				words.addAll(Arrays.asList(sentenceWords));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return words;
	}
}
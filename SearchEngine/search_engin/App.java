package search_engin;
import java.util.*;
import search_engin.moteur_de_recherche.*;
import search_engin.analyseur.*;
import search_engin.index.*;
import search_engin.lecteur.*;
import search_engin.ordonnaceur.*;
import search_engin.file_score.*;
import search_engin.traiteur.*;
public class App {
    public static void main(String[] args) {
        // Initialize variables
		SearchEngineMap moteur1;
        Lecteur lecteur ;
        List<Traiteur> traiteurs = new ArrayList<>();
        Ordonnanceur ordonnanceur;
        Analyseur analyseur;
        Index index;
        System.out.println("Choose what Lecteur you want:");
        System.out.println("1. Lecteur Ligne Par Ligne");
        System.out.println("2. Lecteur Mot Par Mot");
		System.out.println("3. Lecteur Mot Par Mot but return sorted list of words");
		System.out.println("0. if you want to pass");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                lecteur = new LecteurLigneParLigne();
                break;
            case 2:
                lecteur = new LecteurMotParMot();
                break;
				case 3:
				lecteur = new LecteurMotParMotSortedVersion();
				break;
            default:
				lecteur = new LecteurMotParMot();
        }
		do{
			System.out.println("Choose what Traiteurs you want:");
        	System.out.println("1. the traiteur that remove punctiations");
        	System.out.println("2. the traiteur that remove the unportant words");
			System.out.println("3. the traiteur that remove the majuscule");
			System.out.println("4. the traiteur that split the sentences , this a must if you chosed the 1st lecteur");
			System.out.println("0. if you want to pass");
			choice = scanner.nextInt();
        	switch (choice) {
            	case 1:
                	traiteurs.add(new TraiteurSymbolRemover(",;.:/!-+*"));
                	break;
           	 	case 2:
					traiteurs.add(new TraiteurUnimportantWordRemover());
                	break;
				case 3:
					traiteurs.add(new TraiteurLowerCast());
					break;
				case 4:
					traiteurs.add(new TraiteurSplit());
					break;
           	 	default:
					traiteurs.add(new TraiteurLowerCast());
					traiteurs.add(new TraiteurUnimportantWordRemover());
					traiteurs.add(new TraiteurSymbolRemover(",!+-.!?"));
        	}
		}while(choice!=0);
		System.out.println("Choose what Analyser you want:");
        System.out.println("1. Analyseur that use the classic double for loops");
        System.out.println("2. Analyseur that use map in his claculation");
		System.out.println("3. Analyseur that use sorted list in his calculation" + //
						" you can use this option only if you chose the 3rd lecteur");
		System.out.println("4. Analyseur that use the List<T>.indexOf() method");
		System.out.println("5. Analyseur that use a binary search algorithm and return sorted list");
		System.out.println("0. if you want to pass");
		choice = scanner.nextInt();
        switch (choice) {
            case 1:
                analyseur = new AnalyseurClassicVersion();
                break;
            case 2:
                analyseur = new AnalyseurHashMapVersion();
                break;
			case 3:
				analyseur = new AnalyseurSortedListVersion();
				break;
			case 4:
				analyseur = new AnalyseurIndexOfVersion();
				break;
			case 5:
				analyseur = new AnalyseurBinarySearchAlgorithmVersion();
				break;
            default:
				analyseur = new AnalyseurHashMapVersion();
        }
		System.out.println("Choose what Index you want:");
        System.out.println("1. index that use the classic List");
        System.out.println("2. index that use hashMap");
		System.out.println("3. index that use TreeMap");
		System.out.println("0. if you want to pass");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                index = new IndexClassicList();
                break;
            case 2:
                index = new IndexHashMapVersion();
            	break;
			case 3:
                index = new IndexTreeMap();
                break;
            default:
				index = new IndexHashMapVersion();
        }
		System.out.println("Choose what Ordonanceur you want:");
        System.out.println("1. Ordonanceur that just calculate the file score based on the number of occurence of the words");
        System.out.println("2. Ordonanceur that just give score to file depending if word exist or not");
		System.out.println("3. Ordonanceur that do the two");
		System.out.println("4.Ordonnaceur that use the IndexOf method to calculate the score");
		System.out.println("5. Ordonnanceur that use the double for loops to calculate the score");
		System.out.println("0. if you want to pass");
		choice = scanner.nextInt();
		int test;
        switch (choice) {
        	case 1:
				ordonnanceur = new OrdonnanceurOcurrenceMap();
                break;
           	case 2:
			   ordonnanceur = new OrdonnanceurExistanceWords();
                break;
			case 3:
				ordonnanceur = new OrdonnaceurIndexOf();
				break;
			case 4:
				ordonnanceur = new OrdonnaceurDoubleLoops();
				break;
           	default:
			   ordonnanceur = new OrdonnanceurOcurrenceMap();
        }
			moteur1 = new SearchEngineMap(lecteur, traiteurs, analyseur,ordonnanceur,index);
			System.out.println("please wait.....");
			moteur1.index("C:/Users/MSI/eclipse-workspace/MiniProjet/src/corpus");
			// Get user input for words to search for
			scanner = new Scanner(System.in);
			System.out.println("Enter the words to search for:");
			String requette = scanner.nextLine();
			while (!requette.equals("EOS")){
				List<String> words = new ArrayList<>();
				String[] wordsArray = requette.split(" ");
				// Convert the array to a list
				Collections.addAll(words, wordsArray);
				for(Traiteur t: traiteurs){
					words=t.traiter(words);
				}
				List<FileScore> result = moteur1.rechercher(words);
				int count = 0;
				for (FileScore fileScore : result) {
					if (count < 10) {
						System.out.println(fileScore);
						count++;
					} else {
						break;
					}
				}
				System.out.println("Enter the words to search for:");
				requette = scanner.nextLine();
			}
		} 
    }
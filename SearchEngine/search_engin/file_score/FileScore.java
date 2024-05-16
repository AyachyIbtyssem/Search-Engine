package search_engin.file_score;

public class FileScore implements Comparable<FileScore>{
    private String filePath;
    private double score;
 public FileScore(String filePath, Double score) {
        this.filePath = filePath;
        this.score = score;
    }
    public String getFilePath() {
        return filePath;
    }
    public double getScore() {
        return score;
    }
    public void incrementScore(double addedNumber){
        score+=addedNumber;
    }
    public int compareTo(FileScore other) {
        return Double.compare(this.score, other.score);
    }
    public boolean equals(Object obj) {
        // Check if the object is compared with itself
        if (this == obj) {
        return true;
    }
        // Check if the object is an instance of FileScore
        if (!(obj instanceof FileScore)) {
        return false;
    }
        // Cast the object to FileScore
        FileScore other = (FileScore) obj;
        // Compare filePath and score fields
        return this.filePath.equals(other.filePath);
    }
    public int hashCode() {
        return filePath.hashCode();
    }
    public String toString() {
        return "[ file Path: " + filePath + ", Score: " + score + " ]";
    }
}

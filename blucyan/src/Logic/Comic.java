package Logic;
/**
 * Class representing a comic
 * @author Carlos, Alejandro, Samuel
 */
public class Comic extends Element {
        
	private String[] illustrators;
	private String[] writers;
        private int numberChapters;
        private String statusComic;
       
    public String[] getIllustrators() {
        return illustrators;
    }

    public void setIllustrators(String[] illustrators) {
        this.illustrators = illustrators;
    }

    public String[] getWriters() {
        return writers;
    }

    public void setWriters(String[] writers) {
        this.writers = writers;
    }

    public int getNumberChapters() {
        return numberChapters;
    }

    public void setNumberChapters(int number_chapters) {
        this.numberChapters = number_chapters;
    }

    public String getStatusComic() {
        return statusComic;
    }

    public void setStatusComic(String statusComic) {
        this.statusComic = statusComic;
    }
        
}
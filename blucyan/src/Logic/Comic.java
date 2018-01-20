package Logic;

public class Comic extends Element {

	private String[] illustrators;
	private String[] writers;
        private int numberChapters;
        private String statusShow;

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

    public String getStatusShow() {
        return statusShow;
    }

    public void setStatusShow(String statusShow) {
        this.statusShow = statusShow;
    }
        
}
package Logic;

import java.util.Arrays;
import javax.swing.ImageIcon;
/**
 * Class representing an element. Comics, videogames and shows extends from this
 * class
 * @author Carlos, Alejandro, Samuel
 */
public class Element {

	private String name;
	private String type;
	private String[] genre;
	private String releaseDate;
	private String id;
        private String cover;
        private String descritpion;

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }
        
        

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Element{" + "name=" + name + ", type=" + type + ", genre=" + Arrays.toString(genre) + ", releaseDate=" + releaseDate + ", id=" + id + ", cover=" + cover + ", descritpion=" + descritpion + '}';
    }
       
        
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestDAOs;

import Logic.Comic;
import Logic.Element;
import Logic.Show;
import Logic.Videogame;
import Persistence.ElementDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class ElementDAOTest {
    
    public ElementDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void elementDAOTest() throws Exception {
        ElementDAO dao = new ElementDAO();
        Element videogame = new Videogame();
        Element show = new Show();
        Element comic = new Comic();
        String[] p1 = {"ps4","xbox one"};
        String[] g1 = {"action","adventure"};
        
        String[] p2 = {"ps2","xbox"};
        String[] g2 = {"rpg"};
        String[] a2 = {"actor1","actor2"};
        String[] d2 = {"actor1","actor2"};
        String[] pr2 = {"producer1","producer2"};
        String[] gn2 = {"comedy","terror"};
        
        String[] w3 = {"writer1","writer2"};
        String[] i3 = {"illustrator1","illustrator2"};
        String[] g3 = {"action"};
        
        videogame.setName("videojuego");
        ((Videogame) videogame).setDeveloper("develop");
        ((Videogame) videogame).setPlatforms(p1);
        videogame.setReleaseDate("1/02/2003");
        videogame.setGenre(gn2);
        videogame.setCover("ruta");
        videogame.setType("Videogame");
        
        show.setName("show");
        ((Show) show).setActors(a2);
        ((Show) show).setDirectors(g3);
        ((Show) show).setNumberEpisodes(45);
        ((Show) show).setNumberSeasons(4);
        ((Show) show).setDuration(43);
        ((Show) show).setStatus("finished");
        ((Show) show).setProducers(pr2);
        show.setReleaseDate("1/02/2003");
        show.setGenre(g1);
        show.setCover("ruta");
        show.setType("Show");
        
        comic.setName("videojuego");
        ((Comic) comic).setStatusComic("publicando");
        ((Comic) comic).setNumberChapters(4);
        ((Comic) comic).setWriters(w3);
        ((Comic) comic).setIllustrators(i3);
        comic.setReleaseDate("1/02/2003");
        comic.setGenre(g3);
        comic.setCover("ruta");
        comic.setType("Comic");
        
       /* dao.put(videogame);
        dao.put(comic);
        dao.put(show);*/
        
        Element vi = dao.get("30");
        Element co = dao.get("31");
        Element sh = dao.get("32");
        System.out.println(videogame.toString());
        System.out.println(vi.toString());
        assertTrue((videogame.toString().compareTo(vi.toString())==0));
       // assertEquals(comic.toString(),(co.toString()));
       // assertEquals(show.toString(),(sh.toString()));
    }
}

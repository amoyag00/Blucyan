package Persistence;

import Logic.Comic;
import Logic.Element;
import Logic.ElementProxy;
import Logic.Show;
import Logic.Videogame;
import java.awt.Image;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class ElementDAO extends DBConnection implements IConversor<Element, ElementProxy>{
    
    public Element get(String id) throws Exception {
       Connection cn;
       ResultSet rs;
       PreparedStatement st;
       Element element=null;
       ImageIcon elementImg;
       ArrayList<String> genres = new ArrayList<String>();

       this.openConnection();
       cn = this.getConnection();
       st = cn.prepareStatement("SELECT * FROM Elements WHERE element_id = ?");
       st.setString(1, id);
       rs = st.executeQuery();
       rs.first();
       String type=rs.getString("type_element");
       if(type.equalsIgnoreCase("Videogame")){
           element= new Videogame();
           fillVideogame((Videogame) element,id,cn);
           
       }else if(type.equalsIgnoreCase("Show")){
           element=new Show();
           fillShow((Show)element,id,cn);
       }else if(type.equalsIgnoreCase("Comic")){
           element= new Comic();
           fillComic((Comic)element,id,cn);
       }
  
       element.setId(String.valueOf(rs.getInt("element_id")));
       element.setName(rs.getString("name"));
       element.setType(type);
       element.setReleaseDate(rs.getString("release_date"));
       
       /*byte[] img = rs.getBytes("cover");
       ImageIcon image = new ImageIcon(img);
       Image im = image.getImage();
       Image dbImage = im.getScaledInstance(label.getWidth(), label.getHeight, Image.SCALE_SMOOTH);
       ImageIcon cover = new ImageIcon(dbImage);
       label.setIcon(cover);*/
       
       st = cn.prepareStatement("SELECT genre FROM Genres WHERE element_id = ? ");
       st.setString(1, element.getId());
       rs = st.executeQuery();
       
       while(rs.next()){
           genres.add(rs.getString("genre"));
       }
       
       element.setGenre(genres.toArray(new String[genres.size()]));
       
       
       this.closeConnection();
       
       return element;
    }
    
    private Videogame fillVideogame(Videogame videogame,String id, Connection cn) throws SQLException{
        ArrayList<String> platforms = new ArrayList<String>();
        ResultSet rs;
        PreparedStatement st;
        st = cn.prepareStatement("SELECT * FROM Videogames WHERE videogame_id = ?");
        st.setString(1, id);
        rs = st.executeQuery();
        rs.first();
        videogame.setDeveloper(rs.getString("developer"));
           
        st = cn.prepareStatement("SELECT * FROM Platforms WHERE videogame_id = ?");
        st.setString(1, id);
        rs = st.executeQuery();
        while(rs.next()){
            platforms.add(rs.getString("platform")); 
        }  
        videogame.setPlatforms(platforms.toArray(new String[platforms.size()]));
        return videogame;
    }
    
    private Show fillShow(Show show, String id, Connection cn)throws SQLException{
        ArrayList<String> actors=new ArrayList<String>();
        ArrayList<String> producers=new ArrayList<String>();
        ArrayList<String> director=new ArrayList<String>();
        
        ResultSet rs;
        PreparedStatement st;
        st = cn.prepareStatement("SELECT * FROM Shows WHERE show_id = ?");
        st.setString(1, id);
        rs = st.executeQuery();
        rs.first();
        show.setNumberEpisodes(rs.getInt("number_episodes"));
        show.setNumberSeasons(rs.getInt("number_seasons"));
        show.setDuration(rs.getInt("episode_duration"));
        show.setStatus(rs.getString("status_show"));
        //Actors
        st = cn.prepareStatement("SELECT * FROM Actors WHERE show_id = ?");
        st.setString(1, id);
        rs = st.executeQuery();
        while(rs.next()){
            actors.add(rs.getString("actor")); 
        }   
        show.setActors(actors.toArray(new String[actors.size()]));
        //Directors
        st = cn.prepareStatement("SELECT * FROM Director WHERE show_id = ?");
        st.setString(1, id);
        rs = st.executeQuery();
        while(rs.next()){
            director.add(rs.getString("director")); 
        }   
        show.setDirectors(director.toArray(new String[director.size()]));
        //Producers
        st = cn.prepareStatement("SELECT * FROM Producers WHERE show_id = ?");
        st.setString(1, id);
        rs = st.executeQuery();
        while(rs.next()){
           producers.add(rs.getString("producer")); 
        }   
        show.setProducers(producers.toArray(new String[producers.size()]));
        return show;
    }
    
    private Comic fillComic(Comic comic, String id, Connection cn)throws SQLException{
        ArrayList<String> writers = new ArrayList<String>();
        ArrayList<String> illustrators = new ArrayList<String>();
        
        ResultSet rs;
        PreparedStatement st;
        st = cn.prepareStatement("SELECT * FROM Comics WHERE comic_id = ?");
        st.setString(1, id);
        rs = st.executeQuery();
        rs.first();
        comic.setNumberChapters(rs.getInt("number_chapters"));
        comic.setStatusShow(rs.getString("status_comic"));
           
       //Writers 
        st = cn.prepareStatement("SELECT * FROM Writers WHERE comic = ?");
        st.setString(1, id);
        rs = st.executeQuery();
        while(rs.next()){
            writers.add(rs.getString("writer")); 
        }  
        comic.setWriters(writers.toArray(new String[writers.size()]));
        
        //Illustrators
        st = cn.prepareStatement("SELECT * FROM Illustrators WHERE comic_id = ?");
        st.setString(1, id);
        rs = st.executeQuery();
        while(rs.next()){
            writers.add(rs.getString("illustrator")); 
        }  
        comic.setIllustrators(illustrators.toArray(new String[illustrators.size()]));
        
        
        return comic;
    }
    
    public void delete(String id) throws Exception {
        Connection cn;
        ResultSet rs;
        PreparedStatement st;
        
        this.openConnection();
        cn = this.getConnection();
        st = cn.prepareStatement("DELETE FROM Elements WHERE element_id = ?");
        st.setString(1, id);
        st.executeUpdate();
        
        this.closeConnection();
    }
    
    public void put(Element element) throws Exception {
        Connection cn;
        ResultSet rs;
        PreparedStatement st;
        
        this.openConnection();
        cn = this.getConnection();
        st = cn.prepareStatement("INSERT INTO Elements (name,type_element,release_date) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        st.setString(1, element.getName());
        st.setString(2, element.getType());
        
        //TODO introducir la imagen de la portada
        
        DateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        java.util.Date date = format.parse(element.getReleaseDate());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        st.setDate(3, sqlDate);
        st.executeUpdate();
        
        rs = st.getGeneratedKeys();
        rs.first();
        int id = rs.getInt(1);
        
        for(int i=0;i<element.getGenre().length;i++){
            st = cn.prepareStatement("INSERT INTO Genres VALUES (?,?)");
            st.setInt(1, id);
            st.setString(2, element.getGenre()[i]);
        }
        String type=element.getType();
        if(type.equalsIgnoreCase("Videogame")){
           putVideogame();
       }else if(type.equalsIgnoreCase("Show")){
           putShow();
       }else if(type.equalsIgnoreCase("Comic")){
           putComic();
       }
        
        this.closeConnection();
    }
    
    public void putVideogame(){
        
    }
    public void putShow(){
        
    }
    public void putComic(){
        
    }
    
    public boolean exists(String id) throws Exception {
        Connection cn;
        ResultSet rs;
        PreparedStatement st;
        boolean exist = false;
        
        this.openConnection();
        cn = this.getConnection();
        st = cn.prepareStatement("SELECT count(element_id) FROM Elements WHERE element_id = ?");
        st.setString(1, id);
        rs = st.executeQuery();
        rs.first();
        exist = rs.getBoolean(1);
        
        this.closeConnection();
        
        return exist;
    }
    
    public List<ElementProxy> search(String name) throws Exception {
        Connection cn;
        ResultSet rs;
        PreparedStatement st;
        List<ElementProxy> searched = new ArrayList<ElementProxy>();
        
        this.openConnection();
        cn = this.getConnection();
        st = cn.prepareStatement("SELECT name, cover FROM Elements WHERE name LIKE '%"+name+"%'");
        rs = st.executeQuery();
        
        while(rs.next()){
                ElementProxy elem = new ElementProxy();
                elem.setName(rs.getString("name"));
                //TODO añadir imagen portada
                searched.add(elem);
            }
        
        this.closeConnection();
        
        return searched;
    }
    
    public void modify(Element element) throws Exception{
    
        Connection cn;

        PreparedStatement st;
        
        this.openConnection();
        cn = this.getConnection();
       
        st = cn.prepareStatement("UPDATE Elements SET name=?, type_element=?, release_date=? WHERE element_id = ?"); 
        
        st.setString(1, element.getName());
        st.setString(2, element.getType());

        //TODO introducir la imagen de la portada
        
        DateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        java.util.Date date = format.parse(element.getReleaseDate());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        st.setDate(3, sqlDate);
        st.setString(4, element.getId());

        st.executeUpdate();
        
        st = cn.prepareStatement("DELETE FROM Genres WHERE element_id=?");
        st.setString(1, element.getId());
        st.executeUpdate();
        
        for(int i=0;i<element.getGenre().length;i++){
            
            st = cn.prepareStatement("INSERT INTO Genres VALUES (?,?);");
            st.setString(1, element.getId());
            st.setString(2, element.getGenre()[i]);

            st.executeUpdate();
        }

        this.closeConnection();
        
    }
    
    public static void main(String[] args) throws Exception {
         ElementDAO el = new ElementDAO();
         Element e;
         
         /*e = el.get("1");
         
         System.out.println(e.getName());
         System.out.println(e.getId());
         System.out.println(e.getType());
         System.out.println(e.getReleaseDate());
         
         
        
         ArrayList<ElementProxy> p = (ArrayList<ElementProxy>) el.search("a");
         
         for(int i =0;i<p.size();i++){
             System.out.println(p.get(i).getName());
         }
          
         System.out.println(el.exists("1"));*/
         e = new Element();
         e.setId("1");
         String[] s = {"Mecha","Psychological", "Depresion"};
         e.setGenre(s);
         e.setName("Evangelion");
         e.setReleaseDate("04-08-1995");
         e.setType("Show");
       
         
         el.modify(e);
         
        
    }
}
package Persistence;

import Logic.Element;
import Logic.ElementProxy;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class ElementDAO extends DBConnection{
    
    public Element get(String id) throws Exception {
       Connection cn;
       ResultSet rs;
       PreparedStatement st;
       Element element;
       ImageIcon elementImg;
       ArrayList<String> genres = new ArrayList<String>();
       
       this.openConnection();
       cn = this.getConnection();
       st = cn.prepareStatement("SELECT * FROM Elements WHERE element_id = ?");
       st.setString(1, id);
       rs = st.executeQuery();
       rs.first();
       
       element = new Element();
       element.setId(String.valueOf(rs.getInt("element_id")));
       element.setName(rs.getString("name"));
       element.setType(rs.getString("type_element"));
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
        st = cn.prepareStatement("INSERT INTO Elements (name,type_element,cover,release_date) VALUES (?,?,?,?)");
        st.setString(1, element.getName());
        st.setString(2, element.getType());
        //TODO introducir la imagen de la portada
        st.setString(4, element.getReleaseDate());
        st.executeUpdate();
        
        this.closeConnection();
    }
    
    public boolean exists(String id) throws Exception {
        Connection cn;
        ResultSet rs;
        PreparedStatement st;
        boolean exist = false;
        
        this.openConnection();
        cn = this.getConnection();
        st = cn.prepareStatement("SELECT count(element_id FROM Elements WHERE element_id = ?");
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
    
    public static void main(String[] args) throws Exception {
         ElementDAO el = new ElementDAO();
         Element e;
         
         e = el.get("1");
         
         System.out.println(e.getName());
         System.out.println(e.getId());
         System.out.println(e.getType());
         System.out.println(e.getReleaseDate());
    }
}
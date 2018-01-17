package Logic;

import Persistence.Facade;
import javax.swing.ImageIcon;

public class ElementProxy {
        private ImageIcon cover;
        private String name;
        private String id;
        private Element realElement;

    public ImageIcon getCover() {
        return cover;
    }

    public void setCover(ImageIcon cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

  
    
	public Element getRealInstance() {
            if (this.realElement== null){
                realElement= (Element)Facade.getInstance().get(id,Element.class);
                
            }
                return this.realElement;
        }
}

	


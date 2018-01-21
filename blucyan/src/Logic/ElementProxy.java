package Logic;

import Persistence.Facade;
import javax.swing.ImageIcon;

public class ElementProxy {
        private String cover;
        private String name;
        private String id;
        private Element realElement;
        private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

  
    
	public Element getRealInstance() throws Exception {
            if (this.realElement== null){
                realElement= (Element)Facade.getInstance().get(id,Element.class);
                
            }
                return this.realElement;
        }
}

	


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author alex
 */
public class CustomButton extends JButton{
    private int row;
    CustomTextField params[];
    public CustomButton(String name,int row, CustomTextField params[]){
        super(name);
        this.row=row;
        this.params=params;
    
    }       
    public String[] getParams(){
        ArrayList<String> params=new ArrayList<String>();
        for(int i=0;i<this.params.length;i++){
            params.add(this.params[i].getText());
        }
        return params.toArray(new String[params.size()]);
    }
    
    
}

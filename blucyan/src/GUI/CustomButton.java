/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JButton;

/**
 *
 * @author alex
 */
public class CustomButton extends JButton{
    private int row;
    String params[];
    public CustomButton(String name,int row, String params[]){
        super(name);
        this.row=row;
        this.params=params;
    
    }       
    public String[] getParams(){
        return this.params;
    }
    
    
}

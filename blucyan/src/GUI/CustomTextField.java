/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author alex
 */
public class CustomTextField extends JTextField {
    
    public CustomTextField(String text){
        super(text);
        this.setBackground(new Color(1f,0f,0f,0f ));
    }
    @Override 
    public void setBorder(Border border) {
        // No!
    }
  
}

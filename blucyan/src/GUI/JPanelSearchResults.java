/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.Element;
import Logic.ElementProxy;
import Logic.UserController;
import Logic.UserProxy;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.lang.String;
import java.text.AttributedCharacterIterator;

/**
 *
 * @author alex
 */
public class JPanelSearchResults extends javax.swing.JPanel {

    /**
     * Creates new form JPanelSearchResults
     */
    public JPanelSearchResults() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox<>();
        bigPanel = new javax.swing.JPanel();

        searchField.setText("Search");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backButtonMouseReleased(evt);
            }
        });

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Shows", "Videogames", "Comics", "Users" }));

        bigPanel.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchButton)
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bigPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchButton)
                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(593, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bigPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        bigPanel.getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseReleased
        // TODO add your handling code here:
        JPanel mainPanel = (JPanel) this.getParent();
       CardLayout card = (CardLayout) mainPanel.getLayout();
       card.show(mainPanel, "Home");
    }//GEN-LAST:event_backButtonMouseReleased

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try {
            // TODO add your handling code here:
            UserController controller = UserController.getInstance();
            GridBagConstraints gbc = new GridBagConstraints();
            

            bigPanel.removeAll();
            bigPanel.repaint();
            bigPanel.revalidate();
            
            if("User".compareTo((String) comboBox.getSelectedItem())==0){
                List<UserProxy> results = controller.searchUser(searchField.getText());
                
                
                
                
            }else{
                List<ElementProxy> results = controller.searchElement(searchField.getText());
                
                int row=0;
                int column=0;
                ImageIcon img;
                for(int i=0;i<((int)results.size());i++){
                    
                    gbc.gridy=row;
                    gbc.gridx=column;
                    gbc.fill=GridBagConstraints.BOTH;
                    gbc.anchor=GridBagConstraints.CENTER;
                    gbc.weightx=5;
                    ImageIcon image = new ImageIcon("C:/Users/Usuario/Desktop/Imagenes Samu/Gosu.png") {};
                    JLabel cover = new JLabel(); 
                    //cover.setSize(720, 576); 
                    cover.setIcon(image);
                    cover.doLayout();
                   
                   
                   /* JPanel imagePanel = new JPanel();
                    imagePanel.setSize(10, 10);
                    
                    imagePanel.add(cover);*/
                    bigPanel.add(cover,gbc);
                    
                    gbc.gridy=row+1;
                    
                    img = new ImageIcon();
                    JLabel nameLabel = new JLabel(results.get(i).getName());
                    bigPanel.add(nameLabel,gbc);
                    
                }
                
                bigPanel.repaint();
                bigPanel.revalidate();

            }

            /*
            List<Element> results = 
            
            
            
            
            */
            
            
        } catch (Exception ex) {
            Logger.getLogger(JPanelSearchResults.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel bigPanel;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}

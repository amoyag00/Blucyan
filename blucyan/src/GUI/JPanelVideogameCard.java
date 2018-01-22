/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.Element;
import Logic.ElementList;
import Logic.UserController;
import Logic.Videogame;
import java.awt.CardLayout;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author cloud
 */
public class JPanelVideogameCard extends javax.swing.JPanel {

    /**
     * Creates new form JPanelElementCard
     */
    public JPanelVideogameCard(Element ele,JPanel mainPanel,JPanelSearchResults search, JPanelHome homePanel) {
        this.homePanel=homePanel;
        element=ele;
        
        this.mainPanel=mainPanel;
        this.search=search;
        initComponents();
        fillCard();
    }

    private void fillCard(){
        try {
            UserController u=UserController.getInstance();
            Videogame game=(Videogame)this.element;
            
            
            try {
                if(u.isEntryAdded(element.getId(), "Videogame")){
                    this.addButton.setVisible(false);
                }
            } catch (Exception ex) {
                Logger.getLogger(JPanelVideogameCard.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.nameLabel.setText(game.getName());
            this.platformLabel.setText(this.platformLabel.getText() +game.getPlatforms()[0]);
            this.developerLabel.setText(this.developerLabel.getText() + game.getDeveloper());
            this.imageLabel.setText(game.getCover());
           
            this.releaseDate_label.setText(this.releaseDate_label.getText()+ game.getReleaseDate());
            this.reviewWrite.setText(UserController.getInstance().getReview(game.getId()).getText());    
            
        } catch (Exception ex) {
            Logger.getLogger(JPanelComicCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        platformLabel = new javax.swing.JLabel();
        releaseDate_label = new javax.swing.JLabel();
        developerLabel = new javax.swing.JLabel();
        valorationLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        valorationUser = new javax.swing.JTextField();
        state = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        writeReview = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reviewWrite = new javax.swing.JTextArea();
        reviewText = new javax.swing.JLabel();
        deleteButtom = new javax.swing.JButton();

        backButton.setText("< Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backButtonMouseReleased(evt);
            }
        });
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        nameLabel.setText("VIDEOGAME NAME");

        homeButton.setText("HOME");

        imageLabel.setText("IMAGEN");

        platformLabel.setText("Platform: ");

        releaseDate_label.setText("Release date: ");

        developerLabel.setText("Developer");

        valorationLabel.setText("NOTA");

        descriptionLabel.setText("Descripcion");

        valorationUser.setText("NotaUser");

        state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        addButton.setText("ADD");
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addButtonMouseReleased(evt);
            }
        });

        writeReview.setText("Write review");

        reviewWrite.setColumns(20);
        reviewWrite.setRows(5);
        jScrollPane1.setViewportView(reviewWrite);

        reviewText.setText("Review");

        deleteButtom.setText("DELETE");
        deleteButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 567, Short.MAX_VALUE)
                        .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(addButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(releaseDate_label, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(platformLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                        .addComponent(developerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(valorationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(valorationUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(state, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(descriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                                .addGap(53, 53, 53))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(reviewText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(writeReview, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(53, 53, 53))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(backButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valorationUser, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(platformLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(developerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(releaseDate_label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton)
                .addGap(1, 1, 1)
                .addComponent(deleteButtom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(writeReview, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(reviewText, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtomActionPerformed
        try {
            UserController controller = UserController.getInstance();
            controller.delete(element.getId(), Element.class);
        } catch (Exception ex) {
            Logger.getLogger(JPanelVideogameCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteButtomActionPerformed

    private void backButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseReleased
        // TODO add your handling code here:
        ((CardLayout)mainPanel.getLayout()).show(mainPanel, "search");
    }//GEN-LAST:event_backButtonMouseReleased

    private void homeButtonMouseReleased(java.awt.event.MouseEvent evt) {                                         
        // TODO add your handling code here:
        ((CardLayout)mainPanel.getLayout()).show(mainPanel, "Home");
    }
    
    private void addButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseReleased
        try {
            // TODO add your handling code here:
            String [] params=null;
        Videogame game=(Videogame)element;
        int valoration=Integer.valueOf(this.valorationUser.getText());
         if(valoration<0 || valoration> 100){
            JOptionPane.showMessageDialog(null,"Valoration must be between 0 and 100");
        }else{
           params = new String[5];
           
            params[0]=game.getId();
            params[1]=game.getName();
            params[2]=String.valueOf(valoration);
            addButton.setVisible(false);
            try {
                
            } catch (Exception ex) {
                Logger.getLogger(JPanelComicCard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
            
            UserController.getInstance().addEntry(params,"videogame");
            ElementList [] lists=UserController.getInstance().getLists();
                
            homePanel.setLists(lists);
        } catch (Exception ex) {
            Logger.getLogger(JPanelVideogameCard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_addButtonMouseReleased

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        ((CardLayout)mainPanel.getLayout()).show(mainPanel, "search");
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteButtom;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel developerLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel platformLabel;
    private javax.swing.JLabel releaseDate_label;
    private javax.swing.JLabel reviewText;
    private javax.swing.JTextArea reviewWrite;
    private javax.swing.JComboBox<String> state;
    private javax.swing.JLabel valorationLabel;
    private javax.swing.JTextField valorationUser;
    private javax.swing.JLabel writeReview;
    // End of variables declaration//GEN-END:variables
    private Element element;
    private JPanel mainPanel;
    private JPanelSearchResults search;
    private JPanelHome homePanel;
}

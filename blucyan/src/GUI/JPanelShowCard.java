/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.Element;
import Logic.ElementList;
import Logic.Show;
import Logic.UserController;
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
public class JPanelShowCard extends javax.swing.JPanel {

    /**
     * Creates new form JPanelShowCard
     */
    public JPanelShowCard(Element ele,JPanel mainPanel,JPanelSearchResults search, JPanelHome homePanel) throws Exception {
        this.mainPanel=mainPanel;
        this.search = search;
        this.ele = ele;
        this.home = homePanel;
        initComponents();
        fillCard();
        
        UserController u = UserController.getInstance();
        
        if(!u.getActualUser().getIsAdmin()){
            this.deleteButton.setVisible(false);
        }
    }
    
    private void fillCard() throws Exception {
        UserController u = UserController.getInstance();
        Show show = (Show) this.ele;
        
        if(u.isEntryAdded(show.getId(), show.getType())){
            this.addButton.setVisible(false);
        }
        
        this.seasonsLabel.setText(this.seasonsLabel.getText()+show.getNumberSeasons());
        this.episodesLabel.setText(this.episodesLabel.getText()+show.getNumberEpisodes());
        this.chaptersLabel.setText(this.chaptersLabel.getText()+show.getDuration());
        this.dateLabel.setText(this.dateLabel.getText()+show.getReleaseDate());
        this.actorsLabel.setText(this.actorsLabel.getText()+Arrays.toString(show.getActors()));
        this.directorsLabel.setText(this.directorsLabel.getText()+Arrays.toString(show.getDirectors()));
        this.producersLabel.setText(this.producersLabel.getText()+Arrays.toString(show.getProducers()));
        this.statusLabel2.setText(this.statusLabel2+show.getStatus());
        this.genreLabel.setText(this.genreLabel.getText()+show.getGenre());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        seasonsLabel = new javax.swing.JLabel();
        chaptersLabel = new javax.swing.JLabel();
        actorsLabel = new javax.swing.JLabel();
        episodesLabel = new javax.swing.JLabel();
        valorationLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        valorationUser = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        writeReview = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reviewWrite = new javax.swing.JTextArea();
        dateLabel = new javax.swing.JLabel();
        directorsLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        statusText = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        statusLabel2 = new javax.swing.JLabel();
        genreLabel = new javax.swing.JLabel();
        watchedLabel = new javax.swing.JLabel();
        wathedText = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        producersLabel = new javax.swing.JLabel();

        backButton.setText("< Back");

        nameLabel.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        nameLabel.setText("SHOW NAME");

        homeButton.setText("HOME");

        imageLabel.setText("IMAGEN");

        seasonsLabel.setText("Number seasons: ");

        chaptersLabel.setText("Chapter duration: ");

        actorsLabel.setText("Actors: ");

        episodesLabel.setText("Number episodes: ");

        valorationLabel.setText("Valoration: ");

        descriptionLabel.setText("Descripcion");

        addButton.setText("ADD");
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addButtonMouseReleased(evt);
            }
        });

        writeReview.setText("Your review: ");

        reviewWrite.setColumns(20);
        reviewWrite.setRows(5);
        jScrollPane1.setViewportView(reviewWrite);

        dateLabel.setText("Release date: ");

        directorsLabel.setText("Directors:  ");

        deleteButton.setText("DELETE");
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteButtonMouseReleased(evt);
            }
        });

        statusLabel.setText("Status");

        statusLabel2.setText("Status: ");

        genreLabel.setText("Genre: ");

        watchedLabel.setText("Watched episodes: ");

        saveButton.setText("Save changes");

        producersLabel.setText("Producers: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(addButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                        .addGap(116, 116, 116))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(valorationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(valorationUser, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(seasonsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(episodesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(chaptersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(directorsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                                                .addComponent(actorsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(0, 12, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(descriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                    .addComponent(statusText)
                                    .addComponent(statusLabel)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(watchedLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(wathedText)))
                                .addGap(106, 106, 106))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(statusLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                                    .addComponent(genreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                                    .addComponent(producersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(saveButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(writeReview, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(790, 790, 790)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(backButton)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(statusLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(statusText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(watchedLabel)
                                    .addComponent(wathedText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(valorationUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                .addComponent(valorationLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(seasonsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(episodesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chaptersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(actorsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(directorsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(producersLabel)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(statusLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(genreLabel)))
                .addGap(25, 25, 25)
                .addComponent(writeReview, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addGap(143, 143, 143))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1119, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 10, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 10, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1046, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseReleased
        // TODO add your handling code here:
        String[] params;
        Show show = (Show) this.ele;
        int valoration = Integer.parseInt(this.valorationUser.getText());
        
        if(valoration < 0 || valoration > 100){
            JOptionPane.showMessageDialog(null,"Valoration must be between 0 and 100");
        }
        else{
            params = new String[5];
            
            params[0] = show.getId();
            params[1] = String.valueOf(valoration);
            params[2] = this.wathedText.getText();
            params[3] = this.statusText.getText();
            
            this.addButton.setVisible(false);
            
            UserController u = UserController.getInstance();
            try {
                 u.addEntry(params, show.getType());
                 ElementList[] lists = u.getLists();
                 
                 this.home.setLists(lists);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JPanelShowCard.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(JPanelShowCard.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(JPanelShowCard.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(JPanelShowCard.class.getName()).log(Level.SEVERE, null, ex);
            }
              }
    }//GEN-LAST:event_addButtonMouseReleased

    private void deleteButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseReleased
        // TODO add your handling code here:
        UserController u = UserController.getInstance();
        try {
            u.delete(ele.getId(), Element.class);
        } catch (Exception ex) {
            Logger.getLogger(JPanelShowCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteButtonMouseReleased

    private JPanel mainPanel;
    private Element ele;
    private JPanelSearchResults search;
    private JPanelHome home;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actorsLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel chaptersLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel directorsLabel;
    private javax.swing.JLabel episodesLabel;
    private javax.swing.JLabel genreLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel producersLabel;
    private javax.swing.JTextArea reviewWrite;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel seasonsLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel statusLabel2;
    private javax.swing.JTextField statusText;
    private javax.swing.JLabel valorationLabel;
    private javax.swing.JTextField valorationUser;
    private javax.swing.JLabel watchedLabel;
    private javax.swing.JTextField wathedText;
    private javax.swing.JLabel writeReview;
    // End of variables declaration//GEN-END:variables
}

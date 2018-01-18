/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.ElementProxy;
import Logic.UserController;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author alex
 */
public class JPanelHome extends javax.swing.JPanel {

    /**
     * Creates new form JPanelHome
     */
    public JPanelHome(MainFrame mainFrame) {
        initComponents();
        //System.out.println(((JFrame)this.getParent()).toString());
  
        mainFrame.pack();
        mainFrame.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBox = new javax.swing.JComboBox<>();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        videogameButton = new javax.swing.JButton();
        comicButton = new javax.swing.JButton();
        showButton = new javax.swing.JButton();
        panel = new javax.swing.JPanel();

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Shows", "Videogames", "Comics", "Users" }));

        searchField.setText("Search");
        searchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchFieldMouseClicked(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                searchButtonMouseReleased(evt);
            }
        });

        videogameButton.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        videogameButton.setText("VIDEOGAMES");
        videogameButton.setBorderPainted(false);
        videogameButton.setContentAreaFilled(false);
        videogameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                videogameButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                videogameButtonMouseEntered(evt);
            }
        });

        comicButton.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        comicButton.setText("COMICS");
        comicButton.setBorderPainted(false);
        comicButton.setContentAreaFilled(false);
        comicButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                comicButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                comicButtonMouseEntered(evt);
            }
        });

        showButton.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        showButton.setText("SHOWS");
        showButton.setBorderPainted(false);
        showButton.setContentAreaFilled(false);
        showButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showButtonMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1058, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButton)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(videogameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193)
                        .addComponent(comicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(136, 136, 136))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(videogameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void videogameButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videogameButtonMouseEntered

        this.videogameButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_videogameButtonMouseEntered

    private void searchButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseReleased
        // TODO add your handling code here:
        JPanel mainPanel = (JPanel) this.getParent();
       CardLayout card = (CardLayout) mainPanel.getLayout();
       card.show(mainPanel, "Search");
        //List<ElementProxy> searchResults=UserController.getInstance().search(this.searchField.getText());
        
        
    }//GEN-LAST:event_searchButtonMouseReleased

    private void videogameButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videogameButtonMouseExited
        // TODO add your handling code here:
        this.videogameButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_videogameButtonMouseExited

    private void comicButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comicButtonMouseEntered
        // TODO add your handling code here:
        this.comicButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_comicButtonMouseEntered

    private void comicButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comicButtonMouseExited

        this.comicButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_comicButtonMouseExited

    private void showButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonMouseEntered
     
        this.showButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_showButtonMouseEntered

    private void showButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonMouseExited
       
        this.showButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_showButtonMouseExited

    private void searchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFieldMouseClicked
        this.searchField.setText("");
    }//GEN-LAST:event_searchFieldMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JButton comicButton;
    private javax.swing.JPanel panel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton showButton;
    private javax.swing.JButton videogameButton;
    // End of variables declaration//GEN-END:variables
}
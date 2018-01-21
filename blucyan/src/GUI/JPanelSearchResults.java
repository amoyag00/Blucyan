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
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.lang.String;
import java.text.AttributedCharacterIterator;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author alex
 */
public class JPanelSearchResults extends javax.swing.JPanel {
    private final int magicNumber =3;
    /**
     * Creates new form JPanelSearchResults
     */
    public JPanelSearchResults(JPanel mainPanel ) {
        
        initComponents();
       this.mainPanel=mainPanel;
        this.scroll.setPreferredSize(new Dimension(1000,550));
        this.scroll.getVerticalScrollBar().setUnitIncrement(16);
        
    }
    
    public void setHomePanel(JPanelHome homePanel){
        this.homePanel=homePanel;
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
        scroll = new javax.swing.JScrollPane();
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

        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        bigPanel.setLayout(new java.awt.GridBagLayout());
        scroll.setViewportView(bigPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(searchButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseReleased
        // TODO add your handling code here:
        JPanel mainPanel = (JPanel) this.getParent();
       CardLayout card = (CardLayout) mainPanel.getLayout();
       card.show(mainPanel, "Home");
    }//GEN-LAST:event_backButtonMouseReleased

    public void searchFromHome(String text, String type){
        searchField.setText(text);
        comboBox.setSelectedItem(type);   
        
        
      search();
        
    }
    public String getSearchField(){
        return this.searchField.getText();
    }
    
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        search();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxActionPerformed

    public void search(){
     try {
            // TODO add your handling code here:
            UserController controller = UserController.getInstance();
            GridBagConstraints gbc = new GridBagConstraints();
            

            bigPanel.removeAll();
            bigPanel.repaint();
            bigPanel.revalidate();
            
            if("Users".compareTo((String) comboBox.getSelectedItem())==0){
                List<UserProxy> results = controller.searchUser(searchField.getText());
                              
                int row=0;
                int column=0;
                ImageIcon img;
                
                //Insets insetsTitles = new Insets(5,100,100,100);
                
                for(int i=0;i<((int)results.size());i++){
                    
                    //gbc.insets=insetsTitles;
                    gbc.gridy=row+1;
                    
                    //img = new ImageIcon();
                 
                    JLabel nameLabel = new JLabel(results.get(i).getName());
                    nameLabel.setFont(new Font("Ubuntu",Font.PLAIN,15));
                    nameLabel.addMouseListener(new MouseAdapter()  {  
                         public void mouseClicked(MouseEvent e)  {  
                               JPanelOtherHome other=new JPanelOtherHome();
                         }});
                    bigPanel.add(nameLabel,gbc);
                    
                    /*if(column<magicNumber){
                        column++;
                    }else{
                        column=0;
                        row+=1;
                    }*/
                    
                
                }
                JPanel filler=new JPanel();
                gbc.weightx=1;
                gbc.weighty=1;
                gbc.gridx++;
                gbc.gridy++;
                bigPanel.add(filler,gbc);
                bigPanel.repaint();
                bigPanel.revalidate();
                
                
                
            }else{
                List<ElementProxy> results = controller.searchElement(searchField.getText());
                
                int row=0;
                int column=0;

                Image image;
                
                Insets insetsImage = new Insets(75, 50, 0, 100);
                Insets insetsTitles = new Insets(5,50,50,25);
                
                for(int i=0;i<((int)results.size());i++){
                    gbc.insets=insetsImage;
                    gbc.gridy=row;
                    gbc.gridx=column;
                    gbc.fill=GridBagConstraints.BOTH;
                    gbc.anchor=GridBagConstraints.CENTER;
                    image=ImageIO.read(new File("/home/alex/Escritorio/sherlock.jpg"/*results.get(i).getCover()*/));
                    Image scaledImage = image.getScaledInstance(100, 175, Image.SCALE_SMOOTH);
                    ElementProxy proxy=results.get(i);
                    JLabel cover = new JLabel(new ImageIcon(scaledImage));
                    cover.addMouseListener(new MouseAdapter()  {  
                         public void mouseClicked(MouseEvent e)  {  
                                String type=proxy.getType();
                                if(type.equalsIgnoreCase("Videogame")){
                                    try {
                                        JPanelVideogameCard card=new JPanelVideogameCard(proxy.getRealInstance(),JPanelSearchResults.this.mainPanel, JPanelSearchResults.this, JPanelSearchResults.this.homePanel);
                                        JPanel mainPanel=(JPanel)JPanelSearchResults.this.getParent();
                                        mainPanel.add(card,"videogame");
                                        ((CardLayout)mainPanel.getLayout()).show(mainPanel, "videogame");
                                    } catch (Exception ex) {
                                        Logger.getLogger(JPanelSearchResults.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }else if(type.equalsIgnoreCase("Show")){
                                    try {
                                        JPanelShowCard card=new JPanelShowCard(proxy.getRealInstance(),JPanelSearchResults.this.mainPanel, JPanelSearchResults.this, JPanelSearchResults.this.homePanel);
                                        JPanel mainPanel=(JPanel)JPanelSearchResults.this.getParent();
                                        mainPanel.add(card,"show");
                                        ((CardLayout)mainPanel.getLayout()).show(mainPanel, "show");
                                    } catch (Exception ex) {
                                        Logger.getLogger(JPanelSearchResults.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }else if(type.equalsIgnoreCase("Comic")){
                                    try {
                                        JPanelComicCard card=new JPanelComicCard(proxy.getRealInstance(),JPanelSearchResults.this.mainPanel, JPanelSearchResults.this,JPanelSearchResults.this.homePanel);
                                        JPanel mainPanel=(JPanel)JPanelSearchResults.this.getParent();
                                        mainPanel.add(card,"comic");
                                        ((CardLayout)mainPanel.getLayout()).show(mainPanel, "comic");
                                    } catch (Exception ex) {
                                        Logger.getLogger(JPanelSearchResults.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }

                          }  }); 
                    //cover.setSize(720, 576); 
                    
                    cover.doLayout();
                   
                   
                   /* JPanel imagePanel = new JPanel();
                    imagePanel.setSize(10, 10);
                    
                    imagePanel.add(cover);*/
                    bigPanel.add(cover,gbc);
                    
                    gbc.insets=insetsTitles;
                    gbc.gridy=row+1;
                    
                    //img = new ImageIcon();
                    JLabel nameLabel = new JLabel(results.get(i).getName());
                    bigPanel.add(nameLabel,gbc);
                    
                    if(column<magicNumber){
                        column++;
                    }else{
                        column=0;
                        row+=2;
                    }
                    
                
                }
                JPanel filler=new JPanel();
                gbc.weightx=1;
                gbc.weighty=1;
                gbc.gridx++;
                gbc.gridy++;
                bigPanel.add(filler,gbc);
                bigPanel.repaint();
                bigPanel.revalidate();

            }

            /*
            List<Element> results = 
            
            
            
            
            */
            
            
        } catch (Exception ex) {
            Logger.getLogger(JPanelSearchResults.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    private JPanel mainPanel;
    private JPanelHome homePanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel bigPanel;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.ComicEntry;
import Logic.ElementList;
import Logic.ElementProxy;
import Logic.Entry;
import Logic.ShowEntry;
import Logic.UserController;
import Logic.VideogameEntry;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author alex
 */
public class JPanelHome extends javax.swing.JPanel {
   
    /**
     * Creates new form JPanelHome
     */
    public JPanelHome(MainFrame mainFrame,JPanelSearchResults searchPanel) {
        initComponents();
      this.searchPanel=searchPanel;
        ElementList[] lists=null;
        try {
            lists = UserController.getInstance().getLists();
        } catch (Exception ex) {
            Logger.getLogger(JPanelHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        setLists(lists);
        mainFrame.getPanel().repaint();
        mainFrame.getPanel().revalidate();
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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                videogameButtonMouseReleased(evt);
            }
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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comicButtonMouseReleased(evt);
            }
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
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                showButtonMouseReleased(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showButtonMouseEntered(evt);
            }
        });

        java.awt.GridBagLayout panelLayout = new java.awt.GridBagLayout();
        panelLayout.columnWidths = new int[] {0, 5, 0};
        panelLayout.rowHeights = new int[] {0};
        panel.setLayout(panelLayout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(videogameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(292, 292, 292)
                .addComponent(comicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(49, Short.MAX_VALUE)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 1293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(videogameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void videogameButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videogameButtonMouseEntered

        this.videogameButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_videogameButtonMouseEntered

    private void searchButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseReleased
        // TODO add your handling code here:
        JPanel mainPanel = (JPanel) this.getParent();
       CardLayout card = (CardLayout) mainPanel.getLayout();
       searchPanel.searchFromHome(this.searchField.getText(),(String)this.comboBox.getSelectedItem());
       card.show(mainPanel, "Search");
    
    }//GEN-LAST:event_searchButtonMouseReleased

    private void videogameButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videogameButtonMouseExited

        this.videogameButton.setForeground(Color.BLACK);
    }//GEN-LAST:event_videogameButtonMouseExited

    private void comicButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comicButtonMouseEntered

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

    private void videogameButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videogameButtonMouseReleased
      panel.removeAll();
      panel.repaint();
      panel.revalidate();
      createHeaders("Videogame");
      GridBagConstraints c=new GridBagConstraints();
      c.anchor=GridBagConstraints.NORTHWEST;
     // c.weighty=0.5;
      //c.weightx=0.5;
  
      c.insets= new Insets(0, 200, 5, 5);
      List<VideogameEntry> list=videogameList.getEntryList();
      int size=list.size();
      int i;
      for( i=0;i<size;i++){ 
          ArrayList<String> params=new ArrayList<String>();
          VideogameEntry entry=list.get(i);
         
          c.gridy=i+1;
          c.gridx=0;
          String param=entry.getName();
          CustomTextField t =new CustomTextField(entry.getName());
          params.add(param);
          t.setEditable(false);
          panel.add(t,c);
          c.gridx=1;
          param=String.valueOf(entry.getValoration());
          params.add(param);
          panel.add(new CustomTextField(param),c);
          c.gridx=2;
          param=entry.getStatus();
          panel.add(new CustomTextField(param),c); 
          c.gridx=3;
          CustomButton applyButton=new CustomButton("Apply changes",c.gridy,params.toArray(new String[params.size()]));
          applyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                update(evt);
            }
    });
    
          panel.add(applyButton,c);
      }
      JPanel filler=new JPanel();
      c.gridy++;
      c.weightx=1;
      c.weighty=1;
      panel.add(filler,c);
      panel.repaint();
      panel.revalidate();
        
        
    }//GEN-LAST:event_videogameButtonMouseReleased
     private void update(java.awt.event.MouseEvent evt) {                                         
        // TODO add your handling code here:
        ArrayList<String> params=new ArrayList<String>();
        
        //UserController.getInstance().modify(,);
     }
    private void comicButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comicButtonMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_comicButtonMouseReleased

    private void showButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_showButtonMouseReleased

    private void createHeaders(String type){
        GridBagConstraints c=new GridBagConstraints();
        JLabel labelHeaders[];
        String headers[]=null;
        switch(type){
            case "Videogame":
                headers=headersVideogame;
                break;
            case "Show":
               headers=headersShow;
               break;
            case "Comic":
                headers=headersComic;
                break;
            
        }
        labelHeaders=new JLabel[headers.length];
        c.anchor=GridBagConstraints.NORTHWEST;
        //c.weighty=1;
        //c.weightx=1;
        c.gridy=0;
        c.insets= new Insets(0, 200, 5, 5);
       for(int i=0;i<labelHeaders.length;i++){
           labelHeaders[i]= new JLabel(headers[i]);
           labelHeaders[i].setFont(new Font("Ubuntu",Font.PLAIN,19));
           c.gridx=i;
           panel.add(labelHeaders[i],c);
        }
       c.gridy=1;
    
       
     
           
    }
    
    private void setLists(ElementList[] lists){
        for(int i=0;i<lists.length;i++){
            if(lists[i].getTypeList().equalsIgnoreCase("Videogame")){
                videogameList= lists[i];
            }else if(lists[i].getTypeList().equalsIgnoreCase("Show")){
                showList= lists[i];
            }else if(lists[i].getTypeList().equalsIgnoreCase("Comic")){
                comicList= lists[i];
            }
        }
    }
    JPanelSearchResults searchPanel;
    final String headersVideogame []={"Name", "Valoration", "Status"};
    final String headersShow []={"Name", "Valoration", "Status", "Watched"};
    final String headersComic []={"Name", "Valoration", "Status", "Read"};
    ElementList<VideogameEntry> videogameList;
    ElementList<ComicEntry> comicList;
    ElementList<ShowEntry> showList;
    
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

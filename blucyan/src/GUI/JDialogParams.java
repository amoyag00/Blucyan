/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.UserController;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

/**
 *
 * @author cloud
 */
public class JDialogParams extends javax.swing.JDialog {

    /**
     * Creates new form JDialogParams
     */
    public JDialogParams(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        comicFields = new ArrayList<JTextField>();
        showFields = new ArrayList<JTextField>();
        videogameFields = new ArrayList<JTextField>();

        checks.add(comicCheck);
        checks.add(showCheck);
        checks.add(videogameCheck);

        comicFields.add(chaptersText);
        comicFields.add(authorsText);
        comicFields.add(ilustratorsText);

        showFields.add(episodesText);
        showFields.add(seasonsText);
        showFields.add(durationText);
        showFields.add(directorText);
        showFields.add(actorsText);
        showFields.add(producersText);

        videogameFields.add(developerText);
        videogameFields.add(platformText);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checks = new javax.swing.ButtonGroup();
        titleLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        comicCheck = new javax.swing.JCheckBox();
        videogameCheck = new javax.swing.JCheckBox();
        showCheck = new javax.swing.JCheckBox();
        nameText = new javax.swing.JTextField();
        dateText = new javax.swing.JTextField();
        chaptersLabel = new javax.swing.JLabel();
        chaptersText = new javax.swing.JTextField();
        ilustratorsLabel = new javax.swing.JLabel();
        authorsLabel = new javax.swing.JLabel();
        authorsText = new javax.swing.JTextField();
        ilustratorsText = new javax.swing.JTextField();
        episodesLabel = new javax.swing.JLabel();
        seasonsLabel = new javax.swing.JLabel();
        durationLabel = new javax.swing.JLabel();
        producersLabel = new javax.swing.JLabel();
        directorLabel = new javax.swing.JLabel();
        actorsLabel = new javax.swing.JLabel();
        episodesText = new javax.swing.JTextField();
        seasonsText = new javax.swing.JTextField();
        durationText = new javax.swing.JTextField();
        actorsText = new javax.swing.JTextField();
        directorText = new javax.swing.JTextField();
        producersText = new javax.swing.JTextField();
        developerLabel = new javax.swing.JLabel();
        platformLabel = new javax.swing.JLabel();
        developerText = new javax.swing.JTextField();
        platformText = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        genresLabel = new javax.swing.JLabel();
        genresText = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        statusText = new javax.swing.JTextField();
        coverTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        titleLabel.setText("PARAMETERS");

        nameLabel.setText("Name: ");

        dateLabel.setText("Release date: ");

        comicCheck.setText("Comic");
        comicCheck.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comicCheckItemStateChanged(evt);
            }
        });

        videogameCheck.setText("Videogame");
        videogameCheck.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                videogameCheckItemStateChanged(evt);
            }
        });

        showCheck.setText("Show");
        showCheck.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                showCheckItemStateChanged(evt);
            }
        });

        chaptersLabel.setText("Num. chapters: ");

        chaptersText.setEnabled(false);

        ilustratorsLabel.setText("Ilustrators: ");

        authorsLabel.setText("Authors: ");

        authorsText.setEnabled(false);

        ilustratorsText.setEnabled(false);

        episodesLabel.setText("Num episodes: ");

        seasonsLabel.setText("Num seasons: ");

        durationLabel.setText("Episode duration: ");

        producersLabel.setText("Producers: ");

        directorLabel.setText("Director: ");

        actorsLabel.setText("Actors: ");

        episodesText.setEnabled(false);

        seasonsText.setEnabled(false);

        durationText.setEnabled(false);

        actorsText.setEnabled(false);

        directorText.setEnabled(false);

        producersText.setEnabled(false);

        developerLabel.setText("Developer: ");

        platformLabel.setText("Platform: ");

        developerText.setEnabled(false);

        platformText.setEnabled(false);

        addButton.setText("Add");
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addButtonMouseReleased(evt);
            }
        });

        genresLabel.setText("Genres: ");

        statusLabel.setText("Status: ");

        jLabel1.setText("Cover URL:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(videogameCheck)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(developerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(developerText, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(coverTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(statusLabel)
                                .addGap(3, 3, 3)
                                .addComponent(statusText)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(showCheck)
                                    .addComponent(comicCheck))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chaptersLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chaptersText, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(602, 602, 602)
                                        .addComponent(ilustratorsLabel))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(platformLabel)
                                            .addGap(27, 27, 27)
                                            .addComponent(platformText, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(episodesLabel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(episodesText, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(actorsLabel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(actorsText, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(30, 30, 30)
                                            .addComponent(producersLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(producersText, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(titleLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ilustratorsText, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(73, 73, 73)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(authorsLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(authorsText, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(38, 38, 38)
                                            .addComponent(genresLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(genresText, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(seasonsLabel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(seasonsText, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(256, 256, 256)
                                                    .addComponent(durationLabel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(durationText, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(27, 27, 27)
                                            .addComponent(directorLabel)
                                            .addGap(1, 1, 1)
                                            .addComponent(directorText, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(titleLabel)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel)
                    .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genresLabel)
                    .addComponent(genresText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comicCheck)
                    .addComponent(chaptersLabel)
                    .addComponent(chaptersText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorsLabel)
                    .addComponent(authorsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ilustratorsLabel)
                    .addComponent(ilustratorsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(showCheck)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(episodesLabel)
                            .addComponent(seasonsLabel)
                            .addComponent(durationLabel)
                            .addComponent(episodesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seasonsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(durationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(directorLabel)
                            .addComponent(directorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actorsLabel)
                    .addComponent(producersLabel)
                    .addComponent(actorsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(producersText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(videogameCheck)
                    .addComponent(developerLabel)
                    .addComponent(platformLabel)
                    .addComponent(developerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(platformText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(statusLabel)
                    .addComponent(statusText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coverTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comicCheckItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comicCheckItemStateChanged
        // TODO add your handling code here:
        for (int i = 0; i < showFields.size(); i++) {
            showFields.get(i).setEnabled(false);
        }

        for (int i = 0; i < videogameFields.size(); i++) {
            videogameFields.get(i).setEnabled(false);
        }

        for (int i = 0; i < comicFields.size(); i++) {
            comicFields.get(i).setEnabled(true);
        }
    }//GEN-LAST:event_comicCheckItemStateChanged

    private void showCheckItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_showCheckItemStateChanged
        // TODO add your handling code here:

        for (int i = 0; i < comicFields.size(); i++) {
            comicFields.get(i).setEnabled(false);
        }

        for (int i = 0; i < videogameFields.size(); i++) {
            videogameFields.get(i).setEnabled(false);
        }

        for (int i = 0; i < showFields.size(); i++) {
            showFields.get(i).setEnabled(true);
        }
    }//GEN-LAST:event_showCheckItemStateChanged

    private void videogameCheckItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_videogameCheckItemStateChanged
        // TODO add your handling code here:

        for (int i = 0; i < comicFields.size(); i++) {
            comicFields.get(i).setEnabled(false);
        }

        for (int i = 0; i < showFields.size(); i++) {
            showFields.get(i).setEnabled(false);
        }

        for (int i = 0; i < videogameFields.size(); i++) {
            videogameFields.get(i).setEnabled(true);
        }
    }//GEN-LAST:event_videogameCheckItemStateChanged

    private void addButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseReleased
        // TODO add your handling code here:
        if(comicCheck.isSelected()){
            String[] params = new String[10];
            
            params[0] = nameText.getText();
            params[1] = "Comic";
            params[2] = name;
            params[3] = dateText.getText();
            params[4] = chaptersText.getText();
            params[5] = authorsText.getText();
            params[6] = ilustratorsText.getText();
            params[7] = genresText.getText();
            params[8] = statusText.getText();
            params[9]= coverTextField.getText();
            
            UserController.getInstance().addElement(params);
        }
        else if(showCheck.isSelected()){
            String[] params = new String[13];
            
            params[0] = nameText.getText();
            params[1] = "Show";
            params[2] = name;
            params[3] = dateText.getText();
            params[4] = seasonsText.getText();
            params[5] = episodesText.getText();
            params[6] = durationText.getText();
            params[7] = directorText.getText();
            params[8] = actorsText.getText();
            params[9] = producersText.getText();
            params[10] = genresText.getText();
            params[11] = statusText.getText();
            params[12]= coverTextField.getText();
            
            UserController.getInstance().addElement(params);
        }
        else if(videogameCheck.isSelected()){
            String[] params = new String[9];
            
            params[0] = nameText.getText();
            params[1] = "Videogame";
            params[2] = name;
            params[3] = dateText.getText();
            params[4] = platformText.getText();
            params[5] = developerText.getText();
            params[6] = genresText.getText();
            params[7] = statusText.getText();
            params[8]= coverTextField.getText();
            
            UserController.getInstance().addElement(params);
        }
    }//GEN-LAST:event_addButtonMouseReleased

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
 /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialogParams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogParams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogParams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogParams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
 /*    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogParams dialog = new JDialogParams(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }*/
    private String name;
    private JFileChooser selecter;
    private ArrayList<JTextField> comicFields;
    private ArrayList<JTextField> showFields;
    private ArrayList<JTextField> videogameFields;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actorsLabel;
    private javax.swing.JTextField actorsText;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel authorsLabel;
    private javax.swing.JTextField authorsText;
    private javax.swing.JLabel chaptersLabel;
    private javax.swing.JTextField chaptersText;
    private javax.swing.ButtonGroup checks;
    private javax.swing.JCheckBox comicCheck;
    private javax.swing.JTextField coverTextField;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateText;
    private javax.swing.JLabel developerLabel;
    private javax.swing.JTextField developerText;
    private javax.swing.JLabel directorLabel;
    private javax.swing.JTextField directorText;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JTextField durationText;
    private javax.swing.JLabel episodesLabel;
    private javax.swing.JTextField episodesText;
    private javax.swing.JLabel genresLabel;
    private javax.swing.JTextField genresText;
    private javax.swing.JLabel ilustratorsLabel;
    private javax.swing.JTextField ilustratorsText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JLabel platformLabel;
    private javax.swing.JTextField platformText;
    private javax.swing.JLabel producersLabel;
    private javax.swing.JTextField producersText;
    private javax.swing.JLabel seasonsLabel;
    private javax.swing.JTextField seasonsText;
    private javax.swing.JCheckBox showCheck;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField statusText;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JCheckBox videogameCheck;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Logic.ComicEntry;
import Logic.Entry;
import Logic.ShowEntry;
import Logic.VideogameEntry;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author alex
 */
public class CustomButton extends JButton{
    private int row;
    CustomTextField params[];
    Entry entry;
    public CustomButton(String name,int row, CustomTextField params[],Entry entry){
        super(name);
        this.row=row;
        this.params=params;
        this.entry=entry;
    
    }       
    public VideogameEntry getUpdatedVideogameEntry(){
        
        
        entry.setValoration(Integer.valueOf(params[0].getText()));
        entry.setStatus(params[1].getText());
        
        ArrayList<String> params=new ArrayList<String>();
        for(int i=0;i<this.params.length;i++){
            params.add(this.params[i].getText());
        }
        return (VideogameEntry)entry;
    }
    
    public ComicEntry getUpdatedComicEntry(){
        ComicEntry entry=(ComicEntry)this.entry;
        
        entry.setValoration(Integer.valueOf(params[0].getText()));
        entry.setStatus(params[1].getText());
        entry.setNumReadChapters(Integer.valueOf(params[2].getText()));
        ArrayList<String> params=new ArrayList<String>();
        for(int i=0;i<this.params.length;i++){
            params.add(this.params[i].getText());
        }
        return entry;
    }
    public ShowEntry getUpdatedShowEntry(){
        
        
       ShowEntry entry=(ShowEntry)this.entry;
        
        entry.setValoration(Integer.valueOf(params[0].getText()));
        entry.setStatus(params[1].getText());
        entry.setNumWatchedEpisodes(Integer.valueOf(params[2].getText()));
        ArrayList<String> params=new ArrayList<String>();
        for(int i=0;i<this.params.length;i++){
            params.add(this.params[i].getText());
        }
        return entry;
    }
    
    
}


package audioplayer;

import java.io.*;
import java.util.*;
import javax.swing.*;
import javazoom.jl.decoder.*;
import javazoom.jl.player.Player;

public class MusicClass 
{
    //variables section.
    
    FileInputStream FIS;
    BufferedInputStream BIS;
    
    public Player player;
    
    long pauseLocation;
    long songTotal;
    
    int avilabe;
    int n;
    int size;
    
    Thread theThread;
    
    boolean Paused;
    
    //////////////////////////////////////////////////////////
    //functions section.
    //////////////////////////////////////////////////////////
    
    public void Stop()
    {
        if(player!=null)
        {
            Paused=false;
            player.close(); 
        }
    }
    
    //////////////////////////////////////////////////////////
    
    public void Play(String path , JSlider slider)
    {    
        try 
        {            
            FIS = new FileInputStream(path);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            songTotal = FIS.available();     
        }
        catch (JavaLayerException | FileNotFoundException ex) 
        {
            System.out.println(""+ex);
        } 
        catch (IOException ex) 
        {   
            System.out.println(""+ex);

        } 
        
        //play thread
        theThread = new Thread(new Runnable() 
        {
            @Override
            public void run() {
               try 
                {                   
                    if(Paused == false)
                    {
                        player.play();                                            
                    }
                    //for resume
                    else if(Paused == true)
                    {
                        Paused=false;
                        BIS.skip(songTotal - pauseLocation);
                        player.play();  
                    }
                    
                    //for replay the song.
                    if(player.isComplete() && GUI.count==1)
                    {
                        Play(path, slider);
                    }
                    
                    //for random.
                    if(player.isComplete() && GUI.count==0 && GUI.rand==true)
                    {
                       size = GUI.theList.getModel().getSize();
                       
                       Random r = new Random();
                       n = r.nextInt(size);
                       
                       GUI.theList.setSelectedIndex(n);
                       GUI.PLAY(n);
                    }
 
                    //for play the next song automatically when the song complete.
                    if(player.isComplete() && GUI.count==0 && GUI.rand==false)
                    {
                        GUI.theList.setSelectedIndex(GUI.index++);
                        GUI.PLAY(GUI.index);    
                    }
                } 
                catch (JavaLayerException | IOException ex)
                   
                {
                    System.out.println(""+ex);
                }    
            }
        });
        theThread.start();
        
        //about slider
        
        slider.setMinimum(0);
        slider.setMaximum((int)songTotal);
        
        //slider thread
        new Thread(new Runnable() 
        {
            public void run() 
            {
                while(theThread.isAlive())
                {
                    try
                    {
                        slider.setValue((int)(songTotal-BIS.available()));                       
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println(""+ex);
                    }
                }
            }
        }).start();  
    }
     
    //////////////////////////////////////////////////////////
     
    public void Pause()
    {
        if(player!=null)
        {
            Paused = true;
            
            try 
            {
                pauseLocation = BIS.available();
                player.close();
            } 
            catch (IOException ex) 
            {
                System.out.println(" "+ex);
            }           
        }
    }  
}


package audioplayer;

import java.awt.*;
import java.awt.dnd.DropTarget;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class GUI extends javax.swing.JFrame 
{    
    static MusicClass MC = new MusicClass(); 
    
    ImageIcon playIcon = new ImageIcon("src\\icons\\icons_play-48.png");
    ImageIcon pauseIcon = new ImageIcon("src\\icons\\icon-pause-48.png");
    
    public static boolean rand=false;
    Random rnd = new Random(4);
   

    public static int count=0;
    public static int index=0;
    int size;
    
    boolean showList=false;
    
    String Song;
    public static String Name; 
    
    public GUI() 
    {      
        initComponents();  
        setLocationRelativeTo(null);  
        this.setSize(396, 360); 
        
       DragDropList();
    }

    public void DragDropList()
    {
        DragList dl = new DragList(theList);
        new DropTarget(this, dl);    
    }
    private void addToTheList()
    {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3");
        JFileChooser chooser = new JFileChooser("E:\\Music");
            chooser.addChoosableFileFilter(filter);
            chooser.setMultiSelectionEnabled(true);
            int returnVal = chooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                File[] myFiles = chooser.getSelectedFiles();
                  for (File f : myFiles)
                {
                    String path = f.getPath();
                    if(theList.getModel().getSize()==0)
                    {
                        DefaultListModel d=new DefaultListModel();
                        d.addElement(path);
                        theList.setModel(d);
                    }
                    else
                    {
                        ((DefaultListModel)theList.getModel()).addElement(path);
                    }
                }
            }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        theList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        playPause = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        next = new javax.swing.JButton();
        Random = new javax.swing.JButton();
        seeSlider = new javax.swing.JSlider();
        rePlay = new javax.swing.JButton();
        addToListLabel = new javax.swing.JLabel();
        removeFromList = new javax.swing.JLabel();
        showTheList = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openItem = new javax.swing.JMenuItem();
        closeItem = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AudioPlayer");
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        theList.setBackground(new java.awt.Color(204, 204, 204));
        theList.setForeground(new java.awt.Color(0, 0, 0));
        theList.setToolTipText("PlayList");
        theList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        theList.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        theList.setDragEnabled(true);
        theList.setDropMode(javax.swing.DropMode.ON_OR_INSERT);
        theList.setName(""); // NOI18N
        jScrollPane1.setViewportView(theList);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 130));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 390, 150));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        playPause.setBackground(new java.awt.Color(51, 102, 0));
        playPause.setForeground(new java.awt.Color(0, 0, 0));
        playPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons_play-48.png"))); // NOI18N
        playPause.setToolTipText("Play/Pause");
        playPause.setBorder(null);
        playPause.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                playPauseActionPerformed(evt);
            }
        });
        getContentPane().add(playPause, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 50, 50));

        previous.setBackground(new java.awt.Color(51, 102, 0));
        previous.setForeground(new java.awt.Color(0, 0, 0));
        previous.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/black_4_audio_title_back-24.png"))); // NOI18N
        previous.setToolTipText("Previous");
        previous.setBorder(null);
        previous.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                previousActionPerformed(evt);
            }
        });
        getContentPane().add(previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 30, 30));

        stop.setBackground(new java.awt.Color(51, 102, 0));
        stop.setForeground(new java.awt.Color(0, 0, 0));
        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/black_4_audio_stop-24.png"))); // NOI18N
        stop.setToolTipText("Stop");
        stop.setBorder(null);
        stop.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                stopActionPerformed(evt);
            }
        });
        getContentPane().add(stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 30, 30));

        next.setBackground(new java.awt.Color(51, 102, 0));
        next.setForeground(new java.awt.Color(0, 0, 0));
        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/black_4_audio_title_forward-24.png"))); // NOI18N
        next.setToolTipText("Next");
        next.setBorder(null);
        next.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                nextActionPerformed(evt);
            }
        });
        getContentPane().add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 30, 30));

        Random.setBackground(new java.awt.Color(51, 102, 0));
        Random.setForeground(new java.awt.Color(0, 0, 0));
        Random.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/black_2_audio_simple_random-24.png"))); // NOI18N
        Random.setToolTipText("Random");
        Random.setBorder(null);
        Random.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                RandomActionPerformed(evt);
            }
        });
        getContentPane().add(Random, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 30, 30));

        seeSlider.setBackground(new java.awt.Color(51, 102, 0));
        seeSlider.setForeground(new java.awt.Color(0, 0, 0));
        seeSlider.setToolTipText("");
        seeSlider.setValue(0);
        seeSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.SE_RESIZE_CURSOR));
        seeSlider.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                seeSliderStateChanged(evt);
            }
        });
        getContentPane().add(seeSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, 20));

        rePlay.setBackground(new java.awt.Color(51, 102, 0));
        rePlay.setForeground(new java.awt.Color(0, 0, 0));
        rePlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/black_2_audio_simple_repeat_2-24.png"))); // NOI18N
        rePlay.setToolTipText("rePlay");
        rePlay.setBorder(null);
        rePlay.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rePlayActionPerformed(evt);
            }
        });
        getContentPane().add(rePlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 30, 30));

        addToListLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        addToListLabel.setForeground(new java.awt.Color(204, 204, 204));
        addToListLabel.setText("+");
        addToListLabel.setToolTipText("Add song/s to list");
        addToListLabel.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                addToListLabelMouseClicked(evt);
            }
        });
        getContentPane().add(addToListLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        removeFromList.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        removeFromList.setForeground(new java.awt.Color(204, 204, 204));
        removeFromList.setText("_");
        removeFromList.setToolTipText("Remove the selected song from list");
        removeFromList.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                removeFromListMouseClicked(evt);
            }
        });
        getContentPane().add(removeFromList, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, -1));

        showTheList.setBackground(new java.awt.Color(51, 51, 51));
        showTheList.setForeground(new java.awt.Color(204, 204, 204));
        showTheList.setText("▲");
        showTheList.setToolTipText("Show/Hide List");
        showTheList.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                showTheListMouseClicked(evt);
            }
        });
        getContentPane().add(showTheList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\AudioPlayer (drag drop)\\The Project\\src\\icons\\img_1383304661_304.jpg")); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 0, 540, 350));

        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, -10, 10, 170));

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu1.setBackground(new java.awt.Color(102, 102, 102));
        jMenu1.setForeground(new java.awt.Color(204, 204, 204));
        jMenu1.setText("File");

        openItem.setText("OPEN");
        openItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                openItemActionPerformed(evt);
            }
        });
        jMenu1.add(openItem);

        closeItem.setText("CLOSE");
        closeItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                closeItemActionPerformed(evt);
            }
        });
        jMenu1.add(closeItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openItemActionPerformed
                   
        addToTheList();
        
    }//GEN-LAST:event_openItemActionPerformed

    private void closeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeItemActionPerformed
            System.exit(0);      
    }//GEN-LAST:event_closeItemActionPerformed

    private void rePlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rePlayActionPerformed

        switch(count)
        {
            case 0:       
                count=1;
                System.out.println(count);               
                rePlay.setBackground(Color.GRAY);
                break;           
            case 1:
                count=0;
                System.out.println(count);
                rePlay.setBackground(Color.DARK_GRAY);
                break;
        }
    }//GEN-LAST:event_rePlayActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed

        if(theList.getModel().getSize()>0)
        {
            MC.Stop();
            if(rand==false)
            {
                index = theList.getSelectedIndex() - 1;
                theList.setSelectedIndex(index);
            }
            else if(rand==true)
            {
                size = theList.getModel().getSize();       
                index = rnd.nextInt(size);
                theList.setSelectedIndex(index);
            }
        
            PLAY(index);
        
            Name = theList.getSelectedValue().toString();
            this.setTitle(Name);        
        }
        else if(theList.getModel().getSize()==0)
        {
            System.out.println("Empty!");
        }
    }//GEN-LAST:event_previousActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed

        if(theList.getModel().getSize()>0)
        {
            MC.Stop();
        
            if(rand==false)
            {
                index = theList.getSelectedIndex() + 1;
                theList.setSelectedIndex(index);
            }
            else if(rand==true)
            {
                size = theList.getModel().getSize();       
                index = rnd.nextInt(size);
                theList.setSelectedIndex(index);
            }
            PLAY(index);
        
            Name = theList.getSelectedValue().toString();
            this.setTitle(Name); 
        }
        else if(theList.getModel().getSize()==0)
        {
            System.out.println("Empty!");
        }     
    }//GEN-LAST:event_nextActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
       
        if(theList.getModel().getSize()>0)
        {
            if(MC.theThread.isAlive())
            {
                MC.Stop();
                playPause.setIcon(playIcon);
            
                this.setTitle("AudioPlayer");
            }
            else if(!MC.theThread.isAlive())
            {
                System.out.println("already stoped!");
            }   
        }
        else if(theList.getModel().getSize()==0)
        {
            System.out.println("Empty!");
        }       
    }//GEN-LAST:event_stopActionPerformed

    private void playPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPauseActionPerformed
        if(theList.getModel().getSize()==0)
        {
            openItemActionPerformed(evt);
            playPause.setIcon(pauseIcon);
            
            theList.setSelectedIndex(index);
            PLAY(theList.getSelectedIndex());
            
            playPause.setIcon(pauseIcon);
            Name = theList.getSelectedValue().toString();
            this.setTitle(Name);
        }
        else
        {
            if(MC.theThread==null || !MC.theThread.isAlive())
            {
                
                PLAY(theList.getSelectedIndex());
                playPause.setIcon(pauseIcon); 
                Name = theList.getSelectedValue().toString();
                this.setTitle(Name);
            }
            else if(MC.theThread.isAlive())
            {
                MC.Pause();
                playPause.setIcon(playIcon);
            }
            else
            {
                PLAY(index);
            }
        }    
    }//GEN-LAST:event_playPauseActionPerformed
  
    private void addToListLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToListLabelMouseClicked

        addToTheList();
    }//GEN-LAST:event_addToListLabelMouseClicked

    private void removeFromListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeFromListMouseClicked

        index = theList.getSelectedIndex();
        ((DefaultListModel) theList.getModel()).remove(index);
        theList.setSelectedIndex(index);
    }//GEN-LAST:event_removeFromListMouseClicked

    private void RandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RandomActionPerformed
         
        if(rand==false)
        {
            rand=true;            
            Random.setBackground(Color.GRAY);    
            System.out.println("true");
        }
        else if(rand==true)
        { 
            rand=false;
            Random.setBackground(Color.DARK_GRAY);
            System.out.println("false");
        }             
    }//GEN-LAST:event_RandomActionPerformed

    private void seeSliderStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_seeSliderStateChanged
    {//GEN-HEADEREND:event_seeSliderStateChanged

    }//GEN-LAST:event_seeSliderStateChanged

    private void showTheListMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_showTheListMouseClicked
    {//GEN-HEADEREND:event_showTheListMouseClicked
        if(showList==true)
        {
            showList=false;
            this.setSize(396, 360); 
            showTheList.setText("▲");                  
        }
        else if(showList==false)
        {             
            showList=true; 
            this.setSize(396, 215);
            showTheList.setText("▼");
        }   
    }//GEN-LAST:event_showTheListMouseClicked
    
    public static void PLAY(int index)
    {
        theList.setSelectedIndex(index);
        
        String s =theList.getSelectedValue().toString();
          
        MC.Play(s, seeSlider);
    }
       
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run()
            {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Random;
    private javax.swing.JLabel addToListLabel;
    private javax.swing.JMenuItem closeItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton next;
    private javax.swing.JMenuItem openItem;
    private javax.swing.JButton playPause;
    private javax.swing.JButton previous;
    private javax.swing.JButton rePlay;
    private javax.swing.JLabel removeFromList;
    public static javax.swing.JSlider seeSlider;
    private javax.swing.JLabel showTheList;
    private javax.swing.JButton stop;
    public static javax.swing.JList theList;
    // End of variables declaration//GEN-END:variables
}

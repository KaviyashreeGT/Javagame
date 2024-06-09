import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class WhacAMole{
    int boardWidth=600;
    int boardHeight=650;
    JFrame frame=new JFrame ("mario:Whac A Mole");
    JLabel textLabel=new JLabel();
    JPanel textPanel=new JPanel();
    JPanel boardPanel=new JPanel();

    JButton[] board=new JButton[9];
    ImageIcon moleIcon;
    ImageIcon plantIcon;
    JButton currMoleTile;
    JButton currPlantTile;
    Random random=new Random();
    Timer setMoleTimer;
    Timer setPlantTimer;
    int score=0;
    

    WhacAMole(){
        //frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        textLabel.setFont(new Font("Arial",Font.PLAIN,50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Score:0");
        textLabel.setOpaque(true);
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel);
        frame.add(textPanel,BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3,3));
        //boardPanel.setBackground(Color.black);
        frame.add(boardPanel);
        try{
       // plantIcon=new ImageIcon("C:\\kaviya\\WhacAMole\\piranhaplant2.png");
       
       Image plantImg=new ImageIcon(("C:\\kaviya\\WhacAMole\\piranhaplant2.png")).getImage();
       plantIcon=new ImageIcon(plantImg.getScaledInstance(200,180,java.awt.Image.SCALE_SMOOTH));
       
       Image moleImg=new ImageIcon(("C:\\kaviya\\WhacAMole\\monty.png")).getImage();
       moleIcon=new ImageIcon(moleImg.getScaledInstance(200,180,java.awt.Image.SCALE_SMOOTH));
        }catch(Exception e){
            System.err.println("Error loaading image:"+e.getMessage());
        } 
        score=0;
       
        for (int i=0;i<9;i++){
            JButton tile=new JButton();
            board[i]=tile;
            boardPanel.add(tile);
            tile.setFocusable(false);
            //tile.setIcon(moleIcon);
            tile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JButton tile=(JButton)e.getSource();
                    if(tile==currMoleTile){
                        score+=10;
                        textLabel.setText("Score:"+Integer.toString(score));


                    }
                    else if(tile==currPlantTile){
                        textLabel.setText("GameOver:"+Integer.toString(score));
                        setMoleTimer.stop();
                        setPlantTimer.stop();
                        for(int i=0;i<9;i++){
                            board[i].setEnabled(false);
                            

                        }

                    }


                }
                
            });
         }
         setMoleTimer = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //remove mole from current tile
                if(currMoleTile!=null){
                    currMoleTile.setIcon(null);
                    currMoleTile=null;

                }
                //randomly select another tile
                int num=random.nextInt(9);
                JButton tile=board[num];

                //if tile is occupied by plant ,skip tile for thid turn
                if (currPlantTile == tile) return;

                //set tile to mole
                currMoleTile = tile;
                currMoleTile.setIcon(moleIcon);

            }

         });
         setPlantTimer=new Timer(1500,new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(currPlantTile!=null){
                    currPlantTile.setIcon(null);
                    currPlantTile=null;

                }
                int num=random.nextInt(9);
                JButton tile=board[num];

                if(currMoleTile==tile)return;
                currPlantTile=tile;
                currPlantTile.setIcon(plantIcon);


            }
            
         });
         setMoleTimer.start();
         setPlantTimer.start();
         frame.setVisible(true);
        }

    }



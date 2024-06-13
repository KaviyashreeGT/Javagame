import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
public class SnakeGame extends JPanel implements ActionListener ,KeyListener {
    private class Tile{
        int x;
        int y;
        Tile(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    int boardHeight;
    int boardWidth;
    int tilesize=25;
    //snake
    Tile snakeHead;
    ArrayList<Tile>snakeBody;
    //Food
    Tile food;
    Random random;
    //Gamelogic
    Timer gameLoop;
    int velocityx;
    int velocityy;
    boolean gameOver=false;

    public SnakeGame(int boardWidth,int boardHeight)
    {
        this.boardWidth=boardWidth;
        this.boardHeight=boardHeight;
        setPreferredSize(new Dimension(this.boardWidth,this.boardHeight));
        setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);

        snakeHead=new Tile(5,5);
        snakeBody =new ArrayList<Tile>();
        food=new Tile(10,10 );
        random=new Random();
        placeFood();

        velocityx=0;
        velocityy=0;


        gameLoop=new Timer(100,this);
        gameLoop.start(); 



    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        //Grid
       // for (int i=0;i<boardWidth/tilesize;i++){
            //(x1,y1,x2,y2)
          //  g.drawLine(i*tilesize,0,i*tilesize,boardHeight);
          //  g.drawLine(0,i*tilesize,boardWidth,i*tilesize); 

        //}
        //food
        g.setColor(Color.red);
        //g.fillRect(food.x*tilesize,food.y*tilesize,tilesize,tilesize);
        g.fill3DRect(food.x*tilesize,food.y*tilesize,tilesize,tilesize,true);
        //Snakehead
        g.setColor(Color.green);
        //g.fillRect(snakeHead.x*tilesize,snakeHead.y*tilesize,tilesize,tilesize);
        g.fill3DRect(snakeHead.x*tilesize,snakeHead.y*tilesize,tilesize,tilesize,true);
        //snake body
        for(int i=0;i<snakeBody.size();i++){
            Tile snakePart=snakeBody.get(i);
            //g.fillRect(snakePart.x*tilesize,snakePart.y*tilesize,tilesize,tilesize);
            g.fill3DRect(snakePart.x*tilesize,snakePart.y*tilesize,tilesize,tilesize,true);


        }
        //score
        g.setFont(new Font("Arial",Font.PLAIN,16));
        if(gameOver){
            g.setColor(Color.red);
            g.drawString("Game Over:"+String.valueOf(snakeBody.size()),tilesize-16,tilesize);
        }
        else{
            g.drawString("Score:"+String.valueOf(snakeBody.size()),tilesize-16,tilesize);
        }

    }
    public void placeFood(){
        food.x=random.nextInt(boardWidth/tilesize);//600/25=24
        food.y=random.nextInt(boardHeight/tilesize);//600/25=24

    }
    public boolean collision(Tile tile1,Tile tile2){
        return tile1.x==tile2.x&&tile1.y==tile2.y;

    }

    public void move(){
        //eatfood
        if(collision(snakeHead,food)){
            snakeBody.add(new Tile(food.x,food.y));
            placeFood();
        }
        //snake body
        for(int i=snakeBody.size()-1;i>=0;i--){
            Tile snakePart=snakeBody.get(i);
            if(i==0){
                snakePart.x=snakeHead.x;
                snakePart.y=snakeHead.y;

            }
            else{
                Tile prevsnakePart=snakeBody.get(i-1);
                snakePart.x=prevsnakePart.x;
                snakePart.y=prevsnakePart.y;
            }

        }
        

        //Snakehead
        snakeHead.x+=velocityx;
        snakeHead.y+=velocityy;
        //game over conditions
        for (int i=0;i<snakeBody.size();i++){
            Tile snakePart=snakeBody.get(i);
            //collide with the snake head
            if(collision(snakeHead,snakePart)){
                gameOver=true;
            }

        }
        if(snakeHead.x*tilesize<0||snakeHead.x*tilesize>boardWidth||
        snakeHead.y*tilesize<0||snakeHead.y*tilesize>boardHeight){
            gameOver=true;
        }



    }
    @Override
    public void actionPerformed(ActionEvent e){
        move();
        repaint();
        if(gameOver){
            gameLoop.stop();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP && velocityy!=1){
            velocityx=0;
            velocityy=-1;
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN && velocityy!=-1){
            velocityx=0;
            velocityy=1;
        }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT && velocityx!=1){
            velocityx=-1;
            velocityy=0;
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT && velocityx!=-1){
            velocityx=1;
            velocityy=0;
        }
    }
       
    //do not need
    @Override
    public void keyTyped(KeyEvent e) {}
       
   
    @Override
    public void keyReleased(KeyEvent e) {}
        
}

    





    
  

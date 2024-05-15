import javax.swing.*;
public class app{
    public static void main(String[]args)throws Exception{
        int boardHeight=600;
        int boardWidth=boardHeight;
        JFrame frame = new JFrame("SNAKE");
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        


        SnakeGame snake=new SnakeGame(boardWidth,boardHeight);
        frame.add(snake);
        frame.pack();
        snake.requestFocus();






    }

}
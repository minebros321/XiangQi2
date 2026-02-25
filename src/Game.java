import java.awt.*;
import javax.swing.*;

public class Game extends JPanel
{
    Piece[][] board=new Piece[10][9];
    int turn; //0-red 1-black

    public Game(){
        turn=0;
        this.setPreferredSize(new Dimension(910,1010));
        board=new Piece[10][9];
        //black
        board[0][0]=new Chariot(0,0,"Black_Chariot.png",1);
        board[0][8]=new Chariot(8,0,"Black_Chariot.png",1);
        //board[1][0]=new Horse(0,1,"Black_Horse.png",1);
        //board[0][7]=new Horse(7,0,"Black_Horse.png",1);
        board[0][2]=new Elephant(2,0,"Black_Elephant.png",1);
        board[0][6]=new Elephant(6,0,"Black_Elephant.png",1);
        board[0][3]=new Guard(3,0,"Black_Guard.png",1);
        board[0][5]=new Guard(5,0,"Black_Guard.png",1);
        board[0][4]=new General(4,0,"Black_General.png",1);
        for(int x=0;x<9;x+=2) board[3][x] = new Soldier(x, 3, "Black_Soldier.png", 1);
        board[2][1]=new Cannon(1,2,"Black_Cannon.png",1);
        board[2][7]=new Cannon(7,2,"Black_Cannon.png",1);
        //red
        board[9][4]=new General(4,9,"Red_General.png",0);
        board[9][5]=new Guard(5,9,"Red_Guard.png",0);
        board[9][3]=new Guard(3,9,"Red_Guard.png",0);
        board[9][6]=new Elephant(6,9,"Red_Elephant.png",0);
        board[9][2]=new Elephant(2,9,"Red_Elephant.png",0);
        board[9][7]=new Horse(7,9,"Red_Horse.png",0);
        board[9][1]=new Horse(1,9,"Red_Horse.png",0);
        board[9][8]=new Chariot(8,9,"Red_Chariot.png",0);
        board[9][0]=new Chariot(0,9,"Red_Chariot.png",0);
        board[6][0]=new Soldier(0,6,"Red_Soldier.png",0);
        board[6][2]=new Soldier(2,6,"Red_Soldier.png",0);
        board[6][4]=new Soldier(4,6,"Red_Soldier.png",0);
        board[6][6]=new Soldier(6,6,"Red_Soldier.png",0);
        board[6][8]=new Soldier(8,6,"Red_Soldier.png",0);
        board[7][1]=new Cannon(1,7,"Red_Cannon.png",0);
        board[7][7]=new Cannon(7,7,"Red_Cannon.png",0);


    }
    public void paintComponent( Graphics window ) {
        window.setColor(new Color(145,111,46));
        window.fillRect(0,0,910,1010);
        window.setColor(new Color(211,194,129));
        window.fillRect(8,8,894,994);
        window.setColor(new Color(145,111,46));
        window.fillRect(40,40,830,930);
        window.setColor(new Color(239,217,143));
        window.fillRect(55,55,800,900);
        // top left of board x:55 y:55
        // bottom right of board x:855 y:955
        // board is 800 by 900
        window.setColor(new Color(145,111,46));
        Graphics2D g = (Graphics2D) window;
        g.setStroke(new BasicStroke(4));
        for(int x=0;x<10;x++){
            g.drawLine(55,x*100+55,855,x*100+55);
            g.drawLine(100*x+55,55,100*x+55,455);
            g.drawLine(100*x+55,555,100*x+55,955);
        }
        g.drawLine(355,55,555,255);
        g.drawLine(555,55,355,255);
        g.drawLine(355,755,555,955);
        g.drawLine(555,755,355,955);

        for(int x=0;x<10;x++){
            for(int y=0;y<9;y++){
                if(board[x][y]!=null) {
                    board[x][y].paint(window);
                }
            }
        }



    }
    public void run()
    {

        try
        {
            while( true )
            {
                Thread.sleep(10);
                repaint();
            }
        }
        catch( Exception e )
        {

        }

    }

}
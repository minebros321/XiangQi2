import java.awt.*;
import javax.swing.*;

public class Game extends JPanel
{
    Piece[][] board=new Piece[10][9];
    int turn; //0-red 1-black

    public Game(){
        turn=0;
        this.setPreferredSize(new Dimension(910,1010));

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





    }

}
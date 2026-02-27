import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Piece extends JPanel{
    int x;
    int y;
    int color;
    String image;
    Boolean highlight;


    public Piece(int file, int rank, String i,int c){
        x = file;
        y = rank;
        image=i;
        color=c;
        highlight=false;
    }

    public ArrayList<Point> check(Piece[][] p) {
        return null;
    }
    public void move(int xx,int yy){
        x=xx;
        y=yy;
    }

    public void paint( Graphics window )
    {
        if(highlight) {
            window.setColor(new Color(124, 154, 114));
            window.fillRect(x * 100 + 55 - 95 / 2, y * 100 + 55 - 95 / 2, 95, 95);
        }
        Graphics2D g2 = (Graphics2D) window;
        Image img1 = Toolkit.getDefaultToolkit().getImage(image); /*the image cannot be in the SRC folder*/
        g2.drawImage(img1, x*100+55-85/2 , y*100+55-85/2 , 85 , 85 , this);
    }
}

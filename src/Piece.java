import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Piece extends JPanel{
    int x;
    int y;
    int color;
    String image;

    public Piece(int file, int rank, String i,int c){
        x = file;
        y = rank;
        image=i;
        color=c;
    }

    public ArrayList<Point> check() {
        return null;
    }

    public void paint( Graphics window )
    {
        Graphics2D g2 = (Graphics2D) window;
        Image img1 = Toolkit.getDefaultToolkit().getImage(image); /*the image cannot be in the SRC folder*/
        g2.drawImage(img1, x*100+55-85/2 , y*100+55-85/2 , 85 , 85 , this);
    }
}

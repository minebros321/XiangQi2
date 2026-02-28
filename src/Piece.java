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
        Graphics2D g2 = (Graphics2D) window;
        Image img1 = Toolkit.getDefaultToolkit().getImage(image); /*the image cannot be in the SRC folder*/

        if(highlight) {
            float opacity = 0.7f; // 50% opacity
            // Set the composite
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
            g2.setComposite(ac);
            g2.setColor(new Color(93, 156, 79));
            window.fillRect(x * 100 + 60 - 50, y * 100 + 60 - 50, 100, 100);
            opacity=1f;
            ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
            g2.setComposite(ac);
        }
        g2.drawImage(img1, x*100+60-90/2 , y*100+60-90/2 , 90 , 90 , this);
    }
    public String toString(){
        return "X:"+x+" Y:"+y+" "+image.substring(0,image.length()-4)+" Color:"+color;
    }
}

import javax.swing.*;
import java.awt.*;

public class Piece extends JPanel{
     int x;
    int y;
    int color;
    String image;

    public Piece(int ex, int wy, String i,int c){
        x = ex;
        y = wy;
        image=i;
        color=c;
    }

    public void paint( Graphics window )
    {
        window.setColor( Color.RED );
        Graphics2D g2 = (Graphics2D) window;
        Image img1 = Toolkit.getDefaultToolkit().getImage(image); /*the image cannot be in the SRC folder*/
        g2.drawImage(img1, x , y , 85 , 85 , this);
    }
}

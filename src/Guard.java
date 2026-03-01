import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Guard extends Piece {

    public Guard(int ex, int wy, String i, int c) {
        super(ex, wy, i, c);
    }
    public ArrayList<Point> check(Piece[][] p){
        ArrayList<Point> out=new ArrayList<>();
        if(y>7&&color==0||y>0&&color==1){
            if(x>3&&(p[y-1][x-1]==null||p[y-1][x-1].color!=color)){
                out.add(new Point(x-1,y-1));
            }
            if(x<5&&(p[y-1][x+1]==null||p[y-1][x+1].color!=color)){
                out.add(new Point(x+1,y-1));
            }
        }
        if(y<9&&color==0||y<2&&color==1){
            if(x>3&&(p[y+1][x-1]==null||p[y+1][x-1].color!=color)){
                out.add(new Point(x-1,y+1));
            }
            if(x<5&&(p[y+1][x+1]==null||p[y+1][x+1].color!=color)){
                out.add(new Point(x+1,y+1));
            }
        }
        return out;
    }
}

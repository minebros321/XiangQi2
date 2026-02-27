import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Soldier extends Piece {

    public Soldier(int ex, int wy, String i, int c) {
        super(ex, wy, i, c);
    }
    public ArrayList<Point> check(Piece[][] p){
        ArrayList<Point> out=new ArrayList<>();
        if(color==0){
            if(y<=4){
                if(x>0&&p[x][y-1]==null||p[x][y-1].color==1){
                    out.add(new Point(x,y-1));
                }
                if(x<8&&p[x][y+1]==null||p[x][y+1].color==1){
                    out.add(new Point(x,y+1));
                }
            }
            if(y>0&&p[x][y-1]==null||p[x][y-1].color==1){
                out.add(new Point(x,y-1));
            }
        }
        if(color==1){
            if(y>4){
                if(x>0&&p[x][y-1]==null||p[x][y-1].color==0){
                    out.add(new Point(x,y-1));
                }
                if(x<8&&p[x][y+1]==null||p[x][y+1].color==0){
                    out.add(new Point(x,y+1));
                }
            }
            if(y<9&&p[x][y+1]==null||p[x][y+1].color==0){
                out.add(new Point(x,y+1));
            }
        }
        return out;
    }
}

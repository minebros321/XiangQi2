import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class General extends Piece {

    public General(int ex, int wy, String i, int c) {
        super(ex, wy, i, c);
    }
    public ArrayList<Point> check(Piece[][] p){
        ArrayList<Point> out=new ArrayList<>();
        if(y>7&&color==0||y>0&&color==1) {
            if (p[y-1][x]==null||p[y-1][x].color!=color){
                out.add(new Point(x, y - 1));
            }
        }
        if(y<9&&color==0||y<2&&color==1) {
            if(p[y+1][x]==null||p[y+1][x].color!=color){
                out.add(new Point(x,y+1));
            }
        }
        if(x>3) {
            if(p[y][x-1]==null||p[y][x-1].color!=color){
                out.add(new Point(x-1, y));
            }
        }
        if(x<5) {
            if(p[y][x+1]==null||p[y][x+1].color!=color){
                out.add(new Point(x+1,y));
            }
        }
        return out;
    }
}

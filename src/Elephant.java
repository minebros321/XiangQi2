import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Elephant extends Piece {

    public Elephant(int ex, int wy, String i, int c) {
        super(ex, wy, i, c);
    }
    public ArrayList<Point> check(Piece[][] p){
        ArrayList<Point> out=new ArrayList<>();
        if(y>1&&color==1||y>6&&color==0){
            if(x>1&&p[y-1][x-1]==null&&p[y-2][x-2]==null||p[y-2][x-2].color!=color){
                out.add(new Point(x-2,y-2));
            }
            if(x<8&&p[y-1][x+1]==null&&p[y-2][x+2]==null||p[y-2][x+2].color!=color){
                out.add(new Point(x+2,y-2));
            }
        }
        if(y<8&&color==0||y<3&&color==1){
            if(x>1&&p[y+1][x-1]==null&&p[y+2][x-2]==null||p[y+2][x-2].color!=color){
                out.add(new Point(x-2,y+2));
            }
            if(x<8&&p[y+1][x+1]==null&&p[y+2][x+2]==null||p[y+2][x+2].color!=color){
                out.add(new Point(x+2,y+2));
            }
        }


        return out;
    }
}

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Horse extends Piece {

    public Horse(int ex, int wy, String i, int c) {
        super(ex, wy, i, c);
    }
    public ArrayList<Point> check(Piece[][] p){
        ArrayList<Point> out=new ArrayList<>();

        if(y>1&&x>0&& p[y-1][x]==null&&(p[y-2][x-1]==null||p[y-2][x-1].color!=color)){
            out.add(new Point(x-1,y-2));
        }
        if(y>0&&x>1&& p[y][x-1]==null&&(p[y-1][x-2]==null||p[y-1][x-2].color!=color)){
            out.add(new Point(x-2,y-1));
        }
        if(y>1&&x<8&& p[y-1][x]==null&&(p[y-2][x+1]==null||p[y-2][x+1].color!=color)){
            out.add(new Point(x+1,y-2));
        }
        if(y>0&&x<7&& p[y][x-1]==null&&(p[y-1][x+2]==null||p[y-1][x+2].color!=color)){
            out.add(new Point(x+2,y-1));
        }

        if(x>1&&y<9&& p[y][x-1]==null&&(p[y+1][x-2]==null||p[y+1][x-2].color!=color)){
            out.add(new Point(x-2,y+1));
        }
        if(x>0&&y<8&& p[y+1][x]==null&&(p[y+2][x-1]==null||p[y+2][x-1].color!=color)){
            out.add(new Point(x-1,y+2));
        }
        if(x<8&&y<9&& p[y][x+1]==null&&(p[y+1][x+2]==null||p[y+1][x+2].color!=color)){
            out.add(new Point(x+2,y+1));
        }
        if(x<7&&y<8&& p[y+1][x]==null&&(p[y+2][x+1]==null||p[y+2][x+1].color!=color)){
            out.add(new Point(x+1,y+2));
        }

        return out;
    }
}

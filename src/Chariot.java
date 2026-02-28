import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Chariot extends Piece {

    public Chariot(int ex, int wy, String i, int c) {
        super(ex, wy, i, c);
    }
    public ArrayList<Point> check(Piece[][] p){
        ArrayList<Point> out=new ArrayList<>();
        for(int i=x;i<=8;i++){
            if(p[y][i]==null){
                out.add(new Point(i,y));
            }
            else{
                if(p[y][i].color!=color){
                    out.add(new Point(i,y));
                }
                if(i!=x) break;
            }
        }
        for(int i=x;i>=0;i--){
            if(p[y][i]==null){
                out.add(new Point(i,y));
            }
            else{
                if(p[y][i].color!=color){
                    out.add(new Point(i,y));
                }
                if(i!=x) break;
            }
        }
        for(int i=y;i<=9;i++){
            if(p[i][x]==null){
                out.add(new Point(x,i));
            }
            else{
                if(p[i][x].color!=color){
                    out.add(new Point(x,i));
                }
                if(i!=y) break;
            }
        }
        for(int i=y;i>=0;i--){
            if(p[i][x]==null){
                out.add(new Point(x,i));
            }
            else{
                if(p[i][x].color!=color){
                    out.add(new Point(x,i));
                }
                if(i!=y) break;
            }
        }
        return out;
    }
}

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Cannon extends Piece {

    public Cannon(int ex, int wy, String i, int c) {
        super(ex, wy, i, c);
    }
    public ArrayList<Point> check(Piece[][] p){
        ArrayList<Point> out=new ArrayList<>();
        for(int i=x+1;i<=8;i++){
            if(p[y][i]==null){
                out.add(new Point(i,y));
            }
            else{
                for(int t=i+1;t<=8;t++){
                    if(p[y][t]!=null&&p[y][t].color!=color){
                        out.add(new Point(t,y));
                        break;
                    }
                }
                if(i!=x) break;
            }
        }
        for(int i=x-1;i>=0;i--){
            if(p[y][i]==null){
                out.add(new Point(i,y));
            }
            else{
                for(int t=i-1;t>=0;t--){
                    if(p[y][t]!=null&&p[y][t].color!=color){
                        out.add(new Point(t,y));
                        break;
                    }
                }
                if(i!=x) break;
            }
        }
        for(int i=y+1;i<=9;i++){
            if(p[i][x]==null){
                out.add(new Point(x,i));
            }
            else{
                for(int t=i+1;t<=9;t++){
                    if(p[t][x]!=null&&p[t][x].color!=color){
                        out.add(new Point(x,t));
                        break;
                    }
                }
                if(i!=y) break;
            }
        }
        for(int i=y-1;i>=0;i--){
            if(p[i][x]==null){
                out.add(new Point(x,i));
            }
            else{
                for(int t=i-1;t>=0;t--){
                    if(p[t][x]!=null&&p[t][x].color!=color){
                        out.add(new Point(x,t));
                        break;
                    }
                }
                if(i!=y) break;
            }
        }
        return out;
    }
}

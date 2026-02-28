import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Game extends JPanel implements Runnable , MouseListener, MouseMotionListener
{
    Piece[][] board=new Piece[10][9];
    int turn; //0-red 1-black
    ArrayList<Point> checks;
    Point hover;
    Piece current;
    public Game(){
        turn=0;
        hover=new Point(0,0);
        this.setPreferredSize(new Dimension(920,1020));
        board=new Piece[10][9];
        current=null;
        //black
        board[0][0]=new Chariot(0,0,"Black_Chariot.png",1);
        board[0][8]=new Chariot(8,0,"Black_Chariot.png",1);
        //board[1][0]=new Horse(0,1,"Black_Horse.png",1);
        //board[0][7]=new Horse(7,0,"Black_Horse.png",1);
        board[0][2]=new Elephant(2,0,"Black_Elephant.png",1);
        board[0][6]=new Elephant(6,0,"Black_Elephant.png",1);
        board[0][3]=new Guard(3,0,"Black_Guard.png",1);
        board[0][5]=new Guard(5,0,"Black_Guard.png",1);
        board[0][4]=new General(4,0,"Black_General.png",1);
        for(int x=0;x<9;x+=2) board[3][x] = new Soldier(x, 3, "Black_Soldier.png", 1);
        board[2][1]=new Cannon(1,2,"Black_Cannon.png",1);
        board[2][7]=new Cannon(7,2,"Black_Cannon.png",1);
        //red
        board[9][4]=new General(4,9,"Red_General.png",0);
        board[9][5]=new Guard(5,9,"Red_Guard.png",0);
        board[9][3]=new Guard(3,9,"Red_Guard.png",0);
        board[9][6]=new Elephant(6,9,"Red_Elephant.png",0);
        board[9][2]=new Elephant(2,9,"Red_Elephant.png",0);
        board[9][7]=new Horse(7,9,"Red_Horse.png",0);
        board[9][1]=new Horse(1,9,"Red_Horse.png",0);
        board[9][8]=new Chariot(8,9,"Red_Chariot.png",0);
        board[9][0]=new Chariot(0,9,"Red_Chariot.png",0);
        board[6][0]=new Soldier(0,6,"Red_Soldier.png",0);
        board[6][2]=new Soldier(2,6,"Red_Soldier.png",0);
        board[6][4]=new Soldier(4,6,"Red_Soldier.png",0);
        board[6][6]=new Soldier(6,6,"Red_Soldier.png",0);
        board[6][8]=new Soldier(8,6,"Red_Soldier.png",0);
        board[7][1]=new Cannon(1,7,"Red_Cannon.png",0);
        board[7][7]=new Cannon(7,7,"Red_Cannon.png",0);

        checks=new ArrayList<>();
        addMouseListener(this);
        addMouseMotionListener(this);
        new Thread(this).start();
    }
    public void mouseClicked(MouseEvent e) {
        Piece p = null;
        int x=99;
        int y=99;
        if((((e.getX()-60)/100)*100)-85/2<(e.getX()-60)&&(e.getX()-60)<((e.getX()-60)/100)*100+85/2){
            y=(e.getX()-60)/100;
        }
        else if((((e.getX()-60)/100+1)*100)-85/2<(e.getX()-60)&&(e.getX()-60)<((e.getX()-60)/100+1)*100+85/2){
            y=(e.getX()-60)/100+1;
        }
        if((((e.getY()-60)/100)*100)-85/2<(e.getY()-60)&&(e.getY()-60)<((e.getY()-60)/100)*100+85/2){
            x=(e.getY()-60)/100;
        }
        else if((((e.getY()-60)/100+1)*100)-85/2<(e.getY()-60)&&(e.getY()-60)<((e.getY()-60)/100+1)*100+85/2){
            x=(e.getY()-60)/100+1;
        }
        if(x!=99&&y!=99){
            Boolean move=false;
            if(checks!=null&&current!=null) {
                for (Point t : checks) { //loop through checks
                    if (t.x == y && t.y == x) { //does clicked square match one of checks
                        if(board[x][y]!=null){ //capture
                            board[x][y]=null;
                        }
                        board[current.y][current.x]=null;
                        current.move(t.x,t.y);
                        board[x][y]=current;//move current piece
                        move = true;
                        break;
                    }
                }
                if(move){ //did I move a piece
                    current.highlight=false;
                    current=null;
                    checks=null;
                    if(turn==1)turn=0; //switch turns
                    else turn =1;
                }
            }
            if(!move){// did I not move a piece

                if(board[x][y]!=null&&board[x][y].color==turn){//did I click on one of my pieces
                    if(current!=null){//deselect current piece because I did not move
                        current.highlight=false;
                    }
                    current=board[x][y];//select new piece
                    checks=current.check(board);//add checks
                }
            }
        }

    }
    public void mousePressed(MouseEvent e) { }
    /*2 mouseReleased -- when mouse button is released*/
    public void mouseReleased(MouseEvent e) { }
    /*3 mouseEntered -- when the mouse enters the window */
    public void mouseEntered(MouseEvent e) { }
    /*4 mouseExited -- when the mouse exits the window*/
    public void mouseExited(MouseEvent e) { }
    /*5 mouseClicked -- when the mouse button is pressed and released*/
    public void mouseDragged(MouseEvent e){  }
    /*2 mouseMoved -- when mouse cursor is moved around the window*/
    public void mouseMoved(MouseEvent e){
        int x=99;
        int y=99;
        if((((e.getX()-60)/100)*100)-85/2<(e.getX()-60)&&(e.getX()-60)<((e.getX()-60)/100)*100+85/2){
            y=(e.getX()-60)/100;
        }
        else if((((e.getX()-60)/100+1)*100)-85/2<(e.getX()-60)&&(e.getX()-60)<((e.getX()-60)/100+1)*100+85/2){
            y=(e.getX()-60)/100+1;
        }
        if((((e.getY()-60)/100)*100)-85/2<(e.getY()-60)&&(e.getY()-60)<((e.getY()-60)/100)*100+85/2){
            x=(e.getY()-60)/100;
        }
        else if((((e.getY()-60)/100+1)*100)-85/2<(e.getY()-60)&&(e.getY()-60)<((e.getY()-60)/100+1)*100+85/2){
            x=(e.getY()-60)/100+1;
        }
        hover.x=y;
        hover.y=x;
    }


    public void paintComponent( Graphics window ) {
        window.setColor(new Color(145,111,46));
        window.fillRect(0,0,920,1020);
        window.setColor(new Color(211,194,129));
        window.fillRect(10,10,900,1000);
        window.setColor(new Color(145,111,46));
        window.fillRect(45,45,830,930);
        window.setColor(new Color(239,217,143));
        window.fillRect(60,60,800,900);
        // top left of board x:60 y:60
        // bottom right of board x:860 y:960
        // board is 800 by 900
        window.setColor(new Color(145,111,46));
        Graphics2D g = (Graphics2D) window;
        g.setStroke(new BasicStroke(4));
        for(int x=1;x<8;x++){
            g.drawLine(60,x*100+60,860,x*100+60);
            g.drawLine(100*x+60,60,100*x+60,460);
            g.drawLine(100*x+60,560,100*x+60,960);
        }
        g.drawLine(60,8*100+60,860,8*100+60);
        g.drawLine(360,60,560,260);
        g.drawLine(560,60,360,260);
        g.drawLine(360,760,560,960);
        g.drawLine(560,760,360,960);

        for(int x=0;x<10;x++){
            for(int y=0;y<9;y++){
                if(board[x][y]!=null) {
                    board[x][y].paint(window);
                }
            }
        }
        if(current!=null){
            current.highlight=true;
        }
        float opacity = 0.7f; // 50% opacity
        // Set the composite
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
        g.setComposite(ac);
        if(checks!=null) {
            for (Point t : checks) {
                if(hover.x==t.x&&hover.y==t.y){
                    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.3f));
                    g.setColor(new Color(93, 156, 79));
                    window.fillRect(t.x * 100 + 60 - 50, t.y * 100 + 60 - 50, 100, 100);
                }
                else {
                    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.7f));
                    g.setColor(new Color(93, 156, 79));
                    if (board[t.y][t.x] != null) {
                        window.fillRect(t.x * 100 + 60 - 85 / 2, t.y * 100 + 60 - 85 / 2, 85, 85);
                    } else {
                        window.fillOval(t.x * 100 + 60 - 15, t.y * 100 + 60 - 15, 30, 30);
                    }
                }
            }
        }


    }
    public void run()
    {
        try
        {
            while( true )
            {
                Thread.sleep(5);
                repaint();
            }
        }
        catch( Exception e )
        {

        }

    }

}
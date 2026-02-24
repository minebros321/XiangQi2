import javax.swing.*;

public class Runner extends JFrame
{
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 1200;

    public Runner()
    {
        super("XiangQi");



        add( new Game() );
        ImageIcon image = new ImageIcon("logo.png");
        setIconImage(image.getImage());
        setLocation(750,0);
        pack();
        setResizable(false);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main( String args[] )
    {
        Runner run = new Runner();
    }
}
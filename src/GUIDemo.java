import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUIDemo extends JFrame {

  private JButton bOne  = new JButton("STOP");
  private JButton bTwo = new JButton("A + B = ");

  private JTextField txtA = new JTextField();
  private JTextField txtB = new JTextField();
  private JTextField txtC = new JTextField();

  private JLabel lblA = new JLabel("A :");
  private JLabel lblB = new JLabel("B :");
  private JLabel lblC = new JLabel("C :");

  public GUIDemo(){
    setTitle("GUI DEMO");
    setSize(400,400);
    setLocation(new Point(300,200));
    setLayout(null);    
    setResizable(false);

    initComponent();    
    initEvent();    
  }

  private void initComponent(){
    bOne.setBounds(10,30, 120,25);
    bTwo.setBounds(10,60, 129,25);
    
    lblA.setBounds(10,125,100,20);
    lblB.setBounds(10,150,100,20);
    lblC.setBounds(10,200,100,20);

    txtA.setBounds(50,125,100,20);
    txtB.setBounds(50,150,100,20);
    txtC.setBounds(50,200,100,20);

    add(bOne);
    add(bTwo);

    add(lblA);
    add(lblB);
    add(lblC);

    add(txtA);
    add(txtB);
    add(txtC);
  }

  private void initEvent(){

    //do stuff if the close window X is clicked
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e){
       System.exit(1);
      }
    });
    
    //call the method to stop the program 
    //if the STOP button is clicked   
    bOne.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        bOneClick(e);
      }
    });

    //call the method to add the numbers
    bTwo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        bTwoClick(e);
      }
    });
  }
  
  private void bOneClick(ActionEvent evt){
    System.exit(0);
  }
  
  private void bTwoClick(ActionEvent evt){
    Integer x,y,z;
    try{
      x = Integer.parseInt(txtA.getText());
      y = Integer.parseInt(txtB.getText());
      z = x + y;
      txtC.setText(z.toString());

    }catch(Exception e){
      System.out.println(e);
      JOptionPane.showMessageDialog(null, 
          e.toString(),
          "Error", 
          JOptionPane.ERROR_MESSAGE);
    }
  }
}

   /*
       A trivial applet that tests the StopWatchRunner component.
       The applet just creates and shows a StopWatchRunner.
    */
    
    import java.awt.*;
    import javax.swing.*;
    
    public class TestStopWatch extends JApplet {
    
       public void init() {
          
          StopWatchRunner watch = new StopWatchRunner();
          watch.setFont( new Font("SansSerif", Font.BOLD, 16) );
          watch.setBackground(Color.black);
          watch.setForeground( new Color(180,180,180) );
          watch.setOpaque(true);
          watch.setSize(480, 480);
          getContentPane().add(watch, BorderLayout.CENTER);
          
       }
    }
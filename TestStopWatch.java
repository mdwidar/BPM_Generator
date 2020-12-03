/**CIS111BONLN
* @author Tyler Martin, Marwa Dwidar, Charlie Bivinghouse
* @date 12/17/2020
* Final Project - BPM Generator
* Original Creator/Design/Writer of TestStopWatch - David J Eck.
*/

import java.awt.*;
import javax.swing.*;

import java.awt.Toolkit;

public class TestStopWatch {
	
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        StopWatchRunner watch = new StopWatchRunner();
        watch.setFont( new Font("SansSerif", Font.BOLD, 16) );
        watch.setBackground(Color.black);
        watch.setForeground( new Color(180,180,180) );
        watch.setOpaque(true);
        watch.setSize(480, 480);
        frame.add(watch, BorderLayout.CENTER);
                        
        
        frame.setSize(new Dimension(480, 480));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    
    } //End of main
}//End of class

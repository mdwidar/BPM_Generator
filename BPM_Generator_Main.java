/**
* Main defines the JFrame window and the UI to help
* user see the information as it is produced. If there
* is an error or a need to change the window size, please
* adjust accordingly using Line 34.
* 
* CIS111BONLN
* @author Tyler Martin, Marwa Dwidar, Charlie Bivinghouse
* @date 12/18/2020
* Final Project - BPM Generator
* Original Creator/Design/Writer of TestStopWatch - David J Eck.
*/

import java.awt.*;
import javax.swing.*;

import java.awt.Toolkit;

public class BPM_Generator_Main {
	
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
		
      	//Create BPM_Generator and define design parameters
        BPM_Generator generator = new BPM_Generator();
        generator.setFont( new Font("SansSerif", Font.BOLD, 16) );
        generator.setBackground(Color.black);
        generator.setForeground( new Color(180,180,180) );
        generator.setOpaque(true);
        generator.setSize(480, 480);
        frame.add(watch, BorderLayout.CENTER);
                        
        //Clarify and provide more design parameters
        frame.setSize(new Dimension(560, 400));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    
    } //End of main
}//End of class

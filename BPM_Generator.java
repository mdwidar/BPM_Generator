/**CIS111BONLN
* @author Tyler Martin, Marwa Dwidar, Charlie Bivinghouse
* @date 12/17/2020
* Final Project - BPM Generator
* Original Creator/Design/Writer of StopWatchRunner - David J Eck.
*/

/*
   A component that acts as a simple stop-watch.  When the user clicks
   on it, this component starts timing.  When the user clicks again,
   it displays the time between the two clicks.  Clicking a third time
   starts another timer, etc.  While it is timing, the label just
   displays the whole number of seconds since the timer was started.
*/

import java.awt.event.*;
import javax.swing.*;

public class BPM_Generator extends JLabel implements MouseListener, ActionListener {

   private static final long serialVersionUID = 1L; //Required by Eclipse for versioning.

   private long startTime;   // Start time of stopwatch, measured in milliseconds.

   private boolean running;  // True when the stopwatch is running.

   private Timer timer;  // A timer that will generate events while the stopwatch is running

   public double beatsPerMinute; //Calculates the beats per minute

   // Constructor
   public BPM_Generator() { 
      super("  Click to start timer.  ", JLabel.CENTER);
      addMouseListener(this);
   }
   
   // This will be called when an event from the
   // timer is received.  It just sets the stopwatch
   // to show the amount of time that it has been running.
   // Time is rounded down to the nearest second.
   
   public void actionPerformed(ActionEvent evt) {
       long time = (System.currentTimeMillis() - startTime);
       setText("Running:  " + time + " milliseconds");
       
   }
   
   // React when user presses the mouse by
   // starting or stopping the stopwatch.  Also start
   // or stop the timer.
   
   public void mousePressed(MouseEvent evt) {
      if (running == false) {
         
    	 // Record the time and start the stopwatch.
         running = true;
         startTime = evt.getWhen();  // Time when mouse was clicked.
         setText("Running:  0 milliseconds");
	         if (timer == null) {
	            timer = new Timer(10,this);
	            timer.start();
	         }
	         else
	            timer.restart();
      }
      else {
         // Stop the stopwatch.  Compute the elapsed time since the
         // stopwatch was started and display it.
         timer.stop();
         running = false;
         long endTime = evt.getWhen();
         double milliseconds = (endTime - startTime);
         
         //Calculate BPM (beats per minute) ratio from milliseconds
         beatsPerMinute = (60000/milliseconds);
        
         //Display stopwatch milliseconds and BPM calculation result
         setText("<html> BPM Generator" + "<br>" + "Distance between inputs: " + milliseconds + " milliseconds." + "<br>" + "The tempo is: " + Math.round(beatsPerMinute) + " beats per minute.<html>");
         
         //Play metronome of BPM
         BPM_Generator_Metronome_beep metronome1 = new BPM_Generator_Metronome_beep(beatsPerMinute,1);
      	 metronome1.start();
         
      }
   }
   
   //JavaEvent Listeners
   public void mouseReleased(MouseEvent evt) { }
   public void mouseClicked(MouseEvent evt) { }
   public void mouseEntered(MouseEvent evt) { }
   public void mouseExited(MouseEvent evt) { }

}  // end StopWatchRunner

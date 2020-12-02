/*
   A component that acts as a simple stop-watch.  When the user clicks
   on it, this component starts timing.  When the user clicks again,
   it displays the time between the two clicks.  Clicking a third time
   starts another timer, etc.  While it is timing, the label just
   displays the whole number of seconds since the timer was started.
*/

import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class StopWatchRunner extends JLabel
            implements MouseListener, ActionListener {

   private long startTime;   // Start time of stopwatch.
                             //   (Time is measured in milliseconds.)

   private boolean running;  // True when the stopwatch is running.

   private Timer timer;  // A timer that will generate events
                         // while the stopwatch is running

   private double beatsPerMinute; //Calculates the beats per minute

   public StopWatchRunner() {
         // Constructor.
      super("  Click to start timer.  ", JLabel.CENTER);
      addMouseListener(this);
   }

   public void actionPerformed(ActionEvent evt) {
          // This will be called when an event from the
          // timer is received.  It just sets the stopwatch
          // to show the amount of time that it has been running.
          // Time is rounded down to the nearest second.
       long time = (System.currentTimeMillis() - startTime);
       setText("Running:  " + time + " milliseconds");
       
   }

   public void mousePressed(MouseEvent evt) {
          // React when user presses the mouse by
          // starting or stopping the stopwatch.  Also start
          // or stop the timer.
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
    	 long endTime = evt.getWhen();
         timer.stop();
         running = false;
         
         double milliseconds = (endTime - startTime);
         
         //Added code to display the beats per minute
         beatsPerMinute = (milliseconds/6);
         
         setText("<html>End Time: " + milliseconds + " milliseconds." + "<br>" + "The tempo is: " + beatsPerMinute + " beats per minute.<html>");
         
      }
   }

   public void mouseReleased(MouseEvent evt) { }
   public void mouseClicked(MouseEvent evt) { }
   public void mouseEntered(MouseEvent evt) { }
   public void mouseExited(MouseEvent evt) { }

}  // end StopWatchRunner


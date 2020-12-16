/**CIS111BONLN
* @author Tyler Martin, Marwa Dwidar, Charlie Bivinghouse
* @date 12/17/2020
* Final Project - BPM Generator
* Original Creator/Design/Writer of StopWatchRunner - David J Eck.
*/

/*
   The BPM_Generator is a metronome that derives tempo using a stop-watch function.  
   When the user clicks on it, this metronome starts timing.  When the user clicks again,
   it displays the time between the two clicks.  Clicking a third time
   starts the process over again. After the temporal distance between clicks 
   is measured, the program produces an output displaying the BPM of the clicked tempo.
   There are additional calculations added for variations on the generated BPM.
*/

import java.awt.event.*;
import javax.swing.*;

public class BPM_Generator extends JLabel implements MouseListener, ActionListener {

   private static final long serialVersionUID = 1L; //Required by Eclipse for versioning.

   private long startTime;   // Start time of stopwatch, measured in milliseconds.

   private boolean running;  // True when the stopwatch is running.

   private Timer timer;  // A timer that will generate events while the stopwatch is running

   public double beatsPerMinute; //Calculates the beats per minute
	
   public double halftimeBPM; //Calculates half-time feel of given BPM
   
   public double doubletimeBPM; // Calculates double-time feel of given BPM
   
   public double quarterTripBPM; //Calculates quarter note triplet feel of given BPM
   
   public double dottedBPM; //Calculates dotted quarter note feel of given BPM
   
   public double thirdOfBPM; //Contains value for calculating dottedBPM

   /** Default Constructor for BPM_Generator
   **/
   public BPM_Generator() { 
      super("  Click to start timer.  ", JLabel.CENTER);
      addMouseListener(this);
   }
   
   /** This will be called when an event from the
    timer is received.  It just sets the metronome
    to show the amount of time that it has been running.
    Time is rounded down to the nearest second. **/
   
   public void actionPerformed(ActionEvent evt) {
       long time = (System.currentTimeMillis() - startTime);
       setText("Running:  " + time + " milliseconds");
       
   }
   
   /** React when user presses the mouse by
       starting or stopping the metronome.  Also start
       or stop the timer. **/
   
   public void mousePressed(MouseEvent evt) {
      if (running == false) {
         
    	 // Record the time and start the metronome.
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
         // Stop the metronome time capture.  Compute the elapsed time since the
         // metronome was started and display the value as a tempo (BPM).
         timer.stop();
         running = false;
         long endTime = evt.getWhen();
         double milliseconds = (endTime - startTime);
         
         //Calculate BPM (beats per minute) ratio from milliseconds
         beatsPerMinute = (60000/milliseconds);
        
          //Calculate BPM in half-time
         halftimeBPM = (beatsPerMinute/2);
         
         //Calculate BPM in double-time
         doubletimeBPM = (beatsPerMinute*2);
         
         //Calculate BPM in quarter note triplet feel
         quarterTripBPM = beatsPerMinute + halftimeBPM;
         
         //Calculate BPM in dotted quarter note feel
         thirdOfBPM = beatsPerMinute/3;
         dottedBPM = beatsPerMinute + thirdOfBPM;
         
         //Display stopwatch milliseconds and BPM calculation result
         setText("<html> <h1> <center> BPM Generator </center> </h1>" + "<br>" + "<center> Distance between inputs: " + milliseconds + " milliseconds. </center>" + "<br>" +
         "The tempo (as quarter notes in 4/4 time) is: " + "<br> <center>" + Math.round(beatsPerMinute) + " beats per minute. </center>" + "<br>" +
         "<center> Tempo Reference Calculations: " + "<br>" +
         " Half-Time: " + Math.round(halftimeBPM) + " beats per minute." + "<br>" +
         "Double-Time: " + Math.round(doubletimeBPM) + " beats per minute." + "<br>" +
         "Quarter Note Triplet: " + Math.round(quarterTripBPM) + " beats per minute." + "<br>" +
         "Dotted Quarter Note: " + Math.round(dottedBPM) + " beats per minute. </center>" + "<br>" + 
         "<center> <h4> Click again to retry or close the window to exit. </h6> </center>" + "<html>");
	      
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

}  // end BPM_Generator

/**
* This class allows for the use of a system soundfont to
* produce a metronome for the given BPM found in BPM_Generator.
* The "for loop" at Line 51 can be adjusted to any length as needed.
*
* CIS111BONLN
* @author Tyler Martin, Marwa Dwidar, Charlie Bivinghouse
* @date 12/18/2020
* Final Project - BPM Generator
* Original Creator/Design/Writer of Metronome - Rosetta Code.
*/

//Source for sound: https://www.rgagnon.com/javadetails/java-0001.html
	

import java.awt.*;

public class BPM_Generator_Metronome_beep {
	
	private final long serialVersionUID = 1L;

	double beatsPerMinute; //Contains value for BPM
	int measure, counter; //Contains counter for metronome speed
	
    /**
    Setter/Mutator for Metronome
    **/
	public void setBPM(double beatsPerMinute) {
		this.beatsPerMinute = beatsPerMinute;
	}
	
    /**
    Getter/Accessor for Metronome
    **/
	public double getBPM() {
		 return beatsPerMinute;
	}

    /**
    Default Constructor for Metronome
    **/
	public BPM_Generator_Metronome_beep (double beatsPerMinute, int measure){
		this.beatsPerMinute = beatsPerMinute;
		this.measure = measure;	
	}
	
	//Start method to begin metronome sound production
	public void start(){
		//To set amount of metronome quarter notes during runtime, adjust "i< # of beats"
		//This for loop was originally a while loop set to (true); exercise caution as this created an infinite loop!
		for(int i=0; i<9; i++){
			try {
				Thread.sleep((long)(1000*(60.0/beatsPerMinute)));
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			counter++;
			if (counter%measure==0){
				 System.out.println("Tick");
				 Toolkit.getDefaultToolkit().beep();  
			}else{
				 System.out.println("Tock");
			}
		}
	}
} //end of class

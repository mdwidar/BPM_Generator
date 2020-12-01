//**For testing and checking the math, use the "Quarter" column in the chart link in Line 2
//https://guitargearfinder.com/wp-content/uploads/2014/03/bpm-to-ms.jpg

import java.util.Math;

public class bpmGenerate extends BPM_Generator_Driver {
	
	private long tempoEvent1;
	private long tempoEvent2;
	private long tempoDiff;
	
	public long bpmGenerate {
	
	//Calculate temporal distance between start and stop in milliseconds
	tempoDiff = tempoEvent2-tempoEvent1;
	
	//Absolute value the tempoDiff to remove potenial negative from long
	Math.abs(tempoDiff);
	
	//Divide 60000 (number of milliseconds in a minute) by tempoDiff (tempo difference)
	tempoDiff = (60000/tempoDiff);
	
	//Return BPM (beats per minute)
	return tempoDiff;
		
	} //end of class
} // end of main

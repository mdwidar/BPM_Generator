import java.util.Math;

public class bpmGenerate extends BPM_Generator_Driver {
	
	private int tempoEvent1;
	private int tempoEvent2;
	private int tempoDiff;
	
	public int bpmGenerate {
		
	//tempoEvent1 + tempoEvent2 convert to milliseconds
	
	tempoDiff = tempoEvent2-tempoEvent1;
	
	Math.abs(tempoDiff);
	
	tempoDiff = (tempoDiff/1000) * 60;
	
	return tempoDiff;
	
	} //end of class
} // end of main

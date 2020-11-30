import java.util.Math;

public class bpmGenerate extends BPM_Generator_Driver {
	
	private int tempoEvent1;
	private int tempoEvent2;
	private int tempoDiff;
	
	public int bpmGenerate {
		
	//We don't need to convert to milliseconds here because the capture in Chronograph does this for us
	
	tempoDiff = tempoEvent2-tempoEvent1;
	
	Math.abs(tempoDiff);
	
	tempoDiff = (tempoDiff/1000) * 60;
	
	return tempoDiff;
	
	} //end of class
} // end of main

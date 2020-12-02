//Simple Java Chronometer
//Published by Silveira on 15 March, 2008
//Edited by Tyler, Charlie, and Marwa

public class Chronometer {
    
    protected static long tempoEvent1;
	protected static long tempoEvent2;

    public void start(){
        tempoEvent1 = System.currentTimeMillis();
    }

    public void stop(){
        tempoEvent2 = System.currentTimeMillis();
    }

    public long getTime() {
        return tempoEvent2-tempoEvent1;
    }

    public long getMilliseconds() {
        return tempoEvent2-tempoEvent1;
    }
    

    public static void main(String[] arg) {
        Chronometer ch = new Chronometer();

        ch.start();
        for (int i = 1;i<10000000;i++) {}
        ch.stop();
        System.out.println(ch.getTime());

        ch.start();
        for (int i = 10000000;i>0;i--) {}
        ch.stop();
        System.out.println(ch.getTime());
    }
}

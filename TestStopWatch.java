import java.awt.*;
import javax.swing.*;

public class TestStopWatch {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        StopWatchRunner watch = new StopWatchRunner();
        watch.setFont( new Font("SansSerif", Font.BOLD, 16) );
        watch.setBackground(Color.black);
        watch.setForeground( new Color(20,150,187) );
        watch.setOpaque(true);
        watch.setSize(480, 480);
        
        frame.add(watch, BorderLayout.CENTER);
        frame.setSize(new Dimension(480, 480));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

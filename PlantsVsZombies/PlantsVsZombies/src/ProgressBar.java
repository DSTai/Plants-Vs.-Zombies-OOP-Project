import java.awt.Color;

import javax.swing.JProgressBar;

public class ProgressBar extends JProgressBar implements GameObject{

    public ProgressBar() {
        setStringPainted(true);
        setMinimum(0);
        setMaximum(150);
        setBounds(600, 8, 200, 30);
        setSize(300, 30);
        Color lightBlue = new Color(135, 206, 235);
        setForeground(lightBlue);
    }
}

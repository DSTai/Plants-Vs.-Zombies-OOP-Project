import javax.swing.*;
import java.awt.event.ActionEvent;

public class Sunflower extends EnergyProduct {
	public Timer sunProduceTimer;
    public Sunflower(GamePanel parent,int x,int y) {
        super(parent, x, y);
        sunProduceTimer = new Timer(15000,(ActionEvent e) -> {
            Sun sta = new Sun(gp,60 + x*95,110 + y*100,130 + y*100);
            gp.activeSuns.add(sta);
            gp.add(sta,new Integer(1));
        });
        sunProduceTimer.start();    
        System.out.println("producing start");
    }
    public void stop(){
		sunProduceTimer.stop();
		System.out.println("producing stop");
    }
}

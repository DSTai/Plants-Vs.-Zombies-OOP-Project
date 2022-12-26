import java.awt.event.ActionEvent;
import javax.swing.*;

public class GatlingPeashooter extends Shooter {
	
    public GatlingPeashooter(GamePanel parent,int x,int y) {
        super(parent,x,y);
        shootTimer = new Timer(2000,(ActionEvent e) -> {
            
            if(gp.laneZombies.get(y).size() > 0) {
                gp.lanePeas.get(y).add(new GatlingPea(gp, y, 103 + this.x * 100));
                gp.lanePeas.get(y).add(new GatlingPea(gp, y, 126 + this.x * 100));
                gp.lanePeas.get(y).add(new GatlingPea(gp, y, 149 + this.x * 100));
                System.out.println("SHOOT");
            }
        });      
        shootTimer.start();  
        
    }
}
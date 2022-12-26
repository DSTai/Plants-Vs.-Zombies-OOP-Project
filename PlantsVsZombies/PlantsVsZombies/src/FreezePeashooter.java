import java.awt.event.ActionEvent;
import javax.swing.*;

public class FreezePeashooter extends Shooter {


    public FreezePeashooter(GamePanel parent,int x,int y) {
        super(parent,x,y);
        shootTimer = new Timer(2000,(ActionEvent e) -> {
            
            if(gp.laneZombies.get(y).size() > 0) {
                gp.lanePeas.get(y).add(new FreezePea(gp, y, 103 + this.x * 100));
                System.out.println("SHOOT");
            }
        });
        shootTimer.start();
    }
}
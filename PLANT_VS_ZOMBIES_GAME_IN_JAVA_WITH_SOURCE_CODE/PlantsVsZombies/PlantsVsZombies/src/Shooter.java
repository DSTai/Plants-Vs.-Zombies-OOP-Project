import javax.swing.Timer;

public class Shooter extends Plant {
	public Timer shootTimer;
	public Shooter(GamePanel parent, int x, int y) {
		super(parent, x, y);
		setHealth(500);
	}
	public void stop(){
        shootTimer.stop();
        System.out.println("shooting stop");
    }
}

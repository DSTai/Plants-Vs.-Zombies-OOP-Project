import javax.swing.Timer;

public class EnergyProduct extends Plant{
    Timer sunProduceTimer;
	public EnergyProduct(GamePanel parent, int x, int y) {
		super(parent, x, y);
		setHealth(200);
	}
	public void stop(){
    }
}

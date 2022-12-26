
public class Defender extends Plant{

	public Defender(GamePanel parent, int x, int y) {
		super(parent, x, y);
	}
	public void ExtraHealth(int point) {
		this.health += point;
	}

}

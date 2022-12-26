
public class Character implements GameObject{
	public int x;
	public int y;
	public int health;

    
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	@Override
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
    
}

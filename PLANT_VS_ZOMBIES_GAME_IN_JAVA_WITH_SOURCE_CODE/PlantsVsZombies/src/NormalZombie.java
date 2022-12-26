
public class NormalZombie extends Zombie {

    public NormalZombie(GamePanel parent,int lane){
        super(parent,lane);
        setAttack(10);
        setHealth(1800);
        setSpeed(1);
    }

}

import java.awt.*;
public class FreezePea extends Pea {
    public FreezePea(GamePanel parent,int lane,int startX){
        super(parent,lane,startX);
        damage = 350;
    }
    @Override
    public void shoot(){
        Rectangle pRect = new Rectangle(posX,130+myLane*120,28,28);
        for (int i = 0; i < gp.laneZombies.get(myLane).size(); i++) {
            Zombie z = gp.laneZombies.get(myLane).get(i);
            Rectangle zRect = new Rectangle(z.posX,109 + myLane*120,400,120);
            if(pRect.intersects(zRect)){
                z.health -= damage;
                z.slow(); // Abibility of Freeze pea
                boolean exit = false;
                if(z.health < 0){
                    System.out.println("ZOMBIE DIE");
                    Progress.updateProgress(10);
                    gp.laneZombies.get(myLane).remove(i);
                    exit = true;
                }
                gp.lanePeas.get(myLane).remove(this);
                if(exit) break;
            }
        }
        posX += 15;
    }
}

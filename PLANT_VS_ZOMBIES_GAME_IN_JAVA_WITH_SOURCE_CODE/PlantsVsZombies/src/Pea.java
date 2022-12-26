import java.awt.*;

public class Pea implements GameObject{

    public int posX;
    public GamePanel gp;
    public int myLane;
    public int damage;
    public Pea(GamePanel parent,int lane,int startX){
        this.gp = parent;
        this.myLane = lane;
        posX = startX;
    }

    public void shoot(){
    	//create a rectangle of Pea
        Rectangle pRect = new Rectangle(posX,130+myLane*120,28,28); 
        for (int i = 0; i < gp.laneZombies.get(myLane).size(); i++) {
            Zombie z = gp.laneZombies.get(myLane).get(i);
          //create a rectangle of Zombie
            Rectangle zRect = new Rectangle(z.posX,109 + myLane*120,400,120);
            if(pRect.intersects(zRect)){ // if pea intersects zombie
                z.health -= damage;
                boolean exit = false;
                if(z.health < 0){
                    System.out.println("ZOMBIE DIE");                
                    gp.laneZombies.get(myLane).remove(i);
                    Progress.updateProgress(10);
                    exit = true;
                }
                gp.lanePeas.get(myLane).remove(this);
                if(exit) break;
            }
        }
        posX += 15;
    }

	@Override
	public int getX() {

		return posX;
	}
}

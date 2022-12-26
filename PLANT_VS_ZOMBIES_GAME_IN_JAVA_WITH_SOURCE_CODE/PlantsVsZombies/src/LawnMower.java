import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class LawnMower implements GameObject{
	public int posX;
    public GamePanel gp;
    private int myLane;
    Timer MowerProducer;
    public LawnMower(GamePanel parent,int lane,int startX){
        this.gp = parent;
        this.myLane = lane;
        posX = startX;
    }
    public void check(){
    	Rectangle mRect = new Rectangle(posX,130+myLane*120,70,57);
    	for (int i = 0; i < gp.laneZombies.get(myLane).size(); i++) {
            Zombie z = gp.laneZombies.get(myLane).get(i);
          //create a rectangle of Zombie
            Rectangle zRect = new Rectangle(z.posX,109 + myLane*120,400,120);
            if(mRect.intersects(zRect)){ // if mower intersects zombie                    
                System.out.println("ZOMBIE DIE");                
                gp.laneZombies.get(myLane).remove(i);
                Progress.updateProgress(10);  
                MowerProducer= new Timer(60,(ActionEvent e) -> mowing());
                MowerProducer.start();
                
            }
        }
    }
    public void mowing() {
    	//create a rectangle of Mower
        Rectangle mRect = new Rectangle(posX,130+myLane*120,70,57);        
        for (int i = 0; i < gp.laneZombies.get(myLane).size(); i++) {
            Zombie z = gp.laneZombies.get(myLane).get(i);
          //create a rectangle of Zombie
            Rectangle zRect = new Rectangle(z.posX,109 + myLane*120,400,120);
            if(mRect.intersects(zRect)){ // if mower intersects zombie                    
                System.out.println("ZOMBIE DIE");                
                gp.laneZombies.get(myLane).remove(i);
                Progress.updateProgress(10);                    
            }
        }
        posX += 15;if(posX >1100) {
    		gp.laneMowers.get(myLane).remove(this);
    	}
        
    }
    
    
	@Override
	public int getX() {

		return posX;
	}

}

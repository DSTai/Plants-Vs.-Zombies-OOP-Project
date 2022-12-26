import javax.swing.*;

public class Zombie extends Character{

    public int speed;
    public int attack;
    public GamePanel gp;
    public int posX = 1100;
    public int myLane;
    public boolean isMoving = true;
    public int slowInt = 0;

    public Zombie(GamePanel parent,int lane){
        this.gp = parent;
        myLane = lane; // This is line that create zombie from 1 to 5
    }

    public void eating(){
        if(isMoving) {
            boolean isCollides = false;
            Collider collided = null;
            for (int i = myLane * 9; i < (myLane + 1) * 9; i++) {
                if (gp.colliders[i].assignedPlant != null && gp.colliders[i].isInsideCollider(posX)) {
                    isCollides = true;
                    collided = gp.colliders[i];
                }
            }
            if (!isCollides) { //not collide, then zombie moves
                if(slowInt>0){
                    if(slowInt % 2 == 0) {
                        posX--; 
                    }
                    slowInt--;
                }
                else {
                    posX -= speed; /* position of zombie moves from the left side to right side
                    		 this shows how much time that zombie moves */
                }
            } 
            else { // isCollides is true; Zombie attacks plant
                collided.assignedPlant.health -= attack;
                if (collided.assignedPlant.health <= 0) {
                    collided.removePlant();
                }
            }
            if (posX <= 0) { // Zombie gone through the house; player lose
                isMoving = false;
                JOptionPane.showMessageDialog(gp,"THE ZOMBIES ATE YOUR BRAIN !" + '\n' + "Starting the level again");
                GameWindow.gw.dispose();
                GameWindow.gw = new GameWindow();
                Progress.setProgress(0);
                gp.laneZombies.removeAll(null);
            }
        }
    }
  
    public void slow(){
        slowInt = 1000;
    }   
    public static Zombie getZombie(String type,GamePanel parent, int lane) {
        Zombie z = new Zombie(parent,lane);
       switch(type) {
           case "NormalZombie" : z = new NormalZombie(parent,lane);
                                 break;
           case "ConeHeadZombie" : z = new ConeHeadZombie(parent,lane);
                                 break;
         case "Zomboni" : z = new Zomboni(parent,lane);
                                 break;
       }
       return z;
    }
    
    public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
    public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}

}

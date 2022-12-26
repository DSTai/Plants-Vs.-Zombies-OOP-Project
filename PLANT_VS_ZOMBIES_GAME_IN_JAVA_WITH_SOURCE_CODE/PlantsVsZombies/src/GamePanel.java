import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class GamePanel extends JLayeredPane implements MouseMotionListener {
	public int width =1100;
	public int heigth =650;
	ImageContainer IC = new ImageContainer(); //get image
	SunScore SS = new SunScore(); //get sun score
	
    Collider[] colliders;
    
    ArrayList<ArrayList<Zombie>> laneZombies;
    ArrayList<ArrayList<Pea>> lanePeas;
    ArrayList<ArrayList<LawnMower>> laneMowers;
    ArrayList<Sun> activeSuns;
          
    PlantButton.PlantType activePlantingBrush = PlantButton.PlantType.None;
    ShovelButton.ShovelType activeShovel = ShovelButton.ShovelType.None;
    

    
    public GamePanel(){
    }    
    protected void advance(){

        for (int i = 0; i < 5 ; i++) {
        	for (int j = 0; j < laneZombies.get(i).size(); j++) {
                Zombie z = laneZombies.get(i).get(j);
                
                z.eating();
                
            }

            for (int j = 0; j < lanePeas.get(i).size(); j++) {
                Pea p = lanePeas.get(i).get(j);
                p.shoot();
            }
            for (int j = 0; j < laneMowers.get(i).size(); j++) {
                LawnMower m = laneMowers.get(i).get(j);
                m.check();
                
            }

        }

        for (int i = 0; i < activeSuns.size() ; i++) {
            activeSuns.get(i).product();
        }

    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(IC.getBgImage(),0,0,null);

        //Draw Plants
        for (int i = 0; i < 45; i++) {
            Collider c = colliders[i];
            if(c.assignedPlant != null){
                Plant p = c.assignedPlant;
                if(p instanceof Peashooter){
                    g.drawImage(IC.getPeashooterImage(),100 + (i%9)*95,129 + (i/9)*100,null);
                }
                if(p instanceof FreezePeashooter){
                    g.drawImage(IC.getFreezePeashooterImage(),100 + (i%9)*95,129 + (i/9)*100,null);
                }
                if(p instanceof Sunflower){
                    g.drawImage(IC.getSunflowerImage(),100 + (i%9)*95,129 + (i/9)*100,null);
                    
                }
                if(p instanceof WallNut){
                    g.drawImage(IC.getWallNutImage(),100 + (i%9)*95,129 + (i/9)*100,null);
                }
                if(p instanceof GatlingPeashooter){
                    g.drawImage(IC.getGatlingpeashooterImage(),100 + (i%9)*95,129 + (i/9)*100,null);
                }
            }
        }

        for (int i = 0; i < 5 ; i++) {
            for(Zombie z : laneZombies.get(i)){
                if(z instanceof NormalZombie){
                    g.drawImage(IC.getNormalZombieImage(),z.posX,109+(i*100),null);
                }else if(z instanceof ConeHeadZombie){
                    g.drawImage(IC.getConeHeadZombieImage(),z.posX,109+(i*100),null);
                }else if(z instanceof Zomboni){
                    g.drawImage(IC.getZomboniImage(),z.posX,40+(i*100),null);
                }
            }

            for (int j = 0; j < lanePeas.get(i).size(); j++) {
                Pea p = lanePeas.get(i).get(j);
                if(p instanceof FreezePea){
                    g.drawImage(IC.getFreezePeaImage(), p.posX +30, 130 + (i * 100), null);
                }
                else {
                    g.drawImage(IC.getPeaImage(), p.posX +30, 130 + (i * 100), null);
                }
            }
            for(LawnMower m : laneMowers.get(i)){
                	g.drawImage(IC.getLawnmower(), m.posX +40, 140 + (i * 100), null);
            }
        }

    }
    class PlantActionListener implements ActionListener {
        int x,y;

        public PlantActionListener(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        	// if plant card is using
            if(activePlantingBrush == PlantButton.PlantType.Sunflower){
                if(SS.getSunScore()>=50 && colliders[x + y * 9].assignedPlant ==null) {
                    colliders[x + y * 9].setPlant(new Sunflower(GamePanel.this, x, y));
                    SS.setSunScore(SS.getSunScore()-50);
                }
            }
            if(activePlantingBrush == PlantButton.PlantType.Peashooter){
                if(SS.getSunScore() >= 100 && colliders[x + y * 9].assignedPlant ==null){
                    colliders[x + y * 9].setPlant(new Peashooter(GamePanel.this, x, y));
                    SS.setSunScore(SS.getSunScore()-100);
                }
            }
            if(activePlantingBrush == PlantButton.PlantType.FreezePeashooter){
                if(SS.getSunScore() >= 175 && colliders[x + y * 9].assignedPlant ==null) {
                    colliders[x + y * 9].setPlant(new FreezePeashooter(GamePanel.this, x, y));
                    SS.setSunScore(SS.getSunScore()-175);
                }
            }
            if(activePlantingBrush == PlantButton.PlantType.WallNut){
                if(SS.getSunScore() >= 50 && colliders[x + y * 9].assignedPlant ==null) {
                    colliders[x + y * 9].setPlant(new WallNut(GamePanel.this, x, y));
                    SS.setSunScore(SS.getSunScore()-50);
                }
            }            
            if(activePlantingBrush == PlantButton.PlantType.GatlingPeashooter){
                if(SS.getSunScore() >= 250 && colliders[x + y * 9].assignedPlant ==null) {
                    colliders[x + y * 9].setPlant(new GatlingPeashooter(GamePanel.this, x, y));
                    SS.setSunScore(SS.getSunScore()-250);
                }
            }         
            activePlantingBrush = PlantButton.PlantType.None;
            
            // if shovel is using
            if(activeShovel == ShovelButton.ShovelType.Remove){
            	if( colliders[x + y * 9].assignedPlant !=null) {
            	colliders[x + y * 9].removePlant();
            	}
            }
            activeShovel = ShovelButton.ShovelType.None;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
 
    }   
}

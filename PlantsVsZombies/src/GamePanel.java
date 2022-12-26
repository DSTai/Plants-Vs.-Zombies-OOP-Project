import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GamePanel extends JLayeredPane implements MouseMotionListener {
	public int width =1100;
	public int heigth =650;
	ImageContainer IC = new ImageContainer(); //get image
	
    Collider[] colliders;
    
    ArrayList<ArrayList<Zombie>> laneZombies;
    ArrayList<ArrayList<Pea>> lanePeas;
    ArrayList<Sun> activeSuns;

    Timer redrawTimer;
    Timer advancerTimer;
    Timer sunProducer;
    Timer zombieProducer;
       
    JLabel sunScoreboard;
    
    GameWindow.PlantType activePlantingBrush = GameWindow.PlantType.None;

    int mouseX , mouseY;
    

    private int sunScore;

    public int getSunScore() {
        return sunScore;
    }

    public void setSunScore(int sunScore) {
        this.sunScore = sunScore;
        sunScoreboard.setText(String.valueOf(sunScore));  
    }

    public GamePanel(JLabel sunScoreboard){
    	
    	//Add the progress bar
    	ProgressBar progressBar = new ProgressBar();
    	add(progressBar, new Integer(2));
    	Timer progressUpdater = new Timer(100, (ActionEvent e) -> {
    	    progressBar.setValue(Progress.getProgress());
    	});
    	progressUpdater.start();

    	//Add the sun point
        setSize(width,heigth);
        setLayout(null);
        addMouseMotionListener(this);
        this.sunScoreboard = sunScoreboard;
        setSunScore(150);  //pool avalie
      
        laneZombies = new ArrayList<>();
        laneZombies.add(new ArrayList<>()); //line 1
        laneZombies.add(new ArrayList<>()); //line 2
        laneZombies.add(new ArrayList<>()); //line 3
        laneZombies.add(new ArrayList<>()); //line 4
        laneZombies.add(new ArrayList<>()); //line 5

        lanePeas = new ArrayList<>();
        lanePeas.add(new ArrayList<>()); //line 1
        lanePeas.add(new ArrayList<>()); //line 2
        lanePeas.add(new ArrayList<>()); //line 3
        lanePeas.add(new ArrayList<>()); //line 4
        lanePeas.add(new ArrayList<>()); //line 5

        colliders = new Collider[45];
        for (int i = 0; i < 45; i++) {
            Collider a = new Collider();
            a.setLocation(100 + (i%9)*95,109 + (i/9)*100);
            a.setAction(new PlantActionListener((i%9),(i/9)));
            colliders[i] = a;
            add(a,new Integer(0));
        }


        activeSuns = new ArrayList<>();             
        
        redrawTimer = new Timer(25,(ActionEvent e) -> {
            repaint();
        });
        redrawTimer.start();

        advancerTimer = new Timer(60,(ActionEvent e) -> advance());
        advancerTimer.start();

        sunProducer = new Timer(5000,(ActionEvent e) -> {
            Random rnd = new Random();
            Sun sta = new Sun(this,rnd.nextInt(800)+100,0,rnd.nextInt(300)+200);
            activeSuns.add(sta);
            add(sta,new Integer(1));
        });
        sunProducer.start();
        
        zombieProducer = new Timer(7000,(ActionEvent e) -> {
            Random rnd = new Random();
            LevelData lvl = new LevelData();
            String [] Level = lvl.Level[Integer.parseInt(lvl.Lvl)-1];
            int [][] LevelValue = lvl.LevelValue[Integer.parseInt(lvl.Lvl)-1];
            int l = rnd.nextInt(5);
            int t = rnd.nextInt(100);
            Zombie z = null;
            for(int i = 0;i<LevelValue.length;i++) {
                if(t>=LevelValue[i][0]&&t<=LevelValue[i][1]) {
                    z = Zombie.getZombie(Level[i],GamePanel.this,l);
                }
            }    
            laneZombies.get(l).add(z);
            
        });
        	zombieProducer.start();

    }
////////////////////////////////////////
    private void advance(){
        for (int i = 0; i < 5 ; i++) {
            for(Zombie z : laneZombies.get(i)){
                z.advance();
            }

            for (int j = 0; j < lanePeas.get(i).size(); j++) {
                Pea p = lanePeas.get(i).get(j);
                p.shoot();
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
                }
            }

            for (int j = 0; j < lanePeas.get(i).size(); j++) {
                Pea p = lanePeas.get(i).get(j);
                if(p instanceof FreezePea){
                    g.drawImage(IC.getFreezePeaImage(), p.posX, 130 + (i * 100), null);
                }
                else {
                    g.drawImage(IC.getPeaImage(), p.posX, 130 + (i * 100), null);
                }
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
            if(activePlantingBrush == GameWindow.PlantType.Sunflower){
                if(getSunScore()>=50) {
                    colliders[x + y * 9].setPlant(new Sunflower(GamePanel.this, x, y));
                    setSunScore(getSunScore()-50);
                }
            }
            if(activePlantingBrush == GameWindow.PlantType.Peashooter){
                if(getSunScore() >= 100) {
                    colliders[x + y * 9].setPlant(new Peashooter(GamePanel.this, x, y));
                    setSunScore(getSunScore()-100);
                }
            }

            if(activePlantingBrush == GameWindow.PlantType.FreezePeashooter){
                if(getSunScore() >= 175) {
                    colliders[x + y * 9].setPlant(new FreezePeashooter(GamePanel.this, x, y));
                    setSunScore(getSunScore()-175);
                }
            }
            if(activePlantingBrush == GameWindow.PlantType.WallNut){
                if(getSunScore() >= 50) {
                    colliders[x + y * 9].setPlant(new WallNut(GamePanel.this, x, y));
                    setSunScore(getSunScore()-50);
                }
            }
            
            if(activePlantingBrush == GameWindow.PlantType.GatlingPeashooter){
                if(getSunScore() >= 50) {
                    colliders[x + y * 9].setPlant(new GatlingPeashooter(GamePanel.this, x, y));
                    setSunScore(getSunScore()-50);
                }
            }
            
            activePlantingBrush = GameWindow.PlantType.None;
            
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();    
    }   
}

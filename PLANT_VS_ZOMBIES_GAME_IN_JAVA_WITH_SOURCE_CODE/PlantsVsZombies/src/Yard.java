import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Yard extends GamePanel{
	Timer redrawTimer;
    Timer advancerTimer;
    Timer sunProducer;
    Timer zombieProducer;
    
	public Yard(JLabel sunScoreboard) {
		
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
        SS.sunScoreboard = sunScoreboard;
        SS.setSunScore(150);  //pool avalie
      
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
        
        laneMowers = new ArrayList<>();
        laneMowers.add(new ArrayList<>()); //line 1
        laneMowers.add(new ArrayList<>()); //line 2
        laneMowers.add(new ArrayList<>()); //line 3
        laneMowers.add(new ArrayList<>()); //line 4
        laneMowers.add(new ArrayList<>()); //line 5

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
                    z = Zombie.getZombie(Level[i],Yard.this,l);
                }
            }    
            laneZombies.get(l).add(z);
            
        });
        zombieProducer.start();
        
        
        for(int i=0;i<5;i++) {
        LawnMower m = new LawnMower( this, i, 0);
        laneMowers.get(i).add(m);
        }
        
	}
}

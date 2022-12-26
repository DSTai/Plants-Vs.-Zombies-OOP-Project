import javax.swing.*;

import java.awt.event.ActionEvent;

public class GameWindow extends JFrame  {

    enum PlantType{
        None,
        Sunflower,
        Peashooter,
        FreezePeashooter,
        WallNut,
        GatlingPeashooter
    }

    //PlantType activePlantingBrush = PlantType.None;
    
    public GameWindow(){
        setSize(1100,650);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel sun = new JLabel("SUN");
        sun.setLocation(40,75);
        sun.setSize(60,25);

        GamePanel gp = new GamePanel(sun);
        gp.setLocation(0,0);
        getLayeredPane().add(gp,new Integer(0));
        
        
        PlantCard sunflower = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_sunflower.png")).getImage());
        sunflower.setLocation(100,8);
        sunflower.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.Sunflower;
        });
        getLayeredPane().add(sunflower,new Integer(3));

        PlantCard peashooter = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_peashooter.png")).getImage());
        peashooter.setLocation(165,8);
        peashooter.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.Peashooter;
        });
        getLayeredPane().add(peashooter,new Integer(3));
        
        PlantCard freezepeashooter = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_freezepeashooter.png")).getImage());
        freezepeashooter.setLocation(230,8);
        freezepeashooter.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.FreezePeashooter;
        });
        getLayeredPane().add(freezepeashooter,new Integer(3));

        PlantCard wallnut = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_wallnut.png")).getImage());
        wallnut.setLocation(295,8);
        wallnut.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.WallNut;
        });
        getLayeredPane().add(wallnut,new Integer(3));
        
        PlantCard gatlingpeashooter = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/card_gatlingpeashooter.png")).getImage());
        gatlingpeashooter.setLocation(360,8);
        gatlingpeashooter.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.GatlingPeashooter;
        });
        getLayeredPane().add(gatlingpeashooter,new Integer(3));

        getLayeredPane().add(sun,new Integer(2));
        setResizable(false);
        setVisible(true);
    }
    public GameWindow(boolean b) {
        Menu menu = new Menu();
        menu.setLocation(0,0);
        setSize(1100,650);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getLayeredPane().add(menu,new Integer(0));
        menu.repaint();
        setResizable(false);
        setVisible(true);
    }
    static GameWindow gw;
    public static void begin() {
        gw.dispose();
       gw = new GameWindow();
    }
    public static void main(String[] args) {
          gw = new GameWindow(true);
    }

}

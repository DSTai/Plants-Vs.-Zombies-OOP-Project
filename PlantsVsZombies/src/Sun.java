import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Sun extends JPanel implements MouseListener,GameObject {

    GamePanel gp;
    Image sunImage;

    int myX;
    int myY;
    int endY;

    int destruct = 200; //destruct time

    public Sun(GamePanel parent,int startX,int startY,int endY){
        this.gp = parent;
        this.endY = endY;
        setSize(80,80);
        setOpaque(false);
        myX = startX;
        myY = startY;
        setLocation(myX,myY);
        sunImage = new ImageIcon(this.getClass().getResource("images/sun.png")).getImage();
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(sunImage,0,0,null);
    }

    public void product(){
        if(myY < endY) {
            myY+= 4; //how fast sun fall
        }else{
            destruct--; // time that sun present if you do not take it for long time it will destruct
            if(destruct<0){
                gp.remove(this);
                gp.activeSuns.remove(this);
            }
        }
        setLocation(myX,myY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        gp.setSunScore(gp.getSunScore()+25);
        gp.remove(this);
        gp.activeSuns.remove(this);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

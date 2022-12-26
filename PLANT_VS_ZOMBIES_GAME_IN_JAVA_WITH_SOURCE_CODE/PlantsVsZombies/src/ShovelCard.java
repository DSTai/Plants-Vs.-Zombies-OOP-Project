import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class ShovelCard extends Card{
	public ShovelCard(Image img){
        setSize(90,90);
        this.img = img;
        addMouseListener(this);
    }
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,0,0,null);
    }    
	@Override
    public void mouseReleased(MouseEvent e) { //use card to plant
        if(al != null){
            al.actionPerformed(new ActionEvent(this,ActionEvent.RESERVED_ID_MAX+1,""));
            System.out.println("Click shovel");
        }
    }
}

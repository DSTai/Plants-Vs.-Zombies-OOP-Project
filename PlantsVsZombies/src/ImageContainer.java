import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageContainer {
	private Image menuImage;
    private Image bgImage;
    private Image peashooterImage;
    private Image freezePeashooterImage;
    private Image sunflowerImage;
    private Image peaImage;
    private Image freezePeaImage;
    private Image wallNutImage;
    private Image gatlingpeashooterImage;
    private Image normalZombieImage;
    private Image coneHeadZombieImage;
    
    private Image card_sunflower;
    private Image card_peashooter;
    private Image card_freezepeashooter;
    private Image card_wallnut;
    private Image card_gatlingpeashooter;


    private Image loadImage(String filePath) {
        return new ImageIcon(this.getClass().getResource(filePath)).getImage();
    } 
    
    public ImageContainer() {
    	setCard_sunflower(loadImage("images/cards/card_sunflower.png"));
    	setCard_peashooter(loadImage("images/cards/card_peashooter.png"));
    	setCard_freezepeashooter(loadImage("images/cards/card_freezepeashooter.png"));
    	setCard_wallnut(loadImage("images/cards/card_wallnut.png"));
    	setCard_gatlingpeashooter(loadImage("images/cards/card_gatlingpeashooter.png"));
    	
    	menuImage =(loadImage("images/menu.png"));
        bgImage = loadImage("images/mainBG2.png");
        
        wallNutImage = loadImage("images/plants/wallnut.gif");
        peashooterImage = loadImage("images/plants/peashooter.gif");
        freezePeashooterImage = loadImage("images/plants/freezepeashooter.gif");
        sunflowerImage = loadImage("images/plants/sunflower.gif");
        peaImage = loadImage("images/pea.png");
        freezePeaImage = loadImage("images/freezepea.png");
        gatlingpeashooterImage = loadImage("images/plants/gatlingpeashooter.gif");
        
        normalZombieImage = loadImage("images/zombies/zombie1move.gif");
        coneHeadZombieImage = loadImage("images/zombies/zombie2move.gif");
    }

    public Image getCard_peashooter() {
		return card_peashooter;
	}

	public void setCard_peashooter(Image card_peashooter) {
		this.card_peashooter = card_peashooter;
	}

	public Image getCard_freezepeashooter() {
		return card_freezepeashooter;
	}

	public void setCard_freezepeashooter(Image card_freezepeashooter) {
		this.card_freezepeashooter = card_freezepeashooter;
	}

	public Image getCard_wallnut() {
		return card_wallnut;
	}

	public void setCard_wallnut(Image card_wallnut) {
		this.card_wallnut = card_wallnut;
	}

	public Image getCard_gatlingpeashooter() {
		return card_gatlingpeashooter;
	}

	public void setCard_gatlingpeashooter(Image card_gatlingpeashooter) {
		this.card_gatlingpeashooter = card_gatlingpeashooter;
	}

	public Image getFreezePeaImage() {
		return freezePeaImage;
	}

	public void setFreezePeaImage(Image freezePeaImage) {
		this.freezePeaImage = freezePeaImage;
	}

	public Image getWallNutImage() {
		return wallNutImage;
	}

	public void setWallNutImage(Image wallNutImage) {
		this.wallNutImage = wallNutImage;
	}

	public Image getGatlingpeashooterImage() {
		return gatlingpeashooterImage;
	}

	public void setGatlingpeashooterImage(Image gatlingpeashooterImage) {
		this.gatlingpeashooterImage = gatlingpeashooterImage;
	}

	public Image getNormalZombieImage() {
		return normalZombieImage;
	}

	public void setNormalZombieImage(Image normalZombieImage) {
		this.normalZombieImage = normalZombieImage;
	}

	public Image getConeHeadZombieImage() {
		return coneHeadZombieImage;
	}

	public void setConeHeadZombieImage(Image coneHeadZombieImage) {
		this.coneHeadZombieImage = coneHeadZombieImage;
	}

	public void setBgImage(Image bgImage) {
		this.bgImage = bgImage;
	}

	public Image getBgImage() {
		return bgImage;
	}

	public Image getPeashooterImage() {
		return peashooterImage;
	}

	public Image getFreezePeashooterImage() {
		return freezePeashooterImage;
	}

	public Image getSunflowerImage() {
		return sunflowerImage;
	}

	public Image getPeaImage() {
		return peaImage;
	}

	public void setPeashooterImage(Image peashooterImage) {
		this.peashooterImage = peashooterImage;
	}

	public void setFreezePeashooterImage(Image freezePeashooterImage) {
		this.freezePeashooterImage = freezePeashooterImage;
	}

	public void setSunflowerImage(Image sunflowerImage) {
		this.sunflowerImage = sunflowerImage;
	}

	public void setPeaImage(Image peaImage) {
		this.peaImage = peaImage;
	}

	public Image getMenuImage() {
		return menuImage;
	}

	public void setMenuImage(Image menuImage) {
		this.menuImage = menuImage;
	}

	public Image getCard_sunflower() {
		return card_sunflower;
	}

	public void setCard_sunflower(Image card_sunflower) {
		this.card_sunflower = card_sunflower;
	} 
}

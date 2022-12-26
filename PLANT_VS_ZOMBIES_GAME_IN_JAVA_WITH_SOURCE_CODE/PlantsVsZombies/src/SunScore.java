import javax.swing.JLabel;

public class SunScore {
	JLabel sunScoreboard;
	private int sunScore;

    public int getSunScore() {
        return sunScore;
    }

    public void setSunScore(int sunScore) {
        this.sunScore = sunScore;
        sunScoreboard.setText(String.valueOf(sunScore));  
    }
}	

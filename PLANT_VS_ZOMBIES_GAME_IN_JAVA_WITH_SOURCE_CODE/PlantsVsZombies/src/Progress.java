import javax.swing.JOptionPane;

public class Progress {
    private static int progress = 0;
    private static String message = "Level Completed !!!" + '\n' + "Starting next Level";
    public static void updateProgress(int num) {
        progress = progress + num;
        System.out.println(progress);
        if(progress>=150) {
           if("1".equals(LevelData.Lvl)) {
        	   JOptionPane.showMessageDialog(null,message);
        	   GameWindow.gw.dispose();
        	   LevelData.write("2");
        	   GameWindow.gw = new GameWindow();
            }
           if ("2".equals(LevelData.Lvl)){
        	   JOptionPane.showMessageDialog(null,message);
               GameWindow.gw.dispose();
               LevelData.write("3");
               GameWindow.gw = new GameWindow();  
           }
           
           else {
               JOptionPane.showMessageDialog(null,"Level Completed !!!" + '\n' + "More Levels will come soon !!!" + '\n' + "Resetting data");
               LevelData.write("1");
               System.exit(0);
           }
           progress = 0;
        }
    }

	public static int getProgress() {
		return progress;
	}

	public static void setProgress(int progress) {
		Progress.progress = progress;
	}
}

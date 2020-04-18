package me.Treidex.KIUEdInterface.Missions;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import me.Treidex.KIUEdInterface.Interface;
import me.Treidex.KIUEdInterface.Main;

public class Missions extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3302023796445304429L;
	
	public Missions() {
		setTitle("Mission");
		setSize(500, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		add(new Mission());
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/KIUEd.png")));
		setVisible(true);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choose = JOptionPane.showConfirmDialog(Main.ms,
                        "Do you really want to exit the application?\n(Everything not saved will be lost!)",
                        "Confirm Close", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if (choose == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
	}
	
	public static class Mission extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8725235543580303278L;
		
		private static Mission instance;
		public static String[][] missions =
			{
				{
					"Create a window named 'myWindow'",
					"Create a window named 'myWindow' with width of 500\nand height of 400\n\nHINT:\n'DRAW window window_name width height'",
					"DRAW window myWindow 500 400"
				},
				{
					"Draw a rectangle in 'myWindow'",
					"Draw a rectangle in window 'myWindow' at X=50 and\nY=50. Make width 100, height 100, fill true,\n and color #00ff00\n(Remember: keep all previous code!)\n\nHINT:\n'DRAW rect window_name color x y width height fill'",
					"DRAW window myWindow 500 400\nDRAW rect myWindow #00ff00 50 50 100 100 true"
				},
				{
					"Pause program for 5 seconds",
					"Using 'WAIT' keyword, pause the program for\nfive seconds\n(Remember: keep all previous code!)\n\nHINT:\n'WAIT seconds time'",
					"DRAW window myWindow 500 400\nDRAW rect myWindow #00ff00 50 50 100 100 true\nWAIT seconds 5"
				},
				{
					"Close window 'myWindow'",
					"Using 'DELETE' keyword, delete window 'myWindow'\n(Remember: keep all previous code!)\n\nHINT:\n'DELETE window window_name'",
					"DRAW window myWindow 500 400\nDRAW rect myWindow #00ff00 50 50 100 100 true\nWAIT seconds 5\nDELETE window myWindow"
				}
			};
		public static int missionNum = 0;
		public static String mission = missions[missionNum][0];
		public static String missionInfo = missions[missionNum][1];
		public static String missionCode = missions[missionNum][2];
		
		public Mission() {
			instance = this;
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setFont(new Font(Font.MONOSPACED, Font.TRUETYPE_FONT, 20));
			drawString(g, "Mission " + (missionNum+1) + ":\n  " + mission, 14, 0);
			g.setFont(new Font(Font.MONOSPACED, Font.TRUETYPE_FONT, 15));
			drawString(g, missionInfo, 30, 75);
		}
		
		public static void nextMission() {
			try {
				missionNum++;
				mission = missions[missionNum][0];
				missionInfo = missions[missionNum][1];
				missionCode = missions[missionNum][2];
			} catch(Exception e) {
				mission = "No More Missions!";
				missionInfo = "New Missions may be added soon";
			}
			instance.repaint();
		}
		
		public static void testMission() {
			saveMission();
			Interface.run();
			System.out.println(Interface.editor.getText().equals(missionCode));
			if (Interface.editor.getText().trim().equals(missionCode))
				nextMission();
		}
		
		public static void saveMission() {
//			try {
//				File f = new File(Interface.file_name);
//				FileWriter fw = new FileWriter(f, false);
//				fw.write(String.valueOf(missionNum));
//				fw.flush();
//				fw.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
		private void drawString(Graphics g, String text, int x, int y) {
            for (String line : text.split("\n"))
                g.drawString(line, x, y += g.getFontMetrics().getHeight());
        }
		
	}

}

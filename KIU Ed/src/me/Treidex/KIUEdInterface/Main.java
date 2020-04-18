package me.Treidex.KIUEdInterface;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import me.Treidex.KIUEdInterface.Missions.Missions;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Main m;
	public static Missions ms;
	
	public Main() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setTitle("KIU Ed");
		setSize(1000, 800);
		setJMenuBar(new MenuBar());
		add(new Interface());
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/KIUEd.png")));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choose = JOptionPane.showConfirmDialog(ms,
                        "Do you really want to exit the application?\n(Everything not saved will be lost!)",
                        "Confirm Close", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if (choose == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
	}

	public static void main(String[] args) {
		try {
			Interface.setFilePath(args[0]);
			Interface.setFileName(args[1]);
		} catch(ArrayIndexOutOfBoundsException e) {}
		m = new Main();
		ms = new Missions();
	}

}

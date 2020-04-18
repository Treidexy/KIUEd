package me.Treidex.KIUEdInterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

public class Project {
	public static void New() {
		Interface.setFileName(System.getProperty("user.dir") + "\\newProject.kiu");
		Interface.editor.setText("");
		SwingUtilities.updateComponentTreeUI(Main.m);
	}	
	
	public static void open() {
		JButton b = new JButton();
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("."));
		fc.setDialogTitle("Open...");
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		if (fc.showOpenDialog(b)==JFileChooser.APPROVE_OPTION) {
			Interface.setFilePath(fc.getCurrentDirectory().toString());
			Interface.setFileName(fc.getSelectedFile().getName());
			
			try {
				File f = new File(Interface.file_path + "\\" +Interface.file_name);
				FileInputStream fis = new FileInputStream(f);
				byte[] d = new byte[(int) f.length()];
				fis.read(d);
				fis.close();
				String r = new String(d, "UTF-8");
				Interface.editor.setText(r);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

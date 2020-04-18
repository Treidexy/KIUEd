package me.Treidex.KIUEdInterface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import me.Treidex.KIU.Main;
import me.Treidex.KIU.Parser;

public class Interface extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String file_name = "myProgram.eiu";
	public static String file_path = System.getProperty("user.dir");
	public static JTextArea editor = new JTextArea(20, 20);
	
	public Interface() {
		Editor();
	}
	
	public void Editor() {
		setLayout(new BorderLayout());
		editor.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 11));
		JScrollPane editor_pane = new JScrollPane(editor);
		  
	    editor_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//	    editor_pane.setBounds(5,5,360,320); 
	    
	    add(editor_pane);
		setBorder(new EtchedBorder());
	}
	
	public static void saveEditor() {
		try {
			File f = new File(Interface.file_name);
			FileWriter fw = new FileWriter(f, false);
			fw.write(editor.getText());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void run() {
		try {
			for (String line : editor.getText().split("\\n"))
				if (!Parser.parse(line))
					Main.log("[!]: Error in: \"" + line + "\"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void setFileName(String new_file_name) {
		file_name = new_file_name;
	}
	
	public static void setFilePath(String path) {
		file_path = path;
	}

}

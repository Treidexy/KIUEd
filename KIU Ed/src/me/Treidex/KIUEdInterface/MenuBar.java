package me.Treidex.KIUEdInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import me.Treidex.KIUEdInterface.Missions.Missions;

public class MenuBar extends JMenuBar implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1261944790266368727L;
	
	public JMenu project_menu = new JMenu("Project");
		public JMenuItem new_project = new JMenuItem("New Project...");
		public JMenuItem open_project = new JMenuItem("Open...");
		public JMenuItem export_project = new JMenuItem("Export - WIP");
	
	public JMenu edit_menu = new JMenu("Edit");
		public JMenuItem undo_edit = new JMenuItem("Undo - WIP");
		public JMenuItem redo_edit = new JMenuItem("Redo - WIP");
		public JMenuItem copy_edit = new JMenuItem("Copy");
		public JMenuItem cut_edit = new JMenuItem("Cut");
		public JMenuItem paste_edit = new JMenuItem("Paste");
		public JMenuItem select_all_edit = new JMenuItem("Select All");
		public JMenuItem delete_edit = new JMenuItem("Delete");
		public JMenuItem save_edit = new JMenuItem("Save");
	
	public JMenuItem run_run = new JMenuItem("Test Project...");
	
	public MenuBar() {
		new_project.addActionListener(this);
		open_project.addActionListener(this);
		export_project.addActionListener(this);
		
		project_menu.add(new_project);
		project_menu.add(open_project);
		project_menu.add(export_project);
		
		
		undo_edit.addActionListener(this);
		redo_edit.addActionListener(this);
		copy_edit.addActionListener(this);
		cut_edit.addActionListener(this);
		paste_edit.addActionListener(this);
		select_all_edit.addActionListener(this);
		delete_edit.addActionListener(this);
		save_edit.addActionListener(this);
		
		edit_menu.add(undo_edit);
		edit_menu.add(redo_edit);
		edit_menu.add(new JSeparator());
		edit_menu.add(copy_edit);
		edit_menu.add(cut_edit);
		edit_menu.add(paste_edit);
		edit_menu.add(select_all_edit);
		edit_menu.add(delete_edit);
		edit_menu.add(new JSeparator());
		edit_menu.add(save_edit);
		
		
		run_run.addActionListener(this);
		
		add(project_menu);
		add(edit_menu);
		add(run_run);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == new_project)
			Project.New();
		if (e.getSource() == open_project)
			Project.open();
		
		if (e.getSource() == cut_edit)    
			Interface.editor.cut();
		if (e.getSource() == paste_edit)    
			Interface.editor.paste();    
		if (e.getSource() == copy_edit)    
			Interface.editor.copy();    
		if (e.getSource() == select_all_edit) 
			Interface.editor.selectAll();
		if (e.getSource() == save_edit)
			Interface.saveEditor();
		
		if (e.getSource() == run_run)
			Missions.Mission.testMission();
	}

}

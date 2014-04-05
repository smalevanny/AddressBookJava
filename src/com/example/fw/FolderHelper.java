package com.example.fw;

import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

import com.example.tests.FolderData;
import com.example.utils.SortedListOf;

public class FolderHelper {

	private final ApplicationManager manager;

	public FolderHelper(ApplicationManager manager) {
		this.manager = manager;
	}

	public SortedListOf<FolderData> getFolders() {
		SortedListOf<FolderData> folders = new SortedListOf<FolderData>();
		JTreeOperator tree = new JTreeOperator(manager.getApplication());
		Object[] children = tree.getChildren(tree.getRoot());
		for (Object child : children) {
			folders.add(new FolderData().withName("" + child));
		}
		return folders;
	}

	public void createFolder(FolderData folder) {
		manager.getMenuHelper().pushCreateFolder();
		JDialogOperator dialog = new JDialogOperator(manager.getApplication());
		new JTextFieldOperator(dialog).setText(folder.getName());
		new JButtonOperator(dialog, "OK").push();
	}
}

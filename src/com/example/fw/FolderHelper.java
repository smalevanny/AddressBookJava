package com.example.fw;

import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

import com.example.tests.FolderData;
import com.example.utils.SortedListOf;

public class FolderHelper extends HelperBase{
	

	public FolderHelper(ApplicationManager manager) {
		super(manager);
	}

	public SortedListOf<FolderData> getFolders() {
		SortedListOf<FolderData> folders = new SortedListOf<FolderData>();
		JTreeOperator tree = new JTreeOperator(mainFrame);
		Object[] children = tree.getChildren(tree.getRoot());
		for (Object child : children) {
			folders.add(new FolderData().withName("" + child));
		}
		return folders;
	}

	public String createFolder(FolderData folder) {
		manager.getMenuHelper().pushCreateFolder();
		JDialogOperator dialog = new JDialogOperator(mainFrame);
		new JTextFieldOperator(dialog).setText(folder.getName());
		new JButtonOperator(dialog, "OK").push();
		return waitMessageDialog("Warning", 3000);
	}

}

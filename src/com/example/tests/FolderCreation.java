package com.example.tests;

import org.testng.annotations.Test;


import com.example.utils.SortedListOf;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class FolderCreation extends TestBase {

	@Test
	public void FolderCreation(){
		FolderData folder = new FolderData("new_folder");
		SortedListOf<FolderData> oldFolders= app.getFolderHelper().getFolders();
		app.getFolderHelper().createFolder(folder);
		SortedListOf<FolderData> newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder)));
	}
	
}

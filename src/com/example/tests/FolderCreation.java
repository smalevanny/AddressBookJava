package com.example.tests;

import org.testng.annotations.Test;


import com.example.utils.SortedListOf;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class FolderCreation extends TestBase {

	@Test
	public void SomeFolderCreation(){
		FolderData folder = new FolderData("new_folder");
		SortedListOf<FolderData> oldFolders= app.getFolderHelper().getFolders();
		app.getFolderHelper().createFolder(folder);
		SortedListOf<FolderData> newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder)));
	}
	
	@Test
	public void VariousFoldersCreation(){
		FolderData folder1 = new FolderData("new_folder1");
		FolderData folder2 = new FolderData("new_folder2");
		SortedListOf<FolderData> oldFolders= app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().createFolder(folder1), is(nullValue()));
		SortedListOf<FolderData> newFolders1 = app.getFolderHelper().getFolders();
		assertThat(newFolders1, equalTo(oldFolders.withAdded(folder1)));
		assertThat(app.getFolderHelper().createFolder(folder2), is(nullValue()));
		SortedListOf<FolderData> newFolders2 = app.getFolderHelper().getFolders();
		assertThat(newFolders2, equalTo(newFolders1.withAdded(folder2)));
	}
	
	@Test
	public void SameFoldersCreation(){
		FolderData folder = new FolderData("new_folder3");
		SortedListOf<FolderData> oldFolders= app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().createFolder(folder), is(nullValue()));
		SortedListOf<FolderData> newFolders1 = app.getFolderHelper().getFolders();
		assertThat(newFolders1, equalTo(oldFolders.withAdded(folder)));
		assertThat(app.getFolderHelper().createFolder(folder), containsString("Duplicated folder name"));
		SortedListOf<FolderData> newFolders2 = app.getFolderHelper().getFolders();
		assertThat(newFolders2, equalTo(newFolders1));
	}
	
}

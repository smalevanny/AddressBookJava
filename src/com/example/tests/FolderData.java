package com.example.tests;

public class FolderData implements Comparable<FolderData>{
	private String name;

	public FolderData() {
		
	}
	public FolderData(String foldername) {
		this.name = foldername;
	}	
	
	@Override
	public String toString() {
		return "FolderData [name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FolderData other = (FolderData) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public int compareTo(FolderData other) {
		return this.name.toLowerCase().compareTo(other.name.toLowerCase());
	}
	
	public FolderData withName(String name) {
		this.name = name;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
}

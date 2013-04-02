package com.mediware.arch;

public class mData {
    
    private int[] arguments;
    private String[] labels;
    
    public mData(int[] arguments, String[] labels) {
		
		this.arguments = arguments;
		this.labels = labels;
		
    }

	public int[] getArguments() {
		return arguments;
	}

	public void setArguments(int[] arguments) {
		this.arguments = arguments;
	}

	public String[] getLabels() {
		return labels;
	}

	public void setLabels(String[] labels) {
		this.labels = labels;
	}
    
    

}

package com.yougou.bi.mdp.web.utils;

public class Editor {
    private String type;
    private Options options;
    
    public Editor(){
    	
    }
    public Editor(String editorType){
    	this.type = editorType;
    }
    public Editor(String editorType,Options opt){
    	this.type = editorType;
    	this.options = opt;
    }
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Options getOptions() {
		return options;
	}
	public void setOptions(Options options) {
		this.options = options;
	}
    
    
}

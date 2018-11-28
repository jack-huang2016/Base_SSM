package com.yougou.bi.mdp.web.utils;

public class Options {
	private boolean required;
	private String url;
	private String valueField;
	private String textField;
	private String missingMessage;
	private int precision;
	private String clickFn;
	private boolean readonly;
	private boolean disabled;
	
	private Validatebox validatebox;
	
	public Validatebox getValidatebox() {
		return validatebox;
	}
	public void setValidatebox(Validatebox validatebox) {
		this.validatebox = validatebox;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	public boolean isReadonly() {
		return readonly;
	}
	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public String getTextField() {
		return textField;
	}

	public void setTextField(String textField) {
		this.textField = textField;
	}

	public String getMissingMessage() {
		return missingMessage;
	}

	public void setMissingMessage(String missingMessage) {
		this.missingMessage = missingMessage;
	}

	public String getClickFn() {
		return clickFn;
	}

	public void setClickFn(String clickFn) {
		this.clickFn = clickFn;
	}
	
}

package com.noonerware.autocomplete;

import java.util.HashMap;
import java.util.Map;

public class Node {
	Map<String, Node> children;
	String key;
	
	Node() {
		children = new HashMap<>();
		this.key = null;
	}
	
	Node(String key) {
		children = new HashMap<>();
		this.key = key;
	}
	
	void addChild(String key, Node childNode) {
		getChildren().put(key, childNode);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Map<String, Node> getChildren() {
		if (null == children) {
			children = new HashMap<String, Node>();
		}
		return children;
	}

	public void setChildren(Map<String, Node> children) {
		this.children = children;
	}

	public int getNumberOfChildren() {
		return getChildren().size();
	}
	
}

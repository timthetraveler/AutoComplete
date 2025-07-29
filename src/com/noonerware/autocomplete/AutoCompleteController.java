package com.noonerware.autocomplete;

import java.util.List;

public class AutoCompleteController {
	
	Tree tree = new Tree();
	
	void populateTree(List<String> words) {
		for (String word : words) {
			populateTree(word);
		}
	}
	
	void populateTree(String word) {
		tree.insert(word);
	}

	void outputTree() {
		tree.outputTree();
	}
}

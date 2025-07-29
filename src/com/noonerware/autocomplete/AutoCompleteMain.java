package com.noonerware.autocomplete;

import java.util.Arrays;

public class AutoCompleteMain {

	public static void main(String[] args) {
		AutoCompleteController controller = new AutoCompleteController();
//		String[] words = {"000", "1110", "01", "001", "110"};
		String[] words = {"ABC", "ABOARD", "ABOUT"};
		controller.populateTree(Arrays.asList(words));
//		controller.outputTree();
//		List<String> response = controller.tree.findAllWords("A");
		return;
	}

}

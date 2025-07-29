package com.noonerware.autocomplete;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Tree {

	Node rootNode;

	public Tree() {
		super();
		this.rootNode = new Node();
		this.rootNode.setKey("root");
	}

	void insert(String word) {
		Node parentNode = rootNode;

		@SuppressWarnings("unused")
		List<String> autoComplete = new ArrayList<>();
		String wordInProgress = "";

		for (int i = 0; i < word.length(); i++) {
			String key = word.substring(i, i + 1);
			Node node = parentNode.children.get(key);
			wordInProgress += key;
			autoComplete = findAllWords(wordInProgress);

			if (null == node) {
				//
				// Wasn't found ... add it
				//
				node = new Node(key);
				parentNode.addChild(key, node);
			}
			parentNode = node;
		}
	}

	void outputTree() {
		System.out.println(outputTree(rootNode, ""));
	}

	String outputTree(Node node, String indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%sKey: %s: ", indent, node.getKey()));

		sb.append("\n");
		Set<Entry<String, Node>> entrySet = node.getChildren().entrySet();
		for (Map.Entry<String, Node> entry : entrySet) {
			sb.append(outputTree(entry.getValue(), indent + "  "));
		}
		return sb.toString();
	}

	List<String> findAllWords() {
		List<String> allWords = findAllWords(rootNode, "");
		return allWords;
	}
	
	List<String> findAllWords(String wordInProgress) {
		Node parentNode = rootNode;
		Node node = null;
		List<String> allWords = new ArrayList<>();
		
		for (int i = 0; i < wordInProgress.length(); i++) {
			String letter = wordInProgress.substring(i, i + 1);
			node = parentNode.getChildren().get(letter);
			if (null == node) {
				return allWords;
			}
			parentNode = node;
		}
		allWords = findAllWords(parentNode, wordInProgress);
		return allWords;
	}

	List<String> findAllWords(Node parentNode, String wordInProgress) {
		List<String> response = new ArrayList<>();

		String wordPrefix = wordInProgress;
		if (parentNode.getNumberOfChildren() < 1) {
			response.add(wordInProgress);
			return response;
		}
		
		for (Map.Entry<String, Node> entry : parentNode.getChildren().entrySet()) {
			String key = entry.getKey();
			wordPrefix += key;
			List<String> loopWords = findAllWords(entry.getValue(), wordPrefix);
			loopWords.stream().forEach(response::add);
			wordPrefix = wordInProgress;
		}
		return response;
	}
}

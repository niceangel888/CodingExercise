package com.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Assumptions:
//1. Comparison is case sensitive, for example: Dog is not anagram of god
//2. Whitespace is taken into account, therefore, "dog " is not anagram of "god"
public class StringPairAnagram {

	public static String sort(String s) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	
	public static boolean isAnagram(String s1, String s2) {
	
		if (s1 == null && s2 == null) {
			return false;
		}
		
		if (s1.length() != s2.length()) {
			return false;
		}		
		return sort(s1).equals(sort(s2));
	}
	
	public static void pairOfAnagrams(List<String> words) {
		if (words == null || words.isEmpty()) return;
		
		for(int i=0; i < words.size(); i++) {
			String s1 = words.get(i);
			
			for (int j=i+1; j < words.size(); j++){	
				String s2 = words.get(j);
			
				if (isAnagram(s1, s2)) {
					System.out.println(s1 + ", "+s2);
				}
			}
		}
	
	}
	
	public static void main(String[] args) {
		List<String> words = Arrays.asList("vase", "bat", "gods", "latte", "name", "apres", "spit", "joke",
				"ham", "dog", "act", "tale", "parse", "pits", "asper", "tab", "table", "mane", "late", "god",
				"cat", "table", "save", "spare");
		pairOfAnagrams(words);	
	}
}

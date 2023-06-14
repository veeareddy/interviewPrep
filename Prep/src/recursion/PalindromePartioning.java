package recursion;

import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=WBgsABoClE0
// https://leetcode.com/problems/palindrome-partitioning/description/
public class PalindromePartioning {
	// array to store if string(i,j) is palindrom or not 
	private boolean[][] palindromeResult(char[] arr) {
		
		int n = arr.length;
		
		boolean[][] palindromeMap = new boolean[arr.length][arr.length];
		
		for(int i=0; i< arr.length; i++) {
			for(int j=0; j< arr.length ; j++) {
				palindromeMap[i][j] = false;
			}
		}
		
		for(int i=0; i< arr.length; i++) {
			palindromeMap[i][i] = true;
		}
		
		int length =2;
		while (length <=n) {
			for (int i=0; i<=n-length; i++) {
				 int j = i+length-1;
				 
				 char c1 = arr[i];
				 char c2 = arr[j];
				 
				 if(length ==2) {
					 palindromeMap[i][j] = c1==c2;
				 }
				 else {
					 // in case of odd length (first an last two characters are same and in the (i+1) to(j-1) substring is palindrom then (i,j) is also palindrome
					 palindromeMap[i][j] = palindromeMap[i+1][j-1] && c1==c2;
				 }
			}
			length ++;
		}
		return palindromeMap;
		
	}
	
	public List<List<String>> partition(String s) {
		
		 boolean[][] isPalindrome = palindromeResult(s.toCharArray());
		 List<List<String>> result = new ArrayList<>();
		 backTrack(s,0,new ArrayList<String>(), result, isPalindrome);
		 
		 return result;
	        
	}
	
	private void backTrack(String s,int currentIndex, List<String> currentCuts , List<List<String>> result, boolean[][] isPalidrome ) {
		
		if (currentIndex == s.length()) {
			result.add(new ArrayList<String>(currentCuts));
			return;
		}
		
		for (int i=currentIndex; i< s.length(); i++) {
			
			if (isPalidrome[currentIndex][i]) {
				currentCuts.add(s.substring(currentIndex, i+1));
				backTrack(s, i+1,currentCuts, result,isPalidrome );
				currentCuts.remove(currentCuts.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		String s = "aab";
		new PalindromePartioning().partition(s);
		
		
	}

	
	
	
	
}

package recursion;

import java.util.LinkedList;
import java.util.List;

public class printAllSubSequences {
	
	public static void printSubsequence(char[] str, int currentIndex, List<Character> currentSeq) {
		
		if (currentIndex == str.length) {
			for(Character chr : currentSeq) {
				System.out.print(chr);
			}
			
			if (currentSeq.size() ==0 )
				System.out.println("{}");
				
			System.out.println();
			return;
		}
		//Add current char to the sequence 
		currentSeq.add(str[currentIndex]);
		
		// Recursively call with next index;
		printSubsequence(str, currentIndex+1,currentSeq);
		
		// Remove the last character so seq will be in previous state
		currentSeq.remove(currentSeq.size()-1);
		
		// Recursively call with next index without current char in the seq;
		printSubsequence(str, currentIndex+1,currentSeq);
		
		
	}
	
	public static void main(String[] args) {
		
		String s = "123";
		char[] str = s.toCharArray();
		
		List<Character> seq = new LinkedList<>();
		printSubsequence(str,0,seq);
		
	}

}

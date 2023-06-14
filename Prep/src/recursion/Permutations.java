package recursion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutations {
	
	private static void printPermutationsUtil(char[] arr,List<Character> permutation, Set<Character> charSet) {
		
		if(permutation.size() == arr.length) {
			for(Character chr :permutation ) {
				System.out.print(chr);
			}
			System.out.println("---");
			return;
		}
		
		for(int i=0; i < arr.length; i++) {
			
			if (!charSet.contains(arr[i])) {
				charSet.add(arr[i]);
				permutation.add(arr[i]);
				printPermutationsUtil(arr,permutation,charSet);
				charSet.remove(arr[i]);
				permutation.remove(permutation.size()-1);
			}
		}
		
		
	}
	
	public static void printPermutations(char[] arr) {
		
		printPermutationsUtil(arr, new LinkedList<Character>(), new HashSet<Character>());
		
	}
	
	public static void main(String[] args) {
		
		String str = "abcd";
		
		printPermutations(str.toCharArray());
		
	}

}

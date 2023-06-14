package recursion;

import java.util.LinkedList;
import java.util.List;

// Given an array print all subsequences whose sum is equal to k 
/**
 * Ex: [1,2,1] sum is 2 then {1,1}, {2} is the answer
 * @author sowjanya
 *
 */

/**
 * Pesudo code : 
 *  Each time you can either pick the number or not pick the number, if you pick the number update the sequence and update the sum 
 *  and move to the next number , once your done , need to remove the number added so that you can check for the cases you dont pick the number and again call recursively
 *  for next numbers 
 *  
 * @author sowjanya
 *
 */

public class PrintSubSequncesWhoseSumIsK {
  
	static class Result {
		int sum = 0;
	}
	
	private static void printSubSequenceWithSumKUtil(int[] arr, int currentIndex, List<Integer> subSequence , int sum, int target) {
		
		if (target == sum && !subSequence.isEmpty()) {
			for (Integer num : subSequence) {
				System.out.print(num);
			}
			System.out.println();
			return;
		}
		
		if( currentIndex == arr.length)
			return;
		// Pick the current number 
		subSequence.add(arr[currentIndex]);
		 sum =  sum + arr[currentIndex];
		printSubSequenceWithSumKUtil(arr, currentIndex+1,subSequence, sum,target);
		
		// Back track 
		subSequence.remove(subSequence.size()-1);
		sum = sum - arr[currentIndex];
		
		// Dont pick the current number 
		printSubSequenceWithSumKUtil(arr, currentIndex+1,subSequence, sum,target);
		
		
	}
	
	public static void printSubSeqencesWithSumK(int[] arr, int target) {
		printSubSequenceWithSumKUtil(arr, 0, new LinkedList<Integer>(), 0, target);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,0,-1};
		printSubSeqencesWithSumK(arr,0);
	}
	
}

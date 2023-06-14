package recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
//https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=10

// https://leetcode.com/problems/combination-sum/solutions/1777569/full-explanation-with-state-space-tree-recursion-and-backtracking-well-explained-c/
	
public class CombinationSum {
	
	private void combinationSumUtil(int[] candidates, int currentIndex, int target, int currentSum, List<Integer> currentSeq, List<List<Integer>> result ) {
		//Base case
		if (currentSum > target || currentIndex == candidates.length)
			return;
		
		if ( currentSum == target ) {
			result.add(new ArrayList<Integer>(currentSeq));
			return;
		}
		
		if (currentSum + candidates[currentIndex] < target) {
			// pick the current index element
			currentSum = currentSum + candidates[currentIndex];
			currentSeq.add(candidates[currentIndex]);

			// As we can choose the current element infinite number of times we are not
			// increasing the index here
			combinationSumUtil(candidates, currentIndex+1, target, currentSum, currentSeq, result);

			currentSum = currentSum - candidates[currentIndex];
			currentSeq.remove(currentSeq.size() - 1);
		}
		
		// dont pick the current element 
		
		combinationSumUtil(candidates,currentIndex+1,target , currentSum,currentSeq,result);
		
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
	  
		List<List<Integer>> result = new ArrayList<>();
		
		combinationSumUtil(candidates,0,target,0, new ArrayList<Integer>(), result);
		
		return result;
		
	}
	
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7; 
		
		List<List<Integer>> result = new CombinationSum().combinationSum (candidates, target );
		
		System.out.println(result);
	}
	 
}

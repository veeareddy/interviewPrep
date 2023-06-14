package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Here the number are not unique , need to remove duplicates 
// https://leetcode.com/problems/combination-sum-ii/description/
// https://www.youtube.com/watch?v=G1fRTGRxXU8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=11
public class CombinationsSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<>();
		
		if (candidates == null) 
			return new ArrayList<>();
		
		combinationSum2Util(candidates,target,0,0,new ArrayList<Integer>(), result);
		
		return result;
	}
	
	private void combinationSum2Util(int[] candidates, int target, int currentSum,int currentIndex, List<Integer> curSeq, List<List<Integer>> result) {
		if (currentIndex == candidates.length || currentSum > target ) {
			return;
		}
	
		if ( currentSum == target) {
			result.add(new ArrayList<Integer>(curSeq));
			return ;
		}
		
		for (int i=currentIndex ; i < candidates.length ; i++ ) {
			// Ignore if its current element is already processed in previous step, explanation is in the video 
			if ( i >currentIndex &&  candidates[i] == candidates[i-1] )
				continue;
			
			if (currentSum+candidates[currentIndex] <= target ) {
				currentSum =  currentSum + candidates[currentIndex];
				curSeq.add(candidates[currentIndex]);
				combinationSum2Util(candidates, target, currentSum, i+1,curSeq,result);
				currentSum =  currentSum - candidates[currentIndex];
				curSeq.remove(curSeq.size()-1);
			}
		}
		
	}
}

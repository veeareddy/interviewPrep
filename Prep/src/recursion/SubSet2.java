package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/
//https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=13

public class SubSet2 {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
			
		List<List<Integer>> result = new ArrayList<>();
		// sorting so that the output is in the sorted order 
		Arrays.sort(nums);
		backTrack(nums, 0,new ArrayList<Integer>(), result);
		
		return result;
		
	}
	
	private  void backTrack(int[] nums, int currentIndex, List<Integer> currSeq, List<List<Integer>> result) {
		
		// Here we dont have add length check because for all the lengths we need to add the sequence to the result
		// in the first call empty set is added 
		result.add(new ArrayList<Integer>(currSeq));
	
		// Logic is similar to combiationSum11 problem . 
		
		for (int i=currentIndex; i <nums.length ; i++ ) {
			if (i > currentIndex && nums[i] == nums[i-1])
				continue;
			
			currSeq.add(nums[i]);
			backTrack(nums,i+1,currSeq, result);
			currSeq.remove(currSeq.size()-1);
		}
		
	}

}

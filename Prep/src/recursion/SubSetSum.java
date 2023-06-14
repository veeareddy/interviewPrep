package recursion;

import java.util.ArrayList;

// return all the subset sums 
// https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=12
// https://practice.geeksforgeeks.org/problems/subset-sums2234/1
public class SubSetSum {

	ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {

		ArrayList<Integer> result = new ArrayList<>();
		subsetSumUtil(arr, 0, 0, result);

		return result;
	}

	private void subsetSumUtil(ArrayList<Integer> arr, int currentIndex, int currSum, ArrayList<Integer> result) {
		if (currentIndex > arr.size())
			return;
		if (currentIndex == arr.size()) {
			result.add(currSum);
			return;
		}

		// choose the current element for the sum
		currSum = currSum + arr.get(currentIndex);
		subsetSumUtil(arr, currentIndex + 1, currSum, result);
		// current element is not picked in the sum
		currSum = currSum - arr.get(currentIndex);
		subsetSumUtil(arr, currentIndex + 1, currSum, result);
	}

}

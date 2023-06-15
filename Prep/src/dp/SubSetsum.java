package dp;

public class SubSetsum {

	/*
	 * Topdown recursive approach static Boolean isSubsetSum(int N, int arr[], int
	 * sum){ int[][] cache = new int[N+1][sum+1]; for(int i=0; i<=N; i++) { for(int
	 * j=0; j<=sum; j++) { cache[i][j]=-1; } }
	 * isSubsetSumRecursive(N,arr,sum,cache);
	 * 
	 * return cache[N][sum]==1;
	 * 
	 * }
	 */
	/*
	 * Bottom up approach
	 */
	static Boolean isSubsetSum(int N, int arr[], int sum) {
		return isSubsetSumBottomUp(N, arr, sum);

	}

	static Boolean isSubsetSumRecursive(int n, int arr[], int sum, int[][] cache) {
		// is sum is zero that means for any subset its true , as empty set sum is zero .
		if (sum == 0)
			return true;
		// in other cases where sum is non zero and its empty set then subset wont exist so false here 
		if (n == 0)
			return false;

		if (cache[n][sum] != -1) {

			return cache[n][sum] == 1;
		}
		// check if we can include current element, if we can then substrac its value from sum and pass it to next funciton call 
		// we have to choices when we can include the element 1) pick current element 2) dont pick element 
		// check both the cases if any one of them returns true then its true
		if (arr[n - 1] <= sum) {
			
			boolean included = isSubsetSumRecursive(n - 1, arr, sum - arr[n - 1], cache);
			boolean exclued = isSubsetSumRecursive(n - 1, arr, sum, cache);
			cache[n][sum] = (included || exclued) ? 1 : 0;
		} else {
			// in this case we can't include current elemeent so excluding the current element is only choice
			boolean exclued = isSubsetSumRecursive(n - 1, arr, sum, cache);
			cache[n][sum] = exclued ? 1 : 0;
		}

		return cache[n][sum] == 1;

	}

	// Convert above recursive approach to bottom up approach
	static Boolean isSubsetSumBottomUp(int N, int arr[], int sum) {

		if (sum == 0)
			return true;
		if (arr == null)
			return false;

		int[][] cache = new int[N + 1][sum + 1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= sum; j++) {
				cache[i][j] = -1;
			}
		}

		for (int i = 0; i <= N; i++) {
			cache[i][0] = 1;
		}

		for (int i = 1; i <= sum; i++) {
			cache[0][i] = 0;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= sum; j++) {

				if (arr[i - 1] <= j) {
					int included = cache[i - 1][j - arr[i - 1]];
					int excluded = cache[i - 1][j];
					cache[i][j] = (included == 1 || excluded == 1) ? 1 : 0;
				} else {
					int excluded = cache[i - 1][j];
					cache[i][j] = (excluded == 1) ? 1 : 0;
				}
			}
		}

		return cache[N][sum] == 1;

	}

}

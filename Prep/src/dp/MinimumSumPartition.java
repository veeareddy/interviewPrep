package dp;
//https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/#practice

//https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
// 
// Lets take two partitions are s1 and s2 
// Range values of  S1 and S2 -> 0, to sum of all numbers , lets say S
//S1+S2 = S ==> S1 = S-S2;
// S1-S2 need to be minimized ((S-S2)-S2) --> S-2S2 should be minimized .
// S2 can have values from 0 to S2 .among these only some of them can be S2 values ,(like lets say [1,2,7] then S2 could be 1, 2,3,7,8,9,10 
// We can find out what are the values S2 can be from the DP array of subSet probelm . 
// in Subset problem if we send S as sum , dp[arraySize] row contains T or F for all the values from 0, S. From this we know which are all possible values for S2

//We dont have to traverse complete array it doesnt matter S1, S2 we are interested only in the difference . 
// This is better explained in the video 
// 
public class MinimumSumPartition {

	public int minDifference(int arr[], int n) {
		if (n == 0)
			return 0;

		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		int[][] result = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				result[i][j] = -1;
			}
		}

		for (int i = 0; i <= n; i++) {
			result[i][0] = 1;
		}

		for (int i = 1; i <= sum; i++) {
			result[0][i] = 0;
		}


		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {

				if (arr[i - 1] <= j) {

					int include = result[i - 1][j - arr[i - 1]];
					int exclude = result[i - 1][j];
					result[i][j] = include | exclude;

				} else {
					result[i][j] = result[i - 1][j];
				}
			}
		}

		int minDiff = sum;
		for (int j = 0; j <= sum / 2; j++) {

			if (result[n][j] == 1) {
				minDiff = Math.min(minDiff, sum - 2 * j);

			}
		}

		return minDiff;
	}

}

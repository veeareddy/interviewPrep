package dp;

// https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=5
public class KnapSackZeroOneTabluization {

	static int knapSack(int W, int wt[], int val[], int n) {
		
		int[][] dp = new int[n+1][W+1];
		
		for(int i=0; i<=n; i++) {
			for (int j=0; j<=W; j++) {
				//Base conditon in the recursion (index==0 or weight ==0)
				if (i==0 || j==0) {
					dp[i][j] = 0;
				}
			}
		}
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=W; j++) {
				
				if (wt[i-1] <= j) {
					
					dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
				
			}
		}
		
		
		return dp[n][W];

	}

}

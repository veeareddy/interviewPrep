package dp;
//https://www.geeksforgeeks.org/partition-problem-dp-18/
//https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8
// The partition problem is to determine whether a given set can be partitioned into
//two subsets such that the sum of elements in both subsets is the same
public class EqualSubSetPartition {

	// This is similar to previous problem 
	static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum = sum +arr[i];
        }
        // if sum is odd then we can't divide the array into two parts
        if (sum%2 !=0)
            return 0;
        else 
        	// if there is a partion with half of sum of the array , we can divide array into two partitions 
            return partitionSum(N, arr, sum/2);
    }
    
    static int partitionSum(int n, int[] arr, int sum) {
        
        if (sum == 0)
            return 1;
        if (arr == null)
            return 0;
        int[][] cache = new int[n+1][sum+1];
        
        for (int i=0;i<=n;i++) {
            for (int j=0; j<=sum ; j++) {
                cache[i][j] = -1;
            }
        }
        
        for (int i=0; i<=n; i++) {
            cache[i][0] = 1;
        }
        for(int i=1; i<=sum;i++) {
            cache[0][i] =0;
        }
        
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=sum;j++) {
                
                if (arr[i-1] <= j) {
                    int include = cache[i-1][j-arr[i-1]];
                    int exclude = cache[i-1][j];
                    cache[i][j] = (include == 1 || exclude ==1) ? 1: 0;
                }
                else {
                    cache[i][j]  = cache[i-1][j];
                }
            }
        }
        
        return cache[n][sum];
  
     }
}

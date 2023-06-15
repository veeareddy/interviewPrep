package dp;

//269
// 95,4,60,32,23,72,

// you may think to pass value to the knapsack function similar to backtracking that we did earlier 
// but here we are storing the function result value in array there , index and available weight are two variables , if we pass
// total value as parameter then it will be another parameter to store in the array and increase complexity .
//instead simply add the value in function call itself not as parameter.
//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945
public class KnapsackZeroOne {

	
	 //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int[][] cache = new int[n][W+1];
        
        for (int i=0; i< n; i++) {
            for (int j=0; j<=W; j++) {
                cache[i][j] = -1;
            }
        }
        
        //Here i am starting with zero index, i think it makes more sense to pass last index and reduce it in further recursive calls 
        // have smallest problem in base condition . 
        return knapSackUtil(0,W,wt,val,cache); // your code here 
    } 
    
    static int knapSackUtil(int currentIndex, int availableWeight, int wt[], 
            int val[], int[][] cache) {
        // Base condition
        if (availableWeight == 0 || currentIndex >= wt.length )
            return 0;
            
        if (currentIndex >= wt.length)
            return 0;
        if ( cache[currentIndex][availableWeight]  != -1) {
            return cache[currentIndex][availableWeight];
        }
        
        if(wt[currentIndex] <= availableWeight) {
            cache[currentIndex][availableWeight] = 
            Math.max(
               val[currentIndex]+ knapSackUtil(currentIndex+1,availableWeight-wt[currentIndex] ,wt,val, cache),
                knapSackUtil(currentIndex+1,availableWeight ,wt,val, cache)
                );
        }
        else {
            cache[currentIndex][availableWeight] =  knapSackUtil(currentIndex+1,availableWeight ,wt,val, cache);
        }
        
        return cache[currentIndex][availableWeight];
    }
    
    
    
    static int knapSackRegular(int W, int wt[], int val[], int n) 
    { 
        int[][] cache = new int[n][W+1];
        
        for (int i=0; i< n; i++) {
            for (int j=0; j<=W; j++) {
                cache[i][j] = -1;
            }
        }
        
        //Here i am starting with zero index, i think it makes more sense to pass last index and reduce it in further recursive calls 
        // have smallest problem in base condition . 
        return knapSackUtilRegular(n,W,wt,val,cache); // your code here 
    } 
    
    
    static int knapSackUtilRegular(int currentIndex, int availableWeight, int wt[], 
            int val[], int[][] cache) {
        // Base condition
        if (availableWeight == 0 || currentIndex <=0 )
            return 0;
            
       
        if ( cache[currentIndex][availableWeight]  != -1) {
            return cache[currentIndex][availableWeight];
        }
        // Two choices if the current item weight is less than or eqaul to current capacity 1) Pick current item 2) dont pick current item 
        if(wt[currentIndex] <= availableWeight) {
            cache[currentIndex][availableWeight] = 
            Math.max(
               val[currentIndex]+ knapSackUtilRegular(currentIndex-1,availableWeight-wt[currentIndex] ,wt,val, cache),
               knapSackUtilRegular(currentIndex+1,availableWeight ,wt,val, cache)
                );
        }
        else {
            cache[currentIndex][availableWeight] =  knapSackUtilRegular(currentIndex+1,availableWeight ,wt,val, cache);
        }
        
        
        
        return cache[currentIndex][availableWeight];
    }
    
    
    
    
    
    
    
    public static void main(String[] args) {
    	int[] v = {1,2,3};
    	int[] w = {4,5,1};
    	
    	knapSackRegular(4, w, v, 3); 
    	
    }

}

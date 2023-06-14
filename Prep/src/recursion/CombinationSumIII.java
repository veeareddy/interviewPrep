package recursion;
//https://leetcode.com/problems/combination-sum-iii/

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	private void combinationSum3Util (int levels, int target, int curretSum, int currlevel, 
				int currentNum,List<Integer> charSeq, List<List<Integer>> result) {
		
		if (currlevel > levels || curretSum > target || currentNum > 9)
			return ;
		
		if (levels == currlevel && curretSum == target ) {
			result.add(new ArrayList<Integer>(charSeq));
		}
		
		for (int i=currentNum; i<=9 ; i++) {
			
			if ( curretSum + i <= target) {
				curretSum  = curretSum +i ;
				charSeq.add(i);
				combinationSum3Util(levels,target,curretSum,currlevel+1,i+1,charSeq,result);
				charSeq.remove(charSeq.size()-1);
				curretSum  = curretSum -i;
			}
		}
		
		
		
	}
	public List<List<Integer>> combinationSum3(int k, int n) {
        
		List<List<Integer>> result = new ArrayList<>();
		combinationSum3Util(k,n,0,0,1,new ArrayList<Integer>(), result);
		return result;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> result = new CombinationSumIII().combinationSum3(3, 7);
		
	}

}

package recursion;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
//https://www.youtube.com/watch?v=bLGZhJlt4y0&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=20
public class RatInaMaze {
	
	private static boolean isValid (int i, int j, int[][] matrix) {
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		if (i < rows && j < cols && i >=0 && j >=0)
			return true;
		return false;	
	}
	
	
	public static ArrayList<String> findPath(int[][] m, int n) {
		
		int rows = m.length;
		int cols = m[0].length;
		// to keep track which cless have been visited
		boolean[][] visited = new boolean[rows][cols];
		
		ArrayList<String> result = new ArrayList<>();
		
		if ( m[n-1][n-1] == 0 || m[0][0] == 0)
			return result;
		
		visited[0][0] = true;
		
		backTrack(m,0,0,visited,new StringBuilder(),result);
		
		
		return result;
	}
	
	public static void backTrack(int[][] matrix, int i, int j,boolean[][] visited , StringBuilder currentPath,ArrayList<String> result) {
		
	
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		// once we reach bottom right corner we found the solution, add it to the result
		if (i == rows-1 && j== cols-1) {
			result.add( new String(currentPath));
			return;
		}
		// possible paths 
		int[][] paths = { {1,0},{-1,0},{0,-1},{0,1}};
		char[] dirs = {'D','U','L','R'};
		// Try for each path
		for (int k=0; k < paths.length; k++) {
			
			int nextX = i+paths[k][0];
			int nextY = j+paths[k][1];
	
			if (isValid(nextX, nextY, matrix) &&  !visited[nextX][nextY] && matrix[nextX][nextY] == 1) {
				currentPath.append(dirs[k]);
				visited[nextX][nextY] = true;
				backTrack(matrix,nextX, nextY,visited, currentPath,result);
				// backTrack 
				currentPath.deleteCharAt(currentPath.length()-1);
				visited[nextX][nextY] = false;
			}
		}
	
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,1},{1,1}};
		int n= 2;
		
		new RatInaMaze().findPath(matrix, n);
	}
	  

}

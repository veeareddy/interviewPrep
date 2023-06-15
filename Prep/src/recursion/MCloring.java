package recursion;

// https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
// https://www.youtube.com/watch?v=wuVwUK25Rfc&t=7s
public class MCloring {

	// Function to determine if graph can be coloured with at most M colours
	// such
	// that no two adjacent vertices of graph are coloured with same colour.
	public boolean graphColoring(boolean graph[][], int m, int n) {
		// Your code here

		int[] vertexColorMap = new int[n];

		for (int i = 0; i < n; i++) {
			vertexColorMap[i] = -1;
		}

		return backTrack(0, n, graph, m, vertexColorMap);

	}

	private boolean isValid(int currentVertex, int color, boolean[][] graph, int[] vertexColorMap) {

		for (int i = 0; i < graph.length; i++) {
			if (graph[currentVertex][i]) {
				int destVertex = i;
				int destColor = vertexColorMap[destVertex];
				if (destColor == color)
					return false;
			}
		}

		return true;

	}

	private boolean backTrack(int currentVertex, int vertexCount, boolean[][] graph, int colorCount,
			int[] vertexColorMap) {

		if (currentVertex == vertexCount)
			return true;

		for (int i = 0; i < colorCount; i++) {

			if (isValid(currentVertex, i, graph, vertexColorMap)) {

				vertexColorMap[currentVertex] = i;

				if (backTrack(currentVertex + 1, vertexCount, graph, colorCount, vertexColorMap)) {
					return true;
				}

				vertexColorMap[currentVertex] = -1;

			}

		}

		return false;

	}
}

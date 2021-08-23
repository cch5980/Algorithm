package lv2;

public class Programmers_카카오프렌즈컬러링북 {
	static boolean[][] visited;
	static int[][] pos = {{-1,0},{1,0},{0,-1},{0,1}};	// 상,하,좌,우
	static int M, N;
	static int tmpSize;
	public static void main(String[] args) {
		M = 6;
		N = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		visited = new boolean[M][N];
		
		int numberOfArea = 0;
		int maxSizeOfOneArea = Integer.MIN_VALUE;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(picture[i][j] != 0 && !visited[i][j]) {
					tmpSize = 0;
					dfs(i,j,picture[i][j], picture);
					numberOfArea++;
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tmpSize);
				}
			}
		}
		System.out.println(numberOfArea + " " + maxSizeOfOneArea);
	}
	
	static void dfs(int r, int c, int color, int[][] picture) {
		tmpSize++;
		visited[r][c] = true;
		for (int i = 0; i < pos.length; i++) {
			int nr = r + pos[i][0];
			int nc = c + pos[i][1];
			
			if(nr>=0 && nr<M && nc>=0 && nc<N && picture[nr][nc] == color && !visited[nr][nc]) {
				dfs(nr,nc,color,picture);
			}
		}
	}
	
}

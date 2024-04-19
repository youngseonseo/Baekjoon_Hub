import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		arr = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		int count1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs1(i, j);
					count1++;
				}
			}
		}

		int count2 = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs2(i, j);
					count2++;
				}
			}
		}
		sb.append(count1).append(" ").append(count2);
		System.out.println(sb);
	}

	private static void dfs1(int i, int j) {
		visited[i][j] = true;
		for (int n = 0; n < 4; n++) {
			int newX = i + dx[n];
			int newY = j + dy[n];
			if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
				if (!visited[newX][newY] && arr[i][j] == arr[newX][newY]) {
					dfs1(newX, newY);
				}
			}
		}
	}

	private static void dfs2(int i, int j) {
		visited[i][j] = true;
		for (int n = 0; n < 4; n++) {
			int newX = i + dx[n];
			int newY = j + dy[n];

			if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
				if (!visited[newX][newY]) {
					if (arr[i][j] == 'R'|| arr[i][j] == 'G') {
						if(arr[newX][newY] == 'R' || arr[newX][newY] == 'G') {
							dfs2(newX, newY);	
						}
					}
					if(arr[i][j] == 'B') {
						if(arr[newX][newY] == 'B') {
							dfs2(newX, newY);	
						}
					}
				}
			}
		}
	}

}
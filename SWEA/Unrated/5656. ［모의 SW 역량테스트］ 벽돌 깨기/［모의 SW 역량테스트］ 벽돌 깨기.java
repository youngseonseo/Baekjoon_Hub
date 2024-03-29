
import java.io.*;
import java.util.*;

public class Solution {

	static int result, N, W, H, cnt, crashCnt;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int[][] original = new int[16][13];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			cnt = 0;
			result = 987654321;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] arr = new int[H][W];
			

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					original[i][j] = arr[i][j];
					if (arr[i][j] != 0) {
						cnt++;
					}
				}
			}
			permutation(new int[N], new boolean[W], 0, arr);
//			explode(new int[]{2,2}, arr, 0);
//			print(arr);
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}

	private static void permutation(int array[], boolean[] visited, int idx, int arr[][]) {
		if (idx == N) {
			crashCnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					arr[i][j] = original[i][j];
				}
			}			
			explode(array, arr, 0);			
			result = Math.max(result, crashCnt);
			return;
		}
		for (int i = 0; i < W; i++) {
			array[idx] = i;
			permutation(array, visited, idx + 1, arr);

		}

	}

	private static void explode(int col[], int arr[][], int crashBrick) {

		for (int l = 0; l < col.length; l++) {						
			Queue<int[]> queue = new LinkedList<>();
			int firstX = findTop(col[l], arr);
			int firstY = col[l];
			if (firstX == -1) {
				continue;
			}

			queue.add(new int[] { firstX, firstY }); // 타겟 열의 번호 찾아 넣어주기

			while (!queue.isEmpty()) {

				int[] now = queue.poll();
				int nowX = now[0];
				int nowY = now[1];
				int power = arr[nowX][nowY] - 1; // 파괴 위력
				arr[nowX][nowY] = 0;				
				for (int i = 0; i < 4; i++) {
					for (int p = 1; p <= power; p++) {
						int new_x = nowX + dx[i] * p;
						int new_y = nowY + dy[i] * p;
						if (new_x < 0 || new_y < 0 || new_x >= H || new_y >= W)
							continue;
						if (arr[new_x][new_y] > 1) {
							queue.add(new int[] { new_x, new_y });
							continue;
						}
						arr[new_x][new_y] = 0;

					}
				}
			}
			
			arr = gravity(arr);
		}
		int tmp = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (arr[i][j] != 0)
					tmp++;
			}
		}
		result = Math.min(result, tmp);
	}

	private static int[][] gravity(int arr[][]) {
		for (int i = 0; i < W; i++) {
			for (int j = H - 2; j >= 0; j--) {
				if (arr[j][i] == 0)
					continue;
				for (int k = H - 1; k > j; k--) {					
					if (arr[j][i] != 0 && arr[k][i] == 0) {
						arr[k][i] = arr[j][i];
						arr[j][i] = 0;
						break;
					}
				}
			}
		}
		return arr;
	}

	private static int findTop(int w, int arr[][]) {
		for (int i = 0; i < H; i++) {
			if (arr[i][w] != 0) {
				return i;
			}
		}
		return -1;
	}

	public static void print(int[][] arr) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

import java.io.*;
import java.util.*;

public class Solution {

	static int result;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			arr = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (i == j) {
						arr[i][j] = 0;
					}else if(num == 1) {
						arr[i][j] = 1;
					}else {
						arr[i][j] = 100001;
					}
				}
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					for(int k =1; k<= N; k++) {
						arr[j][k] = Math.min(arr[j][k], arr[k][i] + arr[i][j]);
					}
				}
			}

			result = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= N; j++) {
					sum += arr[i][j];
				}
				result = Math.min(result, sum);
			}
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

}
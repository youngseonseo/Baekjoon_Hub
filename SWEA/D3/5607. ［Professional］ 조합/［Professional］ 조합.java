import java.io.*;
import java.util.*;

public class Solution {

	static int MOD = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			long factorial[] = new long[N + 1];
			factorial[1] = 1;
			for (int i = 2; i <= N; i++) {
				factorial[i] = (factorial[i - 1] * i) % MOD;
			}
			long bottom = (factorial[R] * factorial[N - R]) % MOD;
			bottom = power(bottom, MOD - 2);
			sb.append("#").append(t + 1).append(" ").append((factorial[N] * bottom) % MOD).append("\n");
		}
		System.out.println(sb);
	}

	private static long power(long a, long b) {
		if (b == 0) {
			return 1;
		} else if (b == 1) {
			return a;
		}
		if (b % 2 == 0) {
			long tmp = power(a, b / 2);
			return (tmp * tmp) % MOD;
		}
		long tmp = power(a, b - 1) % MOD;
		return (tmp * a) % MOD;
	}
}
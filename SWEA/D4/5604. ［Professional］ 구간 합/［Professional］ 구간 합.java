import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.*;
import java.util.*;

public class Solution {

	private static int[] s;
	private static final Map<Long, Long> cache = new HashMap<>();

	private static boolean isNines(long N) {
		return N == 9 || N % 10 == 9 && isNines(N / 10);
	}

	private static long getDigit(long N) { // 각 자리수로 나누기
		return N > 9 ? getDigit(N / 10) * 10 : 1;
	}

	private static long S(long N) {
		if (cache.containsKey(N)) {
			return cache.get(N);
		}
		if (N < 10) {
			return N > 0 ? s[(int) N] : 0;
		}
		if (isNines(N)) {
			return 45L * ((long) Math.log10(N + 1)) * getDigit(N);
		}

		long v = getDigit(N);
		long res = N / v * (N % v + 1) + S(N % v) + S(N - 1 - N % v);

		cache.put(N, res);
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		s = new int[10];
		for (int i = 1; i <= 9; i++) { // 1부터 10까지의 부분합 ㅈ장
			s[i] = s[i - 1] + i;
		}

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());

			sb.append('#').append(tc).append(' ').append(S(B) - S(A - 1)).append('\n');
		}
		System.out.println(sb);
	}

}
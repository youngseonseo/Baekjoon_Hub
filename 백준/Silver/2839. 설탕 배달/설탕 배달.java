import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int five = N / 5;
		for (int i = five; i >= 0; i--) {
			if ((N - i * 5) % 3 == 0) {
				System.out.println(i + (N - i * 5) / 3);
				System.exit(0);;
			}
		}
		System.out.println(-1);
	}
}
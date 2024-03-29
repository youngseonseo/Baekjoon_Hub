import java.io.*;
import java.util.*;

public class Main {

	public static class Coordinate { // 좌표 클래스 생성
		int x;
		int y;

		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int parent[], n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // tc

		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine()); // 편의점 개수

			ArrayList<Coordinate> arr = new ArrayList<>();
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				arr.add(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			parent = new int[n + 2];
			for (int i = 0; i < n + 2; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < n + 2; i++) {
				for (int j = i + 1; j < n + 2; j++) {
					Coordinate m = arr.get(i);
					Coordinate k = arr.get(j);
					if (Math.abs(m.x - k.x) + Math.abs(m.y - k.y) <= 1000) {
						union(i, j);
					}
				}
			}

			if (find(n + 1) == find(0)) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}
	}


	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b) {
			parent[b] = a;
		} else if (a > b) {
			parent[a] = b;
		}
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return find(parent[x]);
	}
}
import java.io.*;
import java.util.*;

public class Main {

	static char[][] arr;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static Queue<int[]> waters = new LinkedList<>();
	static int gx, gy, bx, by, R, C, waterCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s;
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
				if (arr[i][j] == 'D') {
					bx = i;
					by = j;
				} else if (arr[i][j] == 'S') {
					gx = i;
					gy = j;
				} else if (arr[i][j] == '*') {
					waters.add(new int[] { i, j });
				}
			}
		}
		escape();

	}

	private static void escape() {

		Queue<int[]> pq = new LinkedList<>();
		boolean visited[][] = new boolean[R][C];
		pq.add(new int[] { gx, gy, 0 });
		visited[gx][gy] = true;
		// 먼저 물이 차는 것 구현
		while (!pq.isEmpty()) {

			int[] out = pq.poll();

			for (int i = 0; i < 4; i++) {
				int new_x = out[0] + dx[i];
				int new_y = out[1] + dy[i];
				int new_cnt = out[2] + 1;
				if (new_x >= 0 && new_y >= 0 && new_x < R && new_y < C) {
					while (waterCnt < new_cnt) {
						expand();
					}

					if (new_x == bx && new_y == by) { // 비버집 도착
						System.out.println(new_cnt);
						return;
					}

					if ((arr[new_x][new_y] == '.' || arr[new_x][new_y] == 'D') && !visited[new_x][new_y]) {
						visited[new_x][new_y] = true;
						pq.add(new int[] { new_x, new_y, new_cnt });
					}
				}
//				System.out.println(new_cnt);
//				print();
			}
		}
		System.out.println("KAKTUS");
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

	private static void expand() {

		boolean visited[][] = new boolean[R][C];

		int size = waters.size();
		for (int i = 0; i < size; i++) {
			int waterGet[] = waters.poll();
			visited[waterGet[0]][waterGet[1]] = true;

			for (int j = 0; j < 4; j++) {
				int new_x = waterGet[0] + dx[j];
				int new_y = waterGet[1] + dy[j];

				if (new_x >= 0 && new_y >= 0 && new_x < R && new_y < C && !visited[new_x][new_y]) {
					if (arr[new_x][new_y] == '.') {
						visited[new_x][new_y] = true;
						arr[new_x][new_y] = '*';
						waters.add(new int[] { new_x, new_y });
					}
				}
			}
		}
		waterCnt += 1;
	}
}
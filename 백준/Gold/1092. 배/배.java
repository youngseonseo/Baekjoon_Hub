import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[N];
        int[] position = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        Integer[] box = new Integer[M];
        boolean[] visited = new boolean[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(box, Collections.reverseOrder());
        Arrays.sort(crane, Collections.reverseOrder());

        if (box[0] > crane[0]) {
            System.out.println("-1");
        } else {
            int time = 0;
            int cnt = 0;
            while (cnt < M) {
                for (int i = 0; i < N; i++) {
                    while(position[i] < M){
                        if(crane[i] >= box[position[i]] && visited[position[i]] == false){
                            visited[position[i]] = true;
                            cnt++;
                            position[i]++;
                            break;
                        } else{
                            position[i]++;
                        }
                    }
                }
                time++;
            }
            System.out.println(time);
        }
    }
}
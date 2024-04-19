import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, i);
                visited[i] = false;
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0; i< list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    private static void dfs(int start, int end) {
        if(visited[arr[start]] ==false){
            visited[arr[start]] = true;
            dfs(arr[start], end);
            visited[arr[start]] = false;
        }
        if(arr[start] == end){
            list.add(end);
        }
    }
}
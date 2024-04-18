import java.io.*;
import java.util.*;
class Solution {
    static int[] arr;
    static int idx =0;
    static boolean[] visited;
    static int[] answer;
    static  HashSet<Integer> set = new HashSet<>();
    
    public int[] solution(int[] numbers) {
        int[] answer;
        int size = numbers.length;
        arr = new int[100];
        visited = new boolean[100];
        combination(size, 2, 0, 0, numbers);
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        answer = new int[list.size()];
        
        for (int i = 0 ; i < list.size() ; i++) {
            answer[i] = list.get(i).intValue();
        }
        return answer;
    }
    
    public void combination(int N, int M, int start, int depth, int[] numbers) {
        
        if(depth == M){
            int result =0;
            for(int i=0; i< M; i++){
                result += numbers[arr[i]];
            }
            set.add(result);
            
            return;
        }
        
        for(int i =start; i< N; i++){
            if(visited[i] == false){
                visited[i] = true;
                arr[depth] = i;
                combination(N, M ,i+1, depth +1, numbers);
                visited[i] = false;
            }
        }
    }
}
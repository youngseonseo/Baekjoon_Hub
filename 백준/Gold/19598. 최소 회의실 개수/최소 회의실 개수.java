import java.io.*;
import java.util.*;

public class Main {
    static class Class{
        int start;
        int end;
        public Class(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Class> pq = new PriorityQueue<>(new Comparator<Class>() {
            @Override
            public int compare(Class o1, Class o2) {
                return o1.start -o2.start;
            }
        });
        PriorityQueue<Class> pqAnswer = new PriorityQueue<>(new Comparator<Class>(){
            @Override
            public int compare(Class o1, Class o2){
                return o1.end - o2.end;
            }
        });


        for(int i = 0; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            pq.add(new Class(startTime, endTime));
        }
        pqAnswer.add(pq.poll());
        for(int i =0; i<N - 1 ; i++){
            Class next = pq.poll();
            if(pqAnswer.peek().end <= next.start){
                pqAnswer.poll();
                pqAnswer.add(next);
            }else{
                pqAnswer.add(next);
            }
        }
        System.out.println(pqAnswer.size());

    }
}
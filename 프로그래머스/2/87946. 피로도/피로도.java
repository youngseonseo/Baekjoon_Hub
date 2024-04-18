class Solution {
    static int order[];
    static boolean visited[];
    static int K;
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        
        order = new int[100000];
        visited = new boolean[100000];
        int size = dungeons.length;
        K =k;
        permu(size,size,0,dungeons);
        
        return answer;
    }
    
    public void permu(int n, int m, int depth, int[][] dungeons){
        if(depth == m){

            count(dungeons, m, order);
            // System.out.println();
            return;
        }
        for(int i =0; i< n; i++){
            if(!visited[i]){
                visited[i] = true;
                order[depth] = i;
                permu(n, m , depth + 1, dungeons);
                visited[i] = false;
            }
        }
    }
    
    public void count(int[][] dungeons, int m, int order[]){
        int count =0;
        int curK = K;
        for(int i =0; i< m; i++){
            int minPr= dungeons[order[i]][0];
            int costPr = dungeons[order[i]][1];
            // System.out.println("minPr = " + minPr + " costPr = "+ costPr + " curK = "+ curK);
            if(minPr <= curK){
                curK -= costPr;
                count++;
            }
        }
        answer = Math.max(answer, count);
    }
}
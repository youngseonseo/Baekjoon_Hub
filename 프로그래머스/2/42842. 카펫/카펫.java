class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // (w + h) * 2  - 4 = brown 
        // (w - 2) * (h - 2) = yellow 
        
        for(int h = 1; h <= (brown + 4) /2 ; h ++){
            for(int w = h; w  <= (brown + 4) /2; w++ ){
                if(((w + h) * 2 - 4 == brown ) && ((w-2) * (h - 2) == yellow)){
                    answer[0] = w;
                    answer[1] = h;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        int removeZero = 0;
        int size =0;
        while(!s.equals("1")){
            size = s.length();
            int new_size = size;
            for(int i=0; i< size;i++){
                if(s.charAt(i) == '0'){
                    removeZero++;
                    new_size--;
                }
            }
            // 이진 변환
            s= "";
            for(int i = new_size; i>0; ){
                s+= (i%2);
                i=i/2;
            }
            count++;
        }
        answer[0] = count;
        answer[1] = removeZero;
        return answer;
    }
}
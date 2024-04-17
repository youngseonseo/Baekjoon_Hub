class Solution {
    public int solution(int n) {
        int answer = 0;
        int size = 0;
        
        String s =Integer.toBinaryString(n);

        for(int i =0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                size++;
            }
        }
        n++;
   
        while(true){
            String new_s = Integer.toBinaryString(n);
            int size2 =0;
            for(int i =0; i<new_s.length(); i++){
                if(new_s.charAt(i)=='1'){
                    size2++;
                }
            }

            if(size == size2){
                return n;
            }
            n++;
        }
    }
}
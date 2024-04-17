class Solution {
    public String solution(String s) {

        String answer = "";
        boolean first = false;
        for(int i =0; i< s.length(); i++){
    
            if(i ==0 || first){  // 첫 문자인 경우
                if(s.charAt(i) >= 'a' && s.charAt(i)<='z'){
                    answer += (char)(s.charAt(i) - 'a' + 'A');
                    first = false;
                } else if(s.charAt(i)==' '){
                    answer += s.charAt(i);
                    first = true;
                }
                else{
                    answer += s.charAt(i);
                    first = false;
                }
            }
            else if(s.charAt(i)==' '){ // 공백인 경우
                first = true;
                answer += s.charAt(i);

            } else{
                 if(s.charAt(i) >= 'A' && s.charAt(i)<='Z'){
                    answer += (char)(s.charAt(i) - 'A' + 'a');
                }else{
                     answer += s.charAt(i);
                 }
            }
        }
        System.out.println(answer);
        return answer;
    }
}
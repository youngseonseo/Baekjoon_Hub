import java.util.*;
import java.util.*;

public class Solution {
    
   
    public int solution(int n) {
        return  cal(n);
    }
    
    public int cal(int cur) {
        int cnt = 0;
        while(cur != 0){
            if(cur % 2 ==0){
                cur /= 2;
            } else{
                cur -=1;
                cnt++;
            }
        }
        return cnt;
    }
}
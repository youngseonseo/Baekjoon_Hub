import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int min = Integer.MAX_VALUE;
        int max = -1 * Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(s);
         while(st.hasMoreTokens()) {
            int num = Integer.valueOf(st.nextToken());
            max = Math.max(max, num);
            min = Math.min(min, num);
            
        }
        answer += min + " " + max;

        return answer;
        
    }
}
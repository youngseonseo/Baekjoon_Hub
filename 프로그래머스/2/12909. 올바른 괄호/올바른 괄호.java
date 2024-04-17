import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();
        int size = s.length();
        for(int i =0; i< size; i++){
            char now = s.charAt(i);
            if(now =='('){
                stack.add("(");
            }else{
                if(stack.size() < 1){
                    answer = false;
                    return answer;
                }
                else{
                    stack.pop();
                }
            }
        }
        if(stack.size() >=1){
            answer = false;
        }
        
        return answer;
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;
 
class Main
{
    static Scanner sc;
    static int N, x, y;
    static Vector<Integer> v;
    static int answer = 0;
    
    public static void main (String[] args) throws java.lang.Exception
    {
        sc = new Scanner(System.in);
        
        N = sc.nextInt();
        int[] arr = new int[50002];
        
        for(int i = 0; i < N; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            arr[i] = y;
        }
        
        Stack<Integer> stk = new Stack<Integer>();
        for(int i = 0; i <= N; i++){
            while(!stk.empty() && stk.peek() > arr[i]){
                answer += 1;
                stk.pop();
            }
            
            if(!stk.empty() && stk.peek() == arr[i])
                continue;
                
            stk.push(arr[i]);
        }
        
        System.out.println(answer);
    }
}
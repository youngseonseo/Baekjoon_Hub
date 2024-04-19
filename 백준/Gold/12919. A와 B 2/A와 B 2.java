import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String S, T;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        makeS(T);
        System.out.println(result);
    }

    private static void makeS(String t) {
        if (t.length() == S.length()) {
            if (t.equals(S)) {
                result = 1;
            }
        } else {
            if (t.charAt(t.length() - 1) == 'A') {
                makeS(t.substring(0, t.length() - 1));
            }
            if (t.charAt(0) == 'B') {
                StringBuilder sb = new StringBuilder();
                makeS(sb.append(t.substring(1, t.length())).reverse().toString());

            }
        }
    }
}
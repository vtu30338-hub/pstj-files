import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternatingCharacters(String s) {

        int deletions = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                deletions++;
            }
        }

        return deletions;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < q; i++) {
            String s = scanner.nextLine();

            int result = Result.alternatingCharacters(s);

            System.out.println(result);
        }

        scanner.close();
    }
}

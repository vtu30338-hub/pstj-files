import java.util.*;

public class Solution {
    // Function to find longest palindromic substring length in a given string
    private static int longestPalindromeSubstring(String s) {
        int n = s.length();
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxLen = 2;
            }
        }

        // Check substrings of length > 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    maxLen = len;
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        sc.close();

        // Generate all rotations
        for (int k = 0; k < n; k++) {
            String rotated = s.substring(k) + s.substring(0, k);
            System.out.println(longestPalindromeSubstring(rotated));
        }
    }
}

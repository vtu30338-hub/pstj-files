import java.util.*;

public class Solution {

    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {

                // Try removing the left character
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                }

                // Try removing the right character
                if (isPalindrome(s, left, right - 1)) {
                    return right;
                }

                return -1;
            }
        }

        // String is already a palindrome
        return -1;
    }

    public static boolean isPalindrome(String s, int left, int right) {

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < q; i++) {
            String s = scanner.nextLine();

            System.out.println(palindromeIndex(s));
        }

        scanner.close();
    }
}

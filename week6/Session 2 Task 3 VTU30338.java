import java.util.Scanner;

public class Solution {

    public static String twoStrings(String s1, String s2) {

        boolean[] present = new boolean[26];

        // Store characters from s1
        for (int i = 0; i < s1.length(); i++) {
            present[s1.charAt(i) - 'a'] = true;
        }

        // Check if any character from s2 exists in s1
        for (int i = 0; i < s2.length(); i++) {
            if (present[s2.charAt(i) - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        sc.nextLine();

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < q; i++) {

            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            output.append(twoStrings(s1, s2)).append("\n");
        }

        System.out.print(output);

        sc.close();
    }
}

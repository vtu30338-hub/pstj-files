import java.io.*;
import java.util.*;

public class Solution {

    public static List<Integer> maxSubarray(List<Integer> arr) {

        // Maximum subarray sum (Kadane's Algorithm)
        int currentSum = arr.get(0);
        int maxSubarray = arr.get(0);

        // Maximum subsequence sum
        int maxSubsequence = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {

            int value = arr.get(i);

            // Maximum subarray
            currentSum = Math.max(value, currentSum + value);
            maxSubarray = Math.max(maxSubarray, currentSum);

            // Maximum subsequence
            if (value > 0) {
                maxSubsequence += value;
            }
        }

        // If all numbers are negative,
        // maximum subsequence is the largest single element
        boolean hasPositive = false;

        for (int value : arr) {
            if (value > 0) {
                hasPositive = true;
                break;
            }
        }

        if (!hasPositive) {
            maxSubsequence = Collections.max(arr);
        }

        return Arrays.asList(maxSubarray, maxSubsequence);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder output = new StringBuilder();

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());

            StringTokenizer st = new StringTokenizer(br.readLine());

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            List<Integer> result = maxSubarray(arr);

            output.append(result.get(0))
                  .append(" ")
                  .append(result.get(1))
                  .append("\n");
        }

        System.out.print(output);
    }
}

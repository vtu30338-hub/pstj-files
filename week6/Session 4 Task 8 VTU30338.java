class Solution {
    public int strStr(String haystack, String needle) {
        
        // Check every possible starting position
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            
            // Check if needle matches from index i
            int j = 0;
            
            while (j < needle.length() &&
                   haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            
            // If entire needle matched
            if (j == needle.length()) {
                return i;
            }
        }
        
        // Needle not found
        return -1;
    }
}

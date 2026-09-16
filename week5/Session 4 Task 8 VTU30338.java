import java.util.*;

class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {

            char w = word.charAt(i);
            char p = pattern.charAt(i);

            // Pattern character already mapped
            if (map1.containsKey(p)) {
                if (map1.get(p) != w) {
                    return false;
                }
            } else {
                // Word character already mapped to another pattern character
                if (map2.containsKey(w)) {
                    return false;
                }

                map1.put(p, w);
                map2.put(w, p);
            }
        }

        return true;
    }
}

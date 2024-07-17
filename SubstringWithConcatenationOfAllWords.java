import java.util.*;
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }

        int wordLength = words[0].length();
        int totalWordsLength = wordLength * words.length;
        int sLength = s.length();
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int count = 0;
            HashMap<String, Integer> seenWords = new HashMap<>();
            for (int j = i; j <= sLength - wordLength; j += wordLength) {
                String sub = s.substring(j, j + wordLength);
                
                if (wordCount.containsKey(sub)) {
                    seenWords.put(sub, seenWords.getOrDefault(sub, 0) + 1);
                    count++;
                    
                    while (seenWords.get(sub) > wordCount.get(sub)) {
                        String leftSub = s.substring(left, left + wordLength);
                        seenWords.put(leftSub, seenWords.get(leftSub) - 1);
                        left += wordLength;
                        count--;
                    }

                    if (count == words.length) {
                        res.add(left);
                        String leftSub = s.substring(left, left + wordLength);
                        seenWords.put(leftSub, seenWords.get(leftSub) - 1);
                        left += wordLength;
                        count--;
                    }
                } else {
                    seenWords.clear();
                    count = 0;
                    left = j + wordLength;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords solution = new SubstringWithConcatenationOfAllWords();
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(solution.findSubstring(s, words));  // Output: [0, 9]
    }
}

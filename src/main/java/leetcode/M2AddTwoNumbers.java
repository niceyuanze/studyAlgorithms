package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zeyuan.yyz on 2017/7/17.
 */
public class M2AddTwoNumbers {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * Examples:
     *      Given "abcabcbb", the answer is "abc", which the length is 3.
     *      Given "bbbbb", the answer is "b", with the length of 1.
     *
     *      Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
     *          "pwke" is a subsequence and not a substring.
     */

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> byteContainer = new HashMap<>();
        String longest = "";
        String tmp="";

        for(int i = 0; i < s.length();i++) {
            if (byteContainer.containsKey(s.charAt(i))) {
                int index = byteContainer.get(s.charAt(i));
                byteContainer.clear();
                if (tmp.length() > longest.length()) {
                    longest = tmp;
                }
                tmp="";
                i = index + 1;
                tmp=""+s.charAt(i);
                byteContainer.put(s.charAt(i), i);
            } else {
                byteContainer.put(s.charAt(i), i);
                tmp = tmp + String.valueOf(s.charAt(i));
            }
        }

        return tmp.length() > longest.length()?tmp.length():longest.length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }
}

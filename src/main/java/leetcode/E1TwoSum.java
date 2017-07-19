package leetcode;

import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by zeyuan.yyz on 2017/7/17.
 */
public class E1TwoSum {

    /**
     *
     *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     *  You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *  Example:
     *
     *
     *  Given nums = [2, 7, 11, 15], target = 9,
        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
     */

    public static int[] twoSum(int[] nums, int target) {
        //the first solution


        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if( nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;




        /**
         *
         *


         */
        // Approach #2 (Two-pass Hash Table)
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement) && map.get(complement) != i) {
//                return new int[] { i, map.get(complement) };
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");

        /**
         * Time complexity :O(n)
         * Space complexity : O(n)

         */



        //Approach #3
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement)) {
//                return new int[] { map.get(complement), i };
//            }
//            map.put(nums[i], i);
//        }
//        throw new IllegalArgumentException("No two sum solution");

        /**
         * Time complexity :O(n)
         * Space complexity : O(n)

         */


        // I didn't find  out how to solve this use stream
    }

    public static void main(String[] args) {

        int[] result = twoSum(new int[]{3,2,4},6);
        System.out.println(result[0] + "  "  + result[1]);
    }
}

package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kaijia Wei on 2017/4/7.
 */
public class SingleNumberTest {

    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     * Note:
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (null == nums || nums.length < 1){
            return 0;
        }
        Map<Integer,Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length;i++){
            Integer integer = count.get(nums[i]);
            if (integer == null){
                count.put(nums[i],1);
            }else{
                count.put(nums[i],integer++);
            }
        }
        for (Map.Entry<Integer,Integer> entry : count.entrySet()){
            if (entry.getValue()==1){
                return entry.getKey();
            }
        }
        return 0;
    }

    public int singleNumberFast(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }


    /**
     * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
     * Note:
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     */
    public int singleNumberII(int[] a){
        int ones = 0,twos = 0;
        for (int i = 0; i < a.length; i++) {
            ones = (ones^a[i])& ~twos;
            twos = (twos^a[i])& ~ones;
        }
        return ones;
    }

    public int[] singlenumberIII(int[] nums){
        //int diff
        return  null;
    }


    public static void main(String[] args) {
        int[] arr = {10,10,10,11,11,11,12,24,24,24,15,12,12};
        SingleNumberTest singleNumberTest = new SingleNumberTest();
        singleNumberTest.singleNumberII(arr);
    }
}

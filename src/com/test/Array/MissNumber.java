package com.test.Array;

import java.util.Arrays;

/**
 * Created by Kaijia Wei on 2017/4/20.
 */
public class MissNumber {

    /**
     * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
     * For example,
     * Given nums = [0, 1, 3] return 2.
     * Note:
     * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
     */

    public int myMissingNumber(int[] nums) {
        int total1 =0, total2 =0;
        int i;
        for(i = 0; i < nums.length; i++){
            total1 += i;
            total2 += nums[i];
        }
        total1 +=i;
        return total1 - total2;
    }

    public int missingNumberXOR(int[] nums) { //xor
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    public int missingNumberBinary(int[] nums) { //binary search
        Arrays.sort(nums);
        int left = 0, right = nums.length, mid= (left + right)/2;
        while(left<right){
            mid = (left + right)/2;
            if(nums[mid]>mid) right = mid;
            else left = mid+1;
        }
        return left;
    }

}

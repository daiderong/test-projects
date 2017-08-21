package com.mytest.leetcode;

import java.util.Arrays;

public class Solution {
	
	
	public static void main(String[] args) {
		int [] nums = {1,3,5,6,7,8,9,10,18,20,19};
		
		System.out.println(Arrays.toString(twoSum(nums, 29)));
	}
	
	
    public static int[] twoSum(int[] nums, final int target) {
    	int maxInd = nums.length-1;
    	int max = nums[maxInd];
    	int minInd = 0;
    	int min = nums[minInd];
    	while((min+max) != target ){
    		if( maxInd == minInd  ){
    			break;
    		}
           while((min+max)  < target &&  minInd < maxInd){
        	   minInd++;
        	   min = nums[minInd];
        	   continue;
           }
           while((min+max)  > target && maxInd>minInd){
        	   maxInd--;
        	   max = nums[maxInd];
        	   continue;
           }
    	}
    	if((min+max) == target){
        	return new int[]{minInd,maxInd};
    	}
    	
        return new int[]{0,0};
    }
}
package com.xu1an.leetcode.array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu1Aan
 * @Date: 2022/06/07/20:56
 * @Description:
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4,5,6,6,7,7,9};
        int target = 4;
        SearchRange searchRange = new SearchRange();
        int[] result = searchRange.searchRange(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }

     public int[] searchRange(int[] nums, int target){
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);

        if (leftBorder == -2 || rightBorder == -2) return new int[] {-1,-1};

        if (rightBorder - leftBorder > 1) return new int[]{leftBorder + 1,rightBorder -1};

        return new int[]{-1,-1};
    }

    private int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2;
        while(left <= right){
            int middle = left + ((right - left)>>1);
            if (nums[middle] > target){
                right = middle -1;
            } else {
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    private int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2;
        while(left <= right){
            int middle = left + ((right - left)>>1);
            if (nums[middle] >= target){
                right = middle -1;
                leftBorder = right;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }
}

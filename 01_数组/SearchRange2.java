package com.xu1an.leetcode.array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu1Aan
 * @Date: 2022/06/08/11:10
 * @Description:
 */
public class SearchRange2 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4,5,6,6,7,7,9};
        int target = 2;
        SearchRange2 searchRange = new SearchRange2();
        int[] result = searchRange.searchRange(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] searchRange(int[] nums, int target){
        int index = binarySearch(nums, target);

        if (index == -1) return  new int[]{-1,-1};

        int left = index;
        int right = index;

        while(left - 1 >= 0 && nums[left] == nums[left - 1]) left--;
        while(right + 1 < nums.length && nums[right] == nums[right + 1]) right++;
        return new int[]{left, right};
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int middle = left + ((right - left) / 2);
            if (nums[middle] > target){
                right = middle - 1;
            } else if (nums[middle] < target){
                left = middle + 1;
            } else return middle;
        }
        return -1;
    }
}

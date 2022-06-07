package com.xu1an.leetcode.array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu1Aan
 * @Date: 2022/06/07/19:14
 * @Description:
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6,8,9,10,14,16,17,18,19};
        int target = 4;
        SearchInsert searchInsert = new SearchInsert();
        int result = searchInsert.searchInsert(nums,target);
        System.out.println(result);
        System.out.println("=======");
        int result2 = searchInsert.searchInsert2(nums,target);
        System.out.println(result2);
    }

    public int searchInsert(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int middle = left + ((right - left)>>1);
            if (nums[middle] > target) {
                right = middle - 1;
            }
            else if (nums[middle] < target) {
                left = middle + 1;
            }
            else return middle;

        }
         return right + 1;
    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left < right){
            int middle = left + ((right - left)>>2);
            if (nums[middle] > target){
                right = middle;
            } else if (nums[middle] < target){
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return left;
    }
}

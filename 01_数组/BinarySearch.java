package com.xu1an.leetcode.array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Xu1Aan
 * @Date: 2022/06/07/18:27
 * @Description:
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] Array = {1,3,5,6,8,9,10,13,15,17,18,20};
        int target = 11;
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.binarySearch(Array, target);
        System.out.println(result);
        System.out.println("==============");
        int result2 = binarySearch.binarySearch2(Array, target);
        System.out.println(result2);
    }

    /**
     * 二分查找（左闭右闭区间）
     * @param Array 有序无重复的数组Array
     * @param target 目标元素target
     * @return 返回目标元素的下表，没有则返回-1
     */
    public int binarySearch(int[] Array, int target){
        int left = 0;
        int right = Array.length - 1;
        while(left <= right){
            int middle = left + ((right - left) / 2);
            if (Array[middle]==target) {
                return middle;
            } else if (Array[middle] > target){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    /**
     *
     * 二分查找（左闭右开区间）
     * @param Array 有序无重复的数组Array
     * @param target 目标元素target
     * @return 返回目标元素的下表，没有则返回-1
     */
    public int binarySearch2(int[] Array, int target){
        int left = 0;
        int right = Array.length;
        while(left < right){
            int middle = left + ((right - left)>>1);
            if (Array[middle] == target) return middle;
            else if (Array[middle] > target) right = middle;
            else left = middle + 1;
        }
        return -1;
    }
}

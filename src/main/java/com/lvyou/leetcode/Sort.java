package com.lvyou.leetcode;

import java.util.Arrays;

/**
 * @Author: VernLv
 * @Data: Create in 10:20 2019/8/12
 */
public class Sort {

    /**
     * 归并排序
     * */
    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int []a,int left,int mid,int right){
        int []tmp = new int[a.length];
        int p1 = left, p2 = mid + 1, k = left;

        while(p1 <= mid && p2 <= right){
            if(a[p1] <= a[p2]) {
                tmp[k++] = a[p1++];
            }

            else {
                tmp[k++] = a[p2++];
            }
        }
        while(p1 <= mid) {
            tmp[k++] = a[p1++];
        }
        while(p2 <= right){
            tmp[k++] = a[p2++];
        }
        for (int i = left; i <= right; i++) {
            a[i] = tmp[i];
        }
    }

    /**
     * 快速排序
     * */
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right){
            return;
        }
        int mid = partition(nums, left, right);
        quickSort(nums, left, mid-1);
        quickSort(nums,mid + 1, right);
    }
    public static int partition(int[] nums, int left , int right) {     // 分区操作
        int pivot = left, index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, index - 1);
        return index-1;
    }
    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /**
     * 堆排序
     * */

    //调整堆
    public static void heapify(int[] nums, int i, int end) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left <= end && nums[left] > nums[largest]){
            largest = left;
        }
        if (right <= end && nums[right] > nums[largest]){
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, largest,end);
        }
    }
    public static void buildHeap(int[] nums) {
        for (int i = nums.length/2; i >= 0; i--) {
            heapify(nums, i, nums.length - 1);
        }
    }
    public static void heapSort(int[] nums){
        buildHeap(nums);
        int end = nums.length - 1;
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0,end);
            end--;
        }
    }

    /**
     * 冒泡排序
     * */
    public static void bubbleSort(int[] nums){
        for (int i = 0;i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++ ){
                if (nums[i] > nums[j]){
                    swap(nums,i,j);
                }
            }
        }
    }
    /**
     * 选择排序
     * */
    public static void selectSort(int[] nums){
        for (int i = 0; i < nums.length; i++){
            int key = i;
            for (int j = i; j < nums.length; j++){
                if (nums[j] < nums[key]){
                    key = j;
                }
            }
            swap(nums,i,key);
        }
    }
    /**
     * 插入排序
     * */
    public static void insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++){
            int current = nums[i];
            int index = i;
            for (int j = i-1;j >= 0; j--){
                if (nums[j] > current){
                    nums[j+1] = nums[j];
                    index = j;
                }else {
                    break;
                }
            }
            nums[index] = current;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,2,5,3,6,7,6,8,2,3,4,2,5,};

        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}

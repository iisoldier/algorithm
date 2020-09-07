package com.isoldier.array;

/**
 * @Desc https://leetcode.com/problems/next-permutation/
 *
 * @author jinmeng on 2020/3/20.
 * @version 1.0
 */
public class NextPermutation {

    public int[] nextPermutation(int[] nums) {


        int len = nums.length;
        int front = 0, back =0;
        for(int i = len -1;i > 0;i--){
            if(nums[i-1] < nums[i]){
                front = i-1;
                break;
            }
        }
        if(front == 0){
            reverse(nums,front,len-1);
            return nums;
        }
        for(int i = front;i<len;i++){
            if(nums[i+1] <nums[front]){
                back = i;
                break;
            }
        }
        change(nums,front,back);
        reverse(nums,front+1,len-1);
        return nums;
    }


    public void change(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int head ,int tail){

        while (head < tail){
            change(nums,head,tail);
            head++;
            tail--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {7,3,2};
        NextPermutation  nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        System.out.println(nums);
    }

}

package com.isoldier.array;

/**
 * @author jinmeng on 2020/3/22.
 * @version 1.0
 */
public class JumpGame {


    public static  boolean success = false;

    public boolean jumpToEnd(int[] nums){
        jumpToEnd(nums,0);
        return success;
    }

    public void jumpToEnd(int[] nums,int index){

        if(index >= nums.length){
            return;
        }
        if(index == nums.length - 1){
            success = true;
        }else {

            for(int i = 1 ;i <= nums[index]; i++){
                jumpToEnd(nums,index+i);
            }

        }
    }


    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.jumpToEnd(nums));

    }
}

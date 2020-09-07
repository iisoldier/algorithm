package com.isoldier.tree;

import com.isoldier.common.TreeNode;

/**
 * 将有序数组转换成二叉搜索数
 * @author jinmeng on 2020/3/28.
 * @version 1.0
 */
public class SortedArrayToBST {


    public TreeNode sortedArrayToBST(int[] nums){

        if(nums == null || nums.length == 0){
            return null;
        }
        int start= 0;
        int end = nums.length -1;
        return sortedArrayToBST(nums,start,end);

    }

    public TreeNode sortedArrayToBST(int[] nums,int start,int end) {


        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);

        // 如果只有一个元素
        if(start == end){
            return root;
        }
        // 如果有两个元素
        if(start == mid){
            root.left = null;
        }else {
            root.left = sortedArrayToBST(nums,start,mid -1);
        }
        root.right = sortedArrayToBST(nums,mid+1,end);

        return root;
    }

    public static void main(String[] args) {

        int[] arrays ={1,2,3,4,5,6,7};
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode root = sortedArrayToBST.sortedArrayToBST(arrays);
        System.out.println(root);
    }


}

package com.isoldier.tree;

import com.isoldier.common.TreeNode;

/**
 * @author jinmeng on 2020/3/26.
 * @version 1.0
 */
public class BinarySearchTree {

    public boolean isValid(TreeNode root){

        if(root == null){
            return true;
        }
        if(isValid(root.left) && isValid(root.right)){
            if(root.left != null && max(root.left) >= root.val){
                return false;
            }
            if(root.right != null && min(root.right) <= root.val){
                return false;
            }
        }
        return false;
    }

    public int max(TreeNode root){
        int max = 0;
        while (root != null){
            max = root.val;
            root = root.right;
        }
        return max;
    }

    public int min(TreeNode root){
        int min = 0;
        while (root != null){
            min = root.val;
            root = root.left;
        }
        return min;
    }
}

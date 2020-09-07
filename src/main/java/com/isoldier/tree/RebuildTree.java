package com.isoldier.tree;

import com.isoldier.common.TreeNode;

import java.util.Arrays;

/**
 * 根据前序和中序遍历 重构二叉树
 * @author jinmeng on 2020/3/26.
 * @version 1.0
 */
public class RebuildTree {


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0|| inorder.length != inorder.length){
            return null;
        }
        int len = preorder.length;

        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for(int i = 0;i<len;i++){
            if(inorder[i] == preorder[0]){
                index = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder,1,index+1)
                ,Arrays.copyOfRange(inorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(preorder,index+1,len)
                ,Arrays.copyOfRange(inorder,index+1,len));

        return root;

    }



    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = new RebuildTree().buildTree(preorder,inorder);
        System.out.println(root);
    }

}

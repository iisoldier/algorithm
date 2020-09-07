package com.isoldier.tree;

import com.isoldier.common.TreeNode;

/** 删除二叉搜索树中的节点
 * @author jinmeng on 2020/3/28.
 * @version 1.0
 */
public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null){
            return root;


        }
        if(root.val > key){
            root.left=deleteNode(root.left,key);
        }else if(root.val < key){
            root.right=deleteNode(root.right, key);
        }else {

            if(root.left == null && root.right == null){
                root = null;

            }else if(root.right != null){
                root.val = findMin(root.right);
                root.right = deleteNode(root.right,root.val);
            }else{
                root.val = findMax(root.left);
                root.left = deleteNode(root.left,root.val);
            }
        }

        return root;
    }


    public int findMin(TreeNode root) {

        int val = 0;
        while (root!= null){
            val = root.val;
            root = root.left;
        }
        return val;
    }


    public int findMax(TreeNode root) {

        int val = 0;
        while (root!= null){
            val = root.val;
            root = root.right;
        }
        return val;
    }

    public static void main(String[] args) {

        TreeNode root =new TreeNode(1);

        root.right = new TreeNode(2);


        DeleteNode deleteNode = new DeleteNode();
        TreeNode res = deleteNode.deleteNode(root,2);
        System.out.println(res);


    }
}


package com.isoldier.tree;

import com.isoldier.common.TreeNode;

/**
 * 计算完全二叉树的节点个数
 * @author jinmeng on 2020/3/30.
 * @version 1.0
 */
public class CountNodes {


    /**
     * 常规解法  不管是不是完全二叉树都使用
     * @param root
     * @return
     */
    public int countNodesCommon(TreeNode root) {
        int count = 0;
        if(root!=null){
            count++;
            count+=countNodes(root.left);
            count+=countNodes(root.right);
        }
        return count;
    }


    /**
     * 利用完全二叉树的特点进行优化的解法
     * 核心思想是二分法
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {

        if(root == null){
            return 0;
        }
        int left = calLevel(root.left);
        int right = calLevel(root.right);

        if(left == right){
            return countNodes(root.right) +  (1<<left) ;
        }else {
            return countNodes(root.left) + (1<<(left-1));
        }

    }


    /**
     * 计算完全二叉树的层数
     * @param root
     * @return
     */
    public int calLevel(TreeNode root) {

        int level = 0;
        while (root != null){
            level++;
            root = root.left;
        }
        return level;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        root.right.left = new TreeNode(6);


        CountNodes countNodes = new CountNodes();
        int res = countNodes.countNodes(root);
        System.out.println(res);
    }
}

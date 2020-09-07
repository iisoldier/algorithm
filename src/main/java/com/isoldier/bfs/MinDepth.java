package com.isoldier.bfs;

import com.isoldier.common.TreeNode;

import java.util.LinkedList;

/**
 * @author jinmeng on 2020/4/2.
 * @version 1.0
 */
public class MinDepth {


    public static int minDepth = Integer.MAX_VALUE;
    /**
     * 采用递归的方式 最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root){

        minDepth = Integer.MAX_VALUE;
        if(root == null){
            return 0;
        }
        minDepth(root,1);
        return minDepth;
    }



    public void minDepth(TreeNode root,int len){

        if(root.left == null && root.right == null){
            if(len < minDepth){
                minDepth = len;
            }
            return;
        }
        if(root.left != null){
            minDepth(root.left,len+1);
        }
        if(root.right != null){
            minDepth(root.right,len+1);
        }

    }


    /**
     * 采用非递归的方式
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root){

        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> upLayer = new LinkedList<>();
        LinkedList<TreeNode> downLayer = new LinkedList<>();
        upLayer.add(root);
        int depth = 0;

        boolean stop = false;
        while (!stop){
            depth++;
            while (!upLayer.isEmpty()){

                TreeNode node = upLayer.removeFirst();
                if(node.left == null && node.right == null){
                    stop = true;
                }
                if(node.left!= null){
                    downLayer.addLast(node.left);
                }
                if(node.right!= null){
                    downLayer.addLast(node.right);
                }
            }
            upLayer = downLayer;
            downLayer = new LinkedList<>();

        }
        return depth;
    }


}

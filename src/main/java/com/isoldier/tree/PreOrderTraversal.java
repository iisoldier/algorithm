package com.isoldier.tree;

import com.isoldier.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * @author jinmeng on 2020/3/25.
 * @version 1.0
 */
public class PreOrderTraversal {



    public static List<Integer> res = new ArrayList<>();
    /**
     * 递归算法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        if(root != null){
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return res;
    }


    /**
     * 非递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if(root == null){
            return res;
        }
        linkedList.addLast(root);
        while (!linkedList.isEmpty()){

            TreeNode node = linkedList.pollLast();
            res.add(node.val);
            if(node.right!= null){
                linkedList.add(root.right);
            }
            if(node.left!= null){
                linkedList.add(root.left);
            }
        }
        return res;

    }

}

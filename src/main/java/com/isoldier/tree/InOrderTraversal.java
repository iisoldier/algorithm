package com.isoldier.tree;

import com.isoldier.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 * @author jinmeng on 2020/3/25.
 * @version 1.0
 */
public class InOrderTraversal {

    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;


    }

    public void inorder(TreeNode root,List<Integer> res) {

        if(root!=null){
            inorder(root.left,res);
            res.add(root.val);
            inorder(root.right,res);
        }
    }


    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {


        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        stack.push(root);

        while (!stack.isEmpty()){

            TreeNode node = stack.pop();
            res.addFirst(node.val);
            if(node.left!= null){
                stack.push(node.left);
            }

            if(node.right!= null){
                stack.push(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        TreeNode root =new TreeNode(2);
        root.left  =new TreeNode(1);
        root.right = new TreeNode(3);
        InOrderTraversal in  =  new InOrderTraversal();
        in.inorderTraversal2(root);

    }
}

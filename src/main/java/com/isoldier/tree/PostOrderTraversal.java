package com.isoldier.tree;

import com.isoldier.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jinmeng on 2020/3/26.
 * @version 1.0
 */
public class PostOrderTraversal {

    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        post(root,res);
        return res;
    }

    public void post(TreeNode root,List<Integer> res) {
            if(root!= null){
                post(root.left,res);
                post(root.right,res);
                res.add(root.val);
            }

    }


    /**
     * 迭代解法
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        stack.push(root);

        while (!stack.isEmpty()){

            TreeNode cur =stack.peek();
            while (cur!=null && cur.left!=null){
                stack.push(cur.left);
                cur = cur.left;
            }

            TreeNode node = stack.peek();
            if(node.right == null){
                stack.pop();
                res.add(node.val);
                if(!stack.isEmpty()){
                    stack.peek().left =null;
                }
            }else {
                stack.push(node.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        TreeNode root =new TreeNode(2);
        root.left  =new TreeNode(1);
        root.right = new TreeNode(3);
        PostOrderTraversal postOrderTraversal  =  new PostOrderTraversal();
        postOrderTraversal.postorderTraversal2(root);

    }
}

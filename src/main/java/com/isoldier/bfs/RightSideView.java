package com.isoldier.bfs;


import java.util.ArrayList;
import java.util.List;

/**
 * Author: jinmeng
 * Date: 2017-05-01
 * Time: 23:21
 */
public class RightSideView{


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root,result,0);
        return result;

    }
    public void rightView(TreeNode root,List<Integer> result,int depth){
        if(root == null) return;
        if(depth == result.size()){
            result.add(root.val);
        }

        rightView(root.right,result,depth+1);
        rightView(root.left,result,depth+1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
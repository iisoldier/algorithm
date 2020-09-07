package com.isoldier.bfs;


import com.isoldier.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的右侧视图，解题思想是用了二叉树的深度和数组的大小来来判断
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
        if(root == null){
            return;
        }
        if(depth == result.size()){
            result.add(root.val);
        }

        rightView(root.right,result,depth+1);
        rightView(root.left,result,depth+1);
    }
}


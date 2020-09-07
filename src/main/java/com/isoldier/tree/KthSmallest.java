package com.isoldier.tree;

import com.isoldier.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jinmeng on 2020/3/29.
 * @version 1.0
 */
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {

        List<Integer> res = new ArrayList<>();
        preTraversal(root,res);
        return res.get(k-1);
    }


    public void preTraversal(TreeNode root, List<Integer> res){

        if(root !=null){
            preTraversal(root.left,res);
            res.add(root.val);
            preTraversal(root.right,res);
        }
    }


    public static void main(String[] args) {

    }
}

package com.isoldier.tree;

import com.isoldier.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个树是否是合法的二叉搜索树
 * @author jinmeng on 2020/3/29.
 * @version 1.0
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        for(int i = 0;i<list.size()-1;i++){
            if(list.get(i)>=list.get(i+1)){
                return false;
            }

        }
        return true;
    }

    public void inorder(TreeNode root,List<Integer> res){

        if(root !=null){
            inorder(root.left,res);
            res.add(root.val);
            inorder(root.right,res);
        }
    }




}

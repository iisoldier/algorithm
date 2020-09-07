package com.isoldier.tree;

import com.isoldier.common.TreeNode;

/**
 * @author jinmeng on 2020/3/29.
 * @version 1.0
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {


        if(root == null){
            return new TreeNode(val);
        }
        if(val>root.val){
            root.right = insertIntoBST(root.right,val);
        }else {
            root.left =insertIntoBST(root.left,val);
        }
        return root;
    }
}

package com.isoldier.tree;

import com.isoldier.common.TreeNode;

import java.util.LinkedList;

/**
 * @author jinmeng on 2020/3/28.
 * @version 1.0
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        LinkedList<TreeNode> pPath = new LinkedList<>();
        LinkedList<TreeNode> qPath = new LinkedList<>();

        LinkedList<TreeNode> temp = new LinkedList<>();
        temp.add(root);
        path(p,temp,pPath);

        temp =  new LinkedList<>();
        temp.add(root);
        path(q,temp,qPath);

        TreeNode ancestor = null;
        while (!pPath.isEmpty() && qPath.isEmpty()){
            TreeNode pNode = pPath.removeFirst();
            TreeNode qNode = qPath.removeFirst();
            if(pNode.val == qNode.val){
                ancestor = pNode;
            }else {
                break;
            }
        }
        return ancestor;


    }

    public void path(TreeNode dest,LinkedList<TreeNode> res,LinkedList<TreeNode> pathNode){

        if(!pathNode.isEmpty()){
            return;
        }
        TreeNode node =  res.getLast();
        if(node.val == dest.val){
            pathNode.addAll(res);
            return;
        }
        if(node.left !=null){
            res.addLast(node.left);
            path(dest,res,pathNode);
            res.removeLast();
        }
        if(node.right !=null){
            res.addLast(node.right);
            path(dest,res,pathNode);
            res.removeLast();
        }

    }
}

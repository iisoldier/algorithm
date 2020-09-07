package com.isoldier.tree;

import com.isoldier.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树层序遍历
 * @author jinmeng on 2020/3/28.
 * @version 1.0
 */
public class LayerTraversal {


    public List<Integer> layerTraversal(TreeNode root){

        List<Integer> res = new ArrayList<>();

        LinkedList<TreeNode> list = new LinkedList<>();

        if(root == null){
            return res;
        }
        list.addLast(root);
        while (!list.isEmpty()){
            TreeNode node = list.removeFirst();
            res.add(node.val);
            if(node.left != null){
                list.addLast(node.left);
            }
            if(node.right != null){
                list.addLast(node.right);
            }
        }
        return res;
    }

}

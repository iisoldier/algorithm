package com.isoldier.tree;

import com.isoldier.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将二叉搜索树转换成平衡
 * @author jinmeng on 2020/3/29.
 * @version 1.0
 */
public class BalanceBST {

    public TreeNode balanceBST(TreeNode root) {

        List<Integer> res =  new ArrayList<>();
        inorder(root,res);

        return buildTree(res,0,res.size()-1);
    }




    public void inorder(TreeNode root,List<Integer> res){

        if(root !=null){
            inorder(root.left,res);
            res.add(root.val);
            inorder(root.right,res);
        }
    }


    public TreeNode buildTree(List<Integer> res,int start,int end){

        if(start > end){
            return null;
        }
        if(start==end){
            return new TreeNode(res.get(start));
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(res.get(mid));
        if(start == mid){
            root.left = null;
        }else{
            root.left = buildTree(res,start,mid-1);
        }
        root.right = buildTree(res,mid+1,end);

        return root;
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,7,9,11,14,15,17);
        BalanceBST balanceBST = new BalanceBST();
        TreeNode root = balanceBST.buildTree(list,0,8);
        System.out.println(root);



    }




}

package com.jelly.collect;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTreeTest {
    public static class TreeNode {
        public TreeNode leftChild;
        public TreeNode rightChild;
        private Integer data;
        public TreeNode(){}
        public TreeNode(Integer data){
            this.data=data;
        }
    }
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        TreeNode treeNode=createBinaryTree(inputList);
       /* System.out.println("前序遍历:");
        preOrderTraveral(treeNode);
        preOrderTraveralWithStack(treeNode);
        System.out.println("中序遍历:");
        inOrderTraveral(treeNode);
        System.out.println("=========================");
        inOrderTraveralWithStack(treeNode);
        System.out.println("后序遍历:");
        postOrderTraveral(treeNode);
        System.out.println("=========================");
        postOrderTraveralWithStack(treeNode);*/
        levelOrderTraveral(treeNode);

    }
    public  static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode tn=null;
        if(inputList==null || inputList.isEmpty()){
            return  null;
        }
        Integer data=inputList.removeFirst();
        if(data!=null){
            tn=new TreeNode(data);
            tn.leftChild=createBinaryTree(inputList);
            tn.rightChild=createBinaryTree(inputList);
        }
        return  tn;
    }

    /**
     * 二叉树前序遍历
     * @param node
     */
    public static  void preOrderTraveral(TreeNode node){
        if(node==null){
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树中序遍历
     * @param node
     */
    public static  void inOrderTraveral(TreeNode node){
        if(node==null){
            return;
        }

        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树中序遍历
     * @param node
     */
    public static  void postOrderTraveral(TreeNode node){
        if(node==null){
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);

    }

    /**
     * 利用stack 非递归
     */
    public  static void preOrderTraveralWithStack(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode treeNode=root;
        while (treeNode!=null || !stack.isEmpty()){
            while (treeNode!=null){
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode=treeNode.leftChild;
            }
            if(!stack.isEmpty()){
                treeNode=stack.pop();
                treeNode=treeNode.rightChild;
            }
        }
    }
    /**
     * 利用stack 非递归
     */
    public  static void inOrderTraveralWithStack(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode treeNode=root;
        while (treeNode!=null || !stack.isEmpty()){
            while (treeNode!=null){
                stack.push(treeNode);
                treeNode=treeNode.leftChild;
            }

            if(!stack.isEmpty()){
                treeNode=stack.pop();
                System.out.println(treeNode.data);
                treeNode=treeNode.rightChild;
            }

        }
    }

    public  static void postOrderTraveralWithStack(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        TreeNode treeNode=root;
        TreeNode lastNode=root;
        while (treeNode!=null || !stack.isEmpty()){
            while (treeNode!=null){
                stack.push(treeNode);
                treeNode=treeNode.leftChild;
            }

            if(!stack.isEmpty()){
                treeNode=stack.peek();
                if(treeNode.rightChild==null || treeNode.rightChild==lastNode){
                    System.out.println(treeNode.data);
                    treeNode=stack.pop();
                    lastNode=treeNode;
                    treeNode=null;
                }else {
                    treeNode = treeNode.rightChild;
                }
            }
        }
    }

    public  static void levelOrderTraveral(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode treeNode=queue.poll();
            System.out.println(treeNode.data);
            if(treeNode.leftChild!=null){
                queue.offer(treeNode.leftChild);
            }
            if(treeNode.rightChild!=null){
                queue.offer(treeNode.rightChild);
            }
        }
    }
}

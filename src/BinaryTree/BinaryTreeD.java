package BinaryTree;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Zephery on 2016/7/19.
 */
public class BinaryTreeD {
    private static List<Node> nodeList = null;
    private Node root;

    private class Node {
        Node leftChild;
        Node rightChild;
        int data;

        public Node(int newData) {
            this.leftChild = null;
            this.rightChild = null;
            this.data = newData;
        }

        public Node getLeftChild() {
            return this.leftChild;
        }

        public Node getRightChild() {
            return this.rightChild;
        }

        public int getData() {
            return this.data;
        }
    }


    public void buildTree(Node node, int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            if (data < node.data) {
                if (node.leftChild == null) {
                    node.leftChild = new Node(data);
                } else {
                    buildTree(node.leftChild, data);
                }
            } else {
                if (node.rightChild == null) {
                    node.rightChild = new Node(data);
                } else {
                    buildTree(node.rightChild, data);
                }
            }
        }
    }

    public static void preOrderTraverse(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while (node != null || stack.size() > 0) {  //将所有左孩子压栈
            if (node != null) {   //压栈之前先访问
                System.out.print(node.getData() + " ");
                stack.push(node);
                node = node.getLeftChild();
            } else {
                node = stack.pop();
                node = node.getRightChild();
            }
        }
    }

    public static void inOrderTraverse(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);   //直接压栈
                node = node.getLeftChild();
            } else {
                node = stack.pop(); //出栈并访问
                System.out.print(node.getData() + " ");
                node = node.getRightChild();
            }
        }
    }

    public static void postOrderTraverse(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> output = new Stack<Node>();//构造一个中间栈来存储逆后序遍历的结果
        Node node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.getRightChild();
            } else {
                node = stack.pop();
                node = node.getLeftChild();

            }
        }
        while (output.size() > 0) {
            System.out.print(output.pop().getData() + " ");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串整数并在输入时用英文逗号隔开：");
        String inputString = sc.nextLine();
        String stringArray[] = inputString.split(",");
        int num[] = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            num[i] = Integer.parseInt(stringArray[i]);
        }
        BinaryTreeD binaryTree = new BinaryTreeD();
        for (int i = 0; i < stringArray.length; i++) {
            binaryTree.buildTree(binaryTree.root, num[i]);
        }
        System.out.println("前序遍历");
        preOrderTraverse(binaryTree.root);
        System.out.println("\n中序遍历");
        inOrderTraverse(binaryTree.root);
        System.out.println("\n后序遍历");
        postOrderTraverse(binaryTree.root);
    }
}


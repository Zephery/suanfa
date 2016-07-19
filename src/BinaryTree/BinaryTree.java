package BinaryTree;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Zephery on 2016/7/18.
 */
public class BinaryTree {
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
    }


    public void createTree(Node node, int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            if (data < node.data) {
                if (node.leftChild == null) {
                    node.leftChild = new Node(data);
                } else {
                    createTree(node.leftChild, data);
                }
            } else {
                if (node.rightChild == null) {
                    node.rightChild = new Node(data);
                } else {
                    createTree(node.rightChild, data);
                }
            }
        }
    }

    public static void preOrderTraverse(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    public static void inOrderTraverse(Node node) {
        if (node == null)
            return;
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    public static void postOrderTraverse(Node node) {
        if (node == null)
            return;
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
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
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0; i < stringArray.length; i++) {
            binaryTree.createTree(binaryTree.root, num[i]);
        }
        System.out.println("先序遍历");
        inOrderTraverse(binaryTree.root);
        System.out.println("\n中序遍历");
        preOrderTraverse(binaryTree.root);
        System.out.println("\n后序遍历");
        postOrderTraverse(binaryTree.root);

    }
}

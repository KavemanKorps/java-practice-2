package bstFinal.src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// class for creating nodes
// WHAT DETERMINES IF STRING NODE GETS ADDED TO LEFT OR RIGHT??? their alphabetical order
// made possible with compareTo(); on line 30

class Node {
  Node left;
  Node right;
  String data; // Changed data type to String for handling words
}

// class BST contains two methods: insert() (add new value to tree) and createNewNode();
// which creates a new node, sets its data, and returns it.
class BST {
  
  // this method returns a NODE and accepts a node and String as arguments:
  public Node insert(Node node, String val) {
    // if no node is given, create a new one with the given value. createNewNode ONLY ever used here.
    // this is the base case. Once it's run, recursion stops.
    if (node == null) {
      return createNewNode(val);
    }
    
    // compare the string values for insertion
    int compareResult = val.compareTo(node.data);
    
    // if the value is less than the current node (its data), insert a new node as the current node's left child
    if (compareResult < 0) {
      // node.left.insert(node.left, val);
      node.left = insert(node.left, val);
    // else, insert it as the right child
    } else if (compareResult > 0) {
      node.right = insert(node.right, val);
    }
    
    return node;
  }
  
  // creates "Node" objects:
  public Node createNewNode(String data) {
    Node a = new Node();
    a.data = data;
    a.left = null;
    a.right = null;
    return a;
  }
  
  // Method to empty the tree
  public Node emptyTree(Node node) {
    // return;
    return null;
  }

  // Method to count the number of elements in the tree
  public int countElems(Node node) {
    if (node == null) return 0;
  
    return 1 + countElems(node.left) + countElems(node.right);
  }

  // Method to calculate the height of the tree
  public int getHeight(Node node) {
    if (node == null) return 0;

    // RECURSION USED, every time new node encountered, +1 added.
    int lHeight = getHeight(node.left);
    int rHeight = getHeight(node.right);

    // Return the height of the subtree rooted at this node
    return 1 + Math.max(lHeight, rHeight);
  }

  // MUST USE "LEVEL ORDER TRAVERSAL" to make "levelPrint" happen
  public void levelPrint(Node root) {
    if (root == null) return;

    // a queue full of Node objects:
    Queue<Node> nodes = new LinkedList<>();
    nodes.add(root);

    while (!nodes.isEmpty()) {
      int levelSize = nodes.size(); // gets relative size (htms :) )

      for (int i = 0; i < levelSize; i++) {
        // Node current = nodes.shift();
        // poll gets first elem in queue:
        Node current = nodes.poll();
        System.out.print(current.data + " ");

        // if current node has left/right nodes, add em to queue.
        if (current.left != null) nodes.add(current.left);
        if (current.right != null) nodes.add(current.right);
        
      }
      System.out.println(); // newline after every level
    }
  }
}

// OUTPUT CASE HANDLING AND LOOP:
public class BSTApp2 {
  public static void main(String[] args) {
    BST a = new BST();
    Node root = null;
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print("Enter command or value: ");
      String input = scanner.nextLine();

      if (input.isEmpty()) break;
      
      if (input.equals("emptyTest")) root = a.emptyTree(root);

      // else if (input.equals("emptyTest")) root = a.emptyTree(root);

      else if (input.equals("count")) System.out.println("The tree contains " + a.countElems(root) + " elements.");
      
      else if (input.equals("height")) System.out.println("The height of the tree is: " + a.getHeight(root));

      else if (input.equals("levelPrint")) a.levelPrint(root);

      else if (input.startsWith("insert ")) root = a.insert(root, input.substring(7)); // "insert" removed from string
    }
    scanner.close();
  }
}
package bstFinal.src;

// WHERE IS RECURSION USED HERE?

// class for creating nodes
class Node {
  Node left;
  Node right;
  int data;
}

class BST {
  
  // this METHOD returns a node and accepts a node and int as arguments:
  public Node insert(Node node, int val) {
    if(node == null) {
      return createNewNode(val);
    }
    
    // if value is less than current node (its data), insert new node as current node's left child
    if(val < node.data) {
      node.left = insert(node.left, val);
    // else, insert it as right child
    } else if((val > node.data)) {
      node.right = insert(node.right, val);
    }
    
    return node;
  }
  
  public Node createNewNode(int k) {
    Node a = new Node();
    a.data = k;
    a.left = null;
    a.right = null;
    return a;
  }
}

public class BSTApp {

  public static void main(String[] args) {
    BST a = new BST();
    Node root = null;
    
    root = a.insert(root, 8);
    root = a.insert(root, 3);
    root = a.insert(root, 6);
    root = a.insert(root, 10);
    root = a.insert(root, 4);
    root = a.insert(root, 7);
    root = a.insert(root, 1);
    root = a.insert(root, 14);
    root = a.insert(root, 13);
    
  }

}
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// class for creating nodes
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
      node.left = insert(node.left, val);
    // else, insert it as the right child
    } else if (compareResult > 0) {
      node.right = insert(node.right, val);
    }
    
    return node;
  }
  
  // creates "Node" objects:
  public Node createNewNode(String k) {
    Node a = new Node();
    a.data = k;
    a.left = null;
    a.right = null;
    return a;
  }
  
  // Method to empty the tree
  public Node emptyTree(Node node) {
    // Setting the root to null effectively empties the tree
    return null;
  }

  // Method to count the number of elements in the tree
  public int countElements(Node node) {
    if (node == null) {
      return 0;
    }
    return 1 + countElements(node.left) + countElements(node.right);
  }

  // Method to calculate the height of the tree
  public int calculateHeight(Node node) {
    if (node == null) {
      return 0;
    }

    int leftHeight = calculateHeight(node.left);
    int rightHeight = calculateHeight(node.right);

    // Return the height of the subtree rooted at this node
    return 1 + Math.max(leftHeight, rightHeight);
  }

  // Method to perform level order traversal and print each level
  public void levelPrint(Node root) {
    if (root == null) {
      return;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();

      System.out.print("Level " + (queue.size() - 1) + ": ");
      for (int i = 0; i < levelSize; i++) {
        Node current = queue.poll();
        System.out.print(current.data + " ");

        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }
      System.out.println();
    }
  }
}

public class BSTApp2 {
  public static void main(String[] args) {
    BST a = new BST();
    Node root = null;
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter values to insert into the BST, 'emptyTest' to empty the tree, 'count' to display the number of elements, 'height' to display the height, 'levelPrint' to print levels, or press Enter to exit.");

    while (true) {
      System.out.print("Enter command or value: ");
      String input = scanner.nextLine();

      if (input.isEmpty()) break;
      
      if (input.equals("emptyTest")) root = a.emptyTree(root);

      else if (input.equals("count")) System.out.println("The tree contains " + a.countElements(root) + " elements.");
      
      else if (input.equals("height")) System.out.println("The height of the tree is: " + a.calculateHeight(root));

      else if (input.equals("levelPrint")) a.levelPrint(root);

      else if (input.startsWith("insert ")) root = a.insert(root, input.substring(7)); // "insert" removed from string
    }
    scanner.close();
  }
}

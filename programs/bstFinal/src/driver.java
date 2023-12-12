
public class driver {
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
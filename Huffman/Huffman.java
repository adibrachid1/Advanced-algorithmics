import java.util.Comparator;
import java.util.PriorityQueue;

public class Huffman {
  static int n;
  static int i;
  static PriorityQueue<Node> queue = new PriorityQueue<Node>(20, new Comparator<Node>() {
    public int compare(Node i, Node j) {

      if (i.frequency < j.frequency) {
        return -1;
      } else if ((i.frequency > j.frequency)) {
        return 1;
      } else {
        if(i.step<j.step){
          return-1;
        }
        else if(i.step>j.step){
          return 1;
        }
        return 0;
      }
    }
  }

  );
  static char[] arr;

  public static void fillArray(String s) {
    int n = s.length();
    char[] arrr = new char[n];
    char c = ' ';
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      arrr[i] = c;
    }
    arr = arrr;
  }

  public static boolean isInArray(char[] arrc, char c) {
    for (int i = 0; i < arrc.length; i++) {
      if (arrc[i] == c)
        return true;
    }
    return false;
  }

  public static void fillOccurences(char[] arr) {
    int count = 0;
    char[] visited = new char[arr.length];
    for (int i = 0; i < arr.length; i++) {
      count = 0;
      if (isInArray(visited, arr[i]))
        continue;
      for (int j = 0; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          count++;
        }
      }
      queue.add(new Node(arr[i], count));
      visited[i] = arr[i];
    }
  }
static int k=0;
  public static Arbre createTree(PriorityQueue<Node> queue) {
    n = queue.size();
    while (queue.size() > 1) {
      Arbre a1 = new Arbre();
      a1.root = queue.poll();
      Arbre a2 = new Arbre();
      a2.root = queue.poll();
      Arbre newArbre = new Arbre();
      newArbre.root = new Node('\u0000', a1.root.frequency + a2.root.frequency);
      newArbre.root.left = a1.root;
      newArbre.root.right = a2.root;
      newArbre.root.step=++k;
      queue.add(newArbre.root);
    }
    Arbre resultat = new Arbre(queue.poll());
    return resultat;

  }

  public static void afficher(Node root) {
    if (root != null) {
      if (root.n != '\u0000')
        System.out.println(root.n + " " + root.frequency + " " + root.code);
      afficher(root.left);
      afficher(root.right);

    }
  }

  static void generate(Node node, String a) {
    if (node == null) {

    } else {
      if (node.n != '\u0000') {
        node.code = a;
      }
      generate(node.left, a + "0");
      generate(node.right, a + "1");
    }
  }

  public static void main(String[] args) {
    String s = "abracadabra";
    fillArray(s);
    fillOccurences(arr);
    Arbre result = createTree(queue);
    generate(result.root, " ");
    afficher(result.root);
  }
}
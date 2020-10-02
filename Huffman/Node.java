public class Node {
  char n='\u0000';
  int frequency;
  String code;
  int step=0;
  Node left = null;
  Node right = null;
  public Node(char number,int freq){
    this.n=number;
    this.frequency=freq;
  }
  
  public Node(char number){
    this.n=number;
  }
  
  public void afficher(int N) {
    
  }
}
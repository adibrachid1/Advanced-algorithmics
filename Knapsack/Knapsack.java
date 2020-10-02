import java.util.ArrayList;
import java.util.List;

class Knapsack {

  static int numberOfItems = 5;
  static float[][] tab = { { 4, 12, 0 }, { 8, 32, 0 }, { 2, 40, 0 }, { 6, 30, 0 }, { 1, 50, 0 } };
  static int max = 10;
  static float sum;
  static List<Float> explored = new ArrayList<Float>();
  static float benefit;

  public static float solveKnapsack(int numberofItems, float[][] tab, int max) {
    sum = 0;
    boolean b = false;
    int j;
    for (int i = 0; i < numberofItems; i++) {
      tab[i][2] = (tab[i][1] / tab[i][0]);
    }
    for (int i = 0; i < numberofItems; i++) {
      j = findMax(tab);
      while (b == false) {
        if (tab[j][0] + sum <= max) {
          sum += tab[j][0];
          benefit += tab[j][0] * tab[j][1];
          System.out.println(tab[j][0] + " of " + (j + 1));
          b = true;
        } else {
          tab[j][0]--;
        }
      }
      b = false;

    }
    return sum;
  }

  public static int findMax(float[][] tab) {
    float top = tab[0][2];
    int j = 0;
    for (int i = 1; i < tab.length; i++) {
      if (tab[i][2] > top && !(explored.contains(tab[i][2]))) {
        top = tab[i][2];
        j = i;
      }
    }
    explored.add(top);
    return j;
  }

  public static void main(String args[]) {
    solveKnapsack(numberOfItems, tab, max);
    System.out.println("The total profit is " + benefit);
  }
}
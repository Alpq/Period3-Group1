import java.util.*;
public class Permutations{
  public static int fastestTime(int[][] matrix){
    int min = Integer.MAX_VALUE; // so that we can decrease from there
    int permutations = 1;
    for (int i = matrix.length; i > 0; i --) permutations *= i;
    ArrayList<Integer> blockedCol = new ArrayList<Integer>(); // block visited locations
    ArrayList<Integer> xChain = new ArrayList<Integer>(); //plan out flight course
    for (int i = 0; i < matrix.length; i ++){
      xChain.add(0);
    }
    for (int i = 0; i < permutations; i ++){
      int dist = 0;
      for (int j = 0; j < matrix.length-1; j ++){
        while (blockedCol.contains(xChain.get(j))){
          xChain.set(j, xChain.get(j)+1);
        }
        blockedCol.add(xChain.get(j));
        while (blockedCol.contains(xChain.get(j+1))){
          xChain.set(j+1, xChain.get(j+1)+1);
        }
        if (xChain.get(j+1) > xChain.get(j)) dist += matrix[xChain.get(j)][xChain.get(j+1)];
        else dist += matrix[xChain.get(j+1)][xChain.get(j)];
      }
      if (dist < min) min = dist;

      // Increase the final spot by 1, normalise upward.
      xChain.set(xChain.size()-1, xChain.get(xChain.size()-1)+1);
      for (int o = xChain.size()-1; o >= 0; o --){
        while (xChain.indexOf(xChain.get(o)) < o) xChain.set(o, xChain.get(o)+1);
        if (o > 0 && (xChain.get(o) >= xChain.size() || (xChain.get(o) >= xChain.size()-1
        && xChain.get(o-1) >= xChain.size()-1))){
          xChain.set(o,0);
          xChain.set(o-1,xChain.get(o-1)+1);
        }else break;
      }
      blockedCol = new ArrayList<Integer>();
    }
    return min;
  }

  public static int[][] scanText(){
    ArrayList<String> places = new ArrayList<String>();
    ArrayList<ArrayList<Integer>> dists = new ArrayList<ArrayList<Integer>>();
    Scanner m = new Scanner(System.in);
    while (m.hasNextLine()){
      Scanner n = new Scanner(m.nextLine());
      String row = n.next(); n.next();
      String col = n.next(); n.next();
      if (!places.contains(row)){
        places.add(row);
        dists.add(new ArrayList<Integer>());
      }
      if (!places.contains(col)){
        places.add(col);
        dists.add(new ArrayList<Integer>());
      }
      dists.get(places.indexOf(row)).add(Integer.parseInt(n.next()));
    }
    int[][] matrix = new int[places.size()][places.size()];
    for(int i = 0; i < matrix.length; i ++){
      for(int j = 0; j < matrix.length-(i+1); j ++){
        matrix[i][j+i+1] = dists.get(i).get(j);
      }
    }
    return matrix;
  }

  public static void main(String[] args) {
    int[][] matrix = scanText();
    String str = "";
    for(int i = 0; i < matrix.length; i ++){
      str += Arrays.toString(matrix[i]) + "\n";
    }
    System.out.println(str);
    System.out.println("Minimum: "+fastestTime(matrix));
  }
}

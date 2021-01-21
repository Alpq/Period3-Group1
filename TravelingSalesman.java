import java.util.*;
import java.io.*;
public class TravelingSalesman{
  public static void main(String[] args){
    ArrayList<String> cities = new ArrayList<String>(); //arraylist for starting cities
    ArrayList<String> cities2 = new ArrayList<String>();//arraylist for destination cities
    int distances[][] = new int[9][9]; //is there an upper limit that we need to test?
    Scanner n = new Scanner(System.in);
    while (n.hasNext()){
      String line = n.nextLine();  //"Faerun to Norrath = 129"
      Scanner linescan = new Scanner(line);
      String startingC = linescan.next();
      if (cities.indexOf(startingC) == -1)
        cities.add(startingC); //if cannot find city in 'cities'(returns -1), add to list

      linescan.next(); //skips "to"
      String destinationC = linescan.next();
      if (cities2.indexOf(destinationC) == -1)
        cities2.add(destinationC); //if cannot find city in 'cities2'(returns -1), add to list

      linescan.next(); //skips "="
      int distance = linescan.nextInt(); //finds distance
      distances[cities.indexOf(startingC)][cities2.indexOf(destinationC)] = distance;
      distances[cities2.indexOf(destinationC)][cities.indexOf(startingC)] = distance;
    }
/*    System.out.println(cities.toString());
    System.out.println(cities2.toString());*/
    //we can probably fit startingC and destinationC in the same 'cities' arraylist,
    //but idk if that messes up the order of the starting cities and such

    int shortestPath = Integer.MAX_VALUE;
    ArrayList<Integer> integerPaths = new ArrayList<Integer>();
    for (int i = 0; i < cities.size() ; i++) {integerPaths.add(i);}
    for (int i = 0; i < 6 * factorial(cities.size()) ; i ++)
    {
      Collections.shuffle(cities);
      shortestPath = Math.min(shortestPath, totalDistance(integerPaths, distances));
    }

  }
  public static int totalDistance(ArrayList<Integer> citys, int[][] distance)
  {
    int out = 0;
    for (int i = 0; i < citys.size() - 1; i ++ )
    {
      out += distance[citys.get(i)][citys.get(i + 1)];
    }
    return out;
  }
  public static int factorial (int n)
  {
    int out = 1;
    for (int i = 1;i <= n ; i ++ )
    {
      out = out * i;
    }
    return out;
  }
}

//java TravelingSalesman < Cities.txt

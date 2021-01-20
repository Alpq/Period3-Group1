import java.util.*;
import java.io.*;
public class TravelingSalesman{
  public static void main(String[] args){
    ArrayList<String> cities = new ArrayList<String>(); //arraylist for starting cities
    ArrayList<String> cities2 = new ArrayList<String>(); //arraylist for destination cities
    int distances[][] = new int[9][9];
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
  }
}

//java TravelingSalesman < Cities.txt

import java.util.*;
import java.io.*;
public class Salesman{
  public static void main(String[] args){
    ArrayList<String> cities = new ArrayList<String>(); //arraylist for cities
    ArrayList<String> cities2 = new ArrayList<String>();
    int distances[][] = new int[8][8]; //is there an upper limit that we need to test?
    Scanner n = new Scanner(System.in);
    while (n.hasNext()){
      String line = n.nextLine();  //"Faerun to Norrath = 129"
      Scanner linescan = new Scanner(line);
      String startingC = linescan.next();
      if (cities.indexOf(startingC) == -1)
        cities.add(startingC); //if cannot find city in 'cities'(returns -1), add to list

      linescan.next(); //skips "to"
      String destinationC = linescan.next(); //destination city
      if (cities2.indexOf(destinationC) == -1)
        cities2.add(destinationC);

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

//java Salesman < input.txt

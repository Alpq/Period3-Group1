********************
Names:
********************
Anthony Nosaryev
Alexander Dickerson
Bryan Cheng
Alex Conkey
Annabel Zhang
Alp Doymaz
********************

********************
Notes from Class:
********************
   0 1 2
0 [-,a,b]
1 [a,-,c]
2 [b,c,-]

Number of possibilities = n!
Number of lines given = n(n-1)/2, where n is the # of cities

Each city will have a corresponding number.
We can loop thorugh the array, skipping over nulls with if(point != null) and compare each distance to the previous shortest, then return the shortest.

We will need a Scanner to read the file containing the distances between cities.
********************
********************
Hints from Mr. K:
Homework Tips:
-It is very hard to generate all permutations without recursion. The ways that you do this are tricky or overcomplicated
-You CAN generate all the permutations with high probability of success by randomizing the order Collections.shuffle() can help you scramble the order.

Hint 1:
if there are 5 items, that means there are 5! or 120 permutations.
What if you made 120 random permutations? Would that have a good chance of getting all 120 different permutations?
What if you made 600 random permutations? Would that have a good chance of getting all 120 different permutations?
If you made 1200 permutations, it would be even higher probability.

Hint2: You get at most 9 cities! That helps a lot in your algorithms.
********************
9! = 362880

********************
Possible steps for solving this problem:
1. Scan the file and find # of cities / distances between cities.
2. Create a 2d array with #cities x #cities dimensions.
3. Assign each city a numerical value from 0->(# of cities).
4. Based on the number of cities find the # of permutations needed to find the shortest distance.
   Loop x times{
      5. Shuffle a List with ints from 0->(# of cities).
      6. Iterate through list and find distances between each of the number.
      7. Check if this iteration has the shortest total distance (if so update new shortest distance).
   }
8. Output shortest distance.


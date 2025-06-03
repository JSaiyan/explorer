import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch 
{

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    
    
    public static int reachableArea(int[][] island) 
    {
        //start variable
        int[] start = findExplorer(island);
        //store boolean they all start false, this creates a boolean of false
        boolean[][] visited = new boolean[island.length][island[0].length];

        return reachableArea(island, start, visited);
    }




    //pulling this from the initiatl method, this will be the dfs, overloaded method
    private static int reachableArea(int[][] island, int[] start, boolean[][] visited)
    {
        int row = start[0];
        int col = start[1];

        //setting visited
        if(visited[row][col])
        {
            return 0;
        }

        //this is set to true if we have been there
        //since it is already set to false
        visited[row][col] = true;

        //track what we return at the end
        //has to be 1
        //can i get there if so then count it
        int count = 1;

         List<int[]> neighbors = possibleMoves(island, start);
         for(int[] neighbor : neighbors)
        {
            count += reachableArea(island, neighbor, visited);
        }
       

        return count;

    }



        //where we can go method
        public static List<int[]> possibleMoves(int[][] island, int[] start)
        {
            //create a list that we can move through
            List<int[]> moves = new ArrayList<>();

            int row = start[0];
            int col = start[1];

        //up
        int newR = row - 1;
        int newC = col;

        if (newR >= 0 && island[newR][newC] == 1)
        {
            moves.add(new int[] { newR, newC });
        }

         //down
        newR = row + 1;
        newC = col;
        if (newR < island.length && island[newR][newC] == 1)
        {
            moves.add(new int[] { newR, newC });
        }


         //left
        newR = row;
        newC = col - 1;
        if (newC >= 0 && island[newR][newC] == 1)
        {
            moves.add(new int[] { newR, newC });
        }

               //right
        newR = row;
        newC = col + 1;
        if (newC < island[newR].length && island[newR][newC] == 1)
        {
            moves.add(new int[] { newR, newC });
        }

        return moves;

    }




    //this method helps establish where explorer starts
    //start method
    public static int[] findExplorer(int[][] island)
    {
        for (int row = 0; row < island.length; row++)
        {
            for(int col = 0; col < island[0].length; col++)
            {
                if(island[row][col] == 0)
                {
                    return new int[] {row, col};
                }
            }
        }
        //if no 0 then
        throw new IllegalArgumentException("no explorer (0) found");
    }


}
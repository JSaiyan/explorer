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
        //total number of rows and columns varibales named rows and cols
       int rows = island.length;
       int cols = island[0].length;

       //stroing location of explorer
       int startRow = -1;
       int startCol = -1; 

       //finds explorers starting posistion
       //outter loop for rows
       for (int r = 0; r < rows; r++)
       {
        //inner for columns
        for (int c= 0; c < cols; c++)
        {
            //seraching for cell w/ 0
            if(island[r][c] ==0)
            {
                //break stop once found
                startRow = r;
                startCol = c;
                break;
            }
        }
        if (startRow != -1) break; //stop outer loop if start was found
        
            //no starting point then return 0
            if(startRow == -1 || startCol == -1)
                {
                return 0;
                }
        }

    //start a dfs search , use the start position
    return dfs(island, startRow, startCol);

    }
    private static int dfs(int[][] island, int r, int c)
    {
    //basecase for outof bounds
    if(r < 0 || c < 0 || r >= island.length || c >= island[0].length)
    {
        return 0; 
    }

    //if it is blocked or visted
    //check if it was already visited
    if (island[r][c] == 2 || island[r][c] ==3 || island[r][c] == 9)
    {
        return 0; //cant go there so return 0;
    }

    //tracker to count visited
    island[r][c] = 9;

    //start the count at 1
    int count = 1;

    //check all directions from cell
    for (int[] direct : directions)
    {
        int newRow = r + direct[0]; //moves row up or down
        int newCol = c + direct[1]; //moves column left or right

        //add reachable area
        count += dfs(island, newRow, newCol);
    }

    return count;
    }

}
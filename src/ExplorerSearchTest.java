import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest 
{
    @Test
    //tests islands (1) water (2) mountains (3) and starting point (0)
    //must not go out of bounds
    public void testReachableArea_someUnreachable() 
    {
        int[][] island = 
        {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    @Test
    
}

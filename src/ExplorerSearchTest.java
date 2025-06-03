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
    //tests islands (1) water (2) mountains (3) and starting point (0)
    //must not go out of bounds
    public void testReachableArea_someUnreachable() 
    {
        int[][] island = 
        {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,1,3},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(15, actual);
    }

        @Test
    //tests islands (1) water (2) mountains (3) and starting point (0)
    //must not go out of bounds
    public void testReachableArea_someUnreachable() 
    {
        int[][] island = 
        {
            {1,1,1,3,1,1},
            {3,2,3,1,1,1},
            {1,1,1,1,1,1},
            {3,1,2,1,0,1},
            {1,1,1,2,1,1},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(17, actual);
    }

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
            {3,1,2,1,0,2},
            {1,1,1,2,2,2},
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(11, actual);
    }

    
        @Test
    //tests islands (1) water (2) mountains (3) and starting point (0)
    //must not go out of bounds
    public void testFindExplorer_someUnreachable1() 
    {
        int[][] island = 
        {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,0},
            {1,1,1,2,2,2},
        };
        int[] actual = ExplorerSearch.findExplorer(island);
        int[] expected = {3, 5};

        assertArrayEquals(expected, actual);

    }

         @Test
    //tests islands (1) water (2) mountains (3) and starting point (0)
    //must not go out of bounds
    public void testFindExplorer_someUnreachable2() 
    {
        int[][] island = 
        {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,0,1,2},
            {1,1,1,2,2,2},
        };
        int[] actual = ExplorerSearch.findExplorer(island);
        int[] expected = {3, 3};

        assertArrayEquals(expected, actual);

    }

            @Test
    //tests islands (1) water (2) mountains (3) and starting point (0)
    //must not go out of bounds
    public void testFindExplorer_someUnreachable3() 
    {
        int[][] island = 
        {
            {1,1,1,3,1,1},
            {3,0,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,1,2},
            {1,1,1,2,2,2},
        };
        int[] actual = ExplorerSearch.findExplorer(island);
        int[] expected = {1, 1};

        assertArrayEquals(expected, actual);

    }
        @Test
    //tests islands (1) water (2) mountains (3) and starting point (0)
    //must not go out of bounds
    public void testFindExplorer_someUnreachable4() 
    {
        int[][] island = 
        {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,2,2},
            {1,0,1,2,2,2},
        };
        int[] actual = ExplorerSearch.findExplorer(island);
        int[] expected = {4, 1};

        assertArrayEquals(expected, actual);

    }

            @Test
    //tests islands (1) water (2) mountains (3) and starting point (0)
    //must not go out of bounds
    public void testFindNoExplorer_someUnreachable5() 
    {
        int[][] island = 
        {
            {1,1,1,3,1,1},
            {3,2,3,1,3,1},
            {1,1,1,1,3,3},
            {3,1,2,1,2,2},
            {1,3,1,2,2,2},
        };
       
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
        {
            ExplorerSearch.findExplorer(island);
        });

    }


}

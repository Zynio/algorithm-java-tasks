package pl.lsnova;

import org.junit.jupiter.api.Test;
import pl.zynis.algorithmtasks.FindPairsApp;

import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindPairsAppTest {

    @Test
    void getPairsTest() {
        List<Vector<Integer>> pairs = FindPairsApp.getPairs(new String[]{"1", "2", "10", "7", "5", "3", "6", "6", "13", "0"});

        assertEquals(pairs.size(), 4);
        assertEquals(pairs.get(0).get(0), 0);
        assertEquals(pairs.get(0).get(1), 13);
        assertEquals(pairs.get(1).get(0), 3);
        assertEquals(pairs.get(1).get(1), 10);
        assertEquals(pairs.get(2).get(0), 6);
        assertEquals(pairs.get(2).get(1), 7);
        assertEquals(pairs.get(3).get(0), 6);
        assertEquals(pairs.get(3).get(1), 7);


        List<Vector<Integer>> pairs2 = FindPairsApp.getPairs(new String[]{"1", "2", "3", "4", "5","6", "10", "10", "1", "2", "2","10", "11", "11"});

        assertEquals(pairs2.size(), 9);
        assertEquals(pairs2.get(0).get(0), 2);
        assertEquals(pairs2.get(0).get(1), 11);
        assertEquals(pairs2.get(1).get(0), 2);
        assertEquals(pairs2.get(1).get(1), 11);
        assertEquals(pairs2.get(2).get(0), 2);
        assertEquals(pairs2.get(2).get(1), 11);
        assertEquals(pairs2.get(3).get(0), 2);
        assertEquals(pairs2.get(3).get(1), 11);
        assertEquals(pairs2.get(4).get(0), 2);
        assertEquals(pairs2.get(4).get(1), 11);
        assertEquals(pairs2.get(5).get(0), 2);
        assertEquals(pairs2.get(5).get(1), 11);
        assertEquals(pairs2.get(6).get(0), 3);
        assertEquals(pairs2.get(6).get(1), 10);
        assertEquals(pairs2.get(7).get(0), 3);
        assertEquals(pairs2.get(7).get(1), 10);
        assertEquals(pairs2.get(8).get(0), 3);
        assertEquals(pairs2.get(8).get(1), 10);
    }
}
package pl.lsnova;

import org.junit.jupiter.api.Test;
import pl.zynis.algorithmtasks.FindSeparatedGraphsApp;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindSeparatedGraphsAppTest {

    @Test
    void getPairsTest_first() {
        FindSeparatedGraphsApp app = new FindSeparatedGraphsApp();
        app.addVertexes(1, 2);
        app.addVertexes(1, 40);
        app.addVertexes(1, 41);
        app.addVertexes(2, 3);
        app.addVertexes(5, 6);
        app.addVertexes(7, 10);
        app.addVertexes(10, 11);
        app.addVertexes(11, 40);

        assertEquals(app.getGraphCount(), 2);
    }

    @Test
    void getPairsTest_second() {
        FindSeparatedGraphsApp app = new FindSeparatedGraphsApp();
        app.addVertexes(1, 2);
        app.addVertexes(2, 3);
        app.addVertexes(5, 6);
        app.addVertexes(8, 12);
        app.addVertexes(12, 14);

        assertEquals(app.getGraphCount(), 3);
    }
}
package com.company;

import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Sarthak on 3/27/19.
 */
class QueriesTest {
    @org.junit.jupiter.api.Test
    void readFile() {
        Queries q = new Queries();
        q.openFile("maleFirstNames.txt");
        q.readFile();
        List<String> s = q.names;

        Assertions.assertEquals(100, s.size());
        Assertions.assertEquals("Ismael", s.get(0));
        Assertions.assertEquals("Micah", s.get(1));
        Assertions.assertTrue(s.contains("Humberto"));
        Assertions.assertTrue(s.contains("Cedric"));
    }

}
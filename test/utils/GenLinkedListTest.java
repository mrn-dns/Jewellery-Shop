package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenLinkedListTest {

    private GenLinkedList testList;

    @BeforeEach
    void setUp() {
        testList = new GenLinkedList<>();
    }

    @Test
    void addElement() {
        testList.addElement(2);
        testList.addElement(2);
        assertEquals(2,testList.listLength());
    }

    @Test
    void listLength() {
        testList.addElement(1);
        assertEquals(1,testList.listLength());
    }

    @Test
    void removeElementByObject() {
        testList.addElement(1);
        testList.addElement(2);
        testList.addElement(3);
        testList.addElement(4);
        testList.removeElementByIndex(0);
        assertEquals(3,testList.listLength());
    }

    @Test
    void clear() {
        testList.addElement(1);
        testList.addElement(2);
        testList.clear();
        assertEquals(0,testList.listLength());
    }

    @AfterEach
    void tearDown() {
    }
}
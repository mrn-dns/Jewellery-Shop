package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTrayTest {

    private DisplayTray validTray;

    @BeforeEach
    void setUp() {
        validTray = new DisplayTray("A12",25,25, "RED");
    }

    @Test
    void setId() {
        validTray.setId("B15");
        assertEquals("B15",validTray.getId());
    }

    @Test
    void setWidth() {
        validTray.setWidth(50);
        assertEquals(50,validTray.getWidth());
    }

    @Test
    void setDepth() {
        validTray.setDepth(30);
        assertEquals(30,validTray.getDepth());
    }

    @Test
    void setColor() {
        validTray.setColor("BLUE");
        assertEquals("BLUE",validTray.getColor());
    }

    @AfterEach
    void tearDown() {
    }
}
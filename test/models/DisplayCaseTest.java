package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayCaseTest {

    private DisplayCase validCase;

    @BeforeEach
    void setUp() {
        validCase = new DisplayCase(5,true,true);
    }

    @Test
    public void testConstructor(){
        assertEquals(5,validCase.getId());
        assertTrue(validCase.isFreestd());
        assertTrue(validCase.isLit());
    }

    @Test
    public void setID(){
        validCase.setId(6);
        assertEquals(6,validCase.getId());
    }

    @Test
    public void setFreeStd(){
        validCase.setFreestd(false);
        assertFalse(validCase.isFreestd());
    }

    @Test
    public void setIsLit(){
        validCase.setLit(false);
        assertFalse(false);
    }

    @AfterEach
    void tearDown() {
    }
}
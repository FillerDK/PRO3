package opg2.dictionaryelev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DictionarTest {
    opg2.dictionaryelev.Dictionary<Integer, String> dictionary;
   

    @BeforeEach
    public void setUp() throws Exception {
         dictionary = new opg2.dictionaryelev.DictionaryList<>();

        
    }
    
    @Test
    public void test() {
        assertTrue(dictionary.isEmpty());
        assertEquals(0, dictionary.size());

        dictionary.put(8, "hans");
        dictionary.put(3, "viggo");
        
        assertFalse(dictionary.isEmpty());
        assertEquals(2, dictionary.size());

        assertEquals("hans", dictionary.get(8));

        dictionary.put(7, "bent");
        dictionary.put(2, "lene");
        
        assertFalse(dictionary.isEmpty());
        assertEquals(4, dictionary.size());
        
        assertEquals("viggo", dictionary.remove(3));

        assertEquals(3, dictionary.size());
        
        assertEquals("hans", dictionary.put(8, "ida"));
        assertEquals("ida", dictionary.get(8));

        assertEquals(3, dictionary.size());
    }

    
    
}

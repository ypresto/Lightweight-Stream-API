package com.annimon.stream.function;

import com.annimon.stream.Functions;
import com.annimon.stream.TestUtils;
import java.util.Locale;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests {@code Function}.
 * 
 * @see com.annimon.stream.function.Function
 */
public class FunctionTest {
    
    @Test
    public void testApplyCharacterToString() {
        assertEquals("w", toString.apply('w'));
        assertEquals("0", toString.apply((char)48));
    }
    
    
    @Test
    public void testApplyToUpperCase() {
        assertEquals("JAVA", toUpperCase.apply("java"));
    }
    
    @Test
    public void testAndThen() {
        Function<Character, String> function = Function.Util.andThen(toString, toUpperCase);
        
        assertEquals("W", function.apply('w'));
        assertEquals("A", function.apply((char)65));
    }
    
    @Test
    public void testPrivateConstructor() throws Exception {
        TestUtils.testPrivateConstructor(Function.Util.class);
    }
    
    private static final Function<Character, String> toString = Functions.<Character>convertToString();
    
    private static final Function<String, String> toUpperCase = new Function<String, String>() {
        @Override
        public String apply(String value) {
            return value.toUpperCase(Locale.ENGLISH);
        }
    };
    
}

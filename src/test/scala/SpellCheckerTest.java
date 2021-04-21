import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SpellCheckerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testSetSuggestedWordListLimit() {
        SpellChecker spellChecker = new SpellChecker();
        spellChecker.setSuggestedWordListLimit(1);
        assertEquals(1, spellChecker.getSuggestedWordListLimit());
    }

    @Test
    public void testSetSuggestedWordListLimit2() {
        SpellChecker spellChecker = new SpellChecker();
        spellChecker.setSuggestedWordListLimit(0);
        assertEquals(10, spellChecker.getSuggestedWordListLimit());
    }

    @Test
    public void testCorrect() throws IllegalArgumentException {
        assertTrue((new SpellChecker()).correct("Str").isEmpty());
    }

    @Test
    public void testCorrect2() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        (new SpellChecker()).correct("");
    }

    @Test
    public void testCorrect3() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        (new SpellChecker()).correct(null);
    }
}


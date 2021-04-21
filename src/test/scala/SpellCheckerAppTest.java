import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SpellCheckerAppTest {
    @Test
    public void testCorrectWord() {
        SpellCheckerApp spellCheckerApp = new SpellCheckerApp();
        spellCheckerApp.correctWord("");
        assertNull(spellCheckerApp.page);
        assertNull(spellCheckerApp.fxmlLoader);
    }

    @Test
    public void testCorrectWord2() {
        SpellCheckerApp spellCheckerApp = new SpellCheckerApp();
        spellCheckerApp.correctWord(null);
        assertNull(spellCheckerApp.page);
        assertNull(spellCheckerApp.fxmlLoader);
    }
}


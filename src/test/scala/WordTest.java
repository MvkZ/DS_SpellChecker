import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordTest {
    @Test
    public void testConstructor() {
        Word actualWord = new Word("Sr No", "Word", "Edit Distance");
        assertEquals("Edit Distance", actualWord.getEditDistance());
        assertEquals("Word", actualWord.getWord());
        assertEquals("Sr No", actualWord.getSrNo());
    }

    @Test
    public void testGetSrNo() {
        assertEquals("Sr No", (new Word("Sr No", "Word", "Edit Distance")).getSrNo());
    }

    @Test
    public void testSetSrNo() {
        Word word = new Word("Sr No", "Word", "Edit Distance");
        word.setSrNo("Sr No");
        assertEquals("Edit Distance", word.getEditDistance());
        assertEquals("Word", word.getWord());
        assertEquals("Sr No", word.getSrNo());
    }

    @Test
    public void testGetWord() {
        assertEquals("Word", (new Word("Sr No", "Word", "Edit Distance")).getWord());
    }

    @Test
    public void testSetWord() {
        Word word = new Word("Sr No", "Word", "Edit Distance");
        word.setWord("Word");
        assertEquals("Edit Distance", word.getEditDistance());
        assertEquals("Word", word.getWord());
        assertEquals("Sr No", word.getSrNo());
    }

    @Test
    public void testGetEditDistance() {
        assertEquals("Edit Distance", (new Word("Sr No", "Word", "Edit Distance")).getEditDistance());
    }

    @Test
    public void testSetEditDistance() {
        Word word = new Word("Sr No", "Word", "Edit Distance");
        word.setEditDistance("Edit Distance");
        assertEquals("Edit Distance", word.getEditDistance());
        assertEquals("Word", word.getWord());
        assertEquals("Sr No", word.getSrNo());
    }
}


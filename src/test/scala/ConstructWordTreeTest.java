import static org.junit.Assert.assertNull;

import AlgoObjects.TernarySearchTree;
import org.junit.Test;

public class ConstructWordTreeTest {
    @Test
    public void testCreateTree() {
        assertNull(ConstructWordTree.createTree(new TernarySearchTree()));
    }

    @Test
    public void testCreateTree2() {
        TernarySearchTree ternarySearchTree = new TernarySearchTree();
        ternarySearchTree.insert("dict.txt", "dict.txt");
        ConstructWordTree.createTree(ternarySearchTree);
    }
}


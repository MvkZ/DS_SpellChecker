package AlgoObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TernarySearchTreeTest {
    @Test
    public void testSetRoot() {
        TernarySearchTree ternarySearchTree = new TernarySearchTree();
        Node node = new Node('A');
        ternarySearchTree.setRoot(node);
        assertSame(node, ternarySearchTree.getRoot());
    }

    @Test
    public void testInsert() {
        TernarySearchTree ternarySearchTree = new TernarySearchTree();
        ternarySearchTree.insert("Word", "Frequency");
        Node root = ternarySearchTree.getRoot();
        assertEquals('W', root.getData());
        assertNull(root.getRight());
        assertNull(root.getLeft());
        assertFalse(root.getIsEnd());
        assertNull(root.getFrequency());
        Node equal = root.getEqual();
        assertEquals('o', equal.getData());
        assertNull(equal.getRight());
        assertNull(equal.getLeft());
        assertFalse(equal.getIsEnd());
        assertNull(equal.getFrequency());
        Node equal1 = equal.getEqual();
        assertEquals('r', equal1.getData());
        assertNull(equal1.getRight());
        assertNull(equal1.getLeft());
        assertFalse(equal1.getIsEnd());
        assertNull(equal1.getFrequency());
        Node equal2 = equal1.getEqual();
        assertEquals('d', equal2.getData());
        assertNull(equal2.getRight());
        assertNull(equal2.getLeft());
        assertTrue(equal2.getIsEnd());
        assertEquals("Frequency", equal2.getFrequency());
        assertNull(equal2.getEqual());
    }

    @Test
    public void testInsert2() {
        Node node = new Node('A');
        TernarySearchTree ternarySearchTree = new TernarySearchTree(node);
        ternarySearchTree.insert("Word", "Frequency");
        Node root = ternarySearchTree.getRoot();
        assertSame(node, root);
        Node right = root.getRight();
        assertNull(right.getFrequency());
        assertEquals('W', right.getData());
        assertNull(right.getLeft());
        assertNull(right.getRight());
        assertFalse(right.getIsEnd());
        Node equal = right.getEqual();
        assertNull(equal.getFrequency());
        assertEquals('o', equal.getData());
        assertNull(equal.getLeft());
        assertNull(equal.getRight());
        assertFalse(equal.getIsEnd());
        Node equal1 = equal.getEqual();
        assertNull(equal1.getFrequency());
        assertEquals('r', equal1.getData());
        assertNull(equal1.getLeft());
        assertNull(equal1.getRight());
        assertFalse(equal1.getIsEnd());
        Node equal2 = equal1.getEqual();
        assertEquals("Frequency", equal2.getFrequency());
        assertNull(equal2.getEqual());
        assertEquals('d', equal2.getData());
        assertNull(equal2.getRight());
        assertTrue(equal2.getIsEnd());
        assertNull(equal2.getLeft());
    }

    @Test
    public void testInsert3() {
        TernarySearchTree ternarySearchTree = new TernarySearchTree();
        ternarySearchTree.insert("Word", "Frequency");
        ternarySearchTree.insert("Word", "Frequency");
        Node equal = ternarySearchTree.getRoot().getEqual().getEqual().getEqual();
        assertTrue(equal.getIsEnd());
        assertEquals("Frequency", equal.getFrequency());
    }

    @Test
    public void testSearch() {
        TernarySearchTree ternarySearchTree = new TernarySearchTree();
        assertFalse(ternarySearchTree.search(new Node('A'), "Word", 1));
    }

    @Test
    public void testSearch2() {
        TernarySearchTree ternarySearchTree = new TernarySearchTree();
        assertFalse(ternarySearchTree.search(new Node('o'), "Word", 1));
    }

    @Test
    public void testSearch3() {
        TernarySearchTree ternarySearchTree = new TernarySearchTree();
        assertFalse(ternarySearchTree.search(new Node('z'), "Word", 1));
    }

    @Test
    public void testSearch4() {
        TernarySearchTree ternarySearchTree = new TernarySearchTree();

        Node node = new Node('o');
        node.setIsEnd(true);
        assertFalse(ternarySearchTree.search(node, "Word", 1));
    }
}


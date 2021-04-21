package AlgoObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NodeTest {
    @Test
    public void testSetData() {
        Node node = new Node('A');
        node.setData('A');
        assertEquals('A', node.getData());
    }

    @Test
    public void testSetIsEnd() {
        Node node = new Node('A');
        node.setIsEnd(true);
        assertTrue(node.getIsEnd());
    }

    @Test
    public void testSetLeft() {
        Node node = new Node('A');
        Node node1 = new Node('A');
        node.setLeft(node1);
        assertSame(node1, node.getLeft());
    }

    @Test
    public void testSetEqual() {
        Node node = new Node('A');
        Node node1 = new Node('A');
        Node actualSetEqualResult = node.setEqual(node1);
        assertSame(node1, actualSetEqualResult);
        assertSame(actualSetEqualResult, node.getEqual());
    }

    @Test
    public void testSetRight() {
        Node node = new Node('A');
        Node node1 = new Node('A');
        node.setRight(node1);
        assertSame(node1, node.getRight());
    }

    @Test
    public void testSetFrequency() {
        Node node = new Node('A');
        node.setFrequency("Frequency");
        assertEquals("Frequency", node.getFrequency());
    }
}


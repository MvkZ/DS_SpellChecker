package AlgoObjects;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PriorityQueueElementTest {
    @Test
    public void testSetWord() {
        PriorityQueueElement priorityQueueElement = new PriorityQueueElement("Word", 1, "Frequency");
        priorityQueueElement.setWord("Word");
        assertEquals("Word", priorityQueueElement.getWord());
    }

    @Test
    public void testSetDistance() {
        PriorityQueueElement priorityQueueElement = new PriorityQueueElement("Word", 1, "Frequency");
        priorityQueueElement.setDistance(1);
        assertEquals(1, priorityQueueElement.getDistance());
    }

    @Test
    public void testSetFrequency() {
        PriorityQueueElement priorityQueueElement = new PriorityQueueElement("Word", 1, "Frequency");
        priorityQueueElement.setFrequency("Frequency");
        assertEquals("Frequency", priorityQueueElement.getFrequency());
    }

    @Test
    public void testCompareTo() {
        PriorityQueueElement priorityQueueElement = new PriorityQueueElement("Word", 1, "Frequency");
        assertEquals(0, priorityQueueElement.compareTo(new PriorityQueueElement("Word", 1, "Frequency")));
    }

    @Test
    public void testCompareTo2() {
        PriorityQueueElement priorityQueueElement = new PriorityQueueElement("Word", 0, "Frequency");
        assertEquals(-1, priorityQueueElement.compareTo(new PriorityQueueElement("Word", 1, "Frequency")));
    }

    @Test
    public void testCompareTo3() {
        PriorityQueueElement priorityQueueElement = new PriorityQueueElement("Word", 9, "Frequency");
        assertEquals(1, priorityQueueElement.compareTo(new PriorityQueueElement("Word", 1, "Frequency")));
    }

    @Test
    public void testCompareTo4() {
        PriorityQueueElement priorityQueueElement = new PriorityQueueElement("Word", 1, "");
        assertEquals(1, priorityQueueElement.compareTo(new PriorityQueueElement("Word", 1, "Frequency")));
    }

    @Test
    public void testCompareTo5() {
        PriorityQueueElement priorityQueueElement = new PriorityQueueElement("Word", 1, "Frequency");
        assertEquals(-1, priorityQueueElement.compareTo(new PriorityQueueElement("Word", 1, "")));
    }

    @Test
    public void testCompareTo6() {
        PriorityQueueElement priorityQueueElement = new PriorityQueueElement("", 0, "Frequency");
        assertEquals(-1, priorityQueueElement.compareTo(new PriorityQueueElement("Word", 1, "Frequency")));
    }
}


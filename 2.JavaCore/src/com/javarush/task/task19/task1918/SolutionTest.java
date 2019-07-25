package com.javarush.task.task19.task1918;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @org.junit.Test
    public void getOpenTagPositionTest() {
        String text = "</span> Info <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga ";

        int position = Solution.getOpenTagPosition(text);

        assertEquals(13, position);
    }

    @org.junit.Test
    public void getClosedTagPositionTest() {
        String text = " Leela <span></b></span><span>Super</span><span>girl</span>";

        int position = Solution.getClosedTagPosition(text);

        assertEquals(17, position);
    }

    @Test
    public void isOpenNextTagTest() {
        String text = " Leela <span></b></span><span>Super</span><span>girl</span>";

        assertTrue(Solution.isOpenNextTag(text));
        assertFalse(Solution.isClosedNextTag(text));
    }

    @Test
    public void isClosedNextTagTest() {
        String text = "</span> Info <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga ";
        String text2 = "</span> Info ";

        assertTrue(Solution.isClosedNextTag(text));
        assertFalse(Solution.isOpenNextTag(text));
        assertTrue(Solution.isClosedNextTag(text2));
        assertFalse(Solution.isOpenNextTag(text2));
    }

    @Test
    public void isTagInTextTest() {
        String text = "<b><span>Turanga Leela</span></b>";

        assertTrue(Solution.isTagInText(text));
    }

    @Test
    public void getFullTagTextSimpleTest() {
        String text = "Info about <span>girl</span></span>";

        String fullTagText = Solution.getFullTagText(text, 11, 28);

        String expected = "<span>girl</span>";

        assertEquals(expected, fullTagText);
    }

    @Test
    public void getIncludedTagsTest() {
        String text = "Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela" +
                "</span></b></span><span>Super</span><span>girl</span>";

        List<String> tags = Solution.getTags(text);

        assertEquals("<span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela" +
                "</span></b></span>", tags.get(0));
        assertEquals("<span>Turanga Leela" +
                "</span>", tags.get(1));
    }


    @Test
    public void getAllTagsTest() {
        String text = "Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela" +
                "</span></b></span><span>Super</span><span>girl</span>";

        List<String> tags = Solution.getTags(text);

        assertEquals("<span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela</span></b></span>", tags.get(0));
        assertEquals("<span>Turanga Leela</span>", tags.get(1));
        assertEquals("<span>girl</span>", tags.get(3));
    }
}
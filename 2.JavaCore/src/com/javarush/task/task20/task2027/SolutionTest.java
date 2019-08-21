package com.javarush.task.task20.task2027;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    static int[][] crossword;

    @Before
    public void setUp() {
        crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
    }

    @Test
    public void testFindLiteralCoordinatesFrom() {
        Assert.assertArrayEquals(new int[]{2, 0}, Solution.findLiteralCoordinatesFrom(crossword, 'e', new int[]{0, 0}));
        Assert.assertArrayEquals(new int[]{4, 1}, Solution.findLiteralCoordinatesFrom(crossword, 'e', new int[]{2, 0}));
        Assert.assertArrayEquals(new int[]{2, 4}, Solution.findLiteralCoordinatesFrom(crossword, 'e', new int[]{4, 1}));
        Assert.assertArrayEquals(new int[]{3, 4}, Solution.findLiteralCoordinatesFrom(crossword, 'e', new int[]{2, 4}));
        Assert.assertArrayEquals(null, Solution.findLiteralCoordinatesFrom(crossword, 'e', new int[]{3, 4}));
    }

    @Test
    public void testFindDirection() {
        int[] startPosition = new int[]{1, 1};
        Assert.assertNull(Solution.findDirection(startPosition, new int[]{3, 1}));
        Assert.assertEquals(Solution.Direction.HORIZONTAL, Solution.findDirection(startPosition, new int[]{2, 1}));
        Assert.assertEquals(Solution.Direction.HORIZONTAL_REVERSE, Solution.findDirection(startPosition, new int[]{0, 1}));
        Assert.assertEquals(Solution.Direction.VERTICAL, Solution.findDirection(startPosition, new int[]{1, 2}));
        Assert.assertEquals(Solution.Direction.VERTICAL_REVERSE, Solution.findDirection(startPosition, new int[]{1, 0}));
        Assert.assertEquals(Solution.Direction.DIAGONAL_LEFT_RIGHT, Solution.findDirection(startPosition, new int[]{2, 2}));
        Assert.assertEquals(Solution.Direction.DIAGONAL_LEFT_RIGHT_REVERSE, Solution.findDirection(startPosition, new int[]{0, 0}));
        Assert.assertEquals(Solution.Direction.DIAGONAL_RIGHT_LEFT, Solution.findDirection(startPosition, new int[]{2, 0}));
        Assert.assertEquals(Solution.Direction.DIAGONAL_RIGHT_LEFT_REVERSE, Solution.findDirection(startPosition, new int[]{0, 2}));
    }

    @Test
    public void testIsDirectionalHasNextChar() {
        int[] startPosition = new int[]{1, 1};
        char findedChar = 'a';
        Assert.assertTrue(Solution.isDirectionHasNextChar(crossword, Solution.Direction.HORIZONTAL, startPosition, findedChar));
    }

    @Test
    public void testFindNextPositionOnDirection() {

        int[] startPosition = new int[]{1, 1};

        Assert.assertArrayEquals(
                Solution.findNextPositionOnDirection(crossword, Solution.Direction.HORIZONTAL, startPosition),
                new int[]{2, 1}
        );

        Assert.assertArrayEquals(
                Solution.findNextPositionOnDirection(crossword, Solution.Direction.HORIZONTAL_REVERSE, startPosition),
                new int[]{0, 1}
        );

        Assert.assertArrayEquals(
                new int[]{1, 2},
                Solution.findNextPositionOnDirection(crossword, Solution.Direction.VERTICAL, startPosition)
        );

        Assert.assertArrayEquals(
                Solution.findNextPositionOnDirection(crossword, Solution.Direction.VERTICAL_REVERSE, startPosition),
                new int[]{1, 0}
        );

        Assert.assertArrayEquals(
                Solution.findNextPositionOnDirection(crossword, Solution.Direction.DIAGONAL_LEFT_RIGHT, startPosition),
                new int[]{2, 2}
        );

        Assert.assertArrayEquals(
                Solution.findNextPositionOnDirection(crossword, Solution.Direction.DIAGONAL_LEFT_RIGHT_REVERSE, startPosition),
                new int[]{0, 0}
        );

        Assert.assertArrayEquals(
                Solution.findNextPositionOnDirection(crossword, Solution.Direction.DIAGONAL_RIGHT_LEFT, startPosition),
                new int[]{2, 0}
        );

        Assert.assertArrayEquals(
                Solution.findNextPositionOnDirection(crossword, Solution.Direction.DIAGONAL_RIGHT_LEFT_REVERSE, startPosition),
                new int[]{0, 2}
        );
    }

    @Test
    public void testIsPositionOnCrossword() {
        Assert.assertTrue(Solution.isPositionOnCrossword(crossword, new int[]{2, 2}));
        Assert.assertFalse(Solution.isPositionOnCrossword(crossword, new int[]{6, 4}));
        Assert.assertFalse(Solution.isPositionOnCrossword(crossword, new int[]{5, 5}));
        Assert.assertFalse(Solution.isPositionOnCrossword(crossword, new int[]{0, -1}));
        Assert.assertFalse(Solution.isPositionOnCrossword(crossword, new int[]{-1, 0}));
    }

    private Solution.Word getWord(String text, int[] start, int[] end) {
        Solution.Word word = new Solution.Word(text);

        word.setStartPoint(start[0], start[1]);
        word.setEndPoint(end[0], end[1]);

        return word;
    }

    @Test
    public void testEquivalentWords() {
        Solution.Word home = new Solution.Word("home");
        home.setStartPoint(5, 3);
        home.setEndPoint(2, 0);

        Solution.Word home2 = new Solution.Word("home");
        home2.setStartPoint(5, 3);
        home2.setEndPoint(2, 0);

        Assert.assertEquals(home, home2);
    }

    @Test
    public void testFindLastPosition() {
        Assert.assertArrayEquals(new int[]{2, 0}, Solution.findLastPosition(crossword, Solution.Direction.DIAGONAL_LEFT_RIGHT_REVERSE, new int[]{5, 3}, "home".toCharArray()));
    }

    @Test
    public void testDetectAllWords() {

        Solution.Word home = getWord("home", new int[]{5, 3}, new int[]{2, 0});
        Solution.Word ho = getWord("ho", new int[]{5, 3}, new int[]{4, 2});
        Solution.Word same = getWord("same", new int[]{1, 1}, new int[]{4, 1});
        Solution.Word leo = getWord("leo", new int[]{4, 0}, new int[]{4, 2});
        Solution.Word red = getWord("red", new int[]{3, 0}, new int[]{1, 0});
        Solution.Word mo = getWord("mo", new int[]{3, 1}, new int[]{4, 2});
        Solution.Word mo2 = getWord("mo", new int[]{0, 3}, new int[]{1, 4});

        List<Solution.Word> expectedWords = new ArrayList<>(Arrays.asList(home, ho, same, leo, red, mo, mo2));
        List<Solution.Word> actualWords = Solution.detectAllWords(crossword, "home", "ho", "same", "leo", "red", "mo");

        for (int i = 0; i < expectedWords.size(); i++) {
            Assert.assertEquals(expectedWords.get(i), actualWords.get(i));
        }
    }

    @Test
    public void testOneLiterWords() {
        Solution.Word m = getWord("m", new int[]{3, 1}, new int[]{3, 1});
        Solution.Word m2 = getWord("m", new int[]{0, 3}, new int[]{0, 3});

        List<Solution.Word> expectedWords = new ArrayList<>(Arrays.asList(m, m2));
        List<Solution.Word> actualWords = Solution.detectAllWords(crossword, "m", "m2");

        for (int i = 0; i < expectedWords.size(); i++) {
            Assert.assertEquals(expectedWords.get(i), actualWords.get(i));
        }
    }
}

/*
    detectAllWords(crossword, "home", "same");
            Ожидаемый результат
            home - (5, 3) - (2, 0)
            same - (1, 1) - (4, 1)

/*
int[][] crossword = new int[][]{
                {'f', 'e', 'e', 'e', 'l', 'e'},
                {'u', 's', 'n', 'n', 'n', 'o'},
                {'l', 'e', 'n', 'o', 'n', 'e'},
                {'m', 'm', 'n', 'n', 'n', 'h'},
                {'p', 'e', 'e', 'e', 'j', 'e'},
        };
        List<Word> words = (detectAllWords(crossword, "one"));
        for (Word word:words) {
            System.out.println(word);
        }

        one - (3, 2) - (1, 0)
one - (3, 2) - (3, 0)
one - (3, 2) - (5, 0)
one - (3, 2) - (1, 2)
one - (3, 2) - (5, 2)
one - (3, 2) - (1, 4)
one - (3, 2) - (3, 4)
one - (3, 2) - (5, 4)
*/
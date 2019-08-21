package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* Задача 2027 - тут есть тесты - не забудь запустить
Кроссворд
*/
public class Solution {

    enum Direction
            {
                HORIZONTAL,
                HORIZONTAL_REVERSE,
                VERTICAL,
                VERTICAL_REVERSE,
                DIAGONAL_RIGHT_LEFT,
                DIAGONAL_RIGHT_LEFT_REVERSE,
                DIAGONAL_LEFT_RIGHT,
                DIAGONAL_LEFT_RIGHT_REVERSE
            }

    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}

        };
        detectAllWords(crossword, "home", "same");
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Solution.Word> allWords = new ArrayList<>();

        for (String wordStr : words) {
            //координата первой литеры - содержит позицию по горизонтали и вертикали
            int[] firstCharCoordinates = new int[2];
            //каждое слово необходимо перевести в массив символов для проверки всех символов
            char[] wordChars = getWordChars(wordStr);

            char firstChar = wordChars[0];
            //в матрице символов может быть несколько слов - поэтому необходимо возобновлять поиск с уже найденного символа
            while ((firstCharCoordinates = findLiteralCoordinatesFrom(crossword, firstChar, firstCharCoordinates)) != null){
                //создать объект "слово" которое войдет в итоговый результат
                Solution.Word wordObj = new Solution.Word(wordStr);
                //из одной буквы слово может быть написано в нескольких направлениях,
                //поэтому необходим цикл в котором проверяются все направления
                for (int[][] wordCoordinates : findWord(crossword, firstCharCoordinates, wordChars)) {
                    allWords.add(wordObj.setWordCoordinates(wordCoordinates));
                }
            }
        }

        //v/
        //allWords.forEach(System.out::println);

        return allWords;
    }

    private static char[] getWordChars(String wordStr) {
        char[] chars = new char[wordStr.length()];
        wordStr.getChars(0, wordStr.length(), chars, 0);
        return chars;
    }

    private static List<int[][]> findWord(int[][] crossword, int[] firstCharCoordinates, char[] charsWord) {
        List<int[][]> resultWordCoordinates = new ArrayList<>();
        int[] lastCharCoordinates;

        //необходимо проверить слово во всех направлениях
        for (Direction direction : Direction.values()) {
            if((lastCharCoordinates = findLastPosition(crossword, direction, firstCharCoordinates, charsWord)) == null) continue;
            //сохранить позицию последнего символа слова по этому направлению
            resultWordCoordinates.add(new int[][]{firstCharCoordinates, lastCharCoordinates});
            //если слово из одной буквы - нет смысла проверять все направления
            if (charsWord.length == 1) break;
        }

        return resultWordCoordinates;
    }

    public static int[] findLastPosition(int[][] crossword, Direction direction, int[] coordinata, char[] charsWord) {

        for (int i = 1; i < charsWord.length; i++) {

            coordinata = findNextPositionOnDirection(crossword, direction, coordinata);

            if (coordinata == null || charsWord[i] != crossword[coordinata[1]][coordinata[0]]) {
                coordinata = null;
                break;
            }
        }


        return coordinata;
    }


    public static int[] findLiteralCoordinatesFrom(int[][] crossword, char character, int[] lastCoordinates){
        int i = 0;
        int j = 0;

        if(lastCoordinates != null){
            i = lastCoordinates[1];
            j = lastCoordinates[0] + 1;
        }

        while (i < crossword.length) {
            while (j < crossword[i].length) {
                //если найден символ в массиве и ранее он не использовался, то получить его позицию
                if ((char)crossword[i][j] == character) return new int[]{j, i};
                j++;
            }
            j = 0;
            i++;
        }

        return null;
    }

    public static Direction findDirection(int[] positionStart, int[] positionNext) {

        if(isLeftRightDiagonal(positionStart, positionNext)){
            return Direction.DIAGONAL_LEFT_RIGHT;//diagonal left_high cover - right_bottom cover
        } else if(isReverseLeftRightDiagonal(positionStart, positionNext)){
            return Direction.DIAGONAL_LEFT_RIGHT_REVERSE;
        } else if(isRightLeftDiagonal(positionStart, positionNext)){
            return Direction.DIAGONAL_RIGHT_LEFT;
        } else if(isReverseRightLeftDiagonal(positionStart, positionNext)){
            return Direction.DIAGONAL_RIGHT_LEFT_REVERSE;
        } else if(isStepRight(positionStart, positionNext)){
            return Direction.HORIZONTAL;
        } else if (isStepLeft(positionStart, positionNext)){
            return Direction.HORIZONTAL_REVERSE;
        } else if (isStepDown(positionStart, positionNext)){
            return Direction.VERTICAL;
        } else if (isStepUp(positionStart, positionNext)){
            return Direction.VERTICAL_REVERSE;
        }

        return null;
    }

    private static boolean isReverseRightLeftDiagonal(int[] positionStart, int[] positionNext) {
        return isStepLeft(positionStart, positionNext) &&
                isStepDown(positionStart, positionNext);
    }

    private static boolean isRightLeftDiagonal(int[] positionStart, int[] positionNext) {
        return isStepRight(positionStart, positionNext)
                && isStepUp(positionStart, positionNext);
    }

    private static boolean isReverseLeftRightDiagonal(int[] positionStart, int[] positionNext) {
        return isStepLeft(positionStart, positionNext) &&
                isStepUp(positionStart, positionNext);
    }

    private static boolean isLeftRightDiagonal(int[] positionStart, int[] positionNext) {
        return isStepRight(positionStart, positionNext) &&
               isStepDown(positionStart, positionNext);
    }

    private static boolean isStepUp(int[] positionStart, int[] positionNext) {
        return positionNext[1] - positionStart[1] == -1;
    }

    private static int[] stepUp(int[] positionStart) {
        return new int[]{positionStart[0], positionStart[1] - 1};
    }

    private static boolean isStepDown(int[] positionStart, int[] positionNext) {
        return positionNext[1] - positionStart[1] == 1;
    }

    private static int[] stepDown(int[] positionStart) {
        return new int[]{positionStart[0], positionStart[1] + 1};
    }

    private static boolean isStepLeft(int[] positionStart, int[] positionNext) {
        return positionNext[0] - positionStart[0] == -1;
    }

    private static int[] stepLeft(int[] positionStart) {
        return new int[]{positionStart[0] - 1, positionStart[1]};
    }

    private static boolean isStepRight(int[] positionStart, int[] positionNext) {
        return positionNext[0] - positionStart[0] == 1;
    }

    private static int[] stepRight(int[] positionStart){
        return new int[]{positionStart[0] + 1, positionStart[1]};
    }

    public static boolean isDirectionHasNextChar(int[][] crossword, Direction direction, int[] startPosition, char findedChar) {
        int[] nextPosition = findNextPositionOnDirection(crossword, direction, startPosition);
        return nextPosition != null && crossword[nextPosition[1]][nextPosition[0]] == findedChar;
    }

    public static int[] findNextPositionOnDirection(int[][] crossword, Direction direction, int[] startPosition) {
        int[] nextPosition = startPosition;

        switch (direction){
            case HORIZONTAL:
                nextPosition = stepRight(startPosition);
                break;
            case HORIZONTAL_REVERSE:
                nextPosition = stepLeft(startPosition);
                break;
            case VERTICAL:
                nextPosition = stepDown(startPosition);
                break;
            case VERTICAL_REVERSE:
                nextPosition = stepUp(startPosition);
                break;
            case DIAGONAL_LEFT_RIGHT:
                nextPosition = stepRight(stepDown(startPosition));
                break;
            case DIAGONAL_LEFT_RIGHT_REVERSE:
                nextPosition = stepLeft(stepUp(startPosition));
                break;
            case DIAGONAL_RIGHT_LEFT:
                nextPosition = stepRight(stepUp(startPosition));
                break;
            case DIAGONAL_RIGHT_LEFT_REVERSE:
                nextPosition = stepLeft(stepDown(startPosition));
                break;
        }

        return isPositionOnCrossword(crossword, nextPosition) ? nextPosition : null;
    }

    public static boolean isPositionOnCrossword(int[][] crossword, int[] position) {
        return crossword[0].length-1 >=position[0]
                && crossword.length-1 >= position[1]
                && position[0] >= 0
                && position[1] >= 0
                ;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        private Word setWordCoordinates(int[][] coordinata) {
            setStartPoint(coordinata[0][0], coordinata[0][1]);
            setEndPoint(coordinata[1][0], coordinata[1][1]);
            return this;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(obj == null) return false;

            if(obj instanceof Word) {
                Word o = (Word) obj;

                return this.getClass().equals(obj.getClass())
                        && this.text.equals(o.text)
                        && this.endX == o.endX
                        && this.endY == o.endY
                        && this.startX == o.startX
                        && this.startY == o.startY
                        ;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 37;
            hash = hash*17 + text.hashCode();
            hash = hash*17 + startX;
            hash = hash*17 + startY;
            hash = hash*17 + endX;
            hash = hash*17 + endY;

            return hash;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}

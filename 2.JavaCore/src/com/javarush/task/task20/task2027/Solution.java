package com.javarush.task.task20.task2027;

import java.util.LinkedList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> www = detectAllWords(crossword, "luf", "fde", "ful", "fsg", "edf", "gsf", "esl", "lse", "home", "same");
        System.out.println(www.toString());
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new LinkedList<>();
//        System.out.println(crossword.length);
//        System.out.println(crossword[1].length);
        for (String word : words) {
            list.add(findWord(crossword, word));
        }
        return list;
    }

    private static Word findWord(int[][] crossword, String word) throws NullPointerException {
        Seacher seacher;
        Position start = null;
        Position current = null;
        Position end = null;
        boolean finded = true;
        char[] chars = word.toCharArray();
        seacher = new Seacher(crossword, chars[0]);
        start:
        while ((start = seacher.findChar()) != null) {
            current = new Position(start.x, start.y);
            if ((crossword[current.y].length - current.x - chars.length) > 0) {
                for (char ch : chars) {
                    if (ch != crossword[current.y][current.x++]) finded = false;
                }
                if (finded) {
                    current.x--;
                    end = current;
                    break;
                }
            }
            finded = true;
            current.x = start.x;
            current.y = start.y;
            if ((crossword.length - current.y - chars.length) > 0) {
                for (char ch : chars) {
                    if (ch != crossword[current.y++][current.x]) finded = false;
                }
                if (finded) {
                    current.y--;
                    end = current;
                    break;
                }
            }
            finded = true;
            current.x = start.x;
            current.y = start.y;
            if ((crossword.length - current.y - chars.length) > 0 && (crossword[current.y].length - current.x - chars.length) > 0) {
                for (char ch : chars) {
                    if (ch != crossword[current.y++][current.x++]) finded = false;
                }
                if (finded) {
                    current.y--;
                    current.x--;
                    end = current;
                    break;
                }
            }
            finded = true;
            current.x = start.x;
            current.y = start.y;
            if ((current.y + 1 - chars.length) >= 0) {
                for (char ch : chars) {
                    if (ch != crossword[current.y--][current.x]) finded = false;
                }
                if (finded) {
                    current.y++;
                    end = current;
                    break;
                }
            }
            finded = true;
            current.x = start.x;
            current.y = start.y;
            if ((current.x + 1 - chars.length) >= 0) {
                for (char ch : chars) {
                    if (ch != crossword[current.y][current.x--]) finded = false;
                }
                if (finded) {
                    current.x++;
                    end = current;
                    break;
                }
            }
            finded = true;
            current.x = start.x;
            current.y = start.y;
            if ((current.y + 1 - chars.length) >= 0 && (current.x + 1 - chars.length) >= 0) {
                for (char ch : chars) {
                    if (ch != crossword[current.y--][current.x--]) finded = false;
                }
                if (finded) {
                    current.x++;
                    current.y++;
                    end = current;
                    break;
                }
            }
            finded = true;
            current.x = start.x;
            current.y = start.y;
            if ((current.x + 1 - chars.length) >= 0 && (crossword.length - current.y - chars.length) > 0) {
                for (char ch : chars) {
                    if (ch != crossword[current.y++][current.x--]) finded = false;
                }
                if (finded) {
                    current.y--;
                    current.x++;
                    end = current;
                    break;
                }
            }
            finded = true;
            current.x = start.x;
            current.y = start.y;
            if ((current.y + 1 - chars.length) >= 0 && (crossword[current.y].length - current.x - chars.length) > 0) {
                for (char ch : chars) {
                    if (ch != crossword[current.y--][current.x++]) finded = false;
                }
                if (finded) {
                    current.y++;
                    current.x--;
                    end = current;
                    break;
                }
            }
        }

        Word word1 = new Word(word);
        word1.setStartPoint(start.x, start.y);
        word1.setEndPoint(end.x, end.y);
        return word1;
    }

    private static class Seacher {

        Position current;
        int[][] crossword;
        char ch;

        public Seacher(int[][] crossword, char ch) {
            this.current = new Position(-1, 0);
            this.crossword = crossword;
            this.ch = ch;
        }

        // ищем слудующий повтор, если нет - возвращаем null
        private Position findChar() {
            Position pos = null;
            search:
            for (int y = current.y; y < crossword.length; y++) {
                for (int x = current.x + 1; x < crossword[1].length; x++) {
                    if (crossword[y][x] == (int) ch) {
                        pos = new Position(0, 0);
                        pos.x = x;
                        pos.y = y;
                        current = pos;
                        break search;
                    }
                }
                current.x = -1;
            }
            return pos;
        }
    }

    private static class Position {
        int x = 0;
        int y = 0;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
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

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}

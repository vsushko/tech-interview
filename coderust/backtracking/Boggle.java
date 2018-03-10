package backtracking;

import common.Pair;

import java.util.*;

/**
 * Given an NxN grid of characters and a dictionary, find all words which can be made from
 * the characters in grid and present in the given dictionary. A word can start and end
 * at any character in the grid. Next character must be adjacent to previous character in
 * any of the directions i.e. up, down, left, right and diagonal. Character at each position
 * in grid can be used only once while making a word
 */
public class Boggle {

    private char[][] grid;
    private Set<String> dictionary;
    private boolean[][] state;

    public Boggle(char[][] grid, Set<String> dictionary) {
        this.grid = grid;
        this.dictionary = dictionary;
        state = new boolean[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                state[i][j] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'c', 'a', 't'},
                {'t', 'r', 'e'},
                {'t', 'o', 'n'}};
        Set<String> dictionary = new HashSet<>(Arrays.asList(
                "cat", "carter", "art", "toon", "moon", "not", "eat", "ton"));

        Boggle boggle = new Boggle(grid, dictionary);
        Set<String> words = boggle.findAllWords();
        for (String s : words) {
            System.out.print(s + " ");
        }
    }

    private List<Pair<Integer, Integer>> findAllNbrs(int x, int y) {
        List<Pair<Integer, Integer>> nbrs = new ArrayList<>();

        int startX = Math.max(0, x - 1);
        int startY = Math.max(0, y - 1);
        int endX = Math.min(grid.length - 1, x + 1);
        int endY = Math.min(grid.length - 1, y + 1);

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (state[i][j]) {
                    continue;
                }
                nbrs.add(new Pair<>(i, j));
            }
        }
        return nbrs;
    }

    private void findWordsRec(int i, int j, StringBuilder current, Set<String> words) {
        if (current.length() > 0 && dictionary.contains(current.toString())) {
            words.add(current.toString());
        }

        // we can really speed up our algorithm if we have prefix method available
        // for our dictionary by using code like below
        /*if (!dictionary.isPrefix(current)) {
            // if current word is not prefix of any word in dictionary
            // we don't need to continue with search
            return;
        }*/

        List<Pair<Integer, Integer>> nbrs = findAllNbrs(i, j);
        for (Pair<Integer, Integer> pair : nbrs) {
            current.append(grid[pair.first][pair.second]);
            state[pair.first][pair.second] = true;
            findWordsRec(pair.first, pair.second, current, words);
            current.setLength(current.length() - 1);
            state[pair.first][pair.second] = false;
        }
    }

    private Set<String> findAllWords() {
        Set<String> words = new HashSet<>();
        StringBuilder currentWord = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                findWordsRec(i, j, currentWord, words);
            }
        }
        return words;
    }
}

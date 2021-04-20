import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpellCheckerApp {


    static ObservableList<Word> data = FXCollections.observableArrayList();

    public static void main(String[] args) throws Exception {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter the Word: ");

        String checkWord = myObj.nextLine();  // Read user input
        correctWord(checkWord);
    }

    public static void correctWord(String inputWord) {
        if (inputWord == null || inputWord.trim().equals("")) {
            return;
        }
        long startTime = System.currentTimeMillis();
        SpellChecker spellChecker = new SpellChecker();
//        SpellChecker.setEditLimit(Integer.parseInt(comboEditDistance.getValue().toString()));
        LinkedHashMap<String, Integer> wordList = null;
        try {
            wordList = spellChecker.correct(inputWord);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        Logger.getLogger(SpellCheckerApp.class.getName()).log(Level.INFO, "Suggested " + " words in "
                + (System.currentTimeMillis() - startTime) + " ms");
        int count = 1;
        data.clear();
        for (String wordStr : wordList.keySet()) {
            Word word = new Word((count++) + "", wordStr, wordList.get(wordStr) + "");
            data.add(word);
            System.out.println(word.getWord());
        }
        System.out.println(data);
//        table.setItems(data);
    }
    
}

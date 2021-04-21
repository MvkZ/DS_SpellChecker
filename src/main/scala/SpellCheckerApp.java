import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.scene.control.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import scala.collection.immutable.List;


public class SpellCheckaderApp extends Application {

    VBox page;
    FXMLLoader fxmlLoader;
    private Button btnCorrect;
    private TextField txtInput;
    private ComboBox<?> comboEditDistance;

    private TableView<Word> table;
    private TableColumn<Word, String> clmSrNo;
    private TableColumn<Word, String> clmWord;
    private TableColumn<Word, String> clmDistance;

    private SpellCheckerAppController spellCheckerController;

    static ObservableList<Word> data = FXCollections.observableArrayList();

    static ObservableList<Word> final_data = FXCollections.observableArrayList();

    public void start(Stage primaryStage) {
        try {
            fxmlLoader = new FXMLLoader(SpellCheckerApp.class.getResource("SpellCheckerApp.fxml"));
            page = (VBox) fxmlLoader.load();
            spellCheckerController = (SpellCheckerAppController) fxmlLoader.getController();

            // get control instances.
            btnCorrect = spellCheckerController.getBtnCorrect();
            txtInput = spellCheckerController.getTxtInput();
            table = spellCheckerController.getTable();
            clmWord = spellCheckerController.getWord();

            // modifying table column
            clmWord.setCellValueFactory(new PropertyValueFactory<Word, String>("word"));

            // add event listener
            btnCorrect.setOnAction(e -> {
                        String answer_1 = "";
                        String answer_2 = "";
                        String answer_3 = "";
                        ArrayList<String> checkWords = new ArrayList<String>(Arrays.asList(txtInput.getText().split(" ")));
                        for (String word : checkWords) {
                            correctWord(word);
                            final_data.add(table.getItems().get(0));
                            answer_1 = answer_1 + table.getItems().get(0).getWord() + " ";
                            answer_2 = answer_2 + table.getItems().get(1).getWord() + " ";
                            answer_3 = answer_3 + table.getItems().get(2).getWord() + " ";
                        }
                        data.clear();
                        Word word = new Word( "", answer_1, "");
                        data.add(word);
                        word = new Word( "", answer_2, "");
                        data.add(word);
                        word = new Word( "", answer_3, "");
                        data.add(word);
                        table.setItems(data);
                    }
            );

            txtInput.setOnKeyPressed(keyEvent -> {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    String answer = "";
                    ArrayList<String> checkWords = new ArrayList<String>(Arrays.asList(txtInput.getText().split(" ")));
                    for (String word : checkWords) {
                        correctWord(word);
                        final_data.add(table.getItems().get(0));
                        answer = answer + table.getItems().get(0).getWord() + " ";
                    }
                    data.clear();
                    Word word = new Word( "", answer, "");
                    data.add(word);
                    table.setItems(data);
                }
//                correctWord(txtInput.getText());
            });

            // display GUI.
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Domain Specific Spell Checker");
            primaryStage.show();
            txtInput.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(SpellCheckerApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws Exception {
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter the Word: ");
//
//        String checkWord = myObj.nextLine();  // Read user input
//        List<String> checkWords = new ArrayList<String>(Arrays.asList(checkWord.split(" ")));
//        for (String word: checkWords) {
//            correctWord(word);
//        }
        Application.launch(SpellCheckerApp.class, (java.lang.String[]) null);
    }

    public void correctWord(String inputWord) {
        if (inputWord == null || inputWord.trim().equals("")) {
            return;
        }
        long startTime = System.currentTimeMillis();
        SpellChecker spellChecker = new SpellChecker();
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
//            System.out.println(word.getWord());
        }
        table.setItems(data);
    }

}

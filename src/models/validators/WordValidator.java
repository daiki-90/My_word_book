package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Word;


public class WordValidator {
    public static List<String> validate(Word w) {
        List<String> errors = new ArrayList<String>();

        String word_error = _validateTitle(w.getWord());
        if(!word_error.equals("")) {
            errors.add(word_error);
        }

        String content_error = _validateContent(w.getContent());
        if(!content_error.equals("")) {
            errors.add(content_error);
        }

        return errors;
    }

    private static String _validateTitle(String word) {
        if(word == null || word.equals("")) {
            return "タイトルを入力してください。";
            }

        return "";
    }

    private static String _validateContent(String content) {
        if(content == null || content.equals("")) {
            return "内容を入力してください。";
            }

        return "";
    }

}

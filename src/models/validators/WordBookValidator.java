package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.WordBook;

public class WordBookValidator {

    public static List<String> validate(WordBook w) {
        List<String> errors = new ArrayList<String>();

        String title_error = _validateTitle(w.getTitle());
        if(!title_error.equals("")) {
            errors.add(title_error);
        }

        String comment_error = _validateContent(w.getComment());
        if(!comment_error.equals("")) {
            errors.add(comment_error);
        }

        return errors;
    }

    private static String _validateTitle(String title) {
        if(title == null || title.equals("")) {
            return "タイトルを入力してください。";
            }

        return "";
    }

    private static String _validateContent(String comment) {
        if(comment == null || comment.equals("")) {
            return "内容を入力してください。";
            }

        return "";
    }
}



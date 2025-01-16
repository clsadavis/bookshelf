package com.aca.bookshelf.model;

import java.util.List;
import java.util.Scanner;

public class KeywordAssignment {

   private List<Keyword> keywords;
   private Scanner keywordName;

    public KeywordAssignment(){
        keywordName = new Scanner(System.in);
    }
    //select keyword based on num
    //select num based on keyword

    public static void main(String[] args) {
          new KeywordAssignment().run();
    }

    private void run() {
        getKeywords();
    }

    private void getKeywords() {
        String validInput;
        boolean valid = false;
//        do {
//            validInput = keywordName.nextLine();
//            validInput = validInput.toLowerCase();
//            switch (validInput){
//                case
//            }
//        }
    }


}

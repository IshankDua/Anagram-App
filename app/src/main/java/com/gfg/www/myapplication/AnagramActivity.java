package com.gfg.www.myapplication;

import java.util.Random;

public class AnagramActivity {

    public static final Random RANDOM = new Random();

    public static final String [] WORDS = {"ACCOUNT","ADDITION","AGREEMENT","ANGRY",
    "ANIMAL","BEHAVIOUR","BETWEEN","BLACK", "CHEMICAL","FOOLISH",
    "WEATHER","YESTERDAY"};

    public static String randomWord(){
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }

    public static String shuffleWord(String word){
        if (word != null && !"".equals(word)){
            char a[] = word.toCharArray();

            for (int i =0 ; i<a.length;i++){
                int j = RANDOM.nextInt(a.length);
                char tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;

            }
            return new String(a);
        }
return word;
    }

}

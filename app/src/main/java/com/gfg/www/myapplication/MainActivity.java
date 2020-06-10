package com.gfg.www.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView wordTv,justChecking;
    private EditText wordEnteredTv;
    private Button validate,newGame;
    private String wordToFind;
    private ImageButton hint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordTv = (TextView) findViewById(R.id.wordTv);
        wordEnteredTv = (EditText) findViewById(R.id.wordEnteredEt);
        validate = (Button) findViewById(R.id.validate);
        validate.setOnClickListener(this);
        newGame = (Button) findViewById(R.id.newGame);
        newGame.setOnClickListener(this);
        hint= (ImageButton) findViewById(R.id.hint);
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hint();

            }
        });

        justChecking = (TextView) findViewById(R.id.justchecking);

        newGame();
    }

    @Override
    public void onClick(View view) {
        if (view == validate){
            validate();
        }else if ( view == newGame){
            newGame();
        }
        }



    private void validate(){

        String w = wordEnteredTv.getText().toString();

        if (wordToFind.equals(w)){
            Toast.makeText(this, "Congratulations.. You got the Word", Toast.LENGTH_SHORT).show();
            newGame();
            Log.v("", "Your Word To Find is : "+wordToFind );


        }else {
            Toast.makeText(this, "Retry again", Toast.LENGTH_SHORT).show();
        }
    }
private void newGame(){
        wordToFind = AnagramActivity.randomWord();
        String wordShuffled = AnagramActivity.shuffleWord(wordToFind);
        wordTv.setText(wordShuffled);
        wordEnteredTv.setText("");
        justChecking.setEnabled(false);
        justChecking.setFocusable(false);



}

private void hint(){

        justChecking.setEnabled(true);
        justChecking.setText(wordToFind);
}

}

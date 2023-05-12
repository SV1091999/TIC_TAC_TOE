package com.example.assignment1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,Playagain;
    TextView headerText;
    int count = 0;

    int PLAYER_O = 1;
    int PLAYER_X = 2;

    int PlayerTurn = PLAYER_O;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        headerText = findViewById(R.id.Turn);
        headerText.setText("Player O turn");


        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        Playagain = findViewById(R.id.Play_again);
        Playagain.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        Playagain.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Button clickedBtn = findViewById(view.getId());
        count++;
        //handle on click for tiles
        if (clickedBtn.getText().toString().equals("")) {
            if (PlayerTurn == PLAYER_O) {
                clickedBtn.setText("O");
                PlayerTurn = PLAYER_X;
                headerText.setText("Player X Turn");
            } else {
                clickedBtn.setText("X");
                PlayerTurn = PLAYER_O;
                headerText.setText("Player O Turn");
            }
        }else{
            if(clickedBtn.getText().toString().equals("Play Again")){
                RestartGame();
            }
        }

        checkForWin();

    }

    private void RestartGame(){

        //finishes and reloads the current activity
        finish();
        startActivity(getIntent());
    }

    private void checkForWin() {


        String b1 = btn1.getText().toString();
        String b2 = btn2.getText().toString();
        String b3 = btn3.getText().toString();
        String b4 = btn4.getText().toString();
        String b5 = btn5.getText().toString();
        String b6 = btn6.getText().toString();
        String b7 = btn7.getText().toString();
        String b8 = btn8.getText().toString();
        String b9 = btn9.getText().toString();

        //boolean used at the end of this function to tell us whether the game has ended or not.
        boolean gameHasEnded = false;


            //horizontal winning condition
            if (b1.equals(b2) && b2.equals(b3) && !b1.equals("") ){
                Toast.makeText(this, "Winner is: " + b1, Toast.LENGTH_SHORT).show();
                endgame();
                gameHasEnded=true;
            }
            else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                Toast.makeText(this, "Winner is: " + b4, Toast.LENGTH_SHORT).show();
                endgame();
                gameHasEnded=true;
            }
            else if(b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                Toast.makeText(this, "Winner is: " + b7, Toast.LENGTH_SHORT).show();
                endgame();
                gameHasEnded=true;
            }

            //vertical winning condition
            else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                Toast.makeText(this, "Winner is: " + b1, Toast.LENGTH_LONG).show();
                endgame();
                gameHasEnded=true;
            }

            else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                Toast.makeText(this, "Winner is: " + b2, Toast.LENGTH_SHORT).show();
                endgame();
                gameHasEnded=true;
            }
            else if(b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                Toast.makeText(this, "Winner is: " + b3, Toast.LENGTH_SHORT).show();
                endgame();
                gameHasEnded=true;

            }

            //diagonal winning condition
            else if(b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                Toast.makeText(this,"Winner is: "+ b1,Toast.LENGTH_SHORT).show();
                endgame();
                gameHasEnded=true;
            }
            else if(b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                Toast.makeText(this,"Winner is: "+ b3,Toast.LENGTH_SHORT).show();
                endgame();
                gameHasEnded=true;
            }

            //Tie
            else if(count == 9) {
                Toast.makeText(this,"IT's A TIE: ",Toast.LENGTH_SHORT).show();
                gameHasEnded=true;
            }

            //toggle play again button visibility if game has ended.
        if(gameHasEnded==true){

            Playagain.setVisibility(View.VISIBLE);
        }


    }

    private void endgame() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);


    }



}
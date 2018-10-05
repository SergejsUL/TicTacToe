package ie.ul.serge.tictactoe;

import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TicTacToeGame mGame;
    private TextView mGameStateTextView;
    private Button [] mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGame = new TicTacToeGame(this);
        mGameStateTextView = findViewById(R.id.games_state_text_view);
        mButton = new Button[TicTacToeGame.NUM_SQUARES];
        mButton[0] = findViewById(R.id.button0);
        mButton[1] = findViewById(R.id.button1);
        mButton[2] = findViewById(R.id.button2);
        mButton[3] = findViewById(R.id.button3);
        mButton[4] = findViewById(R.id.button4);
        mButton[5] = findViewById(R.id.button5);
        mButton[6] = findViewById(R.id.button6);
        mButton[7] = findViewById(R.id.button7);
        mButton[8] = findViewById(R.id.button8);
        updateView();


    }

    public void pressSquare(View view) {
        String tagAsString = view.getTag().toString();
        int tagAsInt = Integer.parseInt(tagAsString);
        mGame.pressedButtonAtIndex(tagAsInt);
        updateView();

    }

    private void updateView() {
        mGameStateTextView.setText(mGame.stringForGameState());
        // TODO: Put and X or 0 on each of the buttons
        for (int i=0;i< TicTacToeGame.NUM_SQUARES;i++){
          mButton[i].setText(mGame.stringForButtonAtIndex(i));
        }
    }

    public void pressedNewGame(View view) {
        //Toast.makeText(this, "New Game", Toast.LENGTH_SHORT).show();
        mGame = new TicTacToeGame(this);
        updateView();


    }


}

package com.example.androidprojectcollection;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Match3Activity extends AppCompatActivity {
    private final Button[][] buttons = new Button[5][5];
    private int score = 0;
    private Button firstClickedButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match3act);

        TableLayout tblLayout = findViewById(R.id.tblLayout);
        for (int i = 0; i < 5; i++) {
            TableRow row = (TableRow) tblLayout.getChildAt(i);
            for (int j = 0; j < 5; j++) {
                buttons[i][j] = (Button) row.getChildAt(j);
                final int finalI = i;
                final int finalJ = j;
                buttons[i][j].setOnClickListener(v -> {
                    if (firstClickedButton == null) {
                        firstClickedButton = (Button) v;
                    } else {
                        swapTiles(buttons[finalI][finalJ], firstClickedButton);
                        firstClickedButton = null;
                        checkMatches();
                        updateUI();
                    }
                });
            }
        }
        Button restartButton = findViewById(R.id.btnRestart);
        restartButton.setOnClickListener(v -> {
            resetGame();
            updateUI();
        });

        resetGame();
        updateUI();
    }

    private void swapTiles(Button button1, Button button2) {
        int row1 = -1, col1 = -1, row2 = -1, col2 = -1;

        outerLoop:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (buttons[i][j] == button1) {
                    row1 = i;
                    col1 = j;
                }
                if (buttons[i][j] == button2) {
                    row2 = i;
                    col2 = j;
                }
                if (row1 != -1 && col1 != -1 && row2 != -1 && col2 != -1) {
                    break outerLoop;
                }
            }
        }

        if (Math.abs(row1 - row2) + Math.abs(col1 - col2) == 1) {
            if (Math.abs(row1 - row2) == 1 && col1 == col2 || Math.abs(col1 - col2) == 1 && row1 == row2) {
                int tempColor = getColorIndex(row1, col1);
                setColorIndex(row1, col1, getColorIndex(row2, col2));
                setColorIndex(row2, col2, tempColor);
            }
        }
    }

    private void checkMatches() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (getColorIndex(i, j) == getColorIndex(i, j + 1) && getColorIndex(i, j) == getColorIndex(i, j + 2)) {
                    setColorIndex(i, j, new Random().nextInt(4));
                    setColorIndex(i, j + 1, new Random().nextInt(4));
                    setColorIndex(i, j + 2, new Random().nextInt(4));
                    score++;
                }
            }
        }

        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 3; i++) {
                if (getColorIndex(i, j) == getColorIndex(i + 1, j) && getColorIndex(i, j) == getColorIndex(i + 2, j)) {
                    setColorIndex(i, j, new Random().nextInt(4));
                    setColorIndex(i + 1, j, new Random().nextInt(4));
                    setColorIndex(i + 2, j, new Random().nextInt(4));
                    score++;
                }
            }
        }
    }

    private void resetGame() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                setColorIndex(i, j, rand.nextInt(4));
            }
        }
        score = 0;
    }

    private void updateUI() {
        Toast toast = Toast.makeText(this, "Score: " + score, Toast.LENGTH_SHORT);

        int yOffset = 500;
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, yOffset);

        toast.show();
    }

    private int getColorIndex(int row, int col) {
        Object tag = buttons[row][col].getTag();
        return tag != null ? (int) tag : -1;
    }

    private void setColorIndex(int row, int col, int index) {
        buttons[row][col].setBackgroundColor(getColorForIndex(index));
        buttons[row][col].setTag(index);
    }

    private int getColorForIndex(int index) {
        switch (index) {
            case 0:
                return Color.RED;
            case 1:
                return Color.GREEN;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.YELLOW;
            default:
                return Color.WHITE;
        }
    }
}

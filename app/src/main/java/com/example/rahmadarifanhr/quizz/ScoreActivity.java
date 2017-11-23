package com.example.rahmadarifanhr.quizz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView score, username;
    Button btnMainLagi, btnPenjelasan;
    int totalScore;
    String namaPemain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        init();
        setView();
    }

    private void setView() {
        score.setText(getString(R.string.score) + " " + (totalScore*10));
        username.setText(namaPemain);

        btnMainLagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(ScoreActivity.this).setMessage(getString(R.string.main_lagi_text))
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(ScoreActivity.this, MainActivity.class));
                                finish();
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .show();
            }
        });

        btnPenjelasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScoreActivity.this, PenjelasanActivity.class).putExtra("jawaban", getIntent().getStringExtra("jawaban")));
            }
        });
    }

    private void init() {
        totalScore = getIntent().getIntExtra("score", 0);
        namaPemain = getIntent().getStringExtra("username");

        btnMainLagi = (Button) findViewById(R.id.btnMainLagi);
        btnPenjelasan = (Button) findViewById(R.id.btnPenjelasan);

        score = (TextView) findViewById(R.id.score);
        username = (TextView) findViewById(R.id.nama_pemain);
    }
}

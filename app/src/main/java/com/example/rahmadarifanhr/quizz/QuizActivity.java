package com.example.rahmadarifanhr.quizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static java.util.Arrays.asList;

public class QuizActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private QuizAdapter quizAdapter;
    private List<ListSoal> listSoals;
    private TextView input_soal, nomor_soal;
    private Button btn_next;
    private String username;
    private int i = 0, jawaban = -1, score = 0;
    private String tmpJawaban = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        init();
        addSoal();
        setView();
    }

    private void setView() {
        input_soal.setText(listSoals.get(i).getPertanyaan());
        quizAdapter = new QuizAdapter(listSoals.get(i).getPilihan_jawaban());
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(quizAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                quizAdapter.setPosition(position);
                btn_next.setBackgroundResource(R.color.color_pilih_jawaban);
                btn_next.setTextColor(getResources().getColor(android.R.color.white));
                btn_next.setClickable(true);
                btn_next.setEnabled(true);
                jawaban = position;
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmpJawaban += " " + String.valueOf(jawaban);
                if (jawaban == listSoals.get(i).getJawaban()) {
                    score++;
                }
                Log.v("tmp", String.valueOf(i) + " " + String.valueOf(listSoals.size()) + " " +String.valueOf(score));
                if (i == listSoals.size()-1) {
                    startActivity(new Intent(QuizActivity.this, ScoreActivity.class).putExtra("score", score).putExtra("username", username).putExtra("jawaban", tmpJawaban));
                    finish();
                } else {
                    i++;
                }
                btn_next.setBackgroundResource(R.drawable.background_button);
                btn_next.setTextColor(getResources().getColor(R.color.colorPrimary2));
                btn_next.setClickable(false);
                btn_next.setEnabled(false);
                nomor_soal.setText(String.valueOf(i + 1));
                input_soal.setText(listSoals.get(i).getPertanyaan());
                quizAdapter.setJawaban(listSoals.get(i).getPilihan_jawaban());
                quizAdapter.setPosition(-1);
            }
        });
    }

    private void init() {
        input_soal = (TextView) findViewById(R.id.input_soal);
        nomor_soal = (TextView) findViewById(R.id.nomor_soal);
        btn_next = (Button) findViewById(R.id.next_soal);
        listSoals = new ArrayList<>();
        username = getIntent().getStringExtra("username");
    }

    private void addSoal() {
        listSoals.add(new ListSoal("Pada tahun berapa Google mengakuisisi perusahaan Android Inc. ?", new ArrayList<>(asList("17 Agustus 1945", "17 Agustus 1995", "17 Agustus 2005", "17 Agustus 2010")), 2));
        listSoals.add(new ListSoal("Manakah yang bukan pendiri perusahaan Android Inc. ?", new ArrayList<>(asList("Larry Page", "Andy Rubin", "Rich Miner", "Chris White")), 0));
        listSoals.add(new ListSoal("Versi Android sangat terkenal dengan penamaan berdasarkan huruf abjad yaitu dimulai dari C sampai sekarang 0, apakah kepanjangan dari versi \"N\" ?", new ArrayList<>(asList("Nutella", "Nougat", "Noodle", "Nuts")), 1));
        listSoals.add(new ListSoal("Versi Android 4.0 adalah ?", new ArrayList<>(asList("Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich")), 3));
        listSoals.add(new ListSoal("Bahasa Pemrograman untuk membuat Aplikasi Android pada Android Studio adalah ?", new ArrayList<>(asList("Java", "Perl", "Python", "Php")), 0));
        listSoals.add(new ListSoal("Bahasa Pemrograman untuk membuat Tampilan Aplikasi Android pada Android Studio adalah ?", new ArrayList<>(asList("HTML", "CSS", "XML", "JSON")), 2));
        listSoals.add(new ListSoal("Yang bukan jenis Layout yang dapat digunakan untuk mendesain tampilan Android adalah ?", new ArrayList<>(asList("TabLayout", "LinearLayout", "BarLayout", "TableLayout")), 2));
        listSoals.add(new ListSoal("View yang paling tepat digunakan untuk menampilkan text adalah ?", new ArrayList<>(asList("Button", "EditText", "ComboBox", "TextView")), 3));
        listSoals.add(new ListSoal("Atribut pada XML untuk mengatur lebar tampilan adalah ?", new ArrayList<>(asList("layout_width", "layout_height", "layout_weight", "layout_length")), 0));
        listSoals.add(new ListSoal("Untuk membuat aplikasi pada Android Studio harus menggunakan SDK, apakah kepanjangan SDK ?", new ArrayList<>(asList("System Developer's Kit", "Software Development Kit", "Service Development Kit", " System Design Kit")), 1));
    }
}

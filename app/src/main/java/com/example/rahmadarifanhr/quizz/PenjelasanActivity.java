package com.example.rahmadarifanhr.quizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class PenjelasanActivity extends AppCompatActivity {
    private String tmpJawaban;
    private List<ListSoal> listSoals;
    private List<String> listSoal, listPenjelasan, listJawabanUser, listJawabanBenar, nomor_soal;
    private RecyclerView mRecyclerView;
    private PenjelasanAdapter penjelasanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjelasan);
        setTitle("Penjelasan");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tmpJawaban = getIntent().getStringExtra("jawaban");
//        Log.v("tmp", tmpJawaban);

        listSoals = new ArrayList<>();
        listSoal = new ArrayList<>();
        listPenjelasan = new ArrayList<>();
        listJawabanUser = new ArrayList<>();
        listJawabanBenar = new ArrayList<>();
        nomor_soal = new ArrayList<>();
        addSoal();
        String[] tmp = tmpJawaban.split(" ");
        for (int i = 1; i < tmp.length; i++){
            String jawaban;
            if (tmp[i].equals("0")){
                jawaban = "A";
            } else if (tmp[i].equals("1")){
                jawaban = "B";
            } else if (tmp[i].equals("2")){
                jawaban = "C";
            } else{
                jawaban = "D";
            }

            listJawabanUser.add(jawaban);
        }
        for (int i = 0 ; i < listSoals.size(); i++){
            nomor_soal.add(String.valueOf(i+1));
            listSoal.add(listSoals.get(i).getPertanyaan());
            String jawaban;
            if (listSoals.get(i).getJawaban() == 0){
                jawaban = "A";
            } else if (listSoals.get(i).getJawaban() == 1) {
                jawaban = "B";
            } else if(listSoals.get(i).getJawaban() == 2){
                jawaban = "C";
            } else {
                jawaban = "D";
            }
            listJawabanBenar.add(jawaban);
        }

        penjelasanAdapter = new PenjelasanAdapter(nomor_soal, listSoal, listPenjelasan, listJawabanUser, listJawabanBenar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(penjelasanAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
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
        listPenjelasan.add("Pada awalnya yaitu Oktober 2003 sistem operasi Android dikembangkan oleh Android Inc, namun pada 17 Agustus 2005 Google mengakuisisi Android Inc yang menjadikannya sebagai anak perusajaan Google sepenuhnya");
        listPenjelasan.add("Android Inc didirikan di Palo Alto, California oleh Andy Rubin, Rich Miner, Nick Sears, dan Chris White. Sedangkan Larry Page adalah penemu dari Google");
        listPenjelasan.add("C = Cupcake, D = Donut, E = Eclair, F = Froyo, G = Gingerbread, I = Ice Cream Sandwich, J = Jelly Bean, K = KitKat, L = Lollipop, M = Marshmallow, N = Nougat");
        listPenjelasan.add("1.5 = C, 1.6 = D, 2.0 = E, 2.2 = F, 2.3 = G, 3.1 = H, 4.0 = I, 4.1 = J, 4.4 = K, 5.x = L, 6.0 = M, 7.0 = N");
        listPenjelasan.add("Bahasa yang digunakan untuk membuat aplikasi Android pada Android Studio adalah Java");
        listPenjelasan.add("Bahasa markup untuk membuat tampilan aplikasi android pada Android Studio adalah XML");
        listPenjelasan.add("Jenis Layout pada Android adalah LinearLayout, RelativeLayout, TableLayout, GridView, TabLayout, dan Listview");
        listPenjelasan.add("Button digunakan untuk membuat tombol, EditText digunakan untuk membuat inputan, ComboBox digunakan untuk membuat pilihan, TextView digunakan  untuk menampilkan Text");
        listPenjelasan.add("layout_width untuk mengatur lebar, layout_height untuk mengatur tinggi, layout_weight untuk membagi layar, layout_length tidak ada");
        listPenjelasan.add("SDK adalah singkatan dari Software Development Kit");

    }
}

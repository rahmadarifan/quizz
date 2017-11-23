package com.example.rahmadarifanhr.quizz;

import java.util.List;

/**
 * Created by Rahmad Arifan Hr on 8/12/2017.
 */

public class ListSoal {
    private String pertanyaan;
    private List<String> pilihan_jawaban;
    private int jawaban;
    ListSoal(String pertanyaan, List<String> pilihan_jawaban, int jawaban){
        this.setPertanyaan(pertanyaan);
        this.setPilihan_jawaban(pilihan_jawaban);
        this.setJawaban(jawaban);
    }


    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public List<String> getPilihan_jawaban() {
        return pilihan_jawaban;
    }

    public void setPilihan_jawaban(List<String> pilihan_jawaban) {
        this.pilihan_jawaban = pilihan_jawaban;
    }

    public int getJawaban() {
        return jawaban;
    }

    public void setJawaban(int jawaban) {
        this.jawaban = jawaban;
    }
}

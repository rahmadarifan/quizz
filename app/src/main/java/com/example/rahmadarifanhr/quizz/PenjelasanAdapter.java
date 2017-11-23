package com.example.rahmadarifanhr.quizz;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rahmad Arifan Hr on 8/12/2017.
 */

public class PenjelasanAdapter extends RecyclerView.Adapter<PenjelasanAdapter.PenjelasanViewHolder> {

    private List<String> listSoal, listPenjelasan, jawabanUser, jawabanBenar, nomor_soal;
    private Context context;
    public class PenjelasanViewHolder extends RecyclerView.ViewHolder {
        public TextView nomor, soal, penjelasan, jawaban_user, jawaban_benar;

        public PenjelasanViewHolder(View view) {
            super(view);
            context = view.getContext();
            nomor = (TextView) view.findViewById(R.id.nomor_soal_penjelasan);
            soal = (TextView) view.findViewById(R.id.pertanyaan);
            penjelasan = (TextView) view.findViewById(R.id.penjelasan);
            jawaban_user = (TextView) view.findViewById(R.id.jawaban_user);
            jawaban_benar = (TextView) view.findViewById(R.id.jawaban_sebenarnya);
        }
    }

    public PenjelasanAdapter(List<String> nomor_soal, List<String> listSoal, List<String> listPenjelasan, List<String> jawabanUser, List<String> jawabanBenar) {
        this.nomor_soal = nomor_soal;
        this.listSoal = listSoal;
        this.listPenjelasan = listPenjelasan;
        this.jawabanUser = jawabanUser;
        this.jawabanBenar = jawabanBenar;
    }

    @Override
    public PenjelasanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_penjelasan, parent, false);

        return new PenjelasanViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PenjelasanViewHolder holder, int position) {
        holder.nomor.setText(nomor_soal.get(position));
        holder.soal.setText(listSoal.get(position));
        holder.penjelasan.setText(listPenjelasan.get(position));
        holder.jawaban_user.setText(context.getString(R.string.jawaban_anda) + " " + jawabanUser.get(position));
        holder.jawaban_benar.setText(context.getString(R.string.jawaban_benar) + " " +jawabanBenar.get(position));
    }

    @Override
    public int getItemCount() {
        return listSoal.size();
    }
}

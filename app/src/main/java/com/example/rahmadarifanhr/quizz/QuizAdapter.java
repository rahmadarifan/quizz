package com.example.rahmadarifanhr.quizz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rahmad Arifan Hr on 8/12/2017.
 */

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {

    List<String> list_text_jawaban, list_pilihan_jawaban;
    public int  selected_item = -1;
    private Context context;
    public void setPosition(int position) {
        this.selected_item = position;
        notifyDataSetChanged();
    }

    public class QuizViewHolder extends RecyclerView.ViewHolder {
        TextView text_jawaban, text_pilihan;
//        LinearLayout jawaban;
        public QuizViewHolder(View view) {
            super(view);
            text_jawaban = (TextView) view.findViewById(R.id.text_jawaban);
            text_pilihan = (TextView) view.findViewById(R.id.pilihan_jawaban);
            context = view.getContext();
//            jawaban = (LinearLayout)view.findViewById(R.id.jawaban);
        }
    }

    public QuizAdapter(List<String> list_text_jawaban) {
        this.list_text_jawaban = list_text_jawaban;
        list_pilihan_jawaban = new ArrayList<>();
        list_pilihan_jawaban.add("A");
        list_pilihan_jawaban.add("B");
        list_pilihan_jawaban.add("C");
        list_pilihan_jawaban.add("D");
    }

    public void setJawaban(List<String> list_text_jawaban){
        this.list_text_jawaban = list_text_jawaban;
        notifyDataSetChanged();
    }

    @Override
    public QuizViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_jawaban, parent, false);
        return new QuizViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final QuizViewHolder holder, int position) {
        if (selected_item == position){
            holder.text_pilihan.setBackgroundColor(context.getResources().getColor(R.color.color_pilih_jawaban));
            holder.text_jawaban.setTextColor(context.getResources().getColor(R.color.color_pilih_jawaban));
        } else {
            holder.text_pilihan.setBackgroundColor(context.getResources().getColor(R.color.color_quiz));
            holder.text_jawaban.setTextColor(context.getResources().getColor(R.color.color_quiz));
        }
        holder.text_pilihan.setText(list_pilihan_jawaban.get(position));
        holder.text_jawaban.setText(list_text_jawaban.get(position));
    }

    @Override
    public int getItemCount() {
        return list_text_jawaban.size();
    }
}
package com.example.flixnet.adaptadores;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flixnet.modelos.Serie;

import java.util.List;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesHolder> {

    private List<Serie> series;


    public SeriesAdapter(List<Serie> list) {
        series = list;
    }

    @NonNull
    @Override
    public SeriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesHolder holder, int position) {

    }

    /**
     *
     * @return el numero de items que tiene la lista
     */
    @Override
    public int getItemCount() {
        return series.size();
    }

    public class SeriesHolder extends RecyclerView.ViewHolder{
        public SeriesHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

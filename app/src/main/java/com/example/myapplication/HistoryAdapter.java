package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private List<HistoryEntry> historyList;

    public HistoryAdapter(List<HistoryEntry> historyList) {
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HistoryEntry historyEntry = historyList.get(position);

        holder.name.setText("Name : "+historyEntry.getYourName());
        holder.nakshatra.setText("Nakshatra : "+historyEntry.getNakshatra());
        holder.rashi.setText("Rashi : "+historyEntry.getRashi());
        holder.selectedoption.setText("Time :" + historyEntry.getSelectedOption());
        holder.selecteddate.setText(historyEntry.getSelectedDate());
        holder.pooja_name.setText(historyEntry.getPoojaname());
        holder.price.setText(historyEntry.getPrice());
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nakshatra;
        TextView rashi;
        TextView selectedoption;
        TextView selecteddate;
        TextView name;

        TextView pooja_name;

        TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.historyname);
            nakshatra= itemView.findViewById(R.id.historynakshatra);
            rashi = itemView.findViewById(R.id.historyrashi);
            selectedoption = itemView.findViewById(R.id.historyoption);
            selecteddate = itemView.findViewById(R.id.historydateoption);
            pooja_name = itemView.findViewById(R.id.poojaname);
            price = itemView.findViewById(R.id.historyprice);
        }
    }
}

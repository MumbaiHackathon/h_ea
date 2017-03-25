package com.example.dhana.eventadda;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chavan on 25-03-2017.
 */

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.MyViewHolder> {
     ArrayList<String> eventTitleList = new ArrayList<>();
    ArrayList<String> eventTitleDate = new ArrayList<>();
    ArrayList<String> location = new ArrayList<>();
    ArrayList<String> teamSize = new ArrayList<>();
    ArrayList<String> details = new ArrayList<>();
    ArrayList<String> times = new ArrayList<>();
    public EventListAdapter(ArrayList<String> eventTitleList, ArrayList<String> eventTitleDate, ArrayList<String> location, ArrayList<String> teamSize, ArrayList<String> details, ArrayList<String> times) {
        this.eventTitleList = eventTitleList;
        this.eventTitleDate = eventTitleDate;
        this.location = location;
        this.teamSize = teamSize;
        this.details = details;
        this.times = times;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singleevent, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.txtTitlev.setText(eventTitleList.get(position));
        holder.txtDescv.setText(eventTitleDate.get(position));
    }

    @Override
    public int getItemCount() {
        return eventTitleList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitlev, txtDescv;

        public MyViewHolder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(itemView.getContext(), viewEvent.class);
                    intent.putExtra("titles", eventTitleList.get(getAdapterPosition()));
                    intent.putExtra("dates", eventTitleDate);
                    intent.putExtra("times", times);
                    intent.putExtra("time", times);
                    intent.putExtra("details", details);
                    intent.putExtra("teamsizes", teamSize);
                    intent.putExtra("locations", location);

                }
            });
            txtTitlev = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDescv = (TextView) itemView.findViewById(R.id.txtDesc);
        }
    }
}

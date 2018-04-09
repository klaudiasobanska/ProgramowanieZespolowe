package com.example.programowaniezespolowe;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder> {

    private List<String> mToDoListAdapter;

    public ToDoAdapter(List<String> toDoListAdapter) {
        this.mToDoListAdapter = toDoListAdapter;
    }


    @Override
    public ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.to_do_list_row, parent, false);

        return new ToDoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ToDoViewHolder holder, int position) {
        holder.miniTask.setText(mToDoListAdapter.get(position));
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return mToDoListAdapter.size();
    }


    public class ToDoViewHolder extends RecyclerView.ViewHolder {
        public TextView miniTask;
        public int position;

        public ToDoViewHolder(View view) {
            super(view);
            miniTask = (TextView) view.findViewById(R.id.miniTask);
        }


    }
}

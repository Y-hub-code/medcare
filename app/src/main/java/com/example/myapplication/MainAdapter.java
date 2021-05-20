package com.example.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter  extends RecyclerView.Adapter<MainAdapter.viewHolder> {ArrayList<MainModel> mainModels;
    Context context;
    public MainAdapter(Context context,ArrayList<MainModel> mainModels){
        this.context=context;
        this.mainModels=mainModels;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creat view
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        //set logo to imageView
        holder.imageView.setImageResource(mainModels.get(position).getCategorieLogo());
        //set name to text view
        holder.textView.setText(mainModels.get(position).getCategorieName());
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        //initialize variable
        ImageView imageView;
        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            //assign variable
            imageView=itemView.findViewById(R.id.image_view);
            textView=itemView.findViewById(R.id.text_view);
        }
    }
}

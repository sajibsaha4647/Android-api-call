package com.example.apicallwithretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.TintableCheckedTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apicallwithretrofit.Model.Getposts;
import com.example.apicallwithretrofit.R;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.Myviewholder> {

    Context context;
    ArrayList<Getposts>getpostsArrayList;

    public PostAdapter(Context context, ArrayList<Getposts> getpostsArrayList) {
        this.context = context;
        this.getpostsArrayList = getpostsArrayList;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //create view here

        View v = LayoutInflater.from(context).inflate(R.layout.sample_view,parent,false);

        return new Myviewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) { //set view here

        Getposts getposts = getpostsArrayList.get(position);

        holder.textViewNumber.setText(String.valueOf(getposts.getUserId()));
        holder.textViewText.setText(getposts.getTitle());

    }

    @Override
    public int getItemCount() { //view length
        return getpostsArrayList.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder { //here find view and some functoins

        TextView textViewNumber,textViewText;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);

            textViewNumber = itemView.findViewById(R.id.numberid);
            textViewText = itemView.findViewById(R.id.titleid);


        }
    }
}

package com.example.oblig1dat153.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.oblig1dat153.R;
import com.example.oblig1dat153.model.Animal;
import com.example.oblig1dat153.model.AnimalList;
import com.example.oblig1dat153.utils.QuizUtils;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Animal> animals;

    public MyAdapter(List<Animal> animals) {
        this.animals = animals;
    }

    // 3- Implementing the Methods
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.recyclerview_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Animal animal = animals.get(position);
        holder.name_textView.setText(animal.getName());

        QuizUtils.insertToImageView(
                animal.getImage(),
                holder.imageView,
                holder.getmTextViewContext()
        );


        // not needed but i remoces an unexplained error
        int index = position;
        holder.delete_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimalList.getInstance().deleteAnimal(index);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name_textView;
        TextView delete_textView;
        View mTextView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.name_textView = itemView.findViewById(R.id.textview);
            this.delete_textView = itemView.findViewById(R.id.delete);
            mTextView = itemView;
        }

        void bindImage(Uri imageUri) {
            Glide.with(itemView.getContext())
                    .load(imageUri)
                    .into(imageView);
        }

        public Context getmTextViewContext() {
            return mTextView.getContext();
        }
    }
}

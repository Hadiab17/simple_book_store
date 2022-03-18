package com.hadiabbasi.practice.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hadiabbasi.practice.BookDetailActivity;
import com.hadiabbasi.practice.Model.BookModel;
import com.hadiabbasi.practice.R;

import java.util.ArrayList;

public class VoiceBookAdapter extends RecyclerView.Adapter<VoiceBookAdapter.MyViewHolder> {

    private ArrayList<BookModel> book = new ArrayList<>();
    private Context context;

    public VoiceBookAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.voice_book_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.setData();
    }

    @Override
    public int getItemCount() {
        return book.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView voice_image_item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //initViews
            initViews();
        }

        private void initViews(){
            voice_image_item = itemView.findViewById(R.id.voice_image_item);
        }

        //set data for each recyclerView item
        private  void setData() {
            Glide.with(context)
                    .asBitmap()
                    .load(book.get(getAdapterPosition()).getImageUrl())
                    .into(voice_image_item);

            voice_image_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BookDetailActivity.class);
                    intent.putExtra("voice" , true);
                    intent.putExtra("book_name",book.get(getAdapterPosition()).getBookName());
                    intent.putExtra("author_name", book.get(getAdapterPosition()).getAuthorName());
                    intent.putExtra("image_url",book.get(getAdapterPosition()).getImageUrl());
                    context.startActivity(intent);
                }
            });
        }
    }

    //set data from activity
    public void setBook(ArrayList<BookModel> book){
        this.book = book;
    }
}

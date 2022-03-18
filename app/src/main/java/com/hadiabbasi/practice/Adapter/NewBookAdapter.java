package com.hadiabbasi.practice.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hadiabbasi.practice.BookDetailActivity;
import com.hadiabbasi.practice.Model.BookModel;
import com.hadiabbasi.practice.R;

import java.util.ArrayList;

public class NewBookAdapter extends RecyclerView.Adapter<NewBookAdapter.MyViewHolder> {

    private ArrayList<BookModel> book = new ArrayList<>();
    private Context context;

    public NewBookAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_book_item, parent, false);
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

        private RelativeLayout new_book_item;
        private ImageView new_book_image;
        private TextView new_book_name, new_book_author;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //initViews
            initViews();
        }

        private void initViews(){
            new_book_item = itemView.findViewById(R.id.new_book_item);
            new_book_image = itemView.findViewById(R.id.new_book_image);
            new_book_name = itemView.findViewById(R.id.new_book_name);
            new_book_author = itemView.findViewById(R.id.new_book_author);
        }

        //set data for each recyclerView item
        private void setData() {
            Glide.with(context)
                    .asBitmap()
                    .load(book.get(getAdapterPosition()).getImageUrl())
                    .into(new_book_image);
            new_book_name.setText(book.get(getAdapterPosition()).getBookName());
            new_book_author.setText(book.get(getAdapterPosition()).getAuthorName());

            new_book_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BookDetailActivity.class);
                    intent.putExtra("book_name",book.get(getAdapterPosition()).getBookName());
                    intent.putExtra("author_name", book.get(getAdapterPosition()).getAuthorName());
                    intent.putExtra("image_url",book.get(getAdapterPosition()).getImageUrl());
                    context.startActivity(intent);
                }
            });
        }
    }

    //set book from activity
    public void setBook(ArrayList<BookModel> book){
        this.book = book;
    }
}

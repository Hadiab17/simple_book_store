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

public class ForYouBookAdapter extends RecyclerView.Adapter<ForYouBookAdapter.MyViewHolder> {

    private ArrayList<BookModel> book = new ArrayList<>();
    private Context context;

    public ForYouBookAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.for_you_book_item, parent, false);
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

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout for_you_book_item;
        private ImageView card_image;
        private TextView book_Name, author_Name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //initViews
            initViews();
        }

        //set data on each recyclerView items
        private void setData() {
            Glide.with(context)
                    .asBitmap()
                    .load(book.get(getAdapterPosition()).getImageUrl())
                    .into(card_image);
            book_Name.setText(book.get(getAdapterPosition()).getBookName());
            author_Name.setText(book.get(getAdapterPosition()).getAuthorName());

            for_you_book_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BookDetailActivity.class);
                    intent.putExtra("book_name", book.get(getAdapterPosition()).getBookName().toString());
                    intent.putExtra("author_name", book.get(getAdapterPosition()).getAuthorName().toString());
                    intent.putExtra("image_url", book.get(getAdapterPosition()).getImageUrl().toString());
                    context.startActivity(intent);
                }
            });
        }

        private void initViews() {
            for_you_book_item = itemView.findViewById(R.id.for_you_book_item);
            card_image = itemView.findViewById(R.id.card_image);
            book_Name = itemView.findViewById(R.id.book_Name);
            author_Name = itemView.findViewById(R.id.author_Name);
        }
    }

    //set book from activity
    public void setBook(ArrayList<BookModel> book) {
        this.book = book;
    }
}

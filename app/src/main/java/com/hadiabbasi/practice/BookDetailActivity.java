package com.hadiabbasi.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.hadiabbasi.practice.Adapter.ForYouBookAdapter;
import com.hadiabbasi.practice.Model.BookModel;

import java.util.ArrayList;

public class BookDetailActivity extends AppCompatActivity {

    private ImageView detail_book_image, forward_back;
    private Button listen_demo, buy_btn;
    private TextView detail_book_name, book_name, book_author;
    private Bundle bundle;
    private ArrayList<BookModel> forYouBook = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);


        //initViews
        initViews();

        //set on click listener for back button in action bar
        forward_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



        //get data from intent
        bundle = getIntent().getExtras();

        if(bundle.getBoolean("voice")){
            listen_demo.setVisibility(View.VISIBLE);
        }

        //set data on elements
        detail_book_name.setText(bundle.getString("book_name"));
        book_name.setText(bundle.getString("book_name"));
        book_author.setText(bundle.getString("author_name"));
        Glide.with(BookDetailActivity.this)
                .asBitmap()
                .load(bundle.getString("image_url"))
                .into(detail_book_image);


        //bottom sheet
        buy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(BookDetailActivity.this, R.style.bottom_sheet_style);

                //view
                View bottom_sheet_layout = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet, null);

                TextView name = bottom_sheet_layout.findViewById(R.id.name);
                TextView author = bottom_sheet_layout.findViewById(R.id.author_book_name);
                ImageView image = bottom_sheet_layout.findViewById(R.id.image);
                RecyclerView for_you_rec = bottom_sheet_layout.findViewById(R.id.for_you_rec);



                //prepare adapter for recyclerView
                ForYouBookAdapter forYouBookAdapter = new ForYouBookAdapter(BookDetailActivity.this);
                forYouBookAdapter.setBook(forYouRecData());

                //set adapter for recyclerView
                for_you_rec.setAdapter(forYouBookAdapter);
                for_you_rec.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false));


                //set data on bottom sheet dialog
                name.setText(bundle.getString("book_name"));
                author.setText(bundle.getString("author_name"));
                Glide.with(BookDetailActivity.this)
                        .asBitmap()
                        .load(bundle.getString("image_url"))
                        .into(image);

                bottomSheetDialog.setContentView(bottom_sheet_layout);
                bottomSheetDialog.show();
            }
        });


    }

    private ArrayList<BookModel> forYouRecData(){
        forYouBook.add(new BookModel("دو قدم تا لبخند", "سلماز بهگام", "https://cdn.fidibo.com/images/books/124189_25724_normal.jpg"));
        forYouBook.add(new BookModel("ارغوانی ها", " عباس براتی پور", "https://cdn.fidibo.com/images/books/125495_44644_normal.jpg"));
        forYouBook.add(new BookModel("سالمندی موفق", " مینا صفری", "https://cdn.fidibo.com/images/books/125373_68846_normal.jpg"));
        forYouBook.add(new BookModel("انسانِ بِهتر ", "مهدی قراچه داغی", "https://cdn.fidibo.com/images/books/125327_17451_normal.jpg"));
        return forYouBook;
    }

    private void initViews(){
        listen_demo = findViewById(R.id.listen_demo);
        forward_back = findViewById(R.id.forward_back);
        detail_book_image = findViewById(R.id.detail_book_image);
        detail_book_name = findViewById(R.id.detail_book_name);
        book_name = findViewById(R.id.book_name);
        book_author = findViewById(R.id.book_author);
        buy_btn = findViewById(R.id.buy_btn);
    }
}
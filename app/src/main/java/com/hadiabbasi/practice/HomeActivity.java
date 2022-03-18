package com.hadiabbasi.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.hadiabbasi.practice.Adapter.FavBookAdapter;
import com.hadiabbasi.practice.Adapter.NewBookAdapter;
import com.hadiabbasi.practice.Adapter.VoiceBookAdapter;
import com.hadiabbasi.practice.Model.BookModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ImageView menu;

    private DrawerLayout drawerLayout;

    private RecyclerView fav_rec;

    private RecyclerView voice_rec;

    private RecyclerView new_rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //initViews
        initViews();

        //init items in fav recyclerView
        initFavRec();


        //init items in voice recyclerView
        initVoiceRec();


        //init items in new recyclerView
        initNewRec();


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else{
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

    }

    private ArrayList<BookModel>newRecData(){
        ArrayList<BookModel> new_array = new ArrayList<>();
        new_array.add(new BookModel("دو قدم تا لبخند", "سلماز بهگام", "https://cdn.fidibo.com/images/books/124189_25724_normal.jpg"));
        new_array.add(new BookModel("ارغوانی ها", " عباس براتی پور", "https://cdn.fidibo.com/images/books/125495_44644_normal.jpg"));
        new_array.add(new BookModel("سالمندی موفق", " مینا صفری", "https://cdn.fidibo.com/images/books/125373_68846_normal.jpg"));
        new_array.add(new BookModel("انسانِ بِهتر ", "مهدی قراچه داغی", "https://cdn.fidibo.com/images/books/125327_17451_normal.jpg"));
        new_array.add(new BookModel("ارغوانی ها", " عباس براتی پور", "https://cdn.fidibo.com/images/books/125495_44644_normal.jpg"));
        new_array.add(new BookModel("سالمندی موفق", " مینا صفری", "https://cdn.fidibo.com/images/books/125373_68846_normal.jpg"));
        new_array.add(new BookModel("انسانِ بِهتر ", "مهدی قراچه داغی", "https://cdn.fidibo.com/images/books/125327_17451_normal.jpg"));
        new_array.add(new BookModel("دو قدم تا لبخند", "سلماز بهگام", "https://cdn.fidibo.com/images/books/124189_25724_normal.jpg"));
        new_array.add(new BookModel("ارغوانی ها", " عباس براتی پور", "https://cdn.fidibo.com/images/books/125495_44644_normal.jpg"));
        return new_array;
    }

    private void initNewRec(){
        NewBookAdapter newAdapter = new NewBookAdapter(this);
        newAdapter.setBook(newRecData());
        new_rec.setAdapter(newAdapter);
        new_rec.setLayoutManager(new GridLayoutManager(this,3));
    }

    private ArrayList<BookModel> voiceRecData(){
        ArrayList<BookModel> voice_array = new ArrayList<>();
        voice_array.add(new BookModel("کتاب صوتی مرگ ایوان ایلیچ"," لئو تولستوی","https://fidibo.com/images/books/square/84501_82235_normal.jpg"));
        voice_array.add(new BookModel("تفکر نامطمئن"," آنی دوک","https://cdn.fidibo.com/images/books/122179_47838_normal.jpg"));
        voice_array.add(new BookModel("چرا ملتها شکست میخورند؟"," جیمزای. رابینسون","https://cdn.fidibo.com/images/books/63289_46931_normal.jpg"));
        return voice_array;
    }

    private void initVoiceRec(){
        VoiceBookAdapter voiceAdapter = new VoiceBookAdapter(this);
        voiceAdapter.setBook(voiceRecData());
        voice_rec.setAdapter(voiceAdapter);
        voice_rec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private ArrayList<BookModel> favRecData(){
        ArrayList<BookModel> fav_array = new ArrayList<>();
        fav_array.add(new BookModel("دو قدم تا لبخند", "سلماز بهگام", "https://cdn.fidibo.com/images/books/124189_25724_normal.jpg"));
        fav_array.add(new BookModel("ارغوانی ها", " عباس براتی پور", "https://cdn.fidibo.com/images/books/125495_44644_normal.jpg"));
        fav_array.add(new BookModel("سالمندی موفق", " مینا صفری", "https://cdn.fidibo.com/images/books/125373_68846_normal.jpg"));
        fav_array.add(new BookModel("انسانِ بِهتر ", "مهدی قراچه داغی", "https://cdn.fidibo.com/images/books/125327_17451_normal.jpg"));
        return fav_array;
    }

    private void initFavRec(){


        FavBookAdapter favAdapter = new FavBookAdapter(this);
        favAdapter.setBook(favRecData());

        fav_rec.setAdapter(favAdapter);
        fav_rec.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void initViews(){
        drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.menu);
        fav_rec = findViewById(R.id.fav_rec);
        voice_rec = findViewById(R.id.voice_rec);
        new_rec = findViewById(R.id.new_rec);
    }



}
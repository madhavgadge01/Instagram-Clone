package com.example.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.instagram.data.Post;
import com.example.instagram.data.Story;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;
import adapters.postAdapter;
import adapters.storyAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView storyRecyclerView;
    private RecyclerView postRecyclerView;
    private List<Story> storyList;
    private List<Post> postList;
    private BottomNavigationView bottomNavigationView;
    ImageView homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupRecyclerViews();
        loadDummyData();
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        bottomNavigationView.setItemBackgroundResource(android.R.color.transparent);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else if (id == R.id.search) {
                Intent intent = new Intent(this, explorerActivity.class);
                startActivity(intent);}
               else if (id == R.id.reels) {
                Intent intent = new Intent(this, ReelActivity.class);
                startActivity(intent);}
              else if (id == R.id.profile_image) {
              Intent intent = new Intent(this, profileActivity.class);
                            startActivity(intent);}
            return true;
        });
    }

    private void initializeViews() {
//        Toast.makeText(this,"Created by Madhav",Toast.LENGTH_SHORT).show();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        storyRecyclerView = findViewById(R.id.divider);
        postRecyclerView = findViewById(R.id.single_post);
        storyList = new ArrayList<>();
        postList = new ArrayList<>();
    }



    private void setupRecyclerViews() {

        storyAdapter storyAdapter = new storyAdapter(storyList, this);
        storyRecyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );
        storyRecyclerView.setAdapter(storyAdapter);

        postAdapter postAdapter = new postAdapter(postList, this);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        postRecyclerView.setAdapter(postAdapter);
    }

    private void loadDummyData() {
        storyList.add(new Story(20, "You", R.drawable.mdvprofile));
        storyList.add(new Story(21, "Aachal", R.drawable.story13));
        storyList.add(new Story(22, "dipti", R.drawable.story11));
        storyList.add(new Story(23, "shreya", R.drawable.story33));
        storyList.add(new Story(24, "tanisha r.", R.drawable.ppost4));
        storyList.add(new Story(25, "nitish", R.drawable.story20));
        storyList.add(new Story(26, "prakash", R.drawable.stroy21));
        storyList.add(new Story(27, "Gopal", R.drawable.story17));
        storyList.add(new Story(28, "karun", R.drawable.pmpost3));
        storyList.add(new Story(29, "keshav", R.drawable.story19));
        storyList.add(new Story(31, "shreya", R.drawable.ppost6));
        storyList.add(new Story(37, "sanya", R.drawable.ppost1));
        storyList.add(new Story(32, "deepti", R.drawable.ppost9));

        postList.add(new Post(1, R.drawable.ppost9, R.drawable.post4, "mera music sunete rahna 😇", "104 likes", "view all 52 comments", "Dhavni raj"));
        postList.add(new Post(2, R.drawable.ppost5, R.drawable.post3, "Banaras to indore 😱", "72 likes", "view all 5 comments", "Nidhi Tiwari"));
        postList.add(new Post(3, R.drawable.ppost6, R.drawable.story34, "janlo ke upar... 😅", "45 likes", "view all 2 comments", "anaya"));
        postList.add(new Post(4, R.drawable.story28, R.drawable.post9, "ready for dance", "133 likes", "view all 17 comments", "priya gadge"));
        postList.add(new Post(5, R.drawable.ppost7, R.drawable.ppost2, "first day of office 😎", "233 likes", "view all 59 comments", "Aanchal chaoudhry"));
        postList.add(new Post(6, R.drawable.pmpost2, R.drawable.post1, "My loved one me ❤️", "176 likes", "view all 122 comments", "keshav gadge"));
        postList.add(new Post(7, R.drawable.ppost8, R.drawable.post7, "apnu ki bike guru 🥳", "456 likes", "view all 70 comments", "angli soni"));
        postList.add(new Post(8, R.drawable.story20, R.drawable.story17, "the firt date 💌", "1760 likes", "view all 17 comments", "aadiya"));
    }

}

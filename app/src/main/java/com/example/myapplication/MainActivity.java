 package com.example.myapplication;


 import androidx.appcompat.app.AppCompatActivity;
 import androidx.appcompat.widget.SearchView;
 import androidx.fragment.app.Fragment;
 import androidx.recyclerview.widget.DefaultItemAnimator;
 import androidx.recyclerview.widget.LinearLayoutManager;
 import androidx.recyclerview.widget.RecyclerView;

 import android.content.Context;
 import android.content.Intent;
 import android.content.res.Resources;
 import android.os.Bundle;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.ArrayAdapter;
 import android.widget.Button;
 import android.widget.ImageButton;
 import android.widget.ImageView;
 import android.widget.ListView;
 import android.widget.TextView;
 import android.widget.Toast;

 import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

 import java.util.ArrayList;
 import java.util.zip.Inflater;


 public class MainActivity extends AppCompatActivity {
     //initialize variabl
     MeowBottomNavigation bottomNavigation;
     Toast toast;

     @Override
     public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         bottomNavigation = (MeowBottomNavigation) findViewById(R.id.bottom_navigation);
         bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
         bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_med));
         bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_search_24));
         bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_profil));
         bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
             @Override

             public void onShowItem(MeowBottomNavigation.Model item) {
                 Intent intent = null;
                 switch (item.getId()) {
                     case 2:
                         intent = new Intent(getApplicationContext(),Home.class);
                         startActivity(intent);
                         break;

                      case 3: intent = new Intent(getApplicationContext(),Search.class);
                          startActivity(intent);
                          break;


                     //  case 4: fragment=new ProfilFragment();
                     //  break;
                 }

             }

         });
         boolean enableAnimation;
         //set home fragment initialy selected
         bottomNavigation.show(1, enableAnimation = true);
         bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
             @Override
             public void onClickItem(MeowBottomNavigation.Model item) {
                 //display toast
                 Toast.makeText(getApplicationContext(), "you clicked" + item.getId(), Toast.LENGTH_SHORT).show();
             }

             ;
         });

         bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
             @Override
             public void onReselectItem(MeowBottomNavigation.Model item) {
                 //display toast
                 Toast.makeText(getApplicationContext(), "YOU reslected" + item.getId(), Toast.LENGTH_SHORT).show();
             }
         });

     }
 }


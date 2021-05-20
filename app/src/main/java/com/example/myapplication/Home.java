package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    ImageButton imageButton;
    MeowBottomNavigation bottomNavigation;
    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    //vertical view
    ListView list;
    String[] titles;
    String[] description;
    int[] imgs={R.drawable.doc12,R.drawable.doc12,R.drawable.doc12,R.drawable.doc12
            ,R.drawable.doc12,R.drawable.doc12,R.drawable.doc12
            ,R.drawable.doc12,R.drawable.doc12,R.drawable.doc12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
                    case 1:
                        intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(),Search.class);
                        startActivity(intent);
                        break;
                    // case 3: fragment= new SearchFragment();break;

                    //  case 4: fragment=new ProfilFragment();
                    //  break;
                }

            }

        });
        boolean enableAnimation;
        //set home fragment initialy selected
        bottomNavigation.show(2, enableAnimation = true);
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

//vertical view
        Resources res=getResources();
      titles =res.getStringArray(R.array.titles);
        description=res.getStringArray(R.array.description);
        list=(ListView) findViewById(R.id.list1);
        Myadapter adapter=new Myadapter(this,titles,imgs,description);
        list.setAdapter(adapter);











        //assign varible
        recyclerView=findViewById(R.id.recycler_view);

        //creat integer array
        Integer[] categorieLogo={R.drawable.eye,R.drawable.heart
                ,R.drawable.lungs,R.drawable.teeth};

        //creat string array
        String[] categorieName={"Ophtalmologie","Cardiologie"
                ,"Pneumologie","Dentistes"};

        //initilize arraylist
        mainModels =new ArrayList<>();
        for (int i=0;i<categorieLogo.length;i++){
            MainModel model=new MainModel(categorieLogo[i],categorieName[i]);
            mainModels.add(model);

        }

        //Design Horizontal lyout
        LinearLayoutManager layoutManager=new LinearLayoutManager(
                Home.this,LinearLayoutManager.HORIZONTAL, false

        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //initialize mainAdapter
        mainAdapter=new MainAdapter(Home.this,mainModels);
        //set mainAdapter to recyclerview
        recyclerView.setAdapter(mainAdapter);

                }
    class Myadapter extends ArrayAdapter<String> {
        Context context;
        int[] imgs;
        String mytitles[];
        String mydescription[];

        Myadapter(Context c, String[] titles, int[] imgs, String[] description) {
            super(c, R.layout.verow, R.id.text1, titles);
            this.context = c;
            this.imgs = imgs;
            this.mydescription = description;
            this.mytitles = titles;
        }
        @Override
        public int getCount(){
            return imgs.length;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater layoutInflater=(LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View verow=layoutInflater.inflate(R.layout.verow,parent,false);
            ImageView images;
            images= verow.findViewById(R.id.icon);
            TextView mytitle;
            mytitle=verow.findViewById(R.id.text1);
            TextView mydescription;
            mydescription=verow.findViewById(R.id.text2);
            images.setImageResource(imgs[position]);
            mytitle.setText(titles[position]);
            mydescription.setText(description[position]);
            return verow;
        }
    }



}

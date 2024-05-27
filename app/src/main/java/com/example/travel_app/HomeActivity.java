package com.example.travel_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.travel_app.Adapters.PopularAdapter;
import com.example.travel_app.Domains.PopularDomain;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

/**
 * HomeActivity is the main activity for the travel application, displaying popular tourist spots
 * and providing navigation to other parts of the app such as the map and review sections.
 *
 * @author Hafsa Tazrian
 * @version 1.0
 *
 * @see AppCompatActivity
 * @see PopularAdapter
 * @see PopularDomain
 * @see BottomNavigationView
 * @see SharedPreferencesManager
 * @see ImageListAdapter
 * @see RecyclerView
 * @see LinearLayoutManager
 * @see Intent
 * @see Bundle
 * @see MenuItem
 * @see View
 * @see Button
 */


public class HomeActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerViewPopular;
    //private ImageListAdapter Adapter;private RecyclerView recyclerView;
    private SharedPreferencesManager sharedPreferencesManager2;
    private BottomNavigationView bottomNavigationView;

    /**
     * Called when the activity is first created. This is where you should do all of your
     * normal static set up: create views, bind data to lists, etc. This method also provides
     * a Bundle containing the activity's previously frozen state, if there was one.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously
     *                           being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState(Bundle)}.
     *                           Note: Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //EditText textView=findViewById(R.id.editText2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button button=findViewById(R.id.Mapbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,googleMap.class);
                startActivity(intent);
            }
        });
        bottomNavigationView=findViewById(R.id.bottomNavigationView2);
        sharedPreferencesManager2 = SharedPreferencesManager.getInstance(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.logout2)
                {
                    sharedPreferencesManager2.clear();
                    Intent intent3 = new Intent(HomeActivity.this, MainActivity2.class);
                    startActivity(intent3);
                    //Toast.makeText(this, "logout clicked", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else if(item.getItemId()==R.id.review)
                {
                    Intent intent1=new Intent(HomeActivity.this,ReviewActivity.class);
                    startActivity(intent1);
                }
//                lse if(item.getItemId()==R.id.account)
//                {
//                    Intent intent=new Intent(Login_activity.this,ProfileActivity.class);
//                    s etartActivity(intent);
//                }
                return false;
            }
        });
        initRecyclerView();
        int[] images = {R.drawable.beach_1, R.drawable.mountain_1, R.drawable.forest, R.drawable.traveller, R.drawable.beach};
        String[] texts = {"Beaches", "Mountains", "Forest", "Tourist Places", "Island"};
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        com.example.travel_app.ImageListAdapter adapter = new com.example.travel_app.ImageListAdapter(this, images,texts);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    /**
     * Initializes the RecyclerView for displaying popular tourist destinations.
     */

    private void initRecyclerView()
    {
        ArrayList<PopularDomain> items =new ArrayList<>();
        items.add(new PopularDomain("Sajek Valley","Rangamati","Sajek Valley is one of the most popular tourist spots in Bangladesh situated among the hills of the Kasalong range of mountains in Sajek union, Baghaichhari Upazila in Rangamati District. The valley is 2,000 feet above sea level. Sajek Valley is known as the Queen of Hills & Roof of Rangamati\n"
                ,"1.Nil Pahari Eco Resort\n"+"PHONE:01724356847\n"+"Bed:2\n" +
                "Price:2000TK\n"+"2.Hotel Maitree\n"+"PHONE:01724356847\n"+"Bed:2\n" +
                "Price:3000TK",true,4.8,"sajek",true,1000));
        items.add(new PopularDomain("Srimongol","Sylhet","Srimangal is a small hill town located in the Sylhet Division of Bangladesh, known for its picturesque tea gardens and natural beauty. The town is situated in the midst of the beautiful tea gardens of the Sylhet Valley and is surrounded by lush green hills and forests.","Janina",true,4.8,"srimongol",true,1000));
        items.add(new PopularDomain("Rabindro Kuthibari","Kushtia","Its former name is Khorshedpur, during the reign of British East India Company, a indigo-planter named Shelly built a house in this village, later people started to call the village age Shellydaha and the named changed to Shelaidaha. In 1807, Dwarkanath Tagore bought the village and made it his estate. He also bought the building (kuthi) as well. His grandson Rabindranath Tagore came to the village many times. Now the village is widely known for Shilaidaha Rabindra Kuthibari.","",true,4.5,"kuthibari",true,1000));
        items.add(new PopularDomain("Ahsan Manzil","Dhaka","Ahsan Manzil is a historical palace located in the heart of Dhaka, the capital city of Bangladesh. It was built in the late 19th century and served as the official residential palace of the Nawab of Dhaka. The construction of Ahsan Manzil was completed in 1872, during the reign of Nawab Abdul Ghani.\n" +
                "\n" +
                "The palace is an exquisite example of Indo-Saracenic architecture and reflects a blend of Mughal and European styles. It stands on the banks of the Buriganga River and has a prominent pink facade, earning it the nickname \"Pink Palace.\" The palace complex includes the main building, along with a museum showcasing artifacts and exhibits related to the history of Dhaka and the Nawabs.","",true,4.8,"ahsan_manzil",true,1000));
        items.add(new PopularDomain("Mohastangarh","Bogura","Mahasthangarh is an ancient archaeological site located near Bogura in northern Bangladesh. It is one of the earliest urban archaeological sites in the region and holds great historical significance. The site is believed to have been inhabited continuously for over two millennia, with evidence of settlements dating back to at least the 4th century BCE.","",true,4.8,"mohastangor",true,1000));
        recyclerViewPopular=findViewById(R.id.view_pop);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterPopular=new PopularAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);
    }


}
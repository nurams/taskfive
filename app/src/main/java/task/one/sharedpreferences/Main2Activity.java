package task.one.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private EditText email, user;
    private Button save;

    private sharedpreferenceconfig prefrenceconfig;
    List<Book> lstBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        email = findViewById(R.id.user_email);
        user = findViewById(R.id.user);

        SharedPreferences sharedpref = getApplicationContext().getSharedPreferences("save", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpref.edit();


        prefrenceconfig = new sharedpreferenceconfig(getApplicationContext());

        lstBook = new ArrayList<>();
        lstBook.add(new Book("Kisah Tanah Jawa", "Kategori Buku", "Deskripsi", R.drawable.kisahtanahjawa));
        lstBook.add(new Book("The Lost Girl of Paris", "Kategori Buku", "Deskripsi", R.drawable.lostgirlofparis));
        lstBook.add(new Book("The Lost Man", "Kategori Buku", "Deskripsi", R.drawable.thelostman));
        lstBook.add(new Book("The Suspect", "Kategori Buku", "Deskripsi", R.drawable.thesuspect));
        lstBook.add(new Book("Kisah Tanah Jawa", "Kategori Buku", "Deskripsi", R.drawable.kisahtanahjawa));
        lstBook.add(new Book("The Lost Girl of Paris", "Kategori Buku", "Deskripsi", R.drawable.lostgirlofparis));
        lstBook.add(new Book("The Lost Man", "Kategori Buku", "Deskripsi", R.drawable.thelostman));
        lstBook.add(new Book("The Suspect", "Kategori Buku", "Deskripsi", R.drawable.thesuspect));
        lstBook.add(new Book("Kisah Tanah Jawa", "Kategori Buku", "Deskripsi", R.drawable.kisahtanahjawa));
        lstBook.add(new Book("The Lost Girl of Paris", "Kategori Buku", "Deskripsi", R.drawable.lostgirlofparis));
        lstBook.add(new Book("The Lost Man", "Kategori Buku", "Deskripsi", R.drawable.thelostman));
        lstBook.add(new Book("The Suspect", "Kategori Buku", "Deskripsi", R.drawable.thesuspect));


        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstBook);
        myrv.setLayoutManager(new GridLayoutManager(this, 2));
        myrv.setAdapter(myAdapter);


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new BookFragment()).commit();

    }

   private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
       @Override
       public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
            Fragment selectedFragment = null;

            switch (Item.getItemId()) {
                case R.id.id2:
                selectedFragment = new ProfileFragment();
                break;
                case R.id.id1:
             selectedFragment = new BookFragment();
             break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                   selectedFragment).commit();
            return true;
       }


     };

    public void Logout(View view) {
    prefrenceconfig.writeLoginStatus(false);
    startActivity(new Intent(this, MainActivity.class));
    finish();
    }
}

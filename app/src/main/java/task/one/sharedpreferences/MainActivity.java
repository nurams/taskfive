package task.one.sharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
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
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private sharedpreferenceconfig preferenceconfig;
    private EditText Username, UserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        preferenceconfig = new sharedpreferenceconfig(getApplicationContext());
        Username = findViewById(R.id.user_name);
        UserPassword = findViewById(R.id.user_password);

        if (preferenceconfig.readLoginStatus()){
            startActivity(new Intent(this,Main2Activity.class));
            finish();
        }
    }

    public void loginUser(View view) {

        String username = Username.getText().toString();
        String userpassword = UserPassword.getText().toString();


        if(username.equals(getResources().getString(R.string.user_name))&&userpassword.equals(getResources().getString(R.string.user_password))){
            startActivity(new Intent(this, Main2Activity.class));
            preferenceconfig.writeLoginStatus(true);
            finish();
        }
        else{
            Toast.makeText(this, "login Gagal", Toast.LENGTH_SHORT).show();
            UserPassword.setText("");
            Username.setText("");
        }

    }


}

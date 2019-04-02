package task.one.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Book_Activity extends AppCompatActivity {


    private TextView tvtitle, tvdescription, tvcategory;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_);

        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvcategory = (TextView) findViewById(R.id.txtcat);
        tvdescription = (TextView) findViewById(R.id.txtdesc);
        img = (ImageView) findViewById(R.id.bookthumbnail);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("BookTitle");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");

        tvtitle.setText(Title);
        tvdescription.setText(Description);
        img.setImageResource(image);

    }
}

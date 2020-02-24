package ir.mpkmro.scientists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import ir.mpkmro.scientists.DataBase.DataBase;

public class ContentActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView back;
    CircleImageView image;
    TextView name, field, disc;
    FloatingActionButton fab;
    DataBase db;
    int id, value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        setUpViews();
        getAndSetData();
        favCondition();
        back.setOnClickListener(this);
        fab.setOnClickListener(this);

    }

    private void favCondition() {
        db = new DataBase(ContentActivity.this);
        value = db.fav_value(id);
        if (value == 0) {
            fab.setImageResource(R.drawable.ic_like);
        } else if (value == 1) {
            fab.setImageResource(R.drawable.ic_favorite);
        }

    }

    private void getAndSetData() {
        Intent intent = getIntent();
        name.setText(intent.getExtras().getString("NAME"));
        field.setText(intent.getExtras().getString("FIELD"));
        disc.setText(intent.getExtras().getString("DISC"));
        id = intent.getExtras().getInt("ID");
        String imageLink = intent.getExtras().getString("IMAGE");
        Picasso.with(ContentActivity.this).load(imageLink).resize(128, 128).into(image);
    }

    private void setUpViews() {
        back = findViewById(R.id.back_id);
        image = findViewById(R.id.image_id);
        field = findViewById(R.id.field_id);
        name = findViewById(R.id.name_id);
        disc = findViewById(R.id.disc_id);
        fab = findViewById(R.id.fab_id);
    }

    @Override
    public void onClick(View v) {
        int viewID = v.getId();

        switch (viewID) {
            case R.id.back_id:
                onBackPressed();
                break;
            case R.id.fab_id:
                addOrRemoveFav();
                break;
        }


    }

    private void addOrRemoveFav() {
        db = new DataBase(ContentActivity.this);
        value = db.fav_value(id);
        if (value == 0) {
            db.fav(1,id);
            fab.setImageResource(R.drawable.ic_favorite);
            Toast.makeText(ContentActivity.this, "به لیست علاقمندی ها اضافه شد" , Toast.LENGTH_LONG);

        } else if (value == 1) {
            db.fav(0,id);
            fab.setImageResource(R.drawable.ic_like);
            Toast.makeText(ContentActivity.this, "از لیست علاقمندی های حذف شد!" , Toast.LENGTH_LONG);
        }
    }
}

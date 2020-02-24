package ir.mpkmro.scientists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContentActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView back;
    CircleImageView image;
    TextView name, field, disc;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        setUpViews();
        getAndSetData();
        back.setOnClickListener(this);
        fab.setOnClickListener(this);

    }

    private void getAndSetData() {
        Intent intent = getIntent();
        name.setText(intent.getExtras().getString("NAME"));
        field.setText(intent.getExtras().getString("FIELD"));
        disc.setText(intent.getExtras().getString("DISC"));
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
                //TODO
                break;
        }


    }
}

package ir.mpkmro.scientists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    String name_text;
    boolean isLogin = false;
    EditText name;
    Button next;
    public static final String LOGIN = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupViews();

    }

    private void setupViews() {
        name = findViewById(R.id.name_ed_id);
        next = findViewById(R.id.next_btn);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewID = v.getId();

        switch (viewID) {
            case R.id.next_btn:

                nameValidation();
                break;


        }

    }

    private void nameValidation() {

        name_text = name.getText().toString().trim();
        if (name_text.isEmpty()) {
            Toast.makeText(this, "لطفا نام را وارد کنید!", Toast.LENGTH_SHORT).show();
        } else {
            saveName();
        }


    }

    private void saveName() {

        isLogin = !isLogin;
        SharedPreferences sharedPreferences = getSharedPreferences(LOGIN,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("ISLOGIN", isLogin);
        editor.putString("NAME",name_text);
        editor.apply();


        gotoHome();


    }

    private void gotoHome() {

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}

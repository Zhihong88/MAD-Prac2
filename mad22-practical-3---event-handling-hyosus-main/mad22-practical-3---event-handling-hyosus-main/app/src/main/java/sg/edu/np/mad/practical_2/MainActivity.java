package sg.edu.np.mad.practical_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    User u = new User("MAD","😎",0,false);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView header = findViewById(R.id.header);
        TextView desc = findViewById(R.id.description);

        Intent receivingEnd = getIntent();
        header.setText(u.name + " " + receivingEnd.getStringExtra("randomNumber"));
        desc.setText(u.description);

        Button message = findViewById(R.id.msgBtn);

        message.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(mainActivityIntent);
            }
        }));
    }

    public void follow(View view){
        Button fllw = findViewById(R.id.followBtn);
        switch(String.valueOf(u.isFollowed())) {
                    case "true":
                        u.followed = false;
                        fllw.setText("Unfollow");
                        Toast.makeText(getApplicationContext(), "Followed "+u.name,Toast.LENGTH_SHORT).show();
                        break;

                    case "false":
                        u.followed = true;
                        fllw.setText("Follow");
                        Toast.makeText(getApplicationContext(),"Unfollowed "+u.name, Toast.LENGTH_SHORT).show();
                        break;
        }
    }
}


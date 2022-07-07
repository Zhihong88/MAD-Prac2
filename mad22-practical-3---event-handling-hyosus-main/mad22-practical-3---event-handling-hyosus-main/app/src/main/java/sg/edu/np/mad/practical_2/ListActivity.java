package sg.edu.np.mad.practical_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView img = findViewById(R.id.activity_list_imgview);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);

                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setCancelable(true);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int id) {
                        int randomint = new Random().nextInt(823172316);
                        Intent mainActivityIntent = new Intent(ListActivity.this, MainActivity.class);
                        mainActivityIntent.putExtra("randomNumber", Integer.valueOf(randomint).toString());
                        startActivity(mainActivityIntent);
                        finish();
//                      Toast.makeText(getApplicationContext(), String.format("%s",randomint),Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        finish();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();

            }
        });
    }



}
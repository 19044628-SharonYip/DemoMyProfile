package sg.edu.rp.c346.id19044628.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edName, edGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName=findViewById(R.id.edName);
        edGPA=findViewById(R.id.edGPA);

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        String name=prefs.getString("name","John Doe");
        float gpa= prefs.getFloat("gpa",4.0f);
        edName.setText(name);
        edGPA.setText(gpa+"");
    }

    @Override
    protected void onPause() {
        super.onPause();

        String name=edName.getText().toString();
        float gpa= Float.parseFloat(edGPA.getText().toString());

        SharedPreferences prefs= getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit= prefs.edit();

        prefEdit.putString("name", name);
        prefEdit.putFloat("gpa",gpa);


        prefEdit.commit();

    }
}
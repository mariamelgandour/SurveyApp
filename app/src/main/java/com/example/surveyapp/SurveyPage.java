
package com.example.surveyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SurveyPage extends AppCompatActivity {
    EditText nameText;
    Button surveyButton;
    TextView yesText, noText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_page);

        nameText = findViewById(R.id.nameText);
        surveyButton = findViewById(R.id.surveyButton);
        yesText = findViewById(R.id.yesText);
        noText = findViewById(R.id.noText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void start(View view) {
        String name = nameText.getText().toString().trim();

        if (name.isEmpty()) {
            Toast.makeText(this, "Enter Your Name To Move Survey Page", Toast.LENGTH_LONG).show();
            return;
        }

        UsersData usersData = new UsersData(this);
        boolean exists = usersData.exists(name);
        if (exists) {
            Toast.makeText(this, "Exists Before", Toast.LENGTH_SHORT).show();
            return;
        }

        // إرسال الاسم إلى صفحة الاستبيان
        Intent intent = new Intent(this, SurveyActivity.class);
        intent.putExtra("NAME", name);
        startActivityForResult(intent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 1000 && data != null) {
            byte yes = data.getByteExtra("YES", (byte) 0);
            byte no = data.getByteExtra("NO", (byte) 0);

            yesText.setText("Yes is " + yes);
            noText.setText("No is " + no);
        }
    }

    public void count(MenuItem item) {
        try {
            UsersData usersData = new UsersData(this);
            int userCount = usersData.getCount();
            String message = "عدد المستخدمين: " + userCount;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "حدث خطأ في جلب عدد المستخدمين", Toast.LENGTH_SHORT).show();
            Log.e("CountUsers", "Error getting user count", e);
        }
    }

    public void countNames(MenuItem item) {
        Intent intent = new Intent(this, Name_View_Activity.class);
        intent.putExtra("From","countNames");
        startActivity(intent);
        finish();
    }

    public void details(MenuItem item) {
        Intent intent = new Intent(this, Name_View_Activity.class);
        intent.putExtra("From","details");
        startActivity(intent);
        finish();
    }
}

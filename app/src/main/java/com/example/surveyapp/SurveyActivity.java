
package com.example.surveyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SurveyActivity extends AppCompatActivity {
    TextView questionText, receivedText;
    Button yesBtn, noBtn, finishBtn;
    byte yes, no, i;
    String[] questions;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        // ربط المكونات
        questionText = findViewById(R.id.questionText);
        receivedText = findViewById(R.id.receivedText);
        yesBtn = findViewById(R.id.yesButton);
        noBtn = findViewById(R.id.noButton);
        finishBtn = findViewById(R.id.finishButton);

        // استلام الاسم من SurveyPage
        name = getIntent().getStringExtra("NAME");

        // عرض "Hello" مع الاسم فقط في واجهة المستخدم
        receivedText.setText("Hello " + name); // كلمة "Hello" مع الاسم في واجهة المستخدم

        // تحميل الأسئلة
        QuestionData data = new QuestionData(this);
        questions = data.selectQuestions();
        questionText.setText("DO YOU Like " + questions[0]);
    }

    // دالة للإجابة بـ "Yes"
    public void yes(View view) {
        yes++;
        i++;
        if (i < 4) {
            questionText.setText("DO YOU Like " + questions[i]);
        } else {
            Toast.makeText(this, "Yes Score is {" + yes + "} No Score is {" + no + "}", Toast.LENGTH_SHORT).show();
            yesBtn.setEnabled(false);
            noBtn.setEnabled(false);
        }
    }

    // دالة للإجابة بـ "No"
    public void No(View view) {
        no++;
        i++;
        if (i < 4) {
            questionText.setText("DO YOU Like " + questions[i]);
        } else {
            Toast.makeText(this, "Yes Score is {" + yes + "} No Score is {" + no + "}", Toast.LENGTH_SHORT).show();
            noBtn.setEnabled(false);
            yesBtn.setEnabled(false);
        }
    }

    // دالة لحفظ البيانات عند الانتهاء
    public void finish(View view) {
        // عند إتمام الإجابة، إحنا هنبعث الاسم الفعلي (بدون "Hello") إلى SurveyPage
        Intent intent = new Intent(this, SurveyPage.class);
        intent.putExtra("YES", yes);
        intent.putExtra("NO", no);
        setResult(1000, intent);

        // حفظ الاسم الفعلي (بدون "Hello") في قاعدة البيانات
        UsersData usersData = new UsersData(this);
        boolean success = usersData.insert(name, yes, no);  // هنحفظ الاسم فقط بدون "Hello"
        if (success)
            Toast.makeText(this, "Saved Successfully", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Error in Saving", Toast.LENGTH_LONG).show();

        finish();
    }
}

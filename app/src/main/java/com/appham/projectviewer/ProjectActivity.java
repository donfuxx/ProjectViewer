package com.appham.projectviewer;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appham.projectviewer.model.Project;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ProjectActivity extends AppCompatActivity {

    private Project project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            project = (Project) bundle.get("project");
        }

        LinearLayout layout = findViewById(R.id.layProjectDetails);


        // get all fields and loop through them to display each
        List<Field> fields = Arrays.asList(project.getClass().getDeclaredFields());
        String name;
        Object value;
        SpannableString styledStr;

        for (Field field : fields) {
            try {
                name = field.getName();
                value = field.get(project);
                Log.i("fields", "name: " + name + " - value: " + value + " type: " + field.getType());

                styledStr = new SpannableString(name + ": \n" + value);
                styledStr.setSpan(new StyleSpan(Typeface.BOLD), 0, name.length(), 0);

                // attach view to layout
                TextView textView = new TextView(this);
                textView.setText(styledStr);
                textView.setPadding(10, 10, 10, 10);
                textView.setGravity(Gravity.CENTER);

                layout.addView(textView);

                if ("logo".equals(name)) {

                    // attach img to layout
                    ImageView imgView = new ImageView(this);
                    imgView.setPadding(10, 10, 10, 10);
                    Picasso.with(this).load(project.logo)
                            .error(R.mipmap.ic_launcher_round)
                            .into(imgView);

                    layout.addView(imgView);
                }

                //TODO: Properly display fields that are of a type other than String, int etc.

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


    }
}

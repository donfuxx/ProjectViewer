package com.appham.projectviewer;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.appham.projectviewer.model.Project;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            Project project = (Project) bundle.get("project");

            if (project == null) return;

            // get all fields and loop through them to display each
            List<Field> fields = Arrays.asList(project.getClass().getDeclaredFields());
            String name;
            Object value;
            SpannableStringBuilder spanBuilder = new SpannableStringBuilder();

            for (Field field : fields) {
                try {
                    name = field.getName();
                    value = field.get(project);
                    Log.i("fields", "name: " + name + " - value: " + value + " type: " + field.getType());

                    int startIndex = spanBuilder.length();
                    spanBuilder.append(name).append(": \n")
                            .append(String.valueOf(value)).append("\n\n")
                            .setSpan(new StyleSpan(Typeface.BOLD), startIndex, startIndex + name.length(), 0);

                    //TODO: Properly display fields that are of a type other than String, int etc.

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            TextView txtDetails = findViewById(R.id.txtProjectDetails);
            txtDetails.setText(spanBuilder);

            ImageView imgView = findViewById(R.id.imgProjectDetails);
            Picasso.with(this).load(project.logo)
                    .error(R.mipmap.ic_launcher_round)
                    .into(imgView);

        }
    }
}

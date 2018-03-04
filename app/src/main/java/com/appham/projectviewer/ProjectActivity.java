package com.appham.projectviewer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.widget.ImageView;
import android.widget.TextView;

import com.appham.projectviewer.model.Project;
import com.appham.projectviewer.utils.Spanificator;
import com.squareup.picasso.Picasso;

public class ProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            Project project = (Project) bundle.get("project");

            if (project == null) return;

            TextView txtDetails = findViewById(R.id.txtProjectDetails);
            txtDetails.setText(Spanificator.appendObjectFields(
                    new SpannableStringBuilder(), project, ": \n", "\n\n", 1.2f));

            ImageView imgView = findViewById(R.id.imgProjectDetails);
            Picasso.with(this).load(project.getLogo())
                    .placeholder(android.R.drawable.progress_indeterminate_horizontal)
                    .error(R.mipmap.ic_launcher_round)
                    .into(imgView);

        }
    }
}

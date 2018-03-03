package com.appham.projectviewer;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.RotateDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.appham.projectviewer.model.Project;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * @author thomas
 */
public class ProjectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Project> projects = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.project_item, parent, false);
        return new ProjectHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ProjectHolder) {
            ProjectHolder projectHolder = (ProjectHolder) holder;
            Project project = projects.get(position);
            projectHolder.txtName.setText(project.name);
            projectHolder.txtDesc.setText(project.description);
            projectHolder.txtCompany.setText(project.company.name);

            Context context = holder.itemView.getContext();

            if (project.logo != null) {

                // rotating placeholder image
                RotateDrawable placeholder = (RotateDrawable) ContextCompat.getDrawable(context,
                        R.drawable.ic_launcher_rotate);
                ObjectAnimator animator = ObjectAnimator.ofInt(placeholder, "level", 0, 10000);
                animator.setRepeatCount(Animation.INFINITE);
                animator.setDuration(2000);
                animator.setInterpolator(new LinearInterpolator());
                animator.start();

                int screenWidthPx = Resources.getSystem().getDisplayMetrics().widthPixels;
                int screenHeightPx = Resources.getSystem().getDisplayMetrics().heightPixels;

                Picasso.with(holder.itemView.getContext()).load(project.logo)
                        .resize(Math.min(screenWidthPx / 3, screenHeightPx / 2),
                                Math.min(screenWidthPx / 4, screenHeightPx / 3))
                        .onlyScaleDown()
                        .centerInside()
                        .placeholder(placeholder)
                        .error(R.mipmap.ic_launcher_round)
                        .into(projectHolder.imgLogo);
            }

            projectHolder.itemView.setOnClickListener(view -> {
                Intent intent = new Intent(context, ProjectActivity.class);
                intent.putExtra("project", project);
                context.startActivity(intent);
            });
        }
    }


    @Override
    public int getItemCount() {
        return projects.size();
    }

    class ProjectHolder extends RecyclerView.ViewHolder {


        final TextView txtName, txtDesc, txtCompany;
        final ImageView imgLogo;

        ProjectHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            txtCompany = itemView.findViewById(R.id.txtCompany);
            imgLogo = itemView.findViewById(R.id.imgProject);
        }

    }

    void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}

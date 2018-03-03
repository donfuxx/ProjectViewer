package com.appham.projectviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.appham.projectviewer.api.ApiFactory;
import com.appham.projectviewer.api.ProjectsApi;
import com.appham.projectviewer.model.ProjectsList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProjectListFragment projectListFragment = new ProjectListFragment();
        getFragmentManager().beginTransaction().add(R.id.frameProjects, projectListFragment, ProjectListFragment.TAG)
                .commit();

        callAPI();
    }

    private void callAPI() {
        ProjectsApi projectsApi = ApiFactory.createProjectsApi();
        projectsApi.getProjects().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::logResult, Throwable::printStackTrace);
    }

    private int logResult(ProjectsList p) {
        return Log.i("subscribe", p+"");

    }
}

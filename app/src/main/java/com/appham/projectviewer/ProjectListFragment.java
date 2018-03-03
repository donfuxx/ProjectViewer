package com.appham.projectviewer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.appham.projectviewer.api.ApiFactory;
import com.appham.projectviewer.api.ProjectsApi;
import com.appham.projectviewer.model.ProjectsList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author thomas
 */

public class ProjectListFragment extends Fragment {

    public static String TAG = "ProjectListFragment";
    private ProjectAdapter projectAdapter = new ProjectAdapter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        // get recycler-list of project results
        RecyclerView projectList = view.findViewById(R.id.listProject);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        projectList.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager projectsLayoutManager = new LinearLayoutManager(getActivity());
        projectList.setLayoutManager(projectsLayoutManager);

        projectList.setAdapter(projectAdapter);

        callAPI();

        setRetainInstance(true);

        super.onViewCreated(view, savedInstanceState);
    }

    private void callAPI() {
        ProjectsApi projectsApi = ApiFactory.createProjectsApi();
        projectsApi.getProjects().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onNext, this::onError);
    }

    private int onNext(ProjectsList projectsList) {
        projectAdapter.setProjects(projectsList.projects);
        projectAdapter.notifyDataSetChanged();

        return Log.i("subscribe", projectsList.projects.size() + " projects loaded");

    }

    private void onError(Throwable throwable) {
        throwable.printStackTrace();
        Toast.makeText(this.getActivity(), throwable.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }
}

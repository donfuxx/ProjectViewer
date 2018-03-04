package com.appham.projectviewer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
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
    public static String PROJECTS_LIST = "projects-list";
    private ProjectAdapter projectAdapter = new ProjectAdapter();
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        // get recycler-list of project results
        RecyclerView projectListView = view.findViewById(R.id.listProject);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        projectListView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager projectsLayoutManager = new LinearLayoutManager(getActivity());
        projectListView.setLayoutManager(projectsLayoutManager);

        projectListView.setAdapter(projectAdapter);

        // delete project item from list by swipe right
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }


            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                //TODO: also delete from backend db
                Toast.makeText(getActivity(),
                        R.string.delete_not_yet_implemented, Toast.LENGTH_LONG).show();

                int pos = viewHolder.getAdapterPosition();
                projectAdapter.getProjectsList().getProjects().remove(pos);
                projectAdapter.notifyItemRemoved(pos);
            }
        };
        new ItemTouchHelper(simpleItemTouchCallback).attachToRecyclerView(projectListView);

        progressBar = view.findViewById(R.id.progressBar);

        FloatingActionButton btnRefresh = view.findViewById(R.id.btnRefresh);
        btnRefresh.setOnClickListener(v -> {
            projectAdapter.setProjectsList(new ProjectsList());
            projectAdapter.notifyDataSetChanged();
            callAPI();
        });

        if (savedInstanceState != null) {
            projectAdapter.setProjectsList(savedInstanceState.getParcelable(PROJECTS_LIST));
            projectAdapter.notifyDataSetChanged();
        } else {
            callAPI();
        }

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(PROJECTS_LIST, projectAdapter.getProjectsList());
        super.onSaveInstanceState(outState);
    }


    private void callAPI() {
        progressBar.setVisibility(View.VISIBLE);
        ProjectsApi projectsApi = ApiFactory.createProjectsApi();
        projectsApi.getProjects().subscribeOn(Schedulers.io())
                .retry(2)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onNext, this::onError);
    }

    @UiThread
    private int onNext(ProjectsList projectsList) {
        progressBar.setVisibility(View.GONE);

        projectAdapter.setProjectsList(projectsList);
        projectAdapter.notifyDataSetChanged();

        return Log.i("subscribe", projectsList.getProjects().size() + " projects loaded");

    }

    @UiThread
    private void onError(Throwable throwable) {
        throwable.printStackTrace();
        Toast.makeText(this.getActivity(), throwable.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        progressBar.setVisibility(View.GONE);
    }
}

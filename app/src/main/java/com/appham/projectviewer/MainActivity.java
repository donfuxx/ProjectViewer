package com.appham.projectviewer;

import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getFragmentManager().findFragmentByTag(ProjectListFragment.TAG) == null) {
            ProjectListFragment projectListFragment = new ProjectListFragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.frameProjects, projectListFragment, ProjectListFragment.TAG)
                    .commit();
        }
    }

}

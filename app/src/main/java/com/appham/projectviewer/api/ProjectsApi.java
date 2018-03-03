package com.appham.projectviewer.api;

import com.appham.projectviewer.model.ProjectsList;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author thomas
 */

public interface ProjectsApi {

    String USER = "yat@triplespin.com";
    String PASS = "yatyatyat27";

    String BASE_URL = "https://yat.teamwork.com";
    String FEED = "/projects.json";

    @GET(FEED)
    Observable<ProjectsList> getProjects();
}

package com.nandwere.gadsmobileapplication;


import com.nandwere.gadsmobileapplication.model.LearningLeader;
import com.nandwere.gadsmobileapplication.model.SkillIQLeader;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LeadersApiClient {
    String LEADERS_BASE_URL = "https://gadsapi.herokuapp.com/";
    String PROJECT_SUBMISSION_BASE_URL = "https://docs.google.com/forms/d/e/";


    //PluralSight Requests
    // 1.Get all Learning leaders
    @GET("api/hours")
    Call<List<LearningLeader>> doGetListLearningLeaders();

    // 1.Get all Skill IQ leaders
    @GET("api/skilliq")
    Call<List<SkillIQLeader>> doGetListIQLeaders();

    // 1.Submit project
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    Call<Void> submitProject(
            @Field("entry.1824927963") String email,
            @Field("entry.1877115667") String firstName,
            @Field("entry.2006916086") String lastName,
            @Field("entry.284483984") String gitHubProjectLink);
}
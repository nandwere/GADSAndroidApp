package com.nandwere.gadsmobileapplication;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nandwere.gadsmobileapplication.model.LearningLeader;
import com.nandwere.gadsmobileapplication.model.SkillIQLeader;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataViewModel extends ViewModel {

    private static final String TAG = DataViewModel.class.getSimpleName() ;
    private MutableLiveData<List<LearningLeader>> learningLeaders;
    private MutableLiveData<List<SkillIQLeader>> skillIQLeaders;
    private Retrofit mRetrofit;

    public LiveData<List<LearningLeader>> listLearningLeaderLiveData() {
        if (learningLeaders == null) {
            learningLeaders = new MutableLiveData<>();
            loadLearningLeaders();
        }

        //finally we will return the list
        return learningLeaders;
    }

    public LiveData<List<SkillIQLeader>> listSkillIQLiveData() {
        if (skillIQLeaders == null) {
            skillIQLeaders = new MutableLiveData<>();
            loadSkillIqLeaders();
        }

        //finally we will return the list
        return skillIQLeaders;
    }

    private void loadSkillIqLeaders() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(LeadersApiClient.LEADERS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LeadersApiClient api = mRetrofit.create(LeadersApiClient.class);
        Call<List<SkillIQLeader>> call = api.doGetListIQLeaders();
        call.enqueue(new Callback<List<SkillIQLeader>>() {

            @Override
            public void onResponse(@NotNull Call<List<SkillIQLeader>> call, @NotNull Response<List<SkillIQLeader>> response) {
                skillIQLeaders.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<List<SkillIQLeader>> call, Throwable t) {
                Log.e(TAG, call.toString(), t);
            }
        });
    }
    private void loadLearningLeaders() {
       mRetrofit = new Retrofit.Builder()
                .baseUrl(LeadersApiClient.LEADERS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LeadersApiClient api = mRetrofit.create(LeadersApiClient.class);
        Call<List<LearningLeader>> call = api.doGetListLearningLeaders();
        call.enqueue(new Callback<List<LearningLeader>>() {

            @Override
            public void onResponse(@NotNull Call<List<LearningLeader>> call, Response<List<LearningLeader>> response) {
                Log.e(TAG, String.valueOf(response.body()));
                learningLeaders.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<List<LearningLeader>> call, Throwable t) {
                Log.e(TAG, call.toString(), t);
            }
        });
    }
    public Retrofit submitProject(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(LeadersApiClient.PROJECT_SUBMISSION_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return mRetrofit;
    }
}

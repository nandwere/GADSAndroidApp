package com.nandwere.gadsmobileapplication.ui.main;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.nandwere.gadsmobileapplication.DataViewModel;
import com.nandwere.gadsmobileapplication.LeadersApiClient;
import com.nandwere.gadsmobileapplication.OnConfirmationListener;
import com.nandwere.gadsmobileapplication.R;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectSubmissionActivity extends AppCompatActivity implements OnConfirmationListener {
    private static final String TAG = ProjectSubmissionActivity.class.getSimpleName();
    private EditText firstName, lastName, email, githubLink;
    private  LeadersApiClient leadersApiClient;
    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mGithubLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);
        Button mProjectSubmit = findViewById(R.id.project_submit_btn);
        ImageView mUpArrowIcon = findViewById(R.id.up_arrow);
        mUpArrowIcon.setOnClickListener(v -> onBackPressed());
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        email = findViewById(R.id.email_address);
        githubLink = findViewById(R.id.git_hub_project_link);
        DataViewModel viewModel = new ViewModelProvider(this).get(DataViewModel.class);
        leadersApiClient = viewModel.submitProject().create(LeadersApiClient.class);

        mProjectSubmit.setOnClickListener(v -> {
            mFirstName = firstName.getText().toString();
            mLastName = lastName.getText().toString();
            mEmail = email.getText().toString();
            mGithubLink = githubLink.getText().toString();
            if (!TextUtils.isEmpty(this.mFirstName) && !TextUtils.isEmpty(mLastName) && !TextUtils.isEmpty(mEmail) && !TextUtils.isEmpty(mGithubLink)) {
                showConfirmDialog();
            }

        });
    }
    
    private void submitProject(LeadersApiClient leadersApiClient, String firstName, String lastName, String email, String githubLink) {
        Call<Void> call = leadersApiClient.submitProject(email, firstName, lastName, githubLink);
        call.enqueue(new Callback() {

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                if (response.isSuccessful()) {
                    showSuccessDialog();
                } else {
                    showFailedDialog();
                }
            }

            @Override
            public void onFailure(@NotNull Call call, Throwable t) {
                Log.e(TAG, call.toString(), t);
            }
        });
    }

    private void showSuccessDialog() {
        FragmentManager fm = getSupportFragmentManager();
        SubmissionSuccessDialog successDialog = SubmissionSuccessDialog.newInstance("Some Title");
        successDialog.show(fm, "fragment_edit_name");
    }

    private void showFailedDialog() {
        FragmentManager fm = getSupportFragmentManager();
        SubmitFailedDialog failedDialog = SubmitFailedDialog.newInstance("Some Title");
        failedDialog.show(fm, "fragment_edit_name");
    }

    private void showConfirmDialog() {
        FragmentManager fm = getSupportFragmentManager();
        SubmitConfirmDialog showConfirmDialog = SubmitConfirmDialog.newInstance("title");
        Window window = getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.CENTER;
        wlp.flags &= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(wlp);
        showConfirmDialog.show(fm, "fragment_edit_name");
    }

    @Override
    public void onConfirmSubmit(boolean view) {
        if (view){
            submitProject(leadersApiClient, mFirstName, mLastName, mEmail, mGithubLink);
        }
    }
}
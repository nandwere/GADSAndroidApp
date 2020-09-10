package com.nandwere.gadsmobileapplication.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.nandwere.gadsmobileapplication.OnConfirmationListener;
import com.nandwere.gadsmobileapplication.R;

import java.util.Objects;

public class SubmitConfirmDialog extends DialogFragment  {
    private OnConfirmationListener confirmationListener;

    public SubmitConfirmDialog() {
    }

    public static SubmitConfirmDialog newInstance(String title) {
        SubmitConfirmDialog frag = new SubmitConfirmDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.confirmationListener = (OnConfirmationListener) requireActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.submission_confirmation_dialog, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WindowManager.LayoutParams lp = Objects.requireNonNull(Objects.requireNonNull(getDialog()).getWindow()).getAttributes();
        lp.dimAmount = 0.0f;
        Objects.requireNonNull(getDialog().getWindow()).setAttributes(lp);
        Button mProjectSubmit = view.findViewById(R.id.confirmation_dialog_button);
        mProjectSubmit.setOnClickListener(v -> {
            if (v.getId() == R.id.confirmation_dialog_button){
                confirmationListener.onConfirmSubmit(true);
                getDialog().dismiss();
            }
        });
    }
}

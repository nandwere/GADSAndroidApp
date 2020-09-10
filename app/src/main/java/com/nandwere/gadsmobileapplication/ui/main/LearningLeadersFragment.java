package com.nandwere.gadsmobileapplication.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nandwere.gadsmobileapplication.DataViewModel;
import com.nandwere.gadsmobileapplication.R;
import com.nandwere.gadsmobileapplication.adapters.LearningLeadersAdapter;

public class LearningLeadersFragment extends Fragment {
    private LearningLeadersAdapter adapter;

    public LearningLeadersFragment() {
    }

    public static LearningLeadersFragment newInstance() {
        return new LearningLeadersFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.learning_leaders_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        DataViewModel model = new ViewModelProvider(this).get(DataViewModel.class);
        model.listLearningLeaderLiveData().observe(getViewLifecycleOwner(), leaningLeaders -> {
            adapter = new LearningLeadersAdapter(getContext(), leaningLeaders);
            recyclerView.setAdapter(adapter);
        });
        return view;
    }
}
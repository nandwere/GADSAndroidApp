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
import com.nandwere.gadsmobileapplication.adapters.SkillIQLeadersAdapter;

public class SkillIQLeadersFragment extends Fragment {
    private SkillIQLeadersAdapter adapter;
    private RecyclerView recyclerView;

    public SkillIQLeadersFragment() {
    }

    public static SkillIQLeadersFragment newInstance() {
        return new SkillIQLeadersFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skill_i_q_leaders, container, false);
        recyclerView = view.findViewById(R.id.skill_iq_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        DataViewModel model = new ViewModelProvider(this).get(DataViewModel.class);
        model.listSkillIQLiveData().observe(getViewLifecycleOwner(), skillIQLeader -> {
            adapter = new SkillIQLeadersAdapter(requireActivity(), skillIQLeader);
            recyclerView.setAdapter(adapter);
        });
        return view;
    }
}
package com.nandwere.gadsmobileapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nandwere.gadsmobileapplication.R;
import com.nandwere.gadsmobileapplication.model.LearningLeader;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.LearningLeaderViewHolder> {
    private Context mContext;
    private List<LearningLeader> mLearningLeaders;

    public LearningLeadersAdapter(Context mContext, List<LearningLeader> mLearningLeaders) {
        this.mContext = mContext;
        this.mLearningLeaders = mLearningLeaders;
    }

    @NonNull
    @Override
    public LearningLeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_leader_item, parent, false);
        return new LearningLeaderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningLeaderViewHolder holder, int position) {
        LearningLeader leader = mLearningLeaders.get(position);
        String text = leader.getHours()+" learning hours, "+leader.getCountry();
        holder.imageView.setImageResource(R.drawable.top_learner);
        holder.username.setText(leader.getName());
        holder.details.setText(text);

    }

    @Override
    public int getItemCount() {
        return mLearningLeaders.size();
    }

    static class LearningLeaderViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView username;
        TextView details;

        public LearningLeaderViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.pluralsight_logo);
            username = itemView.findViewById(R.id.user_name);
            details = itemView.findViewById(R.id.user_details);
        }
    }
}

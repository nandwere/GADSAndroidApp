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
import com.nandwere.gadsmobileapplication.model.SkillIQLeader;

import java.util.List;

public class SkillIQLeadersAdapter extends RecyclerView.Adapter<SkillIQLeadersAdapter.SkillIQViewHolder> {
    private Context mContext;
    private List<SkillIQLeader> mSkillIQLeaders;

    public SkillIQLeadersAdapter(Context context, List<SkillIQLeader> leaningLeaders) {
        this.mContext = context;
        this.mSkillIQLeaders = leaningLeaders;
    }

    @NonNull
    @Override
    public SkillIQViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_leader_item, parent, false);
        return new SkillIQViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIQViewHolder holder, int position) {
        SkillIQLeader iqLeader = mSkillIQLeaders.get(position);
        String text = iqLeader.getScore()+" skill IQ score, "+iqLeader.getCountry();
        holder.imageView.setImageResource(R.drawable.skill_iq_trimmed);
        holder.username.setText(iqLeader.getName());
        holder.details.setText(text);
    }


    @Override
    public int getItemCount() {
        return mSkillIQLeaders.size();
    }

    static class SkillIQViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView username,details;

        public SkillIQViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.pluralsight_logo);
            username = itemView.findViewById(R.id.user_name);
            details = itemView.findViewById(R.id.user_details);
        }
    }
}

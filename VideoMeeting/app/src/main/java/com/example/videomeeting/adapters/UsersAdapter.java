package com.example.videomeeting.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videomeeting.R;
import com.example.videomeeting.listeners.UsersListener;
import com.example.videomeeting.models.User;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    private List<User> users;
    private UsersListener usersListener;

    public UsersAdapter(List<User> users,UsersListener usersListener) {
        this.users = users;
        this.usersListener = usersListener;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_container_user,
                        parent,
                        false
                ));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.setUserData(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textViewFirstChar, textViewUsername, textViewEmail;
        ImageView imageAudioMeeting, imageVideoMeeting;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewFirstChar = itemView.findViewById(R.id.textFirstChar);
            textViewUsername = itemView.findViewById(R.id.textViewUsername);
            textViewEmail = itemView.findViewById(R.id.textEmail);
            imageAudioMeeting = itemView.findViewById(R.id.imageAudioMeeting);
            imageVideoMeeting = itemView.findViewById(R.id.imageVideoMeeting);
        }

        void setUserData(User user) {
            textViewFirstChar.setText(user.firstName.substring(0, 1));
            textViewUsername.setText(String.format("%s %s", user.firstName, user.lastName));
            textViewEmail.setText(user.email);
            imageAudioMeeting.setOnClickListener(view -> usersListener.initiateAudioMeeting(user));
            imageVideoMeeting.setOnClickListener(view -> usersListener.initiateVideoMeeting(user));
        }
    }
}

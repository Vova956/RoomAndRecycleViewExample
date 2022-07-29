package com.example.roomexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomexample.db.User;

import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context context;
    private List<User> userList;
    public UserAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        holder.tvFirstName.setText(this.userList.get(position).firstName);
        holder.tvLastName.setText(this.userList.get(position).lastName);
    }

    @Override
    public int getItemCount() {
        return  this.userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView tvFirstName;
        TextView tvLastName;

        public UserViewHolder(View view) {
            super(view);
            tvFirstName = view.findViewById(R.id.tvFirstName);
            tvLastName = view.findViewById(R.id.tvLastName);

        }
    }
}
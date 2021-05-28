package com.example.vehicletickets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class profileRecyclerAdapter extends RecyclerView.Adapter<profileRecyclerAdapter.PostHolder> {


    private ArrayList<String> url;
    private ArrayList<String> namesurname;
    private ArrayList<String> story;

    public profileRecyclerAdapter(ArrayList<String> url, ArrayList<String> namesurname, ArrayList<String> story) {
        this.url = url;
        this.namesurname = namesurname;
        this.story = story;
    }


    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.profilelayoutrow, parent, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.nameSurnameText.setText(namesurname.get(position));
        holder.story.setText(story.get(position));
        Picasso.get().load(url.get(position)).fit().centerCrop()
                .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return story.size();
    }


    class PostHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameSurnameText;
        TextView story;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.rowimageview);
            nameSurnameText = itemView.findViewById(R.id.UserName);
            story = itemView.findViewById(R.id.loremipsum);
        }
    }


}

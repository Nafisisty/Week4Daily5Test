package com.example.week4daily5test.view.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week4daily5test.R;
import com.example.week4daily5test.model.photo.Photo;
import com.example.week4daily5test.view.activities.detailsactivity.DetailsActivity;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<Photo> photoList;

    public RecyclerViewAdapter(List<Photo> photoList) {
        this.photoList = photoList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {

        Photo aPhoto = photoList.get(position);

        if(aPhoto != null) {

            viewHolder.setItemPhoto(aPhoto);

            viewHolder.photoTitleTextView.setText(aPhoto.getTitle() != "" ? aPhoto.getTitle() : "No Title");
            Glide.with(viewHolder.photoImageView)
                    .load("https://farm"+ aPhoto.getFarm() +".staticflickr.com/" + aPhoto.getServer() + "/" + aPhoto.getId() +"_" + aPhoto.getSecret() +"_q.jpg")
                    .into(viewHolder.photoImageView);
        }

    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView photoImageView;
        TextView photoTitleTextView;
        Photo itemPhoto;

        public void setItemPhoto(@NonNull Photo itemPhoto) {
            this.itemPhoto = itemPhoto;
        }

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            photoImageView = itemView.findViewById(R.id.photoImageViewId);
            photoTitleTextView = itemView.findViewById(R.id.photoTitleTextViewId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(itemView.getContext(), DetailsActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putParcelable("selectedPhoto", itemPhoto );
                    intent.putExtras(bundle);
                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}

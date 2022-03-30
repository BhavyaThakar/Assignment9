package com.example.gallery;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.vHolder> {

    ArrayList<Uri> data = new ArrayList<>();

    public RvAdapter(ArrayList<Uri> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public vHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_view, parent, false);
        return new vHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull vHolder holder, int position) {
        Picasso.get()
                .load(data.get(position))
                .resize(400, 400)
                .centerCrop()
                .into(holder.iv);



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class vHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        public vHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.imageView);
        }
    }
}

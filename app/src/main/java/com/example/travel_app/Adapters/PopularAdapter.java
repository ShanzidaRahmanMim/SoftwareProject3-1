package com.example.travel_app.Adapters;
//Factory
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.travel_app.DetailActivity;
import com.example.travel_app.Domains.PopularDomain;
import com.example.travel_app.R;

import java.text.DecimalFormat;
import java.util.ArrayList;



import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    private ArrayList<PopularDomain> items;
    private DecimalFormat formatter;

    public PopularAdapter(ArrayList<PopularDomain> items) {
        this.items = items;
        formatter = new DecimalFormat("###,###,###,###");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);
        return ViewHolderFactory.createViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, location, score;
        private ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleText);
            location = itemView.findViewById(R.id.location);
            score = itemView.findViewById(R.id.starText);
            pic = itemView.findViewById(R.id.sajekView);
        }

        public void bind(PopularDomain item) {
            title.setText(item.getTitle());
            location.setText(item.getLocation());
            score.setText(String.valueOf(item.getScore()));
            int drawableResId = itemView.getResources().getIdentifier(item.getPic(), "drawable", itemView.getContext().getPackageName());
            Glide.with(itemView.getContext())
                    .load(drawableResId)
                    .transform(new CenterCrop(), new GranularRoundedCorners(40, 40, 40, 40))
                    .into(pic);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                    intent.putExtra("object", item);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }

    private static class ViewHolderFactory {
        public static ViewHolder createViewHolder(View itemView) {
            return new ViewHolder(itemView);
        }
    }
}

package com.cxrus.mvpexample.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cxrus.mvpexample.R;
import com.cxrus.mvpexample.model.MovieItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    private List<MovieItem> popularList;
    Context context;

    public PopularAdapter(Context context) {
        this.context = context;
    }

    public void setPopularAdapter(List<MovieItem> popularList) {
        this.popularList = popularList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MovieItem item = popularList.get(position);
        holder.mTitleMovie.setText(item.getTitle());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + item.getBackdropPath())
                .into(holder.mImagePoster);
    }

    @Override
    public int getItemCount() {
        return popularList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_itemMovie)
        ImageView mImagePoster;
        @BindView(R.id.tv_titleMovie)
        TextView mTitleMovie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

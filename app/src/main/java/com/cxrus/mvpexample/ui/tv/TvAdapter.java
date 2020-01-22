package com.cxrus.mvpexample.ui.tv;

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
import com.cxrus.mvpexample.model.Results;
import com.cxrus.mvpexample.model.Tv;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TvAdapter extends RecyclerView.Adapter<TvAdapter.ViewHolder> {
    private Context context;
    private List<Results> tvList;

    public TvAdapter(Context context) {
        this.context = context;
    }

    public void setTvAdapter(List<Results> tvList) {
        this.tvList = tvList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Results tv = tvList.get(position);
        holder.tv_title_tv.setText(tv.getOriginalTitle());
        holder.tv_overview.setText(tv.getOverview());
        holder.tv_release_date.setText(tv.getReleaseDate());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + tv.getBackdropPath())
                .into(holder.iv_poster_tv);
    }

    @Override
    public int getItemCount() {
        return tvList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_poster)
        ImageView iv_poster_tv;
        @BindView(R.id.tv_title)
        TextView tv_title_tv;
        @BindView(R.id.tv_overview)
        TextView tv_overview;
        @BindView(R.id.tv_release_date)
        TextView tv_release_date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

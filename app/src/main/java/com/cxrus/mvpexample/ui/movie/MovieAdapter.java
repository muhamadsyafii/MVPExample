package com.cxrus.mvpexample.ui.movie;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cxrus.mvpexample.R;
import com.cxrus.mvpexample.model.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;
    private List<Movie> movieList;


    public MovieAdapter(Context context) {
        this.context = context;
    }
    public void setMovieAdapter(List<Movie> movieList){
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.tv_title.setText(movie.getTitle());
        holder.tv_overview.setText(movie.getOverview());
        holder.tv_release_date.setText(movie.getRelease_date());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + movie.getPoster_path())
                .into(holder.iv_poster);

        Log.e("Adapter", "Data nya :" + movie.getTitle());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_poster)
        ImageView iv_poster;
        @BindView(R.id.tv_title)
        TextView tv_title;
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

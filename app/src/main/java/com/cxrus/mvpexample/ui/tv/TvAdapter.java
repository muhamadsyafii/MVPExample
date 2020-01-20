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
import com.cxrus.mvpexample.model.Tv;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TvAdapter extends RecyclerView.Adapter<TvAdapter.ViewHolder> {
    private Context context;
    private List<Tv> tvList;

    public TvAdapter(Context context) {
        this.context = context;
    }
    public void setTvAdapter(List<Tv> tvList){
        this.tvList = tvList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tv,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tv tv = tvList.get(position);
        holder.tv_title_tv.setText(tv.getOriginal_name());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + tv.getBackdrop_path())
                .into(holder.iv_poster_tv);
    }

    @Override
    public int getItemCount() {
        return tvList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_poster_tv)
        ImageView iv_poster_tv;
        @BindView(R.id.tv_title_tv)
        TextView tv_title_tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

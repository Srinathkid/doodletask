package com.srinath.doodletask;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {
    private Context mContext;
    private List<CardDetails> cardLists;
    DisplayMetrics displaymetrics;
    int devicewidth, deviceheight;
    private static ClickListener clickListener;

    public CardAdapter(Context mContext, List<CardDetails> cardLists) {

        this.mContext = mContext;
        this.cardLists = cardLists;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_items, parent, false);
        displaymetrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        devicewidth = displaymetrics.widthPixels / 2;


        deviceheight = displaymetrics.heightPixels / 6;
        itemView.getLayoutParams().width = devicewidth;

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CardDetails cardDetails = cardLists.get(position);
        String dist_str = String.valueOf(cardDetails.getDistance());
        String rating_str = String.valueOf(cardDetails.getRating());
        holder.title.setText(cardDetails.getPlace_name());


        holder.card_image.getLayoutParams().width = devicewidth;
        holder.card_image.getLayoutParams().height = deviceheight;
        holder.distance.setText(dist_str);
        holder.rating.setText(rating_str);


    }


    @Override
    public int getItemCount() {
        return cardLists.size();
    }
    public void setOnItemClickListener(ClickListener clickListener) {
        CardAdapter.clickListener = clickListener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title, distance, rating;
        public ImageView card_image;

        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            title = (TextView) view.findViewById(R.id.card_title);
            distance = (TextView) view.findViewById(R.id.card_distance);
            rating = (TextView) view.findViewById(R.id.card_rating);
            card_image = (ImageView) view.findViewById(R.id.card_image_view);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), view);
        }
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

}


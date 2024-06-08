package com.example.jsonparsing.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonparsing.Model.RetroPhoto;
import com.example.jsonparsing.R;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private Context mContext;
    private List<RetroPhoto> dataList;

    public CustomAdapter(Context mContext, List<RetroPhoto> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyler_item, parent, false);
        return new CustomViewHolder(view, view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.textView.setText(dataList.get(position).getTitle());

        Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.downloader(new OkHttp3Downloader(mContext));

        builder.build().load(dataList.get(position).getThumbnailUrl()).placeholder(R.drawable.ic_launcher_foreground).error(android.R.drawable.ic_menu_report_image).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mview;

        TextView textView;
        private ImageView imageView;

        public CustomViewHolder(@NonNull View itemView, View mview) {
            super(itemView);
            this.mview = mview;

            textView = mview.findViewById(R.id.api_txt_text_view);
            imageView = mview.findViewById(R.id.api_img_image_view);


        }
    }


}

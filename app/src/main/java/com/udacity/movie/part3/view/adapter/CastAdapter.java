package com.udacity.movie.part3.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.udacity.movie.part3.R;
import com.udacity.movie.part3.database.entity.CastEntity;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static com.udacity.movie.part3.utils.AppConstants.POSTER_BASE_PATH;


public class CastAdapter extends RecyclerView.Adapter<CastAdapter.MyViewHolder> {
    private List<CastEntity> castList;
    private Context context;

    public CastAdapter(Context context) {
        this.context = context;
    }

    public void addCasts(List<CastEntity> castList) {
        this.castList = castList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_cast, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (castList != null) {
            return castList.size();
        } else {
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imv_cast)
        ImageView imvCast;
        @BindView(R.id.txv_cast_name)
        TextView txvCast;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void onBind(final int position) {

            final CastEntity data = castList.get(position);

            MultiTransformation<Bitmap> multi = new MultiTransformation<>(
                    new CenterCrop(),
                    new RoundedCornersTransformation(36, 0, RoundedCornersTransformation.CornerType.ALL));

            if (data.getProfilePath() != null) {
                Glide.with(context)
                        .load(POSTER_BASE_PATH + data.getProfilePath())
                        .apply(new RequestOptions()
                                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                                .placeholder(R.drawable.movie_detail_placeholder)
                                .error(R.drawable.movie_detail_placeholder))
                        .apply(RequestOptions
                                .bitmapTransform(multi))
                        .into(imvCast);
            }

            if (data.getName() != null) {
                txvCast.setText(data.getName());
            }
        }
    }
}

package me.kaelaela.sample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import me.kaelaela.sample.R;

/**
 * 创建者     demo
 * 创建时间   2016/7/27 14:40
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 */
public class HomeAdapter extends  RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    ArrayList<Integer> items;
    public HomeAdapter(ArrayList<Integer> items) {
        this.items=items;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new HomeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false));
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {

        holder.imageView.setImageResource(items.get(position));
        holder.imageView.setTag(items.get(position));

    }


    @Override
    public int getItemCount() {
        if (items != null) {
            return items.size();
        }
        return 0;
    }


    class HomeViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public HomeViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);

        }
    }
}
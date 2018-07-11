package com.saiful.androidrxnetworkcalling;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by saiful on 7/12/18.
 */

public class AndroidVersionNameAdapter extends RecyclerView.Adapter<AndroidVersionNameAdapter.ViewHolder> {

    private ArrayList<Android> mAndroidList;

    public AndroidVersionNameAdapter(ArrayList<Android> androidList) {
        mAndroidList = androidList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_android_version, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTvName.setText(mAndroidList.get(position).getName());
        holder.mTvVersion.setText(mAndroidList.get(position).getVer());
        holder.mTvApi.setText(mAndroidList.get(position).getApi());
    }

    @Override
    public int getItemCount() {
        return mAndroidList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTvName,mTvVersion,mTvApi;
        public ViewHolder(View view) {
            super(view);

            mTvName = (TextView)view.findViewById(R.id.tv_name);
            mTvVersion = (TextView)view.findViewById(R.id.tv_version);
            mTvApi = (TextView)view.findViewById(R.id.tv_api_level);
        }
    }
}

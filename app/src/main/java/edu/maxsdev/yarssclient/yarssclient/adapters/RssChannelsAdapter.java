package edu.maxsdev.yarssclient.yarssclient.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.maxsdev.yarssclient.yarssclient.R;
import edu.maxsdev.yarssclient.yarssclient.entities.RssChannel;

/**
 * Created by maxsdev on 09.02.2017.
 *
 */

class RssChannelsAdapter extends RecyclerView.Adapter<RssChannelsAdapter.RssChannelsViewHolder> {

    private List<RssChannel> channels;
    private OnItemClickListener listener;

    public RssChannelsAdapter(List<RssChannel> channels, OnItemClickListener listener) {
        this.channels = channels;
        this.listener = listener;
    }

    @Override
    public RssChannelsAdapter.RssChannelsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RssChannelsViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.channels_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RssChannelsAdapter.RssChannelsViewHolder holder, int position) {
        holder.bind(channels.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return channels.size();
    }

    static class RssChannelsViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        RssChannelsViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.name);
        }

        void bind(final RssChannel channel, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(channel);
                }
            });
            tvName.setText(channel.getName());
        }
    }
}

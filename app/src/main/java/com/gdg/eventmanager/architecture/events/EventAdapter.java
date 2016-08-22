package com.gdg.eventmanager.architecture.events;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gdg.eventmanager.R;
import com.gdg.eventmanager.model.Event;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atilabraga on 8/18/16.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    public interface OnEventClickListener {
        void onEventClick(Event event);
        void onScheduleClick(Event event);
        void onShareClick(Event event);
    }

    List<Event> list;
    OnEventClickListener listener;

    public EventAdapter(List<Event> list) {
        this.list = new ArrayList<>();
        if (list == null) return;
        this.list.addAll(list);
    }

    public void update(List<Event> list) {
        if (list == null) return;
        this.list.clear();
        this.list.addAll(list);
    }

    public void setListener(OnEventClickListener listener) {
        this.listener = listener;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    class EventViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.event_item_iv_banner)
        ImageView ivBanner;
        @BindView(R.id.event_item_tv_name)
        TextView tvName;
        @BindView(R.id.event_item_iv_status)
        ImageView ivStatus;
        @BindView(R.id.event_item_iv_schedule)
        ImageView ivSchedule;
        @BindView(R.id.event_item_iv_share)
        ImageView ivShare;
        View itemView;

        public EventViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
        }

        void bind(final Event event) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onEventClick(event);
                }
            });
            tvName.setText(event.getTitle());
            ivSchedule.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onScheduleClick(event);
                }
            });
            ivShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onShareClick(event);
                }
            });
        }
    }

}

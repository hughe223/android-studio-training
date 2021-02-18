package com.example.roomhw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QAListAdapter extends RecyclerView.Adapter<QAListAdapter.QAViewHolder> {

    private final LayoutInflater mInflater;
    private List<QAPair> mPairs; // Cached copy of words

    QAListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public QAViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new QAViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(QAViewHolder holder, int position) {
        if (mPairs != null) {
            QAPair current = mPairs.get(position);
            holder.wordItemView.setText(current.getQuestion());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
        }
    }

    void setPair(List<QAPair> pairs){
        mPairs = pairs;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mPairs != null)
            return mPairs.size();
        else return 0;
    }

    class QAViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private QAViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }

}

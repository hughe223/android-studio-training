package com.example.roomhw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QListAdapter extends RecyclerView.Adapter<QListAdapter.QAViewHolder> {

    private final LayoutInflater mInflater;
    private List<Question> mQuestions; // Cached copy of words

    QListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public QAViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new QAViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(QAViewHolder holder, int position) {
        if (mQuestions != null) {
            Question current = mQuestions.get(position);
            holder.wordItemView.setText(current.getQuestion());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
        }
    }

    void setPair(List<Question> questions){
        mQuestions = questions;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mQuestions != null)
            return mQuestions.size();
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

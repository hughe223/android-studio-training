package com.example.a45hw;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {
    public static final String EXTRA_NAME = "com.example.a45hw.EXTRA.NAME";
    private final LinkedList<String> mRecipeTitle;
    private final LinkedList<String> mRecipeDescription;
    private LayoutInflater mLayoutInflater;


    RecipeListAdapter(Context context, LinkedList<String> recipeTitle, LinkedList<String> recipeDescription){
        mLayoutInflater = LayoutInflater.from(context);
        this.mRecipeTitle = recipeTitle;
        this.mRecipeDescription = recipeDescription;
    }

    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mLayoutInflater.inflate(R.layout.recipelist_item, parent, false);
        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder holder, int position) {
        String mCurrentTitle = mRecipeTitle.get(position);
        String mCurrentDescription = mRecipeDescription.get(position);
        holder.recipeTitleTextView.setText(mCurrentTitle);
        holder.recipeDescriptionTextView.setText(mCurrentDescription);
    }

    @Override
    public int getItemCount() {
        return mRecipeTitle.size();
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        final TextView recipeTitleTextView;
        final TextView recipeDescriptionTextView;
        final RecipeListAdapter mAdapter;


        RecipeViewHolder(View itemView, RecipeListAdapter adapter){
            super(itemView);
            recipeTitleTextView = itemView.findViewById(R.id.recipe_title_text);
            recipeDescriptionTextView = itemView.findViewById(R.id.recipe_description_text);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String element = mRecipeTitle.get(mPosition);
            Intent intent = new Intent(v.getContext(), SecondActivity.class);
            Bundle extra = new Bundle();
            extra.putString(EXTRA_NAME, element);
            intent.putExtras(extra);
            v.getContext().startActivity(intent);
        }
    }

}

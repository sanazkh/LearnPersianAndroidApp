/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.persianfunapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.persianfunapp.R;

import java.util.ArrayList;

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Word} objects.
 */
public class WordAdapter extends ArrayAdapter<Word>  {


    private int colorID;
    public WordAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public WordAdapter(Activity context, ArrayList<Word> words, int mColorID) {
        super(context, 0, words);
        colorID = mColorID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView persianTextView = (TextView) listItemView.findViewById(R.id.persian_text_view);

        persianTextView.setText(currentWord.getPersianTranslation());
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_text_view);

        englishTextView.setText(currentWord.getEnglishTranslation());
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentWord.hasImage()){

            iconView.setImageResource(currentWord.getImageResourceID());
            iconView.setVisibility(View.VISIBLE);
        }
        else{
            iconView.setVisibility(View.GONE);
        }

        View textcont = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), colorID);
        textcont.setBackgroundColor(color);
        return listItemView;
    }
}
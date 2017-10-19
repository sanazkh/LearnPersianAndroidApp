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

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains resource IDs for the default translation, Miwok translation, audio file, and
 * optional image file for that word.
 */
public class Word {

    private String englishWord;
    private String persianWord;


    private int imageId = NO_IMAGE_PROVIDED;

    private int audioResourceID;

    private static final int NO_IMAGE_PROVIDED = -1;


    public String getEnglishWord() {
        return englishWord;
    }

    public String getPersianWord() {
        return persianWord;
    }

    public int getImageId(){
        return imageId;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public void setPersianWord(String persianWord) {
        this.persianWord = persianWord;
    }

    public void setImageId(int imageId){
        this.imageId = imageId;
    }

    public Word(String menglishWord, String mpersianWord, int mAudioID){
        englishWord = menglishWord;
        persianWord = mpersianWord;
        audioResourceID = mAudioID;
    }

    public Word(String menglishWord, String mpersianWord){
        englishWord = menglishWord;
        persianWord = mpersianWord;
    }


    public Word(String menglishWord, String mpersianWord, int mImageID, int mAudioID){
        imageId = mImageID;
        englishWord = menglishWord;
        persianWord = mpersianWord;
        audioResourceID = mAudioID;

    }

    public String getEnglishTranslation(){
        return englishWord;
    }

    public String getPersianTranslation(){
        return persianWord;
    }

    public int getImageResourceID(){
        return imageId;
    }

    public boolean hasImage(){
        return imageId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceID(){ return audioResourceID;}
}
package com.example.appbored;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Launchactivity extends AppCompatActivity { // необходимо сначала активити добавим в manifest

    private static final String PREF_IS_FIRST_LAUNCH = "is_first_launch"; // задать константную ключ
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //для сохрание состояние активити при запуске (проверка булеановой значание о первом запуске)
        //при проверке успользуемся SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean isFirstLaunch = sharedPreferences.getBoolean(PREF_IS_FIRST_LAUNCH,true); // передаем ключь и значение true по умолчанию

        //условия для запуска
        if (isFirstLaunch){
            sharedPreferences.edit().putBoolean(PREF_IS_FIRST_LAUNCH ,false).apply();
            IntroActivity.start(this);
        }else {
            MainActivity.start(this);
        }
        finish();
    }
}

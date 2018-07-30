package com.postscriptum.wallptest;

import android.app.WallpaperManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView wallpShow;
    private Button bNext;
    private Button bInstall;
    private final String nextResource = "R.drawable.u";
    private int countNumber;

    private List<Integer> listOfWallp = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfWallp.add(R.drawable.u1);
        listOfWallp.add(R.drawable.u2);
        listOfWallp.add(R.drawable.u3);
        listOfWallp.add(R.drawable.u4);
        listOfWallp.add(R.drawable.u5);
        listOfWallp.add(R.drawable.u6);
        listOfWallp.add(R.drawable.u7);

        wallpShow = (ImageView) findViewById(R.id.wallpShow);
        bNext = (Button) findViewById(R.id.NextWallpButton);
        bInstall = (Button) findViewById(R.id.InstallWallpButton);

        bNext.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countNumber > 5) {
                    countNumber = 0;
                } else {
                    countNumber++;
                }
                wallpShow.setImageResource(listOfWallp.get(countNumber));
            }
        });

        bInstall.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                try {
                    wallpaperManager.setResource(listOfWallp.get(countNumber));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

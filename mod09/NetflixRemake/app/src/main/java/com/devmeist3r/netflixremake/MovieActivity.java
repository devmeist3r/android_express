package com.devmeist3r.netflixremake;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class MovieActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movie);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back);
    }

    LayerDrawable drawable =
        (LayerDrawable) ContextCompat.getDrawable(this, R.drawable.shadows);

    if (drawable != null) {
     Drawable movieCover = ContextCompat.getDrawable(this, R.drawable.movie_4);
      drawable.setDrawableByLayerId(R.id.cover_drawble, movieCover);
      ((ImageView) findViewById(R.id.image_view_cover)).setImageDrawable(drawable);
    }

  }
}
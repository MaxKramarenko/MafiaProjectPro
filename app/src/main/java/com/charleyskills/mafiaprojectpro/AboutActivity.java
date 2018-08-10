package com.charleyskills.mafiaprojectpro;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class AboutActivity extends Activity
{
    TextView text_versionapp;
    private Intent toHomeActivityIntent;

    private TextView button_back;

    ImageView image_mafiaproject;
    LinearLayout.LayoutParams image_mafiaproject_Params;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        MafiaProjectProApp.setContext(this);

        overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);

        button_back = (TextView) findViewById(R.id.button_back);
        button_back.setTypeface(Typeface.create("serif", Typeface.BOLD));

        toHomeActivityIntent = new Intent(this, HomeActivity.class);

        text_versionapp = (TextView) findViewById(R.id.text_versionapp);
        text_versionapp.setText(MafiaProjectProApp.getContext().getString(R.string.app_name).toUpperCase() + " " + BuildConfig.VERSION_NAME);

        image_mafiaproject = (ImageView) findViewById(R.id.image_mafiaproject);
        image_mafiaproject_Params = new LinearLayout.LayoutParams(AppSettings.getDP(255), AppSettings.getDP(35));
        image_mafiaproject_Params.gravity = Gravity.CENTER_HORIZONTAL;
        image_mafiaproject_Params.setMargins(0, (((AppSettings.getDisplayHeight() - 252) / 8)), 0, 0);
        image_mafiaproject.setLayoutParams(image_mafiaproject_Params);
    }

    public void onBackPressed()
    {
        startActivity(toHomeActivityIntent);
        finish();
    }

    @Override
    public void onPause()
    {
        MafiaProjectProApp.setContext(null);
        super.onPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        MafiaProjectProApp.setContext(this);

        image_mafiaproject = (ImageView) findViewById(R.id.image_mafiaproject);
        image_mafiaproject_Params = new LinearLayout.LayoutParams(AppSettings.getDP(255), AppSettings.getDP(35));
        image_mafiaproject_Params.gravity = Gravity.CENTER_HORIZONTAL;
        image_mafiaproject_Params.setMargins(0, (((AppSettings.getDisplayHeight() - 252) / 8)), 0, 0);
        image_mafiaproject.setLayoutParams(image_mafiaproject_Params);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                findViewById(R.id.button_back).setClickable(false);
                startActivity(toHomeActivityIntent);
                finish();
            }
        });
    }
}

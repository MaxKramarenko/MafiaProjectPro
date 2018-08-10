package com.charleyskills.mafiaprojectpro;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.charleyskills.mafiaprojectpro.startgame.ChooseGameModeActivity;
import com.charleyskills.mafiaprojectpro.statistics.StatisticsActivity;
import com.charleyskills.mafiaprojectpro.theme.ThemeActivity;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class HomeActivity extends Activity
{
    FrameLayout home;

    ImageView mafiaproj_home;
    FrameLayout.LayoutParams mafiaproj_homeParams;
    TextView button_startgame;
    TextView button_statistics;
    TextView button_theme;
    TextView button_about;
    TextView button_exit;

    private Intent toAboutActivityIntent;
    private Intent toChooseGameModeIntent;
    private Intent toStatisticsActivityIntent;
    private Intent toThemeActivityIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MafiaProjectProApp.setContext(this);

        home = (FrameLayout) findViewById(R.id.home);

        if (AppSettings.AnimationMafiaLabel)
        {
            overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);
            AppSettings.AnimationMafiaLabel = false;
        }
        else
        {
            overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);
        }

        toAboutActivityIntent = new Intent(this, AboutActivity.class);
        toChooseGameModeIntent = new Intent(this, ChooseGameModeActivity.class);
        toStatisticsActivityIntent = new Intent(this, StatisticsActivity.class);
        toThemeActivityIntent = new Intent(this, ThemeActivity.class);

        button_startgame = (TextView) findViewById(R.id.text_startgame);
        button_statistics = (TextView) findViewById(R.id.text_statistics);
        button_theme = (TextView) findViewById(R.id.text_theme);
        button_about = (TextView) findViewById(R.id.text_about);
        button_exit = (TextView) findViewById(R.id.text_exit);

        button_startgame.setTypeface(Typeface.create("serif", Typeface.BOLD));
        button_statistics.setTypeface(Typeface.create("serif", Typeface.BOLD));
        button_theme.setTypeface(Typeface.create("serif", Typeface.BOLD));
        button_about.setTypeface(Typeface.create("serif", Typeface.BOLD));
        button_exit.setTypeface(Typeface.create("serif", Typeface.BOLD));

        mafiaproj_home = new ImageView(this);
        mafiaproj_home.setBackgroundResource(R.drawable.pic_mafiaproject);
        mafiaproj_homeParams = new FrameLayout.LayoutParams(AppSettings.getDP(255), AppSettings.getDP(35));
        mafiaproj_homeParams.gravity = Gravity.CENTER_HORIZONTAL;
        mafiaproj_homeParams.setMargins(0, (((AppSettings.getDisplayHeight() - 252) / 8)), 0, 0);

        home.addView(mafiaproj_home, mafiaproj_homeParams);

        button_startgame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);
                button_startgame.setClickable(false);
                startActivity(toChooseGameModeIntent);
                finish();
            }
        });

        button_statistics.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);
                button_statistics.setClickable(false);
                startActivity(toStatisticsActivityIntent);
                finish();
            }
        });

        button_theme.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);
                button_theme.setClickable(false);
                AppSettings.getThemeResources();
                startActivity(toThemeActivityIntent);
                finish();
            }
        });

        button_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);
                button_about.setClickable(false);
                startActivity(toAboutActivityIntent);
                finish();
            }
        });

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(1);
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        MafiaProjectProApp.setContext(this);

        IO.deleteFromSD(IO.LWPstate, "LWPstate");
        IO.deleteFromSD(IO.LWPvotepos, "LWPvotepos");
        IO.deleteFromSD(IO.CUSTOMIZEGAMEstate, "CUSTOMIZEGAMEstate");
        IO.deleteFromSD(IO.SNARitems, "SNARitems");
        IO.deleteFromSD(IO.SNARadapterrole, "SNARadapterrole");
        IO.deleteFromSD(IO.GAMERitems, "GAMERitems");
    }

    public void onBackPressed() {
        showDialog(1);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == 1) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setMessage(R.string.close_app);
            adb.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    System.exit(0);
                }
            });
            adb.setNegativeButton(R.string.no, null);
            return adb.create();
        }
        return super.onCreateDialog(id);
    }

    @Override
    protected void onPause()
    {
        MafiaProjectProApp.setContext(null);
        super.onPause();
    }
}

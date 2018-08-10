package com.charleyskills.mafiaprojectpro.startgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.charleyskills.mafiaprojectpro.AppSettings;
import com.charleyskills.mafiaprojectpro.HomeActivity;
import com.charleyskills.mafiaprojectpro.IO;
import com.charleyskills.mafiaprojectpro.LoadingActivity;
import com.charleyskills.mafiaprojectpro.MafiaProjectProApp;
import com.charleyskills.mafiaprojectpro.R;
import com.charleyskills.mafiaprojectpro.greendesk.GreenDeskActivity;
import com.charleyskills.mafiaprojectpro.snar.SNARActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class ChooseGameModeActivity extends Activity
{
    static LinearLayout linearlayout_chooseGameMode;
    Intent toCustomizeGameActivityIntent;
    private Intent toHomeActivityIntent;

    TextView choosegamemode_textview;
    TextView choosegamemode_savedsetup;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_game_mode);

        MafiaProjectProApp.setContext(this);

        linearlayout_chooseGameMode = (LinearLayout) findViewById(R.id.linearlayout_chooseGameMode);

        overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);

        toHomeActivityIntent = new Intent(this, HomeActivity.class);
        toCustomizeGameActivityIntent = new Intent(this, CustomizeGameActivity.class);


        findViewById(R.id.button_presetclassic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MafiaProjectProApp.getContext());
                builder.setMessage(R.string.Question_setNicknames);
                builder.setCancelable(true);

                final Intent toGreenDesk = new Intent(MafiaProjectProApp.getContext(), GreenDeskActivity.class);

                builder.setPositiveButton(R.string.Question_setNicknames_yes, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        toGreenDesk.putExtra("doctor", 0);
                        toGreenDesk.putExtra("whore", 0);
                        toGreenDesk.putExtra("maniac", 0);
                        toGreenDesk.putExtra("sheriff", 1);
                        toGreenDesk.putExtra("godfather", 1);
                        toGreenDesk.putExtra("mafia", 2);
                        toGreenDesk.putExtra("civilian", 6);

                        toGreenDesk.putExtra("nickname_enable", AppSettings.NicknameAfterGreenDesk);
                        toGreenDesk.putExtra("gamemode", AppSettings.GameMode_Classic);
                        AppSettings.setLoadingIntent(toGreenDesk);
                        startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                        finish();
                    }
                });

                builder.setNegativeButton(R.string.Question_setNicknames_no, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        toGreenDesk.putExtra("doctor", 0);
                        toGreenDesk.putExtra("whore", 0);
                        toGreenDesk.putExtra("maniac", 0);
                        toGreenDesk.putExtra("sheriff", 1);
                        toGreenDesk.putExtra("godfather", 1);
                        toGreenDesk.putExtra("mafia", 2);
                        toGreenDesk.putExtra("civilian", 6);

                        toGreenDesk.putExtra("nickname_enable", AppSettings.NicknameInGreenDesk);
                        toGreenDesk.putExtra("gamemode", AppSettings.GameMode_Classic);
                        AppSettings.setLoadingIntent(toGreenDesk);
                        startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                        finish();
                    }
                });

                builder.setNeutralButton(R.string.Question_setNicknames_cancel, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        toGreenDesk.putExtra("doctor", 0);
                        toGreenDesk.putExtra("whore", 0);
                        toGreenDesk.putExtra("maniac", 0);
                        toGreenDesk.putExtra("sheriff", 1);
                        toGreenDesk.putExtra("godfather", 1);
                        toGreenDesk.putExtra("mafia", 2);
                        toGreenDesk.putExtra("civilian", 6);

                        toGreenDesk.putExtra("nickname_enable", AppSettings.NoNicknameGreenDesk);
                        toGreenDesk.putExtra("gamemode", AppSettings.GameMode_Classic);
                        AppSettings.setLoadingIntent(toGreenDesk);
                        startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                        finish();
                    }
                });

                builder.create();
                builder.show();
            }
        });

        findViewById(R.id.button_presetindaclub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent toSNARActivity = new Intent(MafiaProjectProApp.getContext(), SNARActivity.class);

                toSNARActivity.putExtra("gamemode", AppSettings.GameMode_InDaClub);
                AppSettings.setLoadingIntent(toSNARActivity);
                startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                finish();
            }
        });

        findViewById(R.id.button_presetcustomize).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toCustomizeGameActivityIntent.putExtra("gamemode", AppSettings.GameMode_Customize);
                startActivity(toCustomizeGameActivityIntent);
                finish();
            }
        });

        choosegamemode_textview = (TextView) findViewById(R.id.choosegamemode_textview);
        choosegamemode_textview.setTypeface(Typeface.create("serif", Typeface.NORMAL));

        choosegamemode_savedsetup = (TextView) findViewById(R.id.choosegamemode_savedsetup);
        choosegamemode_savedsetup.setTypeface(Typeface.create("serif", Typeface.NORMAL));
    }

    public void onBackPressed()
    {
        startActivity(toHomeActivityIntent);
        finish();
    }

    @Override
    protected void onPause()
    {
        MafiaProjectProApp.setContext(null);
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleAnalytics.getInstance(ChooseGameModeActivity.this).reportActivityStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        GoogleAnalytics.getInstance(ChooseGameModeActivity.this).reportActivityStop(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        MafiaProjectProApp.setContext(this);

        IO.deleteFromSD(IO.CUSTOMIZEGAMEstate, "CUSTOMIZEGAMEstate");

        if (AppSettings.getGamePresetLayouts().size() != 0)
        {
            findViewById(R.id.text_no_user_preset).setVisibility(View.GONE);

            for (int i = 0; i < AppSettings.getGamePresetLayouts().size(); i++)
            {
                AppSettings.getGamePresetLayouts().get(i).deinitiate_ChooseGameMode();
                if (i != 0)
                    AppSettings.getGamePresetLayouts().get(i).addBreaker_GamePresetLayout();
                AppSettings.getGamePresetLayouts().get(i).initiate_ChooseGameMode();
            }
        }
        else
        {
            findViewById(R.id.text_no_user_preset).setVisibility(View.VISIBLE);
        }
    }
}

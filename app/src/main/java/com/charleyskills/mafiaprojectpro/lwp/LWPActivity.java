package com.charleyskills.mafiaprojectpro.lwp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.charleyskills.mafiaprojectpro.AppSettings;
import com.charleyskills.mafiaprojectpro.HomeActivity;
import com.charleyskills.mafiaprojectpro.IO;
import com.charleyskills.mafiaprojectpro.LoadingActivity;
import com.charleyskills.mafiaprojectpro.Logger;
import com.charleyskills.mafiaprojectpro.MafiaProjectProApp;
import com.charleyskills.mafiaprojectpro.R;
import com.charleyskills.mafiaprojectpro.snar.GamerNumberListComparator;
import com.google.android.gms.analytics.GoogleAnalytics;

import java.util.ArrayList;
import java.util.Collections;

public class LWPActivity extends Activity
{
    public static int NoCalcResultGame = 0;
    public static int GameVictory = 1;
    public static int GameDefeat = 2;

    static public LinearLayout LWP;
    public static ContainerLWPState containerLWPState;
    public static ArrayList<ItemLWP> getItemInGlobalLWPList()
    {
        if(containerLWPState == null)
        {
            containerLWPState = new ContainerLWPState();
        }
        return containerLWPState.itemInGlobalLWPList;
    }

    public static ContainerPositionOfVoting containerPositionOfVoting = new ContainerPositionOfVoting();
    public static ArrayListOfPositionsInVoteList getContainerPositionOfVoting()
    {
        if(containerPositionOfVoting == null)
        {
            containerPositionOfVoting = new ContainerPositionOfVoting();
        }
        return containerPositionOfVoting.positionsInVoteList;
    }

    ScrollView scrollView_LWP;
    static LinearLayout horizontalPlayerVoteList_LWP;
    static LinearLayout horizontalLinearLayout_LWP;
    static HorizontalScrollView horizontalScrollView_LWP;
    static AlertDialog.Builder alertDialog_LWP;
    static AlertDialog.Builder alertDialog_voting_LWP;
    static ArrayAdapter<String> arrayAnotherThings;
    static AlertDialog.Builder anotherThings_LWP;
    static ViewGroup voting_LWP;
    private static AlertDialog.Builder adb1;

    boolean buttonStartAndPause = false;

    TextView lwp_title;

    boolean have_default_role = false;
    boolean black_role = false;
    boolean red_role = false;
    boolean other_role = false;
    boolean have_not_default_nickname = false;
    int count_teams = 0;

    WindowManager windowManager;
    LayoutInflater layoutInflater;
    ViewGroup windowLayout;
    TextView voting_cancel;
    TextView voting_ok;
    TextView voting_title;
    LinearLayout button_skirmish;
    WindowManager.LayoutParams wmparams;
    int secs;
    int mins;
    LayoutInflater layoutInflater_reference;

    private TextView timerValue;
    private TextView voting_timerValue;

    private Handler customHandler = new Handler();

    private long startTime = 0L;
    private long timeInMilliseconds = 0L;
    private long timeSwapBuff = 0L;
    private long updatedTime = 0L;

    private MediaPlayer[] mp = new MediaPlayer[2];
    private FrameLayout layout_skirmish;

    private Button button_timer_stop;
    private Button button_timer_start;

    private Button voting_button_timer_stop;
    private Button voting_button_timer_start;

    ImageButton q;
    private ImageButton show_roles;
    private FrameLayout goVoteLayout;
    private Runnable updateTimerThread = new Runnable()
    {
        public void run()
        {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

            updatedTime = timeSwapBuff + timeInMilliseconds;

            secs = (int) (updatedTime / 1000);
            mins = secs / 60;
            secs = secs % 60;
            timerValue.setText(String.format("%02d:%02d", mins, secs));
            voting_timerValue.setText(String.format("%02d:%02d", mins, secs));

            switch (secs)
            {
                case 50:
                    mp[0].start();
                    timerValue.setTextColor(getResources().getColor(R.color.Red));
                    voting_timerValue.setTextColor(getResources().getColor(R.color.Red));
                    break;

                case 59:
                    mp[1].start();
                    timerValue.setTextColor(getResources().getColor(R.color.Red));
                    voting_timerValue.setTextColor(getResources().getColor(R.color.Red));
                    break;

                default:
                    timerValue.setTextColor(getResources().getColor(R.color.White));
                    voting_timerValue.setTextColor(getResources().getColor(R.color.White));
                    break;
            }
            customHandler.postDelayed(this, 0);
        }
    };

    static void killAllVotesPlayers()
    {
        ArrayList<Integer> temp = new ArrayList<>(getContainerPositionOfVoting());
        for(Integer integer : temp)
        {
            getContainerPositionOfVoting().kill(integer);
        }
    }

    static void checkMafiaWin()
    {
        if (containerLWPState.possibleVotingPlayers != 0)
        {
            if (containerLWPState.checkMafiaWinShow)
            {
                int countMafia = 0;
                int countPlayers = 0;
                for (ItemLWP item : getItemInGlobalLWPList())
                {
                    if (item.activePlayer)
                    {
                        if (item.role.equals("_Maf_") || item.role.equals("_G_"))
                        {
                            countMafia++;
                        }
                        else
                        {
                            countPlayers++;
                        }
                    }
                }

                if (countMafia == countPlayers)
                {
                    containerLWPState.checkMafiaWinShow = false;
                    containerLWPState.checkCivilianWinShow = false;
                    adb1 = new AlertDialog.Builder(MafiaProjectProApp.getContext());
                    adb1.setMessage(R.string.voting_mafiawin);
                    adb1.setPositiveButton(R.string.ok, null);
                    adb1.create();
                    adb1.show();
                    containerLWPState.game_not_done = false;
                }
            }
        }
    }

    static void checkCivilianWin()
    {
        if (containerLWPState.possibleVotingPlayers != 0)
        {
            if (containerLWPState.checkCivilianWinShow)
            {
                int countMafia = 0;
                for (ItemLWP item : getItemInGlobalLWPList())
                {
                    if (item.activePlayer)
                    {
                        if (item.role.equals("_Maf_") || item.role.equals("_G_"))
                        {
                            countMafia++;
                        }
                    }
                }

                if (countMafia == 0)
                {
                    containerLWPState.checkCivilianWinShow = false;
                    containerLWPState.checkMafiaWinShow = false;
                    adb1 = new AlertDialog.Builder(MafiaProjectProApp.getContext());
                    adb1.setMessage(R.string.voting_civilianwin);
                    adb1.setPositiveButton(R.string.ok, null);
                    adb1.create();
                    adb1.show();
                    containerLWPState.game_not_done = false;
                }
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lwp);

        MafiaProjectProApp.setContext(this);

        button_timer_stop = (Button) findViewById(R.id.button_stop);
        button_timer_start = (Button) findViewById(R.id.button_start);

        q = (ImageButton) findViewById(R.id.q);
        show_roles = (ImageButton) findViewById(R.id.show_roles);
        goVoteLayout = (FrameLayout) findViewById(R.id.goVoteLayout);

        mp[0] = MediaPlayer.create(this, R.raw.ring_1);
        mp[1] = MediaPlayer.create(this, R.raw.ring_2);

        lwp_title = (TextView) findViewById(R.id.lwp_title);
        lwp_title.setTypeface(Typeface.create("serif", Typeface.NORMAL));

        windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        wmparams = new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL, WindowManager.LayoutParams.FIRST_SUB_WINDOW, PixelFormat.TRANSLUCENT);
        wmparams.gravity = Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL;

        windowLayout = (ViewGroup) layoutInflater.inflate(R.layout.window_voting, null);
        voting_LWP = (ViewGroup) windowLayout.findViewById(R.id.voting_LWP);
        layout_skirmish = (FrameLayout) windowLayout.findViewById(R.id.layout_skirmish);
        voting_cancel = (TextView) windowLayout.findViewById(R.id.voting_cancel);
        voting_cancel.setTypeface(Typeface.create("serif", Typeface.BOLD));
        voting_ok = (TextView) windowLayout.findViewById(R.id.voting_ok);
        voting_ok.setTypeface(Typeface.create("serif", Typeface.BOLD));
        voting_title = (TextView) windowLayout.findViewById(R.id.voting_title);
        voting_title.setTypeface(Typeface.create("serif", Typeface.NORMAL));

        voting_button_timer_stop = (Button) windowLayout.findViewById(R.id.voting_button_stop);
        voting_button_timer_start = (Button) windowLayout.findViewById(R.id.voting_button_play);
        voting_timerValue = (TextView) windowLayout.findViewById(R.id.voting_timerValue);

        button_skirmish = (LinearLayout) windowLayout.findViewById(R.id.button_skirmish);

        // reference window

        layoutInflater_reference = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        horizontalPlayerVoteList_LWP = (LinearLayout) findViewById(R.id.horizontalPlayerVoteList_LWP);
        horizontalLinearLayout_LWP = (LinearLayout) findViewById(R.id.horizontalLinearLayout_LWP);
        horizontalScrollView_LWP = (HorizontalScrollView) findViewById(R.id.horizontalScrollView_LWP);

        overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);

        LWP = (LinearLayout) findViewById(R.id.LWP);
        scrollView_LWP = (ScrollView) findViewById(R.id.scrollView_LWP);

        timerValue = (TextView) findViewById(R.id.timerValue);

        setupAlertDialog();

        button_timer_start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (!buttonStartAndPause)
                {
                    button_timer_start.setBackgroundResource(R.drawable.button_pause);
                    voting_button_timer_start.setBackgroundResource(R.drawable.button_pause);
                    buttonStartAndPause = true;
                    startTime = SystemClock.uptimeMillis();
                    customHandler.postDelayed(updateTimerThread, 0);
                }
                else
                {
                    button_timer_start.setBackgroundResource(R.drawable.button_play);
                    voting_button_timer_start.setBackgroundResource(R.drawable.button_play);
                    buttonStartAndPause = false;
                    timeSwapBuff += timeInMilliseconds;
                    customHandler.removeCallbacks(updateTimerThread);
                }
            }
        });

        voting_button_timer_start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (!buttonStartAndPause)
                {
                    button_timer_start.setBackgroundResource(R.drawable.button_pause);
                    voting_button_timer_start.setBackgroundResource(R.drawable.button_pause);
                    buttonStartAndPause = true;
                    startTime = SystemClock.uptimeMillis();
                    customHandler.postDelayed(updateTimerThread, 0);
                }
                else
                {
                    button_timer_start.setBackgroundResource(R.drawable.button_play);
                    voting_button_timer_start.setBackgroundResource(R.drawable.button_play);
                    buttonStartAndPause = false;
                    timeSwapBuff += timeInMilliseconds;
                    customHandler.removeCallbacks(updateTimerThread);
                }
            }
        });

        button_timer_stop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                button_timer_start.setBackgroundResource(R.drawable.button_play);
                voting_button_timer_start.setBackgroundResource(R.drawable.button_play);
                buttonStartAndPause = false;

                startTime = 0L;
                timeInMilliseconds = 0L;
                timeSwapBuff = 0L;
                updatedTime = 0L;

                timerValue.setText(String.format("%02d:%02d", 0, 0));
                voting_timerValue.setText(String.format("%02d:%02d", 0, 0));
                customHandler.removeCallbacks(updateTimerThread);
            }
        });

        voting_button_timer_stop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                button_timer_start.setBackgroundResource(R.drawable.button_play);
                voting_button_timer_start.setBackgroundResource(R.drawable.button_play);
                buttonStartAndPause = false;

                startTime = 0L;
                timeInMilliseconds = 0L;
                timeSwapBuff = 0L;
                updatedTime = 0L;

                timerValue.setText(String.format("%02d:%02d", 0, 0));
                voting_timerValue.setText(String.format("%02d:%02d", 0, 0));
                customHandler.removeCallbacks(updateTimerThread);
            }
        });

        goVoteLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                containerLWPState.window_voting_showing = true;
                goVoteLayout.setClickable(false);
                button_timer_stop.performClick();
                voting_button_timer_stop.performClick();
                containerLWPState.avalableVotes = containerLWPState.possibleVotingPlayers;
                if(containerLWPState.counterSkirmish == 0)
                    layout_skirmish.setVisibility(View.GONE);
//                windowManager.removeView(windowLayout);
                windowManager.addView(windowLayout, wmparams);
                goVoteLayout.setClickable(true);
            }
        });

        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppSettings.brandAlertDialog(anotherThings_LWP.show());
            }
        });

        show_roles.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                {
                    for(ItemLWP item : getItemInGlobalLWPList())
                    {
                        show_roles.setBackgroundResource(R.drawable.pic_eye_hover);
                        if(item.role.equals("_Maf_") || item.role.equals("_G_"))
                        {
                            if (item.numberInList + 1 < 10)
                            {
                                item.tTextNickname.setText(String.format("%d.  %s", item.numberInList + 1, AppSettings.getFullNameRole(item.role)));
                            }
                            else
                            {
                                item.tTextNickname.setText(String.format("%d.%s", item.numberInList + 1, AppSettings.getFullNameRole(item.role)));
                            }

                            if(item.activePlayer)
                            {
                                item.tTextNickname.setTextColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.Red));
                            }
                            else
                            {
                                item.tTextNickname.setTextColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.DarkRed));
                            }
                        }
                        else
                        {
                            if (item.numberInList + 1 < 10)
                            {
                                item.tTextNickname.setText(String.format("%d.  %s", item.numberInList + 1, AppSettings.getFullNameRole(item.role)));
                            }
                            else
                            {
                                item.tTextNickname.setText(String.format("%d.%s", item.numberInList + 1, AppSettings.getFullNameRole(item.role)));
                            }

                            if(item.activePlayer)
                            {
                                item.tTextNickname.setTextColor(Color.WHITE);
                            }
                            else
                            {
                                item.tTextNickname.setTextColor(Color.GRAY);
                            }
                        }
                    }
                    return true;
                }
                else
                if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                {
                    show_roles.setBackgroundResource(R.drawable.pic_eye);
                    for(ItemLWP item : getItemInGlobalLWPList())
                    {
                        if (item.numberInList + 1 < 10)
                        {
                            item.tTextNickname.setText(String.format("%d.  %s", item.numberInList + 1, item.nickname));
                        }
                        else
                        {
                            item.tTextNickname.setText(String.format("%d.%s", item.numberInList + 1, item.nickname));
                        }

                        if(item.activePlayer)
                        {
                            item.tTextNickname.setTextColor(Color.WHITE);
                        }
                        else
                        {
                            item.tTextNickname.setTextColor(Color.GRAY);
                        }
                    }
                    return true;
                }
                return false;
            }
        });

        voting_cancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                voting_cancel.setClickable(false);
                windowManager.removeView(windowLayout);
                for (Integer i : getContainerPositionOfVoting())
                {
                    getItemInGlobalLWPList().get(i).countOfVoting_voting = 0;
                    getItemInGlobalLWPList().get(i).tCountOfVoting_voting.setText("0");
                }
                voting_cancel.setClickable(true);
                containerLWPState.window_voting_showing = false;

                button_timer_stop.performClick();
            }
        });

        voting_ok.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                voting_ok.setClickable(false);
                adb1 = new AlertDialog.Builder(MafiaProjectProApp.getContext());

                if (calculateVotes_allZeroVotes())
                {
                    adb1.setMessage(R.string.voting_gamecontinues);
                    adb1.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            ArrayList<Integer> temp = new ArrayList<Integer>(getContainerPositionOfVoting());
                            for (Integer integer : temp)
                            {
                                getContainerPositionOfVoting().custom_remove(integer);
                            }
                            windowManager.removeView(windowLayout);
                            horizontalPlayerVoteList_LWP.setVisibility(View.GONE);
                            containerLWPState.window_voting_showing = false;
                            containerLWPState.counterSkirmish = 0;
                            button_timer_stop.performClick();
                        }
                    });
                }
                else
                {
                    final ArrayList<Integer> arrayList_NumberInList = new ArrayList<Integer>(calculateVotes_findSameVotes());
                    if (arrayList_NumberInList.size() > 1)
                    {
                        adb1.setMessage(MafiaProjectProApp.getContext().getString(R.string.voting_shotingbetween));
                        adb1.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                ArrayList<Integer> temp = new ArrayList<Integer>(getContainerPositionOfVoting());
                                for (Integer integer : temp)
                                {
                                    if (!arrayList_NumberInList.contains(getItemInGlobalLWPList().get(integer).numberInList))
                                    {
                                        getContainerPositionOfVoting().custom_remove(integer);
                                    }
                                    else
                                    {
                                        getItemInGlobalLWPList().get(integer).countOfVoting_voting = 0;
                                        getItemInGlobalLWPList().get(integer).tCountOfVoting_voting.setText("0");
                                    }
                                }
                            }
                        });
                        containerLWPState.counterSkirmish++;
                        if (containerLWPState.counterSkirmish == 1)
                        {
                            layout_skirmish.setVisibility(View.VISIBLE);
                        }
                    }
                    else
                    {
                        adb1.setMessage(getItemInGlobalLWPList().get(arrayList_NumberInList.get(0)).nickname + " " + MafiaProjectProApp.getContext().getString(R.string.leftthegame));
                        adb1.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                getContainerPositionOfVoting().kill(arrayList_NumberInList.get(0));
                                ArrayList<Integer> temp = new ArrayList<Integer>(getContainerPositionOfVoting());
                                for(Integer integer : temp)
                                {
                                    getContainerPositionOfVoting().custom_remove(integer);
                                }
                                horizontalPlayerVoteList_LWP.setVisibility(View.GONE);
                                windowManager.removeView(windowLayout);
                                containerLWPState.window_voting_showing = false;
                                containerLWPState.counterSkirmish = 0;

                                button_timer_stop.performClick();
                            }
                        });
                    }
                }
                adb1.create();
                adb1.show();
                voting_ok.setClickable(true);
            }
        });

        button_skirmish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_skirmish.setClickable(false);
                adb1 = new AlertDialog.Builder(MafiaProjectProApp.getContext());
                adb1.setMessage(MafiaProjectProApp.getContext().getString(R.string.voting_skirmish));
                adb1.setNegativeButton(R.string.no, null);
                adb1.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        killAllVotesPlayers();
                        horizontalPlayerVoteList_LWP.setVisibility(View.GONE);
                        windowManager.removeView(windowLayout);

                        button_timer_stop.performClick();
                    }
                });
                adb1.create();
                adb1.show();
                button_skirmish.setClickable(true);
            }
        });

        try
        {
            LWPActivity.containerLWPState = (ContainerLWPState) IO.readFromSD(ContainerLWPState.class, IO.LWPstate, "LWPstate");
            LWPActivity.containerPositionOfVoting = (ContainerPositionOfVoting) IO.readFromSD(ContainerPositionOfVoting.class, IO.LWPvotepos, "LWPvotepos");
            if(containerLWPState.window_voting_showing)
            {
                goVoteLayout.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        goVoteLayout.performClick();
                    }
                });
            }
        }
        catch (Exception e)
        {
            Logger.e("LWPState", e.toString());
            e.printStackTrace();

            containerLWPState = null;
            if(getIntent().getIntExtra("PreviousActivity", AppSettings.FromGreenDesk) == AppSettings.FromGreenDesk)
            {
                Collections.sort(AppSettings.getContainerGreenDeskState().gamerArrayList, new GamerNumberListComparator());
                for (int i = 0; i < AppSettings.getContainerGreenDeskState().gamerArrayList.size(); i++)
                {
                    getItemInGlobalLWPList().add(new ItemLWP(i, AppSettings.getContainerGreenDeskState().gamerArrayList.get(i).role, AppSettings.getContainerGreenDeskState().gamerArrayList.get(i).nickname, AppSettings.getContainerGreenDeskState().gamerArrayList.get(i).defaultNickname));
                }
                AppSettings.containerGamerItems = null;
                containerLWPState.possibleVotingPlayers = getItemInGlobalLWPList().size();
            }
            else
            {
                for (int i = 0; i < AppSettings.getContainerSNARItems().size(); i++)
                {
                    getItemInGlobalLWPList().add(new ItemLWP(i, AppSettings.getContainerSNARItems().get(i).role, AppSettings.getContainerSNARItems().get(i).nickname, AppSettings.getContainerSNARItems().get(i).defaultNickname));
                }
                AppSettings.containerGamerItems = null;
                AppSettings.containerSNARItems = null;
                containerLWPState.possibleVotingPlayers = getItemInGlobalLWPList().size();
            }
        }

        System.gc();
    }

    void setupAlertDialog()
    {
        alertDialog_LWP = new AlertDialog.Builder(MafiaProjectProApp.getContext());
        alertDialog_LWP.setNegativeButton(MafiaProjectProApp.getContext().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog_voting_LWP = new AlertDialog.Builder(MafiaProjectProApp.getContext());
        alertDialog_voting_LWP.setNegativeButton(R.string.cancel, null);

        arrayAnotherThings = new ArrayAdapter<String>(MafiaProjectProApp.getContext(), android.R.layout.select_dialog_item);
        arrayAnotherThings.add(MafiaProjectProApp.getContext().getString(R.string.endgame_LWP));

        anotherThings_LWP = new AlertDialog.Builder(MafiaProjectProApp.getContext());
        anotherThings_LWP.setTitle(MafiaProjectProApp.getContext().getString(R.string.anotherthings_LWP));
        anotherThings_LWP.setNegativeButton(MafiaProjectProApp.getContext().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        anotherThings_LWP.setAdapter(arrayAnotherThings, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        showDialog(1);
                        break;
                }
            }
        });
    }

    public void onBackPressed()
    {
        showDialog(1);
    }

    protected Dialog onCreateDialog(int id)
    {
        switch (id)
        {
            case 1:
                adb1 = new AlertDialog.Builder(this);
                adb1.setCancelable(false);

                if(containerLWPState.game_not_done)
                {
                    for (ItemLWP item : getItemInGlobalLWPList())
                    {
                        if(!item.defaultNickname)
                        {
                            have_not_default_nickname = true;
                        }

                        if ((item.role.equals("_Maf_") || item.role.equals("_G_")) && !black_role)
                        {
                            have_default_role = true;
                            black_role = true;
                            count_teams++;
                        }
                        else
                        if ((item.role.equals("_D_") || item.role.equals("_C_") || item.role.equals("_S_")) && !red_role)
                        {
                            have_default_role = true;
                            red_role = true;
                            count_teams++;
                        }
                        else
                        if ((item.role.equals("_W_") || item.role.equals("_Man_")) && !other_role)
                        {
                            have_default_role = true;
                            other_role = true;
                            count_teams++;
                        }
                    }

                    if (have_default_role && have_not_default_nickname)
                    {
                        adb1.setMessage(R.string.LWP_endgame);
                        adb1.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                customHandler.removeCallbacks(updateTimerThread);
                                if(count_teams == 1)
                                {
                                    if(black_role)
                                    {
                                        calcStatisticsBlackTeamWin();
                                        IO.writeToSD(AppSettings.containerOfAllPlayersStatistic, IO.STATISTICSplayers, "writeSTAT");
                                        AppSettings.setLoadingIntent(HomeActivity.class);
                                        startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                                        finish();
                                    }
                                    if(red_role)
                                    {
                                        calcStatisticsRedTeamWin();
                                        IO.writeToSD(AppSettings.containerOfAllPlayersStatistic, IO.STATISTICSplayers, "writeSTAT");
                                        AppSettings.setLoadingIntent(HomeActivity.class);
                                        startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                                        finish();
                                    }
                                    if(other_role)
                                    {
                                        calcStatisticsOtherTeamWin();
                                        IO.writeToSD(AppSettings.containerOfAllPlayersStatistic, IO.STATISTICSplayers, "writeSTAT");
                                        AppSettings.setLoadingIntent(HomeActivity.class);
                                        startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                                        finish();
                                    }
                                }
                                else
                                {
                                    showDialog(2);
                                }
                            }
                        });
                        adb1.setNeutralButton(R.string.LWP_no_just_left, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                customHandler.removeCallbacks(updateTimerThread);
                                AppSettings.setLoadingIntent(HomeActivity.class);
                                startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                                finish();
                            }
                        });
                    }
                    else
                    {
                        adb1.setMessage(R.string.end_game);
                        adb1.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                customHandler.removeCallbacks(updateTimerThread);
                                calcStatisticsBlackTeamWin();
                                IO.writeToSD(AppSettings.containerOfAllPlayersStatistic, IO.STATISTICSplayers, "writeSTAT");
                                AppSettings.setLoadingIntent(HomeActivity.class);
                                startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                                finish();
                            }
                        });
                    }
                }
                else
                {
                    adb1.setMessage(R.string.end_game);
                    adb1.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            customHandler.removeCallbacks(updateTimerThread);
                            calcStatisticsBlackTeamWin();
                            IO.writeToSD(AppSettings.containerOfAllPlayersStatistic, IO.STATISTICSplayers, "writeSTAT");
                            AppSettings.setLoadingIntent(HomeActivity.class);
                            startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                            finish();
                        }
                    });
                }

                adb1.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        count_teams = 0;
                    }
                });
                return adb1.create();

            case 2:
                adb1 = new AlertDialog.Builder(this);
                adb1.setCancelable(false);
                adb1.setMessage(R.string.LWP_whowins);

                if(black_role)
                {
                    adb1.setPositiveButton(R.string.LWP_mafias, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            calcStatisticsBlackTeamWin();
                            IO.writeToSD(AppSettings.containerOfAllPlayersStatistic, IO.STATISTICSplayers, "writeSTAT");
                            AppSettings.setLoadingIntent(HomeActivity.class);
                            startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                            finish();
                        }
                    });
                }
                if(red_role)
                {
                    adb1.setNegativeButton(R.string.LWP_civilians, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            calcStatisticsRedTeamWin();
                            IO.writeToSD(AppSettings.containerOfAllPlayersStatistic, IO.STATISTICSplayers, "writeSTAT");
                            AppSettings.setLoadingIntent(HomeActivity.class);
                            startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                            finish();
                        }
                    });
                }
                if(other_role)
                {
                    adb1.setNeutralButton(R.string.LWP_maniacOrWhore, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            calcStatisticsOtherTeamWin();
                            IO.writeToSD(AppSettings.containerOfAllPlayersStatistic, IO.STATISTICSplayers, "writeSTAT");
                            AppSettings.setLoadingIntent(HomeActivity.class);
                            startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                            finish();
                        }
                    });
                }
                return adb1.create();
        }
        return super.onCreateDialog(id);
    }

    private void calcStatisticsRedTeamWin()
    {
        for (ItemLWP itemGlob : getItemInGlobalLWPList())
        {
            if (!itemGlob.defaultNickname)
            {
                if (itemGlob.role.equals("_C_") || itemGlob.role.equals("_S_") || itemGlob.role.equals("_D_"))
                    itemGlob.gameResult = LWPActivity.GameVictory;
                else
                    itemGlob.gameResult = LWPActivity.GameDefeat;
            }
        }
        calcStatistics();
    }

    private void calcStatisticsBlackTeamWin()
    {
        for (ItemLWP itemGlob : getItemInGlobalLWPList())
        {
            if (!itemGlob.defaultNickname)
            {
                if (itemGlob.role.equals("_Maf_") || itemGlob.role.equals("_G_"))
                    itemGlob.gameResult = LWPActivity.GameVictory;
                else
                    itemGlob.gameResult = LWPActivity.GameDefeat;
            }
        }
        calcStatistics();
    }

    private void calcStatisticsOtherTeamWin()
    {
        for (ItemLWP itemGlob : getItemInGlobalLWPList())
        {
            if (!itemGlob.defaultNickname)
            {
                if (itemGlob.role.equals("_W_") || itemGlob.role.equals("_Man_"))
                    itemGlob.gameResult = LWPActivity.GameVictory;
                else
                    itemGlob.gameResult = LWPActivity.GameDefeat;
            }
        }
        calcStatistics();
    }

    private void calcStatistics()
    {
        for (ItemLWP itemGlob : getItemInGlobalLWPList())
        {
            if (!itemGlob.defaultNickname)
            {
                AppSettings.getOrNewPlayerStatistics(itemGlob.nickname).played(itemGlob.role, itemGlob.gameResult);
            }
        }
    }

    private boolean calculateVotes_allZeroVotes()
    {
        for (Integer i : getContainerPositionOfVoting())
        {
            if (getItemInGlobalLWPList().get(i).countOfVoting_voting != 0)
                return false;
        }
        return true;
    }

    private ArrayList<Integer> calculateVotes_findSameVotes()
    {
        int maxVotesAtPlayer = 0;
        for (Integer i : getContainerPositionOfVoting())
        {
            if (maxVotesAtPlayer < getItemInGlobalLWPList().get(i).countOfVoting_voting)
            {
                maxVotesAtPlayer = getItemInGlobalLWPList().get(i).countOfVoting_voting;
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (Integer i : getContainerPositionOfVoting())
        {
            if (maxVotesAtPlayer == getItemInGlobalLWPList().get(i).countOfVoting_voting)
                arrayList.add(getItemInGlobalLWPList().get(i).numberInList);
        }
        return arrayList;
    }

    @Override
    protected void onPause()
    {
        IO.writeToSD(LWPActivity.containerLWPState, IO.LWPstate, "LWPstate");
        IO.writeToSD(LWPActivity.containerPositionOfVoting, IO.LWPvotepos, "LWPvotepos");
        MafiaProjectProApp.setContext(null);
        super.onPause();
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        GoogleAnalytics.getInstance(LWPActivity.this).reportActivityStart(this);
    }

    @Override
    protected void onStop()
    {
        customHandler.removeCallbacks(updateTimerThread);
        GoogleAnalytics.getInstance(LWPActivity.this).reportActivityStop(this);
        super.onStop();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        MafiaProjectProApp.setContext(this);
        IO.deleteFromSD(IO.LWPstate, "LWPstate");
    }
}

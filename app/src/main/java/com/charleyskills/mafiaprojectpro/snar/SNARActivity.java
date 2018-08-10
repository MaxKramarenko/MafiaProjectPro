package com.charleyskills.mafiaprojectpro.snar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.charleyskills.mafiaprojectpro.AppSettings;
import com.charleyskills.mafiaprojectpro.HomeActivity;
import com.charleyskills.mafiaprojectpro.IO;
import com.charleyskills.mafiaprojectpro.LoadingActivity;
import com.charleyskills.mafiaprojectpro.Logger;
import com.charleyskills.mafiaprojectpro.MafiaProjectProApp;
import com.charleyskills.mafiaprojectpro.R;
import com.charleyskills.mafiaprojectpro.lwp.LWPActivity;

import java.util.ArrayList;
import java.util.Collections;

public class SNARActivity extends Activity
{
    public static InputMethodManager imm;

    public static ArrayAdapter<String> arrayAdapter_role;
    public static LinearLayout snar_linearlayout;
    public static AlertDialog.Builder alertDialog_SNAR;
    TextView Next;
    TextView SNAR_title;
    int currentCustomGameMode;
    private Intent toLWPActivity;

    public static AlertDialog.Builder alertDialog_nameFromStat;
    public static ArrayAdapter<String> arrayAdapter_nameSTAT;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snar);

        MafiaProjectProApp.setContext(this);

        snar_linearlayout = (LinearLayout) findViewById(R.id.SNAR);
        Next = (TextView) findViewById(R.id.Next);
        Next.setTypeface(Typeface.create("serif", Typeface.BOLD));
        SNAR_title = (TextView) findViewById(R.id.SNAR_title);
        SNAR_title.setTypeface(Typeface.create("serif", Typeface.NORMAL));

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        toLWPActivity = new Intent(this, LWPActivity.class);
        toLWPActivity.putExtra("PreviousActivity", AppSettings.FromSNAR);

        AppSettings.getContainerSNARItems();

        alertDialog_nameFromStat = new AlertDialog.Builder(this);
        alertDialog_nameFromStat.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });

        arrayAdapter_nameSTAT = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, new ArrayList<String>());

        overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);

        findViewById(R.id.scrollView_SNAR).setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if (event.getAction() == MotionEvent.ACTION_MOVE)
                {
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
                return false;
            }
        });

        alertDialog_SNAR = new AlertDialog.Builder(this);
        alertDialog_SNAR.setCancelable(true);
        alertDialog_SNAR.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        try
        {
            AppSettings.containerSNARAdapterRoles = (ContainerSNARAdapterRoles) IO.readFromSD(ContainerSNARAdapterRoles.class, IO.SNARadapterrole, "SNARadapterrole");
            arrayAdapter_role = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, AppSettings.getContainerSNARAdapterRoles());
            AppSettings.containerSNARItems = (ContainerSNARItems) IO.readFromSD(ContainerSNARItems.class, IO.SNARitems, "SNARitems");
            if(AppSettings.getContainerSNARItems().get(0).noRole)
            {
                ((TextView) findViewById(R.id.SNAR_title)).setText(getResources().getText(R.string.SNAR_Title_2));
            }
            else
            {
                ((TextView) findViewById(R.id.SNAR_title)).setText(getResources().getText(R.string.SNAR_Title_1));
            }
        }
        catch (Exception e)
        {
            Logger.i("SNARitems/adapterrole", e.toString());
            e.printStackTrace();

            currentCustomGameMode = getIntent().getIntExtra("gamemode", AppSettings.GameMode_Customize);
            if (currentCustomGameMode == AppSettings.GameMode_Classic)
            {
                ((TextView) findViewById(R.id.SNAR_title)).setText(getResources().getText(R.string.SNAR_Title_2));

                Collections.sort(AppSettings.getContainerGreenDeskState().gamerArrayList, new GamerNumberListComparator());

                AppSettings.containerSNARItems = null;
                for (int i = 0; i < AppSettings.getContainerGreenDeskState().gamerArrayList.size(); i++)
                {
                    AppSettings.getContainerSNARItems().add(new ItemSNAR(i, AppSettings.getContainerGreenDeskState().gamerArrayList.get(i).role, true));
                }
            }
            else
            if (currentCustomGameMode == AppSettings.GameMode_InDaClub)
            {
                ((TextView) findViewById(R.id.SNAR_title)).setText(getResources().getText(R.string.SNAR_Title_1));

                AppSettings.containerSNARAdapterRoles = null;

                AppSettings.getContainerSNARAdapterRoles().add(getResources().getString(R.string.sheriff));
                AppSettings.getContainerSNARAdapterRoles().add(getResources().getString(R.string.godfather));
                AppSettings.getContainerSNARAdapterRoles().add(getResources().getString(R.string.mafia));
                AppSettings.getContainerSNARAdapterRoles().add(getResources().getString(R.string.civilian));

                arrayAdapter_role = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, AppSettings.getContainerSNARAdapterRoles());

                AppSettings.containerSNARItems = null;

                for (int i = 0; i < 10; i++)
                {
                    AppSettings.getContainerSNARItems().add(new ItemSNAR(i, false));
                }
            }
            else
            if (currentCustomGameMode == AppSettings.GameMode_Customize)
            {
                Collections.sort(AppSettings.getContainerGreenDeskState().gamerArrayList, new GamerNumberListComparator());

                AppSettings.containerSNARItems = null;
                AppSettings.containerSNARAdapterRoles = null;

                if (getIntent().getIntExtra("withcards", AppSettings.WithCards_Off) == AppSettings.WithCards_On)
                {
                    ((TextView) findViewById(R.id.SNAR_title)).setText(getResources().getText(R.string.SNAR_Title_2));

                    for (int i = 0; i < AppSettings.getContainerGreenDeskState().gamerArrayList.size(); i++)
                    {
                        AppSettings.getContainerSNARItems().add(new ItemSNAR(i, AppSettings.getContainerGreenDeskState().gamerArrayList.get(i).role, true));
                    }
                }
                else
                {
                    ((TextView) findViewById(R.id.SNAR_title)).setText(getResources().getText(R.string.SNAR_Title_1));

                    if (getIntent().getIntExtra("doctor", 0) != 0)
                    {
                        AppSettings.getContainerSNARAdapterRoles().add(getResources().getString(R.string.doctor));
                    }
                    if (getIntent().getIntExtra("whore", 0) != 0)
                    {
                        AppSettings.getContainerSNARAdapterRoles().add(getResources().getString(R.string.whore));
                    }
                    if (getIntent().getIntExtra("maniac", 0) != 0)
                    {
                        AppSettings.getContainerSNARAdapterRoles().add(getResources().getString(R.string.maniac));
                    }
                    if (getIntent().getIntExtra("sheriff", 0) != 0)
                    {
                        AppSettings.getContainerSNARAdapterRoles().add(getResources().getString(R.string.sheriff));
                    }
                    if (getIntent().getIntExtra("godfather", 0) != 0)
                    {
                        AppSettings.getContainerSNARAdapterRoles().add(getResources().getString(R.string.godfather));
                    }
                    if (getIntent().getIntExtra("mafia", 0) != 0)
                    {
                        AppSettings.getContainerSNARAdapterRoles().add(getResources().getString(R.string.mafia));
                    }
                    if (getIntent().getIntExtra("civilian", 0) != 0)
                    {
                        AppSettings.getContainerSNARAdapterRoles().add(getResources().getString(R.string.civilian));
                    }

                    ArrayList<String> temp = getIntent().getStringArrayListExtra("anotherrole");
                    if (temp != null)
                        AppSettings.getContainerSNARAdapterRoles().addAll(temp);

                    arrayAdapter_role = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, AppSettings.getContainerSNARAdapterRoles());

                    for (int i = 0; i < getIntent().getIntExtra("players", 10); i++)
                    {
                        AppSettings.getContainerSNARItems().add(new ItemSNAR(i, false));
                    }
                }
            }
        }

        Next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                for (int i = 0; i < AppSettings.getContainerSNARItems().size(); i++)
                {
                    if (AppSettings.getContainerSNARItems().get(i).role.equals(""))
                    {
                        Toast.makeText(MafiaProjectProApp.getContext(), getText(R.string.SNAR_noRole), Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                AppSettings.containerSNARAdapterRoles = null;
                AppSettings.setLoadingIntent(toLWPActivity);
                startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                System.gc();
                finish();
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
                AlertDialog.Builder adb1 = new AlertDialog.Builder(this);
                adb1.setMessage(R.string.end_game);
                adb1.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AppSettings.setLoadingIntent(HomeActivity.class);
                        startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                        finish();
                    }
                });
                adb1.setCancelable(false);
                adb1.setNegativeButton(R.string.no, null);
                return adb1.create();
        }
        return super.onCreateDialog(id);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        MafiaProjectProApp.setContext(this);

        IO.deleteFromSD(IO.SNARitems, "SNARitems");
        IO.deleteFromSD(IO.SNARadapterrole, "SNARadapterrole");
    }

    @Override
    protected void onPause()
    {
        for (int i = 0; i < AppSettings.getContainerSNARItems().size(); i++)
        {
            if (AppSettings.getContainerSNARItems().get(i).editText.getText().toString().equals("") || AppSettings.getContainerSNARItems().get(i).editText.getText().toString().equals(getText(R.string.voting_player) + " " + (i + 1)))
            {
                AppSettings.getContainerSNARItems().get(i).nickname = getText(R.string.voting_player) + " " + (i + 1);
                AppSettings.getContainerSNARItems().get(i).defaultNickname = true;
            }
            else
            {
                AppSettings.getContainerSNARItems().get(i).nickname = AppSettings.getContainerSNARItems().get(i).editText.getText().toString();
                AppSettings.getContainerSNARItems().get(i).defaultNickname = false;
            }
        }

        IO.writeToSD(AppSettings.containerSNARAdapterRoles, IO.SNARadapterrole, "SNARadapterrole");
        IO.writeToSD(AppSettings.containerSNARItems, IO.SNARitems, "SNARitems");
        MafiaProjectProApp.setContext(null);
        super.onPause();
    }
}

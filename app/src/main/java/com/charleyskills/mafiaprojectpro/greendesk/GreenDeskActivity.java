package com.charleyskills.mafiaprojectpro.greendesk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout;
import android.widget.ArrayAdapter;

import com.charleyskills.mafiaprojectpro.AppSettings;
import com.charleyskills.mafiaprojectpro.HomeActivity;
import com.charleyskills.mafiaprojectpro.IO;
import com.charleyskills.mafiaprojectpro.LoadingActivity;
import com.charleyskills.mafiaprojectpro.Logger;
import com.charleyskills.mafiaprojectpro.MafiaProjectProApp;
import com.charleyskills.mafiaprojectpro.R;
import com.charleyskills.mafiaprojectpro.statistics.ItemPlayerStatistics;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;
import java.util.Random;

public class GreenDeskActivity extends Activity
{
    public static InputMethodManager imm;

    public static AbsoluteLayout greendesk_layout;

    ArrayList<Node> pxXpxY = new ArrayList<Node>();
    int nickname_enable;

    public static AlertDialog.Builder alertDialog_nameFromStat;
    public static ArrayAdapter<String> arrayAdapter_nameSTAT;
    public static ArrayList<String> array_nicknamesSTAT;

    static void setBack_buttonBackground(int background)
    {
        for (Gamer gamer : AppSettings.getContainerGreenDeskState().gamerArrayList)
        {
            gamer.back_button.setBackgroundResource(background);
        }
    }

    static boolean notZeroState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_desk);

        MafiaProjectProApp.setContext(this);

        AppSettings.getThemeResources();

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);

        alertDialog_nameFromStat = new AlertDialog.Builder(this);
        alertDialog_nameFromStat.setTitle(R.string.GreenDeskActivity_chooseYourNickname);
        alertDialog_nameFromStat.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });

        array_nicknamesSTAT = new ArrayList<String>();
        for(ItemPlayerStatistics item : AppSettings.getPlayerStatistic())
        {
            array_nicknamesSTAT.add(item.name);
        }
        arrayAdapter_nameSTAT = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, array_nicknamesSTAT);

        greendesk_layout = (AbsoluteLayout) findViewById(R.id.GreenDesk);
        greendesk_layout.setBackgroundResource(AppSettings.getThemeResources().currentGreenDeskDrawableBackground);

        nickname_enable = getIntent().getIntExtra("nickname_enable", AppSettings.NoNicknameGreenDesk);

        AppSettings.containerGamerItems = null;

        try
        {
            AppSettings.containerGamerItems = (ContainerGamerItems) IO.readFromSD(ContainerGamerItems.class, IO.GAMERitems, "GAMERitems");
        }
        catch (Exception e)
        {
            Logger.i("GAMERitems", e.toString());
            e.printStackTrace();
            notZeroState = true;
            ArrayList<String> accidentalDistributeRoles = new ArrayList<>();

            for (int i = 0; i < getIntent().getIntExtra("doctor", 0); i++)
                accidentalDistributeRoles.add("_D_");

            for (int i = 0; i < getIntent().getIntExtra("whore", 0); i++)
                accidentalDistributeRoles.add("_W_");

            for (int i = 0; i < getIntent().getIntExtra("maniac", 0); i++)
                accidentalDistributeRoles.add("_Man_");

            for (int i = 0; i < getIntent().getIntExtra("sheriff", 0); i++)
                accidentalDistributeRoles.add("_S_");

            for (int i = 0; i < getIntent().getIntExtra("godfather", 0); i++)
                accidentalDistributeRoles.add("_G_");

            for (int i = 0; i < getIntent().getIntExtra("mafia", 0); i++)
                accidentalDistributeRoles.add("_Maf_");

            for (int i = 0; i < getIntent().getIntExtra("civilian", 0); i++)
                accidentalDistributeRoles.add("_C_");

            ArrayList<String> temp = getIntent().getStringArrayListExtra("anotherrole");
            if (temp != null)
                accidentalDistributeRoles.addAll(temp);

            int randFromADRList;
            int randFromCLList;
            int drawable;
            int sizeADR = accidentalDistributeRoles.size();
            coolPositionsOfCarts(sizeADR);
            Random r = new Random();
            for (int i = 0; i < sizeADR; i++)
            {
                randFromADRList = r.nextInt(accidentalDistributeRoles.size());
                randFromCLList = r.nextInt(pxXpxY.size());

                if (accidentalDistributeRoles.get(randFromADRList).equals("_C_"))
                {
                    drawable = AppSettings.getThemeResources().currentGreenDeskDrawableCivilian;
                }
                else
                if (accidentalDistributeRoles.get(randFromADRList).equals("_Maf_"))
                {
                    drawable = AppSettings.getThemeResources().currentGreenDeskDrawableMafia;
                }
                else
                if (accidentalDistributeRoles.get(randFromADRList).equals("_S_"))
                {
                    drawable = AppSettings.getThemeResources().currentGreenDeskDrawableSheriff;
                }
                else
                if (accidentalDistributeRoles.get(randFromADRList).equals("_G_"))
                {
                    drawable = AppSettings.getThemeResources().currentGreenDeskDrawableGodfather;
                }
                else
                if (accidentalDistributeRoles.get(randFromADRList).equals("_D_"))
                {
                    drawable = AppSettings.getThemeResources().currentGreenDeskDrawableDoctor;
                }
                else
                if (accidentalDistributeRoles.get(randFromADRList).equals("_W_"))
                {
                    drawable = AppSettings.getThemeResources().currentGreenDeskDrawableWhore;
                }
                else
                if (accidentalDistributeRoles.get(randFromADRList).equals("_Man_"))
                {
                    drawable = AppSettings.getThemeResources().currentGreenDeskDrawableManiac;
                }
                else
                {
                    drawable = AppSettings.getThemeResources().currentGreenDeskDrawableCivilian;
                }

                AppSettings.getContainerGreenDeskState().gamerArrayList.add(new Gamer(i, accidentalDistributeRoles.get(randFromADRList), drawable, pxXpxY.get(randFromCLList).x, pxXpxY.get(randFromCLList).y, Animation.RELATIVE_TO_SELF, 0, Animation.ABSOLUTE, (AppSettings.getDisplayWidth() / 2) - pxXpxY.get(randFromCLList).x - AppSettings.getDP(20), Animation.RELATIVE_TO_SELF, 0, Animation.ABSOLUTE, (AppSettings.getDisplayHeight() / 2) - pxXpxY.get(randFromCLList).y - AppSettings.getDP(29), Animation.ABSOLUTE, (AppSettings.getDisplayWidth() / 2) - pxXpxY.get(randFromCLList).x - AppSettings.getDP(20), Animation.RELATIVE_TO_SELF, 0, Animation.ABSOLUTE, -pxXpxY.get(randFromCLList).y - AppSettings.getDP(60), Animation.RELATIVE_TO_SELF, 0, 500 * i, nickname_enable));

                pxXpxY.remove(randFromCLList);
                accidentalDistributeRoles.remove(randFromADRList);
            }
            pxXpxY = null;
        }
    }

    static void setCardPressedFrontState(boolean state)
    {
        for(Gamer g : AppSettings.getContainerGreenDeskState().gamerArrayList)
        {
            g.pressed_front = state;
        }
    }

    static void setCardPressedBackState(boolean state)
    {
        AppSettings.containerGamerItems.global_pressed_back = state;
        for(Gamer g : AppSettings.getContainerGreenDeskState().gamerArrayList)
        {
            g.pressed_back = state;
        }
    }

    public void onBackPressed()
    {
        AlertDialog.Builder adb1 = new AlertDialog.Builder(MafiaProjectProApp.getContext());
        adb1.setMessage(R.string.end_game);
        adb1.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                AppSettings.setLoadingIntent(HomeActivity.class);
                MafiaProjectProApp.getContext().startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                System.gc();
                ((Activity) MafiaProjectProApp.getContext()).finish();
            }
        });
        adb1.setNegativeButton(R.string.no, null);
        adb1.create();
        adb1.show();
    }

    private void coolPositionsOfCarts(int players)
    {
        switch (players)
        {
            case 1:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                break;
            case 2:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                break;
            case 3:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                break;
            case 4:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                break;
            case 5:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                break;
            case 6:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                break;
            case 7:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                break;
            case 8:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 15 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 15 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                break;
            case 9:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 15 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 29 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 43 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                break;
            case 10:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 15 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 15 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 29 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 43 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 57 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                break;
            case 11:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 15 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 15 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 29 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 43 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 57 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                break;
            case 12:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 83 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 83 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 15 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 15 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 69 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 29 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                break;
            case 13:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 15 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 15 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 15 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 29 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 43 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 57 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                break;
            case 14:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 83 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 83 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 15 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 15 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 15 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 69 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 29 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                break;
            case 15:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 15 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 15 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 29 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 43 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 57 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 69 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 83 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 83 / 100));
                break;
            case 16:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 15 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 15 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 15 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 29 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 43 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 57 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 69 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 83 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 83 / 100));
                break;
            case 17:
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 15 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 15 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 15 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 29 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 29 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 43 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 43 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 57 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 57 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 7 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 44 / 100, AppSettings.getDisplayHeight() * 69 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 82 / 100, AppSettings.getDisplayHeight() * 69 / 100));

                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 25 / 100, AppSettings.getDisplayHeight() * 83 / 100));
                pxXpxY.add(new Node(AppSettings.getDisplayWidth() * 64 / 100, AppSettings.getDisplayHeight() * 83 / 100));
                break;
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        MafiaProjectProApp.setContext(this);
        IO.deleteFromSD(IO.GAMERitems, "GAMERitems");
    }

    @Override
    protected void onPause()
    {
        AppSettings.containerGamerItems.global_pressed_back = true;
        IO.writeToSD(AppSettings.containerGamerItems, IO.GAMERitems, "GAMERitems");
        MafiaProjectProApp.setContext(null);
        super.onPause();
    }
}
package com.charleyskills.mafiaprojectpro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.charleyskills.mafiaprojectpro.greendesk.ContainerGamerItems;
import com.charleyskills.mafiaprojectpro.lwp.LWPActivity;
import com.charleyskills.mafiaprojectpro.snar.ContainerSNARAdapterRoles;
import com.charleyskills.mafiaprojectpro.snar.ContainerSNARItems;
import com.charleyskills.mafiaprojectpro.snar.ItemSNAR;
import com.charleyskills.mafiaprojectpro.startgame.ContainerGamePresetLayoutList;
import com.charleyskills.mafiaprojectpro.startgame.GamePresetLayout;
import com.charleyskills.mafiaprojectpro.statistics.ContainerPlayerStatistic;
import com.charleyskills.mafiaprojectpro.statistics.ItemPlayerStatistics;
import com.charleyskills.mafiaprojectpro.theme.ContainerThemeResources;

import java.util.ArrayList;

public class AppSettings
{
    public static final int WithCards_On = -1;
    public static final int WithCards_Off = 1;

    public static final int GameMode_Classic = -1;
    public static final int GameMode_InDaClub = -2;
    public static final int GameMode_Customize = -3;

    public static final int NicknameAfterGreenDesk = -3;
    public static final int NicknameInGreenDesk = -2;
    public static final int NoNicknameGreenDesk = -1;

    public static final int FromGreenDesk = -1;
    public static final int FromSNAR = -2;

    public static final int max_players = 17;

    public static ContainerPlayerStatistic containerOfAllPlayersStatistic = null;
    public static ArrayList<ItemPlayerStatistics> getPlayerStatistic()
    {
        if(containerOfAllPlayersStatistic == null)
        {
            try
            {
                containerOfAllPlayersStatistic = (ContainerPlayerStatistic) IO.readFromSD(ContainerPlayerStatistic.class, IO.STATISTICSplayers, "readSTAT");
            }
            catch (Exception e)
            {
                Logger.e("SD:readSTAT", e.toString());
                e.printStackTrace();
                containerOfAllPlayersStatistic = new ContainerPlayerStatistic();
            }
        }
        return containerOfAllPlayersStatistic.arrayPlayersStatistics;
    }

    public static ContainerGamerItems containerGamerItems;
    public static ContainerGamerItems getContainerGreenDeskState()
    {
        if(containerGamerItems == null)
        {
            containerGamerItems = new ContainerGamerItems();
        }
        return containerGamerItems;
    }

    public static ContainerSNARItems containerSNARItems = null;
    public static ArrayList<ItemSNAR> getContainerSNARItems()
    {
        if(containerSNARItems == null)
        {
            containerSNARItems = new ContainerSNARItems();
        }
        return containerSNARItems.array_ItemSNAR;
    }

    public static ContainerSNARAdapterRoles containerSNARAdapterRoles = null;
    public static ArrayList<String> getContainerSNARAdapterRoles()
    {
        if(containerSNARAdapterRoles == null)
        {
            containerSNARAdapterRoles = new ContainerSNARAdapterRoles();
        }
        return containerSNARAdapterRoles.array_roles;
    }

    public static int getDisplayWidth()
    {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) MafiaProjectProApp.getContext()).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }
    public static int getDisplayHeight()
    {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) MafiaProjectProApp.getContext()).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }

    static ContainerThemeResources containerThemeResources = null;
    public static ContainerThemeResources getThemeResources()
    {
        if(containerThemeResources == null)
        {
            try
            {
                containerThemeResources = (ContainerThemeResources) IO.readFromSD(ContainerThemeResources.class, IO.THEMEconfig, "readTheme");
            }
            catch (Exception e)
            {
                Logger.e("SD:readTheme", e.toString());
                e.printStackTrace();
                containerThemeResources = new ContainerThemeResources();
            }
        }
        return containerThemeResources;
    }

    public static ArrayAdapter<String> LWParrayAdapter;
    public static ArrayAdapter<String> LWParrayAdapterSpinner;

    public static ContainerGamePresetLayoutList containerGamePresetLayoutsList = null;
    public static ArrayList<GamePresetLayout> getGamePresetLayouts()
    {
        if(containerGamePresetLayoutsList == null)
        {
            try
            {
                containerGamePresetLayoutsList = (ContainerGamePresetLayoutList) IO.readFromSD(ContainerGamePresetLayoutList.class, IO.GAMEPRESETconfig, "readGC");
            }
            catch (Exception e)
            {
                Logger.e("SD:readGC", e.toString());
                e.printStackTrace();
                containerGamePresetLayoutsList = new ContainerGamePresetLayoutList();
            }
        }
        return containerGamePresetLayoutsList.arrayGamePresetLayouts;
    }

    public static String[][] data_adapterAdapterSpinner = {{"0"}, {"0", "1"}, {"0", "1", "2"}, {"0", "1", "2", "3"}, {"0", "1", "2", "3", "4"}, {"0", "1", "2", "3", "4", "5"}, {"0", "1", "2", "3", "4", "5", "6"}, {"0", "1", "2", "3", "4", "5", "6", "7"}, {"0", "1", "2", "3", "4", "5", "6", "7", "8"}, {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}, {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}, {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}, {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}, {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"}, {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"}, {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}, {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"}, {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17"}};

    public static boolean AnimationMafiaLabel = true;
    static int sleepTime = 7;

    static Intent loadingIntent;

    public static ItemPlayerStatistics getOrNewPlayerStatistics(String nickname)
    {
        for (int i = 0; i < AppSettings.getPlayerStatistic().size(); i++)
        {
            if (AppSettings.getPlayerStatistic().get(i).name.equals(nickname))
            {
                return AppSettings.getPlayerStatistic().get(i);
            }
        }

        ItemPlayerStatistics ItemPlayerStatistics = new ItemPlayerStatistics(nickname);
        AppSettings.getPlayerStatistic().add(ItemPlayerStatistics);
        return ItemPlayerStatistics;
    }

    public static void reorder_GamePresetLayout()
    {
        for (int i = 0; i < AppSettings.getGamePresetLayouts().size(); i++)
        {
            AppSettings.getGamePresetLayouts().get(i).order = i;
        }
    }

    //////////////////////////////////

    public static void setLoadingIntent(Class toClass)
    {
        AppSettings.AnimationMafiaLabel = false;
        sleepTime = 2;
        loadingIntent = new Intent(MafiaProjectProApp.getContext(), toClass);
    }

    public static void setLoadingIntent(Intent intent)
    {
        AppSettings.AnimationMafiaLabel = false;
        sleepTime = 2;
        loadingIntent = intent;
    }

    public static int getDP(float pixels)
    {
        if(MafiaProjectProApp.getContext() != null)
        {
            return (int) (pixels * MafiaProjectProApp.getContext().getResources().getDisplayMetrics().density + 0.5f);
        }
        return 0;
    }

    public static void showDialog(int id)
    {
        switch (id)
        {
            case 1:
                AlertDialog.Builder builder = new AlertDialog.Builder(MafiaProjectProApp.getContext());
                builder.setMessage(R.string.card_ends);
                builder.setCancelable(false);

                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AppSettings.setLoadingIntent(LWPActivity.class);
                        MafiaProjectProApp.getContext().startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                        System.gc();
                        ((Activity) MafiaProjectProApp.getContext()).finish();
                    }
                });

                builder.create();
                builder.show();
                break;

            case 2:
                AlertDialog.Builder adb1 = new AlertDialog.Builder(MafiaProjectProApp.getContext());
                adb1.setMessage(R.string.end_game);
                adb1.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        AppSettings.setLoadingIntent(HomeActivity.class);
                        MafiaProjectProApp.getContext().startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                        System.gc();
                        ((Activity) MafiaProjectProApp.getContext()).finish();
                    }
                });
                adb1.setNegativeButton(R.string.no, null);
                adb1.create();
                adb1.show();
                break;

            case 3:
                AlertDialog.Builder adb2 = new AlertDialog.Builder(MafiaProjectProApp.getContext());
                adb2.setMessage(R.string.number_of_players_err);
                adb2.setPositiveButton(R.string.ok, null);
                adb2.create();
                adb2.show();
                break;

            case 4:
                AlertDialog.Builder adb3 = new AlertDialog.Builder(MafiaProjectProApp.getContext());
                adb3.setMessage(R.string.number_of_players_big_err);
                adb3.setPositiveButton(R.string.ok, null);
                adb3.create();
                adb3.show();
                break;

            case 5:
                AlertDialog.Builder adb4 = new AlertDialog.Builder(MafiaProjectProApp.getContext());
                adb4.setMessage(R.string.number_of_players_zero_err);
                adb4.setPositiveButton(R.string.ok, null);
                adb4.create();
                adb4.show();
                break;
        }
    }

    public static AlertDialog brandAlertDialog(AlertDialog dialog)
    {
        try
        {
            Resources resources = dialog.getContext().getResources();
            int color = resources.getColor(R.color.Red);

            int alertTitleId = resources.getIdentifier("alertTitle", "id", "android");
            TextView alertTitle = (TextView) dialog.getWindow().getDecorView().findViewById(alertTitleId);
            alertTitle.setTextColor(color);

            int titleDividerId = resources.getIdentifier("titleDivider", "id", "android");
            View titleDivider = dialog.getWindow().getDecorView().findViewById(titleDividerId);
            titleDivider.setBackgroundColor(color);
            return dialog;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dialog;
    }

    public static String getShortNameRole(String codeString)
    {
        if (codeString.equals(MafiaProjectProApp.getContext().getString(R.string.civilian)))
            return "_C_";
        else if (codeString.equals(MafiaProjectProApp.getContext().getString(R.string.mafia)))
            return "_Maf_";
        else if (codeString.equals(MafiaProjectProApp.getContext().getString(R.string.sheriff)))
            return "_S_";
        else if (codeString.equals(MafiaProjectProApp.getContext().getString(R.string.godfather)))
            return "_G_";
        else if (codeString.equals(MafiaProjectProApp.getContext().getString(R.string.doctor)))
            return "_D_";
        else if (codeString.equals(MafiaProjectProApp.getContext().getString(R.string.whore)))
            return "_W_";
        else if (codeString.equals(MafiaProjectProApp.getContext().getString(R.string.maniac)))
            return "_Man_";
        else
            return codeString;
    }

    public static String getFullNameRole(String codeString)
    {
        if (codeString.equals("_C_"))
            return MafiaProjectProApp.getContext().getString(R.string.civilian);
        else if (codeString.equals("_Maf_"))
            return MafiaProjectProApp.getContext().getString(R.string.mafia);
        else if (codeString.equals("_S_"))
            return MafiaProjectProApp.getContext().getString(R.string.sheriff);
        else if (codeString.equals("_G_"))
            return MafiaProjectProApp.getContext().getString(R.string.godfather);
        else if (codeString.equals("_D_"))
            return MafiaProjectProApp.getContext().getString(R.string.doctor);
        else if (codeString.equals("_W_"))
            return MafiaProjectProApp.getContext().getString(R.string.whore);
        else if (codeString.equals("_Man_"))
            return MafiaProjectProApp.getContext().getString(R.string.maniac);
        else
            return codeString;
    }

    public static int getVotePlayer(int numberInList)
    {
        switch (numberInList)
        {
            case 1:
                return R.drawable.player_1;
            case 2:
                return R.drawable.player_2;
            case 3:
                return R.drawable.player_3;
            case 4:
                return R.drawable.player_4;
            case 5:
                return R.drawable.player_5;
            case 6:
                return R.drawable.player_6;
            case 7:
                return R.drawable.player_7;
            case 8:
                return R.drawable.player_8;
            case 9:
                return R.drawable.player_9;
            case 10:
                return R.drawable.player_10;
            case 11:
                return R.drawable.player_11;
            case 12:
                return R.drawable.player_12;
            case 13:
                return R.drawable.player_13;
            case 14:
                return R.drawable.player_14;
            case 15:
                return R.drawable.player_15;
            case 16:
                return R.drawable.player_16;
            case 17:
                return R.drawable.player_17;
        }
        return 0;
    }
}

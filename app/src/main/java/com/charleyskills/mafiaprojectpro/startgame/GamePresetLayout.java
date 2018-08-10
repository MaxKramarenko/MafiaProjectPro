package com.charleyskills.mafiaprojectpro.startgame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.charleyskills.mafiaprojectpro.AppSettings;
import com.charleyskills.mafiaprojectpro.IO;
import com.charleyskills.mafiaprojectpro.MafiaProjectProApp;
import com.charleyskills.mafiaprojectpro.R;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name="GamePresetLayout")
public class GamePresetLayout
{
    @Attribute(name="name")
    public String name = "";

    @Attribute(name="doctor")
    public int doctor;

    @Attribute(name="whore")
    public int whore;

    @Attribute(name="maniac")
    public int maniac;

    @Attribute(name="sheriff")
    public int sheriff;

    @Attribute(name="godfather")
    public int godfather;

    @Attribute(name="mafia")
    public int mafia;

    @Attribute(name="civilian")
    public int civilian;

    @Element(name = "ContainerItemInAnotherRoleList", type=ContainerItemInAnotherRoleList.class)
    public ContainerItemInAnotherRoleList containerItemInAnotherRoleList;

    FrameLayout topLayout;
    FrameLayout.LayoutParams paramTopLayout;
    FrameLayout delGamePresetLayout;
    FrameLayout.LayoutParams paramDelGamePresetLayout;
    ImageView delGamePreset;
    LinearLayout.LayoutParams paramDelGamePreset;
    LinearLayout lLayout;
    LinearLayout.LayoutParams lParam;
    TextView textName;
    FrameLayout.LayoutParams textNameParam;
    LinearLayout lTextLayout;
    LinearLayout.LayoutParams lTextParam;
    TextView Text_1;
    LinearLayout.LayoutParams tParam_1;
    TextView Text_2;
    LinearLayout.LayoutParams tParam_2;
    TextView Text_3;
    LinearLayout.LayoutParams tParam_3;
    TextView subText_2;
    LinearLayout.LayoutParams stParam_2;
    //breaker
    ImageView breaker_ChooseGameMode;

    // customize
    LinearLayout.LayoutParams bParam_ChooseGameMode;
    Intent toCustomizeGameActivityIntent;

    @Attribute(name="order")
    public int order;

    public GamePresetLayout(@Attribute(name="order") int order, @Attribute(name="name") String name, @Attribute(name="doctor") int doctor, @Attribute(name="whore") int whore, @Attribute(name="maniac") int maniac, @Attribute(name="sheriff") int sheriff, @Attribute(name="godfather") int godfather, @Attribute(name="mafia") int mafia, @Attribute(name="civilian") int civilian, @Element(name = "ContainerItemInAnotherRoleList", type=ContainerItemInAnotherRoleList.class) ContainerItemInAnotherRoleList containerItemInAnotherRoleList)
    {
        this.order = order;
        this.name = name;
        this.doctor = doctor;
        this.whore = whore;
        this.maniac = maniac;
        this.sheriff = sheriff;
        this.godfather = godfather;
        this.mafia = mafia;
        this.civilian = civilian;

        this.containerItemInAnotherRoleList = containerItemInAnotherRoleList;

        if(containerItemInAnotherRoleList != null)
        {
            for (ItemInAnotherRoleList item : this.containerItemInAnotherRoleList.arrayItemAnotherRoles)
            {
                item.setParentGamePresetLayout(this);
            }
        }

//        arrayItemAnotherRoles = new ArrayList<ItemInAnotherRoleList>();
//        if (arrayAnotherRoles != null)
//        {
//            int i = 0;
//            for (String anotherRole : arrayAnotherRoles)
//            {
//                arrayItemAnotherRoles.add(new ItemInAnotherRoleList(i, anotherRole, this));
//                i++;
//            }
//        }
    }

    public int calc_CountOfArrayItemInAnotherRoleList()
    {
        if (containerItemInAnotherRoleList == null)
            return 0;

        int count = 0;
        for (int i = 0; i < containerItemInAnotherRoleList.arrayItemAnotherRoles.size(); i++)
        {
            if (containerItemInAnotherRoleList.arrayItemAnotherRoles.get(i).active)
            {
                count++;
            }
        }
        return count;
    }

    public boolean isHasEmptyItemOfArrayItemAnotherRoleList()
    {
        for(ItemInAnotherRoleList item : containerItemInAnotherRoleList.arrayItemAnotherRoles)
        {
            if(item.role.isEmpty())
            {
                return true;
            }
        }
        return false;
    }

    public boolean del_EmptyItemOfArrayItemInAnotherRoleList(boolean deinitiate)
    {
        if (containerItemInAnotherRoleList == null)
            return false;

        if (containerItemInAnotherRoleList.arrayItemAnotherRoles.size() == 0)
            return false;

        ArrayList<ItemInAnotherRoleList> removeItems = new ArrayList<>();

        for(ItemInAnotherRoleList item : containerItemInAnotherRoleList.arrayItemAnotherRoles)
        {
            if(item.role.isEmpty())
            {
                removeItems.add(item);
                if(deinitiate)
                    item.deinitiate();
            }
        }
        containerItemInAnotherRoleList.arrayItemAnotherRoles.removeAll(removeItems);
        return true;
    }

    public int countPlayers()
    {
        int anotherRole = 0;
        for (int i = 0; i < containerItemInAnotherRoleList.arrayItemAnotherRoles.size(); i++)
        {
            if (containerItemInAnotherRoleList.arrayItemAnotherRoles.get(i).active)
                anotherRole++;
        }
        return doctor + whore + maniac + sheriff + godfather + mafia + civilian + anotherRole;
    }

    boolean initiate_ArrayItemsAnotherRole()
    {
        if (containerItemInAnotherRoleList == null)
        {
            containerItemInAnotherRoleList = new ContainerItemInAnotherRoleList();
            return false;
        }

        if (containerItemInAnotherRoleList.arrayItemAnotherRoles.size() == 0)
            return false;

        for (ItemInAnotherRoleList item : containerItemInAnotherRoleList.arrayItemAnotherRoles)
        {
            item.initiate();
        }
        return true;
    }

    void initiate_ChooseGameMode()
    {
        lLayout = new LinearLayout(MafiaProjectProApp.getContext());
        lLayout.setOrientation(LinearLayout.VERTICAL);
        lLayout.setBackgroundResource(R.drawable.itemingloballist_lwp);
        lLayout.setClickable(true);
        toCustomizeGameActivityIntent = new Intent(MafiaProjectProApp.getContext(), CustomizeGameActivity.class);
        lLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toCustomizeGameActivityIntent.putExtra("gamemode", order);
                MafiaProjectProApp.getContext().startActivity(toCustomizeGameActivityIntent);
                ((Activity) MafiaProjectProApp.getContext()).finish();
            }
        });

        lParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lParam.setMargins(AppSettings.getDP(10), 0, AppSettings.getDP(10), 0);
        ChooseGameModeActivity.linearlayout_chooseGameMode.addView(lLayout, lParam);

        topLayout = new FrameLayout(MafiaProjectProApp.getContext());
        paramTopLayout = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lLayout.addView(topLayout, paramTopLayout);

        textName = new TextView(MafiaProjectProApp.getContext());
        textName.setText(name);
        textName.setTextColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.White));
        textName.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        textName.setTextSize(21);
        textNameParam = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        textNameParam.gravity = Gravity.LEFT | Gravity.TOP;
        textNameParam.setMargins(AppSettings.getDP(5), AppSettings.getDP(3), 0, 0);
        topLayout.addView(textName, textNameParam);

        delGamePresetLayout = new FrameLayout(MafiaProjectProApp.getContext());
        delGamePresetLayout.setClickable(true);
        paramDelGamePresetLayout = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramDelGamePresetLayout.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT;

        delGamePreset = new ImageView(MafiaProjectProApp.getContext());
        delGamePreset.setClickable(true);
        delGamePreset.setBackgroundResource(R.drawable.button_del);
        delGamePreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteGamePreset_ChooseGameMode();
                AppSettings.reorder_GamePresetLayout();
                IO.writeToSD(AppSettings.containerGamePresetLayoutsList, IO.GAMEPRESETconfig, "writeGC");
                if (AppSettings.getGamePresetLayouts().size() == 0)
                {
                    ((Activity) MafiaProjectProApp.getContext()).findViewById(R.id.text_no_user_preset).setVisibility(View.VISIBLE);
                }
            }
        });
        paramDelGamePreset = new LinearLayout.LayoutParams(AppSettings.getDP(40), AppSettings.getDP(36));
        paramDelGamePreset.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT;
        delGamePresetLayout.addView(delGamePreset, paramDelGamePreset);
        topLayout.addView(delGamePresetLayout, paramDelGamePresetLayout);

        //Text

        String textRolesPreset_1 = "";
        String textRolesPreset_2 = "";
        String textRolesPreset_3 = "";

        int players = doctor + whore + maniac + sheriff + godfather + mafia + civilian + calc_CountOfArrayItemInAnotherRoleList();
        if (players != 0)
        {
            if (players == 1)
            {
                textRolesPreset_1 += players + " " + MafiaProjectProApp.getContext().getString(R.string.voting_player);
            }
            else
            if (2 <= players && players <= 4)
            {
                textRolesPreset_1 += players + " " + MafiaProjectProApp.getContext().getString(R.string.ChooseGameMode_Cases_2_4players);
            }
            else
            if (players >= 5)
            {
                textRolesPreset_1 += players + " " + MafiaProjectProApp.getContext().getString(R.string.ChooseGameMode_Cases_4_fewplayers);
            }
        }

        if (mafia != 0) {
            if (mafia == 1) {
                textRolesPreset_1 += "\n" + mafia + " " + MafiaProjectProApp.getContext().getString(R.string.mafia);
            } else if (mafia >= 2) {
                textRolesPreset_1 += "\n" + mafia + " " + MafiaProjectProApp.getContext().getString(R.string.ChooseGameMode_Cases_few_mafia);
            }
        }

        if (godfather != 0) {
            if (godfather == 1) {
                textRolesPreset_1 += "\n" + godfather + " " + MafiaProjectProApp.getContext().getString(R.string.godfather);
            } else if (2 <= godfather && godfather <= 4) {
                textRolesPreset_1 += "\n" + godfather + " " + MafiaProjectProApp.getContext().getString(R.string.ChooseGameMode_Cases_2_4godfather);
            } else if (godfather >= 5) {
                textRolesPreset_1 += "\n" + godfather + " " + MafiaProjectProApp.getContext().getString(R.string.ChooseGameMode_Cases_4_fewgodfather);
            }
        }

        if (civilian != 0) {
            if (civilian == 1) {
                textRolesPreset_2 += civilian + " " + MafiaProjectProApp.getContext().getString(R.string.civilian);
            } else if (civilian >= 2) {
                textRolesPreset_2 += civilian + " " + MafiaProjectProApp.getContext().getString(R.string.ChooseGameMode_Cases_fewcivilian);
            }
        }

        if (sheriff != 0) {
            if (sheriff == 1) {
                textRolesPreset_2 += "\n" + sheriff + " " + MafiaProjectProApp.getContext().getString(R.string.sheriff);
            } else if (2 <= sheriff && sheriff <= 4) {
                textRolesPreset_2 += "\n" + sheriff + " " + MafiaProjectProApp.getContext().getString(R.string.ChooseGameMode_Cases_2_4sheriff);
            } else if (sheriff >= 5) {
                textRolesPreset_2 += "\n" + sheriff + " " + MafiaProjectProApp.getContext().getString(R.string.ChooseGameMode_Cases_2_4sheriff);
            }
        }

        if (maniac != 0) {
            if (maniac == 1) {
                textRolesPreset_3 += maniac + " " + MafiaProjectProApp.getContext().getString(R.string.maniac);
            } else if (2 <= maniac && maniac <= 4) {
                textRolesPreset_3 += maniac + " " + MafiaProjectProApp.getContext().getString(R.string.ChooseGameMode_Cases_2_4maniac);
            } else if (maniac >= 5) {
                textRolesPreset_3 += maniac + " " + MafiaProjectProApp.getContext().getString(R.string.ChooseGameMode_Cases_4_fewmaniac);
            }
        }

        if (whore != 0) {
            if (whore == 1) {
                textRolesPreset_3 += "\n" + whore + " " + MafiaProjectProApp.getContext().getString(R.string.whore);
            } else if (2 <= whore && whore <= 4) {
                textRolesPreset_3 += "\n" + whore + " " + MafiaProjectProApp.getContext().getString(R.string.ChooseGameMode_Cases_2_4whore);
            } else if (whore >= 5) {
                textRolesPreset_3 += "\n" + whore + " " + MafiaProjectProApp.getContext().getString(R.string.ChooseGameMode_Cases_4_fewwhore);
            }
        }

        if (doctor != 0) {
            if (doctor == 1) {
                textRolesPreset_2 += "\n" + doctor + " " + MafiaProjectProApp.getContext().getString(R.string.doctor);
            } else if (2 <= doctor && doctor <= 4) {
                textRolesPreset_2 += "\n" + doctor + " " + MafiaProjectProApp.getContext().getString(R.string.ChooseGameMode_Cases_2_4doctor);
            } else if (doctor >= 5) {
                textRolesPreset_2 += "\n" + doctor + " " + MafiaProjectProApp.getContext().getString(R.string.ChooseGameMode_Cases_4_fewdoctor);
            }
        }

        String textRolesPreset_sub = MafiaProjectProApp.getContext().getString(R.string.ChooseGameMode_additional_role) + ": ";
        for (int i = 0; i < containerItemInAnotherRoleList.arrayItemAnotherRoles.size(); i++) {
            if (i != containerItemInAnotherRoleList.arrayItemAnotherRoles.size() - 1)
                textRolesPreset_sub += containerItemInAnotherRoleList.arrayItemAnotherRoles.get(i).role + ", ";
            else
                textRolesPreset_sub += containerItemInAnotherRoleList.arrayItemAnotherRoles.get(i).role;
        }

        lTextLayout = new LinearLayout(MafiaProjectProApp.getContext());
        lTextLayout.setOrientation(LinearLayout.HORIZONTAL);

        lTextParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lTextParam.setMargins(AppSettings.getDP(5), 0, AppSettings.getDP(10), 0);
        lLayout.addView(lTextLayout, lTextParam);

        Text_1 = new TextView(MafiaProjectProApp.getContext());
        Text_1.setText(textRolesPreset_1);
        Text_1.setTextColor(Color.parseColor("#b4b4b4"));
        Text_1.setTextSize(14);
        tParam_1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tParam_1.gravity = Gravity.TOP;
        tParam_1.weight = 1;

        if (containerItemInAnotherRoleList.arrayItemAnotherRoles.size() == 0)
            tParam_1.setMargins(0, 0, AppSettings.getDP(5), AppSettings.getDP(5));
        else
            tParam_1.setMargins(0, 0, AppSettings.getDP(5), 0);

        lTextLayout.addView(Text_1, tParam_1);

        Text_2 = new TextView(MafiaProjectProApp.getContext());
        Text_2.setText(textRolesPreset_2);
        Text_2.setTextColor(Color.parseColor("#b4b4b4"));
        Text_2.setTextSize(14);
        tParam_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tParam_2.gravity = Gravity.TOP;
        tParam_2.weight = 1;

        if (containerItemInAnotherRoleList.arrayItemAnotherRoles.size() == 0)
            tParam_2.setMargins(0, 0, AppSettings.getDP(5), AppSettings.getDP(5));
        else
            tParam_2.setMargins(0, 0, AppSettings.getDP(5), 0);

        lTextLayout.addView(Text_2, tParam_2);

        Text_3 = new TextView(MafiaProjectProApp.getContext());
        Text_3.setText(textRolesPreset_3);
        Text_3.setTextColor(Color.parseColor("#b4b4b4"));
        Text_3.setTextSize(14);
        tParam_3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tParam_3.gravity = Gravity.TOP;

        if (containerItemInAnotherRoleList.arrayItemAnotherRoles.size() == 0)
            tParam_3.setMargins(0, 0, 0, AppSettings.getDP(5));
        else
            tParam_3.setMargins(0, 0, 0, 0);

        tParam_3.weight = 1;
        lTextLayout.addView(Text_3, tParam_3);

        if (containerItemInAnotherRoleList.arrayItemAnotherRoles.size() != 0)
        {
            subText_2 = new TextView(MafiaProjectProApp.getContext());
            subText_2.setText(textRolesPreset_sub);
            subText_2.setTextColor(Color.parseColor("#b4b4b4"));
            subText_2.setTextSize(14);
            stParam_2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            stParam_2.gravity = Gravity.CENTER_VERTICAL | Gravity.LEFT;
            stParam_2.setMargins(AppSettings.getDP(5), 0, AppSettings.getDP(5), AppSettings.getDP(5));
            lLayout.addView(subText_2, stParam_2);
        }
    }

    public void addBreaker_GamePresetLayout()
    {
        breaker_ChooseGameMode = new ImageView(MafiaProjectProApp.getContext());
        bParam_ChooseGameMode = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 1);
        bParam_ChooseGameMode.setMargins(AppSettings.getDP(10), 0, AppSettings.getDP(10), 0);
        breaker_ChooseGameMode.setBackgroundColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.divider));
        ChooseGameModeActivity.linearlayout_chooseGameMode.addView(breaker_ChooseGameMode, bParam_ChooseGameMode);
    }

    public void deleteGamePreset_ChooseGameMode()
    {
        ChooseGameModeActivity.linearlayout_chooseGameMode.removeView(lLayout);
        ChooseGameModeActivity.linearlayout_chooseGameMode.removeView(breaker_ChooseGameMode);

        AppSettings.getGamePresetLayouts().remove(order);
    }

    public void deinitiate_ChooseGameMode()
    {
        ChooseGameModeActivity.linearlayout_chooseGameMode.removeView(lLayout);
        ChooseGameModeActivity.linearlayout_chooseGameMode.removeView(breaker_ChooseGameMode);
    }
}

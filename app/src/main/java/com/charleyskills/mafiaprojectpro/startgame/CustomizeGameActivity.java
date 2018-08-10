package com.charleyskills.mafiaprojectpro.startgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.charleyskills.mafiaprojectpro.AppSettings;
import com.charleyskills.mafiaprojectpro.IO;
import com.charleyskills.mafiaprojectpro.LoadingActivity;
import com.charleyskills.mafiaprojectpro.Logger;
import com.charleyskills.mafiaprojectpro.MafiaProjectProApp;
import com.charleyskills.mafiaprojectpro.R;
import com.charleyskills.mafiaprojectpro.greendesk.GreenDeskActivity;
import com.charleyskills.mafiaprojectpro.snar.SNARActivity;

import java.util.ArrayList;

public class CustomizeGameActivity extends Activity
{
    public static InputMethodManager imm;

    public static GamePresetLayout gamePresetLayout;

    public static LinearLayout linearlayout_customizeGame;
    public static int currentCustomGameMode;
    public static ScrollView mainScrollView;
    TextView button_small_back;
    TextView button_small_next;
    TextView customizegame_title;
    Button button_number_of_doctor_plus;
    Button button_number_of_doctor_minus;
    Button button_number_of_whore_plus;
    Button button_number_of_whore_minus;
    Button button_number_of_maniac_plus;
    Button button_number_of_maniac_minus;
    Button button_number_of_sheriff_plus;
    Button button_number_of_sheriff_minus;
    Button button_number_of_godfather_plus;
    Button button_number_of_godfather_minus;
    Button button_number_of_mafia_plus;
    Button button_number_of_mafia_minus;
    Button button_number_of_civilians_plus;
    Button button_number_of_civilians_minus;
    TextView CustomizeGame_PresetName_EditText;
    TextView CustomizeGame_ConfirmPresetName;
    private TextView text_number_of_doctor;
    private TextView text_number_of_whore;
    private TextView text_number_of_maniac;
    private TextView text_number_of_sheriff;
    private TextView text_number_of_godfather;
    private TextView text_number_of_mafia;
    private TextView text_number_of_civilians;
    private Intent toChooseGameModeActivityIntent;

    static void recountArray_anotherRoles(GamePresetLayout gamePresetLayout)
    {
        for (int i = 0; i < gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.size(); i++)
        {
            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.get(i).order = i;
            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.get(i).tRole.setText(String.valueOf(i + 1) + ".");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_game);

        MafiaProjectProApp.setContext(this);

        findViewById(R.id.text_WithDoctor).requestFocus();

        linearlayout_customizeGame = (LinearLayout) findViewById(R.id.linearlayout_customizeGame);

        // button plus/minus

        button_number_of_doctor_plus = (Button) findViewById(R.id.button_number_of_doctor_plus);
        button_number_of_doctor_minus = (Button) findViewById(R.id.button_number_of_doctor_minus);

        button_number_of_whore_plus = (Button) findViewById(R.id.button_number_of_whore_plus);
        button_number_of_whore_minus = (Button) findViewById(R.id.button_number_of_whore_minus);

        button_number_of_maniac_plus = (Button) findViewById(R.id.button_number_of_maniac_plus);
        button_number_of_maniac_minus = (Button) findViewById(R.id.button_number_of_maniac_minus);

        button_number_of_sheriff_plus = (Button) findViewById(R.id.button_number_of_sheriff_plus);
        button_number_of_sheriff_minus = (Button) findViewById(R.id.button_number_of_sheriff_minus);

        button_number_of_godfather_plus = (Button) findViewById(R.id.button_number_of_godfather_plus);
        button_number_of_godfather_minus = (Button) findViewById(R.id.button_number_of_godfather_minus);

        button_number_of_mafia_plus = (Button) findViewById(R.id.button_number_of_mafia_plus);
        button_number_of_mafia_minus = (Button) findViewById(R.id.button_number_of_mafia_minus);

        button_number_of_civilians_plus = (Button) findViewById(R.id.button_number_of_civilians_plus);
        button_number_of_civilians_minus = (Button) findViewById(R.id.button_number_of_civilians_minus);

        button_small_back = (TextView) findViewById(R.id.button_small_back);
        button_small_back.setTypeface(Typeface.create("serif", Typeface.BOLD));
        button_small_next = (TextView) findViewById(R.id.button_small_next);
        button_small_next.setTypeface(Typeface.create("serif", Typeface.BOLD));
        customizegame_title = (TextView) findViewById(R.id.customizegame_title);
        customizegame_title.setTypeface(Typeface.create("serif", Typeface.NORMAL));

        // text number

        text_number_of_doctor = (TextView) findViewById(R.id.text_number_of_doctor);
        text_number_of_whore = (TextView) findViewById(R.id.text_number_of_whore);
        text_number_of_maniac = (TextView) findViewById(R.id.text_number_of_maniac);
        text_number_of_sheriff = (TextView) findViewById(R.id.text_number_of_sheriff);
        text_number_of_godfather = (TextView) findViewById(R.id.text_number_of_godfather);
        text_number_of_mafia = (TextView) findViewById(R.id.text_number_of_mafia);
        text_number_of_civilians = (TextView) findViewById(R.id.text_number_of_civilians);

        // name of preset

        CustomizeGame_PresetName_EditText = (EditText) findViewById(R.id.CustomizeGame_EditText);
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(10);
        CustomizeGame_PresetName_EditText.setFilters(filters);
        CustomizeGame_ConfirmPresetName = (TextView) findViewById(R.id.CustomizeGame_ConfirmPresetName);

        try
        {
            CustomizeGameActivity.gamePresetLayout = (GamePresetLayout) IO.readFromSD(GamePresetLayout.class, IO.CUSTOMIZEGAMEstate, "CUSTOMIZEGAMEstate");
            if(!gamePresetLayout.name.equals("classic"))
            {
                findViewById(R.id.CustomizeGame_NamePreset).setVisibility(View.GONE);
            }
        }
        catch (Exception e)
        {
            Logger.i("CUSTOMIZEGAMEstate", e.toString());
            e.printStackTrace();
            currentCustomGameMode = getIntent().getIntExtra("gamemode", AppSettings.GameMode_Customize);
            if (currentCustomGameMode == AppSettings.GameMode_Customize)
            {
                gamePresetLayout = new GamePresetLayout(AppSettings.getGamePresetLayouts().size(), "classic", 0, 0, 0, 1, 1, 2, 6, null);

                findViewById(R.id.CustomizeGame_NamePreset).setVisibility(View.VISIBLE);

                CustomizeGame_PresetName_EditText.setFocusable(true);
                CustomizeGame_PresetName_EditText.setFocusableInTouchMode(true);
                CustomizeGame_PresetName_EditText.setEnabled(true);
            }
            else
            if (currentCustomGameMode >= 0)
            {
                ContainerItemInAnotherRoleList containerItemInAnotherRoleList = new ContainerItemInAnotherRoleList();
                for (ItemInAnotherRoleList item : AppSettings.getGamePresetLayouts().get(currentCustomGameMode).containerItemInAnotherRoleList.arrayItemAnotherRoles)
                {
                    containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(item.order, item.role));
                }

                gamePresetLayout = new GamePresetLayout(AppSettings.getGamePresetLayouts().get(currentCustomGameMode).order, AppSettings.getGamePresetLayouts().get(currentCustomGameMode).name, AppSettings.getGamePresetLayouts().get(currentCustomGameMode).doctor,
                        AppSettings.getGamePresetLayouts().get(currentCustomGameMode).whore, AppSettings.getGamePresetLayouts().get(currentCustomGameMode).maniac, AppSettings.getGamePresetLayouts().get(currentCustomGameMode).sheriff, AppSettings.getGamePresetLayouts().get(currentCustomGameMode).godfather, AppSettings.getGamePresetLayouts().get(currentCustomGameMode).mafia, AppSettings.getGamePresetLayouts().get(currentCustomGameMode).civilian, containerItemInAnotherRoleList);
                findViewById(R.id.CustomizeGame_NamePreset).setVisibility(View.GONE);
            }

            gamePresetLayout.initiate_ArrayItemsAnotherRole();
            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(gamePresetLayout));
        }

        text_number_of_doctor.setText(String.valueOf(gamePresetLayout.doctor));
        text_number_of_whore.setText(String.valueOf(gamePresetLayout.whore));
        text_number_of_maniac.setText(String.valueOf(gamePresetLayout.maniac));
        text_number_of_sheriff.setText(String.valueOf(gamePresetLayout.sheriff));
        text_number_of_godfather.setText(String.valueOf(gamePresetLayout.godfather));
        text_number_of_mafia.setText(String.valueOf(gamePresetLayout.mafia));
        text_number_of_civilians.setText(String.valueOf(gamePresetLayout.civilian));

        CustomizeGame_ConfirmPresetName.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (CustomizeGame_PresetName_EditText.isEnabled())
                {
                    if(gamePresetLayout.countPlayers() == 0)
                    {
                        Toast.makeText(MafiaProjectProApp.getContext(), R.string.CustomizeGame_zeroplayers, Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (CustomizeGame_PresetName_EditText.getText().toString().equals(""))
                    {
                        Toast.makeText(MafiaProjectProApp.getContext(), R.string.CustomizeGame_enterNamePreset, Toast.LENGTH_SHORT).show();
                        return;
                    }
                    gamePresetLayout.name = String.valueOf(CustomizeGame_PresetName_EditText.getText());
                    ((Activity) MafiaProjectProApp.getContext()).findViewById(R.id.CustomizeGame_NamePreset).setVisibility(View.GONE);
                    imm.hideSoftInputFromWindow(CustomizeGame_PresetName_EditText.getWindowToken(), 0);

                    ContainerItemInAnotherRoleList containerItemInAnotherRoleList = new ContainerItemInAnotherRoleList();
                    for(ItemInAnotherRoleList item : gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles)
                    {
                        containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(item.order, item.role));
                    }

                    GamePresetLayout temp = new GamePresetLayout(gamePresetLayout.order, gamePresetLayout.name, gamePresetLayout.doctor,
                            gamePresetLayout.whore, gamePresetLayout.maniac, gamePresetLayout.sheriff, gamePresetLayout.godfather, gamePresetLayout.mafia, gamePresetLayout.civilian, containerItemInAnotherRoleList);
                    temp.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                    AppSettings.getGamePresetLayouts().add(temp);
                    AppSettings.reorder_GamePresetLayout();
                    IO.writeToSD(AppSettings.containerGamePresetLayoutsList, IO.GAMEPRESETconfig, "writeGC");
                    Toast.makeText(MafiaProjectProApp.getContext(), R.string.CustomizeGame_Saved, Toast.LENGTH_SHORT).show();
                }
            }
        });

        overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);

        toChooseGameModeActivityIntent = new Intent(this, ChooseGameModeActivity.class);

        mainScrollView = (ScrollView) findViewById(R.id.mainScrollView);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        linearlayout_customizeGame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    CustomizeGameActivity.imm.hideSoftInputFromWindow(CustomizeGame_PresetName_EditText.getWindowToken(), 0);
                }
                return true;
            }
        });

        CustomizeGameActivity.imm.hideSoftInputFromWindow(mainScrollView.getWindowToken(), 0);

        button_small_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_small_back.setClickable(false);
                gamePresetLayout = null;
                startActivity(toChooseGameModeActivityIntent);
                finish();
            }
        });

        button_small_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(gamePresetLayout.countPlayers() == 0)
                {
                    Toast.makeText(MafiaProjectProApp.getContext(), R.string.CustomizeGame_zeroplayers, Toast.LENGTH_SHORT).show();
                    return;
                }

                for (ItemInAnotherRoleList item : gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles)
                {
                    if(!String.valueOf(item.editText.getText()).equals("") && String.valueOf(item.subText.getText()).equals(getString(R.string.CustomizeGame_Save)))
                    {
                        Toast.makeText(MafiaProjectProApp.getContext(), R.string.add_addicted_role, Toast.LENGTH_SHORT).show();
                        CustomizeGameActivity.imm.showSoftInput(item.editText, 0);
                        findViewById(R.id.button_small_next).setClickable(true);
                        return;
                    }
                }

                final Intent toGreenDesk = new Intent(MafiaProjectProApp.getContext(), GreenDeskActivity.class);
                toGreenDesk.putExtra("doctor", gamePresetLayout.doctor);
                toGreenDesk.putExtra("whore", gamePresetLayout.whore);
                toGreenDesk.putExtra("maniac", gamePresetLayout.maniac);
                toGreenDesk.putExtra("sheriff", gamePresetLayout.sheriff);
                toGreenDesk.putExtra("godfather", gamePresetLayout.godfather);
                toGreenDesk.putExtra("mafia", gamePresetLayout.mafia);
                toGreenDesk.putExtra("civilian", gamePresetLayout.civilian);

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MafiaProjectProApp.getContext());
                builder1.setMessage(R.string.CustomizeGame_playwithcards);
                builder1.setCancelable(true);
                builder1.setPositiveButton(R.string.CustomizeGame_playwithcards_yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MafiaProjectProApp.getContext());
                        builder.setMessage(R.string.Question_setNicknames);
                        builder.setCancelable(false);

                        builder.setPositiveButton(R.string.Question_setNicknames_yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                toGreenDesk.putExtra("nickname_enable", AppSettings.NicknameAfterGreenDesk);
                                toGreenDesk.putExtra("withcards", AppSettings.WithCards_On);
                                gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(false);
                                if (gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.size() != 0)
                                {
                                    ArrayList<String> arrayItem = new ArrayList<String>();
                                    for (ItemInAnotherRoleList item : gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles)
                                    {
                                        arrayItem.add(item.role);
                                    }
                                    toGreenDesk.putStringArrayListExtra("anotherrole", arrayItem);
                                }
                                AppSettings.setLoadingIntent(toGreenDesk);
                                startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                                finish();
                            }
                        });

                        builder.setNegativeButton(R.string.Question_setNicknames_no, new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                toGreenDesk.putExtra("nickname_enable", AppSettings.NicknameInGreenDesk);
                                toGreenDesk.putExtra("withcards", AppSettings.WithCards_On);
                                gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(false);
                                if (gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.size() != 0)
                                {
                                    ArrayList<String> arrayItem = new ArrayList<>();
                                    for (ItemInAnotherRoleList item : gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles)
                                    {
                                        arrayItem.add(item.role);
                                    }
                                    toGreenDesk.putStringArrayListExtra("anotherrole", arrayItem);
                                }
                                AppSettings.setLoadingIntent(toGreenDesk);
                                startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                                finish();
                            }
                        });

                        builder.setNeutralButton(R.string.Question_setNicknames_cancel, new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                toGreenDesk.putExtra("nickname_enable", AppSettings.NoNicknameGreenDesk);

                                gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(false);
                                if (gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.size() != 0)
                                {
                                    ArrayList<String> arrayItem = new ArrayList<String>();
                                    for (ItemInAnotherRoleList item : gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles)
                                    {
                                        arrayItem.add(item.role);
                                    }
                                    toGreenDesk.putStringArrayListExtra("anotherrole", arrayItem);
                                }
                                AppSettings.setLoadingIntent(toGreenDesk);
                                startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                                finish();
                            }
                        });

                        builder.create();
                        builder.show();
                    }
                });

                builder1.setNegativeButton(R.string.CustomizeGame_playwithcards_no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent toSNARActivity = new Intent(MafiaProjectProApp.getContext(), SNARActivity.class);

                        toSNARActivity.putExtra("doctor", gamePresetLayout.doctor);
                        toSNARActivity.putExtra("whore", gamePresetLayout.whore);
                        toSNARActivity.putExtra("maniac", gamePresetLayout.maniac);
                        toSNARActivity.putExtra("sheriff", gamePresetLayout.sheriff);
                        toSNARActivity.putExtra("godfather", gamePresetLayout.godfather);
                        toSNARActivity.putExtra("mafia", gamePresetLayout.mafia);
                        toSNARActivity.putExtra("civilian", gamePresetLayout.civilian);
                        toSNARActivity.putExtra("gamemode", AppSettings.GameMode_Customize);

                        gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(false);
                        if (gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.size() != 0)
                        {
                            ArrayList<String> arrayItem = new ArrayList<String>();
                            for (ItemInAnotherRoleList item : gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles)
                            {
                                arrayItem.add(item.role);
                            }
                            toSNARActivity.putStringArrayListExtra("anotherrole", arrayItem);
                        }
                        toSNARActivity.putExtra("players", gamePresetLayout.countPlayers());
                        toSNARActivity.putExtra("withcards", AppSettings.WithCards_Off);

                        AppSettings.setLoadingIntent(toSNARActivity);
                        startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                        finish();
                    }
                });

                builder1.create();
                builder1.show();
            }
        });

        button_number_of_doctor_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                        gamePresetLayout.doctor +
                        gamePresetLayout.whore +
                        gamePresetLayout.maniac +
                        gamePresetLayout.sheriff +
                        gamePresetLayout.godfather +
                        gamePresetLayout.mafia +
                        gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                {
                    gamePresetLayout.doctor++;
                    text_number_of_doctor.setText(String.valueOf(gamePresetLayout.doctor));

                    if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                            gamePresetLayout.doctor +
                            gamePresetLayout.whore +
                            gamePresetLayout.maniac +
                            gamePresetLayout.sheriff +
                            gamePresetLayout.godfather +
                            gamePresetLayout.mafia +
                            gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                    {
                        if(!gamePresetLayout.isHasEmptyItemOfArrayItemAnotherRoleList())
                        {
                            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(gamePresetLayout));
                        }
                    }
                    else
                    {
                        gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                    }
                }
                else
                {
                    AppSettings.showDialog(3);
                }
            }
        });

        button_number_of_doctor_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamePresetLayout.doctor != 0)
                {
                    gamePresetLayout.doctor--;
                    text_number_of_doctor.setText(String.valueOf(gamePresetLayout.doctor));

                    if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                            gamePresetLayout.doctor +
                            gamePresetLayout.whore +
                            gamePresetLayout.maniac +
                            gamePresetLayout.sheriff +
                            gamePresetLayout.godfather +
                            gamePresetLayout.mafia +
                            gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                    {
                        if(!gamePresetLayout.isHasEmptyItemOfArrayItemAnotherRoleList())
                        {
                            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(gamePresetLayout));
                        }
                    }
                    else
                    {
                        gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                    }
                }
            }
        });

        button_number_of_whore_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                        gamePresetLayout.doctor +
                        gamePresetLayout.whore +
                        gamePresetLayout.maniac +
                        gamePresetLayout.sheriff +
                        gamePresetLayout.godfather +
                        gamePresetLayout.mafia +
                        gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                {
                    gamePresetLayout.whore++;
                    text_number_of_whore.setText(String.valueOf(gamePresetLayout.whore));

                    if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                            gamePresetLayout.doctor +
                            gamePresetLayout.whore +
                            gamePresetLayout.maniac +
                            gamePresetLayout.sheriff +
                            gamePresetLayout.godfather +
                            gamePresetLayout.mafia +
                            gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                    {
                        if(!gamePresetLayout.isHasEmptyItemOfArrayItemAnotherRoleList())
                        {
                            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(gamePresetLayout));
                        }
                    }
                    else
                    {
                        gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                    }
                }
                else
                {
                    AppSettings.showDialog(3);
                }
            }
        });

        button_number_of_whore_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamePresetLayout.whore != 0)
                {
                    gamePresetLayout.whore--;
                    text_number_of_whore.setText(String.valueOf(gamePresetLayout.whore));

                    if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                            gamePresetLayout.doctor +
                            gamePresetLayout.whore +
                            gamePresetLayout.maniac +
                            gamePresetLayout.sheriff +
                            gamePresetLayout.godfather +
                            gamePresetLayout.mafia +
                            gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                    {
                        if(!gamePresetLayout.isHasEmptyItemOfArrayItemAnotherRoleList())
                        {
                            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(gamePresetLayout));
                        }
                    }
                    else
                    {
                        gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                    }
                }
            }
        });

        button_number_of_maniac_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                        gamePresetLayout.doctor +
                        gamePresetLayout.whore +
                        gamePresetLayout.maniac +
                        gamePresetLayout.sheriff +
                        gamePresetLayout.godfather +
                        gamePresetLayout.mafia +
                        gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                {
                    gamePresetLayout.maniac++;
                    text_number_of_maniac.setText(String.valueOf(gamePresetLayout.maniac));

                    if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                            gamePresetLayout.doctor +
                            gamePresetLayout.whore +
                            gamePresetLayout.maniac +
                            gamePresetLayout.sheriff +
                            gamePresetLayout.godfather +
                            gamePresetLayout.mafia +
                            gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                    {
                        if(!gamePresetLayout.isHasEmptyItemOfArrayItemAnotherRoleList())
                        {
                            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(gamePresetLayout));
                        }
                    }
                    else
                    {
                        gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                    }
                }
                else
                {
                    AppSettings.showDialog(3);
                }
            }
        });

        button_number_of_maniac_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamePresetLayout.maniac != 0)
                {
                    gamePresetLayout.maniac--;
                    text_number_of_maniac.setText(String.valueOf(gamePresetLayout.maniac));

                    if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                            gamePresetLayout.doctor +
                            gamePresetLayout.whore +
                            gamePresetLayout.maniac +
                            gamePresetLayout.sheriff +
                            gamePresetLayout.godfather +
                            gamePresetLayout.mafia +
                            gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                    {
                        if(!gamePresetLayout.isHasEmptyItemOfArrayItemAnotherRoleList())
                        {
                            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(gamePresetLayout));
                        }
                    }
                    else
                    {
                        gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                    }
                }
            }
        });

        button_number_of_sheriff_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                        gamePresetLayout.doctor +
                        gamePresetLayout.whore +
                        gamePresetLayout.maniac +
                        gamePresetLayout.sheriff +
                        gamePresetLayout.godfather +
                        gamePresetLayout.mafia +
                        gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                {
                    gamePresetLayout.sheriff++;
                    text_number_of_sheriff.setText(String.valueOf(gamePresetLayout.sheriff));

                    if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                            gamePresetLayout.doctor +
                            gamePresetLayout.whore +
                            gamePresetLayout.maniac +
                            gamePresetLayout.sheriff +
                            gamePresetLayout.godfather +
                            gamePresetLayout.mafia +
                            gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                    {
                        if(!gamePresetLayout.isHasEmptyItemOfArrayItemAnotherRoleList())
                        {
                            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(gamePresetLayout));
                        }
                    }
                    else
                    {
                        gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                    }
                }
                else
                {
                    AppSettings.showDialog(3);
                }
            }
        });

        button_number_of_sheriff_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamePresetLayout.sheriff != 0)
                {
                    gamePresetLayout.sheriff--;
                    text_number_of_sheriff.setText(String.valueOf(gamePresetLayout.sheriff));

                    if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                            gamePresetLayout.doctor +
                            gamePresetLayout.whore +
                            gamePresetLayout.maniac +
                            gamePresetLayout.sheriff +
                            gamePresetLayout.godfather +
                            gamePresetLayout.mafia +
                            gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                    {
                        if(!gamePresetLayout.isHasEmptyItemOfArrayItemAnotherRoleList())
                        {
                            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(gamePresetLayout));
                        }
                    }
                    else
                    {
                        gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                    }
                }
            }
        });

        button_number_of_godfather_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                        gamePresetLayout.doctor +
                        gamePresetLayout.whore +
                        gamePresetLayout.maniac +
                        gamePresetLayout.sheriff +
                        gamePresetLayout.godfather +
                        gamePresetLayout.mafia +
                        gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                {
                    gamePresetLayout.godfather++;
                    text_number_of_godfather.setText(String.valueOf(gamePresetLayout.godfather));

                    if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                            gamePresetLayout.doctor +
                            gamePresetLayout.whore +
                            gamePresetLayout.maniac +
                            gamePresetLayout.sheriff +
                            gamePresetLayout.godfather +
                            gamePresetLayout.mafia +
                            gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                    {
                        if(!gamePresetLayout.isHasEmptyItemOfArrayItemAnotherRoleList())
                        {
                            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(gamePresetLayout));
                        }
                    }
                    else
                    {
                        gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                    }
                }
                else
                {
                    AppSettings.showDialog(3);
                }
            }
        });

        button_number_of_godfather_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamePresetLayout.godfather != 0)
                {
                    gamePresetLayout.godfather--;
                    text_number_of_godfather.setText(String.valueOf(gamePresetLayout.godfather));

                    if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                            gamePresetLayout.doctor +
                            gamePresetLayout.whore +
                            gamePresetLayout.maniac +
                            gamePresetLayout.sheriff +
                            gamePresetLayout.godfather +
                            gamePresetLayout.mafia +
                            gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                    {
                        if(!gamePresetLayout.isHasEmptyItemOfArrayItemAnotherRoleList())
                        {
                            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(gamePresetLayout));
                        }
                    }
                    else
                    {
                        gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                    }
                }
            }
        });

        button_number_of_mafia_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                        gamePresetLayout.doctor +
                        gamePresetLayout.whore +
                        gamePresetLayout.maniac +
                        gamePresetLayout.sheriff +
                        gamePresetLayout.godfather +
                        gamePresetLayout.mafia +
                        gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                {
                    gamePresetLayout.mafia++;
                    text_number_of_mafia.setText(String.valueOf(gamePresetLayout.mafia));

                    if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                            gamePresetLayout.doctor +
                            gamePresetLayout.whore +
                            gamePresetLayout.maniac +
                            gamePresetLayout.sheriff +
                            gamePresetLayout.godfather +
                            gamePresetLayout.mafia +
                            gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                    {
                        if(!gamePresetLayout.isHasEmptyItemOfArrayItemAnotherRoleList())
                        {
                            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(gamePresetLayout));
                        }
                    }
                    else
                    {
                        gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                    }
                }
                else
                {
                    AppSettings.showDialog(3);
                }
            }
        });

        button_number_of_mafia_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamePresetLayout.mafia != 0)
                {
                    gamePresetLayout.mafia--;
                    text_number_of_mafia.setText(String.valueOf(gamePresetLayout.mafia));

                    if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                            gamePresetLayout.doctor +
                            gamePresetLayout.whore +
                            gamePresetLayout.maniac +
                            gamePresetLayout.sheriff +
                            gamePresetLayout.godfather +
                            gamePresetLayout.mafia +
                            gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                    {
                        if(!gamePresetLayout.isHasEmptyItemOfArrayItemAnotherRoleList())
                        {
                            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(gamePresetLayout));
                        }
                    }
                    else
                    {
                        gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                    }
                }
            }
        });

        button_number_of_civilians_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                    if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                            gamePresetLayout.doctor +
                            gamePresetLayout.whore +
                            gamePresetLayout.maniac +
                            gamePresetLayout.sheriff +
                            gamePresetLayout.godfather +
                            gamePresetLayout.mafia +
                            gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                    {
                        gamePresetLayout.civilian++;
                        text_number_of_civilians.setText(String.valueOf(gamePresetLayout.civilian));

                        if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                                gamePresetLayout.doctor +
                                gamePresetLayout.whore +
                                gamePresetLayout.maniac +
                                gamePresetLayout.sheriff +
                                gamePresetLayout.godfather +
                                gamePresetLayout.mafia +
                                gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                        {
                            if(!gamePresetLayout.isHasEmptyItemOfArrayItemAnotherRoleList())
                            {
                                gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(gamePresetLayout));
                            }
                        }
                        else
                        {
                            gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                        }
                    }
                    else
                    {
                        AppSettings.showDialog(3);
                    }
                }
            }
        });

        button_number_of_civilians_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamePresetLayout.civilian != 0)
                {
                    gamePresetLayout.civilian--;
                    text_number_of_civilians.setText(String.valueOf(gamePresetLayout.civilian));

                    if (gamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                            gamePresetLayout.doctor +
                            gamePresetLayout.whore +
                            gamePresetLayout.maniac +
                            gamePresetLayout.sheriff +
                            gamePresetLayout.godfather +
                            gamePresetLayout.mafia +
                            gamePresetLayout.civilian + 1 <= AppSettings.max_players)
                    {
                        if(!gamePresetLayout.isHasEmptyItemOfArrayItemAnotherRoleList())
                        {
                            gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(gamePresetLayout));
                        }
                    }
                    else
                    {
                        gamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                    }
                }
            }
        });
    }

    @Override
    public void onPause()
    {
        IO.writeToSD(CustomizeGameActivity.gamePresetLayout, IO.CUSTOMIZEGAMEstate, "CUSTOMIZEGAMEstate");
        MafiaProjectProApp.setContext(null);
        super.onPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        MafiaProjectProApp.setContext(this);

        IO.deleteFromSD(IO.CUSTOMIZEGAMEstate, "CUSTOMIZEGAMEstate");

        for(ItemInAnotherRoleList item : gamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles)
        {
            item.deinitiate();
            item.initiate();
        }

        CustomizeGameActivity.imm.hideSoftInputFromWindow(mainScrollView.getWindowToken(), 0);
    }

    public void onBackPressed()
    {
        startActivity(toChooseGameModeActivityIntent);
        finish();
    }
}
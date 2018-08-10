package com.charleyskills.mafiaprojectpro.lwp;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.charleyskills.mafiaprojectpro.AppSettings;
import com.charleyskills.mafiaprojectpro.MafiaProjectProApp;
import com.charleyskills.mafiaprojectpro.R;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name="ItemLWP")
class ItemLWP
{
    @Attribute(name="nickname")
    final String nickname;

    @Attribute(name="defaultNickname")
    final boolean defaultNickname;

    @Attribute(name="gameResult")
    int gameResult = LWPActivity.NoCalcResultGame;

    FrameLayout fLayout_voting;
    LinearLayout.LayoutParams fParam_voting;
    TextView tNickname_voting;
    FrameLayout.LayoutParams tNicknameParam_voting;
    ImageView spinner_voting;
    FrameLayout.LayoutParams sParam_voting;
    TextView tCountOfVoting_voting;
    FrameLayout.LayoutParams tCountOfVotingParam_voting;

    @Attribute(name="countOfVoting_voting")
    int countOfVoting_voting = 0;

    ImageView breaker_voting;
    LinearLayout.LayoutParams bParam_voting;
    //------------------------------------------------------------------
    View.OnClickListener itemOnClickListener_voting;
    FrameLayout fLayout;
    FrameLayout.LayoutParams fParam;

    @Attribute(name="role")
    String role;

    TextView tTextNickname;
    FrameLayout.LayoutParams tNicknameParam;
    ImageView foul;
    FrameLayout.LayoutParams foulParam;

    @Attribute(name="numberInList")
    int numberInList;

    @Attribute(name="counterBans")
    int counterBans = 0;

    @Attribute(name="activePlayer")
    boolean activePlayer = true;

    ImageView breaker;
    LinearLayout.LayoutParams bParam;
    View.OnClickListener itemOnClickListener;
    ImageView playerVote_image;
    LinearLayout.LayoutParams pi_layoutParams;
    ImageView voteRedSquare;
    LinearLayout.LayoutParams vrs_layoutParams;
    FrameLayout globalInItemList;
    FrameLayout.LayoutParams giil_layoutParams;

    ItemLWP(@Attribute(name="nickname") final String nickname, @Attribute(name="defaultNickname") final boolean defaultNickname, @Attribute(name="gameResult") int gameResult, @Attribute(name="countOfVoting_voting") int countOfVoting_voting, @Attribute(name="role") String role, @Attribute(name="numberInList") int numberInList, @Attribute(name="counterBans") int counterBans, @Attribute(name="activePlayer") boolean activePlayer)
    {
        this.nickname = nickname;
        this.defaultNickname = defaultNickname;
        this.gameResult = gameResult;
        this.countOfVoting_voting = countOfVoting_voting;
        this.role = role;
        this.numberInList = numberInList;
        this.counterBans = counterBans;
        this.activePlayer = activePlayer;

        if (numberInList != 0)
        {
            breaker = new ImageView(MafiaProjectProApp.getContext());
            bParam = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 1);
            bParam.setMargins(AppSettings.getDP(10), 0, AppSettings.getDP(10), 0);
            breaker.setBackgroundColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.divider));
            LWPActivity.LWP.addView(breaker, bParam);
        }

        initiateGlobalList();
    }

    ItemLWP(int numberInList, String role, String nickname, boolean defaultNickname)
    {
        this.defaultNickname = defaultNickname;
        this.nickname = nickname;
        this.role = role;
        this.numberInList = numberInList;

        if (numberInList != 0)
        {
            breaker = new ImageView(MafiaProjectProApp.getContext());
            bParam = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 1);
            bParam.setMargins(AppSettings.getDP(10), 0, AppSettings.getDP(10), 0);
            breaker.setBackgroundColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.divider));
            LWPActivity.LWP.addView(breaker, bParam);
        }

        initiateGlobalList();
    }

    void addBreaker_voting_LWP()
    {
        breaker_voting = new ImageView(MafiaProjectProApp.getContext());
        bParam_voting = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 1);
        bParam_voting.setMargins(AppSettings.getDP(10), 0, AppSettings.getDP(10), 0);
        breaker_voting.setBackgroundColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.divider));
        LWPActivity.voting_LWP.addView(breaker_voting, bParam_voting);
    }

    private void initiateGlobalList()
    {
        fLayout = new FrameLayout(MafiaProjectProApp.getContext());
        fParam = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        tTextNickname = new TextView(MafiaProjectProApp.getContext());
        tNicknameParam = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        tNicknameParam.gravity = Gravity.CENTER_VERTICAL;
        foul = new ImageView(MafiaProjectProApp.getContext());
        foulParam = new FrameLayout.LayoutParams(AppSettings.getDP(43), AppSettings.getDP(38));

        playerVote_image = new ImageView(MafiaProjectProApp.getContext());
        pi_layoutParams = new LinearLayout.LayoutParams(AppSettings.getDP(50), AppSettings.getDP(38));

        voteRedSquare = new ImageView(MafiaProjectProApp.getContext());
        vrs_layoutParams = new LinearLayout.LayoutParams(AppSettings.getDP(7), AppSettings.getDP(41));

        globalInItemList = new FrameLayout(MafiaProjectProApp.getContext());
        giil_layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, AppSettings.getDP(41));

        LWPActivity.LWP.addView(fLayout, fParam);

        giil_layoutParams.setMargins(AppSettings.getDP(10), 0, AppSettings.getDP(10), 0);
        giil_layoutParams.gravity = Gravity.RIGHT;
        globalInItemList.setBackgroundResource(R.drawable.itemingloballist_lwp);
        globalInItemList.setClickable(true);
        globalInItemList.setFocusable(true);
        fLayout.addView(globalInItemList, giil_layoutParams);

        voteRedSquare.setBackgroundColor(Color.TRANSPARENT);
        vrs_layoutParams.gravity = Gravity.LEFT;
        fLayout.addView(voteRedSquare, vrs_layoutParams);

        if (numberInList + 1 < 10)
        {
            tTextNickname.setText(String.format("%d.  %s", numberInList + 1, nickname));
        }
        else
        {
            tTextNickname.setText(String.format("%d.%s", numberInList + 1, nickname));
        }
        tTextNickname.setTextSize(25);
        tTextNickname.setPadding(AppSettings.getDP(5), 0, 0, 0);

        tTextNickname.setTextColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.White));
        globalInItemList.addView(tTextNickname, tNicknameParam);

        foulParam.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT;
        foulParam.rightMargin = 10;
        foul.setVisibility(View.INVISIBLE);
        globalInItemList.addView(foul, foulParam);

        itemOnClickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                fLayout.setClickable(false);
                LWPActivity.alertDialog_LWP.setTitle(nickname);

                if (activePlayer)
                {
                    if (counterBans == 0)
                    {
                        if (!LWPActivity.getContainerPositionOfVoting().contains(numberInList))
                        {
                            AppSettings.LWParrayAdapter = new ArrayAdapter<String>(MafiaProjectProApp.getContext(), android.R.layout.select_dialog_item);
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.add_ban_LWP));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.votefor_LWP));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_kill_player));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_show_player_role));

                            LWPActivity.alertDialog_LWP.setAdapter(AppSettings.LWParrayAdapter, new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    switch (which)
                                    {
                                        case 0:
                                            addBan();
                                            break;
                                        case 1:
                                            LWPActivity.getContainerPositionOfVoting().add(numberInList);
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.sys_wasputtothevote), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 2:
                                            LWPActivity.getContainerPositionOfVoting().kill(numberInList);
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.sys_waskilled), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 3:
                                            Toast.makeText(MafiaProjectProApp.getContext(), numberInList + 1 + ". " + AppSettings.getFullNameRole(role), Toast.LENGTH_SHORT).show();
                                            break;
                                    }
                                }
                            });
                        }
                        else
                        {
                            AppSettings.LWParrayAdapter = new ArrayAdapter<String>(MafiaProjectProApp.getContext(), android.R.layout.select_dialog_item);
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.add_ban_LWP));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_unvotefor));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_kill_player));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_show_player_role));

                            LWPActivity.alertDialog_LWP.setAdapter(AppSettings.LWParrayAdapter, new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    switch (which)
                                    {
                                        case 0:
                                            addBan();
                                            break;
                                        case 1:
                                            LWPActivity.getContainerPositionOfVoting().custom_remove(numberInList);
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.sys_nogovote), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 2:
                                            LWPActivity.getContainerPositionOfVoting().kill(numberInList);
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.sys_waskilled), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 3:
                                            Toast.makeText(MafiaProjectProApp.getContext(), numberInList + 1 + ". " + AppSettings.getFullNameRole(role), Toast.LENGTH_SHORT).show();
                                            break;
                                    }
                                }
                            });
                        }
                    }
                    else
                    if (counterBans == 3)
                    {
                        if (!LWPActivity.getContainerPositionOfVoting().contains(numberInList))
                        {
                            AppSettings.LWParrayAdapter = new ArrayAdapter<String>(MafiaProjectProApp.getContext(), android.R.layout.select_dialog_item);
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_remove_player));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_remove_ban));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.votefor_LWP));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_kill_player));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_show_player_role));

                            LWPActivity.alertDialog_LWP.setAdapter(AppSettings.LWParrayAdapter, new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    switch (which)
                                    {
                                        case 0:
                                            addBan();
                                            break;
                                        case 1:
                                            removeBan();
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.LWP_removefoul), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 2:
                                            LWPActivity.getContainerPositionOfVoting().add(numberInList);
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.sys_wasputtothevote), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 3:
                                            LWPActivity.getContainerPositionOfVoting().kill(numberInList);
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.sys_waskilled), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 4:
                                            Toast.makeText(MafiaProjectProApp.getContext(), numberInList + 1 + ". " + AppSettings.getFullNameRole(role), Toast.LENGTH_SHORT).show();
                                            break;
                                    }
                                }
                            });
                        }
                        else
                        {
                            AppSettings.LWParrayAdapter = new ArrayAdapter<String>(MafiaProjectProApp.getContext(), android.R.layout.select_dialog_item);
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_remove_player));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_remove_ban));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_unvotefor));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_kill_player));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_show_player_role));

                            LWPActivity.alertDialog_LWP.setAdapter(AppSettings.LWParrayAdapter, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    switch (which)
                                    {
                                        case 0:
                                            addBan();
                                            break;
                                        case 1:
                                            removeBan();
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.LWP_removefoul), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 2:
                                            LWPActivity.getContainerPositionOfVoting().custom_remove(numberInList);
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.sys_nogovote), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 3:
                                            LWPActivity.getContainerPositionOfVoting().kill(numberInList);
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.sys_waskilled), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 4:
                                            Toast.makeText(MafiaProjectProApp.getContext(), numberInList + 1 + ". " + AppSettings.getFullNameRole(role), Toast.LENGTH_SHORT).show();
                                            break;
                                    }
                                }
                            });
                        }
                    }
                    else
                    if (counterBans < 3)
                    {
                        if (!LWPActivity.getContainerPositionOfVoting().contains(numberInList))
                        {
                            AppSettings.LWParrayAdapter = new ArrayAdapter<String>(MafiaProjectProApp.getContext(), android.R.layout.select_dialog_item);
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.add_ban_LWP));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_remove_ban));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.votefor_LWP));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_kill_player));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_show_player_role));

                            LWPActivity.alertDialog_LWP.setAdapter(AppSettings.LWParrayAdapter, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    switch (which)
                                    {
                                        case 0:
                                            addBan();
                                            break;
                                        case 1:
                                            removeBan();
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.LWP_removefoul), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 2:
                                            LWPActivity.getContainerPositionOfVoting().add(numberInList);
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.sys_wasputtothevote), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 3:
                                            LWPActivity.getContainerPositionOfVoting().kill(numberInList);
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.sys_waskilled), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 4:
                                            Toast.makeText(MafiaProjectProApp.getContext(), numberInList + 1 + ". " + AppSettings.getFullNameRole(role), Toast.LENGTH_SHORT).show();
                                            break;
                                    }
                                }
                            });
                        }
                        else
                        {
                            AppSettings.LWParrayAdapter = new ArrayAdapter<String>(MafiaProjectProApp.getContext(), android.R.layout.select_dialog_item);
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.add_ban_LWP));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_remove_ban));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_unvotefor));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_kill_player));
                            AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_show_player_role));

                            LWPActivity.alertDialog_LWP.setAdapter(AppSettings.LWParrayAdapter, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    switch (which)
                                    {
                                        case 0:
                                            addBan();
                                            break;
                                        case 1:
                                            removeBan();
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.LWP_removefoul), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 2:
                                            LWPActivity.getContainerPositionOfVoting().custom_remove(numberInList);
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.sys_nogovote), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 3:
                                            LWPActivity.getContainerPositionOfVoting().kill(numberInList);
                                            Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.sys_waskilled), Toast.LENGTH_SHORT).show();
                                            break;
                                        case 4:
                                            Toast.makeText(MafiaProjectProApp.getContext(), numberInList + 1 + ". " + AppSettings.getFullNameRole(role), Toast.LENGTH_SHORT).show();
                                            break;
                                    }
                                }
                            });
                        }
                    }
                }
                else
                {
                    AppSettings.LWParrayAdapter = new ArrayAdapter<String>(MafiaProjectProApp.getContext(), android.R.layout.select_dialog_item);
                    AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.voting_returntogame));
                    AppSettings.LWParrayAdapter.add(MafiaProjectProApp.getContext().getString(R.string.LWP_show_player_role));

                    LWPActivity.alertDialog_LWP.setAdapter(AppSettings.LWParrayAdapter, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which)
                            {
                                case 0:
                                    alivePlayer();
                                    break;
                                case 1:
                                    Toast.makeText(MafiaProjectProApp.getContext(), numberInList + 1 + ". " + AppSettings.getFullNameRole(role), Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    });
                }
                AppSettings.brandAlertDialog(LWPActivity.alertDialog_LWP.show());
                fLayout.setClickable(true);
            }
        };

        globalInItemList.setOnClickListener(itemOnClickListener);

        playerVote_image.setLayoutParams(pi_layoutParams);
        playerVote_image.setBackgroundResource(AppSettings.getVotePlayer(numberInList + 1));

        initiateBanSetup();
        initiateAliveSetup();
    }

    void initiateVotingList()
    {
        fLayout_voting = new FrameLayout(MafiaProjectProApp.getContext());
        fLayout_voting.setBackgroundResource(R.drawable.itemingloballist_lwp);
        fParam_voting = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, AppSettings.getDP(41));
        fParam_voting.setMargins(AppSettings.getDP(10), 0, AppSettings.getDP(10), 0);

        tNickname_voting = new TextView(MafiaProjectProApp.getContext());
        tNicknameParam_voting = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

        tCountOfVoting_voting = new TextView(MafiaProjectProApp.getContext());
        tCountOfVotingParam_voting = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

        spinner_voting = new ImageView(MafiaProjectProApp.getContext());
        sParam_voting = new FrameLayout.LayoutParams(AppSettings.getDP(30), AppSettings.getDP(25));

        LWPActivity.voting_LWP.addView(fLayout_voting, fParam_voting);

        tNicknameParam_voting.gravity = Gravity.LEFT;

        if (numberInList + 1 < 10)
        {
            tNickname_voting.setText(String.format(" %d.  %s", numberInList + 1, nickname));
        }
        else
        {
            tNickname_voting.setText(String.format(" %d.%s", numberInList + 1, nickname));
        }
        tNickname_voting.setTextSize(25);

        tNickname_voting.setTextColor(Color.WHITE);
        fLayout_voting.addView(tNickname_voting, tNicknameParam_voting);

        tCountOfVoting_voting.setText(String.valueOf(countOfVoting_voting));
        tCountOfVoting_voting.setTextSize(27);
        tCountOfVoting_voting.setTextColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.White));

        tCountOfVotingParam_voting.setMargins(0, 0, AppSettings.getDP(40), 0);
        tCountOfVotingParam_voting.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT;
        fLayout_voting.addView(tCountOfVoting_voting, tCountOfVotingParam_voting);

        spinner_voting.setBackgroundResource(R.drawable.pic_spinner);

        itemOnClickListener_voting = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fLayout_voting.setClickable(false);
                LWPActivity.containerLWPState.avalableVotes = LWPActivity.containerLWPState.possibleVotingPlayers;

                for(Integer i : LWPActivity.getContainerPositionOfVoting())
                {
                    LWPActivity.containerLWPState.avalableVotes = LWPActivity.containerLWPState.avalableVotes - LWPActivity.getItemInGlobalLWPList().get(i).countOfVoting_voting;
                }

                AppSettings.LWParrayAdapterSpinner = new ArrayAdapter<String>(MafiaProjectProApp.getContext(), android.R.layout.select_dialog_item);
                for (int j = 0; j <= countOfVoting_voting + LWPActivity.containerLWPState.avalableVotes; j++)
                {
                    AppSettings.LWParrayAdapterSpinner.add(AppSettings.data_adapterAdapterSpinner[countOfVoting_voting + LWPActivity.containerLWPState.avalableVotes][j]);
                }

                LWPActivity.alertDialog_voting_LWP.setTitle(nickname);
                LWPActivity.alertDialog_voting_LWP.setAdapter(AppSettings.LWParrayAdapterSpinner, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        countOfVoting_voting = which;
                        tCountOfVoting_voting.setText(String.valueOf(countOfVoting_voting));
                    }
                });
                AppSettings.brandAlertDialog(LWPActivity.alertDialog_voting_LWP.show());
                fLayout_voting.setClickable(true);
            }
        };

        fLayout_voting.setOnClickListener(itemOnClickListener_voting);

        sParam_voting.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT;
        fLayout_voting.addView(spinner_voting, sParam_voting);
    }

    private void initiateBanSetup()
    {
        switch (counterBans)
        {
            case 0:
                foul.setVisibility(View.INVISIBLE);
                break;

            case 1:
                foul.setVisibility(View.VISIBLE);
                foul.setBackgroundResource(R.drawable.x_1);
                break;

            case 2:
                foul.setVisibility(View.VISIBLE);
                foul.setBackgroundResource(R.drawable.x_2);
                break;

            case 3:
                foul.setVisibility(View.VISIBLE);
                foul.setBackgroundResource(R.drawable.x_3);
                break;

            case 4:
                foul.setVisibility(View.VISIBLE);
                foul.setBackgroundResource(R.drawable.x_4);
                break;
        }
    }

    private void initiateAliveSetup()
    {
        if(!activePlayer)
        {
            tTextNickname.setTextColor(Color.GRAY);
            tTextNickname.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        }
    }

    private void alivePlayer()
    {
        if (counterBans == 4)
        {
            removeBan();
        }
        tTextNickname.setTextColor(Color.WHITE);
        tTextNickname.setPaintFlags(Paint.ANTI_ALIAS_FLAG | Paint.LINEAR_TEXT_FLAG);

        activePlayer = true;
        LWPActivity.containerLWPState.possibleVotingPlayers++;
        System.gc();
    }

    private void removeBan()
    {
        switch (counterBans)
        {
            case 1:
                foul.setVisibility(View.INVISIBLE);
                counterBans--;
                Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.LWP_removefoul), Toast.LENGTH_SHORT).show();
                System.gc();
                break;

            case 2:
                foul.setBackgroundResource(R.drawable.x_1);
                counterBans--;
                Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.LWP_removefoul), Toast.LENGTH_SHORT).show();
                System.gc();
                break;

            case 3:
                foul.setBackgroundResource(R.drawable.x_2);
                counterBans--;
                Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.LWP_removefoul), Toast.LENGTH_SHORT).show();
                System.gc();
                break;

            case 4:
                foul.setBackgroundResource(R.drawable.x_3);
                counterBans--;
                System.gc();
                break;
        }
    }

    private void addBan()
    {
        switch (counterBans)
        {
            case 0:
                foul.setVisibility(View.VISIBLE);
                foul.setBackgroundResource(R.drawable.x_1);
                counterBans++;
                Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.LWP_addfoul), Toast.LENGTH_SHORT).show();
                System.gc();
                break;

            case 1:
                foul.setBackgroundResource(R.drawable.x_2);
                counterBans++;
                Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.LWP_addfoul), Toast.LENGTH_SHORT).show();
                System.gc();
                break;

            case 2:
                foul.setBackgroundResource(R.drawable.x_3);
                counterBans++;
                Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.LWP_addfoul), Toast.LENGTH_SHORT).show();
                System.gc();
                break;

            case 3:
                LWPActivity.getContainerPositionOfVoting().custom_remove(numberInList);

                Toast.makeText(MafiaProjectProApp.getContext(), nickname + " " + MafiaProjectProApp.getContext().getString(R.string.LWP_removePlayer), Toast.LENGTH_SHORT).show();
                counterBans++;
                tTextNickname.setTextColor(Color.GRAY);
                tTextNickname.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
                foul.setBackgroundResource(R.drawable.x_4);

                activePlayer = false;
                LWPActivity.containerLWPState.possibleVotingPlayers--;
                LWPActivity.checkMafiaWin();
                LWPActivity.checkCivilianWin();
                System.gc();
                break;
        }
    }
}
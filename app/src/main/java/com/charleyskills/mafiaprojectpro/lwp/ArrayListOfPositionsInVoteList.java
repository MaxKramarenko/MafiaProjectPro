package com.charleyskills.mafiaprojectpro.lwp;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name="ArrayListOfPositionsInVoteList")
class ArrayListOfPositionsInVoteList extends ArrayList<Integer>
{
    @Override
    public boolean add(Integer numberInList)
    {
        LWPActivity.horizontalPlayerVoteList_LWP.setVisibility(View.VISIBLE);
        LWPActivity.horizontalLinearLayout_LWP.removeView(LWPActivity.getItemInGlobalLWPList().get(numberInList).playerVote_image);
        LWPActivity.horizontalLinearLayout_LWP.addView(LWPActivity.getItemInGlobalLWPList().get(numberInList).playerVote_image);
        LWPActivity.getItemInGlobalLWPList().get(numberInList).voteRedSquare.setBackgroundColor(Color.RED);

        LWPActivity.horizontalScrollView_LWP.post(new Thread(new Runnable() {
            @Override
            public void run() {
                LWPActivity.horizontalScrollView_LWP.fullScroll(View.FOCUS_RIGHT);
            }
        }));

        LWPActivity.getItemInGlobalLWPList().get(numberInList).initiateVotingList();
        LWPActivity.getItemInGlobalLWPList().get(numberInList).addBreaker_voting_LWP();
        return super.add(numberInList);
    }

    void custom_remove(int numberInList)
    {
        if(!this.contains(numberInList))
        {
            return;
        }

        LWPActivity.horizontalLinearLayout_LWP.removeView(LWPActivity.getItemInGlobalLWPList().get(numberInList).playerVote_image);
        LWPActivity.getItemInGlobalLWPList().get(numberInList).voteRedSquare.setBackgroundColor(Color.TRANSPARENT);
        LWPActivity.getItemInGlobalLWPList().get(numberInList).countOfVoting_voting = 0;
        LWPActivity.getItemInGlobalLWPList().get(numberInList).tCountOfVoting_voting.setText("0");

        LWPActivity.voting_LWP.removeView(LWPActivity.getItemInGlobalLWPList().get(numberInList).fLayout_voting);
        LWPActivity.voting_LWP.removeView(LWPActivity.getItemInGlobalLWPList().get(numberInList).breaker_voting);

        remove(this.indexOf(numberInList));

        if(this.size() == 0)
        {
            LWPActivity.horizontalPlayerVoteList_LWP.setVisibility(View.GONE);
        }
    }

    void kill(int numberInList)
    {
        LWPActivity.getItemInGlobalLWPList().get(numberInList).tTextNickname.setTextColor(Color.GRAY);
        LWPActivity.getItemInGlobalLWPList().get(numberInList).tTextNickname.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);

        custom_remove(numberInList);

        LWPActivity.getItemInGlobalLWPList().get(numberInList).activePlayer = false;
        LWPActivity.containerLWPState.possibleVotingPlayers--;

        if (LWPActivity.containerLWPState.possibleVotingPlayers != 0)
        {
            LWPActivity.checkMafiaWin();
            LWPActivity.checkCivilianWin();
        }
        System.gc();
    }
}

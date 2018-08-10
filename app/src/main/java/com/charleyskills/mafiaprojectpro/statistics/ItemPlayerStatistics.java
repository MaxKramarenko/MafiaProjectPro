package com.charleyskills.mafiaprojectpro.statistics;

import android.view.View;

import com.charleyskills.mafiaprojectpro.lwp.LWPActivity;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name="ItemPlayerStatistics")
public class ItemPlayerStatistics
{
    ArrayAdapterStatistics.ListViewHolder holder;
    boolean checkbox_checked = false;
    int checkbox_visibility = View.GONE;
    boolean expanded = false;

    @Attribute(name="name")
    public String name;

    @Attribute(name="totalPlayedGames")
    int totalPlayedGames = 0;

    @Attribute(name="totalWinPlayedGames")
    int totalWinPlayedGames = 0;

    @Attribute(name="playedRedTeam")
    int playedRedTeam = 0;

    @Attribute(name="winRedTeam")
    int winRedTeam = 0;

    @Attribute(name="playedBlackTeam")
    int playedBlackTeam = 0;

    @Attribute(name="winBlackTeam")
    int winBlackTeam = 0;

    @Attribute(name="playerDoctor")
    int playerDoctor = 0;

    @Attribute(name="winDoctor")
    int winDoctor = 0;

    @Attribute(name="playerWhore")
    int playerWhore = 0;

    @Attribute(name="winWhore")
    int winWhore = 0;

    @Attribute(name="playerManiac")
    int playerManiac = 0;

    @Attribute(name="winManiac")
    int winManiac = 0;

    @Attribute(name="playerSherif")
    int playerSherif = 0;

    @Attribute(name="winSherif")
    int winSherif = 0;

    @Attribute(name="playerGodFather")
    int playerGodFather = 0;

    @Attribute(name="winGodFather")
    int winGodFather = 0;

    @Attribute(name="playerMafia")
    int playerMafia = 0;

    @Attribute(name="winMafia")
    int winMafia = 0;

    @Attribute(name="playerCivilian")
    int playerCivilian = 0;

    @Attribute(name="winCivilian")
    int winCivilian = 0;

    // StatisticsActivity
    ArrayList<Entry> entsWinPlayerStat = new ArrayList<>();
    ArrayList<BarEntry> entsTotalPlayerStat = new ArrayList<>();

    public ItemPlayerStatistics(@Attribute(name="name") String name, @Attribute(name="totalPlayedGames") int totalPlayedGames, @Attribute(name="totalWinPlayedGames") int totalWinPlayedGames, @Attribute(name="playedRedTeam") int playedRedTeam, @Attribute(name="winRedTeam") int winRedTeam, @Attribute(name="playedBlackTeam") int playedBlackTeam, @Attribute(name="winBlackTeam") int winBlackTeam, @Attribute(name="playerDoctor") int playerDoctor, @Attribute(name="winDoctor") int winDoctor, @Attribute(name="playerWhore") int playerWhore, @Attribute(name="winWhore") int winWhore, @Attribute(name="playerManiac") int playerManiac, @Attribute(name="winManiac") int winManiac, @Attribute(name="playerSherif") int playerSherif, @Attribute(name="winSherif") int winSherif, @Attribute(name="playerGodFather") int playerGodFather, @Attribute(name="winGodFather") int winGodFather, @Attribute(name="playerMafia") int playerMafia, @Attribute(name="winMafia") int winMafia, @Attribute(name="playerCivilian") int playerCivilian, @Attribute(name="winCivilian") int winCivilian)
    {
        this.name = name;
        this.totalPlayedGames = totalPlayedGames;
        this.totalWinPlayedGames = totalWinPlayedGames;
        this.playedRedTeam = playedRedTeam;
        this.winRedTeam = winRedTeam;
        this.playedBlackTeam = playedBlackTeam;
        this.winBlackTeam = winBlackTeam;
        this.playerDoctor = playerDoctor;
        this.winDoctor = winDoctor;
        this.playerWhore = playerWhore;
        this.winWhore = winWhore;
        this.playerManiac = playerManiac;
        this.winManiac = winManiac;
        this.playerSherif = playerSherif;
        this.winSherif = winSherif;
        this.playerGodFather = playerGodFather;
        this.winGodFather = winGodFather;
        this.playerMafia = playerMafia;
        this.winMafia = winMafia;
        this.playerCivilian = playerCivilian;
        this.winCivilian = winCivilian;
    }

    public ItemPlayerStatistics(String name)
    {
        this.name = name;
    }

    public void played(String role, int result)
    {
        switch (role) {
            case "_C_":
                playedCivilian(result);
                break;
            case "_Maf_":
                playedMafia(result);
                break;
            case "_S_":
                playedSheriff(result);
                break;
            case "_G_":
                playedGodFather(result);
                break;
            case "_D_":
                playedDoctor(result);
                break;
            case "_W_":
                playedWhore(result);
                break;
            case "_Man_":
                playedManiac(result);
                break;
            default:
                playedAnotherRole(result);
                break;
        }
    }

    private void playedAnotherRole(int result)
    {
        totalPlayedGames++;
        if (result == LWPActivity.GameVictory)
        {
            totalWinPlayedGames++;
        }
    }

    private void playedDoctor(int result)
    {
        totalPlayedGames++;
        playedRedTeam++;
        playerDoctor++;
        if (result == LWPActivity.GameVictory)
        {
            totalWinPlayedGames++;
            winRedTeam++;
            winDoctor++;
        }
    }

    private void playedWhore(int result)
    {
        totalPlayedGames++;
        playerWhore++;
        if (result == LWPActivity.GameVictory)
        {
            totalWinPlayedGames++;
            winWhore++;
        }
    }

    private void playedManiac(int result)
    {
        totalPlayedGames++;
        playerManiac++;
        if (result == LWPActivity.GameVictory)
        {
            totalWinPlayedGames++;
            winManiac++;
        }
    }

    private void playedSheriff(int result)
    {
        totalPlayedGames++;
        playedRedTeam++;
        playerSherif++;
        if (result == LWPActivity.GameVictory)
        {
            totalWinPlayedGames++;
            winRedTeam++;
            winSherif++;
        }
    }

    private void playedGodFather(int result)
    {
        totalPlayedGames++;
        playedBlackTeam++;
        playerGodFather++;
        if (result == LWPActivity.GameVictory)
        {
            totalWinPlayedGames++;
            winBlackTeam++;
            winGodFather++;
        }
    }

    private void playedMafia(int result)
    {
        totalPlayedGames++;
        playedBlackTeam++;
        playerMafia++;
        if (result == LWPActivity.GameVictory)
        {
            totalWinPlayedGames++;
            winBlackTeam++;
            winMafia++;
        }
    }

    private void playedCivilian(int result)
    {
        totalPlayedGames++;
        playedRedTeam++;
        playerCivilian++;
        if (result == LWPActivity.GameVictory)
        {
            totalWinPlayedGames++;
            winRedTeam++;
            winCivilian++;
        }
    }
}

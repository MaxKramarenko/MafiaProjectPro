package com.charleyskills.mafiaprojectpro.lwp;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name="ContainerLWPState")
class ContainerLWPState
{
    @Attribute(name="game_not_done")
    boolean game_not_done = true;

    @Attribute(name="possibleVotingPlayers")
    int possibleVotingPlayers;

    @Attribute(name="avalableVotes")
    int avalableVotes;

    @Attribute(name="checkCivilianWinShow")
    boolean checkCivilianWinShow = true;

    @Attribute(name="checkMafiaWinShow")
    boolean checkMafiaWinShow = true;

    @Attribute(name="window_voting_showing")
    boolean window_voting_showing = false;

    @Attribute(name="counterSkirmish")
    int counterSkirmish = 0;

    @ElementList(required = false, entry = "ItemLWP", inline = true, name = "ArrayListOfItemLWP", type=ItemLWP.class)
    ArrayList<ItemLWP> itemInGlobalLWPList = new ArrayList<>();
}

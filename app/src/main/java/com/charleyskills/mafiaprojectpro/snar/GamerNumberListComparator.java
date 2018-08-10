package com.charleyskills.mafiaprojectpro.snar;

import com.charleyskills.mafiaprojectpro.greendesk.Gamer;

import java.util.Comparator;

public class GamerNumberListComparator implements Comparator<Gamer>
{
    @Override
    public int compare(Gamer gamer1, Gamer gamer2) {
        return gamer1.numberInList - gamer2.numberInList;
    }
}
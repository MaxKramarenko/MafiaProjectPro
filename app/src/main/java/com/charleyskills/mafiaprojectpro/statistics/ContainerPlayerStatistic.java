package com.charleyskills.mafiaprojectpro.statistics;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "ContainerPlayerStatistic")
public class ContainerPlayerStatistic
{
    @ElementList(required = false, entry = "ItemPlayerStatistics", inline = true, name = "ItemPlayerStatistics", type=ItemPlayerStatistics.class)
    public ArrayList<ItemPlayerStatistics> arrayPlayersStatistics = new ArrayList<>();
}
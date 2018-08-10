package com.charleyskills.mafiaprojectpro.startgame;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "ContainerGamePresetLayoutList")
public class ContainerGamePresetLayoutList
{
    @ElementList(required = false, entry = "GamePresetLayout", inline = true, name = "GamePresetLayout", type=GamePresetLayout.class)
    public ArrayList<GamePresetLayout> arrayGamePresetLayouts = new ArrayList<>();
}
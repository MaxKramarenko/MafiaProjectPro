package com.charleyskills.mafiaprojectpro.greendesk;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "ContainerGamerItems")
public class ContainerGamerItems
{
    @Attribute(name="cardend")
    int cardend = 0;

    @Attribute(name="global_pressed_back")
    boolean global_pressed_back = true;

    @ElementList(required = false, entry = "Gamer", inline = true, name = "gamerArrayList", type=Gamer.class)
    public ArrayList<Gamer> gamerArrayList = new ArrayList<>();
}
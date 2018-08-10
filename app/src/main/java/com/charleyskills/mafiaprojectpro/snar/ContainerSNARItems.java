package com.charleyskills.mafiaprojectpro.snar;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "ContainerSNARItems")
public class ContainerSNARItems
{
    @ElementList(required = false, entry = "ItemSNAR", inline = true, name = "ArrayListOfItemSNAR", type=ItemSNAR.class)
    public ArrayList<ItemSNAR> array_ItemSNAR = new ArrayList<>();
}

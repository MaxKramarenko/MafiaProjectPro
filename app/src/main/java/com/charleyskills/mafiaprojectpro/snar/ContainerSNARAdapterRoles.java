package com.charleyskills.mafiaprojectpro.snar;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "ContainerSNARAdapterRoles")
public class ContainerSNARAdapterRoles
{
    @ElementList(required = false, entry = "array_roles", inline = true, name = "array_roles", type=String.class)
    public ArrayList<String> array_roles = new ArrayList<>();
}

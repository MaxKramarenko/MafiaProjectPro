package com.charleyskills.mafiaprojectpro.startgame;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name="ContainerItemInAnotherRoleList")
class ContainerItemInAnotherRoleList
{
    @ElementList(required = false, entry = "ItemInAnotherRoleList", inline = true, name = "ItemInAnotherRoleList", type=ItemInAnotherRoleList.class)
    ArrayList<ItemInAnotherRoleList> arrayItemAnotherRoles = new ArrayList<>();
}

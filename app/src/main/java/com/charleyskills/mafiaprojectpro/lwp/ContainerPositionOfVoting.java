package com.charleyskills.mafiaprojectpro.lwp;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="ContainerPositionOfVoting")
public class ContainerPositionOfVoting
{
    @ElementList(required = false, entry = "PositionsInVoteList", inline = true, name = "ArrayListOfPositionsInVoteList", type=Integer.class)
    ArrayListOfPositionsInVoteList positionsInVoteList = new ArrayListOfPositionsInVoteList();
}

package com.charleyskills.mafiaprojectpro.theme;

import com.charleyskills.mafiaprojectpro.MafiaProjectProApp;
import com.charleyskills.mafiaprojectpro.R;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name="ContainerThemeResources")
public class ContainerThemeResources
{
    boolean isChanged = false;

    public int currentGreenDeskDrawableBackground = R.drawable.pic_background_1;
    @Attribute(name = "name_Background")
    String name_currentGreenDeskDrawableBackground;

    void setCurrentGreenDeskDrawableBackground(int currentGreenDeskDrawableBackground)
    {
        this.currentGreenDeskDrawableBackground = currentGreenDeskDrawableBackground;
        name_currentGreenDeskDrawableBackground = MafiaProjectProApp.getContext().getResources().getResourceName(currentGreenDeskDrawableBackground);
    }

    public int currentGreenDeskDrawableDoctor = R.drawable.pic_card_doctor_1;
    @Attribute(name = "name_Doctor")
    String name_currentGreenDeskDrawableDoctor;

    void setCurrentGreenDeskDrawableDoctor(int currentGreenDeskDrawableDoctor)
    {
        this.currentGreenDeskDrawableDoctor = currentGreenDeskDrawableDoctor;
        name_currentGreenDeskDrawableDoctor = MafiaProjectProApp.getContext().getResources().getResourceName(currentGreenDeskDrawableDoctor);
    }

    public int currentGreenDeskDrawableSheriff = R.drawable.pic_card_sheriff_1;
    @Attribute(name = "name_Sheriff")
    String name_currentGreenDeskDrawableSheriff;

    void setCurrentGreenDeskDrawableSheriff(int currentGreenDeskDrawableSheriff)
    {
        this.currentGreenDeskDrawableSheriff = currentGreenDeskDrawableSheriff;
        name_currentGreenDeskDrawableSheriff = MafiaProjectProApp.getContext().getResources().getResourceName(currentGreenDeskDrawableSheriff);
    }

    public int currentGreenDeskDrawableWhore = R.drawable.pic_card_whore_1;
    @Attribute(name = "name_Whore")
    String name_currentGreenDeskDrawableWhore;

    void setCurrentGreenDeskDrawableWhore(int currentGreenDeskDrawableWhore)
    {
        this.currentGreenDeskDrawableWhore = currentGreenDeskDrawableWhore;
        name_currentGreenDeskDrawableWhore = MafiaProjectProApp.getContext().getResources().getResourceName(currentGreenDeskDrawableWhore);
    }

    public int currentGreenDeskDrawableManiac = R.drawable.pic_card_maniac_1;
    @Attribute(name = "name_Maniac")
    String name_currentGreenDeskDrawableManiac;

    void setCurrentGreenDeskDrawableManiac(int currentGreenDeskDrawableManiac)
    {
        this.currentGreenDeskDrawableManiac = currentGreenDeskDrawableManiac;
        name_currentGreenDeskDrawableManiac = MafiaProjectProApp.getContext().getResources().getResourceName(currentGreenDeskDrawableManiac);
    }

    public int currentGreenDeskDrawableMafia = R.drawable.pic_card_mafia_1;
    @Attribute(name = "name_Mafia")
    String name_currentGreenDeskDrawableMafia;

    void setCurrentGreenDeskDrawableMafia(int currentGreenDeskDrawableMafia)
    {
        this.currentGreenDeskDrawableMafia = currentGreenDeskDrawableMafia;
        name_currentGreenDeskDrawableMafia = MafiaProjectProApp.getContext().getResources().getResourceName(currentGreenDeskDrawableMafia);
    }

    public int currentGreenDeskDrawableGodfather = R.drawable.pic_card_godfather_1;
    @Attribute(name = "name_Godfather")
    String name_currentGreenDeskDrawableGodfather;

    void setCurrentGreenDeskDrawableGodfather(int currentGreenDeskDrawableGodfather)
    {
        this.currentGreenDeskDrawableGodfather = currentGreenDeskDrawableGodfather;
        name_currentGreenDeskDrawableGodfather = MafiaProjectProApp.getContext().getResources().getResourceName(currentGreenDeskDrawableGodfather);
    }

    public int currentGreenDeskDrawableCivilian = R.drawable.pic_card_civilian_1;
    @Attribute(name = "name_Civilian")
    String name_currentGreenDeskDrawableCivilian;

    void setCurrentGreenDeskDrawableCivilian(int currentGreenDeskDrawableCivilian)
    {
        this.currentGreenDeskDrawableCivilian = currentGreenDeskDrawableCivilian;
        name_currentGreenDeskDrawableCivilian = MafiaProjectProApp.getContext().getResources().getResourceName(currentGreenDeskDrawableCivilian);
    }

    public int currentGreenDeskBackCard_mini_selector = R.drawable.pic_card_back_1_mini_selector;
    @Attribute(name = "name_BackCard_mini_selector")
    String name_currentGreenDeskBackCard_mini_selector;

    void setCurrentGreenDeskBackCard_mini_selector(int currentGreenDeskBackCard_mini_selector)
    {
        this.currentGreenDeskBackCard_mini_selector = currentGreenDeskBackCard_mini_selector;
        name_currentGreenDeskBackCard_mini_selector = MafiaProjectProApp.getContext().getResources().getResourceName(currentGreenDeskBackCard_mini_selector);
    }

    public int currentGreenDeskBackCard_mini = R.drawable.pic_card_back_1_mini;
    @Attribute(name = "name_BackCard_mini")
    String name_currentGreenDeskBackCard_mini;

    void setCurrentGreenDeskBackCard_mini(int currentGreenDeskBackCard_mini)
    {
        this.currentGreenDeskBackCard_mini = currentGreenDeskBackCard_mini;
        name_currentGreenDeskBackCard_mini = MafiaProjectProApp.getContext().getResources().getResourceName(currentGreenDeskBackCard_mini);
    }

    public int currentGreenDeskBackCard = R.drawable.pic_card_back_1;
    @Attribute(name = "name_BackCard")
    String name_currentGreenDeskBackCard;

    void setCurrentGreenDeskBackCard(int currentGreenDeskBackCard)
    {
        this.currentGreenDeskBackCard = currentGreenDeskBackCard;
        name_currentGreenDeskBackCard = MafiaProjectProApp.getContext().getResources().getResourceName(currentGreenDeskBackCard);
    }

    public ContainerThemeResources()
    {
        setCurrentGreenDeskDrawableBackground(currentGreenDeskDrawableBackground);
        setCurrentGreenDeskDrawableDoctor(currentGreenDeskDrawableDoctor);
        setCurrentGreenDeskDrawableSheriff(currentGreenDeskDrawableSheriff);
        setCurrentGreenDeskDrawableWhore(currentGreenDeskDrawableWhore);
        setCurrentGreenDeskDrawableManiac(currentGreenDeskDrawableManiac);
        setCurrentGreenDeskDrawableMafia(currentGreenDeskDrawableMafia);
        setCurrentGreenDeskDrawableGodfather(currentGreenDeskDrawableGodfather);
        setCurrentGreenDeskDrawableCivilian(currentGreenDeskDrawableCivilian);
        setCurrentGreenDeskBackCard_mini_selector(currentGreenDeskBackCard_mini_selector);
        setCurrentGreenDeskBackCard_mini(currentGreenDeskBackCard_mini);
        setCurrentGreenDeskBackCard(currentGreenDeskBackCard);
    }

    ContainerThemeResources(
            @Attribute(name = "name_Background") String name_currentGreenDeskDrawableBackground,
            @Attribute(name = "name_Doctor") String name_currentGreenDeskDrawableDoctor,
            @Attribute(name = "name_Sheriff") String name_currentGreenDeskDrawableSheriff,
            @Attribute(name = "name_Whore") String name_currentGreenDeskDrawableWhore,
            @Attribute(name = "name_Maniac") String name_currentGreenDeskDrawableManiac,
            @Attribute(name = "name_Mafia") String name_currentGreenDeskDrawableMafia,
            @Attribute(name = "name_Godfather") String name_currentGreenDeskDrawableGodfather,
            @Attribute(name = "name_Civilian") String name_currentGreenDeskDrawableCivilian,
            @Attribute(name = "name_BackCard_mini_selector") String name_currentGreenDeskBackCard_mini_selector,
            @Attribute(name = "name_BackCard_mini") String name_currentGreenDeskBackCard_mini,
            @Attribute(name = "name_BackCard") String name_currentGreenDeskBackCard)
    {
        setCurrentGreenDeskDrawableBackground(MafiaProjectProApp.getContext().getResources().getIdentifier(name_currentGreenDeskDrawableBackground, "drawable", "com.charleyskills.mafiaprojectpro"));
        setCurrentGreenDeskDrawableDoctor(MafiaProjectProApp.getContext().getResources().getIdentifier(name_currentGreenDeskDrawableDoctor, "drawable", "com.charleyskills.mafiaprojectpro"));
        setCurrentGreenDeskDrawableSheriff(MafiaProjectProApp.getContext().getResources().getIdentifier(name_currentGreenDeskDrawableSheriff, "drawable", "com.charleyskills.mafiaprojectpro"));
        setCurrentGreenDeskDrawableWhore(MafiaProjectProApp.getContext().getResources().getIdentifier(name_currentGreenDeskDrawableWhore, "drawable", "com.charleyskills.mafiaprojectpro"));
        setCurrentGreenDeskDrawableManiac(MafiaProjectProApp.getContext().getResources().getIdentifier(name_currentGreenDeskDrawableManiac, "drawable", "com.charleyskills.mafiaprojectpro"));
        setCurrentGreenDeskDrawableMafia(MafiaProjectProApp.getContext().getResources().getIdentifier(name_currentGreenDeskDrawableMafia, "drawable", "com.charleyskills.mafiaprojectpro"));
        setCurrentGreenDeskDrawableGodfather(MafiaProjectProApp.getContext().getResources().getIdentifier(name_currentGreenDeskDrawableGodfather, "drawable", "com.charleyskills.mafiaprojectpro"));
        setCurrentGreenDeskDrawableCivilian(MafiaProjectProApp.getContext().getResources().getIdentifier(name_currentGreenDeskDrawableCivilian, "drawable", "com.charleyskills.mafiaprojectpro"));
        setCurrentGreenDeskBackCard_mini_selector(MafiaProjectProApp.getContext().getResources().getIdentifier(name_currentGreenDeskBackCard_mini_selector, "drawable", "com.charleyskills.mafiaprojectpro"));
        setCurrentGreenDeskBackCard_mini(MafiaProjectProApp.getContext().getResources().getIdentifier(name_currentGreenDeskBackCard_mini, "drawable", "com.charleyskills.mafiaprojectpro"));
        setCurrentGreenDeskBackCard(MafiaProjectProApp.getContext().getResources().getIdentifier(name_currentGreenDeskBackCard, "drawable", "com.charleyskills.mafiaprojectpro"));
    }
}
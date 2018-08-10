package com.charleyskills.mafiaprojectpro.theme;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.charleyskills.mafiaprojectpro.AppSettings;
import com.charleyskills.mafiaprojectpro.HomeActivity;
import com.charleyskills.mafiaprojectpro.IO;
import com.charleyskills.mafiaprojectpro.MafiaProjectProApp;
import com.charleyskills.mafiaprojectpro.R;

public class ThemeActivity extends Activity
{
    int delay = 700;
    final int widthmargin = 20;

    TextView theme_title;

//    Context ThemeActivityContext;
    private Intent toHomeActivityIntent;

    private Animation mFadeIn_back_Animation, mFadeOut_back_Animation;
    private ImageView currentCardBackBlack;
    private ImageView currentCardBackDone;

    private FrameLayout framelayout_card_back_1;
    private ImageView imageview_card_back_1;
    private ImageView select_card_back_1;

    private FrameLayout framelayout_card_back_2;
    private ImageView imageview_card_back_2;
    private ImageView select_card_back_2;

    private FrameLayout framelayout_card_back_3;
    private ImageView imageview_card_back_3;
    private ImageView select_card_back_3;

    private FrameLayout framelayout_card_back_4;
    private ImageView imageview_card_back_4;
    private ImageView select_card_back_4;

    private FrameLayout framelayout_card_back_5;
    private ImageView imageview_card_back_5;
    private ImageView select_card_back_5;

    private FrameLayout framelayout_card_back_6;
    private ImageView imageview_card_back_6;
    private ImageView select_card_back_6;

    private FrameLayout framelayout_card_back_7;
    private ImageView imageview_card_back_7;
    private ImageView select_card_back_7;

    private FrameLayout framelayout_card_back_8;
    private ImageView imageview_card_back_8;
    private ImageView select_card_back_8;

    private HorizontalScrollView themes_card_back_scrollview;
    private LinearLayout themes_card_back_linearlayout;

    ///////////////////////////////////////

    private Animation mFadeIn_doctor_Animation, mFadeOut_doctor_Animation;
    private ImageView currentCardDoctorBlack;
    private ImageView currentCardDoctorDone;

    private FrameLayout framelayout_card_doctor_1;
    TextView textview_card_doctor_1;
    private ImageView imageview_card_doctor_1;
    private ImageView select_card_doctor_1;

    private FrameLayout framelayout_card_doctor_2;
    TextView textview_card_doctor_2;
    private ImageView imageview_card_doctor_2;
    private ImageView select_card_doctor_2;

    private HorizontalScrollView themes_card_doctor_scrollview;
    private LinearLayout themes_card_doctor_linearlayout;

    ///////////////////////////////////////

    private Animation mFadeIn_whore_Animation, mFadeOut_whore_Animation;
    private ImageView currentCardWhoreBlack;
    private ImageView currentCardWhoreDone;

    private FrameLayout framelayout_card_whore_1;
    TextView textview_card_whore_1;
    private ImageView imageview_card_whore_1;
    private ImageView select_card_whore_1;

    private FrameLayout framelayout_card_whore_2;
    TextView textview_card_whore_2;
    private ImageView imageview_card_whore_2;
    private ImageView select_card_whore_2;

    private HorizontalScrollView themes_card_whore_scrollview;
    private LinearLayout themes_card_whore_linearlayout;

    ///////////////////////////////////////

    private Animation mFadeIn_maniac_Animation, mFadeOut_maniac_Animation;
    private ImageView currentCardManiacBlack;
    private ImageView currentCardManiacDone;

    private FrameLayout framelayout_card_maniac_1;
    TextView textview_card_maniac_1;
    private ImageView imageview_card_maniac_1;
    private ImageView select_card_maniac_1;

    private FrameLayout framelayout_card_maniac_2;
    TextView textview_card_maniac_2;
    private ImageView imageview_card_maniac_2;
    private ImageView select_card_maniac_2;

    private HorizontalScrollView themes_card_maniac_scrollview;
    private LinearLayout themes_card_maniac_linearlayout;

    ///////////////////////////////////////

    private Animation mFadeIn_sheriff_Animation, mFadeOut_sheriff_Animation;
    private ImageView currentCardSheriffBlack;
    private ImageView currentCardSheriffDone;

    private FrameLayout framelayout_card_sheriff_1;
    TextView textview_card_sheriff_1;
    private ImageView imageview_card_sheriff_1;
    private ImageView select_card_sheriff_1;

    private FrameLayout framelayout_card_sheriff_2;
    TextView textview_card_sheriff_2;
    private ImageView imageview_card_sheriff_2;
    private ImageView select_card_sheriff_2;

    private FrameLayout framelayout_card_sheriff_3;
    TextView textview_card_sheriff_3;
    private ImageView imageview_card_sheriff_3;
    private ImageView select_card_sheriff_3;

    private HorizontalScrollView themes_card_sheriff_scrollview;
    private LinearLayout themes_card_sheriff_linearlayout;

    ///////////////////////////////////////

    private Animation mFadeIn_godfather_Animation, mFadeOut_godfather_Animation;
    private ImageView currentCardGodfatherBlack;
    private ImageView currentCardGodfatherDone;

    private FrameLayout framelayout_card_godfather_1;
    TextView textview_card_godfather_1;
    private ImageView imageview_card_godfather_1;
    private ImageView select_card_godfather_1;

    private FrameLayout framelayout_card_godfather_2;
    TextView textview_card_godfather_2;
    private ImageView imageview_card_godfather_2;
    private ImageView select_card_godfather_2;

    private HorizontalScrollView themes_card_godfather_scrollview;
    private LinearLayout themes_card_godfather_linearlayout;

    ///////////////////////////////////////

    private Animation mFadeIn_mafia_Animation, mFadeOut_mafia_Animation;
    private ImageView currentCardMafiaBlack;
    private ImageView currentCardMafiaDone;

    private FrameLayout framelayout_card_mafia_1;
    TextView textview_card_mafia_1;
    private ImageView imageview_card_mafia_1;
    private ImageView select_card_mafia_1;

    private FrameLayout framelayout_card_mafia_2;
    TextView textview_card_mafia_2;
    private ImageView imageview_card_mafia_2;
    private ImageView select_card_mafia_2;

    private FrameLayout framelayout_card_mafia_3;
    TextView textview_card_mafia_3;
    private ImageView imageview_card_mafia_3;
    private ImageView select_card_mafia_3;

    private HorizontalScrollView themes_card_mafia_scrollview;
    private LinearLayout themes_card_mafia_linearlayout;

    ///////////////////////////////////////

    private Animation mFadeIn_civilian_Animation, mFadeOut_civilian_Animation;
    private ImageView currentCardCivilianBlack;
    private ImageView currentCardCivilianDone;

    private FrameLayout framelayout_card_civilian_1;
    TextView textview_card_civilian_1;
    private ImageView imageview_card_civilian_1;
    private ImageView select_card_civilian_1;

    private FrameLayout framelayout_card_civilian_2;
    TextView textview_card_civilian_2;
    private ImageView imageview_card_civilian_2;
    private ImageView select_card_civilian_2;

    private HorizontalScrollView themes_card_civilian_scrollview;
    private LinearLayout themes_card_civilian_linearlayout;

    ///////////////////////////////////////

    private Animation mFadeIn_greendesk_Animation, mFadeOut_greendesk_Animation;
    private ImageView currentGreendeskBlack;
    private ImageView currentGreendeskDone;

    private FrameLayout framelayout_greendesk_1;
    private ImageView imageview_greendesk_1;
    private ImageView select_greendesk_1;

    private FrameLayout framelayout_greendesk_2;
    private ImageView imageview_greendesk_2;
    private ImageView select_greendesk_2;

    private FrameLayout framelayout_greendesk_3;
    private ImageView imageview_greendesk_3;
    private ImageView select_greendesk_3;

    private FrameLayout framelayout_greendesk_4;
    private ImageView imageview_greendesk_4;
    private ImageView select_greendesk_4;

    private FrameLayout framelayout_greendesk_5;
    private ImageView imageview_greendesk_5;
    private ImageView select_greendesk_5;

    private HorizontalScrollView themes_greendesk_scrollview;
    private LinearLayout themes_greendesk_linearlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

//        ThemeActivityContext = this;

        overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);
        toHomeActivityIntent = new Intent(this, HomeActivity.class);

        framelayout_card_back_1 = (FrameLayout) findViewById(R.id.framelayout_card_back_1);
        imageview_card_back_1 = (ImageView) findViewById(R.id.imageview_card_back_1);
        select_card_back_1 = (ImageView) findViewById(R.id.select_card_back_1);

        framelayout_card_back_2 = (FrameLayout) findViewById(R.id.framelayout_card_back_2);
        imageview_card_back_2 = (ImageView) findViewById(R.id.imageview_card_back_2);
        select_card_back_2 = (ImageView) findViewById(R.id.select_card_back_2);

        framelayout_card_back_3 = (FrameLayout) findViewById(R.id.framelayout_card_back_3);
        imageview_card_back_3 = (ImageView) findViewById(R.id.imageview_card_back_3);
        select_card_back_3 = (ImageView) findViewById(R.id.select_card_back_3);

        framelayout_card_back_4 = (FrameLayout) findViewById(R.id.framelayout_card_back_4);
        imageview_card_back_4 = (ImageView) findViewById(R.id.imageview_card_back_4);
        select_card_back_4 = (ImageView) findViewById(R.id.select_card_back_4);

        framelayout_card_back_5 = (FrameLayout) findViewById(R.id.framelayout_card_back_5);
        imageview_card_back_5 = (ImageView) findViewById(R.id.imageview_card_back_5);
        select_card_back_5 = (ImageView) findViewById(R.id.select_card_back_5);

        framelayout_card_back_6 = (FrameLayout) findViewById(R.id.framelayout_card_back_6);
        imageview_card_back_6 = (ImageView) findViewById(R.id.imageview_card_back_6);
        select_card_back_6 = (ImageView) findViewById(R.id.select_card_back_6);

        framelayout_card_back_7 = (FrameLayout) findViewById(R.id.framelayout_card_back_7);
        imageview_card_back_7 = (ImageView) findViewById(R.id.imageview_card_back_7);
        select_card_back_7 = (ImageView) findViewById(R.id.select_card_back_7);

        framelayout_card_back_8 = (FrameLayout) findViewById(R.id.framelayout_card_back_8);
        imageview_card_back_8 = (ImageView) findViewById(R.id.imageview_card_back_8);
        select_card_back_8 = (ImageView) findViewById(R.id.select_card_back_8);

        themes_card_back_scrollview = (HorizontalScrollView) findViewById(R.id.themes_card_back_scrollview);
        themes_card_back_linearlayout = (LinearLayout) findViewById(R.id.themes_card_back_linearlayout);
        themes_card_back_linearlayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                themes_card_back_linearlayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if(AppSettings.getDisplayWidth() < themes_card_back_linearlayout.getWidth())
                {
                    LinearLayout.LayoutParams lp_1 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_1.setMargins((framelayout_card_back_1.getWidth() / 2) - AppSettings.getDP(widthmargin), 0, 0, 0);
                    framelayout_card_back_1.setLayoutParams(lp_1);

                    LinearLayout.LayoutParams lp_2 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_2.setMargins(0, 0, (framelayout_card_back_8.getWidth() / 2) - AppSettings.getDP(widthmargin), 0);
                    framelayout_card_back_8.setLayoutParams(lp_2);
                }
            }
        });

        ///////////////////////////////////////

        framelayout_card_doctor_1 = (FrameLayout) findViewById(R.id.framelayout_card_doctor_1);
        textview_card_doctor_1 = (TextView) findViewById(R.id.textview_card_doctor_1) ;
        imageview_card_doctor_1 = (ImageView) findViewById(R.id.imageview_card_doctor_1);
        select_card_doctor_1 = (ImageView) findViewById(R.id.select_card_doctor_1);

        framelayout_card_doctor_2 = (FrameLayout) findViewById(R.id.framelayout_card_doctor_2);
        textview_card_doctor_2 = (TextView) findViewById(R.id.textview_card_doctor_2) ;
        imageview_card_doctor_2 = (ImageView) findViewById(R.id.imageview_card_doctor_2);
        select_card_doctor_2 = (ImageView) findViewById(R.id.select_card_doctor_2);

        textview_card_doctor_1.setTypeface(Typeface.create("serif", Typeface.BOLD));
        textview_card_doctor_2.setTypeface(Typeface.create("serif", Typeface.BOLD));

        themes_card_doctor_scrollview = (HorizontalScrollView) findViewById(R.id.themes_card_doctor_scrollview);
        themes_card_doctor_linearlayout = (LinearLayout) findViewById(R.id.themes_card_doctor_linearlayout);
        themes_card_doctor_linearlayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                themes_card_doctor_linearlayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if(AppSettings.getDisplayWidth() < themes_card_doctor_linearlayout.getWidth())
                {
                    LinearLayout.LayoutParams lp_1 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_1.setMargins((framelayout_card_doctor_1.getWidth() / 2) - AppSettings.getDP(widthmargin), 0, AppSettings.getDP(15), 0);
                    framelayout_card_doctor_1.setLayoutParams(lp_1);

                    LinearLayout.LayoutParams lp_2 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_2.setMargins(0, 0, (framelayout_card_doctor_2.getWidth() / 2) - AppSettings.getDP(widthmargin), 0);
                    framelayout_card_doctor_2.setLayoutParams(lp_2);
                }
            }
        });

        ///////////////////////////////////////

        framelayout_card_whore_1 = (FrameLayout) findViewById(R.id.framelayout_card_whore_1);
        textview_card_whore_1 = (TextView) findViewById(R.id.textview_card_whore_1) ;
        imageview_card_whore_1 = (ImageView) findViewById(R.id.imageview_card_whore_1);
        select_card_whore_1 = (ImageView) findViewById(R.id.select_card_whore_1);

        framelayout_card_whore_2 = (FrameLayout) findViewById(R.id.framelayout_card_whore_2);
        textview_card_whore_2 = (TextView) findViewById(R.id.textview_card_whore_2) ;
        imageview_card_whore_2 = (ImageView) findViewById(R.id.imageview_card_whore_2);
        select_card_whore_2 = (ImageView) findViewById(R.id.select_card_whore_2);

        textview_card_whore_1.setTypeface(Typeface.create("serif", Typeface.BOLD));
        textview_card_whore_2.setTypeface(Typeface.create("serif", Typeface.BOLD));

        themes_card_whore_scrollview = (HorizontalScrollView) findViewById(R.id.themes_card_whore_scrollview);
        themes_card_whore_linearlayout = (LinearLayout) findViewById(R.id.themes_card_whore_linearlayout);
        themes_card_whore_linearlayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                themes_card_whore_linearlayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if(AppSettings.getDisplayWidth() < themes_card_whore_linearlayout.getWidth())
                {
                    LinearLayout.LayoutParams lp_1 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_1.setMargins((framelayout_card_whore_1.getWidth() / 2) - AppSettings.getDP(widthmargin), 0, AppSettings.getDP(15), 0);
                    framelayout_card_whore_1.setLayoutParams(lp_1);

                    LinearLayout.LayoutParams lp_2 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_2.setMargins(0, 0, (framelayout_card_whore_2.getWidth() / 2) - AppSettings.getDP(widthmargin), 0);
                    framelayout_card_whore_2.setLayoutParams(lp_2);
                }
            }
        });

        ///////////////////////////////////////

        framelayout_card_maniac_1 = (FrameLayout) findViewById(R.id.framelayout_card_maniac_1);
        textview_card_maniac_1 = (TextView) findViewById(R.id.textview_card_maniac_1) ;
        imageview_card_maniac_1 = (ImageView) findViewById(R.id.imageview_card_maniac_1);
        select_card_maniac_1 = (ImageView) findViewById(R.id.select_card_maniac_1);

        framelayout_card_maniac_2 = (FrameLayout) findViewById(R.id.framelayout_card_maniac_2);
        textview_card_maniac_2 = (TextView) findViewById(R.id.textview_card_maniac_2) ;
        imageview_card_maniac_2 = (ImageView) findViewById(R.id.imageview_card_maniac_2);
        select_card_maniac_2 = (ImageView) findViewById(R.id.select_card_maniac_2);

        textview_card_maniac_1.setTypeface(Typeface.create("serif", Typeface.BOLD));
        textview_card_maniac_2.setTypeface(Typeface.create("serif", Typeface.BOLD));

        themes_card_maniac_scrollview = (HorizontalScrollView) findViewById(R.id.themes_card_maniac_scrollview);
        themes_card_maniac_linearlayout = (LinearLayout) findViewById(R.id.themes_card_maniac_linearlayout);
        themes_card_maniac_linearlayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                themes_card_maniac_linearlayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if(AppSettings.getDisplayWidth() < themes_card_maniac_linearlayout.getWidth())
                {
                    LinearLayout.LayoutParams lp_1 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_1.setMargins((framelayout_card_maniac_1.getWidth() / 2) - AppSettings.getDP(widthmargin), 0, AppSettings.getDP(15), 0);
                    framelayout_card_maniac_1.setLayoutParams(lp_1);

                    LinearLayout.LayoutParams lp_2 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_2.setMargins(0, 0, (framelayout_card_maniac_2.getWidth() / 2) - AppSettings.getDP(widthmargin), 0);
                    framelayout_card_maniac_2.setLayoutParams(lp_2);
                }
            }
        });

        ///////////////////////////////////////

        framelayout_card_sheriff_1 = (FrameLayout) findViewById(R.id.framelayout_card_sheriff_1);
        textview_card_sheriff_1 = (TextView) findViewById(R.id.textview_card_sheriff_1) ;
        imageview_card_sheriff_1 = (ImageView) findViewById(R.id.imageview_card_sheriff_1);
        select_card_sheriff_1 = (ImageView) findViewById(R.id.select_card_sheriff_1);

        framelayout_card_sheriff_2 = (FrameLayout) findViewById(R.id.framelayout_card_sheriff_2);
        textview_card_sheriff_2 = (TextView) findViewById(R.id.textview_card_sheriff_2) ;
        imageview_card_sheriff_2 = (ImageView) findViewById(R.id.imageview_card_sheriff_2);
        select_card_sheriff_2 = (ImageView) findViewById(R.id.select_card_sheriff_2);

        framelayout_card_sheriff_3 = (FrameLayout) findViewById(R.id.framelayout_card_sheriff_3);
        textview_card_sheriff_3 = (TextView) findViewById(R.id.textview_card_sheriff_3) ;
        imageview_card_sheriff_3 = (ImageView) findViewById(R.id.imageview_card_sheriff_3);
        select_card_sheriff_3 = (ImageView) findViewById(R.id.select_card_sheriff_3);

        textview_card_sheriff_1.setTypeface(Typeface.create("serif", Typeface.BOLD));
        textview_card_sheriff_2.setTypeface(Typeface.create("serif", Typeface.BOLD));
        textview_card_sheriff_3.setTypeface(Typeface.create("serif", Typeface.BOLD));

        themes_card_sheriff_scrollview = (HorizontalScrollView) findViewById(R.id.themes_card_sheriff_scrollview);
        themes_card_sheriff_linearlayout = (LinearLayout) findViewById(R.id.themes_card_sheriff_linearlayout);
        themes_card_sheriff_linearlayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                themes_card_sheriff_linearlayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if(AppSettings.getDisplayWidth() < themes_card_sheriff_linearlayout.getWidth())
                {
                    LinearLayout.LayoutParams lp_1 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_1.setMargins((framelayout_card_sheriff_1.getWidth() / 2) - AppSettings.getDP(widthmargin), 0, 0, 0);
                    framelayout_card_sheriff_1.setLayoutParams(lp_1);

                    LinearLayout.LayoutParams lp_3 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_3.setMargins(0, 0, (framelayout_card_sheriff_3.getWidth() / 2) - AppSettings.getDP(widthmargin), 0);
                    framelayout_card_sheriff_3.setLayoutParams(lp_3);
                }
            }
        });

        ///////////////////////////////////////

        framelayout_card_godfather_1 = (FrameLayout) findViewById(R.id.framelayout_card_godfather_1);
        textview_card_godfather_1 = (TextView) findViewById(R.id.textview_card_godfather_1) ;
        imageview_card_godfather_1 = (ImageView) findViewById(R.id.imageview_card_godfather_1);
        select_card_godfather_1 = (ImageView) findViewById(R.id.select_card_godfather_1);

        framelayout_card_godfather_2 = (FrameLayout) findViewById(R.id.framelayout_card_godfather_2);
        textview_card_godfather_2 = (TextView) findViewById(R.id.textview_card_godfather_2) ;
        imageview_card_godfather_2 = (ImageView) findViewById(R.id.imageview_card_godfather_2);
        select_card_godfather_2 = (ImageView) findViewById(R.id.select_card_godfather_2);

        textview_card_godfather_1.setTypeface(Typeface.create("serif", Typeface.BOLD));
        textview_card_godfather_2.setTypeface(Typeface.create("serif", Typeface.BOLD));

        themes_card_godfather_scrollview = (HorizontalScrollView) findViewById(R.id.themes_card_godfather_scrollview);
        themes_card_godfather_linearlayout = (LinearLayout) findViewById(R.id.themes_card_godfather_linearlayout);
        themes_card_godfather_linearlayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                themes_card_godfather_linearlayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if(AppSettings.getDisplayWidth() < themes_card_godfather_linearlayout.getWidth())
                {
                    LinearLayout.LayoutParams lp_1 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_1.setMargins((framelayout_card_godfather_1.getWidth() / 2) - AppSettings.getDP(widthmargin), 0, AppSettings.getDP(15), 0);
                    framelayout_card_godfather_1.setLayoutParams(lp_1);

                    LinearLayout.LayoutParams lp_2 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_2.setMargins(0, 0, (framelayout_card_godfather_2.getWidth() / 2) - AppSettings.getDP(widthmargin), 0);
                    framelayout_card_godfather_2.setLayoutParams(lp_2);
                }
            }
        });

        ///////////////////////////////////////

        framelayout_card_mafia_1 = (FrameLayout) findViewById(R.id.framelayout_card_mafia_1);
        textview_card_mafia_1 = (TextView) findViewById(R.id.textview_card_mafia_1) ;
        imageview_card_mafia_1 = (ImageView) findViewById(R.id.imageview_card_mafia_1);
        select_card_mafia_1 = (ImageView) findViewById(R.id.select_card_mafia_1);

        framelayout_card_mafia_2 = (FrameLayout) findViewById(R.id.framelayout_card_mafia_2);
        textview_card_mafia_2 = (TextView) findViewById(R.id.textview_card_mafia_2) ;
        imageview_card_mafia_2 = (ImageView) findViewById(R.id.imageview_card_mafia_2);
        select_card_mafia_2 = (ImageView) findViewById(R.id.select_card_mafia_2);

        framelayout_card_mafia_3 = (FrameLayout) findViewById(R.id.framelayout_card_mafia_3);
        textview_card_mafia_3 = (TextView) findViewById(R.id.textview_card_mafia_3) ;
        imageview_card_mafia_3 = (ImageView) findViewById(R.id.imageview_card_mafia_3);
        select_card_mafia_3 = (ImageView) findViewById(R.id.select_card_mafia_3);

        textview_card_mafia_1.setTypeface(Typeface.create("serif", Typeface.BOLD));
        textview_card_mafia_2.setTypeface(Typeface.create("serif", Typeface.BOLD));
        textview_card_mafia_3.setTypeface(Typeface.create("serif", Typeface.BOLD));

        themes_card_mafia_scrollview = (HorizontalScrollView) findViewById(R.id.themes_card_mafia_scrollview);
        themes_card_mafia_linearlayout = (LinearLayout) findViewById(R.id.themes_card_mafia_linearlayout);
        themes_card_mafia_linearlayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                themes_card_mafia_linearlayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if(AppSettings.getDisplayWidth() < themes_card_mafia_linearlayout.getWidth())
                {
                    LinearLayout.LayoutParams lp_1 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_1.setMargins((framelayout_card_mafia_1.getWidth() / 2) - AppSettings.getDP(widthmargin), 0, 0, 0);
                    framelayout_card_mafia_1.setLayoutParams(lp_1);

                    LinearLayout.LayoutParams lp_3 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_3.setMargins(0, 0, (framelayout_card_mafia_3.getWidth() / 2) - AppSettings.getDP(widthmargin), 0);
                    framelayout_card_mafia_3.setLayoutParams(lp_3);
                }
            }
        });

        ///////////////////////////////////////

        framelayout_card_civilian_1 = (FrameLayout) findViewById(R.id.framelayout_card_civilian_1);
        textview_card_civilian_1 = (TextView) findViewById(R.id.textview_card_civilian_1) ;
        imageview_card_civilian_1 = (ImageView) findViewById(R.id.imageview_card_civilian_1);
        select_card_civilian_1 = (ImageView) findViewById(R.id.select_card_civilian_1);

        framelayout_card_civilian_2 = (FrameLayout) findViewById(R.id.framelayout_card_civilian_2);
        textview_card_civilian_2 = (TextView) findViewById(R.id.textview_card_civilian_2) ;
        imageview_card_civilian_2 = (ImageView) findViewById(R.id.imageview_card_civilian_2);
        select_card_civilian_2 = (ImageView) findViewById(R.id.select_card_civilian_2);

        textview_card_civilian_1.setTypeface(Typeface.create("serif", Typeface.BOLD));
        textview_card_civilian_2.setTypeface(Typeface.create("serif", Typeface.BOLD));

        themes_card_civilian_scrollview = (HorizontalScrollView) findViewById(R.id.themes_card_civilian_scrollview);
        themes_card_civilian_linearlayout = (LinearLayout) findViewById(R.id.themes_card_civilian_linearlayout);
        themes_card_civilian_linearlayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                themes_card_civilian_linearlayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if(AppSettings.getDisplayWidth() < themes_card_civilian_linearlayout.getWidth())
                {
                    LinearLayout.LayoutParams lp_1 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_1.setMargins((framelayout_card_civilian_1.getWidth() / 2) - AppSettings.getDP(widthmargin), 0, AppSettings.getDP(15), 0);
                    framelayout_card_civilian_1.setLayoutParams(lp_1);

                    LinearLayout.LayoutParams lp_2 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(290));
                    lp_2.setMargins(0, 0, (framelayout_card_civilian_2.getWidth() / 2) - AppSettings.getDP(widthmargin), 0);
                    framelayout_card_civilian_2.setLayoutParams(lp_2);
                }
            }
        });

        ///////////////////////////////////////

        framelayout_greendesk_1 = (FrameLayout) findViewById(R.id.framelayout_greendesk_1);
        imageview_greendesk_1 = (ImageView) findViewById(R.id.imageview_greendesk_1);
        select_greendesk_1 = (ImageView) findViewById(R.id.select_greendesk_1);

        framelayout_greendesk_2 = (FrameLayout) findViewById(R.id.framelayout_greendesk_2);
        imageview_greendesk_2 = (ImageView) findViewById(R.id.imageview_greendesk_2);
        select_greendesk_2 = (ImageView) findViewById(R.id.select_greendesk_2);

        framelayout_greendesk_3 = (FrameLayout) findViewById(R.id.framelayout_greendesk_3);
        imageview_greendesk_3 = (ImageView) findViewById(R.id.imageview_greendesk_3);
        select_greendesk_3 = (ImageView) findViewById(R.id.select_greendesk_3);

        framelayout_greendesk_4 = (FrameLayout) findViewById(R.id.framelayout_greendesk_4);
        imageview_greendesk_4 = (ImageView) findViewById(R.id.imageview_greendesk_4);
        select_greendesk_4 = (ImageView) findViewById(R.id.select_greendesk_4);

        framelayout_greendesk_5 = (FrameLayout) findViewById(R.id.framelayout_greendesk_5);
        imageview_greendesk_5 = (ImageView) findViewById(R.id.imageview_greendesk_5);
        select_greendesk_5 = (ImageView) findViewById(R.id.select_greendesk_5);

        themes_greendesk_scrollview = (HorizontalScrollView) findViewById(R.id.themes_greendesk_scrollview);
        themes_greendesk_linearlayout = (LinearLayout) findViewById(R.id.themes_greendesk_linearlayout);
        themes_greendesk_linearlayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout()
            {
                themes_greendesk_linearlayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if(AppSettings.getDisplayWidth() < themes_greendesk_linearlayout.getWidth())
                {
                    LinearLayout.LayoutParams lp_1 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(300));
                    lp_1.setMargins((framelayout_greendesk_1.getWidth() / 2) - AppSettings.getDP(widthmargin), 0, 0, 0);
                    framelayout_greendesk_1.setLayoutParams(lp_1);

                    LinearLayout.LayoutParams lp_5 = new LinearLayout.LayoutParams(AppSettings.getDP(200), AppSettings.getDP(300));
                    lp_5.setMargins(0, 0, (framelayout_greendesk_5.getWidth() / 2) - AppSettings.getDP(widthmargin), 0);
                    framelayout_greendesk_5.setLayoutParams(lp_5);
                }
            }
        });

        mFadeIn_back_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_in);
        mFadeIn_back_Animation.setFillAfter(true);

        mFadeOut_back_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_out);
        mFadeOut_back_Animation.setFillAfter(true);
        mFadeOut_back_Animation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                currentCardBackBlack.setVisibility(View.INVISIBLE);
                currentCardBackDone.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        mFadeIn_doctor_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_in);
        mFadeIn_doctor_Animation.setFillAfter(true);

        mFadeOut_doctor_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_out);
        mFadeOut_doctor_Animation.setFillAfter(true);
        mFadeOut_doctor_Animation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                currentCardDoctorBlack.setVisibility(View.INVISIBLE);
                currentCardDoctorDone.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        mFadeIn_whore_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_in);
        mFadeIn_whore_Animation.setFillAfter(true);

        mFadeOut_whore_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_out);
        mFadeOut_whore_Animation.setFillAfter(true);
        mFadeOut_whore_Animation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                currentCardWhoreBlack.setVisibility(View.INVISIBLE);
                currentCardWhoreDone.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        mFadeIn_maniac_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_in);
        mFadeIn_maniac_Animation.setFillAfter(true);

        mFadeOut_maniac_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_out);
        mFadeOut_maniac_Animation.setFillAfter(true);
        mFadeOut_maniac_Animation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                currentCardManiacBlack.setVisibility(View.INVISIBLE);
                currentCardManiacDone.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        mFadeIn_sheriff_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_in);
        mFadeIn_sheriff_Animation.setFillAfter(true);

        mFadeOut_sheriff_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_out);
        mFadeOut_sheriff_Animation.setFillAfter(true);
        mFadeOut_sheriff_Animation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                currentCardSheriffBlack.setVisibility(View.INVISIBLE);
                currentCardSheriffDone.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        mFadeIn_godfather_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_in);
        mFadeIn_godfather_Animation.setFillAfter(true);

        mFadeOut_godfather_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_out);
        mFadeOut_godfather_Animation.setFillAfter(true);
        mFadeOut_godfather_Animation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                currentCardGodfatherBlack.setVisibility(View.INVISIBLE);
                currentCardGodfatherDone.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        mFadeIn_mafia_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_in);
        mFadeIn_mafia_Animation.setFillAfter(true);

        mFadeOut_mafia_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_out);
        mFadeOut_mafia_Animation.setFillAfter(true);
        mFadeOut_mafia_Animation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                currentCardMafiaBlack.setVisibility(View.INVISIBLE);
                currentCardMafiaDone.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        mFadeIn_civilian_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_in);
        mFadeIn_civilian_Animation.setFillAfter(true);

        mFadeOut_civilian_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_out);
        mFadeOut_civilian_Animation.setFillAfter(true);
        mFadeOut_civilian_Animation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                currentCardCivilianBlack.setVisibility(View.INVISIBLE);
                currentCardCivilianDone.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        mFadeIn_greendesk_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_in);
        mFadeIn_greendesk_Animation.setFillAfter(true);

        mFadeOut_greendesk_Animation = AnimationUtils.loadAnimation(this, R.anim.custom_fade_out);
        mFadeOut_greendesk_Animation.setFillAfter(true);
        mFadeOut_greendesk_Animation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                currentGreendeskBlack.setVisibility(View.INVISIBLE);
                currentGreendeskDone.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });

        ////////////////////////////////////////////////////

        switch (AppSettings.getThemeResources().currentGreenDeskBackCard)
        {
            case R.drawable.pic_card_back_1:
                select_card_back_1.setVisibility(View.VISIBLE);
                imageview_card_back_1.setVisibility(View.VISIBLE);
                currentCardBackBlack = imageview_card_back_1;
                currentCardBackDone = select_card_back_1;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_1, delay);
                break;

            case R.drawable.pic_card_back_2:
                select_card_back_2.setVisibility(View.VISIBLE);
                imageview_card_back_2.setVisibility(View.VISIBLE);
                currentCardBackBlack = imageview_card_back_2;
                currentCardBackDone = select_card_back_2;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_2, delay);
                break;

            case R.drawable.pic_card_back_3:
                select_card_back_3.setVisibility(View.VISIBLE);
                imageview_card_back_3.setVisibility(View.VISIBLE);
                currentCardBackBlack = imageview_card_back_3;
                currentCardBackDone = select_card_back_3;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_3, delay);
                break;

            case R.drawable.pic_card_back_4:
                select_card_back_4.setVisibility(View.VISIBLE);
                imageview_card_back_4.setVisibility(View.VISIBLE);
                currentCardBackBlack = imageview_card_back_4;
                currentCardBackDone = select_card_back_4;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_4, delay);
                break;

            case R.drawable.pic_card_back_5:
                select_card_back_5.setVisibility(View.VISIBLE);
                imageview_card_back_5.setVisibility(View.VISIBLE);
                currentCardBackBlack = imageview_card_back_5;
                currentCardBackDone = select_card_back_5;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_5, delay);
                break;

            case R.drawable.pic_card_back_6:
                select_card_back_6.setVisibility(View.VISIBLE);
                imageview_card_back_6.setVisibility(View.VISIBLE);
                currentCardBackBlack = imageview_card_back_6;
                currentCardBackDone = select_card_back_6;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_6, delay);
                break;

            case R.drawable.pic_card_back_7:
                select_card_back_7.setVisibility(View.VISIBLE);
                imageview_card_back_7.setVisibility(View.VISIBLE);
                currentCardBackBlack = imageview_card_back_7;
                currentCardBackDone = select_card_back_7;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_7, delay);
                break;

            case R.drawable.pic_card_back_8:
                select_card_back_8.setVisibility(View.VISIBLE);
                imageview_card_back_8.setVisibility(View.VISIBLE);
                currentCardBackBlack = imageview_card_back_8;
                currentCardBackDone = select_card_back_8;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_8, delay);
                break;
        }

        framelayout_card_back_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskBackCard == R.drawable.pic_card_back_1)
                    return;

                select_card_back_1.setVisibility(View.VISIBLE);
                select_card_back_1.startAnimation(mFadeIn_back_Animation);
                imageview_card_back_1.setVisibility(View.VISIBLE);
                imageview_card_back_1.startAnimation(mFadeIn_back_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskBackCard(R.drawable.pic_card_back_1);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini(R.drawable.pic_card_back_1_mini);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini_selector(R.drawable.pic_card_back_1_mini_selector);

                currentCardBackBlack.startAnimation(mFadeOut_back_Animation);
                currentCardBackDone.startAnimation(mFadeOut_back_Animation);

                currentCardBackBlack = imageview_card_back_1;
                currentCardBackDone = select_card_back_1;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_1);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_back_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskBackCard == R.drawable.pic_card_back_2)
                    return;

                select_card_back_2.setVisibility(View.VISIBLE);
                select_card_back_2.startAnimation(mFadeIn_back_Animation);
                imageview_card_back_2.setVisibility(View.VISIBLE);
                imageview_card_back_2.startAnimation(mFadeIn_back_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskBackCard(R.drawable.pic_card_back_2);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini(R.drawable.pic_card_back_2_mini);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini_selector(R.drawable.pic_card_back_2_mini_selector);

                currentCardBackBlack.startAnimation(mFadeOut_back_Animation);
                currentCardBackDone.startAnimation(mFadeOut_back_Animation);

                currentCardBackBlack = imageview_card_back_2;
                currentCardBackDone = select_card_back_2;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_2);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_back_3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskBackCard == R.drawable.pic_card_back_3)
                    return;

                select_card_back_3.setVisibility(View.VISIBLE);
                select_card_back_3.startAnimation(mFadeIn_back_Animation);
                imageview_card_back_3.setVisibility(View.VISIBLE);
                imageview_card_back_3.startAnimation(mFadeIn_back_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskBackCard(R.drawable.pic_card_back_3);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini(R.drawable.pic_card_back_3_mini);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini_selector(R.drawable.pic_card_back_3_mini_selector);

                currentCardBackBlack.startAnimation(mFadeOut_back_Animation);
                currentCardBackDone.startAnimation(mFadeOut_back_Animation);

                currentCardBackBlack = imageview_card_back_3;
                currentCardBackDone = select_card_back_3;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_3);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_back_4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskBackCard == R.drawable.pic_card_back_4)
                    return;

                select_card_back_4.setVisibility(View.VISIBLE);
                select_card_back_4.startAnimation(mFadeIn_back_Animation);
                imageview_card_back_4.setVisibility(View.VISIBLE);
                imageview_card_back_4.startAnimation(mFadeIn_back_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskBackCard(R.drawable.pic_card_back_4);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini(R.drawable.pic_card_back_4_mini);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini_selector(R.drawable.pic_card_back_4_mini_selector);

                currentCardBackBlack.startAnimation(mFadeOut_back_Animation);
                currentCardBackDone.startAnimation(mFadeOut_back_Animation);

                currentCardBackBlack = imageview_card_back_4;
                currentCardBackDone = select_card_back_4;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_4);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_back_5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskBackCard == R.drawable.pic_card_back_5)
                    return;

                select_card_back_5.setVisibility(View.VISIBLE);
                select_card_back_5.startAnimation(mFadeIn_back_Animation);
                imageview_card_back_5.setVisibility(View.VISIBLE);
                imageview_card_back_5.startAnimation(mFadeIn_back_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskBackCard(R.drawable.pic_card_back_5);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini(R.drawable.pic_card_back_5_mini);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini_selector(R.drawable.pic_card_back_5_mini_selector);

                currentCardBackBlack.startAnimation(mFadeOut_back_Animation);
                currentCardBackDone.startAnimation(mFadeOut_back_Animation);

                currentCardBackBlack = imageview_card_back_5;
                currentCardBackDone = select_card_back_5;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_5);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_back_6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskBackCard == R.drawable.pic_card_back_6)
                    return;

                select_card_back_6.setVisibility(View.VISIBLE);
                select_card_back_6.startAnimation(mFadeIn_back_Animation);
                imageview_card_back_6.setVisibility(View.VISIBLE);
                imageview_card_back_6.startAnimation(mFadeIn_back_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskBackCard(R.drawable.pic_card_back_6);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini(R.drawable.pic_card_back_6_mini);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini_selector(R.drawable.pic_card_back_6_mini_selector);

                currentCardBackBlack.startAnimation(mFadeOut_back_Animation);
                currentCardBackDone.startAnimation(mFadeOut_back_Animation);

                currentCardBackBlack = imageview_card_back_6;
                currentCardBackDone = select_card_back_6;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_6);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_back_7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskBackCard == R.drawable.pic_card_back_7)
                    return;

                select_card_back_7.setVisibility(View.VISIBLE);
                select_card_back_7.startAnimation(mFadeIn_back_Animation);
                imageview_card_back_7.setVisibility(View.VISIBLE);
                imageview_card_back_7.startAnimation(mFadeIn_back_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskBackCard(R.drawable.pic_card_back_7);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini(R.drawable.pic_card_back_7_mini);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini_selector(R.drawable.pic_card_back_7_mini_selector);

                currentCardBackBlack.startAnimation(mFadeOut_back_Animation);
                currentCardBackDone.startAnimation(mFadeOut_back_Animation);

                currentCardBackBlack = imageview_card_back_7;
                currentCardBackDone = select_card_back_7;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_7);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_back_8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskBackCard == R.drawable.pic_card_back_8)
                    return;

                select_card_back_8.setVisibility(View.VISIBLE);
                select_card_back_8.startAnimation(mFadeIn_back_Animation);
                imageview_card_back_8.setVisibility(View.VISIBLE);
                imageview_card_back_8.startAnimation(mFadeIn_back_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskBackCard(R.drawable.pic_card_back_8);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini(R.drawable.pic_card_back_8_mini);
                AppSettings.getThemeResources().setCurrentGreenDeskBackCard_mini_selector(R.drawable.pic_card_back_8_mini_selector);

                currentCardBackBlack.startAnimation(mFadeOut_back_Animation);
                currentCardBackDone.startAnimation(mFadeOut_back_Animation);

                currentCardBackBlack = imageview_card_back_8;
                currentCardBackDone = select_card_back_8;

                focusOnView(themes_card_back_scrollview, framelayout_card_back_8);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        switch (AppSettings.getThemeResources().currentGreenDeskDrawableDoctor)
        {
            case R.drawable.pic_card_doctor_1:
                select_card_doctor_1.setVisibility(View.VISIBLE);
                imageview_card_doctor_1.setVisibility(View.VISIBLE);
                currentCardDoctorBlack = imageview_card_doctor_1;
                currentCardDoctorDone = select_card_doctor_1;

                focusOnView(themes_card_doctor_scrollview, framelayout_card_doctor_1, delay);
                break;

            case R.drawable.pic_card_doctor_2:
                select_card_doctor_2.setVisibility(View.VISIBLE);
                imageview_card_doctor_2.setVisibility(View.VISIBLE);
                currentCardDoctorBlack = imageview_card_doctor_2;
                currentCardDoctorDone = select_card_doctor_2;

                focusOnView(themes_card_doctor_scrollview, framelayout_card_doctor_2, delay);
                break;
        }

        framelayout_card_doctor_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableDoctor == R.drawable.pic_card_doctor_1)
                    return;

                select_card_doctor_1.setVisibility(View.VISIBLE);
                select_card_doctor_1.startAnimation(mFadeIn_doctor_Animation);
                imageview_card_doctor_1.setVisibility(View.VISIBLE);
                imageview_card_doctor_1.startAnimation(mFadeIn_doctor_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableDoctor(R.drawable.pic_card_doctor_1);

                currentCardDoctorBlack.startAnimation(mFadeOut_doctor_Animation);
                currentCardDoctorDone.startAnimation(mFadeOut_doctor_Animation);

                currentCardDoctorBlack = imageview_card_doctor_1;
                currentCardDoctorDone = select_card_doctor_1;

                focusOnView(themes_card_doctor_scrollview, framelayout_card_doctor_1);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_doctor_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableDoctor == R.drawable.pic_card_doctor_2)
                    return;

                select_card_doctor_2.setVisibility(View.VISIBLE);
                select_card_doctor_2.startAnimation(mFadeIn_doctor_Animation);
                imageview_card_doctor_2.setVisibility(View.VISIBLE);
                imageview_card_doctor_2.startAnimation(mFadeIn_doctor_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableDoctor(R.drawable.pic_card_doctor_2);

                currentCardDoctorBlack.startAnimation(mFadeOut_doctor_Animation);
                currentCardDoctorDone.startAnimation(mFadeOut_doctor_Animation);

                currentCardDoctorBlack = imageview_card_doctor_2;
                currentCardDoctorDone = select_card_doctor_2;

                focusOnView(themes_card_doctor_scrollview, framelayout_card_doctor_2);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        switch (AppSettings.getThemeResources().currentGreenDeskDrawableWhore)
        {
            case R.drawable.pic_card_whore_1:
                select_card_whore_1.setVisibility(View.VISIBLE);
                imageview_card_whore_1.setVisibility(View.VISIBLE);
                currentCardWhoreBlack = imageview_card_whore_1;
                currentCardWhoreDone = select_card_whore_1;

                focusOnView(themes_card_whore_scrollview, framelayout_card_whore_1, delay);
                break;

            case R.drawable.pic_card_whore_2:
                select_card_whore_2.setVisibility(View.VISIBLE);
                imageview_card_whore_2.setVisibility(View.VISIBLE);
                currentCardWhoreBlack = imageview_card_whore_2;
                currentCardWhoreDone = select_card_whore_2;

                focusOnView(themes_card_whore_scrollview, framelayout_card_whore_2, delay);
                break;
        }

        framelayout_card_whore_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableWhore == R.drawable.pic_card_whore_1)
                    return;

                select_card_whore_1.setVisibility(View.VISIBLE);
                select_card_whore_1.startAnimation(mFadeIn_whore_Animation);
                imageview_card_whore_1.setVisibility(View.VISIBLE);
                imageview_card_whore_1.startAnimation(mFadeIn_whore_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableWhore(R.drawable.pic_card_whore_1);

                currentCardWhoreBlack.startAnimation(mFadeOut_whore_Animation);
                currentCardWhoreDone.startAnimation(mFadeOut_whore_Animation);

                currentCardWhoreBlack = imageview_card_whore_1;
                currentCardWhoreDone = select_card_whore_1;

                focusOnView(themes_card_whore_scrollview, framelayout_card_whore_1);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_whore_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableWhore == R.drawable.pic_card_whore_2)
                    return;

                select_card_whore_2.setVisibility(View.VISIBLE);
                select_card_whore_2.startAnimation(mFadeIn_whore_Animation);
                imageview_card_whore_2.setVisibility(View.VISIBLE);
                imageview_card_whore_2.startAnimation(mFadeIn_whore_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableWhore(R.drawable.pic_card_whore_2);

                currentCardWhoreBlack.startAnimation(mFadeOut_whore_Animation);
                currentCardWhoreDone.startAnimation(mFadeOut_whore_Animation);

                currentCardWhoreBlack = imageview_card_whore_2;
                currentCardWhoreDone = select_card_whore_2;

                focusOnView(themes_card_whore_scrollview, framelayout_card_whore_2);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        switch (AppSettings.getThemeResources().currentGreenDeskDrawableManiac)
        {
            case R.drawable.pic_card_maniac_1:
                select_card_maniac_1.setVisibility(View.VISIBLE);
                imageview_card_maniac_1.setVisibility(View.VISIBLE);
                currentCardManiacBlack = imageview_card_maniac_1;
                currentCardManiacDone = select_card_maniac_1;

                focusOnView(themes_card_maniac_scrollview, framelayout_card_maniac_1, delay);
                break;

            case R.drawable.pic_card_maniac_2:
                select_card_maniac_2.setVisibility(View.VISIBLE);
                imageview_card_maniac_2.setVisibility(View.VISIBLE);
                currentCardManiacBlack = imageview_card_maniac_2;
                currentCardManiacDone = select_card_maniac_2;

                focusOnView(themes_card_maniac_scrollview, framelayout_card_maniac_2, delay);
                break;
        }

        framelayout_card_maniac_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableManiac == R.drawable.pic_card_maniac_1)
                    return;

                select_card_maniac_1.setVisibility(View.VISIBLE);
                select_card_maniac_1.startAnimation(mFadeIn_maniac_Animation);
                imageview_card_maniac_1.setVisibility(View.VISIBLE);
                imageview_card_maniac_1.startAnimation(mFadeIn_maniac_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableManiac(R.drawable.pic_card_maniac_1);

                currentCardManiacBlack.startAnimation(mFadeOut_maniac_Animation);
                currentCardManiacDone.startAnimation(mFadeOut_maniac_Animation);

                currentCardManiacBlack = imageview_card_maniac_1;
                currentCardManiacDone = select_card_maniac_1;

                focusOnView(themes_card_maniac_scrollview, framelayout_card_maniac_1);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_maniac_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableManiac == R.drawable.pic_card_maniac_2)
                    return;

                select_card_maniac_2.setVisibility(View.VISIBLE);
                select_card_maniac_2.startAnimation(mFadeIn_maniac_Animation);
                imageview_card_maniac_2.setVisibility(View.VISIBLE);
                imageview_card_maniac_2.startAnimation(mFadeIn_maniac_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableManiac(R.drawable.pic_card_maniac_2);

                currentCardManiacBlack.startAnimation(mFadeOut_maniac_Animation);
                currentCardManiacDone.startAnimation(mFadeOut_maniac_Animation);

                currentCardManiacBlack = imageview_card_maniac_2;
                currentCardManiacDone = select_card_maniac_2;

                focusOnView(themes_card_maniac_scrollview, framelayout_card_maniac_2);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        switch (AppSettings.getThemeResources().currentGreenDeskDrawableSheriff)
        {
            case R.drawable.pic_card_sheriff_1:
                select_card_sheriff_1.setVisibility(View.VISIBLE);
                imageview_card_sheriff_1.setVisibility(View.VISIBLE);
                currentCardSheriffBlack = imageview_card_sheriff_1;
                currentCardSheriffDone = select_card_sheriff_1;

                focusOnView(themes_card_sheriff_scrollview, framelayout_card_sheriff_1, delay);
                break;

            case R.drawable.pic_card_sheriff_2:
                select_card_sheriff_2.setVisibility(View.VISIBLE);
                imageview_card_sheriff_2.setVisibility(View.VISIBLE);
                currentCardSheriffBlack = imageview_card_sheriff_2;
                currentCardSheriffDone = select_card_sheriff_2;

                focusOnView(themes_card_sheriff_scrollview, framelayout_card_sheriff_2, delay);
                break;

            case R.drawable.pic_card_sheriff_3:
                select_card_sheriff_3.setVisibility(View.VISIBLE);
                imageview_card_sheriff_3.setVisibility(View.VISIBLE);
                currentCardSheriffBlack = imageview_card_sheriff_3;
                currentCardSheriffDone = select_card_sheriff_3;

                focusOnView(themes_card_sheriff_scrollview, framelayout_card_sheriff_3, delay);
                break;
        }

        framelayout_card_sheriff_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableSheriff == R.drawable.pic_card_sheriff_1)
                    return;

                select_card_sheriff_1.setVisibility(View.VISIBLE);
                select_card_sheriff_1.startAnimation(mFadeIn_sheriff_Animation);
                imageview_card_sheriff_1.setVisibility(View.VISIBLE);
                imageview_card_sheriff_1.startAnimation(mFadeIn_sheriff_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableSheriff(R.drawable.pic_card_sheriff_1);

                currentCardSheriffBlack.startAnimation(mFadeOut_sheriff_Animation);
                currentCardSheriffDone.startAnimation(mFadeOut_sheriff_Animation);

                currentCardSheriffBlack = imageview_card_sheriff_1;
                currentCardSheriffDone = select_card_sheriff_1;

                focusOnView(themes_card_sheriff_scrollview, framelayout_card_sheriff_1);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_sheriff_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableSheriff == R.drawable.pic_card_sheriff_2)
                    return;

                select_card_sheriff_2.setVisibility(View.VISIBLE);
                select_card_sheriff_2.startAnimation(mFadeIn_sheriff_Animation);
                imageview_card_sheriff_2.setVisibility(View.VISIBLE);
                imageview_card_sheriff_2.startAnimation(mFadeIn_sheriff_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableSheriff(R.drawable.pic_card_sheriff_2);

                currentCardSheriffBlack.startAnimation(mFadeOut_sheriff_Animation);
                currentCardSheriffDone.startAnimation(mFadeOut_sheriff_Animation);

                currentCardSheriffBlack = imageview_card_sheriff_2;
                currentCardSheriffDone = select_card_sheriff_2;

                focusOnView(themes_card_sheriff_scrollview, framelayout_card_sheriff_2);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_sheriff_3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableSheriff == R.drawable.pic_card_sheriff_3)
                    return;

                select_card_sheriff_3.setVisibility(View.VISIBLE);
                select_card_sheriff_3.startAnimation(mFadeIn_sheriff_Animation);
                imageview_card_sheriff_3.setVisibility(View.VISIBLE);
                imageview_card_sheriff_3.startAnimation(mFadeIn_sheriff_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableSheriff(R.drawable.pic_card_sheriff_3);

                currentCardSheriffBlack.startAnimation(mFadeOut_sheriff_Animation);
                currentCardSheriffDone.startAnimation(mFadeOut_sheriff_Animation);

                currentCardSheriffBlack = imageview_card_sheriff_3;
                currentCardSheriffDone = select_card_sheriff_3;

                focusOnView(themes_card_sheriff_scrollview, framelayout_card_sheriff_3);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        switch (AppSettings.getThemeResources().currentGreenDeskDrawableGodfather)
        {
            case R.drawable.pic_card_godfather_1:
                select_card_godfather_1.setVisibility(View.VISIBLE);
                imageview_card_godfather_1.setVisibility(View.VISIBLE);
                currentCardGodfatherBlack = imageview_card_godfather_1;
                currentCardGodfatherDone = select_card_godfather_1;

                focusOnView(themes_card_godfather_scrollview, framelayout_card_godfather_1, delay);
                break;

            case R.drawable.pic_card_godfather_2:
                select_card_godfather_2.setVisibility(View.VISIBLE);
                imageview_card_godfather_2.setVisibility(View.VISIBLE);
                currentCardGodfatherBlack = imageview_card_godfather_2;
                currentCardGodfatherDone = select_card_godfather_2;

                focusOnView(themes_card_godfather_scrollview, framelayout_card_godfather_2, delay);
                break;
        }

        framelayout_card_godfather_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableGodfather == R.drawable.pic_card_godfather_1)
                    return;

                select_card_godfather_1.setVisibility(View.VISIBLE);
                select_card_godfather_1.startAnimation(mFadeIn_godfather_Animation);
                imageview_card_godfather_1.setVisibility(View.VISIBLE);
                imageview_card_godfather_1.startAnimation(mFadeIn_godfather_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableGodfather(R.drawable.pic_card_godfather_1);

                currentCardGodfatherBlack.startAnimation(mFadeOut_godfather_Animation);
                currentCardGodfatherDone.startAnimation(mFadeOut_godfather_Animation);

                currentCardGodfatherBlack = imageview_card_godfather_1;
                currentCardGodfatherDone = select_card_godfather_1;

                focusOnView(themes_card_godfather_scrollview, framelayout_card_godfather_1);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_godfather_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableGodfather == R.drawable.pic_card_godfather_2)
                    return;

                select_card_godfather_2.setVisibility(View.VISIBLE);
                select_card_godfather_2.startAnimation(mFadeIn_godfather_Animation);
                imageview_card_godfather_2.setVisibility(View.VISIBLE);
                imageview_card_godfather_2.startAnimation(mFadeIn_godfather_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableGodfather(R.drawable.pic_card_godfather_2);

                currentCardGodfatherBlack.startAnimation(mFadeOut_godfather_Animation);
                currentCardGodfatherDone.startAnimation(mFadeOut_godfather_Animation);

                currentCardGodfatherBlack = imageview_card_godfather_2;
                currentCardGodfatherDone = select_card_godfather_2;

                focusOnView(themes_card_godfather_scrollview, framelayout_card_godfather_2);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        switch (AppSettings.getThemeResources().currentGreenDeskDrawableMafia)
        {
            case R.drawable.pic_card_mafia_1:
                select_card_mafia_1.setVisibility(View.VISIBLE);
                imageview_card_mafia_1.setVisibility(View.VISIBLE);
                currentCardMafiaBlack = imageview_card_mafia_1;
                currentCardMafiaDone = select_card_mafia_1;

                focusOnView(themes_card_mafia_scrollview, framelayout_card_mafia_1, delay);
                break;

            case R.drawable.pic_card_mafia_2:
                select_card_mafia_2.setVisibility(View.VISIBLE);
                imageview_card_mafia_2.setVisibility(View.VISIBLE);
                currentCardMafiaBlack = imageview_card_mafia_2;
                currentCardMafiaDone = select_card_mafia_2;

                focusOnView(themes_card_mafia_scrollview, framelayout_card_mafia_2, delay);
                break;

            case R.drawable.pic_card_mafia_3:
                select_card_mafia_3.setVisibility(View.VISIBLE);
                imageview_card_mafia_3.setVisibility(View.VISIBLE);
                currentCardMafiaBlack = imageview_card_mafia_3;
                currentCardMafiaDone = select_card_mafia_3;

                focusOnView(themes_card_mafia_scrollview, framelayout_card_mafia_3, delay);
                break;
        }

        framelayout_card_mafia_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableMafia == R.drawable.pic_card_mafia_1)
                    return;

                select_card_mafia_1.setVisibility(View.VISIBLE);
                select_card_mafia_1.startAnimation(mFadeIn_mafia_Animation);
                imageview_card_mafia_1.setVisibility(View.VISIBLE);
                imageview_card_mafia_1.startAnimation(mFadeIn_mafia_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableMafia(R.drawable.pic_card_mafia_1);

                currentCardMafiaBlack.startAnimation(mFadeOut_mafia_Animation);
                currentCardMafiaDone.startAnimation(mFadeOut_mafia_Animation);

                currentCardMafiaBlack = imageview_card_mafia_1;
                currentCardMafiaDone = select_card_mafia_1;

                focusOnView(themes_card_mafia_scrollview, framelayout_card_mafia_1);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_mafia_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableMafia == R.drawable.pic_card_mafia_2)
                    return;

                select_card_mafia_2.setVisibility(View.VISIBLE);
                select_card_mafia_2.startAnimation(mFadeIn_mafia_Animation);
                imageview_card_mafia_2.setVisibility(View.VISIBLE);
                imageview_card_mafia_2.startAnimation(mFadeIn_mafia_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableMafia(R.drawable.pic_card_mafia_2);

                currentCardMafiaBlack.startAnimation(mFadeOut_mafia_Animation);
                currentCardMafiaDone.startAnimation(mFadeOut_mafia_Animation);

                currentCardMafiaBlack = imageview_card_mafia_2;
                currentCardMafiaDone = select_card_mafia_2;

                focusOnView(themes_card_mafia_scrollview, framelayout_card_mafia_2);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_mafia_3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableMafia == R.drawable.pic_card_mafia_3)
                    return;

                select_card_mafia_3.setVisibility(View.VISIBLE);
                select_card_mafia_3.startAnimation(mFadeIn_mafia_Animation);
                imageview_card_mafia_3.setVisibility(View.VISIBLE);
                imageview_card_mafia_3.startAnimation(mFadeIn_mafia_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableMafia(R.drawable.pic_card_mafia_3);

                currentCardMafiaBlack.startAnimation(mFadeOut_mafia_Animation);
                currentCardMafiaDone.startAnimation(mFadeOut_mafia_Animation);

                currentCardMafiaBlack = imageview_card_mafia_3;
                currentCardMafiaDone = select_card_mafia_3;

                focusOnView(themes_card_mafia_scrollview, framelayout_card_mafia_3);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        switch (AppSettings.getThemeResources().currentGreenDeskDrawableCivilian)
        {
            case R.drawable.pic_card_civilian_1:
                select_card_civilian_1.setVisibility(View.VISIBLE);
                imageview_card_civilian_1.setVisibility(View.VISIBLE);
                currentCardCivilianBlack = imageview_card_civilian_1;
                currentCardCivilianDone = select_card_civilian_1;

                focusOnView(themes_card_civilian_scrollview, framelayout_card_civilian_1, delay);
                break;

            case R.drawable.pic_card_civilian_2:
                select_card_civilian_2.setVisibility(View.VISIBLE);
                imageview_card_civilian_2.setVisibility(View.VISIBLE);
                currentCardCivilianBlack = imageview_card_civilian_2;
                currentCardCivilianDone = select_card_civilian_2;

                focusOnView(themes_card_civilian_scrollview, framelayout_card_civilian_2, delay);
                break;
        }

        framelayout_card_civilian_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableCivilian == R.drawable.pic_card_civilian_1)
                    return;

                select_card_civilian_1.setVisibility(View.VISIBLE);
                select_card_civilian_1.startAnimation(mFadeIn_civilian_Animation);
                imageview_card_civilian_1.setVisibility(View.VISIBLE);
                imageview_card_civilian_1.startAnimation(mFadeIn_civilian_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableCivilian(R.drawable.pic_card_civilian_1);

                currentCardCivilianBlack.startAnimation(mFadeOut_civilian_Animation);
                currentCardCivilianDone.startAnimation(mFadeOut_civilian_Animation);

                currentCardCivilianBlack = imageview_card_civilian_1;
                currentCardCivilianDone = select_card_civilian_1;

                focusOnView(themes_card_civilian_scrollview, framelayout_card_civilian_1);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_card_civilian_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableCivilian == R.drawable.pic_card_civilian_2)
                    return;

                select_card_civilian_2.setVisibility(View.VISIBLE);
                select_card_civilian_2.startAnimation(mFadeIn_civilian_Animation);
                imageview_card_civilian_2.setVisibility(View.VISIBLE);
                imageview_card_civilian_2.startAnimation(mFadeIn_civilian_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableCivilian(R.drawable.pic_card_civilian_2);

                currentCardCivilianBlack.startAnimation(mFadeOut_civilian_Animation);
                currentCardCivilianDone.startAnimation(mFadeOut_civilian_Animation);

                currentCardCivilianBlack = imageview_card_civilian_2;
                currentCardCivilianDone = select_card_civilian_2;

                focusOnView(themes_card_civilian_scrollview, framelayout_card_civilian_2);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        switch (AppSettings.getThemeResources().currentGreenDeskDrawableBackground)
        {
            case R.drawable.pic_background_1:
                select_greendesk_1.setVisibility(View.VISIBLE);
                imageview_greendesk_1.setVisibility(View.VISIBLE);
                currentGreendeskBlack = imageview_greendesk_1;
                currentGreendeskDone = select_greendesk_1;

                focusOnView(themes_greendesk_scrollview, framelayout_greendesk_1, delay);
                break;

            case R.drawable.pic_background_2:
                select_greendesk_2.setVisibility(View.VISIBLE);
                imageview_greendesk_2.setVisibility(View.VISIBLE);
                currentGreendeskBlack = imageview_greendesk_2;
                currentGreendeskDone = select_greendesk_2;

                focusOnView(themes_greendesk_scrollview, framelayout_greendesk_2, delay);
                break;

            case R.drawable.pic_background_3:
                select_greendesk_3.setVisibility(View.VISIBLE);
                imageview_greendesk_3.setVisibility(View.VISIBLE);
                currentGreendeskBlack = imageview_greendesk_3;
                currentGreendeskDone = select_greendesk_3;

                focusOnView(themes_greendesk_scrollview, framelayout_greendesk_3, delay);
                break;

            case R.drawable.pic_background_4:
                select_greendesk_4.setVisibility(View.VISIBLE);
                imageview_greendesk_4.setVisibility(View.VISIBLE);
                currentGreendeskBlack = imageview_greendesk_4;
                currentGreendeskDone = select_greendesk_4;

                focusOnView(themes_greendesk_scrollview, framelayout_greendesk_4, delay);
                break;

            case R.drawable.pic_background_5:
                select_greendesk_5.setVisibility(View.VISIBLE);
                imageview_greendesk_5.setVisibility(View.VISIBLE);
                currentGreendeskBlack = imageview_greendesk_5;
                currentGreendeskDone = select_greendesk_5;

                focusOnView(themes_greendesk_scrollview, framelayout_greendesk_5, delay);
                break;
        }

        framelayout_greendesk_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableBackground == R.drawable.pic_background_1)
                    return;

                select_greendesk_1.setVisibility(View.VISIBLE);
                select_greendesk_1.startAnimation(mFadeIn_greendesk_Animation);
                imageview_greendesk_1.setVisibility(View.VISIBLE);
                imageview_greendesk_1.startAnimation(mFadeIn_greendesk_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableBackground(R.drawable.pic_background_1);

                currentGreendeskBlack.startAnimation(mFadeOut_greendesk_Animation);
                currentGreendeskDone.startAnimation(mFadeOut_greendesk_Animation);

                currentGreendeskBlack = imageview_greendesk_1;
                currentGreendeskDone = select_greendesk_1;

                focusOnView(themes_greendesk_scrollview, framelayout_greendesk_1);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_greendesk_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableBackground == R.drawable.pic_background_2)
                    return;

                select_greendesk_2.setVisibility(View.VISIBLE);
                select_greendesk_2.startAnimation(mFadeIn_greendesk_Animation);
                imageview_greendesk_2.setVisibility(View.VISIBLE);
                imageview_greendesk_2.startAnimation(mFadeIn_greendesk_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableBackground(R.drawable.pic_background_2);

                currentGreendeskBlack.startAnimation(mFadeOut_greendesk_Animation);
                currentGreendeskDone.startAnimation(mFadeOut_greendesk_Animation);

                currentGreendeskBlack = imageview_greendesk_2;
                currentGreendeskDone = select_greendesk_2;

                focusOnView(themes_greendesk_scrollview, framelayout_greendesk_2);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_greendesk_3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableBackground == R.drawable.pic_background_3)
                    return;

                select_greendesk_3.setVisibility(View.VISIBLE);
                select_greendesk_3.startAnimation(mFadeIn_greendesk_Animation);
                imageview_greendesk_3.setVisibility(View.VISIBLE);
                imageview_greendesk_3.startAnimation(mFadeIn_greendesk_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableBackground(R.drawable.pic_background_3);

                currentGreendeskBlack.startAnimation(mFadeOut_greendesk_Animation);
                currentGreendeskDone.startAnimation(mFadeOut_greendesk_Animation);

                currentGreendeskBlack = imageview_greendesk_3;
                currentGreendeskDone = select_greendesk_3;

                focusOnView(themes_greendesk_scrollview, framelayout_greendesk_3);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_greendesk_4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableBackground == R.drawable.pic_background_4)
                    return;

                select_greendesk_4.setVisibility(View.VISIBLE);
                select_greendesk_4.startAnimation(mFadeIn_greendesk_Animation);
                imageview_greendesk_4.setVisibility(View.VISIBLE);
                imageview_greendesk_4.startAnimation(mFadeIn_greendesk_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableBackground(R.drawable.pic_background_4);

                currentGreendeskBlack.startAnimation(mFadeOut_greendesk_Animation);
                currentGreendeskDone.startAnimation(mFadeOut_greendesk_Animation);

                currentGreendeskBlack = imageview_greendesk_4;
                currentGreendeskDone = select_greendesk_4;

                focusOnView(themes_greendesk_scrollview, framelayout_greendesk_4);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        framelayout_greendesk_5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(AppSettings.getThemeResources().currentGreenDeskDrawableBackground == R.drawable.pic_background_5)
                    return;

                select_greendesk_5.setVisibility(View.VISIBLE);
                select_greendesk_5.startAnimation(mFadeIn_greendesk_Animation);
                imageview_greendesk_5.setVisibility(View.VISIBLE);
                imageview_greendesk_5.startAnimation(mFadeIn_greendesk_Animation);

                AppSettings.getThemeResources().setCurrentGreenDeskDrawableBackground(R.drawable.pic_background_5);

                currentGreendeskBlack.startAnimation(mFadeOut_greendesk_Animation);
                currentGreendeskDone.startAnimation(mFadeOut_greendesk_Animation);

                currentGreendeskBlack = imageview_greendesk_5;
                currentGreendeskDone = select_greendesk_5;

                focusOnView(themes_greendesk_scrollview, framelayout_greendesk_5);

                AppSettings.getThemeResources().isChanged = true;
            }
        });

        theme_title = (TextView) findViewById(R.id.theme_title);
        theme_title.setTypeface(Typeface.create("serif", Typeface.NORMAL));
    }

    void focusOnView(final HorizontalScrollView scroll, final View view)
    {
        scroll.post(new Runnable()
        {
            @Override
            public void run()
            {
                int vLeft = view.getLeft();
                int vRight = view.getRight();
                int sWidth = scroll.getWidth();
                scroll.smoothScrollTo(((vLeft + vRight - sWidth) / 2), 0);
            }
        });
    }

    void focusOnView(final HorizontalScrollView scroll, final View view, final int delay)
    {
        scroll.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                int vLeft = view.getLeft();
                int vRight = view.getRight();
                int sWidth = scroll.getWidth();
                scroll.smoothScrollTo(((vLeft + vRight - sWidth) / 2), 0);
            }
        }, delay);
    }

    public void onBackPressed()
    {
        if(AppSettings.getThemeResources().isChanged)
        {
            IO.writeToSD(AppSettings.getThemeResources(), IO.THEMEconfig, "writeTheme");
            AppSettings.getThemeResources().isChanged = false;
        }
        startActivity(toHomeActivityIntent);
        finish();
    }

    @Override
    protected void onPause()
    {
        MafiaProjectProApp.setContext(null);
        super.onPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        MafiaProjectProApp.setContext(this);
    }
}

package com.charleyskills.mafiaprojectpro.greendesk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsoluteLayout;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.charleyskills.mafiaprojectpro.AppSettings;
import com.charleyskills.mafiaprojectpro.LoadingActivity;
import com.charleyskills.mafiaprojectpro.MafiaProjectProApp;
import com.charleyskills.mafiaprojectpro.R;
import com.charleyskills.mafiaprojectpro.lwp.LWPActivity;
import com.charleyskills.mafiaprojectpro.snar.SNARActivity;
import com.charleyskills.mafiaprojectpro.statistics.ItemPlayerStatistics;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name="Gamer")
public class Gamer
{
    @Attribute(name="nickname")
    public String nickname = "";

    @Attribute(name="role")
    public String role;

    @Attribute(name="nickname_enable")
    int nickname_enable;

    @Attribute(name="pxX")
    int pxX;

    @Attribute(name="pxY")
    int pxY;

    Animation.AnimationListener listener_animation_transferToPosition_back;

    @Attribute(name="animation_transferToPosition_back_startOffSet")
    private long animation_transferToPosition_back_startOffSet;

    @Attribute(name="index")
    private int index;

    ImageView blackImageView;

    @Attribute(name="numberInList")
    public int numberInList = 0;

    @Attribute(name="defaultNickname")
    public boolean defaultNickname;

    TextView role_background;
    private Animation animation_toAlfaZero_role;

    @Attribute(name="front_background")
    int front_background;

    ImageButton back_button;
    ImageButton front_button;
    private AnimationSet animationSet_back;
    private Animation animation_collapse;
    Animation.AnimationListener listener_animation_collapse;
    private Animation animation_expand;
    Animation.AnimationListener listener_animation_expand;
    private Animation animation_toAlfaZero;
    private Animation.AnimationListener listener_animation_toAlfaZero;
    private Animation animation_toAlfaOne_blackImageView;
    private Animation animation_toAlfaZero_blackImageView;
    private Animation animation_toBigSize_back;
    private TranslateAnimation animation_transferToCenter_back;
    private TranslateAnimation animation_transferToPosition_back;
    Animation.AnimationListener listener_animation_transferToCenter_back;

    @Attribute(name="gamerState")
    private int gamerState = GamerState.notDistributed;

    @Attribute(name="pressed_front")
    boolean pressed_front = false;

    @Attribute(name="pressed_back")
    boolean pressed_back = false;

    @Attribute(name="toCenter_fromXType")
    int toCenter_fromXType;
    @Attribute(name="toCenter_fromXValue")
    float toCenter_fromXValue;
    @Attribute(name="toCenter_toXType")
    int toCenter_toXType;
    @Attribute(name="toCenter_toXValue")
    float toCenter_toXValue;
    @Attribute(name="toCenter_fromYType")
    int toCenter_fromYType;
    @Attribute(name="toCenter_fromYValue")
    float toCenter_fromYValue;
    @Attribute(name="toCenter_toYType")
    int toCenter_toYType;
    @Attribute(name="toCenter_toYValue")
    float toCenter_toYValue;
    @Attribute(name="toPosition_fromXType")
    int toPosition_fromXType;
    @Attribute(name="toPosition_fromXValue")
    float toPosition_fromXValue;
    @Attribute(name="toPosition_toXType")
    int toPosition_toXType;
    @Attribute(name="toPosition_toXValue")
    float toPosition_toXValue;
    @Attribute(name="toPosition_fromYType")
    int toPosition_fromYType;
    @Attribute(name="toPosition_fromYValue")
    float toPosition_fromYValue;
    @Attribute(name="toPosition_toYType")
    int toPosition_toYType;
    @Attribute(name="toPosition_toYValue")
    float toPosition_toYValue;

    Gamer(int index, String role, int front_background, int pxX, int pxY,
          int toCenter_fromXType,
          float toCenter_fromXValue,
          int toCenter_toXType,
          float toCenter_toXValue,
          int toCenter_fromYType,
          float toCenter_fromYValue,
          int toCenter_toYType,
          float toCenter_toYValue,

          int toPosition_fromXType,
          float toPosition_fromXValue,
          int toPosition_toXType,
          float toPosition_toXValue,
          int toPosition_fromYType,
          float toPosition_fromYValue,
          int toPosition_toYType,
          float toPosition_toYValue,

          long animation_transferToPosition_back_startOffSet, int nickname_enable)
    {
        this.nickname_enable = nickname_enable;
        this.role = role;
        this.index = index;
        this.front_background = front_background;
        this.pxX = pxX;
        this.pxY = pxY;

        this.toCenter_fromXType = toCenter_fromXType;
        this.toCenter_fromXValue = toCenter_fromXValue;
        this.toCenter_toXType = toCenter_toXType;
        this.toCenter_toXValue = toCenter_toXValue;
        this.toCenter_fromYType = toCenter_fromYType;
        this.toCenter_fromYValue = toCenter_fromYValue;
        this.toCenter_toYType = toCenter_toYType;
        this.toCenter_toYValue = toCenter_toYValue;
        this.toPosition_fromXType = toPosition_fromXType;
        this.toPosition_fromXValue = toPosition_fromXValue;
        this.toPosition_toXType = toPosition_toXType;
        this.toPosition_toXValue = toPosition_toXValue;
        this.toPosition_fromYType = toPosition_fromYType;
        this.toPosition_fromYValue = toPosition_fromYValue;
        this.toPosition_toYType = toPosition_toYType;
        this.toPosition_toYValue = toPosition_toYValue;

        this.animation_transferToCenter_back = new TranslateAnimation(toCenter_fromXType, toCenter_fromXValue, toCenter_toXType, toCenter_toXValue, toCenter_fromYType, toCenter_fromYValue, toCenter_toYType, toCenter_toYValue);
        this.animation_transferToPosition_back = new TranslateAnimation(toPosition_fromXType, toPosition_fromXValue, toPosition_toXType, toPosition_toXValue, toPosition_fromYType, toPosition_fromYValue, toPosition_toYType, toPosition_toYValue);
        this.animation_transferToPosition_back_startOffSet = animation_transferToPosition_back_startOffSet;

        initiate();
    }

    Gamer(@Attribute(name="nickname") String nickname,
          @Attribute(name="role") String role,
          @Attribute(name="nickname_enable") int nickname_enable,
          @Attribute(name="pxX") int pxX,
          @Attribute(name="pxY") int pxY,
          @Attribute(name="animation_transferToPosition_back_startOffSet") long animation_transferToPosition_back_startOffSet,
          @Attribute(name="index") int index,
          @Attribute(name="numberInList") int numberInList,
          @Attribute(name="defaultNickname") boolean defaultNickname,
          @Attribute(name="front_background") int front_background,
          @Attribute(name="gamerState") int gamerState,
          @Attribute(name="pressed_front") boolean pressed_front,
          @Attribute(name="pressed_back") boolean pressed_back,

          @Attribute(name="toCenter_fromXType") int toCenter_fromXType,
          @Attribute(name="toCenter_fromXValue") float toCenter_fromXValue,
          @Attribute(name="toCenter_toXType") int toCenter_toXType,
          @Attribute(name="toCenter_toXValue") float toCenter_toXValue,
          @Attribute(name="toCenter_fromYType") int toCenter_fromYType,
          @Attribute(name="toCenter_fromYValue") float toCenter_fromYValue,
          @Attribute(name="toCenter_toYType") int toCenter_toYType,
          @Attribute(name="toCenter_toYValue") float toCenter_toYValue,
          @Attribute(name="toPosition_fromXType") int toPosition_fromXType,
          @Attribute(name="toPosition_fromXValue") float toPosition_fromXValue,
          @Attribute(name="toPosition_toXType") int toPosition_toXType,
          @Attribute(name="toPosition_toXValue") float toPosition_toXValue,
          @Attribute(name="toPosition_fromYType") int toPosition_fromYType,
          @Attribute(name="toPosition_fromYValue") float toPosition_fromYValue,
          @Attribute(name="toPosition_toYType") int toPosition_toYType,
          @Attribute(name="toPosition_toYValue") float toPosition_toYValue)
    {
        this.nickname = nickname;
        this.role = role;
        this.nickname_enable = nickname_enable;
        this.pxX = pxX;
        this.pxY = pxY;
        this.index = index;
        this.animation_transferToPosition_back_startOffSet = animation_transferToPosition_back_startOffSet;
        this.numberInList = numberInList;
        this.defaultNickname = defaultNickname;
        this.front_background = front_background;
        this.gamerState = gamerState;
        this.pressed_front = pressed_front;
        this.pressed_back = pressed_back;

        this.toCenter_fromXType = toCenter_fromXType;
        this.toCenter_fromXValue = toCenter_fromXValue;
        this.toCenter_toXType = toCenter_toXType;
        this.toCenter_toXValue = toCenter_toXValue;
        this.toCenter_fromYType = toCenter_fromYType;
        this.toCenter_fromYValue = toCenter_fromYValue;
        this.toCenter_toYType = toCenter_toYType;
        this.toCenter_toYValue = toCenter_toYValue;

//        this.toPosition_fromXType = toPosition_fromXType;
//        this.toPosition_fromXValue = toPosition_fromXValue;
//        this.toPosition_toXType = toPosition_toXType;
//        this.toPosition_toXValue = toPosition_toXValue;
//        this.toPosition_fromYType = toPosition_fromYType;
//        this.toPosition_fromYValue = toPosition_fromYValue;
//        this.toPosition_toYType = toPosition_toYType;
//        this.toPosition_toYValue = toPosition_toYValue;

        this.animation_transferToCenter_back = new TranslateAnimation(toCenter_fromXType, toCenter_fromXValue, toCenter_toXType, toCenter_toXValue, toCenter_fromYType, toCenter_fromYValue, toCenter_toYType, toCenter_toYValue);
        this.animation_transferToPosition_back = new TranslateAnimation(toPosition_fromXType, toPosition_fromXValue, toPosition_toXType, toPosition_toXValue, toPosition_fromYType, toPosition_fromYValue, toPosition_toYType, toPosition_toYValue);
        initiate();
    }

    private void initiate()
    {
        role_background = new TextView(MafiaProjectProApp.getContext());
        role_background.setText(AppSettings.getFullNameRole(this.role).toUpperCase());
        role_background.setTypeface(Typeface.create("serif", Typeface.BOLD));
        role_background.setGravity(Gravity.CENTER);
        role_background.setTextSize(27);
        role_background.setTextColor(Color.WHITE);
        role_background.setVisibility(View.INVISIBLE);

        blackImageView = new ImageView(MafiaProjectProApp.getContext());
        blackImageView.setVisibility(View.INVISIBLE);
        blackImageView.setBackgroundColor(Color.argb(150, 0, 0, 0));

        back_button = new ImageButton(MafiaProjectProApp.getContext());
        back_button.setBackgroundResource(AppSettings.getThemeResources().currentGreenDeskBackCard_mini_selector);
        back_button.setClickable(false);
        initialization_listeners();
        back_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (pressed_back && AppSettings.containerGamerItems.global_pressed_back)
                {
                    GreenDeskActivity.setCardPressedBackState(false);
                    GreenDeskActivity.setCardPressedFrontState(false);
                    if(gamerState != GamerState.setedNickname)
                        gamerState = GamerState.Choosed;

                    if (nickname_enable == AppSettings.NicknameInGreenDesk)
                    {
                        final EditText editText = new EditText(MafiaProjectProApp.getContext());
                        editText.setBackgroundResource(R.drawable.apptheme_edit_text_holo_dark);
                        editText.setInputType(InputType.TYPE_CLASS_TEXT);
                        editText.setFocusable(true);
                        editText.setFocusableInTouchMode(true);
                        editText.setSingleLine(true);
                        InputFilter[] filters = new InputFilter[1];
                        filters[0] = new InputFilter.LengthFilter(10);

                        editText.setFilters(filters);
                        editText.setTextColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.White));

                        Drawable x = MafiaProjectProApp.getContext().getResources().getDrawable(R.drawable.button_del);
                        x.setBounds(0, 0, x.getIntrinsicWidth(), x.getIntrinsicHeight());
                        editText.setCompoundDrawables(null, null, x, null);

                        editText.setSelectAllOnFocus(true);
                        editText.setHighlightColor(Color.DKGRAY);

                        editText.setOnTouchListener(new View.OnTouchListener()
                        {
                            @Override
                            public boolean onTouch(View v, MotionEvent event)
                            {
                                final int DRAWABLE_RIGHT = 2;

                                if (event.getAction() == MotionEvent.ACTION_DOWN)
                                {
                                    if (event.getRawX() >= (editText.getRight() - editText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                                        editText.setText("");
                                        nickname = "";
                                        defaultNickname = true;
                                        return true;
                                    }
                                }
                                return false;
                            }
                        });

                        editText.setText(String.format("%s %d", MafiaProjectProApp.getContext().getText(R.string.voting_player), AppSettings.getContainerGreenDeskState().cardend + 1));
                        AlertDialog.Builder alert = new AlertDialog.Builder(MafiaProjectProApp.getContext());

                        alert.setTitle(MafiaProjectProApp.getContext().getText(R.string.GreenDesk_SetYourNickname));

                        LinearLayout llayout = new LinearLayout(MafiaProjectProApp.getContext());
                        ImageView nameFromStat = new ImageView(MafiaProjectProApp.getContext());
                        nameFromStat.setBackgroundResource(R.drawable.button_book);
                        nameFromStat.setClickable(true);
                        nameFromStat.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View view)
                            {
                                if(AppSettings.getPlayerStatistic().size() == 0)
                                {
                                    Toast.makeText(MafiaProjectProApp.getContext(), R.string.SNAR_GreenDeskActivity_no_nicknames_in_statistics, Toast.LENGTH_SHORT).show();
                                    return;
                                }

                                GreenDeskActivity.arrayAdapter_nameSTAT.clear();
                                for(ItemPlayerStatistics itemSTAT : AppSettings.getPlayerStatistic())
                                {
                                    boolean no_contains = true;
                                    for(Gamer gamer : AppSettings.getContainerGreenDeskState().gamerArrayList)
                                    {
                                        if (editText.getText().toString().equals(itemSTAT.name) || gamer.nickname.equals(itemSTAT.name))
                                        {
                                            no_contains = false;
                                            break;
                                        }
                                    }
                                    if(no_contains)
                                    {
                                        GreenDeskActivity.arrayAdapter_nameSTAT.add(itemSTAT.name);
                                    }
                                }

                                if(GreenDeskActivity.arrayAdapter_nameSTAT.getCount() == 0)
                                {
                                    Toast.makeText(MafiaProjectProApp.getContext(), R.string.SNAR_GreenDeskActivity_all_nicknames_used, Toast.LENGTH_SHORT).show();
                                    return;
                                }

                                GreenDeskActivity.alertDialog_nameFromStat.setAdapter(GreenDeskActivity.arrayAdapter_nameSTAT, new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i)
                                    {
                                        editText.setText(GreenDeskActivity.arrayAdapter_nameSTAT.getItem(i));
                                        GreenDeskActivity.arrayAdapter_nameSTAT.remove(GreenDeskActivity.arrayAdapter_nameSTAT.getItem(i));
                                    }
                                });
                                AppSettings.brandAlertDialog(GreenDeskActivity.alertDialog_nameFromStat.show());
                            }
                        });
                        LinearLayout.LayoutParams nfsParams = new LinearLayout.LayoutParams(AppSettings.getDP(40), AppSettings.getDP(36));
                        nfsParams.gravity = Gravity.CENTER_VERTICAL;
                        editText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
                        llayout.addView(editText);
                        llayout.addView(nameFromStat, nfsParams);

                        alert.setView(llayout);
                        alert.setCancelable(false);
                        alert.setPositiveButton(MafiaProjectProApp.getContext().getText(R.string.ok), new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int whichButton)
                            {
                                gamerState = GamerState.setedNickname;
                                GreenDeskActivity.imm.hideSoftInputFromWindow(editText.getWindowToken(),0);

                                if (editText.getText().toString().equals("") || editText.getText().toString().equals(String.format("%s %d", MafiaProjectProApp.getContext().getText(R.string.voting_player), AppSettings.getContainerGreenDeskState().cardend + 1)))
                                {
                                    nickname = String.format("%s %d", MafiaProjectProApp.getContext().getText(R.string.voting_player), AppSettings.getContainerGreenDeskState().cardend + 1);
                                    defaultNickname = true;
                                }
                                else
                                {
                                    nickname = editText.getText().toString();
                                    defaultNickname = false;
                                }

                                GreenDeskActivity.setBack_buttonBackground(AppSettings.getThemeResources().currentGreenDeskBackCard_mini);

                                blackImageView.startAnimation(animation_toAlfaOne_blackImageView);
                                blackImageView.bringToFront();

                                back_button.startAnimation(animationSet_back);
                                back_button.bringToFront();
                            }
                        });

                        if(gamerState == GamerState.setedNickname)
                        {
                            blackImageView.startAnimation(animation_toAlfaOne_blackImageView);
                            blackImageView.bringToFront();

                            back_button.startAnimation(animationSet_back);
                            back_button.bringToFront();
                        }
                        else
                        {
                            AppSettings.brandAlertDialog(alert.show());
                            GreenDeskActivity.imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
                        }
                    }
                    else
                    if (nickname_enable == AppSettings.NoNicknameGreenDesk || nickname_enable == AppSettings.NicknameAfterGreenDesk)
                    {
                        nickname = String.format("%s %d", MafiaProjectProApp.getContext().getText(R.string.voting_player), AppSettings.getContainerGreenDeskState().cardend + 1);
                        defaultNickname = true;
                        GreenDeskActivity.setBack_buttonBackground(AppSettings.getThemeResources().currentGreenDeskBackCard_mini);

                        blackImageView.startAnimation(animation_toAlfaOne_blackImageView);
                        blackImageView.bringToFront();

                        back_button.startAnimation(animationSet_back);
                        back_button.bringToFront();
                    }
                }
            }
        });
        back_button.setVisibility(View.VISIBLE);

        front_button = new ImageButton(MafiaProjectProApp.getContext());
        front_button.setBackgroundResource(this.front_background);
        front_button.setVisibility(View.INVISIBLE);

        if(!GreenDeskActivity.notZeroState || gamerState == GamerState.Choosed || gamerState == GamerState.setedNickname)
        {
            animation_transferToPosition_back.setDuration(0);
        }
        else
        {
            animation_transferToPosition_back.setDuration(800);
        }
        animation_transferToPosition_back.setStartOffset(animation_transferToPosition_back_startOffSet);
        animation_transferToPosition_back.setFillAfter(true);
        listener_animation_transferToPosition_back = new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                pressed_back = true;
                back_button.setClickable(true);
                if(gamerState == GamerState.Choosed || gamerState == GamerState.setedNickname)
                {
                    back_button.performClick();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        };
        animation_transferToPosition_back.setAnimationListener(listener_animation_transferToPosition_back);

        if(gamerState != GamerState.Removed)
        {
            GreenDeskActivity.greendesk_layout.addView(back_button, new AbsoluteLayout.LayoutParams(AppSettings.getDP(40), AppSettings.getDP(58), pxX, pxY));
            GreenDeskActivity.greendesk_layout.addView(front_button, new AbsoluteLayout.LayoutParams(AppSettings.getDP(40 * 7), AppSettings.getDP(58 * 7), (AppSettings.getDisplayWidth() / 2) - AppSettings.getDP(20 * 7), (AppSettings.getDisplayHeight() / 2) - AppSettings.getDP(29 * 7)));
            GreenDeskActivity.greendesk_layout.addView(blackImageView, new FrameLayout.LayoutParams(AppSettings.getDisplayWidth(), AppSettings.getDisplayHeight()));
            GreenDeskActivity.greendesk_layout.addView(role_background, new AbsoluteLayout.LayoutParams(AppSettings.getDP(40 * 7), AppSettings.getDP(50), (AppSettings.getDisplayWidth() / 2) - AppSettings.getDP(20 * 7), (AppSettings.getDisplayHeight() / 2) + AppSettings.getDP(127)));
            back_button.startAnimation(animation_transferToPosition_back);
        }
    }

    private void initialization_listeners()
    {
        listener_animation_collapse = new Animation.AnimationListener()
        {
            @Override
            public void onAnimationEnd(Animation animation)
            {
                back_button.setVisibility(View.GONE);
                front_button.startAnimation(animation_expand);
                front_button.bringToFront();
                front_button.setVisibility(View.VISIBLE);
                final float startY = front_button.getY();

                front_button.setOnTouchListener(new View.OnTouchListener()
                {
                    float dYcart, dyrole;

                    @Override
                    public boolean onTouch(View v, MotionEvent event)
                    {
                        switch (event.getAction())
                        {
                            case MotionEvent.ACTION_DOWN:
                                if(pressed_front)
                                {
                                    dYcart = v.getY() - event.getRawY();
                                    dyrole = role_background.getY() - event.getRawY();
                                }
                                break;

                            case MotionEvent.ACTION_MOVE:
                                if (pressed_front)
                                {
                                    float alpha = (event.getRawY() + (dYcart)) / (startY);
                                    if (event.getRawY() + dYcart < startY && alpha < 1)
                                    {
                                        if(alpha < 0.05)
                                        {
                                            long downTime = SystemClock.uptimeMillis();
                                            long eventTime = SystemClock.uptimeMillis() + 100;
                                            float x = event.getRawX();
                                            float y = event.getRawY();
                                            int metaState = 0;
                                            MotionEvent motionEvent = MotionEvent.obtain(
                                                    downTime,
                                                    eventTime,
                                                    MotionEvent.ACTION_UP,
                                                    x,
                                                    y,
                                                    metaState
                                            );
                                            v.dispatchTouchEvent(motionEvent);
                                            return true;
                                        }
                                        v.setAlpha(alpha);
                                        v.animate().y(event.getRawY() + dYcart).setDuration(0).start();
                                        role_background.setAlpha(alpha);
                                        role_background.animate().y(event.getRawY() + dyrole).setDuration(0).start();
                                    }
                                }
                                break;

                            case MotionEvent.ACTION_UP:
                                if (pressed_front)
                                {
                                    GreenDeskActivity.setCardPressedFrontState(false);
                                    GreenDeskActivity.setCardPressedBackState(true);

                                    animation_toAlfaZero = AnimationUtils.loadAnimation(MafiaProjectProApp.getContext(), R.anim.anim_card_toalfazero);
                                    animation_toAlfaZero.setFillAfter(true);
                                    animation_toAlfaZero.setAnimationListener(listener_animation_toAlfaZero);

                                    animation_toAlfaZero_role = AnimationUtils.loadAnimation(MafiaProjectProApp.getContext(), R.anim.anim_card_toalfazero);
                                    animation_toAlfaZero_role.setFillBefore(true);
                                    animation_toAlfaZero_role.setFillAfter(true);

                                    animation_toAlfaZero_blackImageView = AnimationUtils.loadAnimation(MafiaProjectProApp.getContext(), R.anim.anim_card_toalfazero);

                                    front_button.startAnimation(animation_toAlfaZero);
                                    role_background.startAnimation(animation_toAlfaZero_role);
                                    blackImageView.startAnimation(animation_toAlfaZero_blackImageView);
                                }
                                break;
                            default:
                                return false;
                        }
                        return true;
                    }
                });

                role_background.startAnimation(animation_expand);
                role_background.bringToFront();
                role_background.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }
        };

        listener_animation_expand = new Animation.AnimationListener()
        {
            @Override
            public void onAnimationEnd(Animation animation)
            {
                pressed_front = true;
                System.gc();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }
        };

        listener_animation_toAlfaZero = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                GreenDeskActivity.setBack_buttonBackground(AppSettings.getThemeResources().currentGreenDeskBackCard_mini_selector);
                gamerState = GamerState.Removed;
                new Handler().post(new Runnable()
                {
                    public void run()
                    {
                        GreenDeskActivity.setCardPressedBackState(true);
                        GreenDeskActivity.greendesk_layout.removeView(AppSettings.getContainerGreenDeskState().gamerArrayList.get(index).blackImageView);
                        GreenDeskActivity.greendesk_layout.removeView(AppSettings.getContainerGreenDeskState().gamerArrayList.get(index).back_button);
                        GreenDeskActivity.greendesk_layout.removeView(AppSettings.getContainerGreenDeskState().gamerArrayList.get(index).front_button);
                        GreenDeskActivity.greendesk_layout.removeView(AppSettings.getContainerGreenDeskState().gamerArrayList.get(index).role_background);

                        blackImageView = null;
                        front_button = null;
                        role_background = null;
                        animationSet_back = null;
                        animation_transferToCenter_back = null;
                        animation_collapse = null;
                        animation_expand = null;
                        animation_toAlfaZero = null;
                        animation_toAlfaZero_role = null;
                        animation_toAlfaOne_blackImageView = null;
                        animation_toBigSize_back = null;
                    }
                });
                isCardEnded();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };

        listener_animation_transferToCenter_back = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                back_button.setBackgroundResource(AppSettings.getThemeResources().currentGreenDeskBackCard);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };

        animation_toAlfaOne_blackImageView = AnimationUtils.loadAnimation(MafiaProjectProApp.getContext(), R.anim.anim_card_toalfaone_blackimageview);
        animation_toAlfaOne_blackImageView.setFillBefore(true);
        animation_toAlfaOne_blackImageView.setFillAfter(true);

        animation_collapse = AnimationUtils.loadAnimation(MafiaProjectProApp.getContext(), R.anim.anim_card_collapse);
        animation_collapse.setStartOffset(1400);
        animation_collapse.setAnimationListener(listener_animation_collapse);

        animation_expand = AnimationUtils.loadAnimation(MafiaProjectProApp.getContext(), R.anim.anim_card_expand);
        animation_expand.setAnimationListener(listener_animation_expand);

        animation_toBigSize_back = AnimationUtils.loadAnimation(MafiaProjectProApp.getContext(), R.anim.anim_card_tobigsize);
        animation_toBigSize_back.setStartOffset(1400);
        animation_toBigSize_back.setFillAfter(true);

        animation_transferToCenter_back.setDuration(1400);
        animation_transferToCenter_back.setFillAfter(true);
        animation_transferToCenter_back.setAnimationListener(listener_animation_transferToCenter_back);

        animationSet_back = new AnimationSet(true);
        animationSet_back.addAnimation(animation_collapse);
        animationSet_back.addAnimation(animation_toBigSize_back);
        animationSet_back.addAnimation(animation_transferToCenter_back);
        animationSet_back.setFillAfter(true);
    }

    private void isCardEnded()
    {
        numberInList = AppSettings.getContainerGreenDeskState().cardend;
        AppSettings.getContainerGreenDeskState().cardend++;
        if (AppSettings.getContainerGreenDeskState().cardend == AppSettings.getContainerGreenDeskState().gamerArrayList.size())
        {
            switch (nickname_enable)
            {
                case AppSettings.NoNicknameGreenDesk:
                    Intent toLWPActivity = new Intent(MafiaProjectProApp.getContext(), LWPActivity.class);
                    toLWPActivity.putExtra("PreviousActivity", AppSettings.FromGreenDesk);
                    AppSettings.setLoadingIntent(toLWPActivity);
                    MafiaProjectProApp.getContext().startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                    System.gc();
                    ((Activity) MafiaProjectProApp.getContext()).finish();
                    break;

                case AppSettings.NicknameInGreenDesk:
                    toLWPActivity = new Intent(MafiaProjectProApp.getContext(), LWPActivity.class);
                    toLWPActivity.putExtra("PreviousActivity", AppSettings.FromGreenDesk);
                    AppSettings.setLoadingIntent(toLWPActivity);
                    MafiaProjectProApp.getContext().startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                    System.gc();
                    ((Activity) MafiaProjectProApp.getContext()).finish();
                    break;

                case AppSettings.NicknameAfterGreenDesk:
                    final Intent toSNARActivity = new Intent(MafiaProjectProApp.getContext(), SNARActivity.class);
                    toSNARActivity.putExtra("gamemode", ((Activity) MafiaProjectProApp.getContext()).getIntent().getIntExtra("gamemode", AppSettings.GameMode_Customize));
                    toSNARActivity.putExtra("withcards", AppSettings.WithCards_On);
                    AppSettings.setLoadingIntent(toSNARActivity);
                    MafiaProjectProApp.getContext().startActivity(new Intent(MafiaProjectProApp.getContext(), LoadingActivity.class));
                    System.gc();
                    ((Activity) MafiaProjectProApp.getContext()).finish();
                    break;
            }
        }
    }
}
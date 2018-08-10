package com.charleyskills.mafiaprojectpro.startgame;

import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.charleyskills.mafiaprojectpro.AppSettings;
import com.charleyskills.mafiaprojectpro.MafiaProjectProApp;
import com.charleyskills.mafiaprojectpro.R;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name="ItemInAnotherRoleList")
class ItemInAnotherRoleList
{
    @Attribute(name="role")
    public String role = "";

    LinearLayout lLayout;
    LinearLayout.LayoutParams lParam;
    TextView tRole;
    LinearLayout.LayoutParams tParam;
    EditText editText;
    LinearLayout.LayoutParams etParam;
    LinearLayout fLayout;
    LinearLayout.LayoutParams fParam;
    TextView subText;
    LinearLayout.LayoutParams stParam;

    @Attribute(name="order")
    int order;

    public boolean active = false;

    GamePresetLayout parentGamePresetLayout;

    ItemInAnotherRoleList(@Attribute(name="order") int order, @Attribute(name="role") String role)
    {
        this.role = role;
        active = true;
        this.order = order;
    }

    ItemInAnotherRoleList(GamePresetLayout parentGamePresetLayout)
    {
        active = false;
        if(parentGamePresetLayout.containerItemInAnotherRoleList == null)
            this.order = 0;
        else
            this.order = parentGamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.size();

        this.parentGamePresetLayout = parentGamePresetLayout;

        initiate();
    }

    public void setParentGamePresetLayout(GamePresetLayout parentGamePresetLayout)
    {
        this.parentGamePresetLayout = parentGamePresetLayout;
    }

    public void initiate()
    {
        lLayout = new LinearLayout(MafiaProjectProApp.getContext());
        lParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        lParam.setMargins(AppSettings.getDP(15), 0, AppSettings.getDP(15), 0);
        CustomizeGameActivity.linearlayout_customizeGame.addView(lLayout, lParam);

        tRole = new TextView(MafiaProjectProApp.getContext());
        tRole.setText(String.valueOf(order + 1) + ".");
        tRole.setTextColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.White));
        tRole.setTextSize(21);
        tRole.setGravity(Gravity.CENTER_VERTICAL);
        tParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        tParam.gravity = Gravity.CENTER_VERTICAL;
        lLayout.addView(tRole, tParam);

        editText = new EditText(MafiaProjectProApp.getContext());
        editText.setBackgroundResource(R.drawable.apptheme_edit_text_holo_dark);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        if (role.length() == 0)
        {
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
        }
        else
        {
            editText.setFocusable(false);
            editText.setFocusableInTouchMode(false);
        }
        editText.setSingleLine(true);
        editText.setText(role);

        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(10);

        editText.setFilters(filters);
        editText.setTextColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.White));
        etParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        etParam.setMargins(5, 0, 0, 0);
        etParam.weight = 10;
        lLayout.addView(editText, etParam);

        //Button

        fLayout = new LinearLayout(MafiaProjectProApp.getContext());
        fLayout.setBackgroundResource(R.drawable.itemingloballist_lwp);
        fLayout.setClickable(true);
        fLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (String.valueOf(subText.getText()).equals(MafiaProjectProApp.getContext().getString(R.string.CustomizeGame_Save)))
                {
                    if (!String.valueOf(editText.getText()).equals(""))
                    {
                        if (parentGamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                                parentGamePresetLayout.doctor +
                                parentGamePresetLayout.whore +
                                parentGamePresetLayout.maniac +
                                parentGamePresetLayout.sheriff +
                                parentGamePresetLayout.godfather +
                                parentGamePresetLayout.mafia +
                                parentGamePresetLayout.civilian + 1 <= AppSettings.max_players)
                        {
                            role = String.valueOf(editText.getText());

                            editText.setEnabled(false);
                            CustomizeGameActivity.imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                            editText.setFocusable(false);
                            editText.setFocusableInTouchMode(false);
                            active = true;
                            subText.setText(R.string.remove);

                            if (parentGamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                                    parentGamePresetLayout.doctor +
                                    parentGamePresetLayout.whore +
                                    parentGamePresetLayout.maniac +
                                    parentGamePresetLayout.sheriff +
                                    parentGamePresetLayout.godfather +
                                    parentGamePresetLayout.mafia +
                                    parentGamePresetLayout.civilian + 1 <= AppSettings.max_players)
                            {
                                parentGamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(parentGamePresetLayout));
                            }

                            CustomizeGameActivity.mainScrollView.post(new Thread(new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    CustomizeGameActivity.mainScrollView.fullScroll(View.FOCUS_DOWN);
                                }
                            }));
                        }
                        else
                        {
                            editText.setText("");
                            AppSettings.showDialog(3);
                        }
                    }
                    else
                    {
                        Toast.makeText(MafiaProjectProApp.getContext(), MafiaProjectProApp.getContext().getString(R.string.entertext), Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    deinitiate();
                    active = false;
                    parentGamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.remove(order);
                    CustomizeGameActivity.recountArray_anotherRoles(CustomizeGameActivity.gamePresetLayout);

                    if (parentGamePresetLayout.calc_CountOfArrayItemInAnotherRoleList() +
                            parentGamePresetLayout.doctor +
                            parentGamePresetLayout.whore +
                            parentGamePresetLayout.maniac +
                            parentGamePresetLayout.sheriff +
                            parentGamePresetLayout.godfather +
                            parentGamePresetLayout.mafia +
                            parentGamePresetLayout.civilian + 1 <= AppSettings.max_players)
                    {
                        if(!parentGamePresetLayout.isHasEmptyItemOfArrayItemAnotherRoleList())
                        {
                            parentGamePresetLayout.containerItemInAnotherRoleList.arrayItemAnotherRoles.add(new ItemInAnotherRoleList(parentGamePresetLayout));
                        }
                    }
                    else
                    {
                        parentGamePresetLayout.del_EmptyItemOfArrayItemInAnotherRoleList(true);
                    }
                }
            }
        });
        fParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        lLayout.addView(fLayout, fParam);

        subText = new TextView(MafiaProjectProApp.getContext());
        if (role.length() == 0) {
            subText.setText(R.string.CustomizeGame_Save);
        } else {
            subText.setText(R.string.remove);
        }
        subText.setTextColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.White));
        subText.setTextSize(21);
        subText.setPadding(AppSettings.getDP(3), 0, AppSettings.getDP(3), 0);
        stParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        stParam.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT;
        stParam.setMargins(AppSettings.getDP(3), 0, 0, 0);
        fLayout.addView(subText, stParam);
    }

    void deinitiate()
    {
        CustomizeGameActivity.linearlayout_customizeGame.removeView(lLayout);
    }
}
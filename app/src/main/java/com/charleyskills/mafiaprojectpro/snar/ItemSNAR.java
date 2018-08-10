package com.charleyskills.mafiaprojectpro.snar;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.charleyskills.mafiaprojectpro.AppSettings;
import com.charleyskills.mafiaprojectpro.MafiaProjectProApp;
import com.charleyskills.mafiaprojectpro.R;
import com.charleyskills.mafiaprojectpro.statistics.ItemPlayerStatistics;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name="ItemSNAR")
public class ItemSNAR
{
    LinearLayout lLayout;
    LinearLayout.LayoutParams lParam;

    TextView tNumberInList;
    LinearLayout.LayoutParams tParam;

    EditText editText;
    LinearLayout.LayoutParams etParam;

    LinearLayout fLayout;
    LinearLayout.LayoutParams fParam;

    @Attribute(name="role")
    public String role = "";

    @Attribute(name="numberInList")
    int numberInList;

    public boolean defaultNickname;

    @Attribute(name="nickname")
    public String nickname;

    @Attribute(name="noRole")
    boolean noRole;

    ImageView breaker;
    LinearLayout.LayoutParams bParam;
    private TextView tSelectRole;
    LinearLayout.LayoutParams tSelectRoleParam;
    ImageView spinner;
    LinearLayout.LayoutParams spinnerParam;

    ItemSNAR(@Attribute(name="role") String role, @Attribute(name="numberInList") int numberInList, @Attribute(name="nickname") String nickname, @Attribute(name="noRole") boolean noRole)
    {
        this.role = role;
        this.numberInList = numberInList;
        this.nickname = nickname;
        this.noRole = noRole;
        initiate(noRole);
    }

    ItemSNAR(int numberInList, String role, boolean noRole)
    {
        this.role = role;
        this.numberInList = numberInList;
        nickname = String.format("%s %d", MafiaProjectProApp.getContext().getResources().getText(R.string.voting_player), numberInList + 1);
        this.noRole = noRole;
        initiate(noRole);
    }

    ItemSNAR(int numberInList, boolean noRole)
    {
        this.numberInList = numberInList;
        nickname = String.format("%s %d", MafiaProjectProApp.getContext().getResources().getText(R.string.voting_player), numberInList + 1);
        this.noRole = noRole;
        initiate(noRole);
    }

    void addBreaker()
    {
        breaker = new ImageView(MafiaProjectProApp.getContext());
        bParam = new LinearLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 1);
        bParam.setMargins(AppSettings.getDP(10), 0, AppSettings.getDP(10), 0);
        breaker.setBackgroundColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.divider));
        SNARActivity.snar_linearlayout.addView(breaker, bParam);
    }

    private void initiate(boolean noRole)
    {
        lLayout = new LinearLayout(MafiaProjectProApp.getContext());
        lLayout.setClickable(true);
        lParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, AppSettings.getDP(41));
        lParam.setMargins(AppSettings.getDP(10), 0, AppSettings.getDP(10), 0);
        SNARActivity.snar_linearlayout.addView(lLayout, lParam);

        tNumberInList = new TextView(MafiaProjectProApp.getContext());
        tNumberInList.setText(String.format("%d.", numberInList + 1));
        tNumberInList.setTextColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.White));
        tNumberInList.setTextSize(21);
        tNumberInList.setGravity(Gravity.CENTER_VERTICAL);
        tParam = new LinearLayout.LayoutParams(AppSettings.getDP(30), LinearLayout.LayoutParams.MATCH_PARENT);
        tParam.gravity = Gravity.CENTER_VERTICAL;
        lLayout.addView(tNumberInList, tParam);

        editText = new EditText(MafiaProjectProApp.getContext());
        editText.setBackgroundResource(R.drawable.apptheme_edit_text_holo_dark);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.setSingleLine(true);
        editText.setText(nickname);

        Drawable x = MafiaProjectProApp.getContext().getResources().getDrawable(R.drawable.button_del);
        x.setBounds(0, 0, x.getIntrinsicWidth(), x.getIntrinsicHeight());
        editText.setCompoundDrawables(null, null, x, null);
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (event.getRawX() >= (editText.getRight() - editText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        editText.setText("");
                        editText.requestFocus();
                        SNARActivity.imm.showSoftInput(editText, 0);
                        return true;
                    }
                }
                return false;
            }
        });

        editText.setSelectAllOnFocus(true);
        editText.setHighlightColor(Color.DKGRAY);

        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(10);

        editText.setFilters(filters);
        editText.setTextColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.White));
        etParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        etParam.setMargins(5, 0, 0, 0);
        etParam.weight = 10;
        lLayout.addView(editText, etParam);

        ImageView nameFromStat = new ImageView(MafiaProjectProApp.getContext());
        nameFromStat.setBackgroundResource(R.drawable.button_book);
        nameFromStat.setClickable(true);
        nameFromStat.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SNARActivity.imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);

                if(AppSettings.getPlayerStatistic().size() == 0)
                {
                    Toast.makeText(MafiaProjectProApp.getContext(), R.string.SNAR_GreenDeskActivity_no_nicknames_in_statistics, Toast.LENGTH_SHORT).show();
                    return;
                }

                SNARActivity.arrayAdapter_nameSTAT.clear();
                for(ItemPlayerStatistics itemSTAT : AppSettings.getPlayerStatistic())
                {
                    boolean no_contains = true;
                    for(ItemSNAR itemSNAR : AppSettings.getContainerSNARItems())
                    {
                        if (itemSNAR.editText.getText().toString().equals(itemSTAT.name))
                        {
                            no_contains = false;
                            break;
                        }
                    }
                    if(no_contains)
                    {
                        SNARActivity.arrayAdapter_nameSTAT.add(itemSTAT.name);
                    }
                }

                if(SNARActivity.arrayAdapter_nameSTAT.getCount() == 0)
                {
                    Toast.makeText(MafiaProjectProApp.getContext(), R.string.SNAR_GreenDeskActivity_all_nicknames_used, Toast.LENGTH_SHORT).show();
                    return;
                }

                SNARActivity.alertDialog_nameFromStat.setTitle(String.format("%d. %s", numberInList + 1, MafiaProjectProApp.getContext().getString(R.string.SNARActivity_chooseYourNickname)));
                SNARActivity.alertDialog_nameFromStat.setAdapter(SNARActivity.arrayAdapter_nameSTAT, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        editText.setText(SNARActivity.arrayAdapter_nameSTAT.getItem(i));
                        SNARActivity.arrayAdapter_nameSTAT.remove(SNARActivity.arrayAdapter_nameSTAT.getItem(i));
                    }
                });
                AppSettings.brandAlertDialog(SNARActivity.alertDialog_nameFromStat.show());
            }
        });
        LinearLayout.LayoutParams nfsParams = new LinearLayout.LayoutParams(AppSettings.getDP(40), AppSettings.getDP(36));
        nfsParams.gravity = Gravity.CENTER_VERTICAL;
        lLayout.addView(nameFromStat, nfsParams);

        //Button

        if (!noRole)
        {
            fLayout = new LinearLayout(MafiaProjectProApp.getContext());
            fLayout.setBackgroundResource(R.drawable.itemingloballist_lwp);
            fLayout.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    SNARActivity.imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);

                    if(editText.getText().toString().equals(MafiaProjectProApp.getContext().getText(R.string.voting_player) + " " + (numberInList + 1)) || editText.getText().toString().equals(""))
                    {
                        SNARActivity.alertDialog_SNAR.setTitle(MafiaProjectProApp.getContext().getText(R.string.voting_player) + " " + (numberInList + 1) + " : " + MafiaProjectProApp.getContext().getText(R.string.SNAR_ChooseRole));
                    }
                    else
                    {
                        SNARActivity.alertDialog_SNAR.setTitle(editText.getText().toString() + " : " + MafiaProjectProApp.getContext().getText(R.string.SNAR_ChooseRole));
                    }
                    SNARActivity.alertDialog_SNAR.setAdapter(SNARActivity.arrayAdapter_role, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            tSelectRole.setText(AppSettings.getContainerSNARAdapterRoles().get(which).substring(0, 1));
                            role = AppSettings.getShortNameRole(AppSettings.getContainerSNARAdapterRoles().get(which));
                        }
                    });
                    AppSettings.brandAlertDialog(SNARActivity.alertDialog_SNAR.show());
                }
            });
            fLayout.setClickable(true);

            fParam = new LinearLayout.LayoutParams(AppSettings.getDP(70), AppSettings.getDP(41));
            lLayout.addView(fLayout, fParam);

            tSelectRole = new TextView(MafiaProjectProApp.getContext());
            tSelectRole.setText(role.equals("") ? "" : AppSettings.getFullNameRole(role).substring(0, 1));
            tSelectRole.setTextSize(27);
            tSelectRole.setTextColor(MafiaProjectProApp.getContext().getResources().getColor(R.color.White));
            tSelectRoleParam = new LinearLayout.LayoutParams(AppSettings.getDP(30), LinearLayout.LayoutParams.WRAP_CONTENT);
            tSelectRoleParam.setMargins(AppSettings.getDP(5), 0, 0, 0);
            tSelectRoleParam.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT;

            fLayout.addView(tSelectRole, tSelectRoleParam);

            spinner = new ImageView(MafiaProjectProApp.getContext());
            spinner.setBackgroundResource(R.drawable.pic_spinner);
            spinner.setClickable(false);
            spinnerParam = new LinearLayout.LayoutParams(AppSettings.getDP(30), AppSettings.getDP(25));
            spinnerParam.gravity = Gravity.CENTER_VERTICAL;
            spinnerParam.setMargins(AppSettings.getDP(5), 0, 0, 0);

            fLayout.addView(spinner, spinnerParam);
        }

        addBreaker();
    }
}

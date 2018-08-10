package com.charleyskills.mafiaprojectpro.statistics;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.charleyskills.mafiaprojectpro.AppSettings;
import com.charleyskills.mafiaprojectpro.HomeActivity;
import com.charleyskills.mafiaprojectpro.IO;
import com.charleyskills.mafiaprojectpro.MafiaProjectProApp;
import com.charleyskills.mafiaprojectpro.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.AxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.tjerkw.slideexpandable.library.AbstractSlideExpandableListAdapter;
import com.tjerkw.slideexpandable.library.SlideExpandableListAdapter;

import java.util.ArrayList;

public class StatisticsActivity extends Activity
{
    public ListView scrollView_STAT;
    private Intent toHomeActivityIntent;
    private ArrayAdapterStatistics adapter;
    private LinearLayout linearLayoutForChart;

    private TextView compare_players;
    private TextView clear_comparing;
    private TextView del_player_statistics;
    private TextView del_all_statistics;
    private TextView compare_done;
    private TextView start_compare;

    private CombinedChart comparechart;
    private CombinedData chart_data;
    private AlertDialog.Builder adb;

    TextView statistics_title;

    SlideExpandableListAdapter s;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        MafiaProjectProApp.setContext(this);

        overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);

        toHomeActivityIntent = new Intent(this, HomeActivity.class);

        compare_players = (TextView) findViewById(R.id.compare_players);
        clear_comparing = (TextView) findViewById(R.id.clear_comparing);
        del_player_statistics = (TextView) findViewById(R.id.del_player_statistics);
        del_all_statistics = (TextView) findViewById(R.id.del_all_statistics);
        compare_done = (TextView) findViewById(R.id.compare_done);
        start_compare = (TextView) findViewById(R.id.start_compare);

        comparechart = (CombinedChart) findViewById(R.id.comparechart);

        scrollView_STAT = (ListView) findViewById(R.id.scrollView_STAT);

        adb = new AlertDialog.Builder(this);

        comparechart.setData(chart_data);
        comparechart.setSelected(false);
        comparechart.setDescription("");
        comparechart.setDrawGridBackground(false);

        comparechart.setDrawOrder(new CombinedChart.DrawOrder[]{CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE});
        comparechart.getXAxis().setAxisMinValue(-0.4f);
        comparechart.getXAxis().setAxisMaxValue(comparechart.getXAxis().getAxisMaximum() + 0.4f);

        comparechart.getXAxis().setDrawAxisLine(false);
        comparechart.getXAxis().setDrawGridLines(false);
        comparechart.getXAxis().setTextColor(Color.WHITE);
        comparechart.getXAxis().setTextSize(11f);
        comparechart.getXAxis().setLabelRotationAngle(22);

        comparechart.getAxisRight().setDrawAxisLine(false);
        comparechart.getAxisRight().setDrawLabels(false);
        comparechart.getAxisRight().setDrawGridLines(false);

        comparechart.getAxisLeft().setDrawAxisLine(false);
        comparechart.getAxisLeft().setDrawLabels(false);
        comparechart.getAxisLeft().setDrawGridLines(false);

        comparechart.setTouchEnabled(false);
        comparechart.setDragEnabled(false);
        comparechart.setEnabled(false);
        comparechart.setScaleEnabled(false);
        comparechart.setPinchZoom(false);
        comparechart.setDoubleTapToZoomEnabled(false);
        comparechart.setHighlightPerDragEnabled(false);
        comparechart.setHighlightPerTapEnabled(false);

        linearLayoutForChart = (LinearLayout) findViewById(R.id.Frame_Chart);
        adapter = new ArrayAdapterStatistics(this, AppSettings.getPlayerStatistic());

        s = new SlideExpandableListAdapter(adapter, R.id.textViewWrap, R.id.layout_for_chart);
        s.setItemExpandCollapseListener(new AbstractSlideExpandableListAdapter.OnItemExpandCollapseListener()
        {
            @Override
            public void onExpand(View itemView, int position)
            {
                final ItemPlayerStatistics item = AppSettings.getPlayerStatistic().get(position);
                item.entsWinPlayerStat = new ArrayList<>();
                item.entsTotalPlayerStat = new ArrayList<>();

                if (item.playerSherif != 0)
                {
                    item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winSherif, new String[]{String.valueOf(item.entsWinPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.sheriff)}));
                    item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerSherif, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.sheriff)}));
                }
                if (item.playerCivilian != 0)
                {
                    item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winCivilian, new String[]{String.valueOf(item.entsWinPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.civilian)}));
                    item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerCivilian, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.civilian)}));
                }
                if (item.playerMafia != 0)
                {
                    item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winMafia, new String[]{String.valueOf(item.entsWinPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.mafia)}));
                    item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerMafia, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.mafia)}));
                }
                if (item.playerGodFather != 0)
                {
                    item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winGodFather, new String[]{String.valueOf(item.entsWinPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.godfather)}));
                    item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerGodFather, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.godfather)}));
                }
                if (item.playerDoctor != 0)
                {
                    item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winDoctor, new String[]{String.valueOf(item.entsWinPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.doctor)}));
                    item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerDoctor, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.doctor)}));
                }
                if (item.playerManiac != 0)
                {
                    item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winManiac, new String[]{String.valueOf(item.entsWinPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.maniac)}));
                    item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerManiac, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.maniac)}));

                }
                if (item.playerWhore != 0) {
                    item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winWhore, new String[]{String.valueOf(item.entsWinPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.whore)}));
                    item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerWhore, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.whore)}));
                }

                BarDataSet bar_DataSetTotal = new BarDataSet(item.entsTotalPlayerStat, MafiaProjectProApp.getContext().getString(R.string.STATActivity_total));
                bar_DataSetTotal.setColor(Color.rgb(255, 0, 0));

                LineDataSet line_DataSet = new LineDataSet(item.entsWinPlayerStat, MafiaProjectProApp.getContext().getString(R.string.STATActivity_win));
                line_DataSet.setColor(Color.rgb(255, 255, 255));
                line_DataSet.setCircleColor(Color.rgb(255, 255, 255));

                BarData barData = new BarData(bar_DataSetTotal);
                barData.setValueTextColor(Color.WHITE);
                barData.setBarWidth(0.4f);
                barData.setValueFormatter(new ValueFormatter()
                {
                    @Override
                    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler)
                    {
                        if (item.entsWinPlayerStat.get((int) entry.getX()).getY() == value)
                        {
                            return "";
                        }
                        return String.format("%d", (int) value);
                    }
                });

                LineData lineData = new LineData(line_DataSet);
                lineData.setValueTextColor(Color.WHITE);
                lineData.setValueFormatter(new ValueFormatter()
                {
                    @Override
                    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler)
                    {
                        return String.format("%d", (int) value);
                    }
                });

                item.holder.data = new CombinedData();
                item.holder.data.setData(barData);
                item.holder.data.setData(lineData);

                item.holder.combinedChart.setData(item.holder.data);
                item.holder.combinedChart.setSelected(false);
                item.holder.combinedChart.setDescription("");
                item.holder.combinedChart.setDrawGridBackground(false);

                item.holder.combinedChart.setDrawOrder(new CombinedChart.DrawOrder[]{CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE});
                item.holder.combinedChart.getXAxis().setAxisMinValue(-0.4f);
                item.holder.combinedChart.getXAxis().setAxisMaxValue(item.holder.combinedChart.getXAxis().getAxisMaximum() + 0.4f);

                item.holder.combinedChart.getXAxis().setDrawAxisLine(false);
                item.holder.combinedChart.getXAxis().setDrawGridLines(false);
                item.holder.combinedChart.getXAxis().setTextColor(Color.WHITE);
                item.holder.combinedChart.getXAxis().setTextSize(11f);
                item.holder.combinedChart.getXAxis().setLabelCount(item.entsTotalPlayerStat.size());
                item.holder.combinedChart.getXAxis().setLabelRotationAngle(22);

                item.holder.combinedChart.getAxisRight().setDrawAxisLine(false);
                item.holder.combinedChart.getAxisRight().setDrawLabels(false);
                item.holder.combinedChart.getAxisRight().setDrawGridLines(false);
                item.holder.combinedChart.getAxisRight().setTextColor(Color.WHITE);

                item.holder.combinedChart.getAxisLeft().setDrawAxisLine(false);
                item.holder.combinedChart.getAxisLeft().setDrawLabels(false);
                item.holder.combinedChart.getAxisLeft().setDrawGridLines(false);
                item.holder.combinedChart.getAxisRight().setTextColor(Color.WHITE);

                item.holder.combinedChart.setTouchEnabled(false);
                item.holder.combinedChart.setDragEnabled(false);
                item.holder.combinedChart.setEnabled(false);
                item.holder.combinedChart.setScaleEnabled(false);
                item.holder.combinedChart.setPinchZoom(false);
                item.holder.combinedChart.setDoubleTapToZoomEnabled(false);
                item.holder.combinedChart.setHighlightPerDragEnabled(false);
                item.holder.combinedChart.setHighlightPerTapEnabled(false);

                item.holder.combinedChart.getXAxis().setValueFormatter(new AxisValueFormatter()
                {
                    @Override
                    public String getFormattedValue(float value, AxisBase axis)
                    {
                        if (value % 1 == 0 && value >= 0 && value < item.entsWinPlayerStat.size())
                        {
                            return ((String[]) item.entsWinPlayerStat.get((int) value % item.entsWinPlayerStat.size()).getData())[1];
                        }
                        return "";
                    }

                    @Override
                    public int getDecimalDigits() {
                        return 0;
                    }
                });

                Legend l = item.holder.combinedChart.getLegend();
                l.setEnabled(false);

                item.holder.combinedChart.animateY(500, Easing.EasingOption.EaseInSine);

                item.holder.combinedChart.getXAxis().resetAxisMinValue();
                item.holder.combinedChart.getXAxis().resetAxisMinValue();
                item.holder.combinedChart.getXAxis().setAxisMinValue(-0.5f);
                item.holder.combinedChart.getXAxis().setAxisMaxValue(item.entsTotalPlayerStat.size() + 0.5f - 1f);
                item.holder.combinedChart.getXAxis().setLabelCount(item.entsTotalPlayerStat.size());

                item.holder.combinedChart.notifyDataSetChanged();
                item.holder.combinedChart.invalidate();

                item.holder.spinner.setBackgroundResource(R.drawable.pic_spinner_rotate180);

                if (clear_comparing.getVisibility() == View.GONE)
                {
                    del_player_statistics.setVisibility(View.VISIBLE);
                    del_all_statistics.setVisibility(View.GONE);
                }
                item.expanded = true;
            }

            @Override
            public void onCollapse(View itemView, int position)
            {
                AppSettings.getPlayerStatistic().get(position).holder.spinner.setBackgroundResource(R.drawable.pic_spinner);
                if (clear_comparing.getVisibility() == View.GONE)
                {
                    del_player_statistics.setVisibility(View.GONE);
                    del_all_statistics.setVisibility(View.VISIBLE);
                }

                AppSettings.getPlayerStatistic().get(position).expanded = false;
            }
        });

        scrollView_STAT.setAdapter(s);

        compare_players.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                for (ItemPlayerStatistics item : AppSettings.getPlayerStatistic())
                {
                    if (item.holder != null)
                    {
                        item.holder.checkable.setVisibility(View.VISIBLE);
                        item.holder.checkable.setChecked(false);

                        item.holder.spinner.setVisibility(View.GONE);
                        item.holder.textViewWrap.setEnabled(false);
                        item.holder.spinner.setBackgroundResource(R.drawable.pic_spinner);
                    }
                    item.checkbox_visibility = View.VISIBLE;
                    item.checkbox_checked = false;
                    item.expanded = false;
                }
                s.collapseLastOpen();

                compare_players.setVisibility(View.GONE);
                clear_comparing.setVisibility(View.VISIBLE);
                del_all_statistics.setVisibility(View.GONE);
                del_player_statistics.setVisibility(View.GONE);
            }
        });

        clear_comparing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                del_all_statistics.setVisibility(View.VISIBLE);
                compare_players.setVisibility(View.VISIBLE);
                clear_comparing.setVisibility(View.GONE);
                start_compare.setVisibility(View.GONE);

                for (ItemPlayerStatistics item : AppSettings.getPlayerStatistic())
                {
                    if (item.holder != null)
                    {
                        item.holder.checkable.setVisibility(View.GONE);
                        item.holder.checkable.setChecked(false);

                        item.holder.spinner.setVisibility(View.VISIBLE);
                        item.holder.textViewWrap.setEnabled(true);
                    }
                    item.checkbox_visibility = View.GONE;
                    item.checkbox_checked = false;
                    item.expanded = false;
                }

                if (clear_comparing.getVisibility() == View.GONE)
                {
                    del_player_statistics.setVisibility(View.GONE);
                    del_all_statistics.setVisibility(View.VISIBLE);
                }
            }
        });

        start_compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView_STAT.setVisibility(View.GONE);
                linearLayoutForChart.setVisibility(View.VISIBLE);

                start_compare.setVisibility(View.GONE);
                clear_comparing.setVisibility(View.GONE);

                compare_done.setVisibility(View.VISIBLE);

                int[] position = new int[2];
                int k = 0;
                for (int i = 0; i < AppSettings.getPlayerStatistic().size(); i++)
                {
                    if (AppSettings.getPlayerStatistic().get(i).checkbox_checked)
                    {
                        position[k] = i;
                        k++;
                    }
                }

                final ItemPlayerStatistics itemOne = AppSettings.getPlayerStatistic().get(position[0]);
                final ItemPlayerStatistics itemTwo = AppSettings.getPlayerStatistic().get(position[1]);
                final ArrayList<BarEntry> entTotalPlayerStatOne = new ArrayList<>();
                final ArrayList<BarEntry> entTotalPlayerStatTwo = new ArrayList<>();

                if (itemOne.playerSherif != 0 || itemTwo.playerSherif != 0) {
                    entTotalPlayerStatOne.add(new BarEntry(entTotalPlayerStatOne.size(), new float[]{itemOne.winSherif, itemOne.playerSherif - itemOne.winSherif}, MafiaProjectProApp.getContext().getString(R.string.sheriff)));
                    entTotalPlayerStatTwo.add(new BarEntry(entTotalPlayerStatTwo.size(), new float[]{itemTwo.winSherif, itemTwo.playerSherif - itemTwo.winSherif}, MafiaProjectProApp.getContext().getString(R.string.sheriff)));
                }
                if (itemOne.playerCivilian != 0 || itemTwo.playerCivilian != 0) {
                    entTotalPlayerStatOne.add(new BarEntry(entTotalPlayerStatOne.size(), new float[]{itemOne.winCivilian, itemOne.playerCivilian - itemOne.winCivilian}, MafiaProjectProApp.getContext().getString(R.string.civilian)));
                    entTotalPlayerStatTwo.add(new BarEntry(entTotalPlayerStatTwo.size(), new float[]{itemTwo.winCivilian, itemTwo.playerCivilian - itemTwo.winCivilian}, MafiaProjectProApp.getContext().getString(R.string.civilian)));
                }
                if (itemOne.playerMafia != 0 || itemTwo.playerMafia != 0) {
                    entTotalPlayerStatOne.add(new BarEntry(entTotalPlayerStatOne.size(), new float[]{itemOne.winMafia, itemOne.playerMafia - itemOne.winMafia}, MafiaProjectProApp.getContext().getString(R.string.mafia)));
                    entTotalPlayerStatTwo.add(new BarEntry(entTotalPlayerStatTwo.size(), new float[]{itemTwo.winMafia, itemTwo.playerMafia - itemTwo.winMafia}, MafiaProjectProApp.getContext().getString(R.string.mafia)));
                }
                if (itemOne.playerGodFather != 0 || itemTwo.playerGodFather != 0) {
                    entTotalPlayerStatOne.add(new BarEntry(entTotalPlayerStatOne.size(), new float[]{itemOne.winGodFather, itemOne.playerGodFather - itemOne.winGodFather}, MafiaProjectProApp.getContext().getString(R.string.godfather)));
                    entTotalPlayerStatTwo.add(new BarEntry(entTotalPlayerStatTwo.size(), new float[]{itemTwo.winGodFather, itemTwo.playerGodFather - itemTwo.winGodFather}, MafiaProjectProApp.getContext().getString(R.string.godfather)));
                }
                if (itemOne.playerDoctor != 0 || itemTwo.playerDoctor != 0) {
                    entTotalPlayerStatOne.add(new BarEntry(entTotalPlayerStatOne.size(), new float[]{itemOne.winDoctor, itemOne.playerDoctor - itemOne.winDoctor}, MafiaProjectProApp.getContext().getString(R.string.doctor)));
                    entTotalPlayerStatTwo.add(new BarEntry(entTotalPlayerStatTwo.size(), new float[]{itemTwo.winDoctor, itemTwo.playerDoctor - itemTwo.winDoctor}, MafiaProjectProApp.getContext().getString(R.string.doctor)));
                }
                if (itemOne.playerManiac != 0 || itemTwo.playerManiac != 0) {
                    entTotalPlayerStatOne.add(new BarEntry(entTotalPlayerStatOne.size(), new float[]{itemOne.winManiac, itemOne.playerManiac - itemOne.winManiac}, MafiaProjectProApp.getContext().getString(R.string.maniac)));
                    entTotalPlayerStatTwo.add(new BarEntry(entTotalPlayerStatTwo.size(), new float[]{itemTwo.winManiac, itemTwo.playerManiac - itemTwo.winManiac}, MafiaProjectProApp.getContext().getString(R.string.maniac)));
                }
                if (itemOne.playerWhore != 0 || itemTwo.playerWhore != 0) {
                    entTotalPlayerStatOne.add(new BarEntry(entTotalPlayerStatOne.size(), new float[]{itemOne.winWhore, itemOne.playerWhore - itemOne.winWhore}, MafiaProjectProApp.getContext().getString(R.string.whore)));
                    entTotalPlayerStatTwo.add(new BarEntry(entTotalPlayerStatTwo.size(), new float[]{itemOne.winWhore, itemTwo.playerWhore - itemOne.winWhore}, MafiaProjectProApp.getContext().getString(R.string.whore)));
                }

                BarDataSet dataSetTotalPlayerStatOne = new BarDataSet(entTotalPlayerStatOne, MafiaProjectProApp.getContext().getString(R.string.STATActivity_total));
                dataSetTotalPlayerStatOne.setColors(new int[]{Color.rgb(158, 0, 0), Color.rgb(255, 0, 0)});
                dataSetTotalPlayerStatOne.setValueFormatter(new ValueFormatter()
                {
                    boolean down = true;

                    @Override
                    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler)
                    {
                        if (down)
                        {
                            down = !down;
                            return String.format("%d", (int) value);
                        }
                        else
                        {
                            down = !down;
                            return String.format("%d", (int) entry.getY());
                        }
                    }
                });
                BarDataSet dataSetTotalPlayerStatTwo = new BarDataSet(entTotalPlayerStatTwo, MafiaProjectProApp.getContext().getString(R.string.STATActivity_total));
                dataSetTotalPlayerStatTwo.setColors(new int[]{Color.rgb(191, 148, 0), Color.rgb(222, 192, 0)});
                dataSetTotalPlayerStatTwo.setValueFormatter(new ValueFormatter()
                {
                    boolean down = true;

                    @Override
                    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler)
                    {
                        if (down)
                        {
                            down = !down;
                            return String.format("%d", (int) value);
                        }
                        else
                        {
                            down = !down;
                            return String.format("%d", (int) entry.getY());
                        }
                    }
                });

                BarData barData = new BarData(dataSetTotalPlayerStatTwo, dataSetTotalPlayerStatOne);
                barData.setValueTextColor(Color.WHITE);
                barData.setBarWidth(0.4f);
                barData.groupBars(-0.4f, 0.1f, 0);

                chart_data = new CombinedData();
                chart_data.setData(barData);

                comparechart.setData(chart_data);
                comparechart.getXAxis().setLabelCount(entTotalPlayerStatOne.size());

                Legend l = comparechart.getLegend();
                l.setEnabled(false);

                comparechart.animateY(500, Easing.EasingOption.EaseInSine);

                comparechart.getXAxis().resetAxisMinValue();
                comparechart.getXAxis().resetAxisMinValue();
                comparechart.getXAxis().setAxisMinValue(-0.5f);
                comparechart.getXAxis().setAxisMaxValue(entTotalPlayerStatOne.size() + 0.5f - 1f);
                comparechart.getXAxis().setLabelCount(entTotalPlayerStatOne.size());

                comparechart.getXAxis().setValueFormatter(new AxisValueFormatter() {
                    @Override
                    public String getFormattedValue(float value, AxisBase axis) {
                        if (value % 1 == 0 && value >= 0 && value < entTotalPlayerStatOne.size()) {
                            return (String) entTotalPlayerStatOne.get((int) value).getData();
                        }
                        return "";
                    }

                    @Override
                    public int getDecimalDigits() {
                        return 0;
                    }
                });

                comparechart.notifyDataSetChanged();
                comparechart.invalidate();

                ((TextView) findViewById(R.id.totalOne)).setText(getString(R.string.STATActivity_total));
                ((TextView) findViewById(R.id.winOne)).setText(getString(R.string.STATActivity_win));
                ((TextView) findViewById(R.id.nameOne)).setText(itemOne.name);

                ((TextView) findViewById(R.id.totalTwo)).setText(getString(R.string.STATActivity_total));
                ((TextView) findViewById(R.id.winTwo)).setText(getString(R.string.STATActivity_win));
                ((TextView) findViewById(R.id.nameTwo)).setText(itemTwo.name);
            }
        });

        compare_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView_STAT.setVisibility(View.VISIBLE);
                linearLayoutForChart.setVisibility(View.GONE);

                for (ItemPlayerStatistics item : AppSettings.getPlayerStatistic())
                {
                    if (item.holder != null)
                    {
                        item.holder.checkable.setVisibility(View.GONE);
                        item.holder.checkable.setChecked(false);
                        item.holder.spinner.setVisibility(View.VISIBLE);

                        item.holder.textViewWrap.setEnabled(true);
                    }
                    item.checkbox_visibility = View.GONE;
                    item.checkbox_checked = false;
                }

                compare_done.setVisibility(View.GONE);
                compare_players.setVisibility(View.VISIBLE);
                del_all_statistics.setVisibility(View.VISIBLE);
            }
        });

        del_player_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < AppSettings.getPlayerStatistic().size(); i++)
                {
                    final ItemPlayerStatistics item = AppSettings.getPlayerStatistic().get(i);
                    if (item.expanded)
                    {
                        final int k = i;
                        adb.setMessage(getString(R.string.STATActivity_delete_player) + " " + item.name + "?");
                        adb.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int l)
                            {
                                s.collapseLastOpen();
                                AppSettings.getPlayerStatistic().remove(item);
                                IO.writeToSD(AppSettings.containerOfAllPlayersStatistic, IO.STATISTICSplayers, "writeSTAT");
                                if (k < AppSettings.getPlayerStatistic().size())
                                {
                                    AppSettings.getPlayerStatistic().get(k).expanded = true;
                                }
                                adapter.notifyDataSetChanged();
                                s.notifyDataSetChanged();

                                if (clear_comparing.getVisibility() == View.GONE)
                                {
                                    del_player_statistics.setVisibility(View.GONE);
                                    del_all_statistics.setVisibility(View.VISIBLE);
                                }
                            }
                        });
                        adb.setNegativeButton(R.string.no, null);
                        adb.create();
                        adb.show();
                        break;
                    }
                }

            }
        });

        del_all_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adb.setMessage(R.string.STATActivity_delete_all_statistics);
                adb.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AppSettings.getPlayerStatistic().clear();
                        IO.writeToSD(AppSettings.containerOfAllPlayersStatistic, IO.STATISTICSplayers, "writeSTAT");
                        adapter.notifyDataSetChanged();
                    }
                });
                adb.setNegativeButton(R.string.no, null);
                adb.create();
                adb.show();
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        MafiaProjectProApp.setContext(this);

        s = new SlideExpandableListAdapter(adapter, R.id.textViewWrap, R.id.layout_for_chart);
        s.setItemExpandCollapseListener(new AbstractSlideExpandableListAdapter.OnItemExpandCollapseListener()
        {
            @Override
            public void onExpand(View itemView, int position)
            {
                final ItemPlayerStatistics item = AppSettings.getPlayerStatistic().get(position);
                item.entsWinPlayerStat = new ArrayList<>();
                item.entsTotalPlayerStat = new ArrayList<>();

                if (item.playerSherif != 0)
                {
                    item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winSherif, new String[]{String.valueOf(item.entsWinPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.sheriff)}));
                    item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerSherif, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.sheriff)}));
                }
                if (item.playerCivilian != 0)
                {
                    item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winCivilian, new String[]{String.valueOf(item.entsWinPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.civilian)}));
                    item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerCivilian, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.civilian)}));

                }
                if (item.playerMafia != 0)
                {
                    item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winMafia, new String[]{String.valueOf(item.entsWinPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.mafia)}));
                    item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerMafia, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.mafia)}));
                }
                if (item.playerGodFather != 0)
                {
                    item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winGodFather, new String[]{String.valueOf(item.entsWinPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.godfather)}));
                    item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerGodFather, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.godfather)}));
                }
                if (item.playerDoctor != 0)
                {
                    item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winDoctor, new String[]{String.valueOf(item.entsWinPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.doctor)}));
                    item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerDoctor, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.doctor)}));
                }
                if (item.playerManiac != 0)
                {
                    item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winManiac, new String[]{String.valueOf(item.entsWinPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.maniac)}));
                    item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerManiac, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.maniac)}));

                }
                if (item.playerWhore != 0)
                {
                    item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winWhore, new String[]{String.valueOf(item.entsWinPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.whore)}));
                    item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerWhore, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), MafiaProjectProApp.getContext().getString(R.string.whore)}));
                }

                BarDataSet bar_DataSetTotal = new BarDataSet(item.entsTotalPlayerStat, MafiaProjectProApp.getContext().getString(R.string.STATActivity_total));
                bar_DataSetTotal.setColor(Color.rgb(255, 0, 0));

                LineDataSet line_DataSet = new LineDataSet(item.entsWinPlayerStat, MafiaProjectProApp.getContext().getString(R.string.STATActivity_win));
                line_DataSet.setColor(Color.rgb(255, 255, 255));
                line_DataSet.setCircleColor(Color.rgb(255, 255, 255));

                BarData barData = new BarData(bar_DataSetTotal);
                barData.setValueTextColor(Color.WHITE);
                barData.setBarWidth(0.4f);
                barData.setValueFormatter(new ValueFormatter()
                {
                    @Override
                    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler)
                    {
                        if (item.entsWinPlayerStat.get((int) entry.getX()).getY() == value)
                        {
                            return "";
                        }
                        return String.format("%d", (int) value);
                    }
                });

                LineData lineData = new LineData(line_DataSet);
                lineData.setValueTextColor(Color.WHITE);
                lineData.setValueFormatter(new ValueFormatter()
                {
                    @Override
                    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler)
                    {
                        return String.format("%d", (int) value);
                    }
                });

                item.holder.data = new CombinedData();
                item.holder.data.setData(barData);
                item.holder.data.setData(lineData);

                item.holder.combinedChart.setData(item.holder.data);
                item.holder.combinedChart.setSelected(false);
                item.holder.combinedChart.setDescription("");
                item.holder.combinedChart.setDrawGridBackground(false);

                item.holder.combinedChart.setDrawOrder(new CombinedChart.DrawOrder[]{CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE});
                item.holder.combinedChart.getXAxis().setAxisMinValue(-0.4f);
                item.holder.combinedChart.getXAxis().setAxisMaxValue(item.holder.combinedChart.getXAxis().getAxisMaximum() + 0.4f);

                item.holder.combinedChart.getXAxis().setDrawAxisLine(false);
                item.holder.combinedChart.getXAxis().setDrawGridLines(false);
                item.holder.combinedChart.getXAxis().setTextColor(Color.WHITE);
                item.holder.combinedChart.getXAxis().setTextSize(11f);
                item.holder.combinedChart.getXAxis().setLabelCount(item.entsTotalPlayerStat.size());
                item.holder.combinedChart.getXAxis().setLabelRotationAngle(22);

                item.holder.combinedChart.getAxisRight().setDrawAxisLine(false);
                item.holder.combinedChart.getAxisRight().setDrawLabels(false);
                item.holder.combinedChart.getAxisRight().setDrawGridLines(false);
                item.holder.combinedChart.getAxisRight().setTextColor(Color.WHITE);

                item.holder.combinedChart.getAxisLeft().setDrawAxisLine(false);
                item.holder.combinedChart.getAxisLeft().setDrawLabels(false);
                item.holder.combinedChart.getAxisLeft().setDrawGridLines(false);
                item.holder.combinedChart.getAxisRight().setTextColor(Color.WHITE);

                item.holder.combinedChart.setTouchEnabled(false);
                item.holder.combinedChart.setDragEnabled(false);
                item.holder.combinedChart.setEnabled(false);
                item.holder.combinedChart.setScaleEnabled(false);
                item.holder.combinedChart.setPinchZoom(false);
                item.holder.combinedChart.setDoubleTapToZoomEnabled(false);
                item.holder.combinedChart.setHighlightPerDragEnabled(false);
                item.holder.combinedChart.setHighlightPerTapEnabled(false);

                item.holder.combinedChart.getXAxis().setValueFormatter(new AxisValueFormatter() {
                    @Override
                    public String getFormattedValue(float value, AxisBase axis) {
                        if (value % 1 == 0 && value >= 0 && value < item.entsWinPlayerStat.size()) {
                            return ((String[]) item.entsWinPlayerStat.get((int) value % item.entsWinPlayerStat.size()).getData())[1];
                        }
                        return "";
                    }

                    @Override
                    public int getDecimalDigits() {
                        return 0;
                    }
                });

                Legend l = item.holder.combinedChart.getLegend();
                l.setEnabled(false);

                item.holder.combinedChart.animateY(500, Easing.EasingOption.EaseInSine);

                item.holder.combinedChart.getXAxis().resetAxisMinValue();
                item.holder.combinedChart.getXAxis().resetAxisMinValue();
                item.holder.combinedChart.getXAxis().setAxisMinValue(-0.5f);
                item.holder.combinedChart.getXAxis().setAxisMaxValue(item.entsTotalPlayerStat.size() + 0.5f - 1f);
                item.holder.combinedChart.getXAxis().setLabelCount(item.entsTotalPlayerStat.size());

                item.holder.combinedChart.notifyDataSetChanged();
                item.holder.combinedChart.invalidate();

                item.holder.spinner.setBackgroundResource(R.drawable.pic_spinner_rotate180);

                if (clear_comparing.getVisibility() == View.GONE)
                {
                    del_player_statistics.setVisibility(View.VISIBLE);
                    del_all_statistics.setVisibility(View.GONE);
                }
                item.expanded = true;
            }

            @Override
            public void onCollapse(View itemView, int position)
            {
                AppSettings.getPlayerStatistic().get(position).holder.spinner.setBackgroundResource(R.drawable.pic_spinner);
                if (clear_comparing.getVisibility() == View.GONE)
                {
                    del_player_statistics.setVisibility(View.GONE);
                    del_all_statistics.setVisibility(View.VISIBLE);
                }

                AppSettings.getPlayerStatistic().get(position).expanded = false;
            }
        });

        scrollView_STAT.setAdapter(s);

        statistics_title = (TextView) findViewById(R.id.statistics_title);
        statistics_title.setTypeface(Typeface.create("serif", Typeface.NORMAL));
    }

    public void onBackPressed()
    {
        if(compare_done.getVisibility() == View.VISIBLE)
        {
            compare_done.performClick();
        }
        else
        if(clear_comparing.getVisibility() == View.VISIBLE)
        {
            clear_comparing.performClick();
        }
        else
        {
            startActivity(toHomeActivityIntent);
            finish();
        }
    }

    @Override
    protected void onPause()
    {
        MafiaProjectProApp.setContext(null);
        super.onPause();
    }
}

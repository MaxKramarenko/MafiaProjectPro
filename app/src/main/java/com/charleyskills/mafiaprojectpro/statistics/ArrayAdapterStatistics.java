package com.charleyskills.mafiaprojectpro.statistics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.charleyskills.mafiaprojectpro.AppSettings;
import com.charleyskills.mafiaprojectpro.MafiaProjectProApp;
import com.charleyskills.mafiaprojectpro.R;
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

import java.util.ArrayList;

public class ArrayAdapterStatistics extends ArrayAdapter<ItemPlayerStatistics>
{
    private final Activity context;
    private final ArrayList<ItemPlayerStatistics> items;

    public ArrayAdapterStatistics(Activity context, ArrayList<ItemPlayerStatistics> items)
    {
        super(context, R.layout.activity_statistics, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final ItemPlayerStatistics item = AppSettings.getPlayerStatistic().get(position);
        if (convertView == null)
        {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.item_statistics_layout, null, true);
            item.holder = new ListViewHolder((LinearLayout) convertView.findViewById(R.id.textViewWrap), (TextView) convertView.findViewById(R.id.nickname), (TextView) convertView.findViewById(R.id.totalplayed), (TextView) convertView.findViewById(R.id.percentage),
                    (CombinedChart) convertView.findViewById(R.id.chart), (ImageView) convertView.findViewById(R.id.spinner), (ToggleButton) convertView.findViewById(R.id.checkable),
                    (TextView) convertView.findViewById(R.id.totalplayer), (TextView) convertView.findViewById(R.id.winplayer));
        }
        else
        {
            item.holder = (ListViewHolder) convertView.getTag();
        }

        item.holder.checkable.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                item.checkbox_checked = !item.checkbox_checked;

                if (item.checkbox_checked)
                {
                    int i = 0;
                    for (ItemPlayerStatistics item : AppSettings.getPlayerStatistic())
                    {
                        if(item.checkbox_checked) i++;
                    }

                    if (i == 2)
                    {
                        for (ItemPlayerStatistics item : AppSettings.getPlayerStatistic())
                        {
                            if (!item.checkbox_checked)
                            {
                                if (item.holder != null)
                                {
                                    item.holder.checkable.setVisibility(View.INVISIBLE);
                                }
                                item.checkbox_visibility = View.INVISIBLE;
                            }
                        }
                        ((Activity) MafiaProjectProApp.getContext()).findViewById(R.id.start_compare).setVisibility(View.VISIBLE);
                    }
                }
                else
                {
                    int i = 0;
                    for (ItemPlayerStatistics item : AppSettings.getPlayerStatistic())
                    {
                        if (item.checkbox_checked) i++;
                    }

                    if (i == 1)
                    {
                        for (ItemPlayerStatistics item : AppSettings.getPlayerStatistic())
                        {
                            if (item.holder != null)
                            {
                                item.holder.checkable.setVisibility(View.VISIBLE);
                            }
                            item.checkbox_visibility = View.VISIBLE;
                        }
                        ((Activity) MafiaProjectProApp.getContext()).findViewById(R.id.start_compare).setVisibility(View.GONE);
                    }
                    else
                    if (i == 0)
                    {
                        ((Activity) MafiaProjectProApp.getContext()).findViewById(R.id.start_compare).setVisibility(View.GONE);
                    }
                }

                for (ItemPlayerStatistics item : AppSettings.getPlayerStatistic())
                {
                    if (item.holder != null)
                    {
                        item.holder.checkable.setVisibility(item.checkbox_visibility);
                        item.holder.checkable.setChecked(item.checkbox_checked);
                    }
                }

                notifyDataSetChanged();
            }
        });

        item.entsWinPlayerStat = new ArrayList<>();
        item.entsTotalPlayerStat = new ArrayList<>();

        if (item.playerSherif != 0)
        {
            item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winSherif, new String[]{String.valueOf(item.entsWinPlayerStat.size()), context.getString(R.string.sheriff)}));
            item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerSherif, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), context.getString(R.string.sheriff)}));
        }
        if (item.playerCivilian != 0) {
            item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winCivilian, new String[]{String.valueOf(item.entsWinPlayerStat.size()), context.getString(R.string.civilian)}));
            item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerCivilian, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), context.getString(R.string.civilian)}));
        }
        if (item.playerMafia != 0) {
            item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winMafia, new String[]{String.valueOf(item.entsWinPlayerStat.size()), context.getString(R.string.mafia)}));
            item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerMafia, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), context.getString(R.string.mafia)}));
        }
        if (item.playerGodFather != 0) {
            item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winGodFather, new String[]{String.valueOf(item.entsWinPlayerStat.size()), context.getString(R.string.godfather)}));
            item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerGodFather, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), context.getString(R.string.godfather)}));
        }
        if (item.playerDoctor != 0) {
            item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winDoctor, new String[]{String.valueOf(item.entsWinPlayerStat.size()), context.getString(R.string.doctor)}));
            item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerDoctor, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), context.getString(R.string.doctor)}));
        }
        if (item.playerManiac != 0) {
            item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winManiac, new String[]{String.valueOf(item.entsWinPlayerStat.size()), context.getString(R.string.maniac)}));
            item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerManiac, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), context.getString(R.string.maniac)}));

        }
        if (item.playerWhore != 0) {
            item.entsWinPlayerStat.add(new Entry(item.entsWinPlayerStat.size(), item.winWhore, new String[]{String.valueOf(item.entsWinPlayerStat.size()), context.getString(R.string.whore)}));
            item.entsTotalPlayerStat.add(new BarEntry(item.entsTotalPlayerStat.size(), item.playerWhore, new String[]{String.valueOf(item.entsTotalPlayerStat.size()), context.getString(R.string.whore)}));
        }

        BarDataSet bar_DataSetTotal = new BarDataSet(item.entsTotalPlayerStat, context.getString(R.string.STATActivity_total));
        bar_DataSetTotal.setColor(Color.rgb(255, 0, 0));

        LineDataSet line_DataSet = new LineDataSet(item.entsWinPlayerStat, context.getString(R.string.STATActivity_win));
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

        item.holder.combinedChart.getXAxis().resetAxisMinValue();
        item.holder.combinedChart.getXAxis().resetAxisMinValue();
        item.holder.combinedChart.getXAxis().setAxisMinValue(-0.5f);
        item.holder.combinedChart.getXAxis().setAxisMaxValue(item.entsTotalPlayerStat.size() + 0.5f - 1f);
        item.holder.combinedChart.getXAxis().setLabelCount(item.entsTotalPlayerStat.size());

        item.holder.combinedChart.notifyDataSetChanged();
        item.holder.combinedChart.invalidate();

        item.holder.checkable.setVisibility(item.checkbox_visibility);
        item.holder.checkable.setChecked(item.checkbox_checked);

        item.holder.nickname.setText(String.valueOf(items.get(position).name));
        item.holder.persentage.setText(String.format("%d%% %s", calcProcentWinRate(items.get(position).totalPlayedGames, items.get(position).totalWinPlayedGames), MafiaProjectProApp.getContext().getString(R.string.STATActivity_winlabel)));

        String str = String.valueOf(items.get(position).totalPlayedGames);

        if (str.endsWith("1") && items.get(position).totalPlayedGames != 11)
        {
            item.holder.totalplayed.setText(String.format("%d %s", items.get(position).totalPlayedGames, MafiaProjectProApp.getContext().getString(R.string.STATActivity_Cases_1_win)));
        }
        else
        if ((str.endsWith("2") || str.endsWith("3") || str.endsWith("4")) && (12 > items.get(position).totalPlayedGames || items.get(position).totalPlayedGames > 14))
        {
            item.holder.totalplayed.setText(String.format("%d %s", items.get(position).totalPlayedGames, MafiaProjectProApp.getContext().getString(R.string.STATActivity_Cases_2_4_win)));
        }
        else
        {
            item.holder.totalplayed.setText(String.format("%d %s", items.get(position).totalPlayedGames, MafiaProjectProApp.getContext().getString(R.string.STATActivity_Cases_few_win)));
        }

        item.holder.totalplayer.setText(context.getString(R.string.STATActivity_total));
        item.holder.winplayer.setText(context.getString(R.string.STATActivity_win));

        convertView.setTag(item.holder);

        return convertView;
    }

    public int calcProcentWinRate(int total, int win)
    {
        if (total == 0)
            return 0;

        return (win * 100 / total);
    }

    public static class ListViewHolder
    {
        public LinearLayout textViewWrap;
        public TextView nickname;
        public TextView totalplayed;
        public TextView persentage;

        public CombinedChart combinedChart;

        public CombinedData data;

        public ImageView spinner;

        public ToggleButton checkable;

        public TextView totalplayer;
        public TextView winplayer;

        public ListViewHolder(LinearLayout textViewWrap, TextView nickname, TextView totalplayed, TextView persentage, CombinedChart combinedChart, ImageView spinner, ToggleButton checkable, TextView totalplayer, TextView winplayer) {
            this.textViewWrap = textViewWrap;
            this.nickname = nickname;
            this.totalplayed = totalplayed;
            this.persentage = persentage;
            this.combinedChart = combinedChart;
            this.spinner = spinner;
            this.checkable = checkable;
            this.totalplayer = totalplayer;
            this.winplayer = winplayer;
        }
    }
}

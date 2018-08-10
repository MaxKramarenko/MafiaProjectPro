package com.charleyskills.mafiaprojectpro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.lang.ref.WeakReference;
import java.util.Random;

public class LoadingActivity extends Activity
{
//    private ImageView progbar_loading;
//    private ImageView mafiaproj_loading;
//    private ImageView pic_bullet1_loading;
//    private ImageView pic_bullet2_loading;
    private LinearLayout loading_center;
    private static MediaPlayer[] mp = new MediaPlayer[4];
    private Random r = new Random();

    private static Intent toHomeActivityIntent;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        MafiaProjectProApp.setContext(this);

//        loading_center = (LinearLayout) findViewById(R.id.loading_center);

        overridePendingTransition(R.anim.custom_fade_in, R.anim.custom_fade_out);

        toHomeActivityIntent = new Intent(this, HomeActivity.class);

        if (AppSettings.AnimationMafiaLabel)
        {
            mp[0] = MediaPlayer.create(this, R.raw.godfather);
            mp[1] = MediaPlayer.create(this, R.raw.neapolitano);
            mp[2] = MediaPlayer.create(this, R.raw.shot_1);
            mp[3] = MediaPlayer.create(this, R.raw.shot_2);
            mp[r.nextInt(2)].start();
        }

        new AsyncTaskLoading(this).execute();
    }

    private static int calculateTranslateAnimation(LoadingActivity activity)
    {
        return ((LinearLayout) activity.findViewById(R.id.loading_center)).getTop() + ((ImageView) activity.findViewById(R.id.image_mafiaproject_loading)).getTop() - ((AppSettings.getDisplayHeight() - 252) / 8);
    }

    public void onBackPressed()
    {

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        MafiaProjectProApp.setContext(this);

//        new AsyncTaskLoading(this).execute();
    }

    @Override
    protected void onPause()
    {
        ((ImageView) findViewById(R.id.image_bullet1_loading)).setVisibility(View.INVISIBLE);
        ((ImageView) findViewById(R.id.image_bullet2_loading)).setVisibility(View.INVISIBLE);
//        MafiaProjectProApp.setContext(null);

        super.onPause();
    }

    static class AsyncTaskLoading extends AsyncTask<Void, Integer, Void>
    {
        private WeakReference<LoadingActivity> activityReference;

        AsyncTaskLoading(LoadingActivity context)
        {
            activityReference = new WeakReference<LoadingActivity>(context);
        }

        LinearLayout.LayoutParams parms_progbar_loading;

        private boolean done = false;

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params)
        {
            for (int mProgressStatus = 0; mProgressStatus < 255; mProgressStatus++)
            {
                try
                {
                    Thread.sleep(AppSettings.sleepTime);
                    publishProgress(mProgressStatus);
                }
                catch (InterruptedException e)
                {
                    Logger.e("LoadingActivity", "Interrupted task");
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            super.onProgressUpdate(values);
            parms_progbar_loading = new LinearLayout.LayoutParams(AppSettings.getDP(values[0]), 5);
            parms_progbar_loading.gravity = Gravity.CENTER_HORIZONTAL;

            final LoadingActivity activity = activityReference.get();
            ImageView progbar_loading = activity.findViewById(R.id.image_startprogressbar_loading);
            progbar_loading.setLayoutParams(parms_progbar_loading);

            switch (values[0])
            {
                case 120:
                    if (AppSettings.AnimationMafiaLabel)
                    {
                        ((ImageView) activity.findViewById(R.id.image_bullet1_loading)).setVisibility(View.VISIBLE);
                        mp[2].start();
                    }
                    break;

                case 155:
                    if (AppSettings.AnimationMafiaLabel)
                    {
                        ((ImageView) activity.findViewById(R.id.image_bullet2_loading)).setVisibility(View.VISIBLE);
                        mp[3].start();
                    }
                    break;

                case 180:
                    if (AppSettings.AnimationMafiaLabel)
                    {
                        AppSettings.getGamePresetLayouts();
                    }
                    break;

                case 200:
                    if (AppSettings.AnimationMafiaLabel)
                    {
                        AppSettings.getPlayerStatistic();
                    }
                    break;

                case 254:
                    if (AppSettings.AnimationMafiaLabel)
                    {
                        TranslateAnimation anim = new TranslateAnimation(0, 0, 0, -calculateTranslateAnimation(activity));

                        Animation.AnimationListener listener_anim = new Animation.AnimationListener()
                        {
                            @Override
                            public void onAnimationStart(Animation animation)
                            {
                                ((ImageView) activity.findViewById(R.id.image_bullet1_loading)).setVisibility(View.INVISIBLE);
                                ((ImageView) activity.findViewById(R.id.image_bullet2_loading)).setVisibility(View.INVISIBLE);
                                ((ImageView) activity.findViewById(R.id.image_startprogressbar_loading)).setVisibility(View.INVISIBLE);
                            }

                            @Override
                            public void onAnimationEnd(Animation animation)
                            {
                                activity.startActivity(toHomeActivityIntent);
                                activity.finish();
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation)
                            {

                            }
                        };

                        anim.setAnimationListener(listener_anim);

                        anim.setDuration(1200);
                        anim.setFillAfter(true);

                        ((ImageView) activity.findViewById(R.id.image_mafiaproject_loading)).startAnimation(anim);
                    }
                    else
                    {
                        activity.startActivity(AppSettings.loadingIntent);
                        activity.finish();
                    }
                    setDone();
                    break;
            }
        }

        void setDone()
        {
            done = true;
        }

        private boolean isDone()
        {
            return done;
        }

        boolean my_cancel(boolean mayInterruptIfRunning)
        {
            return !isDone() && super.cancel(mayInterruptIfRunning);
        }
    };
}

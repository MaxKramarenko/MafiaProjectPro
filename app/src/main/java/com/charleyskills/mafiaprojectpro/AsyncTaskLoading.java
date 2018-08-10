package com.charleyskills.mafiaprojectpro;

import android.os.AsyncTask;
class AsyncTaskLoading1
{
    static class AsyncTaskStatic1 extends AsyncTask<Void, Integer, Void>
    {
        private boolean done = false;

        @Override
        protected Void doInBackground(Void... params)
        {
            return null;
        }

        void setDone()
        {
            done = true;
        }

        private boolean isDone()
        {
            return done;
        }

        @Override
        protected void onProgressUpdate(Integer... values)
        {
            super.onProgressUpdate(values);
        }


        boolean my_cancel(boolean mayInterruptIfRunning)
        {
            return !isDone() && super.cancel(mayInterruptIfRunning);
        }
    }

}
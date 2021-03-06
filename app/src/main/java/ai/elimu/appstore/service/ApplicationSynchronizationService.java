package ai.elimu.appstore.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

import ai.elimu.appstore.asynctask.DownloadApplicationsAsyncTask;
import timber.log.Timber;

public class ApplicationSynchronizationService extends JobService {

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Timber.i("onStartJob");

        // Start processing work
        new DownloadApplicationsAsyncTask(getApplicationContext()).execute();
        // TODO: call jobFinished once AsyncTask completes

        boolean isWorkProcessingPending = false;
        return isWorkProcessingPending;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Timber.i("onStopJob");

        // Job execution stopped, even before jobFinished was called.
        // TODO: stop processing work?

        boolean isJobToBeRescheduled = false;
        return isJobToBeRescheduled;
    }
}

package com.example.android_project.data.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.android_project.data.ItemRepositoryImpl
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltWorker
class PeriodWorker @AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted parameters: WorkerParameters,
    val itemRepositoryImpl: ItemRepositoryImpl
):CoroutineWorker(context,parameters) {

    override suspend fun doWork(): Result {
            try {
                CoroutineScope(Dispatchers.IO).launch {
                    Log.w("doWork", "getData")
                    itemRepositoryImpl.getData()
                }
            }catch (e:Exception){
                Log.w("doWorkFail","")
               return Result.retry()
            }
       return Result.success()
    }
    companion object{
        const val WORKER_NAME = "Worker Name"
    }
}
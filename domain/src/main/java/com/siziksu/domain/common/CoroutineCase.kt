package com.siziksu.domain.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class CoroutineCase<R, P> : CoroutineScope, CoroutineCaseContract<R, P> {

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    override fun run(success: (R) -> Unit, error: (Throwable) -> Unit, params: P) {
        if (job.isCancelled) {
            job = Job()
        }
        launch {
            try {
                val result = func(params)
                withContext(Dispatchers.Main) { success(result) }
            } catch (throwable: Throwable) {
                withContext(Dispatchers.Main) { error(throwable) }
            }
        }
    }

    override fun cancel() = job.cancel()
}

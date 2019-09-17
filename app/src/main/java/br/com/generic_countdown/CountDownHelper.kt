package br.com.generic_countdown

import android.os.CountDownTimer

class CountDownHelper {
    interface TimerListener {
        fun onTimerTick(millisUntilFinished: Long){}
        fun onTimerFinish() {}
    }

    private var timer: CountDownTimer? = null
    private var maxTimeInMillis = 3 * 60L * 1000L // 3 minutes default
    private var intervalInMillis = 100L // 0.1 seconds default
    private var timerListener: TimerListener? = null

    fun setMaxTimeInMinutes(minutes: Long): CountDownHelper{
        timer = null
        maxTimeInMillis = minutes * 60L * 1000L
        return this
    }

    fun setMaxTimeInSeconds(seconds: Long): CountDownHelper{
        timer = null
        maxTimeInMillis = seconds * 1000L
        return this
    }

    fun setTimerListener(listener: TimerListener): CountDownHelper {
        this.timerListener = listener
        return this
    }

    fun start() {
        setupCountDown()
        timer?.start()
    }

    fun cancel() {
        timer?.cancel()
    }

    fun reset() {
        timer = null
        start()
    }

    private fun setupCountDown(){
        if(timer == null ){
            timer =  object : CountDownTimer(maxTimeInMillis, intervalInMillis){
                override fun onTick(millisUntilFinished: Long) {
                    timerListener?.onTimerTick(millisUntilFinished)
                }

                override fun onFinish() {
                    timerListener?.onTimerFinish()
                }
            }

        }
    }
}
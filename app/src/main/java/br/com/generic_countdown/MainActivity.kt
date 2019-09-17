package br.com.generic_countdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {

    var startingDate = Calendar.getInstance()
    var endingDate = LocalDate.parse("2019-09-19", DateTimeFormatter.ISO_DATE)
    var ct: CountDownHelper? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Countdown To Future4")
        startCountdown()
    }

    private fun calculateDifferenceOfTimeInMinutes(): Long {
        val diff = endingDate.getEpochMilliseconds() - startingDate.time.time
        return diff/(1000*60)
    }

    private fun startCountdown() {
        if(ct == null) {
            ct = CountDownHelper()
        }
        ct
            ?.setMaxTimeInMinutes(calculateDifferenceOfTimeInMinutes())
            ?.setTimerListener(object : CountDownHelper.TimerListener {
                override fun onTimerTick(millisUntilFinished: Long) {
                    countdownTextTv.text = millisUntilFinished.toHourString()
                }
            })

        ct?.start()
    }
}

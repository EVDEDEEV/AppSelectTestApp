package my.project.appselecttest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import my.project.appselecttest.R
import my.project.appselecttest.data.api.Api

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            val rtt = Api.api.getMovies("otfGYS588CxyRQR1xWPdBHzNlL6U2OeR").body()
            val ano = rtt
            val ona = 3
        }

    }


}
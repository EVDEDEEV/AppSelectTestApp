package my.project.appselecttest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import my.project.appselecttest.Constants.API_KEY
import my.project.appselecttest.R
import my.project.appselecttest.data.api.Api

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            val rtt = Api.api.getMovies(apiKey = API_KEY).body()
            val ano = rtt
            val ona = 3
        }

    }


}
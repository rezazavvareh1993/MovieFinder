package com.example.jokerfinder.activities

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.jokerfinder.Utils.MyConstantClass
import com.example.jokerfinder.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        readFormatType()
        startActivityByDelay()


    }

    private fun readFormatType() {
        val typeFace = Typeface.createFromAsset(assets, "billion_stars_personal_use.ttf")
        txt_movie_finder.text = this.resources.getString(R.string.movie_finder)
        txt_movie_finder.typeface = typeFace
    }

    private fun startActivityByDelay() {
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MovieListActivity::class.java)
            startActivity(intent)
            finish()
        }, MyConstantClass.SPLASH_ACTIVITY_TIME)
    }
}
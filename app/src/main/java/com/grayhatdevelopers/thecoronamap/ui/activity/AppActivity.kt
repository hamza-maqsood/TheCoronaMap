package com.grayhatdevelopers.thecoronamap.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grayhatdevelopers.thecoronamap.R
import com.grayhatdevelopers.thecoronamap.utils.AppConstants
import com.mapbox.mapboxsdk.Mapbox

class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        Mapbox.getInstance(this, AppConstants.MAP_BOX_TOKEN)
    }
}
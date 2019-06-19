package android.demo.usingcloudinary

import android.app.Application
import com.cloudinary.android.MediaManager

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val map = mutableMapOf<String,String>()
        map.put("cloud_name", "dmhc27jim")
        MediaManager.init( applicationContext , map )
    }
}
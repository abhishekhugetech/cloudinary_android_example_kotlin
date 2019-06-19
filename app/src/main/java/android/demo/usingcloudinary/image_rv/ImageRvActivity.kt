package android.demo.usingcloudinary.image_rv

import android.demo.usingcloudinary.ImageList
import android.demo.usingcloudinary.R
import android.demo.usingcloudinary.Util
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_image_rv.*

class ImageRvActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_rv)
        setUpRv()
    }

    private fun setUpRv() {
        val isCacheEnabled = Util.isImageCacheEnabled(this)
        val imageList = ImageList.getImageList()
        val adapter = ImageAdapter( imageList , isCacheEnabled )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}

package android.demo.usingcloudinary

import android.content.Context
import android.content.Intent
import android.demo.usingcloudinary.Util.Companion.isImageCacheEnabled
import android.demo.usingcloudinary.Util.Companion.setImageCacheEnabled
import android.demo.usingcloudinary.image_rv.ImageRvActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cloudinary.android.MediaManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpButtons()
    }

    private fun setUpButtons() {
        openImageRv.setOnClickListener {
            startActivity(Intent( this , ImageRvActivity::class.java ))
        }
        // Set Up the Cache Button
        reDrawButtonText(isImageCacheEnabled(this))
        // Set Up Listener on Cache Button
        disableImageCache.setOnClickListener {
            reDrawButtonText(setImageCacheEnabled(this))
        }
        imageHeight.hint =  "Current Height " + Util.getImageHeight( this ).toString()
        imageWidth.hint =  "Current Width " + Util.getImageWidth( this ).toString()
        setImageHeight.setOnClickListener {
            val height = imageHeight.text
            if (!height.isNullOrEmpty()){
                val current_height:Int? = try {
                    height.toString().toInt()
                }catch (e:Exception){
                    null
                }
                current_height?.let {
                    Util.setImageHeight( this , it )
                    toast("Height Updated")
                }
            }
        }
        setImageWidth.setOnClickListener {
            val width  = imageWidth.text
            if (!width.isNullOrEmpty()){
                val current_width:Int? = try {
                    width.toString().toInt()
                }catch (e:Exception){
                    null
                }
                current_width?.let {
                    Util.setImageWidth( this , it )
                    toast("Width Updated")
                }
            }
        }

    }

    private fun reDrawButtonText(isImageCacheEnabled: Boolean) {
        if (isImageCacheEnabled){
            disableImageCache.text = "Disable Image Cache"
        }else{
            disableImageCache.text = "Enable Image Cache"
        }
    }


    fun Context.toast(message:String){
        Toast.makeText( this , message , Toast.LENGTH_LONG ).show()
    }

}

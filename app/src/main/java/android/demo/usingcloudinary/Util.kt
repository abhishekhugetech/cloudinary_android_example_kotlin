package android.demo.usingcloudinary

import android.content.Context
import android.demo.usingcloudinary.Transformations.getTransformation
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.cloudinary.android.MediaManager

class Util {

    companion object {

        const val IS_CACHE_ENABLED = "IS_CACHE_ENABLED"
        const val IMAGE_WIDTH = "DEFAULT_IMAGE_WIDTH"
        const val DEFAULT_WIDTH = 360
        const val IMAGE_HEIGHT = "DEFAULT_IMAGE_HEIGHT"
        const val DEFAULT_HEIGHT = 240

        fun getSp(context: Context) =
            context.getSharedPreferences( context.packageName , Context.MODE_PRIVATE )

        fun isImageCacheEnabled(context: Context) : Boolean {
            return getSp(context).getBoolean( IS_CACHE_ENABLED , false  )
        }

        fun setImageCacheEnabled(context: Context ) : Boolean{
            val value = !isImageCacheEnabled(context)
            getSp(context).edit().putBoolean( IS_CACHE_ENABLED , value ).apply()
            return value
        }

        fun getImageUrl(imageName:String , context: Context):String{
            return MediaManager.get()
                .url()
                .transformation(getTransformation(context))
                .generate( imageName )
        }

        fun getRequestOption(toUseCache:Boolean) : RequestOptions {
            return if (toUseCache){
                RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
            }else{
                RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true)
            }
        }

        fun getImageWidth(context: Context) : Int {
            return getSp(context).getInt( IMAGE_WIDTH , DEFAULT_WIDTH  )
        }

        fun getImageHeight(context: Context) : Int {
            return getSp(context).getInt( IMAGE_HEIGHT , DEFAULT_HEIGHT  )
        }

        fun setImageWidth(context: Context , width:Int ) {
            getSp(context).edit().putInt( IMAGE_WIDTH , width ).apply()
        }

        fun setImageHeight(context: Context , height:Int ) {
            getSp(context).edit().putInt( IMAGE_HEIGHT , height ).apply()
        }

    }

}
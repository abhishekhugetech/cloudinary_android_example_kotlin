package android.demo.usingcloudinary.image_rv

import android.content.Context
import android.demo.usingcloudinary.R
import android.demo.usingcloudinary.Util
import android.demo.usingcloudinary.Util.Companion.getImageUrl
import android.demo.usingcloudinary.Util.Companion.getRequestOption
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.single_image.view.*

class ImageAdapter(
    private val imageList : List<String>,
    private val toUseCache:Boolean
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private var context:Context? = null
    private val requestOptions: RequestOptions = getRequestOption(toUseCache)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        if (context==null) context = parent.context
        val view = LayoutInflater.from( context ).inflate( R.layout.single_image , parent , false )
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        if (context==null ) return

        val imageUrl = getImageUrl( imageList[position] , context!! )
        Glide.with(context!!)
            .applyDefaultRequestOptions(requestOptions)
            .load(imageUrl)
            .into(holder.itemView.image_src)
        holder.itemView.image_name.text = imageList[position]


    }

    override fun getItemCount(): Int = imageList.size

    class ImageViewHolder(view:View) : RecyclerView.ViewHolder(view)

}
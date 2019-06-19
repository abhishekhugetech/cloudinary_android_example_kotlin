package android.demo.usingcloudinary;

import android.content.Context;
import com.cloudinary.Transformation;

public class Transformations {
    public static Transformation getTransformation(Context context){
        return new Transformation()
                .width(Util.Companion.getImageWidth(context))
                .height(Util.Companion.getImageHeight(context));
    }
}

package sv.com.orderapp.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import sv.com.orderapp.R;

/**
 * Created by Mohan on 5/26/2016.
 */
public class ImageUtil {

    public static void getClientAvatar(ImageView imageView, int indexNo) {
        if (indexNo == -1) {//no such transactor
            Glide.with(imageView.getContext())
                    .load(R.drawable.avatar_client)
                    .fitCenter()
                    .into(imageView);
        } else {
            Glide.with(imageView.getContext())
                    .load(R.drawable.avatar_client)
                    .fitCenter()
                    .into(imageView);
        }
    }
}

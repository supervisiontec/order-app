package sv.com.orderapp.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mohan on 5/24/2016.
 */
public class LayoutBehavior extends CoordinatorLayout.Behavior<CircleImageView> {

    private float startToolbarPosition = 76.0f;

    private Context mContext;


    public LayoutBehavior(Context context, AttributeSet attrs) {
        mContext = context;

//        if (attrs != null) {
//            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AvatarImageBehavior);
//            mCustomFinalYPosition = a.getDimension(R.styleable.AvatarImageBehavior_finalYPosition, 0);
//            mCustomStartXPosition = a.getDimension(R.styleable.AvatarImageBehavior_startXPosition, 0);
//            mCustomStartToolbarPosition = a.getDimension(R.styleable.AvatarImageBehavior_startToolbarPosition, 0);
//            mCustomStartHeight = a.getDimension(R.styleable.AvatarImageBehavior_startHeight, 0);
//            mCustomFinalHeight = a.getDimension(R.styleable.AvatarImageBehavior_finalHeight, 0);
//
//            a.recycle();
//        }
//
//        init();
//
//        mFinalLeftAvatarPadding = context.getResources().getDimension(
//                R.dimen.spacing_normal);
    }

    public boolean onDependentViewChanged(CoordinatorLayout parent, CircleImageView child, View dependency) {
        final int maxScrollDistance = (int) (startToolbarPosition);
        float expandedPercentageFactor = dependency.getY() / maxScrollDistance;

        child.setAlpha(expandedPercentageFactor);

        Log.d("AAAAAAAA", expandedPercentageFactor+"");

        return super.onDependentViewChanged(parent,child,dependency);
    }
}

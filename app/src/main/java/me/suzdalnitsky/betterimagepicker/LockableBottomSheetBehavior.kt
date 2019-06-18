package me.suzdalnitsky.betterimagepicker

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior

class LockableBottomSheetBehavior(context: Context, attrs: AttributeSet) :
    BottomSheetBehavior<View>(context, attrs) {

    var isEnabled = true

    override fun onInterceptTouchEvent(parent: CoordinatorLayout, child: View, event: MotionEvent): Boolean =
        if (!isEnabled) {
            false
        } else {
            super.onInterceptTouchEvent(
                parent,
                child,
                event
            )
        }

    override fun onTouchEvent(parent: CoordinatorLayout, child: View, event: MotionEvent): Boolean {
        return if (!isEnabled) {
            false
        } else {
            super.onTouchEvent(parent, child, event)
        }
    }

    override fun onStopNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View, type: Int) {
        if (isEnabled) super.onStopNestedScroll(coordinatorLayout, child, target, type)
    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
        if (isEnabled) super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
    }

    override fun onStopNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View) {
        if (isEnabled) super.onStopNestedScroll(coordinatorLayout, child, target)
    }

    override fun onNestedPreFling(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        target: View,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        return if (!isEnabled) {
            false
        } else {
            super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY)
        }
    }
}
package me.suzdalnitsky.betterimagepicker

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout

class DropdownBehavior(context: Context, attrs: AttributeSet) :
    CoordinatorLayout.Behavior<AppBarLayout>(context, attrs) {

    override fun layoutDependsOn(parent: CoordinatorLayout, child: AppBarLayout, dependency: View): Boolean {
        return dependency is FrameLayout
    }

    private var gapSizeCalculated = false
    private var gapSize = 0f

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: AppBarLayout, dependency: View): Boolean {
        val margin = child.height
        val currentGap = ((parent.height - dependency.height - dependency.y) * -1) - margin

        if (!gapSizeCalculated) {
            gapSize = currentGap
            gapSizeCalculated = true
        }

        child.y = (margin * (currentGap / gapSize)) * -1
        return true
    }
}
package me.suzdalnitsky.betterimagepicker

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

abstract class ToolbarBottomSheetDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return ToolbarBottomSheetDialog(context!!, theme)
    }
}
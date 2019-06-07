package me.suzdalnitsky.betterimagepicker

import android.app.Dialog
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_image_picker.*

class ImagePickerFragment : ToolbarBottomSheetDialogFragment() {

    private val adapter = Adapter()
    private val generator = RandomColorGenerator()

    override fun setupDialog(dialog: Dialog, style: Int) = with(dialog) {
        setContentView(R.layout.fragment_image_picker)
        list.adapter = adapter
        list.layoutManager = GridLayoutManager(context, 3)
        list.setHasFixedSize(true)
        toolbar.setNavigationOnClickListener { dismiss() }

        setItems()
    }

    private fun setItems() {
        (0..1000).map {
            ListItem(generator.generate())
        }
            .let(adapter::submitList)
    }
}
package me.suzdalnitsky.betterimagepicker

import androidx.annotation.ColorInt
import androidx.recyclerview.widget.DiffUtil

data class ListItem(
    @ColorInt val color: Int
) {

    class DiffCallback : DiffUtil.ItemCallback<ListItem>() {
        
        override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem) = oldItem == newItem
        override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean = true
    }
}


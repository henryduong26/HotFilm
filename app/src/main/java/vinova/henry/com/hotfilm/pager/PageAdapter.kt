package vinova.henry.com.hotfilm.pager

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import vinova.henry.com.hotfilm.R
import vinova.henry.com.hotfilm.models.Movie

class PageAdapter(private val movies: List<Movie>?) : RecyclerView.Adapter<PageItem>() {

    /*private enum class ItemType(val value: Int) {
        USER(1),
        IMAGE(2);

        companion object {
            private val map = ItemType.values().associateBy(ItemType::value)
            fun fromInt(type: Int, defaultValue: ItemType = USER) = map.getOrElse(type, {defaultValue})
        }
    }*/

    override fun getItemCount() = movies?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageItem {
        /*return when (ItemType.fromInt(viewType)) {
            ItemType.USER -> createItemUser(parent)
            ItemType.IMAGE -> createItemImage(parent)
        }*/
        return createItemMovie(parent)
    }

    override fun onBindViewHolder(holder: PageItem, position: Int) {
        when (holder) {
            is ItemMovie -> { holder.setContent(movies?.get(position)) }
        }
    }

    /*override fun getItemViewType(position: Int): Int {
        return (if (position == 1) ItemType.IMAGE else ItemType.USER).value
    }*/

    override fun onViewRecycled(holder: PageItem) {
        super.onViewRecycled(holder)
        holder.clearContent()
    }

    private fun createItemMovie(parent: ViewGroup): ItemMovie {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_cardview, parent, false)
        return ItemMovie(view)
    }

    /*private fun createItemImage(parent: ViewGroup): ItemImage {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_image, parent, false)
        return ItemImage(view)
    }*/
}

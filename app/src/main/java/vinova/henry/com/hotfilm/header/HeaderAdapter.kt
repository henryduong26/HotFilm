package vinova.henry.com.hotfilm.header

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import vinova.henry.com.hotfilm.R
import vinova.henry.com.hotfilm.feature.home.HeaderViewModel
import vinova.henry.com.hotfilm.models.Header
import vinova.henry.com.hotfilm.models.HeaderDataSet
import vinova.henry.com.hotfilm.navigationtoolbar.HeaderLayout

class HeaderAdapter(
        private val count: Int,
        private val headers: List<Header>?,
        overlay: FrameLayout) : HeaderLayout.Adapter<HeaderItem>() {

    private val textsLayout = overlay.findViewById<FrameLayout>(R.id.texts)
    private val linesLayout = overlay.findViewById<FrameLayout>(R.id.lines)

    override fun getItemCount() = count

    override fun onCreateViewHolder(parent: ViewGroup): HeaderItem {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.header_item, parent, false)
        return HeaderItem(view)
    }

    override fun onBindViewHolder(holder: HeaderItem, position: Int) {
        holder.setContent(headers?.get(position), getNextOverlayTitle(), getNextOverlayLine())
    }

    override fun onViewRecycled(holder: HeaderItem) {
        holder.clearContent()
    }

    private fun getNextOverlayTitle(): TextView? {
        for (i in 0 until textsLayout.childCount) {
            val child = textsLayout.getChildAt(i)
            if (child is TextView && child.getTag() == null) {
                return child
            }
        }
        return null
    }

    private fun getNextOverlayLine(): View? {
        for (i in 0 until linesLayout.childCount) {
            val child = linesLayout.getChildAt(i)
            if (child.getTag() == null) {
                return child
            }
        }
        return null
    }
}
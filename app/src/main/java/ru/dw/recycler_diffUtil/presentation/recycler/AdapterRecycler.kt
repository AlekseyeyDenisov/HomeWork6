package ru.dw.recycler_diffUtil.presentation.recycler


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import ru.dw.recycler_diffUtil.domain.Data
import ru.dw.to_dolist.R
import ru.dw.to_dolist.databinding.RecyclerItemEarthBinding
import ru.dw.to_dolist.databinding.RecyclerItemHeaderBinding
import ru.dw.to_dolist.databinding.RecyclerItemMarsBinding


class AdapterRecycler(
    private var onListItemClickListener: OnListItemClickListener
) :
    ListAdapter<Data, AdapterRecycler.ViewHolderShopItem>(RecyclerDiffUtilCallBack()) {
    companion object {
        const val TYPE_EARTH = 1
        const val TYPE_MARS = 2
        const val TYPE_HEADER = 3
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderShopItem {
        val layout = when (viewType) {
            TYPE_EARTH -> {
                RecyclerItemEarthBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            }
            TYPE_MARS -> {
                RecyclerItemMarsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            }
            TYPE_HEADER -> {
                RecyclerItemHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            }
            else -> throw RuntimeException("Unknown view type: $viewType")
        }

        return ViewHolderShopItem(layout)
    }

    override fun onBindViewHolder(holder: ViewHolderShopItem, position: Int) {
        val data = getItem(position)
        when (data.type) {
            TYPE_EARTH ->  holder.bindEarth(data)

            TYPE_MARS ->  holder.bindMars(data)

            TYPE_HEADER -> {}
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }


    inner class ViewHolderShopItem(viewBinding: ViewBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bindEarth(data: Data) {
            RecyclerItemEarthBinding.bind(itemView).apply {
                title.text = data.someText
                descriptionTextView.text = data.someDescription
                earthImageView.load(R.drawable.bg_earth)
                removeItemImageView.setOnClickListener {
                    onListItemClickListener.onRemoveBtnClick(layoutPosition)

                }
                addItemImageView.setOnClickListener {
                    onListItemClickListener.onAddBtnClick(layoutPosition,data)
                }
            }


        }

        fun bindMars(data: Data) {
            RecyclerItemMarsBinding.bind(itemView).apply {
                title.text = data.someText
                marsDescriptionTextView.text = data.someDescription
                marsImageView.load(R.drawable.bg_mars)
                removeItemImageView.setOnClickListener {
                    onListItemClickListener.onRemoveBtnClick(layoutPosition)

                }
                addItemImageView.setOnClickListener {
                    onListItemClickListener.onAddBtnClick(layoutPosition,data)
                }
            }

        }

    }


}



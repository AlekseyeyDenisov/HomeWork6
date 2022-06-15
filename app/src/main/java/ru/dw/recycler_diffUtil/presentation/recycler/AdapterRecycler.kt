package ru.dw.recycler_diffUtil.presentation.recycler


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import coil.load
import ru.dw.recycler_diffUtil.domain.Entities
import ru.dw.recycler_diffUtil.presentation.recycler.helper_callback.ItemTouchHelperAdapter
import ru.dw.to_dolist.R
import ru.dw.to_dolist.databinding.RecyclerItemEarthBinding
import ru.dw.to_dolist.databinding.RecyclerItemHeaderBinding
import ru.dw.to_dolist.databinding.RecyclerItemMarsBinding


class AdapterRecycler(
    private var onListItemClickListener: OnListItemClickListener
) : ListAdapter<Entities, AdapterRecycler.ViewHolderShopItem>(RecyclerDiffUtilCallBack()),
    ItemTouchHelperAdapter {

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
            TYPE_EARTH -> holder.bindEarth(data)

            TYPE_MARS -> holder.bindMars(data)

            TYPE_HEADER -> {}
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type
    }


    inner class ViewHolderShopItem(viewBinding: ViewBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bindEarth(entities: Entities) {
            RecyclerItemEarthBinding.bind(itemView).apply {
                title.text = entities.someText
                descriptionTextView.text = entities.someDescription
                earthImageView.load(R.drawable.bg_earth)
                removeItemImageView.setOnClickListener {
                    onListItemClickListener.onRemoveItem(layoutPosition)

                }
                addItemImageView.setOnClickListener {
                    onListItemClickListener.onAddBtnClick(layoutPosition, entities)
                }
                weightView.setOnClickListener {
                    onListItemClickListener.weightItem(layoutPosition)
                }
            }


        }

        fun bindMars(entities: Entities) {
            RecyclerItemMarsBinding.bind(itemView).apply {
                title.text = entities.someText
                marsImageView.load(R.drawable.bg_mars)
                marsDescriptionTextView.text = itemView.context.getString(R.string.textDescr)

                removeItemImageView.setOnClickListener {
                    onListItemClickListener.onRemoveItem(layoutPosition)

                }
                addItemImageView.setOnClickListener {
                    onListItemClickListener.onAddBtnClick(layoutPosition, entities)
                }
                moveItemUp.setOnClickListener {
                    onListItemClickListener.moveItem(adapterPosition,adapterPosition-1)

                }
                moveItemDown.setOnClickListener {

                    onListItemClickListener.moveItem(adapterPosition,adapterPosition+1)
                }
                marsImageView.setOnClickListener {
                    val visibility = marsDescriptionTextView.visibility
                    marsDescriptionTextView.visibility =
                        if (visibility == View.VISIBLE) View.GONE else View.VISIBLE
                }
                weightView.setOnClickListener {
                    onListItemClickListener.weightItem(layoutPosition)
                }

            }

        }

    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        onListItemClickListener.moveItem(fromPosition,toPosition)
    }

    override fun onItemDismiss(position: Int) {
        onListItemClickListener.onRemoveItem(position)
    }



}



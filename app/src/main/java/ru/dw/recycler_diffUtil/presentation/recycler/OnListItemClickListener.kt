package ru.dw.recycler_diffUtil.presentation.recycler

import ru.dw.recycler_diffUtil.domain.Entities


interface OnListItemClickListener {
    fun onItemClick(entities: Entities)
    fun onAddBtnClick(position: Int, entities: Entities)
    fun onRemoveItem(position: Int)
    fun moveItem(fromPosition: Int,toPosition:Int)
    fun weightItem(position:Int)
}
package ru.dw.recycler_diffUtil.presentation.recycler.helper_callback

interface ItemTouchHelperAdapter {
    fun onItemMove(fromPosition: Int, toPosition: Int)
    fun onItemDismiss(position: Int)
}
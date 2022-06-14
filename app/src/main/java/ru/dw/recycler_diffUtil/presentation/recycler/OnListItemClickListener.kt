package ru.dw.recycler_diffUtil.presentation.recycler

import ru.dw.recycler_diffUtil.domain.Data


interface OnListItemClickListener {
    fun onItemClick(data: Data)
    fun onAddBtnClick(position: Int)
    fun onRemoveBtnClick(position: Int)
}
package ru.dw.recycler_diffUtil.domain

import androidx.lifecycle.LiveData

interface RepositoryList {
    fun addItem(position:Int, entities: Entities)
    fun deleteItem(position:Int)
    fun getList(): LiveData<List<Entities>>
    fun moveItem(fromPosition: Int,toPosition:Int)
    fun addWeight(position:Int)


}
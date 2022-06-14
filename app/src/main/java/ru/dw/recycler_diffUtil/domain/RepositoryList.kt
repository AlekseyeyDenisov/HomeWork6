package ru.dw.recycler_diffUtil.domain

import androidx.lifecycle.LiveData

interface RepositoryList {
    fun addItem(position:Int,data: Data)
    fun deleteItem(position:Int)
    fun getList(): LiveData<List<Data>>
    fun moveItemUp(position:Int)
    fun moveItemDown(position:Int)

}
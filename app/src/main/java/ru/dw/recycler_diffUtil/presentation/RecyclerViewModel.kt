package ru.dw.recycler_diffUtil.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.dw.recycler_diffUtil.data.ListPlanetRepositoryImpl
import ru.dw.recycler_diffUtil.domain.*


class RecyclerViewModel : ViewModel() {
    private val repository = ListPlanetRepositoryImpl
    private val getListUseCase = GetListUseCase(repository)
    private val deleteItemUseCase = DeleteItemUseCase(repository)
    private val addItemUseCase = AddItemUseCase(repository)
    private val moveItemUseCase = MoveItemUseCase(repository)



    val list = getListUseCase.getList()

    fun addItem(position:Int,data: Data){
        addItemUseCase.addItem(position,data)
    }

    fun deleteItem(position:Int){
        Log.d("@@@", "deleteItem: $position")
        deleteItemUseCase.deleteItem(position)
    }
    fun moveItem(fromPosition: Int,toPosition:Int){
        moveItemUseCase.moveItem(fromPosition,toPosition)
    }




}
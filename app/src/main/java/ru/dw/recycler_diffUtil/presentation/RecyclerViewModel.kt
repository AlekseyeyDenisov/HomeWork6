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
    private val weightUseCase = WeightUseCase(repository)



    val list = getListUseCase.getList()

    fun addItem(position:Int, entities: Entities){
        addItemUseCase.addItem(position,entities)
    }

    fun deleteItem(position: Int){
        deleteItemUseCase.deleteItem(position)
    }
    fun moveItem(fromPosition: Int,toPosition:Int){
        moveItemUseCase.moveItem(fromPosition,toPosition)
    }
    fun weightUseCase(position:Int){
        weightUseCase.weightItem(position)
    }




}
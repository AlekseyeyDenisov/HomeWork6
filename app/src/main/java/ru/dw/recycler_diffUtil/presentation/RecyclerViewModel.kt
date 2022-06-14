package ru.dw.recycler_diffUtil.presentation

import androidx.lifecycle.ViewModel
import ru.dw.recycler_diffUtil.data.ListPlanetRepositoryImpl
import ru.dw.recycler_diffUtil.domain.*


class RecyclerViewModel : ViewModel() {
    private val repository = ListPlanetRepositoryImpl
    private val getListUseCase = GetListUseCase(repository)
    private val deleteItemUseCase = DeleteItemUseCase(repository)
    private val addItemUseCase = AddItemUseCase(repository)
    private val moveItemDownUseCase = MoveItemDownUseCase(repository)
    private val moveItemUpUseCase = MoveItemUpUseCase(repository)

    val list = getListUseCase.getList()

    fun addItem(position:Int,data: Data){
        addItemUseCase.addItem(position,data)
    }

    fun deleteItem(position:Int){
        deleteItemUseCase.deleteItem(position)
    }
    fun moveItemDown(position: Int){
        moveItemDownUseCase.moveItemDown(position)
    }
    fun moveItemUp(position: Int){
        moveItemUpUseCase.moveItemUp(position)
    }



}
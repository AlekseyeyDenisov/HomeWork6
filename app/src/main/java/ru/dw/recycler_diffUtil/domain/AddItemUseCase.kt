package ru.dw.recycler_diffUtil.domain

class AddItemUseCase(private val repositoryList: RepositoryList) {
    fun addItem(position:Int, entities: Entities){
        repositoryList.addItem(position,entities)
    }
}
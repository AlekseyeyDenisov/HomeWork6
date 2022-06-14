package ru.dw.recycler_diffUtil.domain

class MoveItemUseCase(private val repositoryList: RepositoryList) {
    fun moveItem(fromPosition: Int,toPosition:Int){
        repositoryList.moveItem(fromPosition,toPosition)
    }
}
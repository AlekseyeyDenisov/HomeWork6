package ru.dw.recycler_diffUtil.domain

class MoveItemUpUseCase(private val repositoryList: RepositoryList) {
    fun moveItemUp(position:Int){
        repositoryList.moveItemUp(position)
    }
}
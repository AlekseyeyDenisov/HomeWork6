package ru.dw.recycler_diffUtil.domain

class MoveItemDownUseCase(private val repositoryList: RepositoryList) {
    fun moveItemDown(position:Int){
        repositoryList.moveItemDown(position)
    }
}
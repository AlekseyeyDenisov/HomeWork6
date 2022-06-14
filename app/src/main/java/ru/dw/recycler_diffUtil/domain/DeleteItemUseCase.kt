package ru.dw.recycler_diffUtil.domain

class DeleteItemUseCase(private val repositoryList: RepositoryList) {
    fun deleteItem(position:Int){
        repositoryList.deleteItem(position)
    }
}
package ru.dw.recycler_diffUtil.domain

class AddItemUseCase(private val repositoryList: RepositoryList) {
    fun addItem(position:Int,data: Data){
        repositoryList.addItem(position,data)
    }
}
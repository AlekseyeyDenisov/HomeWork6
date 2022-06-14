package ru.dw.recycler_diffUtil.domain

import androidx.lifecycle.LiveData

class GetListUseCase(private val repositoryList: RepositoryList) {
    fun getList(): LiveData<List<Data>> {
        return repositoryList.getList()
    }
}
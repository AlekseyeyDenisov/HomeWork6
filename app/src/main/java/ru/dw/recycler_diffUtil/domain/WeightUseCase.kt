package ru.dw.recycler_diffUtil.domain


class WeightUseCase(private val repositoryList: RepositoryList) {
    fun weightItem(position:Int) {
      repositoryList.addWeight(position)
    }
}
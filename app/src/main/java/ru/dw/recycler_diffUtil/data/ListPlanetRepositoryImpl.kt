package ru.dw.recycler_diffUtil.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.dw.recycler_diffUtil.domain.Data
import ru.dw.recycler_diffUtil.domain.RepositoryList
import ru.dw.recycler_diffUtil.presentation.recycler.AdapterRecycler.Companion.TYPE_EARTH
import ru.dw.recycler_diffUtil.presentation.recycler.AdapterRecycler.Companion.TYPE_HEADER
import ru.dw.recycler_diffUtil.presentation.recycler.AdapterRecycler.Companion.TYPE_MARS


object ListPlanetRepositoryImpl : RepositoryList {

    private val listLD = MutableLiveData<List<Data>>()
    private var listPlanet = mutableListOf<Data>()

    init {
        val list = mutableListOf<Data>(
            Data(0, "Header", type = TYPE_HEADER),
            Data(0, "Earth", type = TYPE_EARTH),
            Data(0, "Mars", type = TYPE_MARS),
            Data(0, "Mars", type = TYPE_MARS),
            Data(0, "Earth", type = TYPE_EARTH),
            Data(0, "Mars", type = TYPE_MARS),
            Data(0, "Mars", type = TYPE_MARS)
        )
        listPlanet = list
        updateList()
    }


    override fun addItem(position:Int,data: Data) {
        listPlanet.add(position, data)
        updateList()
    }

    override fun deleteItem(position: Int) {
        listPlanet.removeAt(position)
        updateList()
    }



    override fun getList(): LiveData<List<Data>> {
        return listLD
    }

    private fun updateList() {
        listLD.value = listPlanet.sortedBy { o1 -> o1.id }
    }
}

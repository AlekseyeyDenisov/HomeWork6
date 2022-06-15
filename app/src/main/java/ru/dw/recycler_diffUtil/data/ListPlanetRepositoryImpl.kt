package ru.dw.recycler_diffUtil.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.dw.recycler_diffUtil.domain.Entities
import ru.dw.recycler_diffUtil.domain.RepositoryList
import ru.dw.recycler_diffUtil.presentation.recycler.AdapterRecycler.Companion.TYPE_EARTH
import ru.dw.recycler_diffUtil.presentation.recycler.AdapterRecycler.Companion.TYPE_HEADER
import ru.dw.recycler_diffUtil.presentation.recycler.AdapterRecycler.Companion.TYPE_MARS


object ListPlanetRepositoryImpl : RepositoryList {

    private val listLD = MutableLiveData<List<Entities>>()
    private var listPlanet = mutableListOf<Entities>()
    private var weightCount = 7

    init {
        val list = mutableListOf<Entities>(
            Entities(1, 1000000000,"Header", type = TYPE_HEADER),
            Entities(2, 500,"Earth 1", type = TYPE_EARTH),
            Entities(3, 400,"Mars 2", type = TYPE_MARS, ),
            Entities(4, 300,"Mars 3", type = TYPE_MARS),
            Entities(5, 200,"Earth 4", type = TYPE_EARTH),
            Entities(6, 100,"Mars 5", type = TYPE_MARS),
            Entities(7, 0,"Mars 6", type = TYPE_MARS)
        )
        listPlanet = list
        updateList()
    }


    override fun addItem(position:Int, entities: Entities) {
        entities.weight = entities.weight +100
        entities.someText = "${weightCount ++}"
        listPlanet.add(position, entities)
        updateList()
    }

    override fun deleteItem(position: Int) {
        listPlanet.removeAt(position)
        updateList()
    }

    override fun getList(): LiveData<List<Entities>> {
        return listLD
    }

    override fun moveItem(fromPosition: Int,toPosition:Int) {
        if (toPosition > 0 && listPlanet.size != toPosition){
//            listPlanet.removeAt(fromPosition).apply {
//                listPlanet.add(fromPosition, this)
//            }
            if (fromPosition < toPosition){
                listPlanet[fromPosition].weight = listPlanet[fromPosition].weight - 100
                listPlanet[toPosition].weight = listPlanet[toPosition].weight + 100
            }else{
                listPlanet[fromPosition].weight = listPlanet[fromPosition].weight + 100
                listPlanet[toPosition].weight = listPlanet[toPosition].weight - 100
            }
            updateList()
        }

    }

    override fun addWeight(position: Int) {
        listPlanet[position].weight = listPlanet[position].weight + 100
        updateList()
    }


    private fun updateList() {
        val newSortList = listPlanet.sortedBy{ it.weight }.reversed()
        listPlanet = mutableListOf()
        listPlanet.addAll(newSortList)
        listLD.value = newSortList
    }
}

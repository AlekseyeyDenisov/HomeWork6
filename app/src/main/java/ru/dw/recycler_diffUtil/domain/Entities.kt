package ru.dw.recycler_diffUtil.domain

import ru.dw.recycler_diffUtil.presentation.recycler.AdapterRecycler.Companion.TYPE_MARS


data class Entities(
    var id: Int = 0,
    var weight: Int,
    var someText: String = "Text",
    val someDescription: String? = "Description",
    val type: Int = TYPE_MARS
)


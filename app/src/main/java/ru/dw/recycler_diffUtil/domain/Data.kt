package ru.dw.recycler_diffUtil.domain

import ru.dw.recycler_diffUtil.presentation.recycler.AdapterRecycler.Companion.TYPE_MARS


data class Data(
    var id: Int = 0,
    val someText: String = "Text",
    val someDescription: String? = "Description",
    val type: Int = TYPE_MARS,
    val weight: Int = 0
)


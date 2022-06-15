package ru.dw.recycler_diffUtil.presentation.recycler

import androidx.recyclerview.widget.DiffUtil
import ru.dw.recycler_diffUtil.domain.Entities

class RecyclerDiffUtilCallBack:DiffUtil.ItemCallback<Entities>() {
    override fun areItemsTheSame(entities: Entities, newEntities: Entities): Boolean {
        return entities.id == newEntities.id
    }

    override fun areContentsTheSame(oldEntities: Entities, newEntities: Entities): Boolean {
        return oldEntities == newEntities
    }
}
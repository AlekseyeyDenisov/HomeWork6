package ru.dw.recycler_diffUtil.presentation.recycler

import androidx.recyclerview.widget.DiffUtil
import ru.dw.recycler_diffUtil.domain.Data

class RecyclerDiffUtilCallBack:DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(data: Data, newData: Data): Boolean {
        return data.id == newData.id
    }

    override fun areContentsTheSame(oldData: Data, newData: Data): Boolean {
        return oldData == newData
    }
}
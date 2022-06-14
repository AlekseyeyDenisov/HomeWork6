package ru.dw.recycler_diffUtil.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.dw.recycler_diffUtil.domain.Data
import ru.dw.recycler_diffUtil.presentation.recycler.AdapterRecycler
import ru.dw.recycler_diffUtil.presentation.recycler.AdapterRecycler.Companion.TYPE_EARTH
import ru.dw.recycler_diffUtil.presentation.recycler.AdapterRecycler.Companion.TYPE_HEADER
import ru.dw.recycler_diffUtil.presentation.recycler.AdapterRecycler.Companion.TYPE_MARS
import ru.dw.to_dolist.databinding.FragmentMainBinding

class RecyclerFragment : Fragment() {

    companion object {
        fun newInstance() = RecyclerFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val adapterRecycler = AdapterRecycler()

    private val viewModel: RecyclerViewModel by lazy {
        ViewModelProvider(this)[RecyclerViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler(binding.recyclerView)
        adapterRecycler.submitList(createItemList())
        createItemList().forEach {

        }


    }

    private fun initRecycler(list: RecyclerView) {
        with(list) {
            adapter = adapterRecycler

        }

    }

    private fun createItemList(): List<Data> {
        return listOf(
            Data(0, "Header", type = TYPE_HEADER),
            Data(1, "Earth", type = TYPE_EARTH),
            Data(2, "Mars", type = TYPE_MARS),
            Data(3, "Mars", type = TYPE_MARS),
            Data(4, "Earth", type = TYPE_EARTH),
            Data(5, "Mars", type = TYPE_MARS),
            Data(6, "Mars", type = TYPE_MARS)
        )

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
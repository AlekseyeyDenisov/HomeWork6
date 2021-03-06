package ru.dw.recycler_diffUtil.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import ru.dw.recycler_diffUtil.domain.Entities
import ru.dw.recycler_diffUtil.presentation.recycler.AdapterRecycler
import ru.dw.recycler_diffUtil.presentation.recycler.OnListItemClickListener
import ru.dw.recycler_diffUtil.presentation.recycler.helper_callback.ItemTouchHelperCallback
import ru.dw.to_dolist.databinding.FragmentMainBinding


class RecyclerFragment : Fragment(), OnListItemClickListener {
    private var listEntities:List<Entities> = mutableListOf()

    companion object {
        fun newInstance() = RecyclerFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val adapterRecycler = AdapterRecycler(this)

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
        submitListRecycler()
        search()
    }

    private fun submitListRecycler() {
        viewModel.list.observe(viewLifecycleOwner) {
            adapterRecycler.submitList(it)
            listEntities = it
        }
    }

    private fun search() {
        binding.searchInput.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                val filterData = listEntities.filter {
                    it.someText.lowercase().contains(newText.lowercase())
                }
                adapterRecycler.submitList(filterData)
                return false
            }
        })
    }

    private fun initRecycler(recycler: RecyclerView) {
        with(recycler) {
            adapter = adapterRecycler
        }
        ItemTouchHelper(ItemTouchHelperCallback(adapterRecycler)).attachToRecyclerView(recycler)


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemClick(entities: Entities) {

    }

    override fun onAddBtnClick(position: Int, entities: Entities) {
        viewModel.addItem(position, entities)

    }

    override fun onRemoveItem(position: Int) {
        viewModel.deleteItem(position)

    }


    override fun moveItem(fromPosition: Int, toPosition: Int) {
        viewModel.moveItem(fromPosition, toPosition)
    }

    override fun weightItem(position: Int) {
        viewModel.weightUseCase(position)
    }


}
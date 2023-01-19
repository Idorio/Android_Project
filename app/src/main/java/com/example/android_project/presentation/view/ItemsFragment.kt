package com.example.android_project.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.android_project.ItemsViewModel
import com.example.android_project.R
import com.example.android_project.data.ItemRepositoryImpl
import com.example.android_project.databinding.FragmentItemsBinding
import com.example.android_project.domain.items.ItemInteractor
import com.example.android_project.presentation.adapter.ItemAdapter
import com.example.android_project.lister.ItemListener
import com.example.android_project.model.ItemsModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemsFragment : Fragment(),ItemListener, ItemsView {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var  itemAdapter: ItemAdapter
    private val viewModel: ItemsViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding= FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        itemsPresenter = ItemsPresenter(this, ItemInteractor(ItemRepositoryImpl()))


        itemAdapter = ItemAdapter(this)
        viewBinding.recyclerView.adapter = itemAdapter


        viewModel.getData()
        viewModel.items.observe(viewLifecycleOwner) {list ->
            itemAdapter.submitList(list)
        }
//

        }

    override fun onClick() {
        viewModel.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        viewModel.elementClicked(name, date, imageView)

    }

    override fun dateReceived(listItems: List<ItemsModel>) {
        itemAdapter.submitList(listItems)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context,getString(msg),Toast.LENGTH_SHORT).show()


    }

    override fun goToDetails(name: String, date: String, imageView: Int) {
        val bundle = Bundle()
        bundle.putString("name",name)
        bundle.putString("date",date)
        bundle.putInt("imageView", imageView)


        findNavController().navigate(
            R.id.action_itemsFragment_to_detailsFragment,bundle
        )
    }
}

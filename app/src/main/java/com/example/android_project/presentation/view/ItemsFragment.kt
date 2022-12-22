package com.example.android_project.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.android_project.R
import com.example.android_project.data.ItemRepositoryImpl
import com.example.android_project.databinding.FragmentItemsBinding
import com.example.android_project.domain.items.ItemInteractor
import com.example.android_project.presentation.adapter.ItemAdapter
import com.example.android_project.lister.ItemListener
import com.example.android_project.model.ItemsModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemsFragment : Fragment(),ItemListener, ItemsView{

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var  itemAdapter: ItemAdapter
    @Inject
    private lateinit var itemsPresenter : ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding= FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter.getItems()


        }

    override fun onClick() {

    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {

    }

    override fun dateReceived(listItems: List<ItemsModel>) {

    }

    override fun imageViewClicked(msg: Int) {

    }

    override fun goToDetails(name: String, date: String, imageView: Int) {

    }


}




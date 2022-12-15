package com.example.android_project.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.R
import com.example.android_project.data.ItemRepositoryImpl
import com.example.android_project.databinding.FragmentItemsBinding
import com.example.android_project.databinding.FragmentOnBoardingBinding
import com.example.android_project.domain.ItemInteractor
import com.example.android_project.domain.ItemsRepository
import com.example.android_project.presentation.adapter.ItemAdapter
import com.example.android_project.lister.ItemListener
import com.example.android_project.model.ItemsModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemsFragment : Fragment(),ItemListener, ItemsView {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var  itemAdapter: ItemAdapter

    lateinit var itemsPresenter: ItemsPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding= FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter = ItemsPresenter(this, ItemInteractor(ItemRepositoryImpl()))


        itemAdapter = ItemAdapter(this)
        viewBinding.recyclerView.adapter = itemAdapter

        itemsPresenter.getData()

        }

    override fun onClick() {
        itemsPresenter.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        itemsPresenter.elementSelected(name,date,imageView)

    }

    override fun dateReceived(listItems: List<ItemsModel>) {
        itemAdapter.submitList(listItems)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context,getString(msg),Toast.LENGTH_SHORT).show()


    }

    override fun goToDetails(name: String, date: String, imageView: Int) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("name",name)
        bundle.putString("date",date)
        bundle.putInt("imageView", imageView)
        detailsFragment.arguments = bundle

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            .addToBackStack("Details")
            .commit()

    }
}

package com.example.android_project.presentation.view


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project.ItemsViewModel
import com.example.android_project.NavigateWithBundle
import com.example.android_project.R
import com.example.android_project.presentation.adapter.ItemAdapter
import com.example.android_project.domain.lister.ItemListener
import com.example.android_project.utils.BundleConstants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemListener {

    private lateinit var itemsAdapter: ItemAdapter
    private val viewModel: ItemsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter



        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.item.catch {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }
                .collect{flowList->
                flowList.collect(){list->
                    itemsAdapter.submitList(list)
                }
            }
        }

        viewModel.msg.observe(viewLifecycleOwner){ msg ->
            Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
        }

        viewModel.error.observe(viewLifecycleOwner){
            Log.w("ERRRRR", it)
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.bundle.observe(viewLifecycleOwner){ navBundle ->

            if(navBundle != null){
                val bundle = Bundle()

                bundle.putString(DESCRIPTION, navBundle.description)
                bundle.putString(BundleConstants.IMAGE_VIEW, navBundle.image)

                NavigateWithBundle(BundleConstants.IMAGE_VIEW,R.id.action_itemsFragment_to_detailsFragment,
                    DESCRIPTION)

                viewModel.userNavigated() // в конце навигации говрим вьюмодели что действие выполнено
            }
        }
    }

    override fun onClick() {

        viewModel.imageViewClicked()
    }



    override fun onElementSelected(description: String, image: String) {
        viewModel.elementClicked(description, image, )
    }



    override fun onFavClicked(description: String) {
        TODO("Not yet implemented")
    }

    override suspend fun onDeleteClicked(description: String) {
        viewModel.deleteItem(description)
    }


    //мы можем это использовать, потому что мы видим откуда берётся константа
    companion object {
        const val DESCRIPTION = "description"
    }

}


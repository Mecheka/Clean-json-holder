package com.example.cleanjsonholder

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanjsonholder.databinding.FragmentMainBinding
import com.example.domain.entities.DataEntity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("Fragment ==> ", "On create")
        observe()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun observe() {
        viewModel.loadPosts()

        viewModel.postsLiveData.observe(this) {
            if (it is DataEntity.SUCCESS) {
                context?.let { ctx ->
                    it.data?.let { posts ->
                        val linearLayoutManager =
                            LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false)
                        val divider = DividerItemDecoration(ctx, linearLayoutManager.orientation)
                        binding.recyclerView.apply {
                            layoutManager = linearLayoutManager
                            addItemDecoration(divider)
                            adapter = MainAdapter(posts)
                        }
                    }
                }
            }
        }
    }
}
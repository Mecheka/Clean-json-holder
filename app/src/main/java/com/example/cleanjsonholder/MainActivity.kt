package com.example.cleanjsonholder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanjsonholder.databinding.ActivityMainBinding
import com.example.domain.entities.DataEntity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loadPosts()

        viewModel.postsLiveData.observe(this) {
            if (it is DataEntity.SUCCESS) {
                it.data?.let { posts ->
                    val linearLayoutManager =
                        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                    val divider = DividerItemDecoration(this, linearLayoutManager.orientation)
                    binding.recyclerview.apply {
                        layoutManager = linearLayoutManager
                        addItemDecoration(divider)
                        adapter = MainAdapter(posts)
                    }
                }
            }
        }
    }
}
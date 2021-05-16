package com.example.cleanjsonholder

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.mockito.kotlin.reset

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
abstract class ViewModelTest<VM: ViewModel> {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val mainThread = newSingleThreadContext("Main")

    protected lateinit var viewModel: VM
    protected abstract fun createViewModel(): VM

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThread)
        viewModel = createViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThread.close()
    }
}
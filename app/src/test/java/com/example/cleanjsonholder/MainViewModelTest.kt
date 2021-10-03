package com.example.cleanjsonholder

import androidx.lifecycle.Observer
import com.example.domain.entities.DataEntity
import com.example.domain.entities.ErrorEntity
import com.example.domain.entities.PostsEntity
import com.example.domain.repository.PostsRepository
import com.example.domain.usecase.GetPostsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class MainViewModelTest : ViewModelTest<MainViewModel>() {

    private val repository: PostsRepository = mock()

    override fun createViewModel(): MainViewModel =
        MainViewModel(GetPostsUseCase(repository))

    @Test
    fun `Test get posts list success`() {

        val postsMock = DataEntity.SUCCESS(listOf(PostsEntity("body", 1, "title", 2)))

        runBlockingTest {
            whenever(repository.getPosts()).thenReturn(flow {
                emit(postsMock)
            })
        }

        viewModel.loadPosts()
        val observerPosts = mock<Observer<DataEntity<List<PostsEntity>>>>()
        viewModel.postsLiveData.observeForever(observerPosts)

        verify(observerPosts).onChanged(postsMock)
    }

    @Test
    fun `Test get posts list fail`() {

        val postsMock = DataEntity.ERROR<List<PostsEntity>>(ErrorEntity("ERROR"))

        runBlockingTest {
            whenever(repository.getPosts()).thenReturn(flow {
                emit(postsMock)
            })
        }

        viewModel.loadPosts()
        val observerPosts = mock<Observer<DataEntity<List<PostsEntity>>>>()
        viewModel.postsLiveData.observeForever(observerPosts)

        verify(observerPosts).onChanged(postsMock)
    }
}
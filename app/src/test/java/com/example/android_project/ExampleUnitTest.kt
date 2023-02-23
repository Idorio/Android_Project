package com.example.android_project

import com.example.android_project.data.ApiService
import com.example.android_project.data.ItemRepositoryImpl
import com.example.android_project.data.data_base.ItemsEntity
import com.example.android_project.data.data_base.dao.ItemsDAO
import com.example.android_project.data.model.ItemsResponce
import com.example.android_project.domain.ItemsRepository
import com.example.android_project.model.ItemsModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.createTestCoroutineScope
import okhttp3.Response
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


class ExampleUnitTest {

    lateinit var itemsRepository: ItemsRepository

    @Mock//инициализация
    lateinit var apiService: ApiService
    @Mock//инициализация
    lateinit var itemsDAO: ItemsDAO
    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        itemsRepository = ItemRepositoryImpl(apiService,itemsDAO)
    }

    @Test
    fun `getData request successful`(){

        val response = retrofit2.Response.success(ItemsResponce(listOf()))
        createTestCoroutineScope(TestCoroutineScope().testScheduler).launch {
            Mockito.`when`(apiService.getData()).thenReturn(response)

            itemsRepository.getData()

            verify(apiService, only()).getData()

        }

    }
    @Test
    fun `showData gave from database successful`(){
        val itemsEntity = listOf(ItemsEntity(0,", ", ""))

        runBlocking {
            `when`(itemsDAO.getItemsEntity()).thenReturn(itemsEntity)
            itemsRepository.getData()
            verify(apiService, only()).getData()
        }
    }
//    @Test(expected = Exception::class)
//    fun `showData gave from database error`(){
//        val itemsEntity = listOf(ItemsEntity(0,", ", ""))
//
//        runBlocking {
//            `when`(itemsDAO.getItemsEntity()).thenThrow(java.lang.RuntimeException())
//            itemsRepository.showData()
//            verify(itemsDAO, never()).getItemsEntity()
//        }
//    }

}




package com.immortalalexsan.cleanarchitecture

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.gson.GsonBuilder
import com.immortalalexsan.cleanarchitecture.core.app.ClearArchitectureApp
import com.immortalalexsan.cleanarchitecture.data.network.entities.RemoteAuthor
import com.immortalalexsan.cleanarchitecture.data.network.entities.RemoteBook
import com.immortalalexsan.cleanarchitecture.di.components.DaggerTestAppComponent
import com.immortalalexsan.cleanarchitecture.domain.boudaries.BooksBoundary
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import java.net.HttpURLConnection
import javax.inject.Inject
import javax.inject.Named

@RunWith(AndroidJUnit4::class)
class ApiServiceTest {

    @Inject
    lateinit var mockServer: MockWebServer

    @Inject
    @Named("TestBooksRepository")
    lateinit var testBooksBoundary: BooksBoundary

    @Before
    fun setup() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as ClearArchitectureApp
        DaggerTestAppComponent.builder()
            .application(app)
            .build()
            .inject(this)
    }

    @After
    fun teardown() {
        mockServer.shutdown()
    }

    @Test
    fun getBookSuccessfulTest() {
        val gson = GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()

        val book = RemoteBook(50, "Title", "Description", RemoteAuthor("Name", "Surname"))
        val body = gson.toJson(book)

        val mockResponse = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(body)

        mockServer.enqueue(mockResponse)
        testBooksBoundary.getBook(50).blockingGet()
    }

    @Ignore("Stub")
    @Test
    fun getBookServerErrorTest() {
        testBooksBoundary.getBook(101).blockingGet()
    }

    @Ignore("Stub")
    @Test
    fun getBooksSuccessfulTest() {
        testBooksBoundary.getBooks(10, 1).blockingGet()
    }
}

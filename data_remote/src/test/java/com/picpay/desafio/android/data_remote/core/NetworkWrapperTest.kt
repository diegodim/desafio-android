package com.picpay.desafio.android.data_remote.core

import com.picpay.desafio.android.core.commons.exception.BadRequestException
import com.picpay.desafio.android.core.commons.exception.NotFoundException
import com.picpay.desafio.android.core.commons.exception.UnauthorizedException
import com.picpay.desafio.android.core.commons.exception.UnknownException
import com.picpay.desafio.android.data_remote.ContactsFactory.CONTACTS_RESPONSE
import com.picpay.desafio.android.data_remote.core.NetworkWrapper.StatusCode.BAD_REQUEST
import com.picpay.desafio.android.data_remote.core.NetworkWrapper.StatusCode.NOT_AUTHORIZED
import com.picpay.desafio.android.data_remote.core.NetworkWrapper.StatusCode.NOT_FOUND
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class NetworkWrapperTest {

    private lateinit var networkWrapper: NetworkWrapper

    @Before
    fun setup() {
        networkWrapper = NetworkWrapper()
    }

    @Test
    fun `WHEN networkWrapper has SUCCESS response MUST return the data`(): Unit = runBlocking {

        val response = Response.success(200, CONTACTS_RESPONSE)

        val result = networkWrapper { response }

        Assert.assertEquals(result, CONTACTS_RESPONSE)
    }

    @Test(expected = UnknownException::class)
    fun `WHEN networkWrapper has UNKNOWN failure MUST throw the UnknownException`(): Unit = runBlocking {
        val response = Response.error<Unit>(500, byteArrayOf().toResponseBody())

        networkWrapper { response }
    }

    @Test(expected = BadRequestException::class)
    fun `WHEN networkWrapper has BAD REQUEST request MUST throw the BadRequestException`(): Unit = runBlocking {
        val response = Response.error<Unit>(BAD_REQUEST, byteArrayOf().toResponseBody())

        networkWrapper { response }
    }

    @Test(expected = NotFoundException::class)
    fun `WHEN networkWrapper has NOT FOUND request MUST throw the NotFoundException`(): Unit = runBlocking {
        val response = Response.error<Unit>(NOT_FOUND, byteArrayOf().toResponseBody())

        networkWrapper { response }
    }

    @Test(expected = UnauthorizedException::class)
    fun `WHEN networkWrapper has NOT AUTHORIZED request MUST throw the UnauthorizedException`(): Unit = runBlocking {
        val response = Response.error<Unit>(NOT_AUTHORIZED, byteArrayOf().toResponseBody())

        networkWrapper { response }
    }
}

package com.example.exam9.network

import com.example.exam9.model.Education
import retrofit2.Response
import retrofit2.http.GET

interface EducationApi {
    @GET("29db8caa-95cb-44be-aa3c-eee0aa406870")
    suspend fun getEducation():Response<Education>
}
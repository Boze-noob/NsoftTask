package com.applid.nsofttask.domain.use_cases

import com.applid.nsofttask.common.Resource
import com.applid.nsofttask.domain.models.RepositoryModel
import com.applid.nsofttask.domain.repositories.GitHubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRepositoryDetailsUseCase @Inject constructor(
    private val gitHubRepository: GitHubRepository
){
    operator fun invoke() : Flow<Resource<>> = flow {
        try {

        } catch (e : HttpException) {
            emit(Resource.Error<List<RepositoryModel>>(message = e.localizedMessage ?: "An unexpected error happen, try again later"))
        } catch (e : IOException) {
            emit(Resource.Error<List<RepositoryModel>>(message = e.localizedMessage ?: "Error happen, check your internet connection"))
        }

    }
}
package com.applid.nsofttask.domain.use_cases

import com.applid.nsofttask.common.Resource
import com.applid.nsofttask.data.api.dto.toRepositoryModel
import com.applid.nsofttask.domain.models.RepositoryModel
import com.applid.nsofttask.domain.repositories.GitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllRepositoriesUseCase @Inject constructor(
    private val gitRepository: GitRepository
){
    operator fun invoke() : Flow<Resource<List<RepositoryModel>>> = flow {
        try{
            emit(Resource.Loading<List<RepositoryModel>>())
            val result = gitRepository.getAllRepositories().map { it.toRepositoryModel() }
            emit(Resource.Success<List<RepositoryModel>>(result))
        } catch (e : HttpException) {
            emit(Resource.Error<List<RepositoryModel>>(message = e.localizedMessage ?: "An unexpected error happen, try again later"))
        } catch (e : IOException) {
            emit(Resource.Error<List<RepositoryModel>>(message = e.localizedMessage ?: "Error happen, check your internet connection"))
        }
    }
}
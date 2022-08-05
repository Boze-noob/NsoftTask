package com.applid.nsofttask.domain.use_cases

import com.applid.nsofttask.common.Resource
import com.applid.nsofttask.data.api.dto.toRepositoryModel
import com.applid.nsofttask.domain.models.RepositoryModel
import com.applid.nsofttask.domain.repositories.GitHubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject

class GetRepositoriesByNameUseCase @Inject constructor(
    private val githubRepository: GitHubRepository
){
    operator fun invoke(name : String) : Flow<Resource<List<RepositoryModel>>> = flow {
        try{
            emit(Resource.Loading<List<RepositoryModel>>())
            val result = githubRepository.getRepositoriesByName(name = name).toRepositoryModel()
            emit(Resource.Success<List<RepositoryModel>>(result))
        } catch (e : HttpException) {
            emit(Resource.Error<List<RepositoryModel>>(message = e.localizedMessage ?: "An unexpected error happen, try again later"))
        } catch (e : IOException) {
            emit(Resource.Error<List<RepositoryModel>>(message = e.localizedMessage ?: "Error happen, check your internet connection"))
        } catch (e : UnknownHostException) {
            emit(Resource.Error<List<RepositoryModel>>(message = e.localizedMessage ?: "Error happen, check your internet connection"))
        }
    }
}
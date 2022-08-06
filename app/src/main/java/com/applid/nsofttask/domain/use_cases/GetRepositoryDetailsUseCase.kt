package com.applid.nsofttask.domain.use_cases

import com.applid.nsofttask.common.Resource
import com.applid.nsofttask.data.api.dto.toRepositoryContributorModel
import com.applid.nsofttask.data.api.dto.toRepositoryDetailsModel
import com.applid.nsofttask.domain.models.RepositoryDetailsModel
import com.applid.nsofttask.domain.repositories.GitHubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRepositoryDetailsUseCase @Inject constructor(
    private val gitHubRepository: GitHubRepository
){
    operator fun invoke(owner : String, name : String) : Flow<Resource<RepositoryDetailsModel>> = flow {
        try {
            emit(Resource.Loading<RepositoryDetailsModel>())
            val repositoryDetailsModelDto = gitHubRepository.getRepositoryDetails(owner = owner, name = name )
            var result = repositoryDetailsModelDto.toRepositoryDetailsModel()
            if(repositoryDetailsModelDto.contributors_url.isNotEmpty())
            {
                val contributorsDto = gitHubRepository.getRepositoryContributors(repositoryDetailsModelDto.contributors_url)
                result.contributors = contributorsDto.map { it.toRepositoryContributorModel() }
            }
            emit(Resource.Success<RepositoryDetailsModel>(result))
        } catch (e : HttpException) {
            emit(Resource.Error<RepositoryDetailsModel>(message = e.localizedMessage ?: "An unexpected error happen, try again later"))
        } catch (e : IOException) {
            emit(Resource.Error<RepositoryDetailsModel>(message = e.localizedMessage ?: "Error happen, check your internet connection"))
        }
    }
}
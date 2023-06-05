package vero.practicaandroidavanzado5datalocal.modules


import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import vero.practicaandroidavanzado5datalocal.data.RepositoryImpl
import vero.practicaandroidavanzado5datalocal.data.local.LocalDataSource
import vero.practicaandroidavanzado5datalocal.data.local.LocalDataSourceImpl
import vero.practicaandroidavanzado5datalocal.data.remote.RemoteDataSource
import vero.practicaandroidavanzado5datalocal.data.remote.RemoteDataSourceImpl
import vero.practicaandroidavanzado5datalocal.domain.Repository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl): Repository

    @Binds
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

}

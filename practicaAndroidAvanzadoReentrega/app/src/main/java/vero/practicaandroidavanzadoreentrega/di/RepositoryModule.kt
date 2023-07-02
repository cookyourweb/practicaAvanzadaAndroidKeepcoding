package vero.practicaandroidavanzadoreentrega.di

import vero.practicaandroidavanzadoreentrega.data.RepositoryImpl
import vero.practicaandroidavanzadoreentrega.data.local.LocalDataSource
import vero.practicaandroidavanzadoreentrega.data.local.LocalDataSourceImpl
import vero.practicaandroidavanzadoreentrega.data.remote.RemoteDataSource
import vero.practicaandroidavanzadoreentrega.data.remote.RemoteDataSourceImpl
import vero.practicaandroidavanzadoreentrega.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

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

package vero.practicaandroidavanzado2.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import vero.practicaandroidavanzado2.data.RepositoryImpl;
import vero.practicaandroidavanzado2.data.local.LocalDataSourceImpl;
import vero.practicaandroidavanzado2.data.mappers.LocalToPresentationMapper;
import vero.practicaandroidavanzado2.data.mappers.RemoteToLocalMapper;
import vero.practicaandroidavanzado2.data.remote.RemoteDataSource;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class RepositoryModule_Companion_ProvidesRepositoryImplFactory implements Factory<RepositoryImpl> {
  private final Provider<LocalDataSourceImpl> localDataSourceProvider;

  private final Provider<RemoteDataSource> remoteDataSourceProvider;

  private final Provider<LocalToPresentationMapper> localToPresentationMapperProvider;

  private final Provider<RemoteToLocalMapper> remoteToLocalMapperProvider;

  public RepositoryModule_Companion_ProvidesRepositoryImplFactory(
      Provider<LocalDataSourceImpl> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider,
      Provider<LocalToPresentationMapper> localToPresentationMapperProvider,
      Provider<RemoteToLocalMapper> remoteToLocalMapperProvider) {
    this.localDataSourceProvider = localDataSourceProvider;
    this.remoteDataSourceProvider = remoteDataSourceProvider;
    this.localToPresentationMapperProvider = localToPresentationMapperProvider;
    this.remoteToLocalMapperProvider = remoteToLocalMapperProvider;
  }

  @Override
  public RepositoryImpl get() {
    return providesRepositoryImpl(localDataSourceProvider.get(), remoteDataSourceProvider.get(), localToPresentationMapperProvider.get(), remoteToLocalMapperProvider.get());
  }

  public static RepositoryModule_Companion_ProvidesRepositoryImplFactory create(
      Provider<LocalDataSourceImpl> localDataSourceProvider,
      Provider<RemoteDataSource> remoteDataSourceProvider,
      Provider<LocalToPresentationMapper> localToPresentationMapperProvider,
      Provider<RemoteToLocalMapper> remoteToLocalMapperProvider) {
    return new RepositoryModule_Companion_ProvidesRepositoryImplFactory(localDataSourceProvider, remoteDataSourceProvider, localToPresentationMapperProvider, remoteToLocalMapperProvider);
  }

  public static RepositoryImpl providesRepositoryImpl(LocalDataSourceImpl localDataSource,
      RemoteDataSource remoteDataSource, LocalToPresentationMapper localToPresentationMapper,
      RemoteToLocalMapper remoteToLocalMapper) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.Companion.providesRepositoryImpl(localDataSource, remoteDataSource, localToPresentationMapper, remoteToLocalMapper));
  }
}

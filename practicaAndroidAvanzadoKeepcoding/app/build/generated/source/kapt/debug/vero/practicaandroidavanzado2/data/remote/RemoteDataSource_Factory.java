package vero.practicaandroidavanzado2.data.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class RemoteDataSource_Factory implements Factory<RemoteDataSource> {
  private final Provider<DragonBallApi> apiProvider;

  public RemoteDataSource_Factory(Provider<DragonBallApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public RemoteDataSource get() {
    return newInstance(apiProvider.get());
  }

  public static RemoteDataSource_Factory create(Provider<DragonBallApi> apiProvider) {
    return new RemoteDataSource_Factory(apiProvider);
  }

  public static RemoteDataSource newInstance(DragonBallApi api) {
    return new RemoteDataSource(api);
  }
}

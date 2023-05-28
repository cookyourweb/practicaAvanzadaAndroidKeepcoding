package vero.practicaandroidavanzado2.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;
import vero.practicaandroidavanzado2.data.remote.DragonBallApi;

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
public final class NetworkModule_ProvidesApiFactory implements Factory<DragonBallApi> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvidesApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public DragonBallApi get() {
    return providesApi(retrofitProvider.get());
  }

  public static NetworkModule_ProvidesApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvidesApiFactory(retrofitProvider);
  }

  public static DragonBallApi providesApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.providesApi(retrofit));
  }
}

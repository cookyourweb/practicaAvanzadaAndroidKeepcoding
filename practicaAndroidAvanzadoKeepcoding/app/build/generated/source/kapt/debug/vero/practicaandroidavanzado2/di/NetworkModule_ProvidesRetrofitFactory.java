package vero.practicaandroidavanzado2.di;

import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

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
public final class NetworkModule_ProvidesRetrofitFactory implements Factory<Retrofit> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<Moshi> moshiProvider;

  public NetworkModule_ProvidesRetrofitFactory(Provider<OkHttpClient> okHttpClientProvider,
      Provider<Moshi> moshiProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
    this.moshiProvider = moshiProvider;
  }

  @Override
  public Retrofit get() {
    return providesRetrofit(okHttpClientProvider.get(), moshiProvider.get());
  }

  public static NetworkModule_ProvidesRetrofitFactory create(
      Provider<OkHttpClient> okHttpClientProvider, Provider<Moshi> moshiProvider) {
    return new NetworkModule_ProvidesRetrofitFactory(okHttpClientProvider, moshiProvider);
  }

  public static Retrofit providesRetrofit(OkHttpClient okHttpClient, Moshi moshi) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.providesRetrofit(okHttpClient, moshi));
  }
}

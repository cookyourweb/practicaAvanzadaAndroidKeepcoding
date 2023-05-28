package vero.practicaandroidavanzado2.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;

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
public final class NetworkModule_ProvidesOkhttpFactory implements Factory<OkHttpClient> {
  @Override
  public OkHttpClient get() {
    return providesOkhttp();
  }

  public static NetworkModule_ProvidesOkhttpFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static OkHttpClient providesOkhttp() {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.providesOkhttp());
  }

  private static final class InstanceHolder {
    private static final NetworkModule_ProvidesOkhttpFactory INSTANCE = new NetworkModule_ProvidesOkhttpFactory();
  }
}

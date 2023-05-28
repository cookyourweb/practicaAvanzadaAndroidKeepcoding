package vero.practicaandroidavanzado2.di;

import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class NetworkModule_ProvidesMoshiFactory implements Factory<Moshi> {
  @Override
  public Moshi get() {
    return providesMoshi();
  }

  public static NetworkModule_ProvidesMoshiFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Moshi providesMoshi() {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.providesMoshi());
  }

  private static final class InstanceHolder {
    private static final NetworkModule_ProvidesMoshiFactory INSTANCE = new NetworkModule_ProvidesMoshiFactory();
  }
}

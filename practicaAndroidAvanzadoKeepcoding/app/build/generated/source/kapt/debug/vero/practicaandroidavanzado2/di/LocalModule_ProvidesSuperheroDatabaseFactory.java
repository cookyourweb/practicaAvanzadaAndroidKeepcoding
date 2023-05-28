package vero.practicaandroidavanzado2.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import vero.practicaandroidavanzado2.data.local.SuperheroDatabase;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class LocalModule_ProvidesSuperheroDatabaseFactory implements Factory<SuperheroDatabase> {
  private final Provider<Context> contextProvider;

  public LocalModule_ProvidesSuperheroDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SuperheroDatabase get() {
    return providesSuperheroDatabase(contextProvider.get());
  }

  public static LocalModule_ProvidesSuperheroDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new LocalModule_ProvidesSuperheroDatabaseFactory(contextProvider);
  }

  public static SuperheroDatabase providesSuperheroDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(LocalModule.INSTANCE.providesSuperheroDatabase(context));
  }
}

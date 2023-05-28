package vero.practicaandroidavanzado2.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import vero.practicaandroidavanzado2.data.local.SuperheroDAO;
import vero.practicaandroidavanzado2.data.local.SuperheroDatabase;

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
public final class LocalModule_ProvidesDaoFactory implements Factory<SuperheroDAO> {
  private final Provider<SuperheroDatabase> dbProvider;

  public LocalModule_ProvidesDaoFactory(Provider<SuperheroDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public SuperheroDAO get() {
    return providesDao(dbProvider.get());
  }

  public static LocalModule_ProvidesDaoFactory create(Provider<SuperheroDatabase> dbProvider) {
    return new LocalModule_ProvidesDaoFactory(dbProvider);
  }

  public static SuperheroDAO providesDao(SuperheroDatabase db) {
    return Preconditions.checkNotNullFromProvides(LocalModule.INSTANCE.providesDao(db));
  }
}

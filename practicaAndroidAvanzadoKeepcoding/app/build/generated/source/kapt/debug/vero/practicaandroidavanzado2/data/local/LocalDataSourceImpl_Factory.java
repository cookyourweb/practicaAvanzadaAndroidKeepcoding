package vero.practicaandroidavanzado2.data.local;

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
public final class LocalDataSourceImpl_Factory implements Factory<LocalDataSourceImpl> {
  private final Provider<SuperheroDAO> daoProvider;

  public LocalDataSourceImpl_Factory(Provider<SuperheroDAO> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public LocalDataSourceImpl get() {
    return newInstance(daoProvider.get());
  }

  public static LocalDataSourceImpl_Factory create(Provider<SuperheroDAO> daoProvider) {
    return new LocalDataSourceImpl_Factory(daoProvider);
  }

  public static LocalDataSourceImpl newInstance(SuperheroDAO dao) {
    return new LocalDataSourceImpl(dao);
  }
}

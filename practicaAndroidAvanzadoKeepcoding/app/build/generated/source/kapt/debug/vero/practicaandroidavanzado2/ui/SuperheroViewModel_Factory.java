package vero.practicaandroidavanzado2.ui;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import vero.practicaandroidavanzado2.data.Repository;

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
public final class SuperheroViewModel_Factory implements Factory<SuperheroViewModel> {
  private final Provider<Repository> repositoryProvider;

  public SuperheroViewModel_Factory(Provider<Repository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SuperheroViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static SuperheroViewModel_Factory create(Provider<Repository> repositoryProvider) {
    return new SuperheroViewModel_Factory(repositoryProvider);
  }

  public static SuperheroViewModel newInstance(Repository repository) {
    return new SuperheroViewModel(repository);
  }
}

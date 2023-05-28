package vero.practicaandroidavanzado2.data.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class LocalToPresentationMapper_Factory implements Factory<LocalToPresentationMapper> {
  @Override
  public LocalToPresentationMapper get() {
    return newInstance();
  }

  public static LocalToPresentationMapper_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static LocalToPresentationMapper newInstance() {
    return new LocalToPresentationMapper();
  }

  private static final class InstanceHolder {
    private static final LocalToPresentationMapper_Factory INSTANCE = new LocalToPresentationMapper_Factory();
  }
}

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
public final class RemoteToLocalMapper_Factory implements Factory<RemoteToLocalMapper> {
  @Override
  public RemoteToLocalMapper get() {
    return newInstance();
  }

  public static RemoteToLocalMapper_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static RemoteToLocalMapper newInstance() {
    return new RemoteToLocalMapper();
  }

  private static final class InstanceHolder {
    private static final RemoteToLocalMapper_Factory INSTANCE = new RemoteToLocalMapper_Factory();
  }
}

package breon.telematics.loneworkersafetyapp.android.data.repository;

import breon.telematics.loneworkersafetyapp.android.data.source.remote.BreonDataSource;
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
public final class BreonRepositoryImpl_Factory implements Factory<BreonRepositoryImpl> {
  private final Provider<BreonDataSource> breonDataSourceProvider;

  public BreonRepositoryImpl_Factory(Provider<BreonDataSource> breonDataSourceProvider) {
    this.breonDataSourceProvider = breonDataSourceProvider;
  }

  @Override
  public BreonRepositoryImpl get() {
    return newInstance(breonDataSourceProvider.get());
  }

  public static BreonRepositoryImpl_Factory create(
      Provider<BreonDataSource> breonDataSourceProvider) {
    return new BreonRepositoryImpl_Factory(breonDataSourceProvider);
  }

  public static BreonRepositoryImpl newInstance(BreonDataSource breonDataSource) {
    return new BreonRepositoryImpl(breonDataSource);
  }
}

package vero.practicaandroidavanzado2.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\b"}, d2 = {"Lvero/practicaandroidavanzado2/di/RepositoryModule;", "", "()V", "bindsRepository", "Lvero/practicaandroidavanzado2/data/Repository;", "repositoryImpl", "Lvero/practicaandroidavanzado2/data/RepositoryImpl;", "Companion", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    @org.jetbrains.annotations.NotNull
    public static final vero.practicaandroidavanzado2.di.RepositoryModule.Companion Companion = null;
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract vero.practicaandroidavanzado2.data.Repository bindsRepository(@org.jetbrains.annotations.NotNull
    vero.practicaandroidavanzado2.data.RepositoryImpl repositoryImpl);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u00a8\u0006\r"}, d2 = {"Lvero/practicaandroidavanzado2/di/RepositoryModule$Companion;", "", "()V", "providesRepositoryImpl", "Lvero/practicaandroidavanzado2/data/RepositoryImpl;", "localDataSource", "Lvero/practicaandroidavanzado2/data/local/LocalDataSourceImpl;", "remoteDataSource", "Lvero/practicaandroidavanzado2/data/remote/RemoteDataSource;", "localToPresentationMapper", "Lvero/practicaandroidavanzado2/data/mappers/LocalToPresentationMapper;", "remoteToLocalMapper", "Lvero/practicaandroidavanzado2/data/mappers/RemoteToLocalMapper;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @dagger.Provides
        @org.jetbrains.annotations.NotNull
        public final vero.practicaandroidavanzado2.data.RepositoryImpl providesRepositoryImpl(@org.jetbrains.annotations.NotNull
        vero.practicaandroidavanzado2.data.local.LocalDataSourceImpl localDataSource, @org.jetbrains.annotations.NotNull
        vero.practicaandroidavanzado2.data.remote.RemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull
        vero.practicaandroidavanzado2.data.mappers.LocalToPresentationMapper localToPresentationMapper, @org.jetbrains.annotations.NotNull
        vero.practicaandroidavanzado2.data.mappers.RemoteToLocalMapper remoteToLocalMapper) {
            return null;
        }
    }
}
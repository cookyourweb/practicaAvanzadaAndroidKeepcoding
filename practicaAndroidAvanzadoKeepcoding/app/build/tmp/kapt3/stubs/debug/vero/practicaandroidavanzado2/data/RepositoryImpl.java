package vero.practicaandroidavanzado2.data;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lvero/practicaandroidavanzado2/data/RepositoryImpl;", "Lvero/practicaandroidavanzado2/data/Repository;", "localDataSource", "Lvero/practicaandroidavanzado2/data/local/LocalDataSource;", "remoteDataSource", "Lvero/practicaandroidavanzado2/data/remote/RemoteDataSource;", "localToPresentationMapper", "Lvero/practicaandroidavanzado2/data/mappers/LocalToPresentationMapper;", "remoteToLocalMapper", "Lvero/practicaandroidavanzado2/data/mappers/RemoteToLocalMapper;", "(Lvero/practicaandroidavanzado2/data/local/LocalDataSource;Lvero/practicaandroidavanzado2/data/remote/RemoteDataSource;Lvero/practicaandroidavanzado2/data/mappers/LocalToPresentationMapper;Lvero/practicaandroidavanzado2/data/mappers/RemoteToLocalMapper;)V", "getHeroes", "", "Lvero/practicaandroidavanzado2/ui/model/Superhero;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class RepositoryImpl implements vero.practicaandroidavanzado2.data.Repository {
    @org.jetbrains.annotations.NotNull
    private final vero.practicaandroidavanzado2.data.local.LocalDataSource localDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final vero.practicaandroidavanzado2.data.remote.RemoteDataSource remoteDataSource = null;
    @org.jetbrains.annotations.NotNull
    private final vero.practicaandroidavanzado2.data.mappers.LocalToPresentationMapper localToPresentationMapper = null;
    @org.jetbrains.annotations.NotNull
    private final vero.practicaandroidavanzado2.data.mappers.RemoteToLocalMapper remoteToLocalMapper = null;
    
    public RepositoryImpl(@org.jetbrains.annotations.NotNull
    vero.practicaandroidavanzado2.data.local.LocalDataSource localDataSource, @org.jetbrains.annotations.NotNull
    vero.practicaandroidavanzado2.data.remote.RemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull
    vero.practicaandroidavanzado2.data.mappers.LocalToPresentationMapper localToPresentationMapper, @org.jetbrains.annotations.NotNull
    vero.practicaandroidavanzado2.data.mappers.RemoteToLocalMapper remoteToLocalMapper) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getHeroes(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<vero.practicaandroidavanzado2.ui.model.Superhero>> $completion) {
        return null;
    }
}
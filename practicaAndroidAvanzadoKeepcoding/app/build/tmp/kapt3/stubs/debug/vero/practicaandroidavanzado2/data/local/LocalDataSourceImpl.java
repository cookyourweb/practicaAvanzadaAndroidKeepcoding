package vero.practicaandroidavanzado2.data.local;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lvero/practicaandroidavanzado2/data/local/LocalDataSourceImpl;", "Lvero/practicaandroidavanzado2/data/local/LocalDataSource;", "dao", "Lvero/practicaandroidavanzado2/data/local/SuperheroDAO;", "(Lvero/practicaandroidavanzado2/data/local/SuperheroDAO;)V", "getHeroes", "", "Lvero/practicaandroidavanzado2/data/local/model/LocalSuperhero;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertHero", "", "localSuperhero", "(Lvero/practicaandroidavanzado2/data/local/model/LocalSuperhero;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertHeroes", "localSuperheros", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class LocalDataSourceImpl implements vero.practicaandroidavanzado2.data.local.LocalDataSource {
    @org.jetbrains.annotations.NotNull
    private final vero.practicaandroidavanzado2.data.local.SuperheroDAO dao = null;
    
    @javax.inject.Inject
    public LocalDataSourceImpl(@org.jetbrains.annotations.NotNull
    vero.practicaandroidavanzado2.data.local.SuperheroDAO dao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getHeroes(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<vero.practicaandroidavanzado2.data.local.model.LocalSuperhero>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertHero(@org.jetbrains.annotations.NotNull
    vero.practicaandroidavanzado2.data.local.model.LocalSuperhero localSuperhero, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertHeroes(@org.jetbrains.annotations.NotNull
    java.util.List<vero.practicaandroidavanzado2.data.local.model.LocalSuperhero> localSuperheros, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}
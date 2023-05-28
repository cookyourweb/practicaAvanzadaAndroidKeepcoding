package vero.practicaandroidavanzado2.data.local;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lvero/practicaandroidavanzado2/data/local/LocalDataSource;", "", "getHeroes", "", "Lvero/practicaandroidavanzado2/data/local/model/LocalSuperhero;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertHero", "", "localSuperhero", "(Lvero/practicaandroidavanzado2/data/local/model/LocalSuperhero;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertHeroes", "localSuperheroes", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface LocalDataSource {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHeroes(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<vero.practicaandroidavanzado2.data.local.model.LocalSuperhero>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertHero(@org.jetbrains.annotations.NotNull
    vero.practicaandroidavanzado2.data.local.model.LocalSuperhero localSuperhero, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertHeroes(@org.jetbrains.annotations.NotNull
    java.util.List<vero.practicaandroidavanzado2.data.local.model.LocalSuperhero> localSuperheroes, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
package vero.practicaandroidavanzado2.ui;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\rR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lvero/practicaandroidavanzado2/ui/SuperheroViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lvero/practicaandroidavanzado2/data/Repository;", "(Lvero/practicaandroidavanzado2/data/Repository;)V", "_heroes", "Landroidx/lifecycle/MutableLiveData;", "", "Lvero/practicaandroidavanzado2/ui/model/Superhero;", "heroes", "Landroidx/lifecycle/LiveData;", "getHeroes", "()Landroidx/lifecycle/LiveData;", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SuperheroViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final vero.practicaandroidavanzado2.data.Repository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<vero.practicaandroidavanzado2.ui.model.Superhero>> _heroes = null;
    
    @javax.inject.Inject
    public SuperheroViewModel(@org.jetbrains.annotations.NotNull
    vero.practicaandroidavanzado2.data.Repository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<vero.practicaandroidavanzado2.ui.model.Superhero>> getHeroes() {
        return null;
    }
    
    public final void getHeroes() {
    }
}
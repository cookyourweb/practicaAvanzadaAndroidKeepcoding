package vero.practicaandroidavanzado2.data.local;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lvero/practicaandroidavanzado2/data/local/SuperheroDatabase;", "Landroidx/room/RoomDatabase;", "()V", "superheroDao", "Lvero/practicaandroidavanzado2/data/local/SuperheroDAO;", "app_debug"})
@androidx.room.Database(entities = {vero.practicaandroidavanzado2.data.local.model.LocalSuperhero.class}, version = 1)
public abstract class SuperheroDatabase extends androidx.room.RoomDatabase {
    
    public SuperheroDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract vero.practicaandroidavanzado2.data.local.SuperheroDAO superheroDao();
}
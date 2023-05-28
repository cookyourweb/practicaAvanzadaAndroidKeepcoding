package vero.practicaandroidavanzado2.data.remote;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lvero/practicaandroidavanzado2/data/remote/DragonBallApi;", "", "getHeroes", "", "Lvero/practicaandroidavanzado2/data/remote/response/GetHeroesResponse;", "getHeroesRequestBody", "Lvero/practicaandroidavanzado2/data/remote/request/GetHeroesRequestBody;", "(Lvero/practicaandroidavanzado2/data/remote/request/GetHeroesRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface DragonBallApi {
    
    @retrofit2.http.POST(value = "api/heroes/all")
    @retrofit2.http.Headers(value = {"Authorization: Bearer eyJhbGciOiJIUzI1NiIsImtpZCI6InByaXZhdGUiLCJ0eXAiOiJKV1QifQ.eyJpZGVudGlmeSI6IjdDNzQ1NjRCLTQ5NUEtNDhCRC04QzIyLTM5OEUwOUREODY0MyIsImV4cGlyYXRpb24iOjY0MDkyMjExMjAwLCJlbWFpbCI6Imp1YW5qZS5jaWxsYTFAZ21haWwuY29tIn0.epMHxtAkVu_fT5FvQwKrm_fRqzT9UOG2gpiTTipQajw"})
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHeroes(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    vero.practicaandroidavanzado2.data.remote.request.GetHeroesRequestBody getHeroesRequestBody, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<vero.practicaandroidavanzado2.data.remote.response.GetHeroesResponse>> $completion);
}
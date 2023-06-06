package practicaandroidavanzado5datalocal.base


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import vero.practicaAndroidAvanzadov5.data.remote.DragonBallAPI
import vero.practicaandroidavanzado5datalocal.utils.DragonBallApiDispatcher
import java.util.concurrent.TimeUnit

open class BaseNetworkTest {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    lateinit var api: DragonBallAPI
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var loggingInterceptor: HttpLoggingInterceptor

    @Before
    fun setup(){
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = DragonBallApiDispatcher()
        mockWebServer.start()
        loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        okHttpClient = buildOkhttpClient(loggingInterceptor)

        api = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(DragonBallAPI::class.java)
    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }

    private fun buildOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

}

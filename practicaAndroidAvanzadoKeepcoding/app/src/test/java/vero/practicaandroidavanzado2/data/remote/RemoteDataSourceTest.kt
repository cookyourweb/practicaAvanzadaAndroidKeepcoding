package vero.practicaandroidavanzado2.data.remote
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import vero.practicaandroidavanzado2.data.utils.BaseNetworkMockTest




import vero.practicaandroidavanzado2.data.remote.request.GetHeroesRequestBody


class RemoteDataSourceTest : BaseNetworkMockTest(){
    //UUT O SUT Unit Test o System under Test: siempre va a ser
    //un test unitario por def deberia ser falsear una clase  o el objeto y mockear lo que deependa de ella

    //mocks  cuando hagamos

    @Test
    fun mytest() = runTest{


        //Given : dado un estado

        val remoteDataSource = RemoteDataSource2(api) //este tiene que ser llocal y la bd igual

        //When : ejecuto algo ()

        val actual = remoteDataSource.getHeroes()

        //then

        assert(actual[0].name == "Broly")

    }

    @Test
    fun `WHEN requesting getheroes EXPECT successful response AND 3 heroes starting by B`() = runTest {
        // Given
        val remoteDataSource = RemoteDataSource2(api)

        // When
        val actual = remoteDataSource.getHeroes()

        // Then
        assert(actual.size == 3)
    }
    @Test
    fun myTest3() = runTest {
        // Given
        val getheroesRequestBody = GetHeroesRequestBody("Juan")

        // When

        // Then
        assert(getheroesRequestBody.name == "Juan")
    }




}
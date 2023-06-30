package vero.practicaandroidavanzado2.data


import vero.practicaandroidavanzado2.ui.model.Superhero

interface Repository {
    suspend fun getHeroes(): List<Superhero>
}
//se mete el metodo para obtener la abstracciones(hay que depender de
//las abstracciones y no de las implementacioes
enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val idade: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: MutableList<ConteudoEducacional>, val nivel: Nivel) {
    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) = inscritos.add(usuario)
    fun alunosInscritos(): MutableList<Usuario> = inscritos
    fun adicionarConteudo(conteudo: ConteudoEducacional) = conteudos.add(conteudo)

    fun descricao() {
        println()
        println("Nome: $nome")
        println("Conteúdos:")
        for(conteudo in conteudos) { println("\t${conteudo.nome} - ${conteudo.duracao} mins") }

        when(nivel) {
            Nivel.BASICO -> println("Básico")
            Nivel.INTERMEDIARIO -> println("Intermediário")
            Nivel.AVANCADO -> println("Avançado")
        }
        println()
    }
}

fun main() {
    val usuario1 = Usuario("Thiago", 22)
    val usuario2 = Usuario("Ana", 18)

    val conteudo1 = ConteudoEducacional("Básico em Kotlin", 6)
    val conteudo2 = ConteudoEducacional("POO em Kotlin", 6)
    val listaConteudo = mutableListOf(conteudo1, conteudo2)

    val formacao = Formacao("Formação - Backend em Kotlin", listaConteudo, Nivel.INTERMEDIARIO)
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    formacao.descricao()

    for(aluno in formacao.alunosInscritos()) {
        println("O aluno ${aluno.nome} de ${aluno.idade} anos está inscrito na formação.")
    }

    val conteudo3 = ConteudoEducacional("Funções em Kotlin", 4)
    formacao.adicionarConteudo(conteudo3)
    formacao.descricao()
}
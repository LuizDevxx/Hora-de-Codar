class BichoVirtual(val nome: String) {

    var fome = 50
    var felicidade = 50
    var cansaço = 0
    var idade = 0
    var perdeu = false

    fun alimentar() {
        fome -= 15
        if (fome < 0) fome = 0
        println("$nome foi alimentado!")
    }

    fun brincar() {
        felicidade += 10
        if (felicidade > 100) felicidade = 100

        cansaço += 10
        println("$nome brincou e ficou mais feliz!")
    }

    fun descansar(horas: Int) {
        cansaço -= horas * 5
        if (cansaço < 0) cansaço = 0
        println("$nome descansou por $horas horas.")
    }

    fun verificarStatus() {
        println("\n--- Status de $nome ---")
        println("Idade: $idade")
        println("Fome: $fome")
        println("Felicidade: $felicidade")
        println("Cansaço: $cansaço")
        println("-----------------------")
    }

    fun passarTempo() {
        fome += 3
        felicidade -= 3
        cansaço += 10
        idade++

        if (fome >= 100 || cansaço >= 100 || felicidade <= 0) {
            perdeu = true
        }
    }
}

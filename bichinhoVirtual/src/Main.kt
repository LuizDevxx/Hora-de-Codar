fun main() {

    println("Bem-vindo ao Simulador de Animal de Estimação Virtual!")
    print("Digite o nome do seu bichinho: ")
    val nome = readln()

    val pet = BichoVirtual(nome)

    while (true) {
        if (pet.perdeu) {
            println("\nSeu bichinho não resistiu... Você perdeu!")
            break
        }

        if (pet.idade >= 50) {
            println("\nParabéns! Seu bichinho chegou à idade 50. Você venceu!")
            break
        }

        println(
            """
            
Escolha uma ação:
1. Alimentar
2. Brincar
3. Descansar
4. Verificar status
5. Sair
""".trimIndent()
        )

        when (readln().toIntOrNull()) {
            1 -> pet.alimentar()
            2 -> pet.brincar()
            3 -> {
                print("Quantas horas ele vai descansar? ")
                val horas = readln().toIntOrNull() ?: 0
                pet.descansar(horas)
            }
            4 -> pet.verificarStatus()
            5 -> {
                println("Saindo... até a próxima!")
                return
            }
            else -> println("Opção inválida.")
        }

        pet.passarTempo()
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //ex1()
    //ex2()
    //ex3()
    ex4()
}

fun ex1() {
    /* 1 Escreva um programa que crie uma variável
     chamada "nome_do_carro" e atribua-a um valor
     "Fusca". Exiba-a ao usuário.*/

    var nome_do_carro: String = "Fusca"

    println(nome_do_carro)
}

fun ex2() {
    /*2 Escreva um programa em que o usuário informe o
    seu nome e exiba a mensagem "Olá, [NomeDoUsuario]".*/

    print("Digite seu nome: ")
    var nome: String = readln()

    println("Olá, " + nome)
}

fun ex3() {
    /*3 Escreva um programa em que o usuário informe o seu nome e em seguida o program
    perguntará a idade do usuário.Agora o programa deve exibir a mensagem
    "Olá, [NomeDoUsuario], sua idade é [idade]".*/

    print("Digite seu nome: ")
    var nome: String = readln()
    print("Digite sua idade: ")
    var idade: Int = readln().toInt()

    println("Olá, $nome, sua idade é $idade")
}

fun ex4() {
    var n1: Double = 0.0
    var n2: Double
    var A: Double=0.0
    var tipo:String=""
    var cabecario:String= "Vamos calcular a área de um: "

    println("Digite qual o tipo de operação deseja fazer: (de 1 a 7)");
    println("1 - Retângulo");
    println("2 - Quadrado");
    println("3 - Losango");
    println("4 - Trapézio");
    println("5 - Paralelogramo");
    println("6 - Triângulo");
    println("7 - Círculo");
    var opcao: Int = readln().toInt()

    when (opcao) {
        1 -> {
            tipo="Retangulo"
            print("$cabecario $tipo\n")

            print("Digite a base: ")
            n1 = readln().toDouble()
            print("Digite a altura: ")
            n2 = readln().toDouble()

            A = retangulo_paralelogramo(n1, n2)
        }

        2 -> {
            tipo="Quadrado"
            print("$cabecario $tipo\n")

            print("Digite o lado: ")
            n1 = readln().toDouble()

            A = quadrado(n1)
        }

        3 -> {
            tipo="Losango"
            print("$cabecario $tipo\n")

            print("Digite a diagonal MAIOR: ")
            n1 = readln().toDouble()
            print("Digite a diagonal Menor: ")
            n2 = readln().toDouble()

            A = losango(n1, n2)
        }

        4 -> {
            tipo="Trapezio"
            print("$cabecario $tipo\n")

            print("Digite a base MAIOR: ")
            n1 = readln().toDouble()
            print("Digite a base MENOR: ")
            n2 = readln().toDouble()
            print("Digite a ALTURA: ")
            var altura: Double = readln().toDouble()

            A = trapezio(n1, n2, altura)
        }

        5 -> {
            tipo="Paralelogramo"
            print("$cabecario $tipo\n")

            print("Digite a base: ")
            n1 = readln().toDouble()
            print("Digite a altura: ")
            n2 = readln().toDouble()

            A = retangulo_paralelogramo(n1, n2)
        }

        6 -> {
            tipo="Triangulo"
            print("$cabecario $tipo\n")

            print("Digite a base: ")
            n1 = readln().toDouble()
            print("Digite a altura: ")
            n2 = readln().toDouble()

            A = triangulo(n1, n2)
        }

        7 -> {
            tipo="Circulo"
            print("$cabecario $tipo\n")

            print("Digite o Raio: ")
            n1 = readln().toDouble()

            A = circulo(n1)
        }
        else -> println("Opção inválida!")



    }
    println("A área do $tipo é: %.2f".format(A))

}

fun retangulo_paralelogramo(base: Double, altura: Double) = base * altura

fun quadrado(lado: Double) = Math.pow(lado, 2.0)

fun losango(diaMaior: Double, diaMenor: Double) = diaMaior * diaMenor / 2

fun trapezio(baseMaior: Double, baseMenor: Double, altura: Double) = (baseMaior + baseMenor) * altura/2

fun triangulo(base: Double, altura: Double) = base * altura / 2

fun circulo(raio: Double) = 3.14 * Math.pow(raio, 2.0)
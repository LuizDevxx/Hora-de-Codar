//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //ex1()
    //ex2()
    //ex3()
    //ex4()
    ex5()
    //ex6()
    //ex7()
    //ex8()
    //ex9()
    //ex10()
    //ex11()
}

fun ex1() {
    /* 1 - Crie uma bomba relógio (usando somente código - para deixar
     claro!) cuja contagem regressiva vá de 30 a 0. No final da repetição
     escreva "EXPLOSÃO".*/

    for (i in 30 downTo 0) {
        println(i)
    }
    System.err.println("EXPLOSÃOO")
}

fun ex2() {
    /*2 - Escreva um algoritmo para ler 2 valores informados pelo usuário e enquanto
    o segundo valor informado for igual ou menor que ZERO, deve ser lido um novo valor,
    mas para a mesma variável. Ou seja, para o segundo valor não pode ser aceito o valor
    zero nem um valor negativo.
    O seu programa deve imprimir o resultado da divisão do primeiro valor lido pelo segundo
    valor e exibir o resultado ao usuário.*/


    var num: Double
    var num2: Double = 0.0
    var total: Double

    print("Digite o primeiro numero: ")
    num = readln().toDouble()

    do {
        print("Digite o segundo numero: ")
        num2 = readln().toDouble()

        if (num2 <= 0.0) {
            System.err.println("Digite o numero maior que zero")
        }
    } while (num2 <= 0.0)

    total = num / num2

    println("O resultado de $num dividido por $num2 é %.2f".format(total))

}

fun ex3() {
    /*3 - Escreva um algoritmo para imprimir os números de 1 (inclusive)
     a 10 (inclusive) em ordem decrescente.
    Exemplo: 10, 9, 8, 7, 6, 5, 4, 3, 2, 1*/

    for (i in 10 downTo 1) {
        print("$i,")
    }
}

fun ex4() {
    /*4 - Faça um algoritmo que calcule e escreva a média
    aritmética dos números inteiros entre 15 (inclusive)
    e 100 (inclusive).*/

    var media: Double = 0.0
    var cont: Double = 0.0

    for (i in 15..100) {
        media += i
        cont++
    }
    media /= cont
    println("A media aritmética é: %.2f".format(media))

}

fun ex5() {
    /* 5 - Faça um algoritmo que calcule e escreva a média aritmética
     dos dois números inteiros informados pelo usuário e todos os números
     inteiros entre eles. Considere que o primeiro sempre será menor que o segundo.*/

    var n1: Int = 0
    var n2: Int = 0


    println("Digite o primeiro valor: ")
    n1 = readln().toInt()
    println("Digite o segundo valor: ")
    n2 = readln().toInt()

    var soma = 0
    var cont = 0
    for (i in n1..n2) {
        soma += i
        cont++
    }
    val media = soma.toDouble() / cont
    println("A média entre $n1 e $n2 é: %.2f".format(media))
}

fun ex6() {
    /*6 - Escreva um programa para ler 2 notas de um aluno, calcular e imprimir
    a média final. Considere que a nota de aprovação é 9,5. Logo após escrever
    a mensagem "Calcular a média de outro aluno Sim/Não?" e solicitar um resposta.
    Se a resposta for "S", o programa deve ser executado novamente, caso contrário
    deve ser encerrado exibindo a quantidade de alunos aprovados.*/

    var opcao: String
    var nota: Double = 0.0
    var media: Double
    var cont: Int = 0
    var soma: Double = 0.0

    println("-----CALCULADORA DE MÉDIA-----")
    do {
        println()
        soma = 0.0
        for (i in 1..2) {
            print("Digite a $i° nota: ")
            nota = readln().toDouble()
            soma += nota
        }
        media = soma / 2

        if (media >= 9.5) {
            cont++
        }
        println("A media é: %.2f\n\n".format(media))

        println("Deseja calcular outro aluno? (digite numero ou a palavra)")
        println("1-Sim")
        println("2-Não")
        opcao = readln()
    } while (opcao == "1" || opcao.uppercase() == "Sim")

    println("ALUNOS APROVADOS: $cont")
}

fun ex7() {
    /*7 - Escreva um algoritmo para ler as notas de avaliações de um aluno, calcule e imprima a média (simples)
    desse aluno. Só devem ser aceitos valores válidos durante a leitura (0 a 10) para cada nota. São 6 notas ao total.
    Caso o valor informado para qualquer uma das notas esteja fora do limite estabelecido, deve ser solicitado um novo valor ao usuário.*/

    var num: Double
    var media: Double = 0.0

    for (i in 1..6) {
        print("Digite a $i°nota: ")
        num = readln().toDouble()
        do {
            if (num > 10 || num < 0) {
                println("A nota deve ser maior que 0 e menor que 10")
                print("Digite de novo a nota $i: ")
                num = readln().toDouble()
            }
        } while (num > 10 || num < 0)

        media += num
    }
    media /= 6
    println("A MEDIA É: $media")
}

fun ex8() {
    /*8 - Ler um valor N e imprimir todos os valores inteiros entre 1 (inclusive)
    e N (inclusive). Considere que o N será sempre maior que ZERO.
    N  é um valor informado pelo usuário*/

    println("Digite um valor: ")
    var num: Int = readln().toInt()

    for (i in 1 + 1 until num) {
        println(i)
    }
}

fun ex9() {
    /* 9 - Escreva um algoritmo para imprimir os 10 primeiros números inteiros maiores que 100.*/

    for (i in 101..110) {
        println(i)
    }
}

fun ex10() {
    /*10 - Escreva um programa em que o usuário informe 10 valores e escreva quantos
    desses valores lidos estão entre os números 24 e 42 (incluindo os valores 24 e 42)
    e quantos deles estão fora deste intervalo
     */
    var num: Int
    var cont: Int = 0
    var contFora: Int = 0

    for (i in 1..10) {
        print("Digite o $i° número: ")
        num = readln().toInt()

        if (num >= 24 && num <= 42) {
            cont++
        } else {
            contFora++
        }
    }
    println()
    println("VALORES DENTRO: $cont")
    println("VALORES FORA: $contFora")
}

fun ex11() {
    /*11 - Escreva um programa para imprimir todas as tabuadas de 1 a N. N será informado pelo usuário.*/

    println("Digite um valor: ")
    var num: Int = readln().toInt()

    var resul: Int = 0

    for (i in 1..num) {
        println("-------------------------------")
        for (j in 1..10) {
            resul = i * j
            println("%2d x %2d = %3d".format(i, j, resul))
        }

    }
}

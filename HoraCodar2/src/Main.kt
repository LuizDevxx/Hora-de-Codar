//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //ex1()
    //ex2()
    //ex3()
    //ex4()
    //ex5()
    //ex6()
    //ex7()
    //ex8()
    //ex9()
    //ex10()
    ex11()
}

fun ex1() {/* 1. Escreva um programa em que o usuário informe
     dois números. Então escreva em tela o maior deles.*/
    var maior: Int

    print("Digite o primeiro numero: ")
    var n1: Int = readln().toInt()
    print("Digite o segundo numero: ")
    var n2: Int = readln().toInt()

    if (n1 > n2) {
        maior = n1
    } else {
        maior = n2
    }
    print("O numero maior é: $maior")
}

fun ex2() {
    /*2.Faça um programa que leia um valor informado pelo usuário e
    diga se o valor informado é positivo, negativo ou zero.*/

    var tipo: String

    print("Digite um valor: ")
    var n1: Int = readln().toInt()

    if (n1 > 0) {
        tipo = "Positivo"
    } else if (n1 < 0) {
        tipo = "Negativo"
    } else {
        tipo = "Zero"
    }
    print("O numero é: $tipo")
}

fun ex3() {
    /* 3. Faça um programa para ler 3 valores (considere que não
     serão informados valores iguais e positivos) e escrever o maior deles.*/
    var n1: Int
    var maior = Int.MIN_VALUE

    for (i in 1..3) {
        print("Digite o $i° numero: ")
        n1 = readln().toInt()
        if (n1 > maior) {
            maior = n1
        }
    }
    print("O numero Maior é: $maior")

}

fun ex4() {
    /*4. Faça um programa que leia 3 valores informados pelo usuário (considere
    que não serão informados valores iguais) e escrever a soma dos 2 maiores.*/
    var resul: Int
    var valor: Int
    var n1: Int = 0
    var n2: Int = 0

    for (i in 1..3) {
        print("Digite o $i° numero: ")
        valor = readln().toInt()

        if (valor > n1) {
            n2 = n1
            n1 = valor
        } else if (valor > n2) {
            n2 = valor
        }
    }
    resul = n1 + n2
    print("A soma de $n1 e $n2 é: $resul")
}

fun ex5() {
    /*5.  Faça um programa que leia 6 valores informados pelo usuário, calcule,
    exiba os números informados e escreva a média aritmética desses valores lidos.*/

    var num: Double
    var total: Double = 0.0

    for (i in 1..6) {
        print("Digite $i° número pra ser somado: ")
        num = readln().toDouble()
        total += num

    }
    total /= 6
    print("A média entre os 6 números é: %.2f".format(total))
}

fun ex6() {
    /*6. Faça um programa que receba quatro valores informados pelo usuário, mas informe
    somente o primeiro, o último e o maior de todos eles (considere que todos os números
    informados serão diferentes)*/

    var maior: Int = Int.MIN_VALUE
    var primeiro: Int = 0
    var ultimo: Int = 0
    var num: Int

    for (i in 1..4) {
        print("Digite o $i° número: ")
        num = readln().toInt()

        if (i == 1) {
            primeiro = num
        }
        if (num > maior) {
            maior = num
        }
        if (i == 4) {
            ultimo = num
        }
    }
    print("O PRIMEIRO número é: $primeiro\n")
    print("O ULTIMO número é: $ultimo\n")

    print("O maior número é: $maior\n")
}

fun ex7() {
    /*  7. Faça um programa que leia 6 números que o usuário vai informar. Todos os números lidos com valor
      inferior a 72 devem ser somados. Escreva o valor final da soma efetuada e também todos valores que o usuário informou.*/

    var soma: Int = 0

    var valor = IntArray(6)

    for (i in 0 until valor.size) {
        print("Digite o ${i + 1} número: ")
        valor[i] = readln().toInt()

        if (valor[i] < 72) {
            soma += valor[i]
        }
    }
    print("\nO a SOMA dos números abaixo de 72 é: $soma\n")
    print("Todos os números digitados: ")


    valor.forEach { num ->
        println(num)

    }
}

fun ex8() {
    /*8. Escreva um programa que calcule a média de quatro números informados
    pelo usuário, mas somente se esses números forem maiores que 0 e menores
    que 10. No final, se a média for maior que cinco o usuário receberá uma
    mensagem "Você passou no teste". Em qualquer outra situação, ele receberá
    uma mensagem de "tente novamente"*/

    var num: Int = 0
    var media: Int = 0

    do {
        media = 0
        for (i in 1..4) {
            print("Digite o $i° número: ")
            num = readln().toInt()

            if (num > 0 && num < 10) {
                media += num
            }

        }
        media /= 4
        if (media > 5) {
            println("Você passou no teste")
        } else {
            System.err.println("Tente novamente")
        }
    } while (media < 5)
}

fun ex9() {
    /*  9.Escreva um programa para ler o ano de nascimento de uma pessoa
      e escrever uma mensagem que diga se ela poderá ou não votar este
      ano (não é necessário considerar o mês em que ela nasceu).*/

    var ano: Int

    print("Digite o ano que você nasceu: ")
    ano = readln().toInt()


    if (2025 - ano >= 18) {
        println("Poderá votar")
    } else {
        println("NÃO Poderá votar")
    }
}

fun ex10() {
    /*10. Tendo como entrada a altura e o gênero designado ao nascer
    (codificado da seguinte forma: 1: feminino - 2: masculino - )
    de uma pessoa, construa um programa que calcule e imprima seu
    peso ideal, utilizando as seguintes fórmulas.*/

    var imc: Double
    var sexo: String

    print("----Calculando o IMC----")
    println()
    print("Digite sua altura: ")
    var altura: Double = readln().toDouble()

    println("Digite 1 ou 2")
    println("1-FEMININO")
    println("2-MASCULINO")
    print("Opção: ")
    var opcao: Int = readln().toInt()



    when (opcao) {
        1 -> {
            imc = pesoMulher(altura)
            sexo = "FEMININO"
        }

        2 -> {
            imc = pesoHomem(altura)
            sexo = "MASCULINO"
        }

        else -> {
            println("Opcão inválida")
            return
        }
    }
    println("Seu sexo é: $sexo")
    println("E seu peso ideal é: %.2f kg".format(imc))


}

fun pesoHomem(altura: Double) = 72.7 * altura - 58
fun pesoMulher(altura: Double) = 62.1 * altura - 44.7


fun ex11() {
    /*  11.Uma micro calculadora
Escreva um programa para ler 2 valores inteiros informados pelo usuário
e uma das seguintes operações a serem executadas (codificada da seguinte
forma : 1. Adição, 2. Subtração, 3. Divisão, 4. Multiplicação).
O programa deve calcular e escrever o resultado dessa operação sobre os dois
valores lidos.Observação: Considere que só serão lidos os valores 1, 2, 3 ou 4
para as operações*/

    var n1: Double=0.0
    var n2 :Double=0.0
    var total:Double=0.0
    var tipo: String=""

    println("---- BEM VINDO A MINI CALCULADORA ----")
    println("Digite uma opção de 1 a 4")
    println("1-ADIÇÃO")
    println("2-SUBTRAÇÃO")
    println("3-DIVISÃO")
    println("4-MULTIPLICAÇÃO")


    var opcao: Int = readln().toInt()

    when (opcao) {
        1 -> {
            tipo="SOMA"

            print("Digite o primeiro número: ")
            n1=readln().toDouble()
            print("Digite o segundo número: ")
            n2=readln().toDouble()
            total=adicao(n1,n2)

        }

        2 -> {
            tipo="SUBTRAÇÃO"

            print("Digite o primeiro número: ")
            n1=readln().toDouble()
            print("Digite o segundo número: ")
            n2=readln().toDouble()
            total=subtracao(n1,n2)

        }

        3 -> {
            tipo="DIVISÃO"

            print("Digite o número MAIOR: ")
            n1=readln().toDouble()
            print("Digite o número MENOR: ")
            n2=readln().toDouble()
            total=divisao(n1,n2)
            println("A $tipo de $n1 e $n2 é: %.2f".format(total))

        }

        4 -> {
            tipo="MULTIPLICAÇÃO"

            print("Digite o primeiro número: ")
            n1=readln().toDouble()
            print("Digite o segundo número: ")
            n2=readln().toDouble()
            total=multiplicacao(n1,n2)


        }

        else -> {
            println("Opção invalida")
            return
        }
    }
    println("A $tipo de $n1 e $n2 é: %.2f".format(total))


}

fun adicao(n1: Double, n2: Double) = n1 + n2
fun subtracao(n1: Double, n2: Double) = n1 - n2
fun divisao(n1: Double, n2: Double) = n1 / n2
fun multiplicacao(n1: Double, n2: Double) = n1 * n2

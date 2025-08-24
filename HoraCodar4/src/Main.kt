//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //ex1()
    //ex2()
    ex3()
}

fun ex1() {
    /* 1
     Crie um programa onde o usuário possa cadastrar estudantes sem limites,
     e, em seguida, Se o usuário digitar "PARE" o programa deve exibir a quantidade
     de estudantes cadastrados e a lista com cada um deles.*/


    var estudantes = ArrayList<String>()

    var nome: String
    var opcao: String

    println("----BEM VINDO AO CADASTRO DE ESTUDANTES----")
    println("Digite o nome do aluno ou 'PARE' para encerrar.")

    while (true) {
        print("Digite o nome do aluno: ")
        nome = readln()

        if (nome.equals("PARE", ignoreCase = true)) {
            break
        }
        estudantes.add(nome)

    }

    println("Ok, Obrigado pelo acesso segue a lista de alunos: ")

    estudantes.forEachIndexed { index, aluno ->
        println("${index + 1}. $aluno")
    }
}
fun ex2(){
   /* 2
    Crie uma array de planetas que inclua "Terra", "Marte", "Plutão", "Vênus", "Júpiter", "Saturno"
    e, em seguida, peça ao usuário para digitar o nome de um planeta.
    Verifique se o planeta que o usuário informou está na array e informe ao usuário.*/

    var planetas = arrayOf("Terra", "Marte", "Plutão", "Vênus", "Júpiter", "Saturno")

    println("Digite um planeta pra eu verificar: ")
    var nome:String=readln()

    if (planetas.any { it.uppercase() == nome.uppercase() }){
        println("Planeta $nome, está na lista")
        return
    }
    println("O Planeta não esta na lista")
}
fun ex3(){
   /* 3
    Vamos criar uma lista de compras.
    Crie uma array de frutas, exiba-a ao usuário e, em seguida, peça ao usuário para digitar o nome de uma das frutas.
    Caso a fruta esteja no array, remova-a e exiba a mensagem "Fruta foi retirada da lista".
    Peça novamente para o usuário digitar o nome de uma fruta para ser removida.
    Sempre que o usuário procurar por uma fruta que não está no array exiba a mensagem "Fruta indisponível no nosso mercado".
    Quando o array não possuir mais itens dentro de si, escreva "Lista de compras finalizada"*/


    var frutas = mutableListOf("Maça", "Pera","Uva","Goiaba","Manga")

    do {
        frutas.forEachIndexed { index, fruta ->
            println("${index+1}. Fruta: $fruta")
        }
        print("Digite o nome de uma fruta: ")

        var nome: String = readln()

        removerFruta(frutas, nome)

    }while (frutas.isNotEmpty())

    println("----AGRADEMOS A PREFERENCIA LISTA DE COMPRAS FINALIZADA----")

}
fun removerFruta(frutas: MutableList<String>, nome: String) {

    if (frutas.any(){it.uppercase()==nome.uppercase()}){
        frutas.removeIf { it.uppercase() == nome.uppercase() }
        println("A fruta $nome foi removida do sistema \n")
    }else{
        println("Fruta indisponivel no nosso mercado\n")
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import kotlin.math.max

fun main() {
    val hotel = "PARAISO"
    println("----BEM VINDO AO HOTEL $hotel----")

    var nome: String
    do {
        print("Qual seu nome: ")
        nome = readln().uppercase()
    } while (!nome.matches(Regex("^[A-Za-zÀ-ÿ ]+$")))

    validandoSenha()

    println("\n----BEM VINDO AO HOTEL $hotel---- \n$nome, é um imenso prazer ter você por aqui")

    val quartos = MutableList(20) { false }

    while (true) {
        println("\nQUAL OPÇÃO DESEJA? ")
        println("1-Reservar quartos")
        println("2-Cadastro de Hóspedes")
        println("3-Cadastrar/Pesquisar/Listar hóspedes")
        println("4-Eventos")
        println("5-Posto de combustível")
        println("6-Ar Puro (Manutenção de Ar-condicionado)")
        println("7-SAIR")

        print("OPÇÃO: ")
        val opcao = readln().toIntOrNull()

        when (opcao) {
            1 -> reservaDeQuartos(nome, quartos)
            2 -> cadastrarHopedes(nome)
            3 -> menuCPLH()
            4 -> eventos()
            5 -> postoCombus(nome)
            6 -> manutencaoArCondicionado()
            7 -> {
                saida(nome)
                return
            }
            else -> println("Digite uma opção válida\n")
        }
    }
}

fun validandoSenha() {
    while (true) {
        print("Digite sua senha: ")
        val senha = readln()
        if (senha == "2678") break
    }
}

fun saida(nome: String) {
    println("\nMuito obrigado e até logo, $nome")
}

fun calculoHopedagem(valor: Double, diarias: Int) = diarias * valor

fun mostrarQuartos(list: MutableList<Boolean>) {
    list.forEachIndexed { index, quarto ->
        if (quarto) println("Quarto ${index + 1}: OCUPADO") else println("Quarto ${index + 1}: LIVRE")
    }
}

fun situacaoQuarto(quartos: MutableList<Boolean>): Int {
    var num: Int
    while (true) {
        do {
            print("Qual o quarto para reserva? (1 - 20)? ")
            num = readln().toIntOrNull() ?: -1
        } while (num !in 1..20)

        if (!quartos[num - 1]) {
            quartos[num - 1] = true
            println("Quarto livre\n")
            return num
        } else {
            println("Quarto $num ocupado. Digite outro quarto\n")
        }
    }
}

fun reservaDeQuartos(nome: String, quartos: MutableList<Boolean>) {
    println("\n----RESERVA DE QUARTOS----")

    var valor: Double
    do {
        print("Qual o valor padrão da diária? ")
        valor = readln().toDoubleOrNull() ?: -1.0
    } while (valor <= 0)

    var dias: Int
    do {
        print("Quantas diárias serão necessárias? ")
        dias = readln().toIntOrNull() ?: -1
    } while (dias <= 0 || dias > 30)

    val total = calculoHopedagem(valor, dias)
    println("O valor de $dias dias de hospedagem é de R$%.2f\n".format(total))

    var nomeHospede: String
    do {
        print("Qual o nome do Hóspede? ")
        nomeHospede = readln().uppercase()
    } while (!nomeHospede.matches(Regex("^[A-Za-zÀ-ÿ ]+$")))

    val quartoEscolhido = situacaoQuarto(quartos)

    print("$nome, você confirma a hospedagem para $nomeHospede por $dias dias no quarto $quartoEscolhido por R$%.2f? (S/N) ".format(total))
    val opcao = readln().uppercase()

    if (opcao == "S") {
        println("$nome, reserva efetuada para $nomeHospede\n")
        mostrarQuartos(quartos)
    } else {
        println("Reserva não efetuada\n")
    }
}

fun calculaPassagens(valor: Double, contMeia: Int, contInt: Int) = (valor / 2 * contMeia) + (valor * contInt)

fun cadastrarHopedes(nomeG: String) {
    println("\n----CADASTRO DE HÓSPEDES----")

    var valor: Double
    do {
        print("Qual o valor padrão da diária? ")
        valor = readln().toDoubleOrNull() ?: -1.0
    } while (valor <= 0)

    var contGra = 0
    var contMeia = 0
    var contInt = 0

    while (true) {
        var nome: String
        do {
            print("Qual o nome do Hóspede? ")
            nome = readln().uppercase()
        } while (!nome.matches(Regex("^[A-Za-zÀ-ÿ ]+$")))

        if (nome == "PARE") break

        var idade: Int
        do {
            print("Qual a idade do Hóspede? ")
            idade = readln().toIntOrNull() ?: -1
        } while (idade < 0 || idade > 120)

        when {
            idade < 6 -> contGra++
            idade > 60 -> contMeia++
            else -> contInt++
        }
    }

    val total = calculaPassagens(valor, contMeia, contInt)
    println("\n$nomeG, o valor total das hospedagens é: R$%.2f; $contGra gratuidade(s); $contMeia meia(s)\n".format(total))
}

fun menuCPLH() {
    val hospedes = mutableListOf<String>()

    while (true) {
        println("\n1-Cadastrar\n2-Pesquisar\n3-Listar\n4-Sair")
        print("OPÇÃO: ")
        when (readln().toIntOrNull()) {
            1 -> cadastrar(hospedes)
            2 -> pesquisar(hospedes)
            3 -> listar(hospedes)
            4 -> return
            else -> println("Opção inválida\n")
        }
    }
}

fun cadastrar(hospedes: MutableList<String>) {
    if (hospedes.size >= 15) return
    var nome: String
    do {
        print("Qual o nome do Hóspede: ")
        nome = readln()
    } while (!nome.matches(Regex("^[A-Za-zÀ-ÿ ]+$")))
    hospedes.add(nome)
    println("Hóspede $nome foi cadastrada(o) com sucesso!\n")
}

fun listar(list: MutableList<String>) {
    if (list.isEmpty()) {
        println("Não há hóspedes cadastrados\n")
        return
    }
    list.forEachIndexed { index, hospede -> println("${index + 1} - $hospede") }
}

fun pesquisar(list: MutableList<String>) {
    if (list.isEmpty()) {
        println("Não há hóspedes para pesquisar\n")
        return
    }

    var nome: String
    do {
        print("Digite o nome que deseja procurar: ")
        nome = readln()
    } while (!nome.matches(Regex("^[A-Za-zÀ-ÿ ]+$")))

    val encontrado = list.indexOfFirst { it.equals(nome, ignoreCase = true) }
    if (encontrado != -1) println("Hóspede $nome foi encontrado!\n") else println("Hóspede $nome não encontrado\n")
}

fun postoCombus(nome: String) {
    var alcoolW: Double
    var gasolinaW: Double
    var alcoolStark: Double
    var gasolinaStark: Double

    do {
        print("Qual o valor do álcool no posto Wayne Oil: ")
        alcoolW = readln().toDoubleOrNull() ?: -1.0
    } while (alcoolW <= 0)

    do {
        print("Qual o valor da gasolina no posto Wayne Oil: ")
        gasolinaW = readln().toDoubleOrNull() ?: -1.0
    } while (gasolinaW <= 0)

    do {
        print("Qual o valor do álcool no posto Stark Petrol: ")
        alcoolStark = readln().toDoubleOrNull() ?: -1.0
    } while (alcoolStark <= 0)

    do {
        print("Qual o valor da gasolina no posto Stark Petrol: ")
        gasolinaStark = readln().toDoubleOrNull() ?: -1.0
    } while (gasolinaStark <= 0)

    val tipoWayne = if ((alcoolW / gasolinaW * 100) > 70) "gasolina" else "alcool"
    val tipoStark = if ((alcoolStark / gasolinaStark * 100) > 70) "gasolina" else "alcool"

    val postoFinal = when {
        tipoWayne == tipoStark && tipoWayne == "gasolina" -> if (gasolinaW < gasolinaStark) "Wayne Oil" else "Stark Petrol"
        tipoWayne == tipoStark && tipoWayne == "alcool" -> if (alcoolW < alcoolStark) "Wayne Oil" else "Stark Petrol"
        tipoWayne == "alcool" && tipoStark == "gasolina" -> if (alcoolW < gasolinaStark) "Wayne Oil" else "Stark Petrol"
        else -> if (gasolinaW < alcoolStark) "Wayne Oil" else "Stark Petrol"
    }

    println("\n$nome, é mais barato abastecer com $tipoWayne no posto $postoFinal\n")
}

fun eventos() {
    println("\n-----EVENTOS-----")

    var convidados: Int
    do {
        print("Qual o número de convidados para o seu evento? ")
        convidados = readln().toIntOrNull() ?: -1
    } while (convidados <= 0 || convidados > 350)

    val auditorio = if (convidados > 220) "Colorado" else {
        var aud = "Laranja"
        if (convidados > 150) aud += " (inclua mais ${convidados - 150} cadeiras)"
        aud
    }
    println("Use o auditório $auditorio\n")

    var dia: String
    val semana = listOf("segunda", "terca", "quarta", "quinta", "sexta", "sabado", "domingo")
    do {
        print("Digite o dia do seu evento: ")
        dia = readln().lowercase()
    } while (!semana.contains(dia))

    var hora: Int
    val horario = if (dia == "sabado" || dia == "domingo") 7..15 else 7..23
    do {
        print("Qual a hora do evento? ")
        hora = readln().toIntOrNull() ?: -1
    } while (hora !in horario)

    print("Digite o nome da empresa: ")
    val empresa = readln()
    println("Auditório reservado para $empresa $dia às $hora hs.\n")

    var duracao: Int
    do {
        print("Qual a duração do evento em horas? ")
        duracao = readln().toIntOrNull() ?: -1
    } while (duracao <= 0 || duracao > horario.last - hora)

    val garcons = (convidados / 4.0).toInt()
    println("São necessários $garcons garçons.")

    val custoGarcons = garcons * 10.5
    println("Custo do garçons: R$%.2f\n".format(custoGarcons))

    buffet(convidados, duracao, empresa, dia, hora, auditorio, garcons, custoGarcons)
}

fun buffet(
    convidados: Int, duracao: Int, empresa: String, dia: String,
    hora: Int, auditorio: String, garcons: Int, custoGarcons: Double
) {
    val cafe = 0.2 * convidados
    val agua = 0.5 * convidados
    val salgados = 7 * convidados
    val custoBuffet = cafe * 0.8 + agua * 0.4 + (salgados / 100.0) * 34

    println("O evento precisará de %.1f litros de café, %.1f litros de água, %d salgados.\n".format(cafe, agua, salgados))

    println("Evento no Auditório $auditorio.")
    println("Nome da Empresa: $empresa.")
    println("Data: ${dia.replaceFirstChar { it.uppercase() }}, ${hora}H às ${hora + duracao}H.")
    println("Duração do evento: $duracao H.")
    println("Quantidade de garçons: $garcons.")
    println("Quantidade de Convidados: $convidados")
    println("Custo do garçons: R$%.2f".format(custoGarcons))
    println("Custo do Buffet: R$%.2f".format(custoBuffet))

    val valorTotal = custoGarcons + custoBuffet
    println("Valor total do Evento: R$%.2f\n".format(valorTotal))

    print("Gostaria de efetuar a reserva? S/N ")
    val opcao = readln().uppercase()
    if (opcao == "S") println("$empresa, reserva efetuada com sucesso.\n") else println("Reserva não efetuada.\n")
}

fun manutencaoArCondicionado() {
    val empresas = mutableListOf<String>()
    val valores = mutableListOf<Double>()
    var resp: String

    do {
        println("\n----- NOVO ORÇAMENTO DE AR-CONDICIONADO -----")
        print("Qual o nome da empresa? ")
        val nomeEmpresa = readln()

        var valorPorAparelho: Double
        var quantidadeAparelhos: Int
        var percentualDesconto: Double
        var minAparelhos: Int

        do {
            print("Qual o valor por aparelho? ")
            valorPorAparelho = readln().toDoubleOrNull() ?: -1.0
        } while (valorPorAparelho <= 0)

        do {
            print("Qual a quantidade de aparelhos? ")
            quantidadeAparelhos = readln().toIntOrNull() ?: -1
        } while (quantidadeAparelhos <= 0)

        do {
            print("Qual a porcentagem de desconto? ")
            percentualDesconto = readln().toDoubleOrNull() ?: -1.0
        } while (percentualDesconto < 0)

        do {
            print("Qual o número mínimo de aparelhos para conseguir o desconto? ")
            minAparelhos = readln().toIntOrNull() ?: -1
        } while (minAparelhos < 0)

        var total = valorPorAparelho * quantidadeAparelhos
        if (quantidadeAparelhos >= minAparelhos) total -= total * (percentualDesconto / 100)

        println("\nO serviço de $nomeEmpresa custará R$ %.2f\n".format(total))

        empresas.add(nomeEmpresa)
        valores.add(total)

        do {
            print("Deseja informar novos dados, $nomeEmpresa? (S/N) ")
            resp = readln().uppercase()
        } while (resp != "S" && resp != "N")

    } while (resp == "S")

    if (empresas.size >= 2) {
        val minIndex = valores.indexOf(valores.minOrNull()!!)
        println("\nO orçamento de menor valor é o de ${empresas[minIndex]} por R$ %.2f\n".format(valores[minIndex]))
    }
}

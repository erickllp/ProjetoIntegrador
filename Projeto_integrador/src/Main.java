import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<String> produtos = new ArrayList<>();
        ArrayList<Double> precos = new ArrayList<>();
        ArrayList<Integer> estoque = new ArrayList<>();
        ArrayList<Integer> carrinhoqtd = new ArrayList<>();
        ArrayList<String> carrinhoproduto = new ArrayList<>();
        ArrayList<Double> carrinhopreco = new ArrayList<>();

        String email = "";
        int senha;
        int escolha = 0;
        boolean menu = true;
        Scanner sc = new Scanner(System.in);


        while (menu) {
            System.out.println("Bem vindo a Areco\n");
            System.out.print("Email:");
            email = sc.next();
            System.out.print("Senha:");
            senha = sc.nextInt();

            if (email.equals("adminADM") && senha == 12345) {
                boolean ADM = true;

                while (ADM) {
                    System.out.println("Estoque Tributario\n");
                    System.out.println("1 - Adicionar item ao estoque.\n2 - Remover Item\n3 - conferir estoque \n4 - tributações/relatorio \n5 - trocar de conta\n0 - sair");
                    escolha = sc.nextInt();
                    switch (escolha) {
                        case 1:
                            System.out.println(" --------- ADICIONAR ESTOQUE ----------\n");
                            System.out.println("quantos produtos distintos deseja adicionar:  ");
                            int qtd = sc.nextInt();

                            for (int i = 0; i < qtd; i++) {
                                System.out.println("insira nome do componente: ");
                                String produto = sc.next();
                                produtos.add(produto);

                                System.out.println("insira quantia de: " + produto);
                                int quantia = sc.nextInt();
                                estoque.add(quantia);

                                System.out.println("preço do produto: ");
                                double preco = sc.nextDouble();
                                precos.add(preco);
                                System.out.println("----------------------------------");

                                System.out.println("ESTOQUE ATUAL\n");
                                for (int a = 0; a < produtos.size(); a++) {
                                    System.out.println(a + " - " + produtos.get(a) + "\n Quantidade: " + estoque.get(a) + "\n preço: " + precos.get(a) + "R$\n");
                                }

                            }
                            ;
                            break;
                        case 2:
                            System.out.println(" --------- REMOVER ESTOQUE ---------\n");
                            if (produtos.size() <= 0) {
                                System.out.println("estoque vazio");
                            } else {
                                for (int rem = 0; rem < produtos.size(); rem++) {
                                    System.out.println(rem + " - " + produtos.get(rem) + "\n Quantidade: " + estoque.get(rem) + "\n preço: " + precos.get(rem) + "R$\n");

                                }
                                ;
                            }
                            ;
                            System.out.println("------------------------");
                            System.out.println("o que deseja remover: ");
                            int removeproduto = sc.nextInt();
                            System.out.println("quantos deseja remover: ");
                            int qntdRemove = sc.nextInt();

                            if (qntdRemove <= estoque.get(removeproduto)) {
                                estoque.set(removeproduto, estoque.get(removeproduto) - qntdRemove);
                                System.out.println("atualizado.");
                                System.out.println();
                            } else {
                                System.out.println("não é possivel executar essa ação");
                                System.out.println();
                            }
                            ;
                            break;
                        case 3:
                            System.out.println(" --------- CONFERIR ESTOQUE ---------\n");
                            System.out.println("componentes disponiveis: ");
                            System.out.println(produtos);
                            System.out.println(estoque);
                            System.out.println();
                            System.out.println("---------------------------------------");
                            System.out.println();
                            break;
                        case 4:
                            System.out.println(" --------- TRIBUTAÇÕES - RELATÓRIO --------- \n" +
                                    "Impostos Envolvidos:\n" + "ICMS - 18%\nIPI - 5%\nPIS/pasep - 1,65%\nCONFINS - 7,60%");

                            for (int b = 0; b < produtos.size(); b++) {
                                double impostos = (18 + 5 + 1.65 + 7.60) / 100;
                                double somados = estoque.get(b) * precos.get(b);
                                double sobreimposto = somados - (somados * impostos);
                                System.out.println("-------------------------------------------------------");
                                System.out.printf(
                                        "Valor bruto do: %s = %.2f%nVALOR LIQUIDO: %s = %.2f%n%n",
                                        produtos.get(b),
                                        somados,
                                        produtos.get(b),
                                        sobreimposto
                                );

                                System.out.println("------------------------------------");
                                System.out.println();
                            }
                            break;
                        case 5:
                            ADM = false;
                            break;
                        case 0:
                            menu = false;
                            ADM = false;
                            break;
                        default:
                            System.out.println("opção incorreta");

                    }
                }
                ;
            } else {
                boolean cliente = true;
                while (cliente) {

                    System.out.println("-------- BEM VINDO A ARECO ---------\n");
                    System.out.println("Deseja: \n1 - verificar estoque\n2 - comprar produto\n3 - Carrinho\n4 - trocar usuario \n0 - sair");
                    int selecao = 0;
                    selecao = sc.nextInt();

                    switch (selecao) {
                        case 1:
                            System.out.println("Produtos disponiveis: \n");
                            for (int i = 0; i < produtos.size(); i++) {
                                System.out.println(i + " - " + produtos.get(i)
                                        + "  R$ " + precos.get(i)
                                        + "  Estoque: " + estoque.get(i));

                            };
                            break;

                        case 2:
                            for (int i = 0; i < produtos.size(); i++) {
                                System.out.println(i + " - " + produtos.get(i) + "\n Quantidade: " + estoque.get(i) + "\n preço: " + precos.get(i) + "R$\n");
                                }
                                System.out.println("o que deseja comprar: ");
                                int compraprodutro = sc.nextInt();
                                System.out.println("quantos deseja comprar: ");
                                int qndcompra = sc.nextInt();
                                if (qndcompra <= estoque.get(compraprodutro)) {
                                    estoque.set(compraprodutro, estoque.get(compraprodutro) - qndcompra);
                                    System.out.println("Adicionado ao carrinho");
                                    System.out.println();
                                    carrinhoproduto.add(produtos.get(compraprodutro));
                                    carrinhoqtd.add(qndcompra);
                                    carrinhopreco.add(precos.get(compraprodutro));
                                } else {
                                    System.out.println("estoque insuficiente");
                                    System.out.println();
                                }
                                break;
                        case 3:
                            double total = 0;

                            for(int i =0;i<carrinhoproduto.size();i++){
                                Double subtotal = carrinhoqtd.get(i)*carrinhopreco.get(i);
                                total +=subtotal;
                                System.out.println("Carrinho: \n"+i+" - Produtos: "+carrinhoproduto.get(i)+"\nQuantidades: "+ carrinhoqtd.get(i)+
                                        "\nvalor unitario: "+carrinhopreco.get(i)+"\ntotal = "+ total);
                                System.out.println("-----------------------------------------");
                                System.out.println();
                            };
                            System.out.println("total da compra: "+total+" R$");
                            System.out.println("Deseja finalizar comprar?\nDigite 1 para sim\nDigite 2 para retornar as compras");
                            int finaliza;
                            finaliza = sc.nextInt();
                            if(finaliza == 1) {
                                JOptionPane.showMessageDialog(null,"Parabens pela compra, foi debitado automaticamente o valor de" + total);
                                System.out.println("");
                            }

                            System.out.println("Compra finalizada, retornaremos a tela inicial");
                            System.out.println("");
                            break;
                        case 4:
                            cliente = false;
                            break;


                    }
                }
            }
        }
    }
}




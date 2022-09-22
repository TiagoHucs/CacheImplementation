package com.hucs.cachedemo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NamesRepository {

    private List<String> nomes = new ArrayList<>();

    public NamesRepository(){
        nomes.addAll(Arrays.asList("Benjamin Mateus Lucca Ribeiro","Felipe Enrico Leonardo Peixoto","Allana Giovana Farias","Isabelly Laís Renata Monteiro","Analu Cecília Patrícia Caldeira","Malu Allana da Cunha","Regina Alice Ferreira","Lucca Daniel Marcos Vinicius dos Santos",
                "Laura Clara Lúcia Figueiredo","Isadora Rosângela Galvão","Rebeca Bárbara Drumond","Emily Emily Carla Cardoso","Bianca Lívia Corte Real","Alana Isabela Heloise Silveira","Francisco Matheus Pedro Henrique Almeida","Marcos Martin Pinto",
                "Milena Andrea Priscila Moraes","Lorenzo Ruan Porto","Benedita Emilly Ayla Brito","Heloisa Eloá Lívia Lopes","Lucas Manoel Nogueira","Iago Vitor da Cruz","Theo Nathan Hugo da Mata","Mário João Alves","Lucca Otávio Jesus","Stella Patrícia Aragão",
                "Rita Esther Rodrigues","Heloise Rayssa Maria Martins","Emily Rebeca Fernandes","Benjamin Ricardo Matheus Aparício","Isadora Evelyn da Cruz","Cecília Cláudia Jaqueline da Paz","Andrea Ayla Assis","Henrique Augusto Freitas","Leandro Lucas Thiago Monteiro",
                "Maya Isadora Costa","Sebastiana Bárbara Emily Cardoso","Adriana Valentina Eduarda Melo","Isaac Arthur Theo Lima","Olivia Sebastiana da Costa","Luiz Heitor Julio Galvão","Rayssa Camila Elisa Duarte","Carla Brenda Rita Sales","Fernando Hugo Giovanni Ramos","Agatha Débora Baptista",
                "Natália Rita Letícia da Rosa","Emily Márcia Clarice Martins","Mário Bruno Sérgio dos Santos","Yasmin Sophie Rocha","Sophie Elaine Francisca Cavalcanti","Patrícia Marlene Giovana Ferreira","Erick Daniel Campos","Manuel Gael Rezende",
                "Thomas Vicente João Gonçalves","Gustavo Pedro Nascimento","Regina Joana Priscila Lopes","Guilherme Thomas Souza","Alexandre Samuel da Costa","Benício Pedro Sérgio Bernardes","Matheus Nelson Cauã Castro"));
    }

    public List<String> list(String filtro){
        System.out.println("buscou no Repository");
        return nomes.stream().filter(n -> n.contains(filtro)).collect(Collectors.toList());
    }

    public void save(String nome) {
        nomes.add(nome);
    }
}

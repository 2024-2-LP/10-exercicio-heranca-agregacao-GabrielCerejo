package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class Consultoria {

    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(String nome, Integer vagas, List<Desenvolvedor> desenvolvedores) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if (vagas > desenvolvedores.size()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double soma = 0.0;

        for (int i = 0; i < desenvolvedores.size(); i++) {
            Desenvolvedor desenvolvedorAtual = desenvolvedores.get(i);

            soma += desenvolvedorAtual.calcularSalario();
        }

        return soma;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer totalMobile = 0;

        for (int i = 0; i < desenvolvedores.size(); i++) {
            if (desenvolvedores.get(i) instanceof DesenvolvedorMobile){
                totalMobile++;
            }
        }

        return totalMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> listaDevs = new ArrayList<>();

        for (int i = 0; i < desenvolvedores.size(); i++) {
            Desenvolvedor devAtual = desenvolvedores.get(i);

            if (devAtual.calcularSalario() >= salario){
                listaDevs.add(devAtual);
            }
        }

        return listaDevs;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty()){
            return null;
        }

        Desenvolvedor desenvolvedorMenorSalario = desenvolvedores.get(0);

        for (int i = 0; i < desenvolvedores.size(); i++) {
            Desenvolvedor devAtual = desenvolvedores.get(i);

            if (devAtual.calcularSalario() < desenvolvedorMenorSalario.calcularSalario()){
                desenvolvedorMenorSalario = devAtual;
            }
        }

        return desenvolvedorMenorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> devs = new ArrayList<>();

        for (int i = 0; i < desenvolvedores.size(); i++) {
            if (desenvolvedores.get(i) instanceof DesenvolvedorMobile){
                if (((DesenvolvedorMobile) desenvolvedores.get(i)).getLinguagem().equalsIgnoreCase(tecnologia) || ((DesenvolvedorMobile) desenvolvedores.get(i)).getPlataforma().equalsIgnoreCase(tecnologia)){
                    devs.add(desenvolvedores.get(i));
                }
            }

            if (desenvolvedores.get(i) instanceof DesenvolvedorWeb){
                if (((DesenvolvedorWeb) desenvolvedores.get(i)).getFrontend().equalsIgnoreCase(tecnologia) || ((DesenvolvedorWeb) desenvolvedores.get(i)).getBackend().equalsIgnoreCase(tecnologia) || ((DesenvolvedorWeb) desenvolvedores.get(i)).getSgbd().equalsIgnoreCase(tecnologia)){
                    devs.add(desenvolvedores.get(i));
                }
            }
        }

        return devs;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        List<Desenvolvedor> devs = new ArrayList<>();
        Double somaSalarios = 0.0;

        for (int i = 0; i < desenvolvedores.size(); i++) {
            if (desenvolvedores.get(i) instanceof DesenvolvedorMobile){
                if (((DesenvolvedorMobile) desenvolvedores.get(i)).getLinguagem().equalsIgnoreCase(tecnologia) || ((DesenvolvedorMobile) desenvolvedores.get(i)).getPlataforma().equalsIgnoreCase(tecnologia)){
                    somaSalarios += desenvolvedores.get(i).calcularSalario();
                }
            }

            if (desenvolvedores.get(i) instanceof DesenvolvedorWeb){
                if (((DesenvolvedorWeb) desenvolvedores.get(i)).getFrontend().equalsIgnoreCase(tecnologia) || ((DesenvolvedorWeb) desenvolvedores.get(i)).getBackend().equalsIgnoreCase(tecnologia) || ((DesenvolvedorWeb) desenvolvedores.get(i)).getSgbd().equalsIgnoreCase(tecnologia)){
                    somaSalarios += desenvolvedores.get(i).calcularSalario();
                }
            }
        }

        return somaSalarios;
    }
}

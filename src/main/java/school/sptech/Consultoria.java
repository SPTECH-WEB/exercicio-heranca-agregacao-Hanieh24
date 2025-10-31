package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public void contratar(Desenvolvedor desenvolvedor){
        if (vagas>desenvolvedores.size()){
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
        for (Desenvolvedor desenvolvedor : desenvolvedores){
            soma += desenvolvedor.calcularSalario();
        }
        return soma;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer contagem = 0;
        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorMobile){
                contagem++;
            }
        }
        return contagem;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> resposta=new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor.calcularSalario() >= salario){
                resposta.add(desenvolvedor);
            }
        }
        return resposta;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty()){
            return null;
        }else {
            Double menor =desenvolvedores.get(0).calcularSalario();
            Desenvolvedor desenvolvedorMenor = desenvolvedores.get(0);
            for (Desenvolvedor desenvolvedor : desenvolvedores){
                if (desenvolvedor.calcularSalario() < menor){
                    menor = desenvolvedor.calcularSalario();
                    desenvolvedorMenor = desenvolvedor;
                }
            }
            return desenvolvedorMenor;
        }
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> resposta = new ArrayList<>();

        for (Desenvolvedor dev : desenvolvedores){
            if (dev instanceof DesenvolvedorMobile){

                if (((DesenvolvedorMobile) dev).getPlataforma().equalsIgnoreCase(tecnologia) ||
                                ((DesenvolvedorMobile) dev).getLinguagem().equalsIgnoreCase(tecnologia)){
                    resposta.add(dev);
                }
            }else if(dev instanceof DesenvolvedorWeb){
                if (((DesenvolvedorWeb) dev).getFrontend().equalsIgnoreCase(tecnologia)||
                                ((DesenvolvedorWeb) dev).getBackend().equalsIgnoreCase(tecnologia)||
                                ((DesenvolvedorWeb) dev).getSgbd().equalsIgnoreCase(tecnologia)){
                    resposta.add(dev);
                }
            }
        }
        return resposta;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double soma = 0.0;
        List <Desenvolvedor> novo = buscarPorTecnologia(tecnologia);

        for (Desenvolvedor desenvolvedor : novo){
            soma +=desenvolvedor.calcularSalario();
        }

        return soma;
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
}

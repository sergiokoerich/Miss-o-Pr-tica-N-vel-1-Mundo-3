package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<>();

    public void inserir(PessoaFisica pessoa) {
        pessoasFisicas.add(pessoa);
    }

    public void alterar(PessoaFisica pessoa) {
        PessoaFisica pf = obter(pessoa.getId());
        if (pf != null) {
            pf.setNome(pessoa.getNome());
            pf.setCpf(pessoa.getCpf());
            pf.setIdade(pessoa.getIdade());
        }
    }

    public void excluir(int id) {
        PessoaFisica pf = obter(id);
        if (pf != null) {
            pessoasFisicas.remove(pf);
        }
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pf : pessoasFisicas) {
            if (pf.getId() == id) {
                return pf;
            }
        }
        return null;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(pessoasFisicas);
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasFisicas = (ArrayList<PessoaFisica>) ois.readObject();
        }
    }
}

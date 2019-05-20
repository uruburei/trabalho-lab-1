package grafico.controllers.Login_Cadastro;

import Entidades.Cartao;
import Entidades.Cliente;
import Entidades.Endereco;
import Negocio.*;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CLoginCliente {
    private NegocioCliente negociocliente = new NegocioCliente();
    private NegocioEndereco negocioendereco = new NegocioEndereco();
    private NegocioPessoa negociopessoa = new NegocioPessoa();
    private NegocioCartao negociocartao = new NegocioCartao();
    public Cliente cliente;public Endereco endereco;public Cartao cartao;

    @FXML
    private VBox PainelLoginCliente;

    @FXML
    private TextField CPF;

    @FXML
    private PasswordField Senha;

    @FXML
    private Label LoginError;

    @FXML
    private Button btnLogin;

    @FXML
    private Label CriarConta;

    private Parent fxml;

    @FXML
    void criarConta(MouseEvent event) {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/grafico/view/Login_Cadastro/Endereco.fxml"));
            PainelLoginCliente.getChildren().removeAll();
            PainelLoginCliente.getChildren().setAll(fxml);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void logarCliente(ActionEvent event) {
        System.out.println(negociocliente.Verificarcliente(CPF.getText(),Senha.getText()));
        if (negociocliente.Verificarcliente(CPF.getText(),Senha.getText()) != null){
            System.out.println("Entrar no programa");
            LoginError.setVisible(false);
        }else {
            LoginError.setVisible(true);
        }
    }

    //---------------------------------------------cadastro

    @FXML
    private VBox PainelEndereco;

    @FXML
    private TextField Lugadouro;

    @FXML
    private TextField Numero;

    @FXML
    private TextField Bairro;

    @FXML
    private TextField Cidade;

    @FXML
    private TextField Estado;

    @FXML
    private TextField Cep;

    @FXML
    private Label ErroEndereco;

    @FXML
    private Button btnClienteEndereco;

    private Parent fxml2;



    @FXML
    void logarClienteEndereco(ActionEvent event) {
       if(negocioendereco.validarCEPGrafico(Cep.getText())){
           endereco = new Endereco(Lugadouro.getText(), Cep.getText(), Numero.getText(), Bairro.getText(),
                   Cidade.getText(), Estado.getText());
           try {
               fxml2 = FXMLLoader.load(getClass().getResource("/grafico/view/Login_Cadastro/cadastroCliente.fxml"));
               PainelEndereco.getChildren().removeAll();
               PainelEndereco.getChildren().setAll(fxml2);
           } catch (IOException ex) {
               ex.printStackTrace();
           }
           ErroEndereco.setVisible(false);
       }else {
           ErroEndereco.setText("Cep invalido");
           ErroEndereco.setVisible(true);
       }


    }


    //------------------------------------Cliente-------------------------------------


    @FXML
    private VBox PainelDados;

    @FXML
    private TextField Nome;

    @FXML
    private TextField Data;

    @FXML
    private TextField CPF2;

    @FXML
    private PasswordField Senha2;

    @FXML
    private ToggleButton ifCartao;

    @FXML
    private Button btnClienteDados;

    @FXML
    private Label ErroDados;



    @FXML
    void logarClienteFim(ActionEvent event) {
        if (negociopessoa.validarCPFGrafico(CPF2.getText()) && negociopessoa.validarDataNascimentoGrafico(Data.getText())){
            if (!ifCartao.isSelected()){
                cliente = new Cliente(Nome.getText(), CPF2.getText(), Data.getText(), endereco, Senha2.getText());
                negociocliente.CadastroCliente(cliente);
                negociocliente.getDadoscliente().atualizarArquivo();
                try {
                    fxml2 = FXMLLoader.load(getClass().getResource("/grafico/view/Login_Cadastro/loginCliente.fxml"));
                    PainelDados.getChildren().removeAll();
                    PainelDados.getChildren().setAll(fxml2);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }else {
                try {
                    fxml2 = FXMLLoader.load(getClass().getResource("/grafico/view/Login_Cadastro/cadastroClienteCartao.fxml"));
                    PainelDados.getChildren().removeAll();
                    PainelDados.getChildren().setAll(fxml2);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            ErroDados.setVisible(false);
        }else {
            if (!negociopessoa.validarCPFGrafico(CPF2.getText())){
                ErroDados.setText("Cpf esta invalida");
            }else if (!negociopessoa.validarDataNascimentoGrafico(Data.getText())){
                ErroDados.setText("Data de nascimento esta invalida");
            }
            ErroDados.setVisible(true);
        }
    }
//------------------------------------------------cartão
    @FXML
    private VBox PainelCartao;

    @FXML
    private TextField NomeTitular;

    @FXML
    private TextField NumeroCartao;

    @FXML
    private TextField DataValidade;

    @FXML
    private PasswordField CodSeguranca;

    @FXML
    private TextField Limite;

    @FXML
    private Label ErrorCartao;

    @FXML
    void logarClienteFim2(ActionEvent event) {
        if (negociocartao.validarCodigoDeSegurancaGrafico(CodSeguranca.getText()) && negociocartao.validarDatadeValidadeGrafico(DataValidade.getText())
        && negociocartao.validarNumeroGrafico(NumeroCartao.getText())) {
            cartao = new Cartao(NomeTitular.getText(), NumeroCartao.getText(), DataValidade.getText(),
                    Integer.parseInt(CodSeguranca.getText()), Double.parseDouble(Limite.getText()));
            System.out.println(endereco.toString());
            System.out.println(cartao.toString());
            cliente = new Cliente(Nome.getText(), CPF2.getText(), Data.getText(), cartao, endereco, Senha2.getText());
            System.out.println(cliente.toString());
            negociocliente.CadastroCliente(cliente);
            negociocliente.getDadoscliente().atualizarArquivo();
            ErrorCartao.setVisible(false);
        }else {
            if (!negociocartao.validarCodigoDeSegurancaGrafico(CodSeguranca.getText())){
                ErrorCartao.setText("Codigo esta invalida");
            }else if (!negociocartao.validarNumeroGrafico(NumeroCartao.getText())){
                ErrorCartao.setText("Numero do cartao esta invalida");
            }else if (!negociocartao.validarDatadeValidadeGrafico(DataValidade.getText())){
                ErrorCartao.setText("Validade do cartao esta invalida");
            }
            ErrorCartao.setVisible(true);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Cliente;
import model.Empregado;
import model.OrderSimple;
import model.PedidosView;
import model.ProductCart;
import model.ProductView;
import model.Produto;
import utilities.AliasID;
import utilities.Conexao;

/**
 * FXML Controller class
 *
 * @author ayrto
 */
public class TelaInicialController implements Initializable {

    //ListView
    //Spinners
    @FXML
    private Spinner<Integer> increase;

    //Buttons
    @FXML
    private Button mCliente;

    @FXML
    private Button btComprar;

    @FXML
    private Button mVendas;

    @FXML
    private Button mProdutos;

    @FXML
    private Button mRelatorios;

    @FXML
    private Button btBuscarCliente;

    @FXML
    private Button btExibirPedidos;

    @FXML
    private Button exitButton;

    //Vbox
    @FXML
    private VBox visualizar;

    @FXML
    private VBox vendas;

    @FXML
    private VBox relatorios;

    @FXML
    private VBox exibirUser;

    @FXML
    private VBox editarC;

    @FXML
    private VBox cadastrarC;

    @FXML
    private VBox exibirPedidos;

    @FXML
    private VBox fPedidos;

    //Text
    @FXML
    private Text welcome;

    @FXML
    private Text eCompanyID;

    @FXML
    private Text eCompanyName;

    @FXML
    private Text eContactName;

    @FXML
    private Text eTitleName;

    @FXML
    private Text eAddress;

    @FXML
    private Text eCity;

    @FXML
    private Text eRegion;

    @FXML
    private Text eCountry;

    @FXML
    private Text ePostalCode;

    @FXML
    private Text ePhone;

    @FXML
    private Text eFax;

    //Text Produtos
    @FXML
    private Text vProductID;

    @FXML
    private Text vProductName;

    @FXML
    private Text vDesc;

    @FXML
    private Text vCategory;

    @FXML
    private Text vUnitStock;

    @FXML
    private Text vPrice;

    @FXML
    private Text vSupplier;

    @FXML
    private Text vCompanyName;

    @FXML
    private Text vCompanyID;

    //TextFields
    @FXML
    private TextField textFieldBuscaClientes;

    // TextField: Cadastrar Cliente
    @FXML
    private Text cCompanyID;

    @FXML
    private TextField cCompanyName;

    @FXML
    private TextField cContactName;

    @FXML
    private TextField cTitleName;

    @FXML
    private TextField cAddress;

    @FXML
    private TextField cCity;

    @FXML
    private TextField cRegion;

    @FXML
    private TextField cCountry;

    @FXML
    private TextField cPostalCode;

    @FXML
    private TextField cPhone;

    @FXML
    private TextField cFax;

    //TextField: Editar Cliente
    @FXML
    private Text aCompanyID;

    @FXML
    private TextField aCompanyName;

    @FXML
    private TextField aContactName;

    @FXML
    private TextField aTitleName;

    @FXML
    private TextField aAddress;

    @FXML
    private TextField aCity;

    @FXML
    private TextField aRegion;

    @FXML
    private TextField aCountry;

    @FXML
    private TextField aPostalCode;

    @FXML
    private TextField aPhone;

    @FXML
    private TextField aFax;

    //Radio Buttons
    @FXML
    private RadioButton radioNome;

    @FXML
    private RadioButton radioID;

    @FXML
    private ToggleGroup toggleBusca;

    //Listas
    @FXML
    private ObservableList<Cliente> clientes = FXCollections.observableArrayList();

    @FXML
    private ObservableList<Empregado> vendedores = FXCollections.observableArrayList();

    @FXML
    private ObservableList<ProductCart> cart = FXCollections.observableArrayList();

    @FXML
    private ObservableList<PedidosView> pedidos = FXCollections.observableArrayList();

    @FXML
    private ObservableList<ProductView> products = FXCollections.observableArrayList();

    //Table Clientes
    @FXML
    private TableView<Cliente> tableClientes;

    @FXML
    private TableColumn<Cliente, String> colNomeCliente;

    @FXML
    private TableColumn<Cliente, String> colIDCliente;

    //Table Pedidos
    @FXML
    private TableView<PedidosView> tableOrdersView;

    @FXML
    private TableColumn<PedidosView, Integer> colOrderID;

    @FXML
    private TableColumn<PedidosView, Integer> colProductID;

    @FXML
    private TableColumn<PedidosView, String> colProductName;

    @FXML
    private TableColumn<PedidosView, String> colOClienteName;

    @FXML
    private TableColumn<PedidosView, String> colEmployee;

    @FXML
    private TableColumn<PedidosView, Integer> colOQtd;

    @FXML
    private TableColumn<PedidosView, Float> colOPrice;

    @FXML
    private TableColumn<PedidosView, Float> colDiscount;

    //Table Products
    @FXML
    private TableView<ProductView> vTableProduct;

    @FXML
    private TableColumn<ProductView, Integer> vColProductID;

    @FXML
    private TableColumn<ProductView, String> vColProductName;

    @FXML
    private TableColumn<ProductView, Integer> vColUnitStock;

    //Table Cart
    @FXML
    private TableView<ProductCart> cartTable;

    @FXML
    private TableColumn<ProductCart, String> colCartProduto;

    @FXML
    private TableColumn<ProductCart, Float> colCartPrice;

    @FXML
    private TableColumn<ProductCart, Integer> colCartQtd;

    //Table empregados
    @FXML
    private TableView<Empregado> tableEmpregado;

    @FXML
    private TableColumn<Empregado, Integer> empregadoID;

    @FXML
    private TableColumn<Empregado, String> nomeEmpregado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        exitButton.setStyle("-fx-background-color: #f73e41;");
        btComprar.setStyle("-fx-background-color: #1388e8;");
        btBuscarCliente.setOnMouseClicked((MouseEvent e) -> {
            buscarClientes();
            tableClientes.setItems(clientes);
        });

        //
        btExibirPedidos.setOnMouseClicked((MouseEvent e) -> {
            buscarPedidos();
            tableOrdersView.setItems(pedidos);
        });

        //clientes = FXCollections.observableArrayList(Conexao.selectAllCustomers());
        //Inicializa as colunas de Cliente
        colNomeCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("companyName"));
        colIDCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("customerID"));

        //Inicializa as colunas de OrderDetails
        colOrderID.setCellValueFactory(new PropertyValueFactory<PedidosView, Integer>("orderID"));
        colProductID.setCellValueFactory(new PropertyValueFactory<PedidosView, Integer>("productID"));
        colProductName.setCellValueFactory(new PropertyValueFactory<PedidosView, String>("productName"));
        colOClienteName.setCellValueFactory(new PropertyValueFactory<PedidosView, String>("cliente"));
        colEmployee.setCellValueFactory(new PropertyValueFactory<PedidosView, String>("vendedo"));
        colOQtd.setCellValueFactory(new PropertyValueFactory<PedidosView, Integer>("qtd"));
        colOPrice.setCellValueFactory(new PropertyValueFactory<PedidosView, Float>("unitPrice"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<PedidosView, Float>("discount"));

        //Inicializa as colunas de ProductView
        vColProductID.setCellValueFactory(new PropertyValueFactory<ProductView, Integer>("productID"));
        vColProductName.setCellValueFactory(new PropertyValueFactory<ProductView, String>("productName"));
        vColUnitStock.setCellValueFactory(new PropertyValueFactory<ProductView, Integer>("qtd"));

        //Inicializar cart
        colCartProduto.setCellValueFactory(new PropertyValueFactory<ProductCart, String>("productName"));
        colCartPrice.setCellValueFactory(new PropertyValueFactory<ProductCart, Float>("unitPrice"));
        colCartQtd.setCellValueFactory(new PropertyValueFactory<ProductCart, Integer>("qtd"));
        
        //Inicializar cart
        nomeEmpregado.setCellValueFactory(new PropertyValueFactory<Empregado, String>("nome"));
        empregadoID.setCellValueFactory(new PropertyValueFactory<Empregado, Integer>("employeeID"));
        

        //last to load
        cartTable.setItems(cart);
        vTableProduct.setItems(products);
        tableOrdersView.setItems(pedidos);
        tableClientes.setItems(clientes);
        tableClientes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        vTableProduct.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableEmpregado.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableClientes.setPlaceholder(new Label("Nenhuma busca executada"));
        tableEmpregado.setItems(vendedores);

        vTableProduct.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ProductView>() {

            @Override
            public void changed(ObservableValue<? extends ProductView> observable, ProductView oldValue, ProductView newValue) {
                vProductID.setText(String.valueOf(newValue.getProductID()));
                vProductName.setText(newValue.getProductName());
                vDesc.setText(newValue.getDesc());
                vCategory.setText(newValue.getCategoryName());
                vUnitStock.setText(String.valueOf(newValue.getQtd()));
                vPrice.setText(String.valueOf(newValue.getPrice()));
                vSupplier.setText(newValue.getSupplier());
            }
        });

    }

    // Botão Clientes
    public void mCliente() {
        menuDefault();
        setInvisibleAllMenu();
        mCliente.setStyle("-fx-background-color: #439fe5; "
                + "-fx-border-color: #b6e1fc;"
                + "-fx-border-radius: 10;"
                + "-fx-border-width: 2;"
                + "-fx-bacground-radius: 10;");// Mudar a Cor
        mCliente.setTextFill(Color.WHITE);
        visualizar.setVisible(true);
        welcome.setVisible(false);
        clearAllLists();
    }

    //Botão Vendas
    public void mVendas() {
        menuDefault();
        setInvisibleAllMenu();
        mVendas.setStyle("-fx-background-color: #439fe5; "
                + "-fx-border-color: #b6e1fc;"
                + "-fx-border-radius: 10;"
                + "-fx-border-width: 2;"
                + "-fx-bacground-radius: 10;");// Mudar a Cor
        mVendas.setTextFill(Color.WHITE);
        exibirPedidos.setVisible(true);
        welcome.setVisible(false);
        clearAllLists();
    }

    // Botão Relatorios
    public void mRelatorios() {
        menuDefault();
        setInvisibleAllMenu();
        mRelatorios.setStyle("-fx-background-color: #439fe5; "
                + "-fx-border-color: #b6e1fc;"
                + "-fx-border-radius: 10;"
                + "-fx-border-width: 2;"
                + "-fx-bacground-radius: 10;");// Mudar a Cor
        mRelatorios.setTextFill(Color.WHITE);
        relatorios.setVisible(true);
        welcome.setVisible(false);
        clearAllLists();
    }

    //Metodos da tela clientes/buscar
    public void buscarClientes() {
        if (textFieldBuscaClientes.getText().isEmpty()) {
            clientes = FXCollections.observableArrayList(Conexao.selectAllCustomers());
        } else if (radioNome.isSelected()) {
            System.out.println(textFieldBuscaClientes.getText());
            clientes = FXCollections.observableArrayList(Conexao.selectCustomerByName(textFieldBuscaClientes.getText()));
        } else if (radioID.isSelected()) {
            System.out.println("ID!! OK");
            clientes = FXCollections.observableArrayList(Conexao.selectCustomerByID(textFieldBuscaClientes.getText()));
        }

    }

    //Uteis default;
    public void menuDefault() {
        allInvisible();
        mCliente.setTextFill(Color.BLACK);
        mCliente.setStyle("-fx-background-color: #87CEFA; "
                + "-fx-border-color: #b6e1fc;"
                + "-fx-border-radius: 10;"
                + "-fx-border-width: 2;"
                + "-fx-bacground-radius: 10;");
        mVendas.setTextFill(Color.BLACK);
        mVendas.setStyle("-fx-background-color: #87CEFA; "
                + "-fx-border-color: #b6e1fc;"
                + "-fx-border-radius: 10;"
                + "-fx-border-width: 2;"
                + "-fx-bacground-radius: 10;");
        mRelatorios.setTextFill(Color.BLACK);
        mRelatorios.setStyle("-fx-background-color: #87CEFA; "
                + "-fx-border-color: #b6e1fc;"
                + "-fx-border-radius: 10;"
                + "-fx-border-width: 2;"
                + "-fx-bacground-radius: 10;");
    }

    //Botão Novo Cliente
    public void novoCliente() {
        allInvisible();
        cadastrarC.setVisible(true);
        visualizar.setVisible(false);
    }

    public void allInvisible() {
        exibirUser.setVisible(false);
        editarC.setVisible(false);
        cadastrarC.setVisible(false);
        exibirPedidos.setVisible(false);
    }

    //Limpa as listas
    public void clearAllLists() {
        clientes.clear();
        pedidos.clear();
        tableOrdersView.setItems(pedidos);
        tableClientes.setItems(clientes);
    }

    //Exibir Cliente
    public void exibirCliente() {
        Alert aviso;
        aviso = new Alert(AlertType.WARNING);
        int userSelected = tableClientes.getSelectionModel().getSelectedIndex();
        if (userSelected >= 0) {
            visualizar.setVisible(false);
            exibirUser.setVisible(true);
            Cliente c = tableClientes.getSelectionModel().getSelectedItem();
            eCompanyID.setText(c.getCustomerID());
            eCompanyName.setText(c.getCompanyName());
            eContactName.setText(c.getContactName());
            eTitleName.setText(c.getContactTitle());
            eAddress.setText(c.getAddress());
            eCity.setText(c.getCity());
            eRegion.setText(c.getRegion());
            eCountry.setText(c.getCountry());
            ePostalCode.setText(c.getPostalCode());
            ePhone.setText(c.getPhone());
            eFax.setText(c.getFax());

        } else {
            aviso.setTitle("");
            aviso.setContentText("Você não selecionou um Cliente.");
            aviso.showAndWait();
        }
    }

    public void eVoltar() {
        exibirUser.setVisible(false);
        visualizar.setVisible(true);
        clearAllLists();

    }

    // Inserir Cliente
    public void inserirCliente() {
        Alert aviso;
        aviso = new Alert(AlertType.WARNING);
        if (validarCamposCliente(cCompanyName, cContactName, cTitleName, cAddress, cCountry, cPhone, cPostalCode)) {
            Cliente cliente = new Cliente();
            cliente.setCompanyName(cCompanyName.getText());
            cliente.setCustomerID(AliasID.generateAliasID(cCompanyName.getText()));
            cliente.setContactName(cContactName.getText());
            cliente.setContactTitle(cTitleName.getText());
            cliente.setAddress(cAddress.getText());
            cliente.setCity(cCity.getText());
            cliente.setRegion(cRegion.getText());
            cliente.setCountry(cCountry.getText());
            cliente.setPostalCode(cPostalCode.getText());
            cliente.setPhone(cPhone.getText());
            cliente.setFax(cFax.getText());
            boolean resultado = Conexao.inserirCliente(cliente);
            if (resultado) {
                aviso.setTitle("");
                aviso.setContentText("Cliente cadastrado com sucesso. ID: " + cliente.getCustomerID());
                aviso.showAndWait();
            } else {
                aviso.setTitle("");
                aviso.setContentText("A inserção não pode ser feita.");
                aviso.showAndWait();
            }
        } else {
            aviso.setTitle("");
            aviso.setContentText("Existem campos não preenchidos");
            aviso.showAndWait();
        }
    }

    // Update Cliente
    public void atualizarCliente() {
        Alert aviso;
        Alert info;
        info = new Alert(AlertType.CONFIRMATION);
        aviso = new Alert(AlertType.WARNING);
        if (validarCamposCliente(aCompanyName, aContactName, aTitleName, aAddress, aCountry, aPhone, aPostalCode)) {
            Cliente cliente = new Cliente();
            cliente.setCustomerID(aCompanyID.getText());
            cliente.setContactName(aContactName.getText());
            cliente.setContactTitle(aTitleName.getText());
            cliente.setAddress(aAddress.getText());
            if (aCity.getText().isEmpty()) {
                cliente.setCity(null);
            } else {
                cliente.setCity(aCity.getText());
            }
            if (aRegion.getText().isEmpty()) {
                cliente.setRegion(null);
            } else {
                cliente.setRegion(aRegion.getText());
            }
            cliente.setCountry(aCountry.getText());
            cliente.setPostalCode(aPostalCode.getText());
            cliente.setPhone(aPhone.getText());
            if (aFax.getText().isEmpty()) {
                cliente.setFax(null);
            } else {
                cliente.setFax(aFax.getText());
            }
            boolean resultado = Conexao.updateCliente(cliente);
            if (resultado) {
                info.setTitle("");
                info.setContentText("Cliente alterado com sucesso.");
                info.showAndWait();
            } else {
                aviso.setTitle("");
                aviso.setContentText("A atualização não pode ser feita.");
                aviso.showAndWait();
            }
        } else {
            aviso.setTitle("");
            aviso.setContentText("Existem campos não preenchidos ou com valores incoretos");
            aviso.showAndWait();
        }
    }

    public void goEditarCliente() {
        Alert aviso;
        aviso = new Alert(AlertType.WARNING);
        int userSelected = tableClientes.getSelectionModel().getSelectedIndex();
        if (userSelected >= 0) {
            visualizar.setVisible(false);
            editarC.setVisible(true);
            Cliente c = tableClientes.getSelectionModel().getSelectedItem();
            aCompanyID.setText(c.getCustomerID());
            aCompanyName.setText(c.getCompanyName());
            aContactName.setText(c.getContactName());
            aTitleName.setText(c.getContactTitle());
            aAddress.setText(c.getAddress());
            aCity.setText(c.getCity());
            aRegion.setText(c.getRegion());
            aCountry.setText(c.getCountry());
            aPostalCode.setText(c.getPostalCode());
            aPhone.setText(c.getPhone());
            aFax.setText(c.getFax());

        } else {
            aviso.setTitle("");
            aviso.setContentText("Você não selecionou um Cliente.");
            aviso.showAndWait();
        }
    }

    //Remover Cliente
    public void removerCliente() {
        Alert aviso;
        Alert info;
        info = new Alert(AlertType.INFORMATION);
        aviso = new Alert(AlertType.WARNING);
        int userSelected = tableClientes.getSelectionModel().getSelectedIndex();
        if (userSelected >= 0) {
            Cliente c = tableClientes.getSelectionModel().getSelectedItem();
            boolean resultado = Conexao.deleteCliente(c);
            if (resultado) {
                info.setTitle("");
                info.setContentText("O cliente " + c.getCompanyName() + " foi removido com sucesso.");
                info.showAndWait();
            } else {
                aviso.setTitle("");
                aviso.setContentText("O cliente " + c.getCompanyName() + " não pode ser removido.");
            }

        } else {
            aviso.setTitle("");
            aviso.setContentText("Você não selecionou um Cliente.");
            aviso.showAndWait();
        }
    }

    // Validar Campos de Cliente
    public boolean validarCamposCliente(TextField companyName, TextField contactName, TextField titleName, TextField address, TextField country, TextField phone, TextField postalCode) {

        if (companyName.getText().isEmpty()) {
            return false;
        } else if (contactName.getText().isEmpty()) {
            return false;
        } else if (titleName.getText().isEmpty()) {
            return false;
        } else if (address.getText().isEmpty()) {
            return false;
        } else if (country.getText().isEmpty()) {
            return false;
        } else if (phone.getText().isEmpty()) {
            return false;
        } else if (postalCode.getText().length() > 10) {
            return false;
        }

        return true;
    }

    public void buscarPedidos() {
        pedidos = FXCollections.observableArrayList(Conexao.selectAllOrders());
    }

    //Sai da Aplicação
    public void exit() {
        Alert certeza = new Alert(AlertType.CONFIRMATION);
        certeza.setTitle("Sair do Programa");
        certeza.setContentText("Deseja sair?");
        Optional<ButtonType> resposta = certeza.showAndWait();
        if (resposta.get() == ButtonType.OK) {
            System.exit(0);
        }

    }

    //Comprar
    //Botão comprar
    public void goComprar() {
        Alert aviso;
        aviso = new Alert(AlertType.WARNING);
        int userSelected = tableClientes.getSelectionModel().getSelectedIndex();
        if (userSelected >= 0) {
            setInvisibleAllMenu();
            vendas.setVisible(true);
            products = FXCollections.observableArrayList(Conexao.selectAllProducts());
            vTableProduct.setItems(products);
            Cliente c = tableClientes.getSelectionModel().getSelectedItem();
            vCompanyName.setText(c.getCompanyName());
            vCompanyID.setText(c.getCustomerID());
        } else {
            aviso.setTitle("");
            aviso.setContentText("Você não selecionou um Cliente.");
            aviso.showAndWait();
        }

    }

    //Inserir no carrinho
    public void inserirNoCarrinho() {
        Alert aviso;
        aviso = new Alert(AlertType.WARNING);
        int userSelected = vTableProduct.getSelectionModel().getSelectedIndex();
        if (userSelected >= 0) {
            ProductView p = vTableProduct.getSelectionModel().getSelectedItem();
            if (p.getQtd() == 0) {
                aviso.setTitle("");
                aviso.setContentText("Não há produto no estoque.");
                aviso.showAndWait();
            } else {
                ProductCart c = new ProductCart();
                c.setProductID(p.getProductID());
                c.setProductName(p.getProductName());
                c.setQtd(1);
                c.setUnitPrice(p.getPrice());
                c.setDiscount(0);
                cart.add(c);
               

            }

        } else {
            aviso.setTitle("");
            aviso.setContentText("Você não selecionou um Produto.");
            aviso.showAndWait();
        }
    }

    //Remover do carrinho
    public void removerProduto() {
        Alert aviso, info;
        aviso = new Alert(AlertType.WARNING);
        info = new Alert(AlertType.INFORMATION);
        if (cart.isEmpty()) {
            aviso.setTitle("");
            aviso.setContentText("O carrinho está vazio.");
            aviso.showAndWait();
        } else {
            int userSelected = cartTable.getSelectionModel().getSelectedIndex();
            ProductCart p = cartTable.getSelectionModel().getSelectedItem();
            if (userSelected >= 0) {
                cart.remove(userSelected);
                info.setTitle("");
                info.setContentText("O produto " + p.getProductName() + " foi removido do carrinho.");
                info.showAndWait();
            }
        }
    }

    // Coloca todas as telas do menu como invisiveis
    public void setInvisibleAllMenu() {
        visualizar.setVisible(false);
        vendas.setVisible(false);
        relatorios.setVisible(false);
        fPedidos.setVisible(false);
    }

    // F-Pedidos-tela 2
    public void goFPedidos() {
        Alert aviso;
        aviso = new Alert(AlertType.WARNING);
        if (!cart.isEmpty()) {
            setInvisibleAllMenu();
            fPedidos.setVisible(true);
            vendedores = FXCollections.observableArrayList(Conexao.selectEmpregados());
            tableEmpregado.setItems(vendedores);

        } else {
            aviso.setTitle("");
            aviso.setContentText("Não há produtos no carrinho.");
            aviso.showAndWait();
        }
    }
    
    

    //Pedidos Confr tela
    public void confirmarPedido() {
            int userSelected = tableEmpregado.getSelectionModel().getSelectedIndex();
            Empregado e = tableEmpregado.getSelectionModel().getSelectedItem();
            Cliente c = tableClientes.getSelectionModel().getSelectedItem();
            if (userSelected >= 0) {
                OrderSimple order = new OrderSimple();
                ArrayList<ProductCart> lista = new ArrayList<>();
                for(ProductCart p: cart){
                    lista.add(p);
                }
                order.setOrder(lista);
                order.setEmployeeID(e.getEmployeeID());
                Date data = new Date(System.currentTimeMillis());
                order.setOrderDate(data);
                order.setCustomerID(c.getCustomerID());
                
            }
    }

    
}

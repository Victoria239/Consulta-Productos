package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Producto;

public class ProductosView extends VBox {
    private TableView<Producto> tablaProductos;
    private Button btnConsultar;
    private Button btnAdd;
    private Button btnUpdate;
    private Button btnDelete;
    private Button btnSalir;
    private Button btnBuscarHuevos;
    private Button btnPasillo1;
    private TextField txtNombre;
    private TextField txtPrecio;
    private TextField txtUbicacion;

    public ProductosView() {
        // Configurar los márgenes y el espaciado
        this.setPadding(new Insets(20));
        this.setSpacing(15);
        this.setStyle("-fx-background-color: #F3E5F5;"); // Color lila claro

        // Campos de búsqueda
        txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");
        txtPrecio = new TextField();
        txtPrecio.setPromptText("Precio");
        txtUbicacion = new TextField();
        txtUbicacion.setPromptText("Ubicación");

        HBox searchBox = new HBox(10);
        searchBox.setAlignment(Pos.CENTER);
        searchBox.getChildren().addAll(
                new Label("Nombre:"), txtNombre,
                new Label("Precio:"), txtPrecio,
                new Label("Ubicación:"), txtUbicacion
        );

        // Estilo de las etiquetas
        for (int i = 0; i < searchBox.getChildren().size(); i += 2) {
            ((Label) searchBox.getChildren().get(i)).setFont(Font.font("Arial", FontWeight.NORMAL, 14));
            ((Label) searchBox.getChildren().get(i)).setStyle("-fx-text-fill: #4A148C;"); // Color púrpura oscuro
        }

        // Botones
        btnConsultar = new Button("Consultar Productos");
        btnAdd = new Button("Añadir Producto");
        btnUpdate = new Button("Actualizar Producto");
        btnDelete = new Button("Eliminar Producto");
        btnBuscarHuevos = new Button("Buscar Huevos");
        btnPasillo1 = new Button("Pasillo 1");
        btnSalir = new Button("Salir");

        // Estilo de los botones
        String buttonStyle = "-fx-background-color: #4A148C; -fx-text-fill: white; -fx-font-size: 14px; -fx-font-weight: bold;";
        btnConsultar.setStyle(buttonStyle);
        btnAdd.setStyle(buttonStyle);
        btnUpdate.setStyle(buttonStyle);
        btnDelete.setStyle(buttonStyle);
        btnBuscarHuevos.setStyle(buttonStyle);
        btnPasillo1.setStyle(buttonStyle);
        btnSalir.setStyle(buttonStyle);

        HBox buttonBox1 = new HBox(10);
        buttonBox1.setAlignment(Pos.CENTER);
        buttonBox1.getChildren().addAll(btnConsultar, btnAdd, btnUpdate, btnDelete);

        HBox buttonBox2 = new HBox(10);
        buttonBox2.setAlignment(Pos.CENTER);
        buttonBox2.getChildren().addAll(btnBuscarHuevos, btnPasillo1, btnSalir);

        // Tabla de productos
        tablaProductos = new TableView<>();
        TableColumn<Producto, Number> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(cellData -> cellData.getValue().idProductoProperty());
        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        TableColumn<Producto, Number> colPrecio = new TableColumn<>("Precio");
        colPrecio.setCellValueFactory(cellData -> cellData.getValue().precioProperty());
        TableColumn<Producto, String> colTipo = new TableColumn<>("Tipo");
        colTipo.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());
        TableColumn<Producto, String> colUbicacion = new TableColumn<>("Ubicación");
        colUbicacion.setCellValueFactory(cellData -> cellData.getValue().ubicacionProperty());
        tablaProductos.getColumns().addAll(colId, colNombre, colPrecio, colTipo, colUbicacion);

        // Añadir estilos y componentes a la vista
        this.getChildren().addAll(searchBox, buttonBox1, buttonBox2, tablaProductos);
    }

    // Getters para los nuevos campos
    public TextField getTxtNombre() {
        return txtNombre;
    }

    public TextField getTxtPrecio() {
        return txtPrecio;
    }

    public TextField getTxtUbicacion() {
        return txtUbicacion;
    }

    // Getters existentes
    public TableView<Producto> getTablaProductos() {
        return tablaProductos;
    }

    public Button getBtnConsultar() {
        return btnConsultar;
    }

    public Button getBtnAdd() {
        return btnAdd;
    }

    public Button getBtnUpdate() {
        return btnUpdate;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public Button getBtnSalir() {
        return btnSalir;
    }

    public Button getBtnBuscarHuevos() {
        return btnBuscarHuevos;
    }

    public Button getBtnPasillo1() {
        return btnPasillo1;
    }
}

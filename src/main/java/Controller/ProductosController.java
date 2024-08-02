package Controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Producto;
import util.DatabaseConnection;
import view.ProductosView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductosController {
    private ProductosView productosView;
    private ObservableList<Producto> productos = FXCollections.observableArrayList();

    public ProductosController(ProductosView productosView) {
        this.productosView = productosView;
        initializeListeners();
    }

    private void initializeListeners() {
        productosView.getBtnConsultar().setOnAction(e -> consultarProductos());
        productosView.getBtnAdd().setOnAction(e -> addProducto());
        productosView.getBtnUpdate().setOnAction(e -> updateProducto());
        productosView.getBtnDelete().setOnAction(e -> deleteProducto());
        productosView.getBtnSalir().setOnAction(e -> Platform.exit());
        productosView.getBtnBuscarHuevos().setOnAction(e -> buscarHuevos());
        productosView.getBtnPasillo1().setOnAction(e -> buscarPasillo1());
    }

    private void consultarProductos() {
        productos.clear();
        String nombre = productosView.getTxtNombre().getText().trim();
        String precioStr = productosView.getTxtPrecio().getText().trim();
        String ubicacion = productosView.getTxtUbicacion().getText().trim();
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM productos WHERE 1=1");
        List<Object> parameters = new ArrayList<>();
        if (!nombre.isEmpty()) {
            queryBuilder.append(" AND nombre LIKE ?");
            parameters.add("%" + nombre + "%");
        }
        if (!precioStr.isEmpty()) {
            queryBuilder.append(" AND precio > ?");
            try {
                double precio = Double.parseDouble(precioStr);
                parameters.add(precio);
            } catch (NumberFormatException e) {
                // Controlar error de formato de número
                return;
            }
        }
        if (!ubicacion.isEmpty()) {
            queryBuilder.append(" AND ubicacion LIKE ?");
            parameters.add("%" + ubicacion + "%");
        }
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(queryBuilder.toString())) {

            for (int i = 0; i < parameters.size(); i++) {
                pstmt.setObject(i + 1, parameters.get(i));
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    productos.add(new Producto(
                            rs.getInt("id_producto"),
                            rs.getString("nombre"),
                            rs.getDouble("precio"),
                            rs.getString("tipo"),
                            rs.getString("ubicacion")
                    ));

                }
                Platform.runLater(() -> {
                    productosView.getTablaProductos().setItems(null);
                    productosView.getTablaProductos().setItems(productos);
                    System.out.println("Tabla actualizada con " + productos.size() + " productos");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }

    private void addProducto() {
        // Lógica para añadir un producto
        System.out.println("Añadir Producto");
    }

    private void updateProducto() {
        // Lógica para actualizar un producto
        System.out.println("Actualizar Producto");
    }

    private void deleteProducto() {
        // Lógica para eliminar un producto
        System.out.println("Eliminar Producto");
    }

    private void buscarHuevos() {
        productos.clear();
        String query = "SELECT * FROM productos WHERE tipo = 'Huevos'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                productos.add(new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getString("tipo"),
                        rs.getString("ubicacion")
                ));
            }
            Platform.runLater(() -> {
                productosView.getTablaProductos().setItems(null);
                productosView.getTablaProductos().setItems(productos);
                System.out.println("Tabla actualizada con productos del tipo 'Huevos'");
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar productos del tipo 'Huevos': " + e.getMessage());
        }
    }

    private void buscarPasillo1() {
        productos.clear();
        String query = "SELECT * FROM productos WHERE ubicacion = 'Pasillo 1'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                productos.add(new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getString("tipo"),
                        rs.getString("ubicacion")
                ));
            }
            Platform.runLater(() -> {
                productosView.getTablaProductos().setItems(null);
                productosView.getTablaProductos().setItems(productos);
                System.out.println("Tabla actualizada con productos del 'Pasillo 1'");
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar productos del 'Pasillo 1': " + e.getMessage());
        }
    }
}

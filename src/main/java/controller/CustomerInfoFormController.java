package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.CustomerInfoDTO;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CustomerInfoFormController implements Initializable {

    ObservableList<CustomerInfoDTO> customerInfoDTOS = FXCollections.observableArrayList();

    public ObservableList<CustomerInfoDTO> getAllCustomers() throws SQLException {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation_system","root","1234");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                customerInfoDTOS.add(new CustomerInfoDTO(
                        resultSet.getString("customerId"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getString("city"),
                        resultSet.getString("registeredDate"),
                        resultSet.getString("phone"),
                        resultSet.getString("addresss")
                ));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerInfoDTOS;

    }



    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colRegisteredDate;

    @FXML
    private TableView<CustomerInfoDTO> tblCustomerInfomation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colRegisteredDate.setCellValueFactory(new PropertyValueFactory<>("registeredDate"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("addresss"));

        tblCustomerInfomation.setItems(customerInfoDTOS);

        tblCustomerInfomation.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldValue, newValue) -> {);

            if(newValue != null) {
                // You can set text fields here if needed
            }

        }));

    }

    @FXML
    void btnAddOnAction(ActionEvent event) {



    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
